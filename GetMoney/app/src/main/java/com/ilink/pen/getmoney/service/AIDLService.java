package com.ilink.pen.getmoney.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import com.ilink.pen.getmoney.IMyAidlInterface;

/**
 * Created by pen on 2016/7/19.
 */
public class AIDLService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return new MyServiceIml();
    }
    public class MyServiceIml extends IMyAidlInterface.Stub{

        @Override
        public String getValue() throws RemoteException {
            return "I am from Remote Service";
        }
    }
}
