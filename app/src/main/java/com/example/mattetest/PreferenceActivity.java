package com.example.mattetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.Locale;

public class PreferenceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);

        final RadioGroup rg = findViewById(R.id.radioGroup);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedID) {
                switch (checkedID){
                    case R.id.numberOfQuestions5:
                        Log.d("5", "changed to 5");
                        break;
                    case R.id.numberOfQuestions10:
                        Log.d("10", "changed to 10");
                        break;
                    case R.id.numberOfQuestions25:
                        Log.d("25", "changed to 25");
                        default:
                            break;
                }
            }
        });

        final Button btnStart = findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Resources res = getResources();

                Configuration config = new Configuration(res.getConfiguration());

                Log.d("L:", "GER");
                config.locale = Locale.GERMAN;

                res.updateConfiguration(config, res.getDisplayMetrics());
            }
        });


        /*
        RadioGroup rgLanguage = findViewById(R.id.radioGroupLanguage);
        rgLanguage.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

            }
        });

    <RadioGroup
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        android:gravity="center"
        android:id="@+id/radioGroupLanguage">

        <RadioButton
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:id="@+id/radioBtnNorwegian"
            android:drawableRight="@drawable/norflag"
            android:text="nor"

            android:scaleX="0.2"
            android:scaleY="0.2">
        </RadioButton>

        <RadioButton
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:id="@+id/radioBtnDeutsch"
            android:drawableRight="@drawable/gerflag"
            android:text="ger"
            android:scaleX="0.2"
            android:scaleY="0.2">
        </RadioButton>

    </RadioGroup>


         */
    }
}
