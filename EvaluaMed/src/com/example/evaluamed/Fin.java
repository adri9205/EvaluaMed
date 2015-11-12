package com.example.evaluamed;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Fin extends Activity {
	String user;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fin);
		Button evaluar=(Button) findViewById(R.id.BtnVolver);
		Button salir=(Button) findViewById(R.id.BtnSalir);
		Bundle extras = getIntent().getExtras();
        //Obtenemos datos enviados en el intent.
        if (extras != null) {
     	   user  = extras.getString("user");//usuario
     	 
        }else{
     	   user="error";
     	   }
		View.OnClickListener registroListener = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                    Intent intent =new Intent (Fin.this, MainActivity.class);
                    startActivity(intent);
            }

        };
        salir.setOnClickListener(registroListener);
        View.OnClickListener registroListener1 = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                    Intent intent =new Intent (Fin.this, Evaluacion.class);
                    intent.putExtra("user", user);
                    startActivity(intent);
            }

        };
        evaluar.setOnClickListener(registroListener1);
	}
	 @Override
	 public boolean onKeyDown(int keyCode, KeyEvent event)  {
	     if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
	         // no hacemos nada.
	         return true;
	     }

	     return super.onKeyDown(keyCode, event);
	 }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.fin, menu);
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
