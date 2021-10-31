    package com.example.quickpay.login_signup;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quickpay.R;
import com.example.quickpay.database.database;

import java.util.ArrayList;
import java.util.List;

public class signup_form extends AppCompatActivity {
    Spinner signup_spinner;
    Button button_signup;
    EditText signup_fullname_txt, signup_username_txt, signup_email_txt, signup_mobile_txt,
            signup_password_txt;
    RadioButton female_radio, male_radio;
    CheckBox signup_checkBox;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_form);
        signup_spinner = findViewById(R.id.signup_spinner);
        List<String> country_name = new ArrayList<String>();
        country_name.add("India");
        country_name.add("United state of america");
        country_name.add("United arab emirates");
        country_name.add("united kingdom");
        country_name.add("canada");
        country_name.add("Australia");

        ArrayAdapter<String> signup_country = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, country_name);
        signup_country.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        signup_spinner.setAdapter(signup_country);
        signup_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                signup_spinner.setSelection(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        button_signup = findViewById(R.id.button_signup);
        signup_fullname_txt = findViewById(R.id.signup_fullname_txt);
        signup_username_txt = findViewById(R.id.signup_username_txt);
        signup_email_txt = findViewById(R.id.signup_email_txt);
        signup_mobile_txt = findViewById(R.id.signup_mobile_txt);
        signup_password_txt = findViewById(R.id.signup_password_txt);
        female_radio = findViewById(R.id.female_radio);
        male_radio = findViewById(R.id.male_radio);
        signup_checkBox = findViewById(R.id.signup_checkBox);
        database g=new database(this);

        button_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullname = signup_fullname_txt.getText().toString();
                String username = signup_username_txt.getText().toString();
                String email = signup_email_txt.getText().toString();
                String mobile = signup_mobile_txt.getText().toString();
                String password = signup_password_txt.getText().toString();
                String f_radio = female_radio.getText().toString();
                String m_radio = male_radio.getText().toString();
                String s_checkbox = signup_checkBox.getText().toString();

                if (
//                        fullname.equals("") ||
                        username.equals("") ||
//                        email.equals("") || mobile.equals("") ||
                                password.equals("") ||
                                f_radio.equals("") || m_radio.equals("")) {
                    Toast.makeText(signup_form.this, "Enter all fields", Toast.LENGTH_SHORT).show();
                } else {

                    boolean b=g.add_data(username,password);
                    if(b){
                        Toast.makeText(signup_form.this, "Insert successfully", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(signup_form.this, "Not Insert", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });



    }
}