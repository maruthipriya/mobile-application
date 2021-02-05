package com.example.mydatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    String[] names={"priya","sridhar","aruna"};
    String[] mailID={"priya@gmail.com","sridhar@gmail.com","aruna@gmail.com"};
    String[] number={"123","456","789"};

    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv=findViewById(R.id.recycler);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new DataAdapter(this,names,mailID,number));
    }
}