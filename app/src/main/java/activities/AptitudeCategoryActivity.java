/*
 * Created by Sujoy Datta. Copyright (c) 2018. All rights reserved.
 *
 * To the person who is reading this..
 * When you finally understand how this works, please do explain it to me too at sujoydatta26@gmail.com
 * P.S.: In case you are planning to use this without mentioning me, you will be met with mean judgemental looks and sarcastic comments.
 */

package activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.morningstar.aptitude.R;

import java.util.ArrayList;
import java.util.Arrays;

import adapters.AptitudeCategoryAdapter;

public class AptitudeCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_category_activitiy);
        RecyclerView recyclerView = findViewById(R.id.sub_cat_recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        ArrayList<String> categoryTitle = new ArrayList<>(Arrays.asList("Trains", "Time and work", "Interest", "Weight and Distance", "Age", "Clock", "Averages", "Area", "Volume and Surface Area", "Permutations and Combinations"));
        ArrayList<Integer> categoryImage = new ArrayList<>(Arrays.asList(R.drawable.trains, R.drawable.time_and_work, R.drawable.interest, R.drawable.interest, R.drawable.age, R.drawable.clock, R.drawable.averages, R.drawable.area, R.drawable.volume, R.drawable.perm));

        AptitudeCategoryAdapter aptitudeCategoryAdapter = new AptitudeCategoryAdapter(categoryTitle, categoryImage, AptitudeCategoryActivity.this);
        recyclerView.setAdapter(aptitudeCategoryAdapter);
    }
}
