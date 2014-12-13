package com.example.mainprojecttheraptest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.media.ExifInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

public class UploadFromStroageClass extends Activity{
	AsyncTaskLoadFiles myAsyncTaskLoadFiles;
	double latt,lonn;
	String imgNameUrl;
	String imageName;

	public class AsyncTaskLoadFiles extends AsyncTask<Void, String, Void> {
		
		File targetDirector;
		ImageAdapter myTaskAdapter;

		public AsyncTaskLoadFiles(ImageAdapter adapter) {
			myTaskAdapter = adapter;
		}

		@Override
		protected void onPreExecute() {
			String ExternalStorageDirectoryPath = Environment
					.getExternalStorageDirectory().getAbsolutePath();

			String targetPath = ExternalStorageDirectoryPath + "/Pictures/Captured Image/";
			targetDirector = new File(targetPath);
			myTaskAdapter.clear();
			
			super.onPreExecute();
		}

		@Override
		protected Void doInBackground(Void... params) {
			
			File[] files = targetDirector.listFiles();
			for (File file : files) {
				publishProgress(file.getAbsolutePath());
				if (isCancelled()) break;
			}
			return null;
		}

		@Override
		protected void onProgressUpdate(String... values) {
			myTaskAdapter.add(values[0]);
			super.onProgressUpdate(values);
		}

		@Override
		protected void onPostExecute(Void result) {
			myTaskAdapter.notifyDataSetChanged();
			super.onPostExecute(result);
		}

	}

	public class ImageAdapter extends BaseAdapter {

		private Context mContext;
		ArrayList<String> itemList = new ArrayList<String>();

		public ImageAdapter(Context c) {
			mContext = c;
		}

		void add(String path) {
			itemList.add(path);
		}
		
		void clear() {
			itemList.clear();
		}
		
		void remove(int index){
			itemList.remove(index);
		}

		@Override
		public int getCount() {
			return itemList.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return itemList.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView imageView;
			if (convertView == null) { // if it's not recycled, initialize some
										// attributes
				imageView = new ImageView(mContext);
				imageView.setLayoutParams(new GridView.LayoutParams(220, 220));
				imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
				imageView.setPadding(8, 8, 8, 8);
			} else {
				imageView = (ImageView) convertView;
			}

			Bitmap bm = decodeSampledBitmapFromUri(itemList.get(position), 220,
					220);

			imageView.setImageBitmap(bm);
			return imageView;
		}

		public Bitmap decodeSampledBitmapFromUri(String path, int reqWidth,
				int reqHeight) {

			Bitmap bm = null;
			// First decode with inJustDecodeBounds=true to check dimensions
			final BitmapFactory.Options options = new BitmapFactory.Options();
			options.inJustDecodeBounds = true;
			BitmapFactory.decodeFile(path, options);

			// Calculate inSampleSize
			options.inSampleSize = calculateInSampleSize(options, reqWidth,
					reqHeight);

			// Decode bitmap with inSampleSize set
			options.inJustDecodeBounds = false;
			bm = BitmapFactory.decodeFile(path, options);

			return bm;
		}

		public int calculateInSampleSize(

		BitmapFactory.Options options, int reqWidth, int reqHeight) {
			// Raw height and width of image
			final int height = options.outHeight;
			final int width = options.outWidth;
			int inSampleSize = 1;

			if (height > reqHeight || width > reqWidth) {
				if (width > height) {
					inSampleSize = Math.round((float) height
							/ (float) reqHeight);
				} else {
					inSampleSize = Math.round((float) width / (float) reqWidth);
				}
			}

			return inSampleSize;
		}

	}

	ImageAdapter myImageAdapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.upload_photo_layout);

		final GridView gridview = (GridView) findViewById(R.id.gridview);
		myImageAdapter = new ImageAdapter(this);
		gridview.setAdapter(myImageAdapter);

		/*
		 * Move to asyncTaskLoadFiles String ExternalStorageDirectoryPath =
		 * Environment .getExternalStorageDirectory() .getAbsolutePath();
		 * 
		 * String targetPath = ExternalStorageDirectoryPath + "/test/";
		 * 
		 * Toast.makeText(getApplicationContext(), targetPath,
		 * Toast.LENGTH_LONG).show(); File targetDirector = new
		 * File(targetPath);
		 * 
		 * File[] files = targetDirector.listFiles(); for (File file : files){
		 * myImageAdapter.add(file.getAbsolutePath()); }
		 */
		myAsyncTaskLoadFiles = new AsyncTaskLoadFiles(myImageAdapter);
		myAsyncTaskLoadFiles.execute();

		gridview.setOnItemClickListener(myOnItemClickListener);
		
