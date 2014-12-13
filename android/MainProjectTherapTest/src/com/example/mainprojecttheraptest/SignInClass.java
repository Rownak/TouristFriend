package com.example.mainprojecttheraptest;

import com.google.gson.Gson;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignInClass extends Activity{

	Button loginB;
	EditText userEmail,pass;
	String userS = "-1",passS = "-1";
	static String staticLoginEmailS=null,staticPass=null;
	
	Boolean isInternetPresent = false;
	String resultShow;
	String resultJson="";
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in_layout);
        
        userEmail = (EditText)findViewById(R.id.userEmail);
		pass = (EditText)findViewById(R.id.password);
		loginB = (Button)findViewById(R.id.signInButton);
		
		loginB.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				userS = userEmail.getText().toString();
				passS = pass.getText().toString();
				
				Toast.makeText(getApplicationContext(), userS, Toast.LENGTH_LONG).show();
				
				resultJson=converToJson();
				String URL = Config.SERVER_URL + "Login";
				Toast.makeText(getBaseContext(), URL, Toast.LENGTH_LONG)
				.show();
				new HttpAsyncTask().execute(URL);
				
			}
		});
        
	}
	private String converToJson() {
		// TODO Auto-generated method stub
	 
	 UserBean userBean = new UserBean(userS,passS);
	 TypeBean typeBean = new TypeBean();
	 typeBean.setName("User");
	 typeBean.setIdType(1);
	 
	 userBean.setTypeBean(typeBean);
	 
	 Gson gson = new Gson();

	 String resultJson = gson.toJson(userBean); 
	 
		return resultJson;
	}
	
	private class HttpAsyncTask extends AsyncTask<String, Void, String> {
		@Override
		protected String doInBackground(String... urls) {
			String result= "dhuke nai";
			
			
			 result =HttpReqResp.POST(urls[0],resultJson);
			resultShow = result;
			return result;
		}

		// onPostExecute displays the results of the AsyncTask.
		@Override
		protected void onPostExecute(String result) {

			//loading_ProgressBar.setVisibility(View.GONE);
			
			if(resultShow.equalsIgnoreCase("valid")){
				Intent intent=new Intent(SignInClass.this,MainMenuClass.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(intent);
			}
			else{
				Intent intent=new Intent(SignInClass.this,MainClass.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(intent);
			}
		}
 }
	
}
