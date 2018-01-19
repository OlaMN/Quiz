package com.example.android.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {

    float result = 0;
    float ansCorrect = 0;
    float ansWrong = 0;
    final ArrayList<TextView> tvQuestion = new ArrayList<TextView>();
    final ArrayList<RadioGroup> rgQuestion = new ArrayList<RadioGroup>();
    final ArrayList<TextView> rbAnswer1 = new ArrayList<TextView>();
    final ArrayList<TextView> rbAnswer2 = new ArrayList<TextView>();
    final ArrayList<TextView> rbAnswer3 = new ArrayList<TextView>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent resultIntent = getIntent();
        ArrayList<QuizQuestion> question = resultIntent.getParcelableArrayListExtra("question");


        // Find views
        TextView tvResult = (TextView) findViewById(R.id.tv_result);
        TextView tvOk = (TextView) findViewById(R.id.tv_resultOk);
        TextView tvNOk = (TextView) findViewById(R.id.tv_resultNOk);
        // Question 1
        tvQuestion.add((TextView) findViewById(R.id.tv_question1));
        rgQuestion.add((RadioGroup) findViewById(R.id.rg_question1));
        rbAnswer1.add((TextView) findViewById(R.id.rb_answer1_1));
        rbAnswer2.add((TextView) findViewById(R.id.rb_answer1_2));
        rbAnswer3.add((TextView) findViewById(R.id.rb_answer1_3));

        // Question 2
        tvQuestion.add((TextView) findViewById(R.id.tv_question2));
        rgQuestion.add((RadioGroup) findViewById(R.id.rg_question2));
        rbAnswer1.add((TextView) findViewById(R.id.rb_answer2_1));
        rbAnswer2.add((TextView) findViewById(R.id.rb_answer2_2));
        rbAnswer3.add((TextView) findViewById(R.id.rb_answer2_3));

        // Question 3
        tvQuestion.add((TextView) findViewById(R.id.tv_question3));
        rgQuestion.add((RadioGroup) findViewById(R.id.rg_question3));
        rbAnswer1.add((TextView) findViewById(R.id.rb_answer3_1));
        rbAnswer2.add((TextView) findViewById(R.id.rb_answer3_2));
        rbAnswer3.add((TextView) findViewById(R.id.rb_answer3_3));

        // Question 4
        tvQuestion.add((TextView) findViewById(R.id.tv_question4));
        rgQuestion.add((RadioGroup) findViewById(R.id.rg_question4));
        rbAnswer1.add((TextView) findViewById(R.id.rb_answer4_1));
        rbAnswer2.add((TextView) findViewById(R.id.rb_answer4_2));
        rbAnswer3.add((TextView) findViewById(R.id.rb_answer4_3));

        // Question 5
        tvQuestion.add((TextView) findViewById(R.id.tv_question5));
        rgQuestion.add((RadioGroup) findViewById(R.id.rg_question5));
        rbAnswer1.add((TextView) findViewById(R.id.rb_answer5_1));
        rbAnswer2.add((TextView) findViewById(R.id.rb_answer5_2));
        rbAnswer3.add((TextView) findViewById(R.id.rb_answer5_3));

        // Question 6
        tvQuestion.add((TextView) findViewById(R.id.tv_question6));
        rgQuestion.add((RadioGroup) findViewById(R.id.rg_question6));
        rbAnswer1.add((TextView) findViewById(R.id.rb_answer6_1));
        rbAnswer2.add((TextView) findViewById(R.id.rb_answer6_2));
        rbAnswer3.add((TextView) findViewById(R.id.rb_answer6_3));

        // Question 7
        tvQuestion.add((TextView) findViewById(R.id.tv_question7));
        rgQuestion.add((RadioGroup) findViewById(R.id.rg_question7));
        rbAnswer1.add((TextView) findViewById(R.id.rb_answer7_1));
        rbAnswer2.add((TextView) findViewById(R.id.rb_answer7_2));
        rbAnswer3.add((TextView) findViewById(R.id.rb_answer7_3));

        // Question 8
        tvQuestion.add((TextView) findViewById(R.id.tv_question8));
        rgQuestion.add((RadioGroup) findViewById(R.id.rg_question8));
        rbAnswer1.add((TextView) findViewById(R.id.rb_answer8_1));
        rbAnswer2.add((TextView) findViewById(R.id.rb_answer8_2));
        rbAnswer3.add((TextView) findViewById(R.id.rb_answer8_3));

        // Question 9
        tvQuestion.add((TextView) findViewById(R.id.tv_question9));
        rgQuestion.add((RadioGroup) findViewById(R.id.rg_question9));
        rbAnswer1.add((TextView) findViewById(R.id.rb_answer9_1));
        rbAnswer2.add((TextView) findViewById(R.id.rb_answer9_2));
        rbAnswer3.add((TextView) findViewById(R.id.rb_answer9_3));

        // Question 10
        tvQuestion.add((TextView) findViewById(R.id.tv_question10));
        rgQuestion.add((RadioGroup) findViewById(R.id.rg_question10));
        rbAnswer1.add((TextView) findViewById(R.id.rb_answer10_1));
        rbAnswer2.add((TextView) findViewById(R.id.rb_answer10_2));
        rbAnswer3.add((TextView) findViewById(R.id.rb_answer10_3));

        for (int i = 0; i <question.size(); i++) {
            if (question.get(i).getSelectedAnswerOK())
                ansCorrect++;
            else
                ansWrong++;
        }
        // Calculate result in %
        result = ansCorrect/question.size() * 100;

        // Display results
        tvResult.setText(getString(R.string.yourResult) + (int) result + "%");
        tvOk.setText(getString(R.string.nmbCorrect) + (int) ansCorrect);
        tvNOk.setText(getString(R.string.nmbWrong) + (int) ansWrong);

        // Display answers and questions
        for (int index = 0; index < question.size(); index++){
            tvQuestion.get(index).setText(question.get(index).getQuestion());
            rbAnswer1.get(index).setText(question.get(index).getAnswer1());
            rbAnswer2.get(index).setText(question.get(index).getAnswer2());
            rbAnswer3.get(index).setText(question.get(index).getAnswer3());
            // Set radio buttons as not clickable
            for (int i = 0; i < rgQuestion.get(index).getChildCount(); i++) {
                rgQuestion.get(index).getChildAt(i).setClickable(false);
            }
            // Display selected answers
            // Mark wrong and correct answers
            int selected = question.get(index).getCurrentSelection();
            int correct = question.get(index).getCorrectAnswer();

            for (int i = 0; i < rgQuestion.get(index).getChildCount(); i++){
                RadioButton rb = (RadioButton) rgQuestion.get(index).getChildAt(i);
                if (i == correct){
                    rb.setButtonDrawable(getResources().getDrawable(R.drawable.ic_correct));
                    rb.setPadding(16, 8, 0, 8);
                } else if (i == selected & i != correct ){
                    rb.setButtonDrawable(getResources().getDrawable(R.drawable.ic_wrong));
                    rb.setPadding(16, 8, 0, 8);
                } else {
                    rb.setButtonDrawable(getResources().getDrawable(R.drawable.ic_notchecked));
                    rb.setPadding(16, 8, 0, 8);
                }
            }
        }
    }
}
