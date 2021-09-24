package com.example.shopshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Home_page extends AppCompatActivity implements View.OnClickListener{

    ImageView  profile_24, cart_24 , home_24 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        profile_24 = findViewById(R.id.profile_24);
        cart_24 = findViewById(R.id.cart_24);
        home_24 = findViewById(R.id.home_24);

        profile_24.setOnClickListener(this);
        cart_24.setOnClickListener(this);
        home_24.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if(view.getId() == home_24.getId()){
            Intent h = new Intent(getApplicationContext(),Home_page.class);
            startActivity(h);

        }
        else if(view.getId() == cart_24.getId()){
            Intent c = new Intent(getApplicationContext(),Home_page.class);
            startActivity(c);

        }
        else if(view.getId() == profile_24.getId()){
            Intent p = new Intent(getApplicationContext(), profile_page.class);
            startActivity(p);

        }
    }
}