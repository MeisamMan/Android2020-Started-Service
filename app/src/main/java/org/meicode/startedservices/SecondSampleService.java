package org.meicode.startedservices;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;

import androidx.annotation.Nullable;

public class SecondSampleService extends Service {
    private static final String TAG = "SecondSampleService";

    private int startId = -1;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        this.startId = startId;
        if (null != intent) {
            final int number = intent.getIntExtra("number", -1);
            if (number != -1) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i=0; i<number; i++) {
                            Log.d(TAG, "run: i was: " + i);
                            SystemClock.sleep(1000);
                        }
                    }
                });

                thread.start();
            }
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopSelf(startId);
    }
}
