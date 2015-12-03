package com.example.evaluamed;

import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class ListViewAdapter extends ArrayAdapter<Libro> {

	private Context context;
	int layoutResourceId;
	List <Libro> listaLibros;
	public ListViewAdapter(Context context, int resource, List<Libro> libros){
		super (context, resource, libros);
		this.context=context;
		this.listaLibros=libros;
		this.layoutResourceId=resource;
	}
	
	

	public View getView(int position, View convertView, ViewGroup parent){
		View row =convertView;
		
		if (row==null){
			LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row=inflater.inflate(layoutResourceId, parent, false);
		}
		
		TextView titulo=(TextView)row.findViewById(R.id.textView1);
		//TextView isbn=(TextView)row.findViewById(R.id.textView5);
		//TextView fecha_publicacion=(TextView)row.findViewById(R.id.textView7);
		//3 año  y 2especialidad
		//TextView especialidad=(TextView)row.findViewById(R.id.textView2);
		//TextView year=(TextView)row.findViewById(R.id.textView3);
		
		titulo.setTextColor(Color.rgb(0,0,0));
		//isbn.setTextColor(Color.rgb(0,0,0));
		//fecha_publicacion.setTextColor(Color.rgb(0,0,0));
		//year.setTextColor(Color.rgb(0,0,0)); 
		//especialidad.setTextColor(Color.rgb(0,0,0));
		Libro libro=listaLibros.get(position);
		titulo.setText(libro.getTitulo()+" "+libro.getIsbn()+" "+libro.getFecha_publicacion()+"\n"+libro.getEsp()+" R"+libro.getYear());
		//isbn.setText(libro.getIsbn());
		//if (libro.getYear()==5)
		//fecha_publicacion.setText(libro.getFecha_publicacion());
		//especialidad.setText(libro.getEsp());
		//year.setText(libro.getYear());
		
		if (libro.getYear().equals("5")){
			titulo.setBackgroundColor(Color.rgb(51, 102, 0));
			titulo.setTextColor(Color.BLACK);
		}
		if (libro.getYear().equals("4")){
			titulo.setBackgroundColor(Color.GREEN);
			titulo.setTextColor(Color.BLACK);
			
		}
		if (libro.getYear().equals("3")){
			titulo.setBackgroundColor(Color.YELLOW);
			titulo.setTextColor(Color.BLACK);
		}
		if (libro.getYear().equals("2")){
			titulo.setBackgroundColor(Color.rgb(255, 128, 0));
			titulo.setTextColor(Color.BLACK);
			
		}
		 if (libro.getYear().equals("1")){
			titulo.setBackgroundColor(Color.RED);
			titulo.setTextColor(Color.BLACK);
		}
		//tv1.setBackgroundColor(0xFF12FF45);
        //tv1.setText("Background color from int color (0xFF12FF45)");
		
		return row;
	}
	
	
}
