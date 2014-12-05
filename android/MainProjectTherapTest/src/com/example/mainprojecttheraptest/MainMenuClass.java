package com.example.mainprojecttheraptest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenuClass extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_menu_layout);
		
		Button searchPlaceButton =(Button)findViewById(R.id.SearchPlaceButton);
		searchPlaceButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent intent=new Intent(MainMenuClass.this,MapClass.class);
				startActivity(intent);
				
			}
		});
        
        
        Button takePhotoButton =(Button)findViewById(R.id.TakePhotoButton);
        takePhotoButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent intent=new Intent(MainMenuClass.this,ImageCaptureClass.class);
				startActivity(intent);
				
			}
		});
        
        
        Button uploadPhotoButton =(Button)findViewById(R.id.UploadPhotoButton);
        uploadPhotoButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent intent=new Intent(MainMenuClass.this,UploadPhotoClass.class);
				startActivity(intent);
				
			}
		});
        
        
        Button ratePlaceButton =(Button)findViewById(R.id.RatePlaceButton);
        ratePlaceButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent intent=new Intent(MainMenuClass.this,SignInClass.class);
				startActivity(intent);
				
			}
		});
        
	}
	

}
