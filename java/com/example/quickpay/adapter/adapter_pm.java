package com.example.quickpay.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quickpay.R;

import java.util.List;

public class adapter_pm extends RecyclerView.Adapter<adapter_pm.holder_pm> {
    List<Integer> pm_image;
    List<String> pm_text;
    private Context context;

    public adapter_pm(List<Integer> pm_image, List<String> pm_text, Context context) {
        this.pm_image = pm_image;
        this.pm_text = pm_text;
        this.context = context;
    }

    @NonNull
    @Override
    public holder_pm onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_pm, parent, false);
        return new holder_pm(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adapter_pm.holder_pm holder, int position) {
    holder.pm_image_mobile.setImageResource(pm_image.get(position));
    holder.pm_mobile_text.setText(pm_text.get(position));
    }

    @Override
    public int getItemCount() {
        return pm_image.size();
    }

    public class holder_pm extends RecyclerView.ViewHolder {
        ImageView pm_image_mobile;
        TextView pm_mobile_text;

        public holder_pm(@NonNull View itemView) {
            super(itemView);
            pm_image_mobile = itemView.findViewById(R.id.pm_image_mobile);
            pm_mobile_text = itemView.findViewById(R.id.pm_mobile_text);
        }
    }


}
