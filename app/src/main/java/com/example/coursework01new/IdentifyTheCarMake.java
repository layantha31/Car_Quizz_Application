package com.example.coursework01new;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.Random;

public class IdentifyTheCarMake extends AppCompatActivity {

    String vehBrandName="";
    private Button buttonChange,buttonNext;

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
        //connect with identify the car make XML file
        setContentView(R.layout.activity_identify_the_car_make);

        //pass image ID to variable
        ImageView imageView01 = findViewById(R.id.randImage);
        //set random image to interface
        imageView01.setImageResource(images[randNum]);

        //create spinner to select items from drop down menu
        Spinner spinner = findViewById(R.id.dropDown01);
        //create array adapter to  data from the data sources display in to interface
        ArrayAdapter<String> adapter = new ArrayAdapter(IdentifyTheCarMake.this, android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.brands));
        //set items to array adapter
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //set adapter to spinner to read data in string xml
        spinner.setAdapter(adapter);

        //pass identify button ID to variable
        buttonChange = findViewById(R.id.button);
        //pass next button ID to variable
        buttonNext = findViewById(R.id.buttonNextMake);
    }

    //action to identify button
    public void button(View v) {

        //call chooseImage method
        chooseImage();

        //next button visible to user
        buttonNext.setVisibility(v.VISIBLE);
        //submit button invisible to user
        buttonChange.setVisibility(v.INVISIBLE);
    }

    //correct answer dialog box
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

    //wrong answer dialog box
    public void wrongAnswer(){
        //create message to dialog box
        String textWrong = "<font color='#BF0000'> WRONG! </font>" +"It is a " +vehBrandName+ " car";
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

    //choose image method
    public void chooseImage(){
        //pass dropDown menu ID to variable
        Spinner mySpinnerDropDown = findViewById(R.id.dropDown01);
        //get dropDown menu items to string
        String answerText = mySpinnerDropDown.getSelectedItem().toString();

        //check random image
        if(randNum<=2){
            //set brand name to string variable
            vehBrandName= ("<font color='#f5c71a'> AUDI  </font>  ");
        }  else if (randNum>=3  && randNum<=5){
            //set brand name to string variable
            vehBrandName= ("<font color='#f5c71a'> BENZ  </font>  ");
        } else if (randNum>=6  && randNum<=8){
            //set brand name to string variable
            vehBrandName= ("<font color='#f5c71a'> BMW  </font>  ");
        } else if (randNum>=9  && randNum<=11){
            //set brand name to string variable
            vehBrandName= ("<font color='#f5c71a'> FERRARI  </font>  ");
        } else if (randNum>=12  && randNum<=14){
            //set brand name to string variable
            vehBrandName= ("<font color='#f5c71a'> JAGUAR  </font>  ");
        } else if (randNum>=15  && randNum<=17){
            //set brand name to string variable
            vehBrandName= ("<font color='#f5c71a'> KIA  </font>  ");
        } else if (randNum>=18  && randNum<=20){
            //set brand name to string variable
            vehBrandName= ("<font color='#f5c71a'> NISSAN  </font>  ");
        } else if (randNum>=21  && randNum<=23){
            //set brand name to string variable
            vehBrandName= ("<font color='#f5c71a'> RENAULT  </font>  ");
        } else if (randNum>=24  && randNum<=26){
            //set brand name to string variable
            vehBrandName= ("<font color='#f5c71a'> SUZUKI  </font>  ");
        } else if (randNum>=27  && randNum<=29){
            //set brand name to string variable
            vehBrandName= ("<font color='#f5c71a'> TOYOTA  </font>  ");
        }

        //check user selected brand name
        if (answerText.equals("Audi")) {
            //check displayed image
            if(randNum<=2){
                //if user select correct item display correct answer dialog box
                correctAnswer();
            }
            else{
                //if user select wrong item display wrong answer dialog box
                wrongAnswer();
            }
        }
        //check user selected brand name
        else if (answerText.equals("Benz")) {
            //check displayed image
            if(randNum>=3  && randNum<=5){
                //if user select correct item display correct answer dialog box
                correctAnswer();
            }
            else {
                //if user select wrong item display wrong answer dialog box
                wrongAnswer();
            }
        }
        //check user selected brand name
        else if (answerText.equals("BMW")) {
            //check displayed image
            if(randNum>=6  && randNum<=8) {
                //if user select correct item display correct answer dialog box
                correctAnswer();
            }
            else{
                //if user select wrong item display wrong answer dialog box
                wrongAnswer();
            }
        }
        //check user selected brand name
        else if (answerText.equals("Ferrari")) {
            //check displayed image
            if(randNum>=9  && randNum<=11){
                //if user select correct item display correct answer dialog box
                correctAnswer();
            }
            else{
                //if user select wrong item display wrong answer dialog box
                wrongAnswer();
            }
        }
        //check user selected brand name
        else if (answerText.equals("Jaguar")) {
            //check displayed image
            if(randNum>=12  && randNum<=14){
                //if user select correct item display correct answer dialog box
                correctAnswer();
            }
            else{
                //if user select wrong item display wrong answer dialog box
                wrongAnswer();
            }
        }
        //check user selected brand name
        else if (answerText.equals("Kia")) {
            //check displayed image
            if(randNum>=15  && randNum<=17){
                //if user select correct item display correct answer dialog box
                correctAnswer();
            }
            else{
                //if user select wrong item display wrong answer dialog box
                wrongAnswer();
            }
        }
        //check user selected brand name
        else if (answerText.equals("Nissan")) {
            //check displayed image
            if(randNum>=18  && randNum<=20){
                //if user select correct item display correct answer dialog box
                correctAnswer();
            }
            else{
                //if user select wrong item display wrong answer dialog box
                wrongAnswer();
            }
        }
        //check user selected brand name
        else if (answerText.equals("Renault")) {
            //check displayed image
            if(randNum>=21  && randNum<=23){
                //if user select correct item display correct answer dialog box
                correctAnswer();
            }
            else{
                //if user select wrong item display wrong answer dialog box
                wrongAnswer();
            }
        }
        //check user selected brand name
        else if (answerText.equals("Suzuki")) {
            //check displayed image
            if(randNum>=24  && randNum<=26){
                //if user select correct item display correct answer dialog box
                correctAnswer();
            }
            else{
                //if user select wrong item display wrong answer dialog box
                wrongAnswer();
            }
        }
        //check user selected brand name
        else if (answerText.equals("Toyota")) {
            //check displayed image and
            if(randNum>=27  && randNum<=29){
                //if user select correct item display correct answer dialog box
                correctAnswer();
            }
            else{
                //if user select wrong item display wrong answer dialog box
                wrongAnswer();
            }
        }
    }

    //method to next button
    public void buttonNextMake(View v) {
        //using finish to activity
        finish();

        //create a new object to start new activity
        Intent intent = new Intent(this, IdentifyTheCarMake.class);
        //pass object to startActivity method
        startActivity(intent);
    }
}