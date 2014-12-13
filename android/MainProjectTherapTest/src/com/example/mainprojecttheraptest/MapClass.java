package com.example.mainprojecttheraptest;

import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.util.List;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

public class MapClass extends Activity implements OnMapClickListener,
OnMarkerClickListener{
	GoogleMap map;

	private TextView addressLabel;
	private WebView webView;
	boolean markerClicked;
	LatLng CurrntLatlng;
	String resultJson, resultShow, currentAddress = "surma";

	double latitude;
	double longitude;

	List<PlaceBean> listOfPlaceBean = null;
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map_layout);
		addressLabel = (TextView) findViewById(R.id.AddressId);
		addressLabel.setText("aosd");
		if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(this) != ConnectionResult.SUCCESS) {
			// Handle the case here

			Toast.makeText(getApplicationContext(), "not working",
					Toast.LENGTH_LONG).show();
		}

		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
				.getMap();
		map.setMapType(GoogleMap.MAP_TYPE_NORMAL);

		myLocation();

		
	}



	public void myLocation() {
		// TODO Auto-generated method stub

		LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
		Criteria criteria = new Criteria();

		String provider = locationManager.getBestProvider(criteria, true);
		Location myLocation = locationManager.getLastKnownLocation(provider);

		double latitude = myLocation.getLatitude();

		double longitude = myLocation.getLongitude();
		
		//ImageCaptureClass imageCaptureClass =new ImageCaptureClass(latitude,longitude);
		

		CurrntLatlng = new LatLng(latitude, longitude);

		String res = CurrntLatlng.toString();

		addressLabel.setText(res);
		// Toast.makeText(getApplicationContext(), res,5).show();
		MarkerOptions marker = new MarkerOptions().position(CurrntLatlng).title(
				"My Location!");

		//map.addMarker(marker);

		map.moveCamera(CameraUpdateFactory.newLatLngZoom(CurrntLatlng, 10.0f));
		
		//------------- conver the currentlocation to placebean obj------------- 
		resultJson = converToJson(currentAddress, latitude, longitude);
		//-------------call mapshow servlet for showing marker---------
		
		new HttpAsyncTask().execute(Config.SERVER_URL + "MapShow");
		

	}

	private String converToJson(String address, Double latit, Double longit) {
		// TODO Auto-generated method stub

		PlaceBean placeBean = new PlaceBean(address, latit, longit);

		Gson gson = new Gson();

		String resultJson = gson.toJson(placeBean);

		return resultJson;
	}
	

	private class HttpAsyncTask extends AsyncTask<String, Void, String> {
		@Override
		protected String doInBackground(String... urls) {
			String result = "dhuke nai";

			result = HttpReqResp.POST(urls[0], resultJson);
			resultShow = result;
			return result;
		}

		// onPostExecute displays the results of the AsyncTask.
		@Override
		protected void onPostExecute(String result) {

			// loading_ProgressBar.setVisibility(View.GONE);
			resultShow = result;
			Log.d("Result", result);
			Log.v("Result", result);
			Log.e("Result", result);
			System.out.println(result);
			// Toast.makeText(getApplicationContext(), result,
			// Toast.LENGTH_LONG).show();
			try {
				fromJsonToObj(PlaceBean.class.getName());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			map.setOnMarkerClickListener(MapClass.this);
			markerClicked = false;
		}
	}
	

	private void fromJsonToObj(String className) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException {

		Class classTemp = Class.forName(className);

		Object obj = classTemp.newInstance();
		Gson gson = new Gson();

		if (obj instanceof PlaceBean) {
			PlaceBean placeBean = new PlaceBean();

			Type type = new TypeToken<List<PlaceBean>>() {
			}.getType();

			 listOfPlaceBean = gson.fromJson(resultShow, type);
			Toast.makeText(getApplicationContext(),
					listOfPlaceBean.get(0).getName(), Toast.LENGTH_LONG).show();
			addMarker(listOfPlaceBean);
		} else if (obj instanceof PhotosBean) {
			PhotosBean photosBean = new PhotosBean();
			
			Type type = new TypeToken<List<PhotosBean>>() {
			}.getType();

			List<PlaceBean> listOfPlaceBean = gson.fromJson(resultShow, type);
			Toast.makeText(getApplicationContext(),
					listOfPlaceBean.get(0).getName(), Toast.LENGTH_LONG).show();
		}

	}
	private void addMarker(List<PlaceBean> listOfPlaceBean) {
		// TODO Auto-generated method stub

		for (int i = 0; i < listOfPlaceBean.size(); i++) {
			LatLng latLng = new LatLng(listOfPlaceBean.get(i).getLatitude(),
					listOfPlaceBean.get(i).getLongitude());
			map.addMarker(new MarkerOptions().position(latLng)
					.title(listOfPlaceBean.get(i).getName()).snippet("" + i));
		}

	}

	@Override
	public boolean onMarkerClick(Marker marker) {
		// TODO Auto-generated method stub
		
		final int markerNumb = Integer.parseInt(marker.getSnippet());
		

		LatLng EndP = new LatLng(listOfPlaceBean.get(markerNumb).getLatitude(), listOfPlaceBean.get(markerNumb).getLongitude());

		Double distance = CalculationByDistance(CurrntLatlng, EndP);

		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
		// set title
		alertDialogBuilder.setTitle("Place Name:" + listOfPlaceBean.get(markerNumb).getName());
		Toast.makeText(getApplicationContext(), listOfPlaceBean.get(markerNumb).getName(), Toast.LENGTH_LONG).show();
		// set dialog message
		alertDialogBuilder
				.setMessage(
						"Distance::" + distance )
				.setCancelable(false)
				.setPositiveButton("Show Images",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								// if this button is clicked, close
								// current activity
								// MainActivity.this.finish();

								// Intent intent=new
								// Intent(MapActivity.this,ShowImage.class);
								// intent.putExtra("pathName", path);
								// startActivity(intent);
								
								if(listOfPlaceBean.get(markerNumb).getPhotosList().size()>0){
									setContentView(R.layout.webview);

									webView = (WebView) findViewById(R.id.webView1);
									webView.getSettings().setJavaScriptEnabled(true);

									Gson gson = new Gson();
//									String listOfImagesString = gson.toJson(listOfPlaceBean.get(markerNumb).getPhotosList());
//									webView.loadUrl(Config.SERVER_URL+"ImgShowServlet"+"?address=" +listOfImagesString);
									
									PlaceBean clickedPlace = listOfPlaceBean.get(markerNumb);
									webView.loadUrl(Config.SERVER_URL+"WebViewOfImages"+"?idPlace=" +clickedPlace.getIdPlace());
								}
								
							 
								
								
								//new HttpAsyncTask().execute(Config.SERVER_URL + "PhotosGet");
							}
						})
				.setNegativeButton("Not now",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								// if this button is clicked, just close
								// the dialog box and do nothing
								dialog.cancel();
							}
						});
		// create alert dialog
		AlertDialog alertDialog = alertDialogBuilder.create();
		// show it
		alertDialog.show();

		return false;
	}

	@Override
	public void onMapClick(LatLng arg0) {
		// // TODO Auto-generated method stub

	}

	public double CalculationByDistance(LatLng StartP, LatLng EndP) {
		int Radius = 6371;// radius of earth in Km
		double lat1 = StartP.latitude;
		double lat2 = EndP.latitude;
		double lon1 = StartP.longitude;
		double lon2 = EndP.longitude;
		double dLat = Math.toRadians(lat2 - lat1);
		double dLon = Math.toRadians(lon2 - lon1);
		double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
				+ Math.cos(Math.toRadians(lat1))
				* Math.cos(Math.toRadians(lat2)) * Math.sin(dLon / 2)
				* Math.sin(dLon / 2);
		double c = 2 * Math.asin(Math.sqrt(a));
		double valueResult = Radius * c;
		double km = valueResult / 1;
		DecimalFormat newFormat = new DecimalFormat("####");
		int kmInDec = Integer.valueOf(newFormat.format(km));
		double meter = valueResult % 1000;
		int meterInDec = Integer.valueOf(newFormat.format(meter));
		Log.i("Radius Value", "" + valueResult + "   KM  " + kmInDec
				+ " Meter   " + meterInDec);

		return Radius * c;
	}

}
