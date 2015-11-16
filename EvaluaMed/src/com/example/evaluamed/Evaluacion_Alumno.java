package com.example.evaluamed;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Evaluacion_Alumno extends Activity {
	String user;
	String ID;
	Double promedio;
	Double juicio, conocimiento, interrogatorio, fisica, clinico, quirurgico,comunicacion, desempeno, desarrollo;
	String titulo[]={"Jucio Clínico", "Aplicación conocimiento médico",
			"Aplicación de habilidades clínicas-Interrogatorio",
			"Aplicación de habilidades clínicas-Exploración Física", 
			"Aplicación de habilidades clínicas-Expediente Clínico", 
			"Aplicación de habilidades clínicas-Comportamiento Quirúrgico", 
			"Comunicación efectiva", "Desempeño en Sistema de salud", 
			"Desarrollo Personal"};
	String descripcion[]={
			"Capaz de reaccionar a la aplicación clínica que se le presenta con su conocimiento médico.\n Conoce los métodos diagnósticos y tratamiento al nivel del curso",
			"Actualizado, extenso, organizado, adecuado al nivel del curso", 
			"Bien, digido, lógico y completo",
			"Completa organizada, bien dirigida", 
			"Expediente clínico ordenado, bien integrado, da seguimiento al paciente",
			"Conoce al paciente, sus diagnósticos, su anatomía, técnica quirurgica y potenciales complicaciones",
			"Tiene una comunicación efectiva con el paciente y su familia, excelente comunicación oral, escrita y telefónica",
			"Demuestra respeto,compasión, empatía con el paciente y con su familia. Busca el mayor beneficio del paciente, respeta a otros alumnos, residentes, profesores y personal de salud",
			"Siempre llega a tiempo, cuida su apariencia, demuestra interés por aprender. Reconoce debilidades y fortalezas. Cumple siempre con sus compromisos. Busca la excelencia."
			};
    
   double suma=0;
   Integer n=0;
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
        final ArrayList<String> list = new ArrayList<String>();
        final ArrayList<String> list1 = new ArrayList<String>();
	    final ArrayList<Double> list2 = new ArrayList<Double>();
	    for (int i=0; i<titulo.length; i++){
	    	list.add(titulo[i]);
	    	list1.add(descripcion[i]);
	    	list2.add(0.0);
	    	//list1.add(descripcion[i]);
	    	//list2.add(0.0);
	    }
	  //instantiate custom adapter
	    MyCustomAdapter adapter = new MyCustomAdapter(list,list1,list2, this);
	    ListView lView = (ListView)findViewById(R.id.list2);
	    lView.setAdapter(adapter);
	    
		
		OnItemClickListener registro = new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
			//	Libro perfil=(Libro)miAdaptador.getItem(arg2);
				Toast.makeText(Evaluacion_Alumno.this,descripcion[arg2], Toast.LENGTH_LONG).show();
				
				// TODO Auto-generated method stub
				
			}
			
		};
		lView.setOnItemClickListener(registro);
	   
        View.OnClickListener registroListener1 = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
            		for (int i=0; i<list2.size(); i++){
            			if (list2.get(i)!=0){
            				n+=1;
            				suma+=list2.get(i);
            			}
            			
            		}
            		System.out.println(suma);
            		System.out.println(n);
            		promedio= (suma/n);
            		//Double juicio, conocimiento, interrogatorio, 
            		//fisica, clinico, quirurgico,comunicacion, desempeno, desarrollo;
            		juicio=list2.get(0);
            		conocimiento=list2.get(1);
            		interrogatorio=list2.get(2);
            		fisica=list2.get(3);
            		clinico=list2.get(4);
            		quirurgico=list2.get(5);
            		comunicacion=list2.get(6);
            		desempeno=list2.get(7);
            		desarrollo=list2.get(8);
            		System.out.println(promedio);
                    Intent intent =new Intent (Evaluacion_Alumno.this, ComentariosActivity.class);
                    intent.putExtra("ID", ID);
       			    intent.putExtra("user", user);
       			    intent.putExtra("promedio", promedio);
       			    intent.putExtra("juicio", juicio);
    			    intent.putExtra("conocimiento", conocimiento);
    			    intent.putExtra("interrogatorio", interrogatorio);
    			    intent.putExtra("fisica", fisica);
       			    intent.putExtra("clinico", clinico);
       			    intent.putExtra("quirurgico", quirurgico);
       			    intent.putExtra("comunicacion", comunicacion);
    			    intent.putExtra("desempeno", desempeno);
    			    intent.putExtra("desarrollo", desarrollo);
    			    
       			    
    			    
       			    
       			    
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
