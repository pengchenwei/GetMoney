package com.ilink.pen.getmoney.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ilink.pen.getmoney.R;

/**
 * Created by pen on 2016/7/14.
 */
public class ActivityLifeCycle extends AppCompatActivity {
    private int count = 0;
    private Button btnMsg;
    private EditText etMsg;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_life_cycle);

        if (savedInstanceState != null) {
            count = savedInstanceState.getInt("count");
            Toast.makeText(this, "count值"+count, Toast.LENGTH_SHORT).show();
        }

        btnMsg = (Button) findViewById(R.id.btnMsg);
        etMsg = (EditText) findViewById(R.id.etMsg);

        btnMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //每一个控件的每一个属性对应一个get操作，可以获得属性值
                String msgStr= etMsg.getText().toString().trim();
                //putExtra将信息以键值对的形式放入Intent中
                // setClass表明要从哪个类传到哪个类中
                Intent intent = new Intent();//intent将被传到指定的.class中
                intent.putExtra("msgData",msgStr);
                intent.setClass(ActivityLifeCycle.this,DataActivity.class);
                startActivity(intent);//最后不要忘了启动Activity
            }
        });

        Log.i("ActivityLifeCycle", "onCreate被执行了");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("ActivityLifeCycle", "onStop被执行了");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.w("ActivityLifeCycle", "onDestroy被执行了");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.wtf("ActivityLifeCycle", "onPause被执行了");
    }

    @Override
    protected void onResume() {
        super.onResume();
        count++;
        Log.e("ActivityLifeCycle", "onResume被执行了");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ActivityLifeCycle", "onStart被执行了");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.w("ActivityLifeCycle", "onRestart被执行了");
    }

    /**
     * 用bundle来存储数据
     * @param outState  在Activity销毁之后还能存储数据
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count", count);//采用键值对的形式存储数据
    }
}
