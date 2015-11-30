package com.example.evaluamed;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MyCustomAdapter extends BaseAdapter implements ListAdapter { 
private ArrayList<String> list = new ArrayList<String>(); 
private ArrayList<String> list1 = new ArrayList<String>(); 
private ArrayList<Double> list2 = new ArrayList<Double>(); 
private Context context; 



public MyCustomAdapter(ArrayList<String> list,ArrayList<String> list1, ArrayList<Double> list2, Context context) { 
    this.list = list; 
    this.list1 = list1;
    this.list2 = list2;
    this.context = context; 
} 

@Override
public int getCount() { 
    return list.size(); 
} 

@Override
public Object getItem(int pos) { 
    return list.get(pos); 
} 


@Override
public long getItemId(int pos) { 
    return 0;
    //just return 0 if your list items do not have an Id variable.
} 

@Override
public View getView(final int position, View convertView, ViewGroup parent) {
    View view = convertView;
    if (view == null) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); 
        view = inflater.inflate(R.layout.row, null);
        
    } 

    //Handle TextView and display string from your list
    TextView listItemText = (TextView)view.findViewById(R.id.textView1); 
    listItemText.setText(list.get(position)); 
    ImageButton btninfo = (ImageButton) view.findViewById(R.id.button1);
    final Button btn6 = (Button)view.findViewById(R.id.Btn_6);
    final Button btn7 = (Button)view.findViewById(R.id.Btn_7);
    final Button btn7_5 = (Button)view.findViewById(R.id.Btn_7_5);
    final Button btn8 = (Button)view.findViewById(R.id.Btn_8);
    final Button btn9 = (Button)view.findViewById(R.id.Btn_9);
    final Button btn9_5 = (Button)view.findViewById(R.id.Btn_9_5);
    final Button btn10 = (Button)view.findViewById(R.id.Btn_10);
      btn6.setOnClickListener(new View.OnClickListener(){
          @Override
          public void onClick(View v) { 
              //do something
          
          	list2.set(position, 6.0);
          	
              notifyDataSetChanged();
          }
      });
      btn7.setOnClickListener(new View.OnClickListener(){
          @Override
          public void onClick(View v) { 
              //do something
          
          	list2.set(position, 7.0);
              notifyDataSetChanged();
          }
      });
      btn7_5.setOnClickListener(new View.OnClickListener(){
          @Override
          public void onClick(View v) { 
              //do something
          
          	list2.set(position, 7.5);
              notifyDataSetChanged();
          }
      });

      btn8.setOnClickListener(new View.OnClickListener(){
          @Override
          public void onClick(View v) { 
              //do something
          
          	list2.set(position, 8.0);
              notifyDataSetChanged();
          }
      });
      btn9.setOnClickListener(new View.OnClickListener(){
          @Override
          public void onClick(View v) { 
              //do something
          
          	list2.set(position, 9.0);
              notifyDataSetChanged();
          }
      });
      btn9_5.setOnClickListener(new View.OnClickListener(){
          @Override
          public void onClick(View v) { 
              //do something
          
          	list2.set(position, 9.5);
              notifyDataSetChanged();
          }
      });
      btn10.setOnClickListener(new View.OnClickListener(){
          @Override
          public void onClick(View v) { 
              //do something
          
          	list2.set(position, 10.0);
         
              notifyDataSetChanged();
          }
      });
     btninfo.setOnClickListener(new View.OnClickListener(){
          @Override
          public void onClick(View v) { 
              //do something
        	  Toast.makeText(context, list1.get(position), Toast.LENGTH_LONG).show();
          }
      });
     if (list2.get(position)==6.0){
    		btn6.setBackgroundColor(Color.BLUE);
    	  	btn6.setTextColor(Color.WHITE);
    	  	
    	}
    	else{
    	   	btn6.setBackgroundResource(android.R.drawable.btn_default);
          	btn6.setTextColor(Color.BLACK);    	  	
    	}
     if (list2.get(position)==7.0){
 		btn7.setBackgroundColor(Color.BLUE);
 	  	btn7.setTextColor(Color.WHITE);
 	  	
 	}
 	else{
 	   	btn7.setBackgroundResource(android.R.drawable.btn_default);
       	btn7.setTextColor(Color.BLACK);    	  	
 	}
     if (list2.get(position)==7.5){
 		btn7_5.setBackgroundColor(Color.BLUE);
 	  	btn7_5.setTextColor(Color.WHITE);
 	  	
 	}
 	else{
 	   	btn7_5.setBackgroundResource(android.R.drawable.btn_default);
       	btn7_5.setTextColor(Color.BLACK);    	  	
 	}
     if (list2.get(position)==8.0){
 		btn8.setBackgroundColor(Color.BLUE);
 	  	btn8.setTextColor(Color.WHITE);
 	  	
 	}
 	else{
 	   	btn8.setBackgroundResource(android.R.drawable.btn_default);
       	btn8.setTextColor(Color.BLACK);    	  	
 	}
     if (list2.get(position)==9.0){
 		btn9.setBackgroundColor(Color.BLUE);
 	  	btn9.setTextColor(Color.WHITE);
 	  	
 	}
 	else{
 	   	btn9.setBackgroundResource(android.R.drawable.btn_default);
       	btn9.setTextColor(Color.BLACK);    	  	
 	}
     if (list2.get(position)==9.5){
 		btn9_5.setBackgroundColor(Color.BLUE);
 	  	btn9_5.setTextColor(Color.WHITE);
 	  	
 	}
 	else{
 	   	btn9_5.setBackgroundResource(android.R.drawable.btn_default);
       	btn9_5.setTextColor(Color.BLACK);    	  	
 	}
     if (list2.get(position)==10.0){
 		btn10.setBackgroundColor(Color.BLUE);
 	  	btn10.setTextColor(Color.WHITE);
 	  	
 	}
 	else{
 	   	btn10.setBackgroundResource(android.R.drawable.btn_default);
       	btn10.setTextColor(Color.BLACK);    	  	
 	}



    return view; 
} 
}
