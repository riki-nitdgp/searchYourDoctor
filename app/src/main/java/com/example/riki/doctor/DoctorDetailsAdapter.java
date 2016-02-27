package com.example.riki.doctor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Riki on 22/12/2015.
 */
public class DoctorDetailsAdapter extends ArrayAdapter {
    Context context;
    String[] name;
    String[] address;

    public DoctorDetailsAdapter(Context context, String[] name,String[] addresss) {
        super(context, R.layout.doctordetails,name);
        this.context=context;
        this.name=name;
        this.address=addresss;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.doctordetails,parent,false);
        TextView dname = (TextView) view.findViewById(R.id.name);
        TextView address1= (TextView) view.findViewById(R.id.address);

        dname.setText(name[position]);
        address1.setText(address[position]);
        return view;
    }
}
