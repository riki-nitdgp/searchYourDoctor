package com.example.riki.doctor;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


public class Hospital extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital);
        ListView listView = (ListView) findViewById(R.id.iv);
        final String [] name= getResources().getStringArray(R.array.Hname);
        final String [] address=  getResources().getStringArray(R.array.Haddress);
        final int pic[] ={R.drawable.a,R.drawable.a,R.drawable.b,R.drawable.d,R.drawable.p,R.drawable.m,R.drawable.s};
        Hospitaladapter hospitaladapter=new Hospitaladapter(getApplicationContext(),pic,name,address);
        listView.setAdapter(hospitaladapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getApplicationContext(),Store.class);
                intent.putExtra("position",position);
                intent.putExtra("name",name[position]);
                startActivity(intent);

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hospital, menu);
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
