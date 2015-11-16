package com.example.evaluamed;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class Evaluacion extends Activity {
	List<String> array;
	ListViewAdapter miAdaptador;
	Libro libro;
	ListView alumnos;
	List<Libro> listLibros= new ArrayList<Libro>();
	String user;
	Button salir;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_evaluacion);
		//SearchView busca=(SearchView) findViewById(R.id.searchView1);
		EditText ed=(EditText)findViewById(R.id.searchView1);
		salir = (Button)findViewById(R.id.button1);
		alumnos=(ListView) findViewById(R.id.list1);
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Bundle extras = getIntent().getExtras();
        //Obtenemos datos enviados en el intent.
        if (extras != null) {
     	   user  = extras.getString("user");//usuario
        }else{
     	   user="error";
     	   }
        System.out.println("usuario: "+user);
        miAdaptador= new ListViewAdapter(getApplicationContext(), R.layout.row1,getDataForListView());
	
	alumnos.setAdapter(miAdaptador);
    View.OnClickListener registroListener1 = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
                Intent intent =new Intent (Evaluacion.this, MainActivity.class);
                //intent.putExtra("user", user);
               // intent.putExtra("promedio", prom);
                startActivity(intent);
        }

    };
    salir.setOnClickListener(registroListener1);
	  ed.addTextChangedListener(new TextWatcher() {
		   
		   @Override
		   public void onTextChanged(CharSequence s, int start, int before, int count) {
			   int textlength = s.length();
				List<Libro> listtemp= new ArrayList<Libro>();
				for(Libro c: listLibros){
					 if ((textlength <= c.getTitulo().length())||(textlength <= c.getIsbn().length())
							 ||(textlength <= c.getFecha_publicacion().length())
							 ||(textlength <= c.getYear().length())
							 ||(textlength <= c.getEsp().length())
							 ) {
		                 if ((c.getTitulo().toLowerCase().contains(s.toString().toLowerCase())
		                		 )||(c.getIsbn().toLowerCase().contains(s.toString().toLowerCase()))
		                				 ||(c.getFecha_publicacion().toLowerCase().contains(s.toString().toLowerCase())
		                						 )||(c.getEsp().toLowerCase().contains(s.toString().toLowerCase()))
		                						 ||(c.getYear().toLowerCase().contains(s.toString().toLowerCase()))
		                		 ) {
		                    listtemp.add(c);
		                 }
				}
					 }
		    	miAdaptador= new ListViewAdapter(getApplicationContext(),R.layout.row1,listtemp);
		    	
		    	alumnos.setAdapter(miAdaptador);
		    
		    
		   }
		   
		   @Override
		   public void beforeTextChanged(CharSequence s, int start, int count,
		     int after) {
		    // TODO Auto-generated method stub
		    
		   }
		   
		   @Override
		   public void afterTextChanged(Editable s) {
		    // TODO Auto-generated method stub
		    
		   }
		  });
	OnItemClickListener registro = new OnItemClickListener(){

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1,
				int arg2, long arg3) {
			Libro perfil=(Libro)miAdaptador.getItem(arg2);
			
			Toast.makeText(Evaluacion.this,perfil.id, Toast.LENGTH_LONG).show();
			 Intent intent =new Intent (Evaluacion.this, Evaluacion_Alumno.class);
			 intent.putExtra("ID", perfil.id);
			 intent.putExtra("user", user);
             startActivity(intent);
			// TODO Auto-generated method stub
			
		}
		
	};
	alumnos.setOnItemClickListener(registro);

	}
	
	public List<Libro> getDataForListView(){
		
		
	
	
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
