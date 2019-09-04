package com.example.mattetest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class StartActivity extends AppCompatActivity {

    public ArrayList<String> questions = new ArrayList<>();
    public ArrayList<Integer> answers = new ArrayList<>();
    public int preferedAmount = 5;

    public EditText editText;
    public TextView text;
    public int counter = 0;

    public int correctCounter = 0;
    public int wrongCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        getResFromXml();

        text = findViewById(R.id.txtQuestion);
        text.setText(questions.get(counter));

        final Button next = findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText = findViewById(R.id.temp);
                if(Integer.valueOf(editText.getText().toString()) == answers.get(counter)){
                    Log.d("A:", "Correct");
                    Toast.makeText(StartActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                    correctCounter++;
                }else{
                    Log.d("A:", "Wrong");
                    Toast.makeText(StartActivity.this, "WRONG!", Toast.LENGTH_SHORT).show();
                    wrongCounter++;
                }

                Log.d("Counter:", String.valueOf(counter));
                Log.d("Pref amount:", String.valueOf(preferedAmount));
                Log.d("Len:", String.valueOf(questions.size()));
                //if all questions have been shown, end game
                if(counter == questions.size()-1){
                    Log.d("FIN", "FINISHED");
                    int total = questions.size()-wrongCounter;
                    Toast.makeText(StartActivity.this, "Du er ferdig! Du klarte " + total
                                    + " av " + questions.size() + " spørsmål!"
                            , Toast.LENGTH_SHORT).show();
                }else{
                    //increase counter and set next question
                    counter++;
                    text.setText(questions.get(counter));
                }
            }
        });


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
        Log.d("Size: ", String.valueOf(questions.size()));
    }
}
