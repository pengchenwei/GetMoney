package com.ilink.pen.getmoney.sharedData;
/**
 * 实现SharedPreferences存储数据
 * 1.获得SharedPreferences对象
 * 2.获得SharedPreferences.Editor对象
 * 3.通过putXXX()放入数据
 * 4.Editor的commit（）保存键值对
 */

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.ilink.pen.getmoney.R;

public class SharedPrefData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_shared_pref_data);
        //写入信息到data文件中
        /*SharedPreferences sharedPreferencesWriter = getSharedPreferences("share", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferencesWriter.edit();

        editor.putInt("API_version", 21);
        editor.putString("APP_name", "SharedDataDemo");
        editor.commit();*/
        //从data文件中读取相关信息
        SharedPreferences sharedPreferencesReader = getSharedPreferences("share", MODE_PRIVATE);
        String APP_name = sharedPreferencesReader.getString("APP_name", "null");
        int API_version = sharedPreferencesReader.getInt("API_version", 1);
        Toast.makeText(SharedPrefData.this, "获取信息：" + APP_name + API_version, Toast.LENGTH_LONG).show();
    }
}
