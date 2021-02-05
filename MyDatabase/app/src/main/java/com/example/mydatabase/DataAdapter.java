package com.example.mydatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {
    Context ct;
    String[] name;
    String[] mail;
    String[] num;

    public DataAdapter(MainActivity mainActivity, String[] names, String[] mailID, String[] number) {
        ct = mainActivity;
        name=names;
        mail=mailID;
        num=number;
    }




    @NonNull
    @Override
    public DataAdapter.DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ct).inflate(R.layout.rowdesign,parent,false);
        return new DataViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.DataViewHolder holder, int position) {
        holder.tv1.setText("Name:"+name[position]);
        holder.tv2.setText("Mailid:"+mail[position]);
        holder.tv3.setText("number"+num[position]);

    }

    @Override
    public int getItemCount() {
        return name.length;
    }

    public class DataViewHolder extends RecyclerView.ViewHolder {
        TextView tv1,tv2,tv3;
        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
            tv1=itemView.findViewById(R.id.username);
            tv2=itemView.findViewById(R.id.mail);
            tv3=itemView.findViewById(R.id.number);
        }
    }
}
