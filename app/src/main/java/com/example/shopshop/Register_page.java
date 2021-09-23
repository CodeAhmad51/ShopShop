package com.example.shopshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Register_page extends AppCompatActivity {

    Button registerButton2;
    EditText username_register , password_register;

    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
        registerButton2 = findViewById(R.id.register_button2);
       username_register = findViewById(R.id.username);
       password_register = findViewById(R.id.password);


        database = FirebaseDatabase.getInstance("https://shophop-33f3a.firebaseio.com/");
        reference = database.getReference("users");

        registerButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateUsername(username_register.getText().toString() , password_register.getText().toString());
                Intent logInPage = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(logInPage);
            }
        });

    }


    void validateUsername(String username , String password){

        reference.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                boolean flag = false;
                for (DataSnapshot ds : snapshot.getChildren()){
                    if (ds.getKey().equals(username)){
                        failure();
                        return;
                    }
                }

                    success(username, password);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    void failure(){
        Toast.makeText(this, "Username already exists", Toast.LENGTH_SHORT).show();
    }

    void success(String userName , String password){
        database.getReference("users").child(String.valueOf(userName)).setValue(password);
        Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show();
    }


}