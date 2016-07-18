package com.ilink.pen.getmoney.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ilink.pen.getmoney.R;
import com.ilink.pen.getmoney.service.StartService;

public class StartServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_service);

        this.findViewById(R.id.btnStartService).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startSerIntent = new Intent(StartServiceActivity.this, StartService.class);
                startService(startSerIntent);
            }
        });

        this.findViewById(R.id.btnStopService).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent stopIntent= new Intent(StartServiceActivity.this, StartService.class);
                stopService(stopIntent);
            }
        });
    }

}
