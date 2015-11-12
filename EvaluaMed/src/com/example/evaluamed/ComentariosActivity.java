package com.example.evaluamed;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ComentariosActivity extends Activity {
	EditText comments;
    String comentarios;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.comentarios);
		Button guardar=(Button) findViewById(R.id.button2);
		comments = (EditText) findViewById(R.id.editText1);
		final String user;
		final String ID;
		final Double promedio;
		
		Calendar c = Calendar.getInstance();
		//System.out.println("Current time => " + c.getTime());

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		final String formattedDate = df.format(c.getTime());
		Bundle extras = getIntent().getExtras();
        //Obtenemos datos enviados en el intent.
    
     	   user  = extras.getString("user");//usuario
     	   ID = extras.getString("ID");
     	   promedio = extras.getDouble("promedio");
       
        final String prom=Double.toString(promedio);
        
        
        View.OnClickListener registroListener1 = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
            	comentarios=comments.getText().toString();
            	try{
            		
                    // url where the data will be posted
                    String postReceiverUrl = "http://evaluacionqx.com/android/inserta.php";
                    
                     
                    // HttpClient
                    HttpClient httpClient = new DefaultHttpClient();
                     
                    // post header
                    HttpPost httpPost = new HttpPost(postReceiverUrl);
             
                    // add your data
                    List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
                    nameValuePairs.add(new BasicNameValuePair("usuario", user));
                    nameValuePairs.add(new BasicNameValuePair("ID", ID));
                    nameValuePairs.add(new BasicNameValuePair("promedio", prom));
                    nameValuePairs.add(new BasicNameValuePair("fecha", formattedDate));
                    nameValuePairs.add(new BasicNameValuePair("comentarios",comentarios));
                     
                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
             
                    // execute HTTP post request
                    HttpResponse response = httpClient.execute(httpPost);
                    HttpEntity resEntity = response.getEntity();
                     
                    if (resEntity != null) {
                         
                        String responseStr = EntityUtils.toString(resEntity).trim();
              //          Log.v(TAG, "Response: " +  responseStr);
                         
                        // you can add an if statement here and do other actions based on the response
                    }
                     
                } catch (ClientProtocolException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                    Intent intent =new Intent (ComentariosActivity.this, Fin.class);
                    /*intent.putExtra("user", user);*/
                    startActivity(intent);
            }

        };
        guardar.setOnClickListener(registroListener1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.comentarios, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
