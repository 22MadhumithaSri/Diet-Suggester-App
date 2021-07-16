package com.example.dietsuggester;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class ChooseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        ArrayList<MyListData> mylist = new ArrayList<>();
        MyListAdapter adapter;
        Intent intent = getIntent();
        int calorie = intent.getIntExtra("cal",0);
        mylist=intent.<MyListData>getParcelableArrayListExtra("list");
        System.out.println(calorie);

        ArrayList<MyListData> finalMylist = mylist;
        findViewById(R.id.carbohydrate).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),CarbohydrateActivity.class);

                i.putExtra("cal",calorie);
                //i.putExtra("list", finalMylist);

                startActivity(i);
            }
        });


        int calorie1 = intent.getIntExtra("cal",0);
        findViewById(R.id.protein).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ProteinActivity.class);

                i.putExtra("cal",calorie);
                i.putExtra("list", finalMylist);

                startActivity(i);
            }
        });

        int calorie2 = intent.getIntExtra("cal",0);
        findViewById(R.id.fat).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),FoodActivity.class);

                i.putExtra("cal",calorie);
                i.putExtra("list", finalMylist);

                startActivity(i);
            }
        });
        findViewById(R.id.bot).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);


                startActivity(i);
            }
        });
    }
}