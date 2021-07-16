package com.example.dietsuggester;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class ProteinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food);
        //code written by me
        ArrayList<MyListData> mylist=new ArrayList<>();
        ArrayList<MyListData> mytemplist=new ArrayList<>();
        MyListData[] myListData1;
        MyListData[] myListData = new MyListData[] {
                new MyListData("Egg White","80", R.drawable.egg),
                new MyListData("Almond","170", R.drawable.almond),
                new MyListData("Grilled Chicken","225", R.drawable.grilled_chicken),
                        new MyListData("Green Beans","100", R.drawable.green_beans),
                    new MyListData("Sprouts", "100",R.drawable.sprouts),
                new MyListData("Fish", "136",R.drawable.fish),
                new MyListData("Tofu", "86",R.drawable.tofu),
                new MyListData("Spinach", "23",R.drawable.spinach),
        };




        Intent intent = getIntent();
        int calorie = intent.getIntExtra("cal",0);
        mytemplist=intent.<MyListData>getParcelableArrayListExtra("list");
        System.out.println(calorie);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        MyListAdapter adapter = new MyListAdapter(myListData,calorie);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.setList(mytemplist);
        adapter.setCal(calorie);
        mylist=adapter.getList();


        ArrayList<MyListData> finalMylist = mylist;
        findViewById(R.id.ib2).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent i = new Intent(ProteinActivity.this,ChooseActivity.class);
                i.putExtra("list", finalMylist);
                i.putExtra("cal",calorie);
                startActivity(i);
            }
        });

    }
}