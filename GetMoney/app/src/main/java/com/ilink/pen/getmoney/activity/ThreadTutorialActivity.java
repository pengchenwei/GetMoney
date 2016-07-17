package com.ilink.pen.getmoney.activity;
/*启动线程的几种方法：
* 方法一：new Thread(new Runnable{
*   @Override
*   public void run(){...}
* });
*
* 方法二：新建一个class 继承Thread类，实现Thread中的run方法
*
* 方式三：在本类中实现Runnable接口，实现Runnable中的run方法，直接调用本类实例
* */
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ilink.pen.getmoney.R;

public class ThreadTutorialActivity extends AppCompatActivity implements Runnable {
    private Button btnStartMainThread, btnStartThread01, btnStartThread02, btnStartThread03;
    private ProgressDialog progressDialog;

    private static final int STOP = 1;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == STOP) {
                progressDialog.dismiss();//关闭进度对话框
                Toast.makeText(ThreadTutorialActivity.this, "加载完成", Toast.LENGTH_SHORT).show();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_tutorial);

        btnStartMainThread = (Button) findViewById(R.id.btnStartMainThread);
        btnStartThread01 = (Button) findViewById(R.id.btnStartThread01);
        btnStartThread02 = (Button) findViewById(R.id.btnStartThread02);
        btnStartThread03 = (Button) findViewById(R.id.btnStartThread03);

        BtnListener btnListener = new BtnListener();
        btnStartMainThread.setOnClickListener(btnListener);
        btnStartThread01.setOnClickListener(btnListener);
        btnStartThread02.setOnClickListener(btnListener);
        btnStartThread03.setOnClickListener(btnListener);


    }

    private class BtnListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                //主线程阻塞
                case R.id.btnStartMainThread:
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                //方式一：启动子线程
                case R.id.btnStartThread01:
                    //进度对话框
                    progressDialog = ProgressDialog.show(ThreadTutorialActivity.this, "提示", "线程01正在执行耗时操作", true, false);
                    LoadThread loadThread = new LoadThread();
                    loadThread.start();
                    break;
                //方式二：启动子线程
                case R.id.btnStartThread02:
                    progressDialog = ProgressDialog.show(ThreadTutorialActivity.this, "提示", "线程02正在执行耗时操作", true, false);
                    Thread thread02 = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(6000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            //通知handler处理
                            Message msg = new Message();
                            msg.what = STOP;
                            handler.sendMessage(msg);
                        }
                    });
                    thread02.start();
                    break;
                //方式三：启动子线程
                case R.id.btnStartThread03:
                    progressDialog = ProgressDialog.show(ThreadTutorialActivity.this, "提示", "线程03正在执行耗时操作", true, false);
                    new Thread(ThreadTutorialActivity.this).start();
                    break;

            }
        }

        //方式一启动线程
        private class LoadThread extends Thread {
            @Override
            public void run() {
                try {
                    Thread.sleep(6000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //通知handler处理
                Message msg = new Message();
                msg.what = STOP;
                handler.sendMessage(msg);
            }
        }
    }

    //方式三启动线程
    @Override
    public void run() {
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //通知handler处理
        Message msg = new Message();
        msg.what = STOP;
        handler.sendMessage(msg);
    }
}
