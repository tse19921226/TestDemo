package com.example.tse_chen.demo1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class IntervalActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView goBack,Save;
    private SeekBar minSlide;
    private TextView txtSlideMin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interval);
        goBack = (ImageView) findViewById(R.id.goBack);
        Save = (ImageView) findViewById(R.id.save);
        goBack.setVisibility(View.VISIBLE);
        Save.setVisibility(View.VISIBLE);
        goBack.setOnClickListener(this);
        Save.setOnClickListener(this);

        minSlide = (SeekBar) findViewById(R.id.SlideMin);
        txtSlideMin = (TextView) findViewById(R.id.TextSlideMin);

        minSlide.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                if (progress<10){
                    txtSlideMin.setText("0"+String.valueOf(progress)+"  min");
                }else {
                    txtSlideMin.setText(String.valueOf(progress)+"  min");
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.goBack:
                Intent intent = new Intent();
                intent.setClass(IntervalActivity.this,DeviceActivity.class);
                startActivity(intent);

                finish();
                break;
            case R.id.save:
                intent = new Intent();
                intent.setClass(IntervalActivity.this,DeviceActivity.class);
                startActivity(intent);

                finish();
                break;
        }
    }
}
