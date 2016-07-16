package com.ilink.pen.getmoney.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ilink.pen.getmoney.R;
import com.ilink.pen.getmoney.barcode.IntentIntegrator;
import com.ilink.pen.getmoney.barcode.IntentResult;

public class BarCodeActivity extends AppCompatActivity {
    private Button btnBarCodeScanner;
    private TextView tvBarCodeScannerResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_code);
        btnBarCodeScanner = (Button) findViewById(R.id.btnBarCodeScanner);
        tvBarCodeScannerResult = (TextView) findViewById(R.id.tvBarCodeScannerResult);

        btnBarCodeScanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator intentIntegrator = new IntentIntegrator(BarCodeActivity.this);
                intentIntegrator.initiateScan();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult scannerResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (scannerResult != null) {
            //显示扫描结果
            tvBarCodeScannerResult.setText(scannerResult.toString());
        } else {
            //扫描未知
            Toast.makeText(BarCodeActivity.this, "扫描失败", Toast.LENGTH_SHORT).show();
        }
    }
}
