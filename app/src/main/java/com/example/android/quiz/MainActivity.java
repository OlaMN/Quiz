package com.example.android.quiz;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<QuizQuestion> question = new ArrayList<QuizQuestion>();
    ArrayList<TextView> tvQuestion = new ArrayList<TextView>();
    ArrayList<RadioGroup> rgQuestion = new ArrayList<RadioGroup>();
    ArrayList<TextView> rbAnswer1 = new ArrayList<TextView>();
    ArrayList<TextView> rbAnswer2 = new ArrayList<TextView>();
    ArrayList<TextView> rbAnswer3 = new ArrayList<TextView>();
    ArrayList<Button> btnSubmit = new ArrayList<Button>();
    Button btnResult;
    ScrollView scrollView;
    int index = 0;
    private boolean isBackBtnPressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        question.add(new QuizQuestion(getString(R.string.question1), getString(R.string.answer1_1), getString(R.string.answer1_2), getString(R.string.answer1_3), Integer.parseInt(getString(R.string.correct1))));
        question.add(new QuizQuestion(getString(R.string.question2), getString(R.string.answer2_1), getString(R.string.answer2_2), getString(R.string.answer2_3), Integer.parseInt(getString(R.string.correct2))));
        question.add(new QuizQuestion(getString(R.string.question3), getString(R.string.answer3_1), getString(R.string.answer3_2), getString(R.string.answer3_3), Integer.parseInt(getString(R.string.correct3))));
        question.add(new QuizQuestion(getString(R.string.question4), getString(R.string.answer4_1), getString(R.string.answer4_2), getString(R.string.answer4_3), Integer.parseInt(getString(R.string.correct4))));
        question.add(new QuizQuestion(getString(R.string.question5), getString(R.string.answer5_1), getString(R.string.answer5_2), getString(R.string.answer5_3), Integer.parseInt(getString(R.string.correct5))));
        question.add(new QuizQuestion(getString(R.string.question6), getString(R.string.answer6_1), getString(R.string.answer6_2), getString(R.string.answer6_3), Integer.parseInt(getString(R.string.correct6))));
        question.add(new QuizQuestion(getString(R.string.question7), getString(R.string.answer7_1), getString(R.string.answer7_2), getString(R.string.answer7_3), Integer.parseInt(getString(R.string.correct7))));
        question.add(new QuizQuestion(getString(R.string.question8), getString(R.string.answer8_1), getString(R.string.answer8_2), getString(R.string.answer8_3), Integer.parseInt(getString(R.string.correct8))));
        question.add(new QuizQuestion(getString(R.string.question9), getString(R.string.answer9_1), getString(R.string.answer9_2), getString(R.string.answer9_3), Integer.parseInt(getString(R.string.correct9))));
        question.add(new QuizQuestion(getString(R.string.question10), getString(R.string.answer10_1), getString(R.string.answer10_2), getString(R.string.answer10_3), Integer.parseInt(getString(R.string.correct10))));

        // Find views
        // Question 1
        tvQuestion.add((TextView) findViewById(R.id.tv_question1));
        rgQuestion.add((RadioGroup) findViewById(R.id.rg_question1));
        rbAnswer1.add((TextView) findViewById(R.id.rb_answer1_1));
        rbAnswer2.add((TextView) findViewById(R.id.rb_answer1_2));
        rbAnswer3.add((TextView) findViewById(R.id.rb_answer1_3));
        btnSubmit.add((Button) findViewById(R.id.btn_submit1));

        // Question 2
        tvQuestion.add((TextView) findViewById(R.id.tv_question2));
        rgQuestion.add((RadioGroup) findViewById(R.id.rg_question2));
        rbAnswer1.add((TextView) findViewById(R.id.rb_answer2_1));
        rbAnswer2.add((TextView) findViewById(R.id.rb_answer2_2));
        rbAnswer3.add((TextView) findViewById(R.id.rb_answer2_3));
        btnSubmit.add((Button) findViewById(R.id.btn_submit2));

        // Question 3
        tvQuestion.add((TextView) findViewById(R.id.tv_question3));
        rgQuestion.add((RadioGroup) findViewById(R.id.rg_question3));
        rbAnswer1.add((TextView) findViewById(R.id.rb_answer3_1));
        rbAnswer2.add((TextView) findViewById(R.id.rb_answer3_2));
        rbAnswer3.add((TextView) findViewById(R.id.rb_answer3_3));
        btnSubmit.add((Button) findViewById(R.id.btn_submit3));

        // Question 4
        tvQuestion.add((TextView) findViewById(R.id.tv_question4));
        rgQuestion.add((RadioGroup) findViewById(R.id.rg_question4));
        rbAnswer1.add((TextView) findViewById(R.id.rb_answer4_1));
        rbAnswer2.add((TextView) findViewById(R.id.rb_answer4_2));
        rbAnswer3.add((TextView) findViewById(R.id.rb_answer4_3));
        btnSubmit.add((Button) findViewById(R.id.btn_submit4));

        // Question 5
        tvQuestion.add((TextView) findViewById(R.id.tv_question5));
        rgQuestion.add((RadioGroup) findViewById(R.id.rg_question5));
        rbAnswer1.add((TextView) findViewById(R.id.rb_answer5_1));
        rbAnswer2.add((TextView) findViewById(R.id.rb_answer5_2));
        rbAnswer3.add((TextView) findViewById(R.id.rb_answer5_3));
        btnSubmit.add((Button) findViewById(R.id.btn_submit5));

        // Question 6
        tvQuestion.add((TextView) findViewById(R.id.tv_question6));
        rgQuestion.add((RadioGroup) findViewById(R.id.rg_question6));
        rbAnswer1.add((TextView) findViewById(R.id.rb_answer6_1));
        rbAnswer2.add((TextView) findViewById(R.id.rb_answer6_2));
        rbAnswer3.add((TextView) findViewById(R.id.rb_answer6_3));
        btnSubmit.add((Button) findViewById(R.id.btn_submit6));

        // Question 7
        tvQuestion.add((TextView) findViewById(R.id.tv_question7));
        rgQuestion.add((RadioGroup) findViewById(R.id.rg_question7));
        rbAnswer1.add((TextView) findViewById(R.id.rb_answer7_1));
        rbAnswer2.add((TextView) findViewById(R.id.rb_answer7_2));
        rbAnswer3.add((TextView) findViewById(R.id.rb_answer7_3));
        btnSubmit.add((Button) findViewById(R.id.btn_submit7));

        // Question 8
        tvQuestion.add((TextView) findViewById(R.id.tv_question8));
        rgQuestion.add((RadioGroup) findViewById(R.id.rg_question8));
        rbAnswer1.add((TextView) findViewById(R.id.rb_answer8_1));
        rbAnswer2.add((TextView) findViewById(R.id.rb_answer8_2));
        rbAnswer3.add((TextView) findViewById(R.id.rb_answer8_3));
        btnSubmit.add((Button) findViewById(R.id.btn_submit8));

        // Question 9
        tvQuestion.add((TextView) findViewById(R.id.tv_question9));
        rgQuestion.add((RadioGroup) findViewById(R.id.rg_question9));
        rbAnswer1.add((TextView) findViewById(R.id.rb_answer9_1));
        rbAnswer2.add((TextView) findViewById(R.id.rb_answer9_2));
        rbAnswer3.add((TextView) findViewById(R.id.rb_answer9_3));
        btnSubmit.add((Button) findViewById(R.id.btn_submit9));

        // Question 10
        tvQuestion.add((TextView) findViewById(R.id.tv_question10));
        rgQuestion.add((RadioGroup) findViewById(R.id.rg_question10));
        rbAnswer1.add((TextView) findViewById(R.id.rb_answer10_1));
        rbAnswer2.add((TextView) findViewById(R.id.rb_answer10_2));
        rbAnswer3.add((TextView) findViewById(R.id.rb_answer10_3));
        btnSubmit.add((Button) findViewById(R.id.btn_submit10));

        scrollView = (ScrollView) findViewById(R.id.listview_quiz);
        btnResult = (Button) findViewById(R.id.btn_result);

        // Display question's text
        for (int i = 0; i < question.size(); i++) {
            tvQuestion.get(i).setText(question.get(i).getQuestion());
            rbAnswer1.get(i).setText(question.get(i).getAnswer1());
            rbAnswer2.get(i).setText(question.get(i).getAnswer2());
            rbAnswer3.get(i).setText(question.get(i).getAnswer3());
        }

        // // Hide questions 1-9
        for (int i = 1; i < question.size(); i++) {
            tvQuestion.get(i).setVisibility(View.GONE);
            rgQuestion.get(i).setVisibility(View.GONE);
            btnSubmit.get(i).setVisibility(View.GONE);
        }
        // Hide result button
        btnResult.setVisibility(View.GONE);

        // Submit buttons click listeners
        for (int i = 0; i < question.size(); i++){
            btnSubmit.get(i).setOnClickListener(this);
        }
        // Result button click listener
        btnResult.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        switch(v.getId()) {
            case R.id.btn_submit1:
            case R.id.btn_submit2:
            case R.id.btn_submit3:
            case R.id.btn_submit4:
            case R.id.btn_submit5:
            case R.id.btn_submit6:
            case R.id.btn_submit7:
            case R.id.btn_submit8:
            case R.id.btn_submit9:
            case R.id.btn_submit10:
                submitClicked();
                break;
            case R.id.btn_result:
                resultClicked();
                break;
        }
    }

    // Submit button: submit answer
    // Save selected answer in question ArrayList
    // Show next question
    // Increase index
    // On last question display "show result" button
    public void submitClicked (){
        if (rgQuestion.get(index).getCheckedRadioButtonId() == -1) {
            // Answer is not selected
            Toast.makeText(getBaseContext(), "Select answer!", Toast.LENGTH_SHORT).show();
        } else {
            // Answer is selected
            if (index < question.size()) {
                // Save selected answer
                int selectedRadioButtonID = rgQuestion.get(index).indexOfChild(findViewById(rgQuestion.get(index).getCheckedRadioButtonId()));
                question.get(index).currentSelection = selectedRadioButtonID;
                question.get(index).submitClicked = true;
                // Check if selected answer is correct
                if (question.get(index).currentSelection == question.get(index).getCorrectAnswer()){
                    question.get(index).selectedAnswerOK = true;
                }
                // Disable radio buttons selection
                for (int i = 0; i < rgQuestion.get(index).getChildCount(); i++) {
                    rgQuestion.get(index).getChildAt(i).setEnabled(false);
                }
                // Disable submit button clicking and change its color
                btnSubmit.get(index).setClickable(false);
                btnSubmit.get(index).setBackgroundColor(getResources().getColor(R.color.colorGray));
                // Increase index
                index++;
                Log.e("Index", String.valueOf(index));
                Log.e("Size", String.valueOf(question.size()));
                // Show next question and set text
                if (index < question.size()) {
                    tvQuestion.get(index).setVisibility(View.VISIBLE);
                    rgQuestion.get(index).setVisibility(View.VISIBLE);
                    btnSubmit.get(index).setVisibility(View.VISIBLE);
                    // Scroll to next question's submit button
                    btnSubmit.get(index).getParent().requestChildFocus(btnSubmit.get(index), btnSubmit.get(index));
                }
            }
            if (index == question.size() ){
                btnResult.setVisibility(View.VISIBLE);
                Log.e("Button result", "shown");
            }
        }
    }

    // Result button: new activity with quiz result
    public void resultClicked(){
        // Open result activity
        Intent resultIntent = new Intent (MainActivity.this, ResultActivity.class);
        // Copy question ArrayList to result activity
        resultIntent.putParcelableArrayListExtra("question", question );
        startActivity(resultIntent);
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        if(isBackBtnPressed){
            finish();
        }else {
            isBackBtnPressed = true;
            Toast.makeText(this, R.string.backButton, Toast.LENGTH_SHORT).show();
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    isBackBtnPressed = false;
                }
            }, 2000);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("questionArrayList", question);
        outState.putInt("questionIndex", index);
        super.onSaveInstanceState(outState);
    }

    /**
     * Save state on rotation
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        question = savedInstanceState.getParcelableArrayList("questionArrayList");
        index = savedInstanceState.getInt("questionIndex");
        for (int i = 0; i < question.size(); i++){
            if (question.get(i).submitClicked){
                tvQuestion.get(i).setVisibility(View.VISIBLE);
                rgQuestion.get(i).setVisibility(View.VISIBLE);
                btnSubmit.get(i).setVisibility(View.VISIBLE);
                for (int j = 0; j < rgQuestion.get(i).getChildCount(); j++) {
                    rgQuestion.get(i).getChildAt(j).setEnabled(false);
                }
                btnSubmit.get(i).setClickable(false);
                btnSubmit.get(i).setBackgroundColor(getResources().getColor(R.color.colorGray));
            } else {
                tvQuestion.get(i).setVisibility(View.VISIBLE);
                rgQuestion.get(i).setVisibility(View.VISIBLE);
                btnSubmit.get(i).setVisibility(View.VISIBLE);
                final int k = i;
                scrollView.post(new Runnable(){
                    public void run(){
                        scrollView.scrollTo(0, btnSubmit.get(k).getBottom());
                    }
                });
                break;
            }

        }
        if (question.get(question.size() - 1).submitClicked){
            btnResult.setVisibility(View.VISIBLE);
            scrollView.post(new Runnable(){
                public void run(){
                    int i = question.size() - 1;
                    scrollView.scrollTo(0, btnSubmit.get(i).getBottom());
                }
            });
        }
    }
}
