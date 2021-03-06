package com.example.dietsuggester;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static androidx.core.content.ContextCompat.startActivity;


public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder>{

    private MyListData[] listdata;
    MyListData myListData1;
    ArrayList<MyListData> list=new ArrayList<>();

    public ArrayList<MyListData> getList() {
        return list;
    }

    public void setList(ArrayList<MyListData> list) {
        this.list = list;
    }

    int cal;

    public int getCal() {
        return cal;
    }

    public void setCal(int cal) {
        this.cal = cal;
    }

    public MyListData[] getListdata() {
        return listdata;
    }


    // RecyclerView recyclerView;

    public MyListAdapter(MyListData[] listdata) {
        this.listdata = listdata;

    }
    public MyListAdapter(MyListData[] listdata, int cal) {
        this.listdata = listdata;
         this.cal=cal;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
         final MyListData myListData = listdata[position];
        holder.textView.setText(listdata[position].getDescription());

        holder.textView2.setText(listdata[position].getCal());
        holder.imageView.setImageResource(listdata[position].getImgId());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 myListData1 = new MyListData(myListData.getDescription(),myListData.getCal(), myListData.getImgId());
                 list.add(myListData1);
                 String data=myListData.getCal();
                Toast.makeText(view.getContext(),"Added "+myListData.getDescription()+" "
                        +myListData.caladd()+" calories"+"\n\n\n"+myListData.setmsg(cal),Toast.LENGTH_LONG).show();


            }
        });
    }

//code referred from internet
    @Override
    public int getItemCount() {
        return listdata.length;
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