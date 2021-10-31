package com.example.quickpay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.quickpay.adapter.adapter_last;
import com.example.quickpay.adapter.adapter_pm;
import com.example.quickpay.adapter.adapter_temp;
import com.example.quickpay.adapter.adapter_tf;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recycler_view_temp, recyclerview_pm, recyclerview_tf, recyclerview_last;
    EditText serach_left_text;
    ImageView search_image;

    String[] button_arr_temp = {"Invoice for payment", "MY MTR", "Dad sberbank", "Mom's mobile", "Sister tinkoff"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler_view_temp = findViewById(R.id.recycler_view_temp);
        recycler_view_temp.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        adapter_temp atemp = new adapter_temp(button_arr_temp);
        recycler_view_temp.setAdapter(atemp);

        List<Integer> pm_image = new ArrayList<>();
        pm_image.add(R.drawable.ic_cell_phone);
        pm_image.add(R.drawable.ic_internet);
        pm_image.add(R.drawable.ic_hcs);
        pm_image.add(R.drawable.ic_telephone);
        pm_image.add(R.drawable.ic_credit_card);
        pm_image.add(R.drawable.ic_internet);

        List<String> pm_text = new ArrayList<>();
        pm_text.add("Mobile");
        pm_text.add("Internet");
        pm_text.add("HCS");
        pm_text.add("Home Phone");
        pm_text.add("Cards");
        pm_text.add("World");

        recyclerview_pm = findViewById(R.id.recyclerview_pm);
        recyclerview_pm.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        adapter_pm pma = new adapter_pm(pm_image, pm_text, this);
        recyclerview_pm.setAdapter(pma);

        List<Integer> tf_image = new ArrayList<>();
        tf_image.add(R.drawable.ic_to_contacts);
        tf_image.add(R.drawable.ic_to_card);
        tf_image.add(R.drawable.ic_to_person);
        tf_image.add(R.drawable.ic_credit_card);
        tf_image.add(R.drawable.ic_to_person);
        tf_image.add(R.drawable.ic_to_contacts);

        List<String> tf_text = new ArrayList<>();
        tf_text.add("To Contacts");
        tf_text.add("To Cards");
        tf_text.add("Yourself");
        tf_text.add("To Credit Cards");
        tf_text.add("Others");
        tf_text.add("My Personal");

        recyclerview_tf = findViewById(R.id.recyclerview_tf);
        recyclerview_tf.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        adapter_tf tfa = new adapter_tf(tf_image, tf_text, this);
        recyclerview_tf.setAdapter(tfa);


        String[] button_arr_last = {"Divya's credit card", "Mom's bank cards", "Mobile recharge", "Fastag recharge"};
        recyclerview_last = findViewById(R.id.recyclerview_last);

        recyclerview_last.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        adapter_last lasta = new adapter_last(button_arr_last);
        recyclerview_last.setAdapter(lasta);

        serach_left_text = findViewById(R.id.serach_left_text);
        search_image=findViewById(R.id.search_image);


        search_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = serach_left_text.getText().toString();
                SharedPreferences shrd=getSharedPreferences("demo",MODE_PRIVATE);
                SharedPreferences.Editor editor=shrd.edit();
                editor.putString("str",data);
                editor.apply();
                serach_left_text.setText(data);

                Intent intent=new Intent(MainActivity.this,second_screen.class);
                intent.putExtra("pbri",data);
                startActivity(intent);
            }
        });

        SharedPreferences getshrd=getSharedPreferences("demo",MODE_PRIVATE);
        String value=getshrd.getString("str","Payment name,tin,account no");
        serach_left_text.setText(value);


    }
}