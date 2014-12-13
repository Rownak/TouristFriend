package com.example.mainprojecttheraptest;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.NameValuePair;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class RatingClass extends Activity {

	double latitude;
	double longitude;
	double rate;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rating_layout);
		myLocation();
		final RatingBar ratingBar_default = (RatingBar) findViewById(R.id.ratingbar_default);

		ratingBar_default.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {

					@Override
					public void onRatingChanged(RatingBar ratingBar,
							float rating, boolean fromUser) {

						rate = rating;
						Toast.makeText(RatingClass.this,
								"rating:" + String.valueOf(rating),
								Toast.LENGTH_LONG).show();
					}
				});

		Button okButton = (Button) findViewById(R.id.okbutton);
		okButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new HttpAsyncTask()
						.execute(Config.SERVER_URL + "RateThisPlace");
				Intent intent=new Intent(RatingClass.this,MainMenuClass.class);
				startActivity(intent);
			}
		});

	}

	private class HttpAsyncTask extends AsyncTask<String, Void, String> {
		@Override
		protected String doInBackground(String... urls) {

			sendPostRequest(urls[0]);
			return "finish";
		}

		// onPostExecute displays the results of the AsyncTask.
		@Override
		protected void onPostExecute(String result) {

		}
	}

	private void sendPostRequest(String url) {
		HttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

		nameValuePairs.add(new BasicNameValuePair("latitude", "" + latitude));
		nameValuePairs.add(new BasicNameValuePair("longitude", "" + longitude));
		nameValuePairs.add(new BasicNameValuePair("rate", "" + rate));

		try {

			httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			httpClient.execute(httpPost);

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void myLocation() {
		LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		Criteria criteria = new Criteria();

		String provider = locationManager.getBestProvider(criteria, true);
		Location myLocation = locationManager.getLastKnownLocation(provider);

		latitude = myLocation.getLatitude();
		longitude = myLocation.getLongitude();

		// Toast.makeText(getApplicationContext(), ""+latitude,
		// Toast.LENGTH_LONG).show();

	}
}
