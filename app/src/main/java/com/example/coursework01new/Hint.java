package com.example.coursework01new;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class Hint extends AppCompatActivity{
    Button buttonSubmit,buttonNext;
    EditText textBoxInput;
    String inputLetter,brandName;
    TextView textViewOutput,correctNameText;

    ArrayList<String> dashesArray;
    ArrayList<String> namesArray;

    int wrongLetterCount,dashesCount;

    //Add images into array
    int images[] = {R.drawable.audi01,R.drawable.audi02,R.drawable.audi03,R.drawable.benz01,R.drawable.benz02,R.drawable.benz03,
            R.drawable.bmw01,R.drawable.bmw02,R.drawable.bmw03,R.drawable.ferrari01,R.drawable.ferrari02,R.drawable.ferrari03,
            R.drawable.jaguar01,R.drawable.jaguar02,R.drawable.jaguar03,R.drawable.kia01,R.drawable.kia02,R.drawable.kia03,
            R.drawable.nissan01,R.drawable.nissan02,R.drawable.nissan03,R.drawable.rr01,R.drawable.rr02,R.drawable.rr03,
            R.drawable.suzuki01,R.drawable.suzuki02,R.drawable.suzuki03,R.drawable.toyota01,R.drawable.toyota02,R.drawable.toyota03,};

    Random r = new Random();
    //get random image
    int randNum=r.nextInt(30);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //connect with hint XML file
        setContentView(R.layout.activity_hint);

        //create dashesArray
        dashesArray = new ArrayList<>();
        //create namesArray
        namesArray = new ArrayList<>();

        //pass image ID to variable
        ImageView imageView01 = findViewById(R.id.hintRandImage);
        //set random image to interface
        imageView01.setImageResource(images[randNum]);

        //pass text view ID to variable
        textViewOutput = findViewById(R.id.textHint);
        //pass text view ID to variable
        correctNameText = findViewById(R.id.textViewCorrectName);

        //call names and dashes arrays
        setNamesForArray();

        //set the same number of dashes as the car brand name to the text view
        for (int b=0; b<dashesArray.size(); b++){
            textViewOutput.setText(textViewOutput.getText()+dashesArray.get(b));
        }

        //pass submit button ID to variable
        buttonSubmit = findViewById(R.id.buttonSubmit);
        //pass next button ID to variable
        buttonNext = findViewById(R.id.buttonNextHint);
    }

    public void buttonHint(View view) {
        //pass edit text ID to variable
        textBoxInput = findViewById(R.id.edit_Dashes);

        //get user inputs with edit text
        inputLetter = textBoxInput.getText().toString().toLowerCase();

        String carBrandName = "";

        boolean isWrong = true;
        //get user inputs
        for (int a = 0; a < namesArray.size(); a++) {
            carBrandName = carBrandName + namesArray.get(a);
            brandName = carBrandName.toUpperCase();
            //check user input are correct
            if (inputLetter.equals(namesArray.get(a))) {
                //set input letter to dashes array
                dashesArray.set(a, inputLetter);
                isWrong = false;
            }
        }
        //calculate wrong answers submit count
        if (isWrong) {
            wrongLetterCount += 1;
        }

        //check wrong answers count and give chance to user submit another answer
        if(wrongLetterCount < 3) {
            String textName = "";
            //set user inputs and dashes to text view
            for (int b = 0; b <= dashesArray.size() - 1; b++) {
                textName = textName + dashesArray.get(b);
                textViewOutput.setText(textName.toUpperCase());
            }
        }
        //user enter 3 wrong answers
        else {
            //call wrong answers dialog box
            wrongAnswer();
            //set correct brand name to text view
            correctNameText.setText(brandName);

            //next button visible to user
            buttonNext.setVisibility(view.VISIBLE);
            //submit button invisible to user
            buttonSubmit.setVisibility(view.INVISIBLE);

            //edit text invisible to user
            textBoxInput.setVisibility(view.INVISIBLE);
            //text view visible to user
            correctNameText.setVisibility(view.VISIBLE);
        }

        dashesCount = 0;
        //calculate dashes count in text view to check user enter correct answer
        for (int a = 0; a < dashesArray.size(); a++) {
            if ("-".equals(dashesArray.get(a))) {
                dashesCount += 1;
            }
        }

        //if all letters submit correctly then action in below
        if (dashesCount==0){
            //call correct answer dialog box
            correctAnswer();

            //next button visible to user
            buttonNext.setVisibility(view.VISIBLE);
            //submit button invisible to user
            buttonSubmit.setVisibility(view.INVISIBLE);
            //edit text invisible to user
            textBoxInput.setVisibility(view.INVISIBLE);
        }
        //clear text in edit text
        textBoxInput.getText().clear();
    }

    //set elements to arrays
    public void setNamesForArray(){
        //check the vehicle random image to identify car brand
        if(randNum<=2){
            //Adding the letters of name to the namesArray
            namesArray.add("a");
            namesArray.add("u");
            namesArray.add("d");
            namesArray.add("i");

            //Adding the same number of dashes as the name to the array
            for (int i=0; i<4; i++){
                dashesArray.add("-");
            }

        }
        //check the vehicle random image to identify car brand
        else if (randNum>=3  && randNum<=5){
            //Adding the letters of name to the namesArray
            namesArray.add("b");
            namesArray.add("e");
            namesArray.add("n");
            namesArray.add("z");

            //Adding the same number of dashes as the name to the array
            for (int i=0; i<4; i++){
                dashesArray.add("-");
            }

        }
        //check the vehicle random image to identify car brand
        else if (randNum>=6  && randNum<=8){
            //Adding the letters of name to the namesArray
            namesArray.add("b");
            namesArray.add("m");
            namesArray.add("w");

            //Adding the same number of dashes as the name to the array
            for (int i=0; i<3; i++){
                dashesArray.add("-");
            }

        }
        //check the vehicle random image to identify car brand
        else if (randNum>=9  && randNum<=11){
            //Adding the letters of name to the namesArray
            namesArray.add("f");
            namesArray.add("e");
            namesArray.add("r");
            namesArray.add("r");
            namesArray.add("a");
            namesArray.add("r");
            namesArray.add("i");

            //Adding the same number of dashes as the name to the array
            for (int i=0; i<7; i++){
                dashesArray.add("-");
            }

        }
        //check the vehicle random image to identify car brand
        else if (randNum>=12  && randNum<=14){
            //Adding the letters of name to the namesArray
            namesArray.add("j");
            namesArray.add("a");
            namesArray.add("g");
            namesArray.add("u");
            namesArray.add("a");
            namesArray.add("r");

            //Adding the same number of dashes as the name to the array
            for (int i=0; i<6; i++){
                dashesArray.add("-");
            }

        }
        //check the vehicle random image to identify car brand
        else if (randNum>=15  && randNum<=17){
            //Adding the letters of name to the namesArray
            namesArray.add("k");
            namesArray.add("i");
            namesArray.add("a");

            //Adding the same number of dashes as the name to the array
            for (int i=0; i<3; i++){
                dashesArray.add("-");
            }

        }
        //check the vehicle random image to identify car brand
        else if (randNum>=18  && randNum<=20){
            //Adding the letters of name to the namesArray
            namesArray.add("n");
            namesArray.add("i");
            namesArray.add("s");
            namesArray.add("s");
            namesArray.add("a");
            namesArray.add("n");

            //Adding the same number of dashes as the name to the array
            for (int i=0; i<6; i++){
                dashesArray.add("-");
            }

        }
        //check the vehicle random image to identify car brand
        else if (randNum>=21  && randNum<=23){
            //Adding the letters of name to the namesArray
            namesArray.add("r");
            namesArray.add("e");
            namesArray.add("n");
            namesArray.add("a");
            namesArray.add("u");
            namesArray.add("l");
            namesArray.add("t");

            //Adding the same number of dashes as the name to the array
            for (int i=0; i<7; i++){
                dashesArray.add("-");
            }

        }
        //check the vehicle random image to identify car brand
        else if (randNum>=24  && randNum<=26){
            //Adding the letters of name to the namesArray
            namesArray.add("s");
            namesArray.add("u");
            namesArray.add("z");
            namesArray.add("u");
            namesArray.add("k");
            namesArray.add("i");

            //Adding the same number of dashes as the name to the array
            for (int i=0; i<6; i++){
                dashesArray.add("-");
            }

        }
        //check the vehicle random image to identify car brand
        else if (randNum>=27  && randNum<=29){
            //Adding the letters of name to the namesArray
            namesArray.add("t");
            namesArray.add("o");
            namesArray.add("y");
            namesArray.add("o");
            namesArray.add("t");
            namesArray.add("a");

            //Adding the same number of dashes as the name to the array
            for (int i=0; i<6; i++){
                dashesArray.add("-");
            }
        }
    }

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

    public void wrongAnswer(){
        //create message to dialog box
        String textWrong = "<font color='#BF0000'> WRONG! </font>"+brandName ;
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

    //method to next button
    public void buttonHintNext(View view) {
        //using finish to activity
        finish();

        //create a new object to start new activity
        Intent intent = new Intent(this, Hint.class);
        //pass object to startActivity
        startActivity(intent);
    }
}