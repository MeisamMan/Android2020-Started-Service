package org.meicode.startedservices;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, SecondSampleService.class);
        intent.putExtra("number", 5);
        startService(intent);
        startService(intent);
        stopService(intent);
    }
}
