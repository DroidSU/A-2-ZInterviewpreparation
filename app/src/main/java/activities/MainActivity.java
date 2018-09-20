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
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.morningstar.aptitude.R;

import java.util.ArrayList;
import java.util.Arrays;

import adapters.MainMenuAdapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;
    ArrayList<String> item_names = new ArrayList<>(Arrays.asList("Aptitudes","Reasoning","Verbal Ability","Puzzles","Interview","Group Discussions","Rate Us","About Us"));
    ArrayList<Integer> item_icons = new ArrayList<>(Arrays.asList(R.drawable.aptitude,R.drawable.reasoning,R.drawable.verbal_ability,R.drawable.puzzles,R.drawable.interview, R.drawable.group_discussions, R.drawable.rate_us,R.drawable.contact_us));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager);

        MainMenuAdapter mainMenuAdapter = new MainMenuAdapter(item_names, item_icons, MainActivity.this);
        recyclerView.setAdapter(mainMenuAdapter);

    }
}
