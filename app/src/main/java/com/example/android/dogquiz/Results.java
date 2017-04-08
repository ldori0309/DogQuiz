package com.example.android.dogquiz;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AlignmentSpan;
import android.view.View;
import android.widget.Toast;

public class Results extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_layout);
        int score = getIntent().getIntExtra("answers", 0);
        showMessage(score);
    }

    public void showMessage(int score){
        String messageToShow;

        if (score > 6){
            messageToShow = getResources().getString(R.string.resultMessage1, score);
            //toast = Toast.makeText(this, getResources().getString(R.string.resultMessage1, goodAnswers), Toast.LENGTH_LONG);
        }
        else if(score > 3){
            messageToShow = getResources().getString(R.string.resultMessage2, score);
            //toast = Toast.makeText(this, getResources().getString(R.string.resultMessage2, goodAnswers), Toast.LENGTH_LONG);
        }
        else {
            messageToShow = getResources().getString(R.string.resultMessage3, score);
            //toast = Toast.makeText(this, getResources().getString(R.string.resultMessage3, goodAnswers), Toast.LENGTH_LONG);
        }

        Spannable centeredMessage = new SpannableString(messageToShow);
        centeredMessage.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER),
                0, messageToShow.length()-1, Spannable.SPAN_INCLUSIVE_INCLUSIVE);

        Toast.makeText(this, centeredMessage, Toast.LENGTH_LONG).show();
    }

    public void restartQuiz(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("EXIT", true);
        startActivity(intent);
        this.finish();
    }

    public void finishQuiz(View view) {
        this.finish();
    }
}
