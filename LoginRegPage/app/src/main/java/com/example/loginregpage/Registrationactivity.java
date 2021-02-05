package com.example.loginregpage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.loginregpage.databinding.ActivityRegistrationactivityBinding;
import com.example.loginregpage.databinding.ActivityRegistrationactivityBindingImpl;

public class Registrationactivity extends AppCompatActivity {
    ActivityRegistrationactivityBinding binding;
    DBhelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_registrationactivity);
        helper=new DBhelper(this);
    }

    public void saveData(View view) {
        ContentValues cn=new ContentValues();
        cn.put(helper.col_0,binding.etRegUsername.getText().toString());
        cn.put(helper.col_1,binding.etRegPassword.getText().toString());
        cn.put(helper.col_2,binding.etRegEmail.getText().toString());
        long row=helper.saveData(cn);
        Toast.makeText(this, binding.etRegUsername.getText().toString()+"Inserted successfully"+row, Toast.LENGTH_SHORT).show();
        helper.saveData(cn);
    }

    public void retriveData(View view) {
        Cursor c=helper.retriveData();
        StringBuilder sb=new StringBuilder();
        while (c.moveToNext()){
            sb.append(c.getString(1)+"\t");
            sb.append(c.getString(2)+"\n");
        }
        binding.tvResult.setText(sb);
    }
}