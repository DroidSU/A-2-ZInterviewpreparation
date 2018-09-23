/*
 * Created by Sujoy Datta. Copyright (c) 2018. All rights reserved.
 *
 * To the person who is reading this..
 * When you finally understand how this works, please do explain it to me too at sujoydatta26@gmail.com
 * P.S.: In case you are planning to use this without mentioning me, you will be met with mean judgemental looks and sarcastic comments.
 */

package activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.morningstar.aptitude.R;

import java.util.Arrays;
import java.util.List;

import Managers.ConstantManger;

public class MCQItem extends Fragment {
    private TextView textView_questions;
    private TextView textView_answer_one;
    private TextView textView_answer_two;
    private TextView textView_answer_three;
    private TextView textView_answer_four;

    private String question, firstAnswer, secondAnswer, thirdAnswer, fourthAnswer;
    private int hint;

    private List<String> questionsArray;
    private List<String> answerOneArray;
    private List<String> answerTwoArray;
    private List<String> answerThreeArray;
    private List<String> answerFourArray;

    private int pagerPosition;

    public MCQItem() {
        //default empty constructor
    }

    @SuppressLint("ValidFragment")
    public MCQItem(int position) {
        pagerPosition = position;
    }

    public static MCQItem newInstance(int position_number) {
        MCQItem mcqItem = new MCQItem();
        return mcqItem;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.mcq_item_layout, container, false);
        textView_questions = view.findViewById(R.id.mcqQuestion);
        textView_answer_one = view.findViewById(R.id.mcqAnswerOne);
        textView_answer_two = view.findViewById(R.id.mcqAnswerTwo);
        textView_answer_three = view.findViewById(R.id.mcqAnswerThree);
        textView_answer_four = view.findViewById(R.id.mcqAnswerFour);

        questionsArray = Arrays.asList(getResources().getStringArray(R.array.aptitude_questions));
        answerOneArray = Arrays.asList(getResources().getStringArray(R.array.aptitude_answer_one));
        answerTwoArray = Arrays.asList(getResources().getStringArray(R.array.aptitude_answer_two));
        answerThreeArray = Arrays.asList(getResources().getStringArray(R.array.aptitude_answer_three));
        answerFourArray = Arrays.asList(getResources().getStringArray(R.array.aptitude_answer_four));

        //pagerPosition = ConstantManger.AptitudePagerPosition;

        textView_questions.setText(questionsArray.get(pagerPosition));
        textView_answer_one.setText(answerOneArray.get(pagerPosition));
        textView_answer_two.setText(answerTwoArray.get(pagerPosition));
        textView_answer_three.setText(answerThreeArray.get(pagerPosition));
        textView_answer_four.setText(answerFourArray.get(pagerPosition));

        textView_questions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConstantManger.Category += 1;
                Toast.makeText(getContext(), "Working fine! ID is: " + ConstantManger.Category, Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
