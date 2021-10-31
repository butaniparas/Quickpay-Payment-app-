package com.example.quickpay.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quickpay.R;

public class adapter_temp extends RecyclerView.Adapter<adapter_temp.holder_temp> {
    String [] arr;

    public adapter_temp(String[] arr) {
        this.arr = arr;
    }

    @NonNull
    @Override
    public holder_temp onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_temp,parent,false);
        return new holder_temp(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adapter_temp.holder_temp holder, int position) {
    holder.button.setText(arr[position]);
    }

    @Override
    public int getItemCount() {
        return arr.length;
    }


    public  class holder_temp extends RecyclerView.ViewHolder{
        Button button;
        public holder_temp(@NonNull View itemView) {
            super(itemView);
            button=itemView.findViewById(R.id.button);
        }
    }






}
