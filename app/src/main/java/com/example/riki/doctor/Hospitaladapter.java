package com.example.riki.doctor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Riki on 18/12/2015.
 */
public class Hospitaladapter extends ArrayAdapter {
    Context context;
    int[] pic;
    String[] Hname;
    String[] Haddress;

    public Hospitaladapter(Context context, int[] pic, String[] Hname, String[] Haddress) {

        super(context, R.layout.hospital,Hname);
        this.context = context;
        this.pic = pic;
        this.Hname = Hname;
        this.Haddress = Haddress;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Introducing Layout Variable image view and text view
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.hospital, parent, false);
        ImageView imageView= (ImageView) view.findViewById(R.id.iv1);
        TextView name = (TextView) view.findViewById(R.id.textView2);
        TextView address = (TextView) view.findViewById(R.id.address);

        imageView.setImageResource(pic[position]);
        name.setText(Hname[position]);
        address.setText(Haddress[position]);
        return view;

    }
}