package com.example.dietsuggester;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class DisplayActivity extends AppCompatActivity {

    MyListData[] mylist1;
     String[] data1=null;
     ArrayList<MyListData> mylist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Intent intent = getIntent();

        mylist = intent.<MyListData>getParcelableArrayListExtra("list");
        int n= mylist.size();
        for(int i=0;i<n;i++)
        {
            MyListData[] mylist1=new MyListData[]{
                    new MyListData(mylist.get(i).getDescription(),mylist.get(i).getCal(), mylist.get(i).getImgId()),
            };
        }
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView1);
        MyDisplayAdapter adapter = new MyDisplayAdapter(mylist);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        findViewById(R.id.ib3).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent i = new Intent(DisplayActivity.this,TipsActivity.class);
                //i.putExtra("list", finalMylist);
                startActivity(i);
            }
        });

    }
}