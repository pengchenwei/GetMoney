package com.ilink.pen.getmoney.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ilink.pen.getmoney.R;

public class BrodcastSenderActivity extends AppCompatActivity {
    private Button btnBrodcastSender;
    private EditText etBrodcastSender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brodcast_sender);

        btnBrodcastSender = (Button) findViewById(R.id.btnBrodcastSender);
        etBrodcastSender = (EditText) findViewById(R.id.etBrodcastSender);

        btnBrodcastSender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //发送广播
                String brodcastStr = etBrodcastSender.getText().toString();
                //设置intent的Action的name，与Manifest中intent-filter-->action设置的一致
                Intent bcIntent = new Intent().setAction("com.iLink.NOTIFY");
                bcIntent.putExtra("brodcastMsg", brodcastStr);
                sendBroadcast(bcIntent);
            }
        });

    }
}
