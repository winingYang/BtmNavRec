package com.surkaa.btmnavrec;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyChronometer chronometer = findViewById(R.id.myChronometer);
        getLifecycle().addObserver(chronometer);
        findViewById(R.id.btn_btm_nav).setOnClickListener(view ->
                startActivity(new Intent(MainActivity.this, BtmNav.class)));
    }

}