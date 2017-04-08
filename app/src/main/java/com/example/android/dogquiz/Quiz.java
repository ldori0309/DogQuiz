package com.example.android.dogquiz;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

public class Quiz extends AppCompatActivity {

    CardView cardView1;
    CardView cardView2;
    CardView cardView3;
    CardView cardView4;
    CardView cardView5;
    CardView cardView6;
    CardView cardView7;
    CardView cardView8;
    CardView[] cardViews;

    int question = 0;
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

        cardView1 = (CardView) findViewById(R.id.cardView1);
        cardView2 = (CardView) findViewById(R.id.cardView2);
        cardView3 = (CardView) findViewById(R.id.cardView3);
        cardView4 = (CardView) findViewById(R.id.cardView4);
        cardView5 = (CardView) findViewById(R.id.cardView5);
        cardView6 = (CardView) findViewById(R.id.cardView6);
        cardView7 = (CardView) findViewById(R.id.cardView7);
        cardView8 = (CardView) findViewById(R.id.cardView8);
        cardViews = new CardView[] {cardView1,cardView2,cardView3,cardView4,cardView5,cardView6,cardView7,cardView8};
        for(int i=1; i<8; i++){
            cardViews[i].setVisibility(View.GONE);
        }

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
            question = savedInstanceState.getInt("question");
            q1answer = savedInstanceState.getInt("q1answer");
            q3answer = savedInstanceState.getInt("q3answer");
            q6answer = savedInstanceState.getInt("q6answer");
            if (q1.getChildAt(q1answer)!=null) q1.check(q1.getChildAt(q1answer).getId());
            if (q3.getChildAt(q3answer)!=null) q3.check(q3.getChildAt(q3answer).getId());
            if (q6.getChildAt(q6answer)!=null) q6.check(q6.getChildAt(q6answer).getId());
            cardViews[0].setVisibility(View.GONE);
            cardViews[question].setVisibility(View.VISIBLE);
        }
    }

    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("question",question);
        q1answer = q1.indexOfChild(findViewById(q1.getCheckedRadioButtonId()));
        q3answer = q3.indexOfChild(findViewById(q3.getCheckedRadioButtonId()));
        q6answer = q6.indexOfChild(findViewById(q6.getCheckedRadioButtonId()));
        savedInstanceState.putInt("q1answer", q1answer);
        savedInstanceState.putInt("q3answer", q3answer);
        savedInstanceState.putInt("q6answer", q6answer);
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        View v = getCurrentFocus();

        if (v != null &&
                (ev.getAction() == MotionEvent.ACTION_UP || ev.getAction() == MotionEvent.ACTION_MOVE) &&
                v instanceof EditText &&
                !v.getClass().getName().startsWith("android.webkit.")) {
            int scrcoords[] = new int[2];
            v.getLocationOnScreen(scrcoords);
            float x = ev.getRawX() + v.getLeft() - scrcoords[0];
            float y = ev.getRawY() + v.getTop() - scrcoords[1];

            if (x < v.getLeft() || x > v.getRight() || y < v.getTop() || y > v.getBottom())
                hideKeyboard(this);
        }
        return super.dispatchTouchEvent(ev);
    }

    public static void hideKeyboard(Activity activity) {
        if (activity != null && activity.getWindow() != null && activity.getWindow().getDecorView() != null) {
            InputMethodManager imm = (InputMethodManager)activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 0);
        }
    }

    public void nextQuestion(View view) {
        cardViews[question].setVisibility(View.GONE);
        question++;
        cardViews[question].setVisibility(View.VISIBLE);
    }

    public void submitAnswers(View view) {
        checkAnswers();
        Intent gameResults = new Intent(this, Results.class);
        gameResults.putExtra("answers",goodAnswers);
        startActivity(gameResults);
        this.finish();
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