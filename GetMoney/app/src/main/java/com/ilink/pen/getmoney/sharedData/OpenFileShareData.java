package com.ilink.pen.getmoney.sharedData;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ilink.pen.getmoney.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class OpenFileShareData extends AppCompatActivity implements View.OnClickListener {
    private Button btnSaveInfoData, btnLoadInfoData;
    private TextView tvShowInfoData;
    private EditText etInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_file_share_data);
        btnLoadInfoData = (Button) findViewById(R.id.btnLoadInfoData);
        btnSaveInfoData = (Button) findViewById(R.id.btnSaveInfoData);
        tvShowInfoData = (TextView) findViewById(R.id.tvShowInfoData);
        etInfo = (EditText) findViewById(R.id.etInfo);

        btnSaveInfoData.setOnClickListener(this);
        btnLoadInfoData.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSaveInfoData:
                //保存数据到文件
                String str = etInfo.getText().toString().trim();
                BufferedWriter bw = null;
                try {
                    //数据写出到哪里:FileOutputStream
                    FileOutputStream fos = openFileOutput("data", MODE_PRIVATE);
                    //数据以何种方式写入：bufferedWriter，outputStreamWriter
                    bw = new BufferedWriter(new OutputStreamWriter(fos));
                    //写什么数据：str
                    bw.write(str);
                    Toast.makeText(OpenFileShareData.this, "数据写入成功", Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if(bw!=null){
                        try {
                            bw.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                break;
            case R.id.btnLoadInfoData:
                //从文件读取数据
                BufferedReader br = null;
                StringBuffer stringBuffer = new StringBuffer();
                try {
                    FileInputStream fis= openFileInput("data");
                    br = new BufferedReader(new InputStreamReader(fis));
                    String line = "";
                    while((line=br.readLine())!=null){
                        stringBuffer.append(line);
                    }
                    tvShowInfoData.setText(stringBuffer.toString());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if (br != null) {
                        try {
                            br.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                break;
        }
    }
}
