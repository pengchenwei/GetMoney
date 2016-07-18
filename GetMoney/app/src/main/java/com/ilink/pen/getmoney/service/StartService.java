package com.ilink.pen.getmoney.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by pen on 2016/7/18.
 * 一定要注意到Manifest.xml文件中去注册服务组件
 */
public class StartService extends Service {

    private String TAG="StartService";
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG,"StartService-->onCreate");//调试窗口打印日志观察

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG,"StartService-->onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG,"StartService-->onDestroy");
    }

    @Override
    public IBinder onBind(Intent intent) {
        //服务真正需要执行的内容
        return null;
    }
}
