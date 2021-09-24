package com.example.shopshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class profile_page extends AppCompatActivity {

    EditText username_profilePage, password_ProfilePage , email_profile;

    SharedPreferences sharedPreferences_profile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        username_profilePage = findViewById(R.id.username_profilePage);
        password_ProfilePage = findViewById(R.id.password_profilePage);
        email_profile = findViewById(R.id.Email_editText);


        sharedPreferences_profile = getSharedPreferences("username_dataBase",MODE_PRIVATE);

        username_profilePage.setText(getUsername("username_key"));
        password_ProfilePage.setText(getPassword("username_key"));
        email_profile.setText(getEmail("username_key"));


    }


    String getUsername(String key){
        String s;
        s = sharedPreferences_profile.getString(key," ");
        return s ;
    }
    String getPassword(String key){
        String password;
        password = sharedPreferences_profile.getString(key," ");
        return password ;
    }
    String getEmail(String key){
        String email;
        email=sharedPreferences_profile.getString(key," ");
        return email;
    }

}