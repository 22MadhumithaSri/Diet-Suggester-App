package com.example.dietsuggester;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;


public class FoodActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food);
        //code written by me
        ArrayList<MyListData> mylist=new ArrayList<>();
        ArrayList<MyListData> mytemplist=new ArrayList<>();
        MyListData[] myListData1;
        MyListData[] myListData = new MyListData[] {
                new MyListData("Flax Seeds","534", R.drawable.flaxseed),
                new MyListData("Dark Chocolate","505", R.drawable.darkchoclate),
                new MyListData("Egg yolk","40", R.drawable.eggyolk),
                new MyListData("Olives","115", R.drawable.olives),
                new MyListData("Whole Fat Milk","237", R.drawable.milk),
                 new MyListData("Walnut","165", R.drawable.walnut),
                new MyListData("Peanut Butter","75", R.drawable.peanut_butter),
                       };




        Intent intent = getIntent();
        int cal = intent.getIntExtra("cal",0);
        mytemplist=intent.<MyListData>getParcelableArrayListExtra("list");
        System.out.println(cal);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        MyListAdapter adapter = new MyListAdapter(myListData,cal);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.setList(mytemplist);
        adapter.setCal(cal);
        mylist=adapter.getList();


        ArrayList<MyListData> finalMylist = mylist;
        findViewById(R.id.ib2).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent i = new Intent(FoodActivity.this,DisplayActivity.class);
                i.putExtra("list", finalMylist);
                startActivity(i);
            }
        });

    }
}

