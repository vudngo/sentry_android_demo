package com.example.vu.sentry_android_demo;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import io.sentry.Sentry;
import io.sentry.android.AndroidSentryClientFactory;
import android.content.Context;



public class MainActivity extends AppCompatActivity {

    TextView total;
    EditText numerator;
    EditText denominator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Context ctx = this.getApplicationContext();
        // Use the Sentry DSN (client key) from the Project Settings page on Sentry
        String sentryDsn = "https://80b8a795d2a14cf796acaae4fa6cab30:762e19f86e23471586cc4dd3b1ee15fb@sentry.io/261820";
        Sentry.init(sentryDsn, new AndroidSentryClientFactory(ctx));

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        total = (TextView) findViewById(R.id.total);
        numerator = (EditText) findViewById(R.id.multiplier);
        //denominator = (EditText) findViewById(R.id.denominator);

        Button submit_button = (Button)findViewById(R.id.submit_button);

        // submit_button.setOnClickListener(button2OnClickListener);
        submit_button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view){
                int n = Integer.parseInt(numerator.getText().toString());
                int t = n / 0 ;
                total.setText(Integer.toString(t));

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
}
