package com.example.mainprojecttheraptest;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import useful.RandomId;


import com.google.gson.Gson;



import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SignUpClass extends Activity{
	
	EditText userName,Email,password,confirmPass;
	RadioGroup roleType;
	Button signUp;
	//ConnectionDetector cd;
	
	String userNameS,emailS,passS,confirmPassS,roleTypeS, jsonToPass, resultShow;
	UserBean userBean;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_layout);
        
        userName = (EditText) findViewById(R.id.userNameSE);
		Email  = (EditText) findViewById(R.id.emailSE);
		password  = (EditText) findViewById(R.id.passwordSE);
		confirmPass  = (EditText) findViewById(R.id.conPassSE);
		
		roleType = (RadioGroup) findViewById(R.id.radioGroup1);
		
		signUp = (Button) findViewById(R.id.signUpB);
		
		signUp.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				userNameS = userName.getText().toString();
				emailS = Email.getText().toString();
				passS = password.getText().toString();
				confirmPassS = confirmPass.getText().toString();
				
				int selectedId = roleType.getCheckedRadioButtonId();
				 
				// find the radiobutton by returned id
			    RadioButton role_id = (RadioButton) findViewById(selectedId);
			    
			    //Toast.makeText(signUpActivity.this, String.valueOf(selectedId), Toast.LENGTH_LONG).show();
				
				if( userNameS.length()<3 || emailS.length()<3 || passS.length()<3 || confirmPassS.length()<3 ){
					Toast.makeText(SignUpClass.this, "Username, password can't be less than 3 letter",Toast.LENGTH_LONG).show();
				}else{
					if(confirmPassS.equals(passS)){
					
						if(role_id.getText().toString().equals("Male")){
							roleTypeS="2";
						}else if(role_id.getText().toString().equals("Female")){
							roleTypeS="3";
						}
						//checkedEmail(emailS);
					}else{
						Toast.makeText(SignUpClass.this, "Password doesn't match.",Toast.LENGTH_LONG).show();
					}
					getAllFieldValues();
					roleTypeS = role_id.getText().toString();
					jsonToPass = converToJson();
					//Toast.makeText(Registration_class.this, jsonToPass,Toast.LENGTH_LONG).show();
					if(userBean.validate()){
						Toast.makeText(getApplicationContext(), userBean.getMessage(), Toast.LENGTH_LONG).show();
						new HttpAsyncTask().execute(Config.SERVER_URL+ "Registration");
					}
					else{
						Toast.makeText(getApplicationContext(), userBean.getMessage(), Toast.LENGTH_LONG).show();
						password.setText("");
						confirmPass.setText("");
						Email.setText("");
					}
					
				}
			}
		});
		
	}
	
	 private String converToJson() {
			// TODO Auto-generated method stub
		 BigInteger rand= RandomId.RandomIdGenerator.nextSessionId();
		 userBean = new UserBean(rand.intValue(),userNameS,emailS,passS,roleTypeS);
		 TypeBean typeBean = new TypeBean();
		 typeBean.setName("User");
		 typeBean.setIdType(1);
		 
		 userBean.setTypeBean(typeBean);
		 
		 Gson gson = new Gson();

		 String resultJson = gson.toJson(userBean); 
		 
			return resultJson;
		}
	 private void getAllFieldValues() {
			// TODO Auto-generated method stub
			
			userNameS = userName.getText().toString();
			emailS = Email.getText().toString();
			passS = password.getText().toString();
			confirmPassS = confirmPass.getText().toString();
			
		}
		public String POST(String url) {
			InputStream inputStream = null;
			String result = "dhukse" + url;
			try {

				// 1. create HttpClient
				HttpClient httpclient = new DefaultHttpClient();

				// 2. make POST request to the given URL
				HttpPost httpPost = new HttpPost(url);

				// 5. set json to StringEntity
				StringEntity se = new StringEntity(jsonToPass);

				// 6. set httpPost Entity
				httpPost.setEntity(se);

				// 7. Set some headers to inform server about the type of the
				// content
				httpPost.setHeader("Accept", "application/json");
				httpPost.setHeader("Content-type", "application/json");

				// 8. Execute POST request to the given URL
				HttpResponse httpResponse = httpclient.execute(httpPost);

				// 9. receive response as inputStream
				inputStream = httpResponse.getEntity().getContent();

				// 10. convert inputstream to string
				if (inputStream != null)
					result = convertInputStreamToString(inputStream);
				else
					result = "Did not work!";

			} catch (Exception e) {
				Log.d("InputStream", e.getLocalizedMessage());
				
			}

			// 11. return result
			return result;
		}
		
		private class HttpAsyncTask extends AsyncTask<String, Void, String> {
			@Override
			protected String doInBackground(String... urls) {
				String result= "dhuke nai";

				 result = POST(urls[0]);
				resultShow = result;
				return result;
			}

			// onPostExecute displays the results of the AsyncTask.
			@Override
			protected void onPostExecute(String result) {

				
				Toast.makeText(getBaseContext(), resultShow, Toast.LENGTH_LONG)
						.show();
			}
		}

		private static String convertInputStreamToString(InputStream inputStream)
				throws IOException {
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(inputStream));
			String line = "";
			String result = "";
			while ((line = bufferedReader.readLine()) != null)
				result += line;

			inputStream.close();
			return result;

		}

}
