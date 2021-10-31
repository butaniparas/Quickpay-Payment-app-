package com.example.quickpay.login_signup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quickpay.MainActivity;
import com.example.quickpay.R;
import com.example.quickpay.database.database;

public class login_form extends AppCompatActivity {

    TextView username_edittext,password_editText,textView_pass,textView_signup;
    Button login_button1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_form);
        login_button1=findViewById(R.id.login_button1);
        username_edittext=findViewById(R.id.username_edittext);
        password_editText=findViewById(R.id.password_editText);
        textView_pass=findViewById(R.id.textView_pass);
        textView_signup=findViewById(R.id.textView_signup);
        database db=new database(this);


        login_button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=username_edittext.getText().toString();
                String password=password_editText.getText().toString();
                if(username.equals("") || password.equals("")){
                    Toast.makeText(login_form.this, "Enter all fields", Toast.LENGTH_SHORT).show();
                }else{
                    boolean checkuserpass=db.check_data(username,password);
                    if(checkuserpass==true){
                        Toast.makeText(login_form.this, "Login successfully", Toast.LENGTH_SHORT).show();
                        Intent i=new Intent(login_form.this, MainActivity.class);
                        startActivity(i);
                    }else{
                        Toast.makeText(login_form.this, "Invalid username & password", Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });
        textView_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(login_form.this,signup_form.class);
                startActivity(i);
            }
        });
        textView_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=username_edittext.getText().toString();
                String password=password_editText.getText().toString();
                boolean b=db.update_data(username,password);
                if(b){
                    Toast.makeText(login_form.this, "Password update successfully", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(login_form.this, "password not update", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}