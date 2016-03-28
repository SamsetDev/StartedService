package com.samset.startedservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.samset.startedservice.intentservice.MyIntentService;
import com.samset.startedservice.simpleservice.MyService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    // Start the service
    public void startService(View view) {

        startService(new Intent(this, MyService.class));
    }

    // Stop the service
    public void stopService(View view) {
        stopService(new Intent(this, MyService.class));
    }

    public void intentservice()
    {
        EditText sleepTime=(EditText)findViewById(R.id.et);

        Long secondsToSleep=Long.parseLong(sleepTime.getText().toString());

        Intent intent= new Intent(MainActivity.this,MyIntentService.class);

        intent.putExtra("seconds", secondsToSleep);

        startService(intent);
    }

}
