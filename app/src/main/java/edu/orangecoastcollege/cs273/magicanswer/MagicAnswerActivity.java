package edu.orangecoastcollege.cs273.magicanswer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MagicAnswerActivity extends AppCompatActivity {

    MagicAnswer magicAnswer;
    private TextView answerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magic_answer);

        // TASK 1: SET THE REFERENCES TO THE LAYOUT ELEMENTS
        answerTextView = (TextView) findViewById(R.id.answerTextView);

        // TASK 2: CREATE A NEW MAGIC ANSWER OBJECT

        // TASK 3: REGISTER THE SENSOR MANAGER AND SETUP THE SHAKE DETECTION

    }


}
