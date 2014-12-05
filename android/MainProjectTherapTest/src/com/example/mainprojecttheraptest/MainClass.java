package com.example.mainprojecttheraptest;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainClass extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.front_page_layout);
        
        Button signInbutton =(Button)findViewById(R.id.signInButtonFront);
        signInbutton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent intent=new Intent(MainClass.this,SignInClass.class);
				startActivity(intent);
				
			}
		});
        
        
        Button signUpbutton =(Button)findViewById(R.id.signUpButtonFront);
        signUpbutton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent intent=new Intent(MainClass.this,SignUpClass.class);
				startActivity(intent);
				
			}
		});
        
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_class, menu);
        return true;
    }
    
}
