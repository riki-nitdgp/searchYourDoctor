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
import android.widget.Toast;


public class Login extends Activity {
    Mydbadapter mydbadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //introducing form content
        final EditText username        = (EditText) findViewById(R.id.username);
        final   EditText password        = (EditText) findViewById(R.id.password);
        final Button loginbutton       = (Button) findViewById(R.id.loginbutton);
        final   Button registrationbutton= (Button) findViewById(R.id.registrationbutton);

        //LOGIN BUTTON FUNCTION
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mydbadapter=new Mydbadapter(getApplicationContext());
                String uid=username.getText().toString();
                String pass=password.getText().toString();



                //validation

               boolean invalid=false;
               if (uid.equals("")){
                   Toast.makeText(getApplicationContext(),"Please Enter Your Email 0r UserId",Toast.LENGTH_SHORT).show();
                   invalid=true;
               }
               else if (pass.equals("")){
                   Toast.makeText(getApplicationContext(),"Please Enter Your Password",Toast.LENGTH_SHORT).show();
                   invalid=true;

               }
               else {
                    invalid=false;
                   String log=mydbadapter.login(uid,pass);
                   Toast.makeText(getApplicationContext(), log, Toast.LENGTH_LONG).show();
                   Intent intent = new Intent(getApplicationContext(), Welcome.class);
                   startActivity(intent);

               }





            }
        });
        // FUNCTION OF REGISTRATION BUTTON
        registrationbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1= new Intent(getApplicationContext(),Registration.class);
                startActivity(intent1);
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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





