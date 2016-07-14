package com.ilink.pen.getmoney.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.ilink.pen.getmoney.R;


/**
 * Created by pen on 2016/7/13.
 */
public class SecondActivity extends Activity {
    private RatingBar rtbStar;
    private SeekBar skbDrag;
    private TextView tvDragResult;

    private ProgressBar pbWaiting;
    private ImageButton ibWaiting;

    private DatePicker dpPicker;
    private TimePicker tpPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        rtbStar = (RatingBar) findViewById(R.id.rtbStar);
        skbDrag = (SeekBar) findViewById(R.id.skbDrag);
        tvDragResult = (TextView) findViewById(R.id.tvDragResult);
        pbWaiting = (ProgressBar) findViewById(R.id.pbWaiting);
        ibWaiting = (ImageButton) findViewById(R.id.ibWaiting);
        dpPicker = (DatePicker) findViewById(R.id.dpPicker);
        tpPicker = (TimePicker) findViewById(R.id.tpPicker);

        //星级评价和拖动评价
        rtbStar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(SecondActivity.this, "你的星级评分是"+rating+"分", Toast.LENGTH_SHORT).show();
            }
        });
        skbDrag.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvDragResult.setText("你的拖动评分是："+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        //等待图标
        ibWaiting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pbWaiting.setVisibility(View.VISIBLE);
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
                thread.start();
            }
        });
        //日期时间选择器
        dpPicker.setCalendarViewShown(false);
        dpPicker.init(2016, 7, 15, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Toast.makeText(SecondActivity.this, "你当前选择的日期是"+year+"年"+(monthOfYear+1)+
                        "月"+dayOfMonth+"日", Toast.LENGTH_SHORT).show();
            }
        });
        tpPicker.setIs24HourView(true);
        tpPicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                Toast.makeText(SecondActivity.this, "你选择的时间是"+hourOfDay+"点"+minute+"分", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
