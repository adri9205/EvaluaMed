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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ComentariosActivity extends Activity {
	EditText comments;
	TextView calif;
    String comentarios;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.comentarios);
		Button guardar=(Button) findViewById(R.id.button2);
		comments = (EditText) findViewById(R.id.editText1);
		calif = (TextView) findViewById(R.id.textView1);
		
		
		final String user;
		final String ID;
		final Double promedio;
		final Double juicio, conocimiento, interrogatorio, fisica, clinico, quirurgico,comunicacion, desempeno, desarrollo;

		
		Calendar c = Calendar.getInstance();
		//System.out.println("Current time => " + c.getTime());

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		final String formattedDate = df.format(c.getTime());
		Bundle extras = getIntent().getExtras();
        //Obtenemos datos enviados en el intent.
    
     	   user  = extras.getString("user");//usuario
     	   ID = extras.getString("ID");
     	   promedio = extras.getDouble("promedio");
     	   juicio = extras.getDouble("juicio");
     	   conocimiento = extras.getDouble("conocimiento");
     	   interrogatorio = extras.getDouble("interrogatorio");
     	   fisica = extras.getDouble("fisica");
     	   clinico = extras.getDouble("clinico");
     	   quirurgico = extras.getDouble("quirurgico");
     	   comunicacion = extras.getDouble("comunicacion");
     	   desempeno = extras.getDouble("desempeno");
     	   desarrollo = extras.getDouble("desarrollo");
     	 final String prom=Double.toString(promedio);
        final String juicio1=Double.toString(juicio), conocimiento1=Double.toString(conocimiento), interrogatorio1=Double.toString(interrogatorio), fisica1=Double.toString(fisica), clinico1=Double.toString(clinico), quirurgico1=Double.toString(quirurgico),comunicacion1=Double.toString(comunicacion), desempeno1=Double.toString(desempeno), desarrollo1=Double.toString(desarrollo);
        if (promedio!=0.0){
        calif.setText("La impresión general del alumno para este evento fue: \n"+String.format( "%.1f", promedio ));
        }
        else{
        	calif.setText("No se evaluó este evento");
        }
        View.OnClickListener registroListener1 = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
            	comentarios=comments.getText().toString();
            	if (promedio!=0){
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
                    //juicio, comunicacion, desempeno, desarrollo;
                    
                    nameValuePairs.add(new BasicNameValuePair("juicio", juicio1));
                    nameValuePairs.add(new BasicNameValuePair("conocimiento", conocimiento1));
                    nameValuePairs.add(new BasicNameValuePair("interrogatorio", interrogatorio1));
                    nameValuePairs.add(new BasicNameValuePair("fisica", fisica1));
                    nameValuePairs.add(new BasicNameValuePair("clinico",clinico1));
                    

                    nameValuePairs.add(new BasicNameValuePair("quirurgico", quirurgico1));
                    nameValuePairs.add(new BasicNameValuePair("comunicacion", comunicacion1));
                    nameValuePairs.add(new BasicNameValuePair("desempeno", desempeno1));
                    nameValuePairs.add(new BasicNameValuePair("desarrollo", desarrollo1));
                    //nameValuePairs.add(new BasicNameValuePair("clinico",clinico1));
                     
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
                }}
            	else {
            		Toast.makeText(ComentariosActivity.this, "No se guardo la evaluacion", Toast.LENGTH_LONG);
            	}
                    Intent intent =new Intent (ComentariosActivity.this, Evaluacion.class);
                    intent.putExtra("user", user);
                   // intent.putExtra("promedio", prom);
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
