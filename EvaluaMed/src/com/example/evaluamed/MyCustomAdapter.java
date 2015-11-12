package com.example.evaluamed;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;

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
    TextView listItemText1 = (TextView)view.findViewById(R.id.textView2); 
    listItemText1.setText(list1.get(position)); 
    

    //Handle buttons and add onClickListeners
    Button btn4 = (Button)view.findViewById(R.id.Btn_4);
    Button btn5 = (Button)view.findViewById(R.id.Btn_5);
    Button btn6 = (Button)view.findViewById(R.id.Btn_6);
    Button btn7 = (Button)view.findViewById(R.id.Btn_7);
    Button btn7_5 = (Button)view.findViewById(R.id.Btn_7_5);
    Button btn8 = (Button)view.findViewById(R.id.Btn_8);
    Button btn9 = (Button)view.findViewById(R.id.Btn_9);
    Button btn9_5 = (Button)view.findViewById(R.id.Btn_9_5);
    Button btn10 = (Button)view.findViewById(R.id.Btn_10);
    Button NA = (Button)view.findViewById(R.id.Btn_no_aplica);
      btn4.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) { 
            //do something
        
        	list2.set(position, 4.0);
        	
            notifyDataSetChanged();
        }
    });
      
      btn5.setOnClickListener(new View.OnClickListener(){
          @Override
          public void onClick(View v) { 
              //do something
          
          	list2.set(position, 5.0);
              notifyDataSetChanged();
          }
      });
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
      NA.setOnClickListener(new View.OnClickListener(){
          @Override
          public void onClick(View v) { 
              //do something
          
          	list2.set(position, 0.0);
          	
              notifyDataSetChanged();
          }
      });




    return view; 
} 
}
