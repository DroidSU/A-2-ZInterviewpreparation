/*
 * Created by Sujoy Datta. Copyright (c) 2018. All rights reserved.
 *
 * To the person who is reading this..
 * When you finally understand how this works, please do explain it to me too at sujoydatta26@gmail.com
 * P.S.: In case you are planning to use this without mentioning me, you will be met with mean judgemental looks and sarcastic comments.
 */

package com.morningstar.aptitude;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class SubCategoryActivitiy extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    private ArrayList<String> CategoryTitle;
    private ArrayList<Integer> CategoryImage;
    private String CATEGORY_NAME = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_category_activitiy);
        Intent intent = getIntent();
        if (intent.hasExtra("category_name")) {
            CATEGORY_NAME = intent.getStringExtra("category_name");
        }
        recyclerView = findViewById(R.id.sub_cat_recyclerview);
        linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        switch (CATEGORY_NAME) {
            case "Aptitudes":
                CategoryTitle = new ArrayList<>(Arrays.asList("Trains", "Time and work", "Interest", "Weight and Distance", "Age", "Clock", "Averages", "Area", "Volume and Surface Area", "Permutations and Combinations"));
                CategoryImage = new ArrayList<>(Arrays.asList(R.drawable.trains, R.drawable.time_and_work, R.drawable.interest, R.drawable.interest, R.drawable.age, R.drawable.clock, R.drawable.averages, R.drawable.area, R.drawable.volume, R.drawable.perm));
                break;
            case "Interview":
                CategoryTitle = new ArrayList<>(Arrays.asList("HR","Software","Engineering","MBA","Company-wise"));
                CategoryImage = new ArrayList<>(Arrays.asList(R.drawable.hr, R.drawable.software, R.drawable.engineering, R.drawable.mba, R.drawable.company));
                break;
            case "Puzzles":
                CategoryTitle = new ArrayList<>(Arrays.asList("Number Puzzles","Missing Letter Puzzles","Logical Puzzles","Clock Puzzles"));
                CategoryImage = new ArrayList<>(Arrays.asList(R.drawable.number_puzzle,R.drawable.missing_letter,R.drawable.logical_puzzle,R.drawable.clock_puzzle));
                break;
            case "Reasoning":
                CategoryTitle = new ArrayList<>(Arrays.asList("Number Series 1","Number Series 2","Number Series 3","Number Series 4","Letter & Symbol","Verbal Classifications","Analogies","Artificial Language","Matching Definition","Blood Relations","Logical sequence of words","Syllogism","Cause and Effect","Seating Arrangement","Arithmetic Reasoning"));
                CategoryImage = new ArrayList<>(Arrays.asList(R.drawable.number_series_1,R.drawable.number_series_2,R.drawable.number_series_3,R.drawable.number_series_4,R.drawable.number_series_4,R.drawable.number_series_4,R.drawable.number_series_4,R.drawable.number_series_4,R.drawable.number_series_4,R.drawable.number_series_4,R.drawable.number_series_4,R.drawable.number_series_4,R.drawable.number_series_4,R.drawable.number_series_4,R.drawable.number_series_4));
                break;
            default:
                CategoryTitle = new ArrayList<>(Arrays.asList("Not set yet"));
                CategoryImage = new ArrayList<>(Arrays.asList(R.drawable.hr));
                break;
        }
        SubCategoryAdapter subCategoryAdapter = new SubCategoryAdapter(CategoryTitle, CategoryImage, SubCategoryActivitiy.this);
        recyclerView.setAdapter(subCategoryAdapter);
    }
}
