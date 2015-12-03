package com.example.evaluamed;


import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.evaluamed.library.Httppostaux;

public class Olvido extends Activity {
	Httppostaux post;
	String usuario;
	   // String URL_connect="http://www.scandroidtest.site90.com/acces.php";
		String URL_connect="http://evaluacionqx.com/android/olvido.php";
	    //String IP_Server="192.168.3.20";//IP DE NUESTRO PC
	   // String URL_connect="http://"+IP_Server+"/droidlogin/acces.php";//ruta en donde estan nuestros archivos
	  
	    boolean result_back;
	    private ProgressDialog pDialog;
	    EditText email;
	    String pass="al";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_olvido);
		email=(EditText) findViewById(R.id.editText1);
		Button enviar=(Button) findViewById(R.id.BtnRecuperar);
		enviar.setBackgroundColor(Color.BLUE);
		enviar.setTextColor(Color.WHITE);
		post=new Httppostaux();
		enviar.setOnClickListener(new View.OnClickListener(){
		       
        	public void onClick(View view){
        		//Extreamos datos de los EditText
        		usuario=email.getText().toString();
        		if (usuario.equals("")){
        			 Toast toast1 = Toast.makeText(getApplicationContext(),"Ingresa tu usuario", Toast.LENGTH_SHORT);
              	    toast1.show();
        
        		}
        		else{
        		new asynclogin().execute(usuario);


        		}
        	}});

	}

	 //vibra y muestra un Toast
   public void err_login(){
   	//Vibrator vibrator =(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
	    //vibrator.vibrate(200);
	    Toast toast1 = Toast.makeText(getApplicationContext(),"Error: Nombre de usuario incorrecto", Toast.LENGTH_SHORT);
	    toast1.show();    	
   }
		
   /*Valida el estado del logueo solamente necesita como parametros el usuario y passw*/
   public boolean loginstatus(String username) {
   	int logstatus=-1;
   	
   	/*Creamos un ArrayList del tipo nombre valor para agregar los datos recibidos por los parametros anteriores
   	 * y enviarlo mediante POST a nuestro sistema para relizar la validacion*/ 
   	ArrayList<NameValuePair> postparameters2send= new ArrayList<NameValuePair>();
    		
		    		postparameters2send.add(new BasicNameValuePair("usuario",username));
		    		//postparameters2send.add(new BasicNameValuePair("password",password));

		   //realizamos una peticion y como respuesta obtenes un array JSON
     		JSONArray jdata=post.getserverdata(postparameters2send, URL_connect);

     		/*como estamos trabajando de manera local el ida y vuelta sera casi inmediato
     		 * para darle un poco realismo decimos que el proceso se pare por unos segundos para poder
     		 * observar el progressdialog
     		 * la podemos eliminar si queremos
     		 */
		    SystemClock.sleep(100);
		    		
		    //si lo que obtuvimos no es null
		    	if (jdata!=null && jdata.length() > 0){

		    		JSONObject json_data; //creamos un objeto JSON
					try {
						json_data = jdata.getJSONObject(0); //leemos el primer segmento en nuestro caso el unico
						 logstatus=json_data.getInt("logstatus");//accedemos al valor 
						 Log.e("loginstatus","logstatus= "+logstatus);//muestro por log que obtuvimos
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}		            
		             
					//validamos el valor obtenido
		    		 if (logstatus==0){// [{"logstatus":"0"}] 
		    			 Log.e("loginstatus ", "invalido");
		    			 return false;
		    		 }
		    		 else{// [{"logstatus":"1"}]
		    			 Log.e("loginstatus ", "valido");
		    			 return true;
		    		 }
		    		 
			  }else{	//json obtenido invalido verificar parte WEB.
		    			 Log.e("JSON  ", "ERROR");
			    		return false;
			  }
   	
   }
   
                  
   
/*		CLASE ASYNCTASK
* 
* usaremos esta para poder mostrar el dialogo de progreso mientras enviamos y obtenemos los datos
* podria hacerse lo mismo sin usar esto pero si el tiempo de respuesta es demasiado lo que podria ocurrir    
* si la conexion es lenta o el servidor tarda en responder la aplicacion sera inestable.
* ademas observariamos el mensaje de que la app no responde.     
*/
   
   class asynclogin extends AsyncTask< String, String, String > {
   	 
   	String user,pass;
       protected void onPreExecute() {
       	//para el progress dialog
           pDialog = new ProgressDialog(Olvido.this);
           pDialog.setMessage("Autenticando....");
           pDialog.setIndeterminate(false);
           pDialog.setCancelable(false);
           pDialog.show();
       }

		protected String doInBackground(String... params) {
			//obtnemos usr y pass
			user=params[0];
			//pass=params[1];
           
			//enviamos y recibimos y analizamos los datos en segundo plano.
   		if (loginstatus(user)==true){    		    		
   			return "ok"; //login valido
   		}else{    		
   			return "err"; //login invalido     	          	  
   		}
       	
		}
      
		/*Una vez terminado doInBackground segun lo que halla ocurrido 
		pasamos a la sig. activity
		o mostramos error*/
       protected void onPostExecute(String result) {

          pDialog.dismiss();//ocultamos progess dialog.
          Log.e("onPostExecute=",""+result);
          
          if (result.equals("ok")){

				/*Intent i=new Intent(MainActivity.this, Evaluacion.class);
				i.putExtra("user",user);
				startActivity(i);*/ 
        	 Toast toast1 = Toast.makeText(getApplicationContext(),"Tu contraseña ha sido enviada", Toast.LENGTH_SHORT);
       	    toast1.show();  
      		Intent intent =new Intent (Olvido.this, MainActivity.class);
    			
                 startActivity(intent);
				
           }else{
           	err_login();
           }
           
               									}
		
       }




	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.olvido, menu);
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
