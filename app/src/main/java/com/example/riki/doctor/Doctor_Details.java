package com.example.riki.doctor;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;


public class Doctor_Details extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor__details);
        ListView listView= (ListView) findViewById(R.id.details);
        TextView textView= (TextView) findViewById(R.id.txt);
        TextView name= (TextView) findViewById(R.id.name);
        TextView address= (TextView) findViewById(R.id.address);
        Intent intent=getIntent();
        int position = intent.getIntExtra("position",1);
        final String catagory = intent.getStringExtra("catagory");

        //GENERAL PHYSICIAN
        final String[] genral= getResources().getStringArray(R.array.genphy);
        final String[] gaddress=getResources().getStringArray(R.array.genphyaddress);

        //Dental
        final String[] dental=getResources().getStringArray(R.array.Dental);
        final String[] dental_address=getResources().getStringArray(R.array.Dental_address);

        //Eye
        final String[] eye=getResources().getStringArray(R.array.eye);
        final String[]eye_details=getResources().getStringArray(R.array.eye_details);

        //Gyneco
        final String[] gyneco=getResources().getStringArray(R.array.gyno);
        final String[] gyno_details=getResources().getStringArray(R.array.gyno_details);

        //Neuro
        final String[] neuro=getResources().getStringArray(R.array.neuro);
        final String[] neuro_details=getResources().getStringArray(R.array.neuro_details);

        //
        final String[] skin=getResources().getStringArray(R.array.skin);
        final String[] skin_details=getResources().getStringArray(R.array.skin_delails);

        //
        final String[] gas=getResources().getStringArray(R.array.gas);
        final String[] gas_details=getResources().getStringArray(R.array.gas_details);

        //
        final String[] child=getResources().getStringArray(R.array.child);
        final String[] child_details=getResources().getStringArray(R.array.child_details);


        switch(position){
            case 0:
                DoctorDetailsAdapter gen= new DoctorDetailsAdapter(getApplicationContext(),genral,gaddress);
                listView.setAdapter(gen);
                textView.setText(catagory);

                break;
            case 1:
                DoctorDetailsAdapter dental1 =new DoctorDetailsAdapter(getApplicationContext(),dental,dental_address);
                listView.setAdapter(dental1);
                textView.setText(catagory);

                break;
            case 2:
                DoctorDetailsAdapter eye1=new DoctorDetailsAdapter(getApplicationContext(),eye,eye_details);
                listView.setAdapter(eye1);
                textView.setText(catagory);

                break;
            case 3:
                DoctorDetailsAdapter Gyno1=new DoctorDetailsAdapter(getApplicationContext(),gyneco,gyno_details);
                listView.setAdapter(Gyno1);
                textView.setText(catagory);

                break;
            case 4:
                DoctorDetailsAdapter neuro1=new DoctorDetailsAdapter(getApplicationContext(),neuro,neuro_details);
                listView.setAdapter(neuro1);
                textView.setText(catagory);

                break;
            case 5:
                DoctorDetailsAdapter skin1=new DoctorDetailsAdapter(getApplicationContext(),skin,skin_details);
                listView.setAdapter(skin1);
                textView.setText(catagory);

                break;
            case 6:
                DoctorDetailsAdapter gas1=new DoctorDetailsAdapter(getApplicationContext(),gas,gas_details);
                listView.setAdapter(gas1);
                textView.setText(catagory);

                break;
            case 7:
                DoctorDetailsAdapter child1=new DoctorDetailsAdapter(getApplicationContext(),child,child_details);
                listView.setAdapter(child1);
                textView.setText(catagory);
                break;


        }











    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_doctor__details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
