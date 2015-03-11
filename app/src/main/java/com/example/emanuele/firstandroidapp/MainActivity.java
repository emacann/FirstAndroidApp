package com.example.emanuele.firstandroidapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private TextView attempts;
    private EditText username = null;
    private EditText password = null;
    private Button login_button;
    private int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText)findViewById(R.id.editText);
        password = (EditText)findViewById(R.id.editText2);
        attempts = (TextView)findViewById(R.id.textView4);
        attempts.setText(getString(R.string.attempts) + " " + Integer.toString(counter));
        login_button = (Button)findViewById(R.id.button);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(getCurrentFocus());
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void login (View view){
        String _username = username.getText().toString();
        String _password = password.getText().toString();

        if (_username.equals("admin") && _password.equals("admin")){
            Toast.makeText(getApplicationContext(), getString(R.string.redirecting), Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(), getString(R.string.auth_fail), Toast.LENGTH_SHORT).show();
            counter--;
            attempts.setText(getString(R.string.attempts) +  " " + counter);
            if (counter == 0){
                attempts.setTextColor(Color.RED);
                login_button.setEnabled(false);
            }
        }
    }
}
