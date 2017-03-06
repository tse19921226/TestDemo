package com.example.tse_chen.demo1;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.tse_chen.demo1.Adapter.RecycleAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {
    private RecyclerView recyclerView;
    private RecycleAdapter adapter;
    private ArrayList<String> devices = new ArrayList<>();
    private Toolbar toolbar;
    private ImageView editDevice,goBack;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new RecycleAdapter(devices);
        recyclerView.setAdapter(adapter);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        editDevice = (ImageView) findViewById(R.id.edit_device);
        goBack = (ImageView) findViewById(R.id.goBack);
        editDevice.setVisibility(View.VISIBLE);
        setSupportActionBar(toolbar);


        dbHelper = new DBHelper(this);
        refresh();





        editDevice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("TAG","..........................");
                adapter.addItem("Test");
                dbHelper.create("0xff",  "FFFF:FFFF:FFFF", "F1", "F2");
                cl();
                refresh();
            }
        });

        adapter.setOnItemClickListener(new RecycleAdapter.OnRecycleViewItemClickListener() {
            @Override
            public void OnItemClick(View view, String device) {
                Toast.makeText(MainActivity.this,device,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,DeviceActivity.class);
                startActivity(intent);


            }
        });


    }
    public void cl(){
        adapter.clearAll();
    }

    public void refresh()
    {
        // clear main page;


        Cursor cursor  = dbHelper.getAll();
        int rows_num = cursor.getCount();

        if(rows_num != 0)
        {
            do
            {
                int RowID = cursor.getInt(0);
                String DeviceID = cursor.getString(1);
                String Address = cursor.getString(2);
                String Date = cursor.getString(3);
                String Data = cursor.getString(4);

                adapter.addItem(DeviceID + ": " + Address);
            }
            while(cursor.moveToNext());
        }

    }

}