//		Button buttonReload = (Button)findViewById(R.id.reload);
//		buttonReload.setOnClickListener(new OnClickListener(){
//
//			@Override
//			public void onClick(View arg0) {
//				
//				//Cancel the previous running task, if exist.
//				myAsyncTaskLoadFiles.cancel(true);
//				
//				//new another ImageAdapter, to prevent the adapter have
//				//mixed files
//				myImageAdapter = new ImageAdapter(UploadFromStroageClass.this);
//				gridview.setAdapter(myImageAdapter);
//				myAsyncTaskLoadFiles = new AsyncTaskLoadFiles(myImageAdapter);
//				myAsyncTaskLoadFiles.execute();
//			}});

	}

	OnItemClickListener myOnItemClickListener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			//String prompt = "remove"+ (String) parent.getItemAtPosition(position);		
//			myImageAdapter.remove(position);
//			myImageAdapter.notifyDataSetChanged();
			
//			Intent intent=new Intent(MainActivity.this,test.class);
//			startActivity(intent);
			
			final String imgNameUrl=(String) parent.getItemAtPosition(position);
			String[] imageNameSplited= imgNameUrl.split("/");
			
			//Toast.makeText(getApplicationContext(), imageNameSplited[imageNameSplited.length-1], Toast.LENGTH_LONG).show();
			//Toast.makeText(getApplicationContext(), imgNameUrl,Toast.LENGTH_LONG).show();
			imageName=imageNameSplited[imageNameSplited.length-1];
			
			try {
				exif2Loc(imgNameUrl);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				Toast.makeText(getApplicationContext(), "kisu pay nai ", Toast.LENGTH_LONG).show();	
				}
			
			Toast.makeText(getApplicationContext(), ""+latt+""+lonn,Toast.LENGTH_LONG).show();
			AlertDialog.Builder alertDialogBuilder1 = new AlertDialog.Builder(UploadFromStroageClass.this);	 
				// set title
				alertDialogBuilder1.setTitle("Image Upload");
	 
				// set dialog message
				alertDialogBuilder1
					.setMessage("")
					.setCancelable(false).setPositiveButton("OK",new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,int id) {
							// if this button is clicked, close
							// current activity
							//MainActivity.this.finish();
						
							Intent intent=new Intent(UploadFromStroageClass.this,UploadPhotoClass.class);
							intent.putExtra("latitude", latt);
							intent.putExtra("longitude", lonn);
							intent.putExtra("imageName", imageName);
							intent.putExtra("fileUrl", imgNameUrl);
							startActivity(intent);							
						}
					  })
					.setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,int id) {
							// if this button is clicked, just close
							// the dialog box and do nothing
							//dialog.cancel();
						}
					}); 
					// create alert dialog
					AlertDialog alertDialog = alertDialogBuilder1.create();	 
					// show it
					alertDialog.show();
        	
			

		}
	};
	
	public void exif2Loc(String flNm) throws Exception {
		  String sLat = "", sLatR = "", sLon = "", sLonR = "";
		  try {
		    ExifInterface ef = new ExifInterface(flNm);
		    sLat  = ef.getAttribute(ExifInterface.TAG_GPS_LATITUDE);
		    sLon  = ef.getAttribute(ExifInterface.TAG_GPS_LONGITUDE);
		    sLatR = ef.getAttribute(ExifInterface.TAG_GPS_LATITUDE_REF);
		    sLonR = ef.getAttribute(ExifInterface.TAG_GPS_LONGITUDE_REF);
		  } catch (IOException e) {
			  Toast.makeText(getApplicationContext(), "kisu pay nai ", Toast.LENGTH_LONG).show();
		  }

		  double lat = dms2Dbl(sLat);
		   latt=lat;
		  if (lat > 180.0) ; 
		  double lon = dms2Dbl(sLon);
		   lonn=lon;
		  if (lon > 180.0); 
		  

		  lat = sLatR.contains("S") ? -lat : lat;
		  lon = sLonR.contains("W") ? -lon : lon;

		  Location loc = new Location("exif");
		  loc.setLatitude(lat);
		  loc.setLongitude(lon);
		  
		  
		  
		}
		//-------------------------------------------------------------------------
		double dms2Dbl(String sDMS){
		  double dRV = 999.0;
		  try {
		    String[] DMSs = sDMS.split(",", 3);
		    String s[] = DMSs[0].split("/", 2);
		    dRV = (new Double(s[0])/new Double(s[1]));
		    s = DMSs[1].split("/", 2);
		    dRV += ((new Double(s[0])/new Double(s[1]))/60);
		    s = DMSs[2].split("/", 2);
		    dRV += ((new Double(s[0])/new Double(s[1]))/3600);
		  } catch (Exception e) {}
		  return dRV;
		}


}

