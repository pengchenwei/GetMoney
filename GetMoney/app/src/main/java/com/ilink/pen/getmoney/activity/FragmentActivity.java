package com.ilink.pen.getmoney.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.ilink.pen.getmoney.R;

public class FragmentActivity extends AppCompatActivity {
    public FragmentActivity() {
        super();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("FragmentActivity", "onStop被执行了");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("FragmentActivity", "onDestroy被执行了");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("FragmentActivity", "onPause被执行了");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("FragmentActivity", "onResume被执行了");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("FragmentActivity", "onStart被执行了");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("FragmentActivity", "onRestart被执行了");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("FragmentActivity", "onCreate被执行了");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        Button btnChangeRightFragment = (Button) findViewById(R.id.btnChangeRightFragment);
        if (btnChangeRightFragment != null) {
            btnChangeRightFragment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AnotherRightFragment anotherRightFragment = new AnotherRightFragment();
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.flRight, anotherRightFragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
            });
        }

    }
}
