package com.ilink.pen.getmoney;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //建立对象：对应UI布局的控件类型
    private Button btnGetMoney;
    private TextView tvGetMoney;
    private int money = 0;
    private Button btnLoseMoney;
    private EditText etgoalMoney;
    private RadioGroup rgSurvey;

    private CheckBox cbNo1;
    private CheckBox cbNo2;
    private CheckBox cbNo3;

    private Button btnSwitch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//绑定：从布局(layout)xml文件中获得控件，对应UI布局控件的id
        btnGetMoney = (Button) findViewById(R.id.btnGetMoney);
        tvGetMoney = (TextView) findViewById(R.id.tvGetMoney);
        btnLoseMoney = (Button) findViewById(R.id.btnLoseMoney);
        etgoalMoney = (EditText) findViewById(R.id.etGoalMoney);

        rgSurvey = (RadioGroup) findViewById(R.id.rgSurvey);
        cbNo1 = (CheckBox) findViewById(R.id.cbNo1);
        cbNo2 = (CheckBox) findViewById(R.id.cbNo2);
        cbNo3 = (CheckBox) findViewById(R.id.cbNo3);

//绑定一个btn监听器用来监听btnGetMoney的点击事件

        btnGetMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String goalMoneyStr = etgoalMoney.getText().toString().trim();
                if (goalMoneyStr.equals("") || goalMoneyStr.isEmpty()) {
                    Toast.makeText(MainActivity.this, "请填写期望数值", Toast.LENGTH_SHORT).show();
                } else {
                    int goalMoney = Integer.parseInt(goalMoneyStr);
                    //具体操作，点击btnGetMoney按钮后的逻辑卸载onClick方法中
                    if (goalMoney == money) {
                        Toast.makeText(MainActivity.this, "达成目标！", Toast.LENGTH_SHORT).show();

                    } else {
                        money++;
                        //将文本信息显示在TextView控件中
                        tvGetMoney.setText("点击赚了" + money + "块钱");
                    }
                }

            }
        });

        btnLoseMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (money == 0) {
                    //提示信息
                    Toast.makeText(MainActivity.this, "已经没钱了，不要再点了", Toast.LENGTH_SHORT).show();
                } else {
                    money--;
                    tvGetMoney.setText("点击赚了" + money + "块钱");
                }
            }
        });

        rgSurvey.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rbNo1:
                        Toast.makeText(MainActivity.this, "You've been chose RadioButtonNo1", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbNo2:
                        Toast.makeText(MainActivity.this, "You've been chose RadioButtonNo2", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbNo3:
                        Toast.makeText(MainActivity.this, "You've been chose RadioButtonNo3", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        cbNo1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity.this, "You've been chose CheckBoxNo1", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "You've been canceled your choose", Toast.LENGTH_SHORT).show();
                }
            }
        });
        cbNo2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity.this, "You've been chose CheckBoxNo2", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "You've been canceled your choose", Toast.LENGTH_SHORT).show();
                }
            }
        });
        cbNo3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity.this, "You've been chose CheckBoxNo3", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "You've been canceled your choose", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,SecondActivity.class);
            }
        });
    }
}
