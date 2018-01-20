package com.example.android.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final ArrayList<QuizQuestion> question = new ArrayList<QuizQuestion>();
    int index = 0;

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
        final TextView tvQuestion = (TextView) findViewById(R.id.tv_question1);
        final RadioGroup rgQuestion = (RadioGroup) findViewById(R.id.rg_question1);
        final TextView rbAnswer1 = (TextView) findViewById(R.id.rb_answer1_1);
        final TextView rbAnswer2 = (TextView) findViewById(R.id.rb_answer1_2);
        final TextView rbAnswer3 = (TextView) findViewById(R.id.rb_answer1_3);
        final Button btnSubmit = (Button) findViewById(R.id.btn_submit1);

        // Dispaly texts
        tvQuestion.setText(question.get(index).getQuestion());
        rbAnswer1.setText(question.get(index).getAnswer1());
        rbAnswer2.setText(question.get(index).getAnswer2());
        rbAnswer3.setText(question.get(index).getAnswer3());


        // Submit button: submit answer
        // Save selected answer in question ArrayList
        // Show next question
        // Increase index
        // On last question open result activity
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rgQuestion.getCheckedRadioButtonId() == -1) {
                    // Answer is not selected
                    Toast.makeText(getBaseContext(), "Select answer!", Toast.LENGTH_SHORT).show();
                } else {
                    // Answer is selected
                    if (index < question.size()) {
                        // Save selected answer
                        int selectedRadioButtonID = rgQuestion.indexOfChild(findViewById(rgQuestion.getCheckedRadioButtonId()));
                        question.get(index).currentSelection = selectedRadioButtonID;
                        question.get(index).submitClicked = true;
                        // Check if selected answer is correct
                        if (question.get(index).currentSelection == question.get(index).getCorrectAnswer()){
                            question.get(index).selectedAnswerOK = true;
                        }
                        // Increase index
                        index++;
                        // Show next question
                        if (index < question.size()) {
                            rgQuestion.clearCheck();
                            tvQuestion.setText(question.get(index).getQuestion());
                            rbAnswer1.setText(question.get(index).getAnswer1());
                            rbAnswer2.setText(question.get(index).getAnswer2());
                            rbAnswer3.setText(question.get(index).getAnswer3());
                        }
                        if (index == question.size()){
                            // Open result activity
                            Intent resultIntent = new Intent (MainActivity.this, ResultActivity.class);
                            // Copy question ArrayList to result activity
                            resultIntent.putParcelableArrayListExtra("question", question );
                            startActivity(resultIntent);
                        }
                    } else
                        Toast.makeText(getBaseContext(), "All questions displayed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
