package com.example.evaluamed;

import com.example.evaluamed.library.Httppostaux;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Olvido extends Activity {
	Httppostaux post;
	   // String URL_connect="http://www.scandroidtest.site90.com/acces.php";
		String URL_connect="http://evaluacionqx.com/android/acces.php";
	    //String IP_Server="192.168.3.20";//IP DE NUESTRO PC
	   // String URL_connect="http://"+IP_Server+"/droidlogin/acces.php";//ruta en donde estan nuestros archivos
	  
	    boolean result_back;
	    private ProgressDialog pDialog;
	    EditText user;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_olvido);
		TextView email=(TextView) findViewById(R.id.textView1);
		Button enviar=(Button) findViewById(R.id.BtnRecuperar);
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
