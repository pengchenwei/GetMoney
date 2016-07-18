package com.ilink.pen.getmoney.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ilink.pen.getmoney.R;
import com.ilink.pen.getmoney.service.BindService;
import com.ilink.pen.getmoney.service.StartService;

public class StartServiceActivity extends AppCompatActivity {
    private BindService.MyBinder mybander;
    boolean isBind = false;
    private ServiceConnection serviceConnection = new ServiceConnection() {
        //service连接后会调用onServiceConnected
        @Override
        //通过IBinder与service进行通信
        public void onServiceConnected(ComponentName name, IBinder service) {
            mybander = (BindService.MyBinder) service;
            mybander.startDownload();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_service);
//启动服务
        this.findViewById(R.id.btnStartService).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startSerIntent = new Intent(StartServiceActivity.this, StartService.class);
                startService(startSerIntent);
            }
        });
//停止服务
        this.findViewById(R.id.btnStopService).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent stopIntent = new Intent(StartServiceActivity.this, StartService.class);
                stopService(stopIntent);
            }
        });
//绑定服务
        this.findViewById(R.id.btnBindService).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bindIntent = new Intent(StartServiceActivity.this, BindService.class);
                //绑定上面创建的serviceConnection，BIND_AUTO_CREATE（创建后自动执行）
                isBind = bindService(bindIntent, serviceConnection, BIND_AUTO_CREATE);//绑定成功返回一个true
            }
        });
//解绑服务
        this.findViewById(R.id.btnUnbindService).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBind) {//没有绑定就不能执行解绑操作
                    unbindService(serviceConnection);
                    isBind = false;
                }
            }
        });
    }

}
