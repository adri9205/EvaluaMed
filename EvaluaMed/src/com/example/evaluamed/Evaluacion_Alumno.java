package com.example.evaluamed;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class Evaluacion_Alumno extends Activity {
	String user;
	String ID;
	Double promedio;
	String titulo[]={"Jucio Cl�nico", "Aplicaci�n conocimiento m�dico",
			"Aplicaci�n de habilidades cl�nicas-Interrogatorio",
			"Aplicaci�n de habilidades cl�nicas-Exploraci�n F�sica", 
			"Aplicaci�n de habilidades cl�nicas-Expediente Cl�nico", 
			"Aplicaci�n de habilidades cl�nicas-Comportamiento Quir�rgico", 
			"Comunicaci�n efectiva", "Desempe�o en Sistema de salud", 
			"Desarrollo Personal", "Impresi�n General del alumno"};
	String descripcion[]={"Capaz de reaccionar a la aplicaci�n cl�nica que se le presenta con su conocimiento m�dico.\n Conoce los m�todos diagn�sticos y tratamiento al nivel del curso",
			"Actualizado, extenso, organizado, adecuado al nivel del curso", "Bien, digido, l�gico y completo",
			"Completa organizada, bien dirigida", "Expediente cl�nico ordenado, bien integrado, da seguimiento al paciente",
			"Conoce al paciente, sus diagn�sticos, su anatom�a, t�cnica quirurgica y potenciales complicaciones",
			"Tiene una comunicaci�n efectiva con el paciente y su familia, excelente comunicaci�n oral, escrita y telef�nica",
			"Demuestra respeto,compasi�n, empat�a con el paciente y con su familia. Busca el mayor beneficio del paciente, respeta a otros alumnos, residentes, profesores y personal de salud"
			,"Siempre llega a tiempo, cuida su apariencia, demuestra inter�s por aprender. Reconoce debilidades y fortalezas. Cumple siempre con sus compromisos. Busca la excelencia."};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_evaluacion__alumno);
		ListView preguntas=(ListView) findViewById(R.id.list2);
		Button sig=(Button) findViewById(R.id.button1);
		Calendar c = Calendar.getInstance();
		//System.out.println("Current time => " + c.getTime());

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = df.format(c.getTime());
		Bundle extras = getIntent().getExtras();
        //Obtenemos datos enviados en el intent.
        if (extras != null) {
     	   user  = extras.getString("user");//usuario
     	   ID = extras.getString("ID");
        }else{
     	   user="error";
     	   }

        View.OnClickListener registroListener1 = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                    Intent intent =new Intent (Evaluacion_Alumno.this, ComentariosActivity.class);
                    intent.putExtra("ID", ID);
       			    intent.putExtra("user", user);
       			    intent.putExtra("promedio", promedio);
                    startActivity(intent);
            }

        };
        sig.setOnClickListener(registroListener1);
		//System.out.println("ID => " + ID +" "+user);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.evaluacion__alumno, menu);
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
