package com.example.tse_chen.demo1.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tse_chen.demo1.R;

import java.util.ArrayList;

/**
 * Created by Tse_Chen on 2016/6/14.
 */
public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.RecycleHolder> implements View.OnClickListener {

    public ArrayList<String> devices;

    private RecycleHolder recycleHolder;
    public RecycleAdapter(ArrayList<String> devices) {
        this.devices = devices;
    }



    @Override
    public RecycleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.device_item,parent,false);
        view.setOnClickListener(this);
        recycleHolder = new RecycleHolder(view);
        return new RecycleHolder(view);
    }

    @Override
    public void onBindViewHolder(RecycleHolder holder, int position) {
        holder.dev_name.setText(devices.get(position));
        holder.itemView.setTag(devices.get(position));
    }

    private OnRecycleViewItemClickListener itemClick = null;

    @Override
    public void onClick(View v) {
        if (itemClick!=null){
            itemClick.OnItemClick(v, (String) v.getTag());
        }
    }

    public interface OnRecycleViewItemClickListener {
        void OnItemClick(View view,String device);
    }

    public void setOnItemClickListener(OnRecycleViewItemClickListener listener){
        this.itemClick = listener;
    }

    @Override
    public int getItemCount() {
        return devices.size();
    }

    public void addItem(String device){
        devices.add(device);
        notifyItemInserted(devices.size());

    }

    public void clearAll(){
        devices.clear();
        notifyItemInserted(devices.size());
        notifyDataSetChanged();
    }


    public static class RecycleHolder extends RecyclerView.ViewHolder {
        ImageView dev_set;
        TextView dev_name;

        public RecycleHolder(View view) {
            super(view);
            dev_name = (TextView) view.findViewById(R.id.DeviceName);
            dev_set = (ImageView) view.findViewById(R.id.DeviceSet);

        }
    }

}
