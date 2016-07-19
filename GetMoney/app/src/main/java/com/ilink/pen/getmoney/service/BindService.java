package com.ilink.pen.getmoney.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import com.ilink.pen.getmoney.R;

/**
 * Created by pen on 2016/7/18.
 */
public class BindService extends Service {
    private String TAG = "BindService";

    MyBinder myBinder = new MyBinder();

    @Override
    public void onCreate() {
        Log.i(TAG, "BindService-->onCreate");//调试窗口打印日志观察
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "BindService-->onStartCommand");//只有startService才会调用
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "BindService-->onDestroy");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG, "BindService-->onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "BindService-->onBind");
        return myBinder;
    }

    public class MyBinder extends Binder {
        public void startDownload() {
            Log.i(TAG, "开始进行下载操作。。。");
        }
    }
}
