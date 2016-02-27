package com.example.riki.doctor;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


public class Store extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        final TextView textView= (TextView) findViewById(R.id.store);
        ListView list= (ListView) findViewById(R.id.lv1);
        Button btn= (Button) findViewById(R.id.map);
        Intent intent=getIntent();
        final int position=intent.getIntExtra("position",1);
        final String store=intent.getStringExtra("name");

        //atul Medical
        final String[] atul_doc=getResources().getStringArray(R.array.atul_medical_doctor);
        final String[] atul_time=getResources().getStringArray(R.array.atul_time);
        final String[] atul_spl=getResources().getStringArray(R.array.atul_spl);

        //adhakari medical
         final String[] adhi_doc=getResources().getStringArray(R.array.adhakari_dr);
         final String[] adhi_spl=getResources().getStringArray(R.array.atul_spl);
         final String[] adhi_time=getResources().getStringArray(R.array.adhakari_medical);

        //Basu Medical

        final String[] basu_doc=getResources().getStringArray(R.array.basu_doctor);
        final String[] basu_spl=getResources().getStringArray(R.array.basu_spl);
        final String[] basu_time=getResources().getStringArray(R.array.basu_time);

        //Damoodar

        final String[] dam_doc=getResources().getStringArray(R.array.damoodar_doc);
        final String[] dam_spl=getResources().getStringArray(R.array.damoodar_spl);
        final String[] dam_time=getResources().getStringArray(R.array.damoodar_time);

        //Pappu

        final String[] pappu_doc=getResources().getStringArray(R.array.pappu_doctor);
        final String[] pappu_spl=getResources().getStringArray(R.array.pappu_spl);
        final String[] pappu_time=getResources().getStringArray(R.array.psppu_time);

        //Mansi
         final String[] mansi_doc =getResources().getStringArray(R.array.mansi_doctor);
         final String[] mansi_spl = getResources().getStringArray(R.array.mansi_spl);
         final String[] mansi_time =getResources().getStringArray(R.array.mansi_time);

        //Sairam.

        final String[] sai_doc=getResources().getStringArray(R.array.sai_doc);
        final String[] sai_spl= getResources().getStringArray(R.array.sai_spl);
        final String[] sai_time=getResources().getStringArray(R.array.sai_time);

        switch (position){
            case 0:
                StoreAdapter atul=new StoreAdapter(getApplicationContext(),atul_doc,atul_spl,atul_time);
                list.setAdapter(atul);
               textView.setText(store);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final double atul_lat=22.3438457;
                        final double atul_long=87.27859255;
                        Intent atul=new Intent(getApplicationContext(),ShowMap.class);
                        atul.putExtra("store",store);
                        atul.putExtra("lat",atul_lat);
                        atul.putExtra("longi",atul_long);
                        startActivity(atul);
                    }
                });
                break;
            case 1:
                 StoreAdapter adhakari=new StoreAdapter(getApplicationContext(),adhi_doc,adhi_spl,adhi_time);
                list.setAdapter(adhakari);
                textView.setText(store);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent adhai =new Intent(getApplicationContext(),ShowMap.class);
                        final double adhi_lat=22.34424978;
                        final double adhi_long=87.28551629;
                        adhai.putExtra("store",store);
                        adhai.putExtra("lat",adhi_lat);
                        adhai.putExtra("longi",adhi_long);
                        startActivity(adhai);
                    }
                });
                break;
            case 2:
                StoreAdapter basu=new StoreAdapter(getApplicationContext(),basu_doc,basu_doc,basu_time);
                list.setAdapter(basu);
                textView.setText(store);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent basui=new Intent(getApplicationContext(),ShowMap.class);
                        final double basu_lat=22.34459244;
                        final double basu_long=87.29291756;
                        basui.putExtra("store",store);
                        basui.putExtra("lat",basu_lat);
                        basui.putExtra("longi",basu_long);
                        startService(basui);
                    }
                });
                break;
            case 3:
                StoreAdapter dam=new StoreAdapter(getApplicationContext(),dam_doc,dam_spl,dam_time);
                list.setAdapter(dam);
                textView.setText(store);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent damo=new Intent(getApplicationContext(),ShowMap.class);
                        final double dam_lat=22.34374437;
                        final double dam_long=87.28402753;
                        damo.putExtra("store",store);
                        damo.putExtra("lat",dam_lat);
                        damo.putExtra("longi",dam_long);
                        startActivity(damo);
                    }
                });
                break;
            case 4:
                StoreAdapter pappu=new StoreAdapter(getApplicationContext(),pappu_doc,pappu_spl,pappu_time);
                list.setAdapter(pappu);
                textView.setText(store);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent pappum=new Intent(getApplicationContext(),ShowMap.class);
                        final double pappu_lat=22.344244978;
                        final double pappu_long=87.28551629;
                        pappum.putExtra("store",store);
                        pappum.putExtra("lat",pappu_lat);
                        pappum.putExtra("longi",pappu_long);
                        startActivity(pappum);
                    }
                });
                break;
            case 5:
                 StoreAdapter mansi=new StoreAdapter(getApplicationContext(),mansi_doc,mansi_spl,mansi_time);
                list.setAdapter(mansi);
                textView.setText(store);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent mansi_d=new Intent(getApplicationContext(),ShowMap.class);
                        final double mansi_lat=22.3463031;
                        final double mansi_long=87.28901026;
                        mansi_d.putExtra("store",store);
                        mansi_d.putExtra("lat",mansi_lat);
                        mansi_d.putExtra("longi",mansi_long);
                        startActivity(mansi_d);
                    }
                });
                break;
            case 6:
              StoreAdapter sai=new StoreAdapter(getApplicationContext(),sai_doc,sai_spl,sai_time);
              list.setAdapter(sai);
                textView.setText(store);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent sai_m=new Intent(getApplicationContext(),ShowMap.class);
                        final double sai_lat=22.34421486;
                        final double sai_long=87.28314573;
                        sai_m.putExtra("store",store);
                        sai_m.putExtra("lat",sai_lat);
                        sai_m.putExtra("longi",sai_long);
                        startActivity(sai_m);
                    }
                });
                break;
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_store, menu);
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
