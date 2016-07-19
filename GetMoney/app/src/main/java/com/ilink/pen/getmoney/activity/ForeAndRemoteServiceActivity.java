package com.ilink.pen.getmoney.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ilink.pen.getmoney.IMyAidlInterface;
import com.ilink.pen.getmoney.R;
import com.ilink.pen.getmoney.service.AIDLService;
import com.ilink.pen.getmoney.service.StartService;

public class ForeAndRemoteServiceActivity extends AppCompatActivity implements View.OnClickListener {
    //跨进程通信

    private Button btnBindAIDLService, btnUnbindAIDLService, btnInvokeAIDLService;
    private TextView tvIPC;
    private boolean isBind = false;
    private IMyAidlInterface myAidlInterface = null;

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myAidlInterface = IMyAidlInterface.Stub.asInterface(service);
            btnInvokeAIDLService.setEnabled(true);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    //前台服务
    private Button btnStartForeService, btnStopForeService;
    private boolean isBindFore = false;

    private StartService myService = null;

    private ServiceConnection foreServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myService = ((StartService.ForeBinder) service).getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //跨进程通信
        setContentView(R.layout.activity_remote_service);

        tvIPC = (TextView) findViewById(R.id.tvIPC);

        btnBindAIDLService = (Button) findViewById(R.id.btnBindAIDLService);
        btnBindAIDLService.setOnClickListener(this);
        btnUnbindAIDLService = (Button) findViewById(R.id.btnUnbindAIDLService);
        btnUnbindAIDLService.setOnClickListener(this);
        btnInvokeAIDLService = (Button) findViewById(R.id.btnInvokeAIDLService);
        btnInvokeAIDLService.setOnClickListener(this);

        //前台服务
        btnStartForeService = (Button) findViewById(R.id.btnStartForeService);
        btnStartForeService.setOnClickListener(this);
        btnStopForeService = (Button) findViewById(R.id.btnStopForeService);
        btnStopForeService.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //跨进程通信
            case R.id.btnBindAIDLService:
                Intent aidlIntent = new Intent(this, AIDLService.class);
                isBind = bindService(aidlIntent, serviceConnection, BIND_AUTO_CREATE);
                btnInvokeAIDLService.setEnabled(true);
                Toast.makeText(this, "AIDL绑定成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnInvokeAIDLService:
                try {
                    String aidlStr = myAidlInterface.getValue();
                    tvIPC.setText(aidlStr);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btnUnbindAIDLService:
                if (isBind) {
                    unbindService(serviceConnection);
                    myAidlInterface = null;
                    btnInvokeAIDLService.setEnabled(false);
                    isBind = false;
                    tvIPC.setText("");
                }
                break;
            //前台服务
            case R.id.btnStartForeService:
                Intent intent = new Intent(this, StartService.class);
                isBindFore = bindService(intent, foreServiceConnection, BIND_AUTO_CREATE);
                Toast.makeText(ForeAndRemoteServiceActivity.this, "通知栏消息出现", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnStopForeService:
                if (isBindFore) {
                    unbindService(foreServiceConnection);
                    isBindFore = false;
                }
                break;
        }


    }

}
