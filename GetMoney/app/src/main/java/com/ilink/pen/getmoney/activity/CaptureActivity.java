package com.ilink.pen.getmoney.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.ilink.pen.getmoney.R;

public class CaptureActivity extends AppCompatActivity {
    private Button btnTakePic;
    private ImageView ivShowPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capture);

        btnTakePic = (Button) findViewById(R.id.btnTakePic);
        ivShowPic = (ImageView) findViewById(R.id.ivShowPic);

        btnTakePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent imgIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);  //调用摄像头
                //startActivityForResult开始一个intent，得到返回的结果，
                // requestCode设定一个请求识别码，以备下面操作识别是那个intent操作
                startActivityForResult(imgIntent,88);
            }
        });
    }

    /**
     *
     * @param requestCode 请求识别码
     * @param resultCode    结果识别码
     * @param data  请求结果
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==88){//判断是否是是上面的拍照请求
            if(resultCode==RESULT_OK){//判断请求的操作结果是否成功
                //如果成功则显示照片
                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                ivShowPic.setImageBitmap(bitmap);
            }else { //如果不成功则提示信息
                Toast.makeText(CaptureActivity.this, "拍照失败", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
