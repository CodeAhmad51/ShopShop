package com.example.shopshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button register , login ;
    TextView forgetPassword;
    EditText username_login, password_login;

    SharedPreferences sharedPreferences_data;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        register = findViewById(R.id.register_button);
        login = findViewById(R.id.log_in_button);
        forgetPassword = findViewById(R.id.forget_password);
        username_login = findViewById(R.id.username_login);
        password_login = findViewById(R.id.password_login);

        sharedPreferences_data = getSharedPreferences("username_dataBase", MODE_PRIVATE);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent r = new Intent(getApplicationContext(),Register_page.class);
                startActivity(r);
            }


        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (username_login.getText().length() == 0 || password_login.getText().length() == 0){
                    Toast.makeText(getApplicationContext(),"plz enter username & password" , Toast.LENGTH_SHORT).show();
                }
                else{
                    setUsername("username_key",username_login.getText().toString());
                    Intent i = new Intent(getApplicationContext(),Home_page.class);
                    startActivity(i);
                }

            }
        });

        forgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent l = new Intent(getApplicationContext(),ForgetPage.class);
                startActivity(l);
            }
        });
    }


    void setUsername(String key , String value){
        SharedPreferences.Editor editor = sharedPreferences_data.edit();
        editor.putString(key, value);
        editor.apply();
    }

    String getUsername(String key){
        String s = sharedPreferences_data.getString(key,"");
        return s ;
    }

    void setPassword(String key , String value){
        SharedPreferences.Editor editor = sharedPreferences_data.edit();
        editor.putString(key, value);
        editor.apply();
    }

    String getPassword(String key){
        String password = sharedPreferences_data.getString(key,"");
        return password ;
    }
    void setEmail(String key , String value){
        SharedPreferences.Editor editor = sharedPreferences_data.edit();
        editor.putString(key, value);
        editor.commit();
    }

    String getEmail(String key){
        String password = sharedPreferences_data.getString(key,"");
        return password ;
    }

}