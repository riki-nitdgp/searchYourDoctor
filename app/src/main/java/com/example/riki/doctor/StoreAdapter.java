package com.example.riki.doctor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Riki on 20/01/2016.
 */
public class StoreAdapter extends ArrayAdapter {
    Context  context;
    String[] name;
    String[] time;
    String[] cat;
    public StoreAdapter(Context context,String[] name,String[] time,String[] cat) {
        super(context,R.layout.store_details,name);
        this.context=context;
        this.cat=cat;
        this.name=name;
        this.time=time;
    }
    @Override
   public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.store_details,parent,false);
        TextView name1= (TextView) view.findViewById(R.id.name);
        TextView time1= (TextView) view.findViewById(R.id.time);
        TextView cat1= (TextView) view.findViewById(R.id.cat);

        //Setting Resource

        name1.setText(name[position]);
        time1.setText(cat[position]);
        cat1.setText(time[position]);

        return view;



  }
}
