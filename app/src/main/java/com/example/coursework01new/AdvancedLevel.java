package com.example.coursework01new;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class AdvancedLevel extends AppCompatActivity {

    Button buttonAdvancedSubmit,buttonAdvancedNext;
    ImageView imageCar01,imageCar02,imageCar03;
    EditText textImage01,textImage02,textImage03;
    TextView textCorrect01,textCorrect02,textCorrect03,textScore;

    int wrongCount = 0;
    int points;

    String correctName = " ";

    //Add images into array
    int images[] = {R.drawable.audi01,R.drawable.audi02,R.drawable.audi03,R.drawable.benz01,R.drawable.benz02,R.drawable.benz03,
            R.drawable.bmw01,R.drawable.bmw02,R.drawable.bmw03,R.drawable.ferrari01,R.drawable.ferrari02,R.drawable.ferrari03,
            R.drawable.jaguar01,R.drawable.jaguar02,R.drawable.jaguar03,R.drawable.kia01,R.drawable.kia02,R.drawable.kia03,
            R.drawable.nissan01,R.drawable.nissan02,R.drawable.nissan03,R.drawable.rr01,R.drawable.rr02,R.drawable.rr03,
            R.drawable.suzuki01,R.drawable.suzuki02,R.drawable.suzuki03,R.drawable.toyota01,R.drawable.toyota02,R.drawable.toyota03,};

    Random r = new Random();
    //get first random image
    int randImgNum1 = r.nextInt(22);
    //get second random image
    int randImgNum2 = randImgNum1+3;
    //get third random image
    int randImgNum3 = randImgNum2+3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //connect with advanced level XML file
        setContentView(R.layout.activity_advanced_level);

        //pass first image ID to variable
        imageCar01 = findViewById(R.id.imageViewAdvanced1);
        //set first random image to interface
        imageCar01.setImageResource(images[randImgNum1]);

        //pass second image ID to variable
        imageCar02 = findViewById(R.id.imageViewAdvanced2);
        //set second random image to interface
        imageCar02.setImageResource(images[randImgNum2]);

        //pass third image ID to variable
        imageCar03 = findViewById(R.id.imageViewAdvanced3);
        //set third random image to interface
        imageCar03.setImageResource(images[randImgNum3]);

        //pass third text view ID to variable
        textScore = findViewById(R.id.textViewPoints);

        //pass third button ID to variable
        buttonAdvancedSubmit = findViewById(R.id.buttonAdvanced);
        //pass third button ID to variable
        buttonAdvancedNext = findViewById(R.id.buttonAdvancedNext);
    }

    public void advancedLevel(View view) {
        wrongCount +=1 ;

        //call logic method to button
        advancedLogic();

        //when user enter all correct answers
        if (points==3){
            //call correct answers dialog box
            correctAnswer();

            //next button visible to user
            buttonAdvancedNext.setVisibility(view.VISIBLE);
            //submit button invisible to user
            buttonAdvancedSubmit.setVisibility(view.INVISIBLE);

            //first edit text convert uneditable
            textImage01.setEnabled(false);
            //second edit text convert uneditable
            textImage02.setEnabled(false);
            //third edit text convert uneditable
            textImage03.setEnabled(false);

            //if user enter all answers are correct then set score to text view
            textScore.setText("3");
        }

        //when user enter wrong answer
        else if (wrongCount==3){
            //call wrong answers dialog box
            wrongAnswer();

            //next button visible to user
            buttonAdvancedNext.setVisibility(view.VISIBLE);
            //submit button invisible to user
            buttonAdvancedSubmit.setVisibility(view.INVISIBLE);

            //if user enter wrong answer to first image then user can visible this text box
            textCorrect01.setVisibility(view.VISIBLE);
            //if user enter wrong answer to second image then user can visible this text box
            textCorrect02.setVisibility(view.VISIBLE);
            //if user enter wrong answer to third image then user can visible this text box
            textCorrect03.setVisibility(view.VISIBLE);

            //answer is wrong but first edit text convert uneditable
            textImage01.setEnabled(false);
            //answer is wrong but second edit text convert uneditable
            textImage02.setEnabled(false);
            //answer is wrong but third edit text convert uneditable
            textImage03.setEnabled(false);

            //if user enter only two correct answers then set score in to text view
            if (points == 2){
                textScore.setText("2/3");
            }
            //if user enter only one correct answers then set score in to text view
            else if (points == 1){
                textScore.setText("1/3");
            }
            //if user enter all answers are wrong then set score in to text view
            else {
                textScore.setText("0");
            }
        }
    }

    //dialog box for correct answers
    public void correctAnswer(){
        //build new object in dialog box
        AlertDialog.Builder dialogBoxAns = new AlertDialog.Builder(this);
        //set title to dialog box
        dialogBoxAns.setTitle("Results");
        //set correct message to dialog box
        dialogBoxAns.setMessage((Html.fromHtml("<font color='#39FF14'> CORRECT!  </font>  ")));
        //set button to dialog box
        dialogBoxAns.setPositiveButton("OK",  null);
        //create new dialog box
        AlertDialog dialog = dialogBoxAns.create();
        dialog.show();
    }

    //dialog box for wrong answers
    public void wrongAnswer(){
        //create message to dialog box
        String textWrong = "<font color='#BF0000'> WRONG! </font>" ;
        //build new object in dialog box
        AlertDialog.Builder dialogBoxAns = new AlertDialog.Builder(this);
        //set title to dialog box
        dialogBoxAns.setTitle("Results");
        //set wrong message to dialog box
        dialogBoxAns.setMessage((Html.fromHtml(textWrong)));
        //set button to dialog box
        dialogBoxAns.setPositiveButton("OK", null);
        //create new dialog box
        AlertDialog dialog = dialogBoxAns.create();
        dialog.show();
    }

    //advance level class main logic
    public void advancedLogic(){
        points=0;

        //pass first edit text ID to variable
        textImage01 = findViewById(R.id.editImage01);
        //pass second edit text ID to variable
        textImage02 = findViewById(R.id.editImage02);
        //pass third edit text ID to variable
        textImage03 = findViewById(R.id.editImage03);

        //pass first text view ID to variable
        textCorrect01 = findViewById(R.id.textViewAdvanced01);
        //pass second text view ID to variable
        textCorrect02 = findViewById(R.id.textViewAdvanced02);
        //pass third text view ID to variable
        textCorrect03 = findViewById(R.id.textViewAdvanced03);

        //get user input with first edit text and convert it to capital letters
        String guessName01 = textImage01.getText().toString().toUpperCase();
        //get user input with second edit text and convert it to capital letters
        String guessName02 = textImage02.getText().toString().toUpperCase();
        //get user input with third edit text and convert it to capital letters
        String guessName03 = textImage03.getText().toString().toUpperCase();

        //check first image and first edit text
        if (randImgNum1 <= 2 && guessName01.equals("AUDI")) {
            correctAns01();
            //calculate points
            points+=1;
        } else if (randImgNum1 <= 2 && !guessName01.contentEquals("AUDI")) {
            //call variable to correct car name
            correctName = "<font color=#fefe22>AUDI</font>";
            wrongAns01();
        } else if (randImgNum1 > 2 && randImgNum1 <= 5 && guessName01.equals("BENZ")) {
            correctAns01();
            //calculate points
            points+=1;
        } else if (randImgNum1 > 2 && randImgNum1 <= 5 && !guessName01.contentEquals("BENZ")) {
            //call variable to correct car name
            correctName = "<font color=#fefe22>BENZ</font>";
            wrongAns01();
        } else if (randImgNum1 > 5 && randImgNum1 <= 8 && guessName01.equals("BMW")) {
            correctAns01();
            //calculate points
            points+=1;
        } else if (randImgNum1 > 5 && randImgNum1 <= 8 && !guessName01.contentEquals("BMW")) {
            //call variable to correct car name
            correctName = "<font color=#fefe22>BMW</font>";
            wrongAns01();
        } else if (randImgNum1 > 8 && randImgNum1 <= 11 && guessName01.equals("FERRARI")) {
            correctAns01();
            //calculate points
            points+=1;
        } else if (randImgNum1 > 8 && randImgNum1 <= 11 && !guessName01.contentEquals("FERRARI")) {
            //call variable to correct car name
            correctName = "<font color=#fefe22>FERRARI</font>";
            wrongAns01();
        } else if (randImgNum1 > 11 && randImgNum1 <= 14 && guessName01.equals("JAGUAR")) {
            correctAns01();
            //calculate points
            points+=1;
        } else if (randImgNum1 > 11 && randImgNum1 <= 14 && !guessName01.contentEquals("JAGUAR")) {
            //call variable to correct car name
            correctName = "<font color=#fefe22>JAGUAR</font>";
            wrongAns01();
        } else if (randImgNum1 > 14 && randImgNum1 <= 17 && guessName01.equals("KIA")) {
            correctAns01();
            //calculate points
            points+=1;
        } else if (randImgNum1 > 14 && randImgNum1 <= 17 && !guessName01.contentEquals("KIA")) {
            //call variable to correct car name
            correctName = "<font color=#fefe22>KIA</font>";
            wrongAns01();
        } else if (randImgNum1 > 17 && randImgNum1 <= 20 && guessName01.equals("NISSAN")) {
            correctAns01();
            //calculate points
            points+=1;
        } else if (randImgNum1 > 17 && randImgNum1 <= 20 && !guessName01.contentEquals("NISSAN")) {
            //call variable to correct car name
            correctName = "<font color=#fefe22>NISSAN</font>";
            wrongAns01();
        } else if (randImgNum1 > 20 && randImgNum1 <= 23 && guessName01.equals("RENAULT")) {
            correctAns01();
            //calculate points
            points+=1;
        } else if (randImgNum1 > 20 && randImgNum1 <= 23 && !guessName01.contentEquals("RENAULT")) {
            //call variable to correct car name
            correctName = "<font color=#fefe22>RENAULT</font>";
            wrongAns01();
        } else if (randImgNum1 > 23 && randImgNum1 <= 26 && guessName01.equals("SUZUKI")) {
            correctAns01();
            //calculate points
            points+=1;
        } else if (randImgNum1 > 23 && randImgNum1 <= 26 && !guessName01.contentEquals("SUZUKI")) {
            //call variable to correct car name
            correctName = "<font color=#fefe22>SUZUKI</font>";
            wrongAns01();
        } else if (randImgNum1 > 26 && randImgNum1 <= 29 && guessName01.equals("TOYOTA")) {
            correctAns01();
            //calculate points
            points+=1;
        } else if (randImgNum1 > 26 && randImgNum1 <= 29 && !guessName01.contentEquals("TOYOTA")) {
            //call variable to correct car name
            correctName = "<font color=#fefe22>TOYOTA</font>";
            wrongAns01();
        }

        //check second image and second edit text
        if (randImgNum2 <= 2 && guessName02.equals("AUDI")) {
            correctAns02();
            //calculate points
            points+=1;
        } else if (randImgNum2 <= 2 && !guessName02.contentEquals("AUDI")) {
            //call variable to correct car name
            correctName = "<font color=#fefe22>AUDI</font>";
            wrongAns02();
        } else if (randImgNum2 > 2 && randImgNum2 <= 5 && guessName02.equals("BENZ")) {
            correctAns02();
            //calculate points
            points+=1;
        } else if (randImgNum2 > 2 && randImgNum2 <= 5 && !guessName02.contentEquals("BENZ")) {
            //call variable to correct car name
            correctName = "<font color=#fefe22>BENZ</font>";
            wrongAns02();
        } else if (randImgNum2 > 5 && randImgNum2 <= 8 && guessName02.equals("BMW")) {
            correctAns02();
            //calculate points
            points+=1;
        } else if (randImgNum2 > 5 && randImgNum2 <= 8 && !guessName02.contentEquals("BMW")) {
            //call variable to correct car name
            correctName = "<font color=#fefe22>BMW</font>";
            wrongAns02();
        } else if (randImgNum2 > 8 && randImgNum2 <= 11 && guessName02.equals("FERRARI")) {
            correctAns02();
            //calculate points
            points+=1;
        } else if (randImgNum2 > 8 && randImgNum2 <= 11 && !guessName02.contentEquals("FERRARI")) {
            //call variable to correct car name
            correctName = "<font color=#fefe22>FERRARI</font>";
            wrongAns02();
        } else if (randImgNum2 > 11 && randImgNum2 <= 14 && guessName02.equals("JAGUAR")) {
            correctAns02();
            //calculate points
            points+=1;
        } else if (randImgNum2 > 11 && randImgNum2 <= 14 && !guessName02.contentEquals("JAGUAR")) {
            //call variable to correct car name
            correctName = "<font color=#fefe22>JAGUAR</font>";
            wrongAns02();
        } else if (randImgNum2 > 14 && randImgNum2 <= 17 && guessName02.equals("KIA")) {
            correctAns02();
            //calculate points
            points+=1;
        } else if (randImgNum2 > 14 && randImgNum2 <= 17 && !guessName02.contentEquals("KIA")) {
            //call variable to correct car name
            correctName = "<font color=#fefe22>KIA</font>";
            wrongAns02();
        } else if (randImgNum2 > 17 && randImgNum2 <= 20 && guessName02.equals("NISSAN")) {
            correctAns02();
            //calculate points
            points+=1;
        } else if (randImgNum2 > 17 && randImgNum2 <= 20 && !guessName02.contentEquals("NISSAN")) {
            //call variable to correct car name
            correctName = "<font color=#fefe22>NISSAN</font>";
            wrongAns02();
        } else if (randImgNum2 > 20 && randImgNum2 <= 23 && guessName02.equals("RENAULT")) {
            correctAns02();
            //calculate points
            points+=1;
        } else if (randImgNum2 > 20 && randImgNum2 <= 23 && !guessName02.contentEquals("RENAULT")) {
            //call variable to correct car name
            correctName = "<font color=#fefe22>RENAULT</font>";
            wrongAns02();
        } else if (randImgNum2 > 23 && randImgNum2 <= 26 && guessName02.equals("SUZUKI")) {
            correctAns02();
            //calculate points
            points+=1;
        } else if (randImgNum2 > 23 && randImgNum2 <= 26 && !guessName02.contentEquals("SUZUKI")) {
            //call variable to correct car name
            correctName = "<font color=#fefe22>SUZUKI</font>";
            wrongAns02();
        } else if (randImgNum2 > 26 && randImgNum2 <= 29 && guessName02.equals("TOYOTA")) {
            correctAns02();
            //calculate points
            points+=1;
        } else if (randImgNum2 > 26 && randImgNum2 <= 29 && !guessName02.contentEquals("TOYOTA")) {
            //call variable to correct car name
            correctName = "<font color=#fefe22>TOYOTA</font>";
            wrongAns02();
        }

        //check third image and third edit text
        if (randImgNum3 <= 2 && guessName03.equals("AUDI")) {
            correctAns03();
            //calculate points
            points+=1;
        } else if (randImgNum3 <= 2 && !guessName03.contentEquals("AUDI")) {
            //call variable to correct car name
            correctName = "<font color=#fefe22>AUDI</font>";
            wrongAns03();
        } else if (randImgNum3 > 2 && randImgNum3 <= 5 && guessName03.equals("BENZ")) {
            correctAns03();
            //calculate points
            points+=1;
        } else if (randImgNum3 > 2 && randImgNum3 <= 5 && !guessName03.contentEquals("BENZ")) {
            //call variable to correct car name
            correctName = "<font color=#fefe22>BENZ</font>";
            wrongAns03();
        } else if (randImgNum3 > 5 && randImgNum3 <= 8 && guessName03.equals("BMW")) {
            correctAns03();
            //calculate points
            points+=1;
        } else if (randImgNum3 > 5 && randImgNum3 <= 8 && !guessName03.contentEquals("BMW")) {
            //call variable to correct car name
            correctName = "<font color=#fefe22>BMW</font>";
            wrongAns03();
        } else if (randImgNum3 > 8 && randImgNum3 <= 11 && guessName03.equals("FERRARI")) {
            correctAns03();
            //calculate points
            points+=1;
        } else if (randImgNum3 > 8 && randImgNum3 <= 11 && !guessName03.contentEquals("FERRARI")) {
            //call variable to correct car name
            correctName = "<font color=#fefe22>FERRARI</font>";
            wrongAns03();
        } else if (randImgNum3 > 11 && randImgNum3 <= 14 && guessName03.equals("JAGUAR")) {
            correctAns03();
            //calculate points
            points+=1;
        } else if (randImgNum3 > 11 && randImgNum3 <= 14 && !guessName03.contentEquals("JAGUAR")) {
            //call variable to correct car name
            correctName = "<font color=#fefe22>JAGUAR</font>";
            wrongAns03();
        } else if (randImgNum3 > 14 && randImgNum3 <= 17 && guessName03.equals("KIA")) {
            correctAns03();
            //calculate points
            points+=1;
        } else if (randImgNum3 > 14 && randImgNum3 <= 17 && !guessName03.contentEquals("KIA")) {
            //call variable to correct car name
            correctName = "<font color=#fefe22>KIA</font>";
            wrongAns03();
        } else if (randImgNum3 > 17 && randImgNum3 <= 20 && guessName03.equals("NISSAN")) {
            correctAns03();
            //calculate points
            points+=1;
        } else if (randImgNum3 > 17 && randImgNum3 <= 20 && !guessName03.contentEquals("NISSAN")) {
            //call variable to correct car name
            correctName = "<font color=#fefe22>NISSAN</font>";
            wrongAns03();
        } else if (randImgNum3 > 20 && randImgNum3 <= 23 && guessName03.equals("RENAULT")) {
            correctAns03();
            //calculate points
            points+=1;
        } else if (randImgNum3 > 20 && randImgNum3 <= 23 && !guessName03.contentEquals("RENAULT")) {
            //call variable to correct car name
            correctName = "<font color=#fefe22>RENAULT</font>";
            wrongAns03();
        } else if (randImgNum3 > 23 && randImgNum3 <= 26 && guessName03.equals("SUZUKI")) {
            correctAns03();
            //calculate points
            points+=1;
        } else if (randImgNum3 > 23 && randImgNum3 <= 26 && !guessName03.contentEquals("SUZUKI")) {
            //call variable to correct car name
            correctName = "<font color=#fefe22>SUZUKI</font>";
            wrongAns03();
        } else if (randImgNum3 > 26 && randImgNum3 <= 29 && guessName03.equals("TOYOTA")) {
            correctAns03();
            //calculate points
            points+=1;
        } else if (randImgNum3 > 26 && randImgNum3 <= 29 && !guessName03.contentEquals("TOYOTA")) {
            //call variable to correct car name
            correctName = "<font color=#fefe22>TOYOTA</font>";
            wrongAns03();
        }
    }


    //method to correct answer in first edit text
    public void correctAns01(){
        //set first edit text text color to green
        textImage01.setTextColor(Color.parseColor("#008000"));
        //set edit text color to green
        textImage01.getBackground().setColorFilter(Color.parseColor("#008000"), PorterDuff.Mode.SRC_ATOP);
        //set edit text to uneditable
        textImage01.setEnabled(false);
        //set empty text to text view
        textCorrect01.setText(" ");
    }

    //method to correct answer in second edit text
    public void correctAns02(){
        //set second edit text text color to green
        textImage02.setTextColor(Color.parseColor("#008000"));
        //set edit text color to green
        textImage02.getBackground().setColorFilter(Color.parseColor("#008000"), PorterDuff.Mode.SRC_ATOP);
        //set edit text to uneditable
        textImage02.setEnabled(false);
        //set empty text to text view
        textCorrect02.setText(" ");
    }

    //method to correct answer in third edit text
    public void correctAns03(){
        //set third edit text text color to green
        textImage03.setTextColor(Color.parseColor("#008000"));
        //set edit text color to green
        textImage03.getBackground().setColorFilter(Color.parseColor("#008000"), PorterDuff.Mode.SRC_ATOP);
        //set edit text to uneditable
        textImage03.setEnabled(false);
        //set empty text to text view
        textCorrect03.setText(" ");
    }

    //method to wrong answer in first edit text
    public void wrongAns01(){
        //set first edit text text color to red
        textImage01.setTextColor(Color.RED);
        //set first edit text color to red
        textImage01.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
        //set correct car name to text view
        textCorrect01.setText(Html.fromHtml(correctName));
    }

    //method to wrong answer in second edit text
    public void wrongAns02(){
        //set second edit text text color to red
        textImage02.setTextColor(Color.RED);
        //set second edit text color to red
        textImage02.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
        //set correct car name to text view
        textCorrect02.setText(Html.fromHtml(correctName));
    }

    //method to wrong answer in third edit text
    public void wrongAns03(){
        //set third edit text text color to red
        textImage03.setTextColor(Color.RED);
        //set third edit text color to red
        textImage03.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
        //set correct car name to text view
        textCorrect03.setText(Html.fromHtml(correctName));
    }

    //method to next button
    public void advancedLevelNext(View view) {
        //using finish to activity
        finish();

        //create a new object to start new activity
        Intent intent = new Intent(this, AdvancedLevel.class);
        //pass object to startActivity
        startActivity(intent);
    }
}