package com.ilink.pen.getmoney.brodcast;


import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * Created by pen on 2016/7/15.
 */
public class MyBrodcastReceiver extends BroadcastReceiver {
    private final static String CALLACTION = Intent.ACTION_NEW_OUTGOING_CALL;

    @Override
    public void onReceive(Context context, Intent intent) {
//        String receivedMsg = intent.getExtras().getString("brodcastMsg");
//        Toast.makeText(context, "收到广播消息："+receivedMsg, Toast.LENGTH_LONG).show();
        if (intent.getAction().equals(CALLACTION)) {
            //拨打电话
            String callOutNum = intent.getExtras().getString(intent.EXTRA_PHONE_NUMBER);
            Log.i("brodcast", "呼出电话号码：" + callOutNum);
        } else {
//接到来电
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Service.TELEPHONY_SERVICE);
            telephonyManager.listen(phoneStateListener, PhoneStateListener.LISTEN_CALL_STATE);
        }

    }

    PhoneStateListener phoneStateListener = new PhoneStateListener() {
        @Override
        public void onCallStateChanged(int state, String incomingNumber) {
            super.onCallStateChanged(state, incomingNumber);
            switch (state) {
//                case TelephonyManager.CALL_STATE_IDLE:
//                    Log.i("brodcast", "挂断");
//                    break;
//                case TelephonyManager.CALL_STATE_OFFHOOK:
//                    Log.i("brodcast", "接听");
//                    break;
                case TelephonyManager.CALL_STATE_RINGING:
                    Log.i("brodcast", "来电号码：" + incomingNumber);
                    break;
            }
        }
    };
}
