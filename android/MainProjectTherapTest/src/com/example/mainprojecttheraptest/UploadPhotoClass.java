package com.example.mainprojecttheraptest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.codec.binary.Base64;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.widget.Toast;
import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


public class UploadPhotoClass extends FragmentActivity {
	ViewPager viewPager;
	String fileUrl,imageName;
	double latitude,longitude;
	public static FragmentManager fragmentManager = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent intent = getIntent();
		fileUrl = intent.getExtras().getString("fileUrl");
		imageName = intent.getExtras().getString("imageName");
		latitude = intent.getExtras().getDouble("latitude");
		longitude = intent.getExtras().getDouble("longitude");
		Toast.makeText(getApplicationContext(), latitude+ " fileUrl: "+ fileUrl , Toast.LENGTH_LONG).show();
		
		uploadImage();
		
		
		Intent intent1=new Intent(UploadPhotoClass.this,MainMenuClass.class);
		startActivity(intent1);
		
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	void uploadImage() {
		File mainFolderpath = new File(Environment.getExternalStorageDirectory(),
				"Image keeper");
		//File file = new File(mainFolderpath,"img1.jpg");
			File file = new File(fileUrl);
		try {
			// Reading a Image file from file system
			FileInputStream imageInFile = new FileInputStream(file);
			byte imageData[] = new byte[(int) file.length()];
			imageInFile.read(imageData);

			// Converting Image byte array into Base64 String
			String imageDataString = encodeImage(imageData);

			makeVolleyRequest(imageDataString);
			imageInFile.close();

		} catch (FileNotFoundException e) {
			Toast.makeText(UploadPhotoClass.this, e.toString(), Toast.LENGTH_LONG)
					.show();
		} catch (IOException ioe) {
			Toast.makeText(UploadPhotoClass.this, ioe.toString(), Toast.LENGTH_LONG)
					.show();
		}
	}

	public String encodeImage(byte[] imageByteArray) {

		return new String(Base64.encodeBase64(imageByteArray));
	}

	private void makeVolleyRequest(final String imageString) {
		if (imageString == null) {
			Toast.makeText(UploadPhotoClass.this, "string null", Toast.LENGTH_LONG)
					.show();
		}
		StringRequest strReq = new StringRequest(Method.POST,
				Config.SERVER_URL + "UploadImage",
				new Response.Listener<String>() {

					@Override
					public void onResponse(String response) {
						Toast.makeText(UploadPhotoClass.this, response.toString(),
								Toast.LENGTH_LONG).show();
					}
				}, new Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {
						Toast.makeText(UploadPhotoClass.this, "fahad: "+error.toString(),
								Toast.LENGTH_LONG).show();
					}
				}) {

			@Override
			protected Map<String, String> getParams() {
				Map<String, String> params = new HashMap<String, String>();
				params.put("image", imageString);
				params.put("image_name", imageName);
				params.put("latitude",""+latitude);
				params.put("longitude", ""+longitude);
				return params;
			}

		};

		Volley.newRequestQueue(UploadPhotoClass.this).add(strReq);
	}
}
