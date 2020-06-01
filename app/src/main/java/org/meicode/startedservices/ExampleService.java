package org.meicode.startedservices;

import android.app.IntentService;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;

import androidx.annotation.Nullable;

public class ExampleService extends IntentService {
    private static final String TAG = "ExampleService";

    public ExampleService() {
        super("Download Thread");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if (null != intent) {
            int number = intent.getIntExtra("number", -1);
            for (int i=0; i<number; i++) {
                Log.d(TAG, "onHandleIntent: i Was: " + i);
                SystemClock.sleep(1000);
            }
        }
    }
}
