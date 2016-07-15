package com.ilink.pen.getmoney.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ilink.pen.getmoney.R;

/**
 * Created by pen on 2016/7/14.
 */
public class IndexActivity extends AppCompatActivity {
    private Button btnToMain, btnToSecond,btnToSome,btnToActivityLifeCycle,
            btnToCapture,btnToBrodcastSender,btnToDynamicRegisterBrodcast;
    private BtnListener btnListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //将本类与一个布局(layout)绑定,这样就可以通过id来获取该布局中的控件
        setContentView(R.layout.activity_index);

        btnListener = new BtnListener();// 实例化监听器
        FindView();
        SetClickListener();
    }
    // 通过id获得View
    private void FindView() {
        btnToMain = (Button) findViewById(R.id.btnToMain);
        btnToSecond = (Button) findViewById(R.id.btnToSecond);
        btnToSome = (Button) findViewById(R.id.btnToSome);

        btnToActivityLifeCycle = (Button) findViewById(R.id.btnToActivityLifeCycle);

        btnToCapture = (Button) findViewById(R.id.btnToCapture);

        btnToBrodcastSender = (Button) findViewById(R.id.btnToBrodcastSender);
        btnToDynamicRegisterBrodcast = (Button) findViewById(R.id.btnToDynamicRegisterBrodcast);
    }
    // 绑定监听器
    private void SetClickListener() {
        btnToMain.setOnClickListener(btnListener);
        btnToSecond.setOnClickListener(btnListener);
        btnToSome.setOnClickListener(btnListener);

        btnToActivityLifeCycle.setOnClickListener(btnListener);

        btnToCapture.setOnClickListener(btnListener);
        btnToBrodcastSender.setOnClickListener(btnListener);
        btnToDynamicRegisterBrodcast.setOnClickListener(btnListener);

    }
// 内部类来简化btnListener，将FindView中得到的view传入，用switch/case来判断onClick事件
    private class BtnListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnToMain:
                    Intent i1 = new Intent(IndexActivity.this, MainActivity.class);
                    startActivity(i1);
                    break;
                case R.id.btnToSecond:
                    Intent i2 = new Intent(IndexActivity.this, SecondActivity.class);
                    startActivity(i2);
                    break;
                case R.id.btnToActivityLifeCycle:
                    Intent i3 = new Intent(IndexActivity.this, ActivityLifeCycle.class);
                    startActivity(i3);
                    break;
                case R.id.btnToCapture:
                    Intent i4 = new Intent(IndexActivity.this, CaptureActivity.class);
                    startActivity(i4);
                    break;
                case R.id.btnToBrodcastSender:
                    Intent i5 = new Intent(IndexActivity.this, BrodcastSenderActivity.class);
                    startActivity(i5);
                    break;
                case R.id.btnToDynamicRegisterBrodcast:
                    Intent i6 = new Intent(IndexActivity.this, DynamicRegisterBrodcastReceiver.class);
                    startActivity(i6);
                    break;
                case R.id.btnToSome:
                    Toast.makeText(IndexActivity.this, "Coming Soon", Toast.LENGTH_SHORT).show();
                    break;


            }
        }
    }
}
