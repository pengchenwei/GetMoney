package com.ilink.pen.getmoney.newsDemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.ilink.pen.getmoney.R;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
       TextView textView = (TextView) findViewById(R.id.tvNewsDetail);
        textView.setText(getIntent().getStringExtra("detail"));

    }
}
