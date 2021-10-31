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

public class adapter_tf extends RecyclerView.Adapter<adapter_tf.holder_tf> {
    List<Integer> image_tf;
    List<String> text_tf;
    private Context context;

    public adapter_tf(List<Integer> image_tf, List<String> text_tf, Context context) {
        this.image_tf = image_tf;
        this.text_tf = text_tf;
        this.context = context;
    }

    @NonNull
    @Override
    public holder_tf onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_tf,parent,false);
        return new holder_tf(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  adapter_tf.holder_tf holder, int position) {
    holder.tf_image_tocontact.setImageResource(image_tf.get(position));
    holder.tf_text_tocontact.setText(text_tf.get(position));
    }

    @Override
    public int getItemCount() {
        return image_tf.size();
    }

    public class holder_tf extends RecyclerView.ViewHolder{
        ImageView tf_image_tocontact;
        TextView tf_text_tocontact;
        public holder_tf(@NonNull View itemView) {
            super(itemView);
            tf_image_tocontact=itemView.findViewById(R.id.tf_image_tocontact);
            tf_text_tocontact=itemView.findViewById(R.id.tf_text_tocontact);
        }
    }





}
