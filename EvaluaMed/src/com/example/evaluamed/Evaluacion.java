package com.example.evaluamed;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Evaluacion extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_evaluacion);
		SearchView busca=(SearchView) findViewById(R.id.searchView1);
		ListView alumnos=(ListView) findViewById(R.id.list1);
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

 
	final ListViewAdapter miAdaptador= new ListViewAdapter(getApplicationContext(), R.layout.row1,getDataForListView());
	
	alumnos.setAdapter(miAdaptador);
	
	
	OnItemClickListener registro = new OnItemClickListener(){

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1,
				int arg2, long arg3) {
			Libro perfil=(Libro)miAdaptador.getItem(arg2);
			
			Toast.makeText(Evaluacion.this,perfil.id, Toast.LENGTH_LONG).show();
			 Intent intent =new Intent (Evaluacion.this, Evaluacion_Alumno.class);
			 intent.putExtra("ID", perfil.id);
             startActivity(intent);
			// TODO Auto-generated method stub
			
		}
		
	};
	alumnos.setOnItemClickListener(registro);

	}
	
	public List<Libro> getDataForListView(){
		
		Libro libro;
		List<Libro> listLibros= new ArrayList<Libro>();/*
		libro= new Libro("ios programming cookbook", "9780470918029","23/01/2010");
		listLibros.add(libro);
		libro= new Libro("Beginning ios 4 Application Development", "9781479211418","10/08/2011");
		listLibros.add(libro);
		libro= new Libro("ios 7 Application Development in 24 Hours", "9781449372422","25/03/2014");
		listLibros.add(libro);*/
	
		      String data;
		      List<String> r = new ArrayList<String>();
		      ArrayAdapter<String>adapter=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,r);
		     
		        try {
		            DefaultHttpClient client = new DefaultHttpClient();
		            HttpGet request = new HttpGet("http://evaluacionqx.com/android/get-data.php");
		            HttpResponse response = client.execute(request);
		            HttpEntity entity=response.getEntity();
		            data=EntityUtils.toString(entity);
		            Log.e("STRING", data);
		            try {
		             
		       JSONArray json=new JSONArray(data);
		       for(int i=0;i<json.length(); i++)
		       {
		        JSONObject obj=json.getJSONObject(i);
		        String id=obj.getString("id_alumno");
		        String name=obj.getString("nombre");
		        String year=obj.getString("apellido_p");
		        String age=obj.getString("apellido_m");
		        String y=obj.getString("nivel");
		        String esp=obj.getString("especialidad");
		        Log.e("STRING", year);
		        libro= new Libro(id,name,year,age,esp,y);
				listLibros.add(libro);
		        
		       }
		       
		      } catch (JSONException e) {
		       // TODO Auto-generated catch block
		       e.printStackTrace();
		      }
		          
		        } catch (ClientProtocolException e) {
		            Log.d("HTTPCLIENT", e.getLocalizedMessage());
		        } catch (IOException e) {
		            Log.d("HTTPCLIENT", e.getLocalizedMessage());
		        }
		      
		      
		    
		return listLibros;
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.evaluacion, menu);
		
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
