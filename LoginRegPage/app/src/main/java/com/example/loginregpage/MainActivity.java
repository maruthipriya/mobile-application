package com.example.loginregpage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.loginregpage.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
DBhelper helper;
String name,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
      helper=new DBhelper(this);
    }

    public void loginEvent(View view) {
       Cursor c=helper.retriveData();
       while (c.moveToNext()){
           name=c.getString(1);
           password=c.getString(2);
       }
       if (binding.etUsername.getText().toString().equals(name)||binding.etPassword.getText().toString().equals(password))
        Toast.makeText(this, "welcome", Toast.LENGTH_SHORT).show();
        else
        Toast.makeText(this, "invalid", Toast.LENGTH_SHORT).show();
    }


    public void registerEvent(View view) {
        startActivity(new Intent(this,Registrationactivity.class));
    }
}