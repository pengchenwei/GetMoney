package com.ilink.pen.getmoney.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.ilink.pen.getmoney.R;

public class DataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        Intent intent = getIntent();//接收传过来的intent，getStringExtra并从中取数据
        String msgData = intent.getStringExtra("msgData");
        Toast.makeText(DataActivity.this, "传过来的消息："+msgData, Toast.LENGTH_LONG).show();
    }
}
