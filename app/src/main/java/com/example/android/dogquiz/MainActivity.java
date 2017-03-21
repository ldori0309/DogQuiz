package com.example.android.dogquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int goodAnswers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startQuiz(View view)
    {
        setContentView(R.layout.quiz_layout);
    }

    public void submitAnswers(View view) {
        checkAnswers();
        setContentView(R.layout.result_layout);
        if (goodAnswers > 6){
            Toast.makeText(this, "Congratulations! You answered " + goodAnswers +
                    " out of 8 questions correctly! You are a dog expert!", Toast.LENGTH_LONG).show();
        }
        else if(goodAnswers > 3){
            Toast.makeText(this, "Congratulations! You answered " + goodAnswers +
                    " out of 8 questions correctly! Not bad, but you could improve!", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "You answered " + goodAnswers +
                    " out of 8 questions correctly! You should read more about dogs!", Toast.LENGTH_LONG).show();
        }
    }

    public void checkAnswers(){
        RadioGroup q1 = (RadioGroup) findViewById(R.id.quiz1q);
        int q1answer = q1.indexOfChild(findViewById(q1.getCheckedRadioButtonId()));
        if(q1answer == 0) goodAnswers++;

        EditText q2=(EditText) findViewById(R.id.quiz2q);
        String q2answer = q2.getText().toString();
        if (q2answer.toLowerCase().equals("border collie")) goodAnswers++;

        RadioGroup q3 = (RadioGroup) findViewById(R.id.quiz3q);
        int q3answer = q3.indexOfChild(findViewById(q3.getCheckedRadioButtonId()));
        if(q3answer == 1) goodAnswers++;

        CheckBox q4p1 = (CheckBox) findViewById(R.id.quiz4p1);
        boolean q4p1answer = q4p1.isChecked();
        CheckBox q4p2 = (CheckBox) findViewById(R.id.quiz4p2);
        boolean q4p2answer = q4p2.isChecked();
        CheckBox q4p3 = (CheckBox) findViewById(R.id.quiz4p3);
        boolean q4p3answer = q4p3.isChecked();
        CheckBox q4p4 = (CheckBox) findViewById(R.id.quiz4p4);
        boolean q4p4answer = q4p4.isChecked();
        CheckBox q4p5 = (CheckBox) findViewById(R.id.quiz4p5);
        boolean q4p5answer = q4p5.isChecked();
        if(!q4p1answer && !q4p2answer && q4p3answer && !q4p4answer && q4p5answer) goodAnswers++;

        EditText q5=(EditText) findViewById(R.id.quiz5q);
        String q5answer = q5.getText().toString();
        if (q5answer.toLowerCase().equals("pug")) goodAnswers++;

        RadioGroup q6 = (RadioGroup) findViewById(R.id.quiz6q);
        int q6answer = q6.indexOfChild(findViewById(q6.getCheckedRadioButtonId()));
        if(q6answer == 0) goodAnswers++;

        EditText q7=(EditText) findViewById(R.id.quiz7q);
        String q7answer = q7.getText().toString();
        if (q7answer.toLowerCase().equals("german shepherd")) goodAnswers++;

        CheckBox q8p1 = (CheckBox) findViewById(R.id.quiz8p1);
        boolean q8p1answer = q8p1.isChecked();
        CheckBox q8p2 = (CheckBox) findViewById(R.id.quiz8p2);
        boolean q8p2answer = q8p2.isChecked();
        CheckBox q8p3 = (CheckBox) findViewById(R.id.quiz8p3);
        boolean q8p3answer = q8p3.isChecked();
        CheckBox q8p4 = (CheckBox) findViewById(R.id.quiz8p4);
        boolean q8p4answer = q8p4.isChecked();
        CheckBox q8p5 = (CheckBox) findViewById(R.id.quiz8p5);
        boolean q8p5answer = q8p5.isChecked();
        if(!q8p1answer && !q8p2answer && q8p3answer && q8p4answer && !q8p5answer) goodAnswers++;
    }

}
