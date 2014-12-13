package com.example.mainprojecttheraptest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainMenuClass extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_menu_layout);
		
		ImageButton searchPlaceButton =(ImageButton)findViewById(R.id.SearchPlaceButton);
		searchPlaceButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent intent=new Intent(MainMenuClass.this,MapClass.class);
				startActivity(intent);
				
			}
		});
        
        
        ImageButton takePhotoButton =(ImageButton)findViewById(R.id.TakePhotoButton);
        takePhotoButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent intent=new Intent(MainMenuClass.this,ImageCaptureClass.class);
				startActivity(intent);
				
			}
		});
        
        
        ImageButton uploadPhotoButton =(ImageButton)findViewById(R.id.UploadPhotoButton);
        uploadPhotoButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent intent=new Intent(MainMenuClass.this,UploadFromStroageClass.class);
				startActivity(intent);
				
			}
		});
        
        
        ImageButton ratePlaceButton =(ImageButton)findViewById(R.id.RatePlaceButton);
        ratePlaceButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent intent=new Intent(MainMenuClass.this,RatingClass.class);
				startActivity(intent);
				
			}
		});
        
	}
	

}
