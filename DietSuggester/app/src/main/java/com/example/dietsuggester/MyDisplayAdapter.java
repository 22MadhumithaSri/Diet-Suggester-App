package com.example.dietsuggester;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyDisplayAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder> {

    ArrayList<MyListData> listdata=new ArrayList<>();
    //private MyListData[] listdata;
    public MyDisplayAdapter(ArrayList<MyListData> mylist) {
        this.listdata=mylist;
    }

    @Override
    public MyListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.list_item, parent, false);
        MyListAdapter.ViewHolder viewHolder = new MyListAdapter.ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyListAdapter.ViewHolder holder, int position) {
        final MyListData myListData = listdata.get(position);
        holder.textView.setText(listdata.get(position).getDescription());
        holder.textView2.setText(listdata.get(position).getCal());
        holder.imageView.setImageResource(listdata.get(position).getImgId());
    }

    @Override
    public int getItemCount() {
        return listdata.size() ;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;
        public TextView textView2;
        public RelativeLayout relativeLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.imageView);
            this.textView = (TextView) itemView.findViewById(R.id.textView);
            this.textView2 = (TextView) itemView.findViewById(R.id.textView2);
            relativeLayout = (RelativeLayout)itemView.findViewById(R.id.relativeLayout);
        }
    }
}
