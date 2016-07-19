package com.ilink.pen.getmoney.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import com.ilink.pen.getmoney.R;

/**
 * Created by pen on 2016/7/18.
 * 一定要注意到Manifest.xml文件中去注册服务组件
 */
public class StartService extends Service {

    private String TAG = "StartService";
    private NotificationManager notificationManager;//通知栏管理器
    private int NOTIFY_NUM = 100;

    @Override
    public void onCreate() {
        super.onCreate();
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification.Builder nb = new Notification.Builder(this);
        nb.setContentTitle("title");
        nb.setContentText("来自服务的text");
        nb.setSmallIcon(R.mipmap.ic_launcher);
        notificationManager.notify(NOTIFY_NUM, nb.getNotification());
        Log.i(TAG, "StartService-->onCreate");//调试窗口打印日志观察

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "StartService-->onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        notificationManager.cancelAll();
        Log.e(TAG, "StartService-->onDestroy");
    }

    @Override
    public IBinder onBind(Intent intent) {
        //服务真正需要执行的内容
        return new ForeBinder();
    }

    public class ForeBinder extends Binder {
        public StartService getService() {
            return StartService.this;
        }
    }
}
