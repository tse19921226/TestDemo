package com.example.tse_chen.demo1.Adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tse_chen.demo1.R;

import java.util.ArrayList;

/**
 * Created by Tse_Chen on 2016/6/16.
 */
public class RecycleDeviceAdapter extends RecyclerView.Adapter<RecycleDeviceAdapter.RecycleDeviceHolder> implements View.OnClickListener {
    private ArrayList<String> deviceSetting;
    private RecycleDeviceHolder recycleHolder;
    private int getPosition;
    public RecycleDeviceAdapter(ArrayList<String> deviceSetting) {
        this.deviceSetting = deviceSetting;
    }

    @Override
    public RecycleDeviceHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.device_set_item,parent,false);
        view.setOnClickListener(this);
        recycleHolder = new RecycleDeviceHolder(view);
        return new RecycleDeviceHolder(view);
    }

    @Override
    public void onBindViewHolder(RecycleDeviceHolder holder, int position) {
        recycleHolder.deviceSet.setText(deviceSetting.get(position));
        recycleHolder.deviceSet.setTag(position);
        getPosition = position;
    }

    private OnRecycleViewItemClickListener itemClick = null;

    @Override
    public void onClick(View v) {
        if (itemClick!=null){
            itemClick.OnItemClick(v);
        }
    }

    public interface OnRecycleViewItemClickListener {
        void OnItemClick(View view);
    }

    public void setOnItemClickListener(OnRecycleViewItemClickListener listener){
        this.itemClick = listener;
    }

    @Override
    public int getItemCount() {
        return deviceSetting.size();
    }

    public static class RecycleDeviceHolder extends RecyclerView.ViewHolder {
        private TextView deviceSet;
        public RecycleDeviceHolder(View view) {
            super(view);
            deviceSet = (TextView) view.findViewById(R.id.device_set);


        }
    }
}
