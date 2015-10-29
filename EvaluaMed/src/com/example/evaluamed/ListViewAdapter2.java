package com.example.evaluamed;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.NumberPicker;
import android.widget.TextView;

public class ListViewAdapter2 extends ArrayAdapter<Calificaciones> {
	private Context context;
	int layoutResourceId;
	List <Calificaciones> listaCalificaciones;
	public ListViewAdapter2(Context context, int resource, List<Calificaciones> calificaciones){
		super (context, resource, calificaciones);
		this.context=context;
		this.listaCalificaciones=calificaciones;
		this.layoutResourceId=resource;
	}
	public View getView(int position, View convertView, ViewGroup parent){
		View row =convertView;
		
		if (row==null){
			LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row=inflater.inflate(layoutResourceId, parent, false);
		}
		
		TextView titulo=(TextView)row.findViewById(R.id.textView1);
		TextView descripcion=(TextView)row.findViewById(R.id.textView2);
		NumberPicker cal=(NumberPicker)row.findViewById(R.id.numberPicker1);
		/*numberPicker.setMinValue(0); 
        numberPicker.setMaxValue(100);    
        numberPicker.setWrapSelectorWheel(true);
        numberPicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
		 * // within onCreate
numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
    @Override
    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
        Log.d("DEBUG", "Selected number in picker is " + newVal);
    }
});
*/
		//TextView fecha_publicacion=(TextView)row.findViewById(R.id.textView7);
		//3 año  y 2especialidad
		//TextView especialidad=(TextView)row.findViewById(R.id.textView2);
		//TextView year=(TextView)row.findViewById(R.id.textView3);
		
		//titulo.setTextColor(Color.rgb(0,0,0));
		//isbn.setTextColor(Color.rgb(0,0,0));
		//fecha_publicacion.setTextColor(Color.rgb(0,0,0));
		//year.setTextColor(Color.rgb(0,0,0));
		//especialidad.setTextColor(Color.rgb(0,0,0));
		Calificaciones calificacion=listaCalificaciones.get(position);
		//titulo.setText(libro.getTitulo()+" "+libro.getIsbn()+" "+libro.getFecha_publicacion()+"\n"+libro.getEsp()+" "+libro.getYear());
		//isbn.setText(libro.getIsbn());
		//fecha_publicacion.setText(libro.getFecha_publicacion());
		//especialidad.setText(libro.getEsp());
		//year.setText(libro.getYear());
		
		//tv1.setBackgroundColor(0xFF12FF45);
        //tv1.setText("Background color from int color (0xFF12FF45)");
		
		return row;
	}
	
}
