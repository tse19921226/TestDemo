package com.example.tse_chen.demo1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

public class DataActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView goBack,DataImage;
    private RecyclerView DataRecycleView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        goBack = (ImageView) findViewById(R.id.goBack);
        goBack.setVisibility(View.VISIBLE);
        goBack.setOnClickListener(this);

        DataImage = (ImageView) findViewById(R.id.data_image);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.goBack:
                Intent intent = new Intent();
                intent.setClass(DataActivity.this, DeviceActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}
