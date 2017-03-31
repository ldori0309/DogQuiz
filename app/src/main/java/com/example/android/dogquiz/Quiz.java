package com.example.android.dogquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

public class Quiz extends AppCompatActivity {

    int goodAnswers = 0;
    RadioGroup q1;
    EditText q2;
    RadioGroup q3;
    CheckBox q4p1;
    CheckBox q4p2;
    CheckBox q4p3;
    CheckBox q4p4;
    CheckBox q4p5;
    EditText q5;
    RadioGroup q6;
    EditText q7;
    CheckBox q8p1;
    CheckBox q8p2;
    CheckBox q8p3;
    CheckBox q8p4;
    CheckBox q8p5;
    int q1answer, q3answer, q6answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_layout);
        q1 = (RadioGroup) findViewById(R.id.quiz1q);
        q2 = (EditText) findViewById(R.id.quiz2q);
        q3 = (RadioGroup) findViewById(R.id.quiz3q);
        q4p1 = (CheckBox) findViewById(R.id.quiz4p1);
        q4p2 = (CheckBox) findViewById(R.id.quiz4p2);
        q4p3 = (CheckBox) findViewById(R.id.quiz4p3);
        q4p4 = (CheckBox) findViewById(R.id.quiz4p4);
        q4p5 = (CheckBox) findViewById(R.id.quiz4p5);
        q5= (EditText) findViewById(R.id.quiz5q);
        q6 = (RadioGroup) findViewById(R.id.quiz6q);
        q7 = (EditText) findViewById(R.id.quiz7q);
        q8p1 = (CheckBox) findViewById(R.id.quiz8p1);
        q8p2 = (CheckBox) findViewById(R.id.quiz8p2);
        q8p3 = (CheckBox) findViewById(R.id.quiz8p3);
        q8p4 = (CheckBox) findViewById(R.id.quiz8p4);
        q8p5 = (CheckBox) findViewById(R.id.quiz8p5);
        if (savedInstanceState !=null) {
            q1answer = savedInstanceState.getInt("q1answer");
            q3answer = savedInstanceState.getInt("q3answer");
            q6answer = savedInstanceState.getInt("q6answer");
            if (q1.getChildAt(q1answer)!=null) q1.check(q1.getChildAt(q1answer).getId());
            if (q3.getChildAt(q3answer)!=null) q3.check(q3.getChildAt(q3answer).getId());
            if (q6.getChildAt(q6answer)!=null) q6.check(q6.getChildAt(q6answer).getId());
        }
    }

    public void onSaveInstanceState(Bundle savedInstanceState) {
        q1answer = q1.indexOfChild(findViewById(q1.getCheckedRadioButtonId()));
        q3answer = q3.indexOfChild(findViewById(q3.getCheckedRadioButtonId()));
        q6answer = q6.indexOfChild(findViewById(q6.getCheckedRadioButtonId()));
        savedInstanceState.putInt("q1answer", q1answer);
        savedInstanceState.putInt("q3answer", q3answer);
        savedInstanceState.putInt("q6answer", q6answer);
        super.onSaveInstanceState(savedInstanceState);
    }

    public void submitAnswers(View view) {
        checkAnswers();
        Intent gameResults = new Intent(this, Results.class);
        gameResults.putExtra("answers",goodAnswers);
        startActivity(gameResults);
    }

    private void checkAnswers(){

        q1answer = q1.indexOfChild(findViewById(q1.getCheckedRadioButtonId()));
        if(q1answer == 0) goodAnswers++;

        String q2answer = q2.getText().toString();
        if (q2answer.toLowerCase().equals(getResources().getString(R.string.dogBorderCollie).toLowerCase())) goodAnswers++;

        q3answer = q3.indexOfChild(findViewById(q3.getCheckedRadioButtonId()));
        if(q3answer == 1) goodAnswers++;

        boolean q4p1answer = q4p1.isChecked();
        boolean q4p2answer = q4p2.isChecked();
        boolean q4p3answer = q4p3.isChecked();
        boolean q4p4answer = q4p4.isChecked();
        boolean q4p5answer = q4p5.isChecked();
        if(!q4p1answer && !q4p2answer && q4p3answer && !q4p4answer && q4p5answer) goodAnswers++;

        String q5answer = q5.getText().toString();
        if (q5answer.toLowerCase().equals(getResources().getString(R.string.dogPug).toLowerCase())) goodAnswers++;

        q6answer = q6.indexOfChild(findViewById(q6.getCheckedRadioButtonId()));
        if(q6answer == 0) goodAnswers++;

        String q7answer = q7.getText().toString();
        if (q7answer.toLowerCase().equals(getResources().getString(R.string.dogGermanShepherd).toLowerCase())) goodAnswers++;

        boolean q8p1answer = q8p1.isChecked();
        boolean q8p2answer = q8p2.isChecked();
        boolean q8p3answer = q8p3.isChecked();
        boolean q8p4answer = q8p4.isChecked();
        boolean q8p5answer = q8p5.isChecked();
        if(!q8p1answer && !q8p2answer && q8p3answer && q8p4answer && !q8p5answer) goodAnswers++;
    }

}