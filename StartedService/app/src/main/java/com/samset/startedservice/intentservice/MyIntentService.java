package com.samset.startedservice.intentservice;

import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.os.SystemClock;
import android.text.format.DateFormat;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by samset on 28/03/16.
 */
public class MyIntentService extends IntentService {

    public long seconds;

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public MyIntentService(String name) {
        super(name);
    }

    public MyIntentService() {
        super("MyIntentService");
    }
    @Override
    protected void onHandleIntent(Intent intent) {

        seconds =intent.getExtras().getLong("seconds");
        long millis = seconds * 1000;
        try
        {
            Thread.sleep(millis);
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public void onDestroy()
    {
        super.onDestroy();
        Toast.makeText(this, String.format("Slept %d seconds", seconds), Toast.LENGTH_SHORT).show();
    }
}
