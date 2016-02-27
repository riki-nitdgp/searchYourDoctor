package com.example.riki.doctor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Riki on 18/12/2015.
 */
public class Myadapter extends ArrayAdapter {
    Context context;
    int [] pic;
    String [] catagory;
    public Myadapter(Context context, int [] pic,String[] catagory) {
        super(context, R.layout.catagory,catagory);
        this.context=context;
        this.pic=pic;
        this.catagory=catagory;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        //Introducing Layout Variable image view and text view

        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view =layoutInflater.inflate(R.layout.catagory,parent,false);
        ImageView imageView= (ImageView) view.findViewById(R.id.iv);
        TextView textView= (TextView) view.findViewById(R.id.tv1);

        //set resources;


        imageView.setImageResource(pic[position]);
        textView.setText(catagory[position]);

        return view;
    }

   }

