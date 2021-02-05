package com.example.covid19reports;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.covid19reports.databinding.ActivityMainBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding databinding;
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        databinding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        dialog=new ProgressDialog(this);
        dialog.setTitle("fetching data");
        dialog.setMessage("please wait data is loading");
        dialog.show();
        EndPointInterface endPointInterface=covid19instance
                .getRetrofitInstance().create(EndPointInterface.class);
        Call<String> c=endPointInterface.getAll();
        c.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i("ding",response.body());
                Toast.makeText(MainActivity.this, ""+response.body(), Toast.LENGTH_SHORT).show();
               dialog.cancel();
               try {
                    JSONArray rootarray=new JSONArray(response.body());
                    JSONObject rootobject=rootarray.getJSONObject(1);
                    String result_country=rootobject.getString("Country");
                    String result_Confirmed=rootobject.getString("Confirmed");
                    String result_Deaths=rootobject.getString("Deaths");
                    String result_Recovered=rootobject.getString("Recovered");
                    String result_Active=rootobject.getString("Active");
                    String result_Date=rootobject.getString("Date");
                    databinding.tvCountry.setText("Country :"+result_country);
                   databinding.tvConfirmed.setText("Confirmed :"+result_Confirmed);
                   databinding.tvDeath.setText("Deaths :"+result_Deaths);
                   databinding.tvRecovered.setText("Recovered :"+result_Recovered);
                   databinding.tvActive.setText("Active :"+result_Active);
                   databinding.tvDate.setText("Date :"+result_Date);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(MainActivity.this, "failed while fetching", Toast.LENGTH_SHORT).show();

            }
        });
    }
}