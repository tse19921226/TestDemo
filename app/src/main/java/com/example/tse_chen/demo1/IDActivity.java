package com.example.tse_chen.demo1;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class IDActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView save,goBack;
    private EditText newID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_id);
        goBack = (ImageView) findViewById(R.id.goBack);
        save = (ImageView) findViewById(R.id.save);
        goBack.setVisibility(View.VISIBLE);
        save.setVisibility(View.VISIBLE);
        goBack.setOnClickListener(this);
        save.setOnClickListener(this);

        newID = (EditText) findViewById(R.id.editNewID);
        newID.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){
                    newID.setInputType(InputType.TYPE_NULL);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.goBack:
                Intent intent = new Intent();
                intent.setClass(IDActivity.this,DeviceActivity.class);
                startActivity(intent);

                finish();
                break;
            case R.id.save:
                intent = new Intent();
                intent.setClass(IDActivity.this,DeviceActivity.class);
                startActivity(intent);

                finish();
        }
    }
}
