package com.example.recyclerviewimplementation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.zip.Inflater;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    List<String> values;

    public MyAdapter(List<String> myData){
        values = myData;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.single_item,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,final int position) {
        String name = values.get(position);
        holder.tvHeader.setText(name);
        holder.tvHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remove(position);
            }
        });
        holder.tvFooter.setText("K_ZAWN Footer");

    }

    public void remove(int position){
        values.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvHeader, tvFooter;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvHeader = (TextView) itemView.findViewById(R.id.tvheader);
            tvFooter = (TextView) itemView.findViewById(R.id.tvfooter);
        }
    }
}
