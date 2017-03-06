package com.example.tse_chen.demo1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.example.tse_chen.demo1.Adapter.RecycleDeviceAdapter;

import java.util.ArrayList;

public class DeviceActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recyclerDevice;
    private ImageView editDevice,goBack;
    private RecycleDeviceAdapter deviceAdapter;
    private ArrayList<String> deviceSetting = new ArrayList<>();
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device);
        recyclerDevice = (RecyclerView) findViewById(R.id.recycleDevice);
        editDevice = (ImageView) findViewById(R.id.edit_device);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        goBack = (ImageView) findViewById(R.id.goBack);
        goBack.setVisibility(View.VISIBLE);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerDevice.setLayoutManager(layoutManager);
        recyclerDevice.setHasFixedSize(true);
        deviceAdapter = new RecycleDeviceAdapter(deviceSetting);
        recyclerDevice.setAdapter(deviceAdapter);

        deviceSetting.add("ID");
        deviceSetting.add("Interval");
        deviceSetting.add("Hi/Lo Alarm");
        deviceSetting.add("Data Download");
        deviceSetting.add("Data Files");
        deviceSetting.add("Stats");

        goBack.setOnClickListener(this);


        deviceAdapter.setOnItemClickListener(new RecycleDeviceAdapter.OnRecycleViewItemClickListener() {
            @Override
            public void OnItemClick(View view) {
                switch (recyclerDevice.getChildViewHolder(view).getAdapterPosition()){
                    case 0:
                        Intent intent = new Intent();
                        intent.setClass(DeviceActivity.this,IDActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                    case 1:
                        intent = new Intent();
                        intent.setClass(DeviceActivity.this,IntervalActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                    case 2:
                        intent = new Intent();
                        intent.setClass(DeviceActivity.this,AlarmActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                    case 3:
                        intent = new Intent();
                        intent.setClass(DeviceActivity.this,DownloadActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                    case 4:
                        intent = new Intent();
                        intent.setClass(DeviceActivity.this,DataActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                    case 5:
                        break;
                }

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.goBack:
                finish();
                break;
        }
    }
}
