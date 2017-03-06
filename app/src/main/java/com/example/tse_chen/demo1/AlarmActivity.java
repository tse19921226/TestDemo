package com.example.tse_chen.demo1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.NumberPicker;

public class AlarmActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView goBack,Save;
    private NumberPicker hiPicker,loPicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        goBack = (ImageView) findViewById(R.id.goBack);
        Save = (ImageView) findViewById(R.id.save);
        goBack.setVisibility(View.VISIBLE);
        Save.setVisibility(View.VISIBLE);
        goBack.setOnClickListener(this);
        Save.setOnClickListener(this);
        hiPicker = (NumberPicker) findViewById(R.id.HighPicker);
        loPicker = (NumberPicker) findViewById(R.id.LowPicker);
        hiPicker.setMaxValue(100);
        hiPicker.setMinValue(0);
        loPicker.setMaxValue(100);
        loPicker.setMinValue(0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.goBack:
                Intent intent = new Intent();
                intent.setClass(AlarmActivity.this,DeviceActivity.class);
                startActivity(intent);

                finish();
                break;
            case R.id.save:
                intent = new Intent();
                intent.setClass(AlarmActivity.this,DeviceActivity.class);
                startActivity(intent);

                finish();
                break;
        }
    }
}
