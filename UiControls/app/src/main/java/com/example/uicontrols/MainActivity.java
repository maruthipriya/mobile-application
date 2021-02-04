package com.example.uicontrols;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    RatingBar rating;
    SeekBar seekBar;
    TextView tv_rating,tv_seekbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rating=findViewById(R.id.rb);
        seekBar=findViewById(R.id.sb);
        tv_rating=findViewById(R.id.tv_rating);
        tv_seekbar=findViewById(R.id.tv_progress);
        rating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rate, boolean b) {
            tv_rating.setText("User Rating is: "+rate);
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                tv_seekbar.setText("your progress is :"+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}