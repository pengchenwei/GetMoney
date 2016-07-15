package com.ilink.pen.getmoney.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.ilink.pen.getmoney.R;

import java.util.Locale;

public class DynamicRegisterBrodcastReceiver extends AppCompatActivity {
    private TextView tvBatteryInfo;
    //定义电池Action常量
    private static final String BATTERY_ACTION = Intent.ACTION_BATTERY_CHANGED;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_register_brodcast_receiver);

        tvBatteryInfo = (TextView) findViewById(R.id.tvBatteryInfo);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //动态注册广播
        //IntentFilter:过滤器将广播中的电池信息（BATTERY_ACTION）过滤下来
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BATTERY_ACTION);
        //registerReceiver：广播接受者，过滤器
        registerReceiver(mBatteryBR, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //取消注册广播
        unregisterReceiver(mBatteryBR);
    }

    //BroadcastReceiver:要接收广播传回来的信息
    private BroadcastReceiver mBatteryBR = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            //处理Intent中传回的电池信息
            if (intent.getAction().equals(BATTERY_ACTION)) {
                int status = intent.getIntExtra("status", 0);
                int health = intent.getIntExtra("health", 1);
                boolean present = intent.getBooleanExtra("present", true);
                int level = intent.getIntExtra("level", 0);
                float scale = intent.getIntExtra("scale", 0);
                int plugged = intent.getIntExtra("plugged", 0);
                float voltage = intent.getIntExtra("voltage", 0);
                float temperature = intent.getIntExtra("temperature", 0);
                String technology = intent.getStringExtra("technology");

                String statusString = "未知状态";
                switch (status) {
                    case BatteryManager.BATTERY_STATUS_UNKNOWN:
                        statusString = "电池状态未知";
                        break;
                    case BatteryManager.BATTERY_STATUS_CHARGING:
                        statusString = "充电状态";
                        break;
                    case BatteryManager.BATTERY_STATUS_DISCHARGING:
                        statusString = "放电状态";
                        break;
                    case BatteryManager.BATTERY_STATUS_NOT_CHARGING:
                        statusString = "未充电";
                        break;
                    case BatteryManager.BATTERY_STATUS_FULL:
                        statusString = "充满电";
                        break;

                }

                String healthString = "未知状态";
                switch (health) {
                    case BatteryManager.BATTERY_HEALTH_UNKNOWN:
                        healthString = "状态未知";
                        break;
                    case BatteryManager.BATTERY_HEALTH_GOOD:
                        healthString = "状态好";
                        break;
                    case BatteryManager.BATTERY_HEALTH_OVERHEAT:
                        healthString = "电池过热";
                        break;
                    case BatteryManager.BATTERY_HEALTH_DEAD:
                        healthString = "电池没有电";
                        break;
                    case BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE:
                        healthString = "电池电压过高";
                        break;
                    case BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE:
                        healthString = "未知错误";
                        break;
                }
                String acString = "未知状态";
                switch (health) {
                    case BatteryManager.BATTERY_PLUGGED_AC:
                        acString = "直流充电";
                        break;
                    case BatteryManager.BATTERY_PLUGGED_USB:
                        acString = "USB充电";
                        break;
                }
                String setBInfo = "电池状态：" +
                        "\n是否使用电池：" + String.valueOf(present) +
                        "\n电池状态：" + statusString +
                        "\n电量：" + String.format(Locale.CHINA,"%d", level) + "%" +
                        "\n健康：" + healthString +
                        "\n最大值：" + String.format(Locale.CHINA,"%f", scale) +
                        "\n充电方式：" + acString +
                        "\n电压：" + String.format(Locale.CHINA,"%g", voltage) +
                        "\n温度：" + String.format(Locale.CHINA,"%g", temperature) +
                        "\n接通电源：" + String.format(Locale.CHINA,"%d", plugged) +
                        "\n电池类型：" + technology;
                tvBatteryInfo.setText(setBInfo);
            }
        }
    };
}
