package com.ilink.pen.getmoney.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

    }
}
