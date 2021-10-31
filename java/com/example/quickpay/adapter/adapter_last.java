package com.example.quickpay.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quickpay.R;

public class adapter_last extends RecyclerView.Adapter<adapter_last.holder_last> {
    String [] arr;

    public adapter_last(String[] arr) {
        this.arr = arr;
    }

    @NonNull

    @Override
    public holder_last onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_last,parent,false);
        return new holder_last(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  adapter_last.holder_last holder, int position) {
    holder.button_last.setText(arr[position]);
    }

    @Override
    public int getItemCount() {
        return arr.length;
    }

    public class holder_last extends RecyclerView.ViewHolder{
        Button button_last;
        public holder_last(@NonNull View itemView) {
            super(itemView);
            button_last=itemView.findViewById(R.id.button_last);
        }
    }
}
