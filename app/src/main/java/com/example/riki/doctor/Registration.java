package com.example.riki.doctor;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;


public class Registration extends Activity {
    Mydbadapter mydbadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        // myDbhelper=new MyDbhelper(getApplicationContext());
        //myDbhelper=new MyDbhelper(this);

        //SQLiteDatabase sqLiteDatabase=myDbhelper.getWritableDatabase();

        // Introducing Form Variable
        final EditText name =      (EditText) findViewById(R.id.name);
        final EditText date =      (EditText) findViewById(R.id.date);
        final EditText phone =     (EditText) findViewById(R.id.phone);
        final EditText email =     (EditText) findViewById(R.id.email);
        final EditText password =  (EditText) findViewById(R.id.pass);
        final EditText cpass   =   (EditText) findViewById(R.id.confrimpass);
        final RadioGroup gender =  (RadioGroup) findViewById(R.id.gender);
        final Spinner city  =      (Spinner) findViewById(R.id.spiner);
        final Button register  =   (Button) findViewById(R.id.register);


        //Function of Registration button
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mydbadapter=new Mydbadapter(getApplication());
                int checkedid = gender.getCheckedRadioButtonId();
                RadioButton radioButton = (RadioButton) findViewById(checkedid);
                String pname  =   name.getText().toString();
                String dob    =   date.getText().toString();
                String mobno  =   phone.getText().toString();
                String email1 =   email.getText().toString();
                String pass   =   password.getText().toString();
                String passw  =   cpass.getText().toString();
                String gender = radioButton.getText().toString();
                String selectcity = city.getSelectedItem().toString();


                //VALIDATION

                boolean invalid=false;
                if(pname.equals("")){
                    Toast.makeText(getApplicationContext(), "Enter Your Name", Toast.LENGTH_SHORT).show();
                    invalid=true;

                }
                else if (dob.equals("")){
                    Toast.makeText(getApplicationContext(),"Enter Your Date Of Birth",Toast.LENGTH_SHORT).show();
                    invalid=true;

                }
                else if(mobno.equals("")){

                    Toast.makeText(getApplicationContext(),"Enter Your Mobile No.",Toast.LENGTH_SHORT).show();
                    invalid=true;

                }
                else if(email.equals("")){
                    Toast.makeText(getApplicationContext(),"Enter Your Email",Toast.LENGTH_SHORT).show();
                    invalid=true;
                }
                else if(pass.equals("")){

                    Toast.makeText(getApplicationContext(),"Enter Your Password",Toast.LENGTH_SHORT).show();
                    invalid=true;

                }
                else if(passw.equals("")){
                    Toast.makeText(getApplicationContext(),"Renter Your Password",Toast.LENGTH_SHORT).show();
                    invalid=true;

                }
                else if(!passw.equals(pass)){
                    Toast.makeText(getApplicationContext()," Password Dosn't Match",Toast.LENGTH_SHORT).show();
                    invalid=true;


                }
                else{
                    long insert=mydbadapter.insertdata(pname,dob,mobno,email1,pass,gender,selectcity);
                    if(insert<0){
                        Toast.makeText(getApplicationContext(), "Registration Failed", Toast.LENGTH_LONG).show();

                    }
                    else {


                        invalid = false;
                        Intent intent = new Intent(getApplicationContext(), Login.class);
                        Toast.makeText(getApplicationContext(), "Register Sucessfully", Toast.LENGTH_LONG).show();
                        startActivity(intent);
                    }
                }


            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_registration, menu);
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
