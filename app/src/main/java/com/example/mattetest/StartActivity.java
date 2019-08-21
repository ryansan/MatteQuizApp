package com.example.mattetest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class StartActivity extends AppCompatActivity {

    public ArrayList<String> questions = new ArrayList<>();
    public ArrayList<Integer> answers = new ArrayList<>();
    public int preferedAmount = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        getResFromXml();


        final Button next = findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //test if answer is correct
            }
        });

        TextView text = findViewById(R.id.txtQuestion);
        text.setText(questions.get(0));
    }

    public void getResFromXml(){
        String[] innQuestions = getResources().getStringArray(R.array.questions);
        int[] innAnswers = getResources().getIntArray(R.array.answers);

        Random random = new Random();

        for(int i = 0; i < preferedAmount; i++){
            //get random
            int r = random.nextInt((9)+1);

            //put random number from xml into arraylist
            questions.add(innQuestions[r]);
            answers.add(innAnswers[r]);

            Log.d("q", questions.get(i));
            Log.d("a", String.valueOf(answers.get(i)));
        }
    }
}
