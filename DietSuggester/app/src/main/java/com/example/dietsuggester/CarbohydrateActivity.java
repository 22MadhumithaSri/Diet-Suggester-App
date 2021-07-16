package com.example.dietsuggester;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class CarbohydrateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food);
        //code written by me
        ArrayList<MyListData> mylist=new ArrayList<>();
        ArrayList<MyListData> mytemplist=new ArrayList<>();
        MyListData[] myListData1;
        MyListData[] myListData = new MyListData[] {
                new MyListData("Potato","77", R.drawable.potato),
                new MyListData("Oats","389", R.drawable.oats),
                new MyListData("Apple","59", R.drawable.apple),
                new MyListData("Banana","90", R.drawable.banana),
                new MyListData("Buttered toast", "150",R.drawable.toast),
                new MyListData("Brown Rice","175", R.drawable.brown_rice),
                new MyListData("Peanut Butter","75", R.drawable.peanut_butter),

        };




        Intent intent = getIntent();
        int cal = intent.getIntExtra("cal",0);
        //mytemplist=intent.<MyListData>getParcelableArrayListExtra("list");
        System.out.println(cal);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        MyListAdapter adapter = new MyListAdapter(myListData,cal);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        //adapter.setList(mytemplist);
        mylist=adapter.getList();


        ArrayList<MyListData> finalMylist = mylist;
        findViewById(R.id.ib2).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent i = new Intent(CarbohydrateActivity.this,ChooseActivity.class);
                i.putExtra("list", finalMylist);
                i.putExtra("cal",cal);
                startActivity(i);
            }
        });

    }
}