/*
 * Created by Sujoy Datta. Copyright (c) 2018. All rights reserved.
 *
 * To the person who is reading this..
 * When you finally understand how this works, please do explain it to me too at sujoydatta26@gmail.com
 * P.S.: In case you are planning to use this without mentioning me, you will be met with mean judgemental looks and sarcastic comments.
 */

package activities;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.morningstar.aptitude.R;

import adapters.MCQViewPagerAdapter;

public class MultipleChoiceQuestionsActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private MCQViewPagerAdapter mcqViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_choice_questions);

        viewPager = findViewById(R.id.mcqViewPager);
        mcqViewPagerAdapter = new MCQViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mcqViewPagerAdapter);
    }
}
