package com.example.coursework01new;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class IdentifyTheCarImage extends AppCompatActivity {
    Button buttonCar01;
    TextView textView01;

    int touchCount = 0;

    //Add brand names into array
    String carBrandNamesArray[] = {"AUDI","BENZ","BMW","FERRARI","JAGUAR","KIA","NISSAN","RENAULT","SUZUKI","TOYOTA"};

    //Add images into array
    int images[] = {R.drawable.audi01,R.drawable.audi02,R.drawable.audi03,R.drawable.benz01,R.drawable.benz02,R.drawable.benz03,
            R.drawable.bmw01,R.drawable.bmw02,R.drawable.bmw03,R.drawable.ferrari01,R.drawable.ferrari02,R.drawable.ferrari03,
            R.drawable.jaguar01,R.drawable.jaguar02,R.drawable.jaguar03,R.drawable.kia01,R.drawable.kia02,R.drawable.kia03,
            R.drawable.nissan01,R.drawable.nissan02,R.drawable.nissan03,R.drawable.rr01,R.drawable.rr02,R.drawable.rr03,
            R.drawable.suzuki01,R.drawable.suzuki02,R.drawable.suzuki03,R.drawable.toyota01,R.drawable.toyota02,R.drawable.toyota03,};

    Random r = new Random();
    //get first random image
    int randImgNum1 = r.nextInt(8);
    //get second random image
    int randImgNum2 = randImgNum1+9;
    //get third random image
    int randImgNum3 = randImgNum2+12;

    //get random name
    int randomN = r.nextInt(3);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //connect with identify the car image XML file
        setContentView(R.layout.activity_identify_the_car_image);

        //call main logic to onCreate method
        imageIdentify();

        //pass next button ID to variable
        buttonCar01 = findViewById(R.id.button1);
    }

    //method to next button
    public void buttonImage(View view){
        //using finish to activity
        finish();

        //create a new object to start new activity
        Intent intent = new Intent(this, IdentifyTheCarImage.class);
        //pass object to startActivity method
        startActivity(intent);
    }

    //correct answers dialog box
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

    //wrong answers dialog box
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

    public void imageIdentify(){

        //pass first image ID to variable
        ImageView imageCar01 = findViewById(R.id.image1);
        //set first random image to interface
        imageCar01.setImageResource(images[randImgNum1]);

        //pass second image ID to variable
        ImageView imageCar02 = findViewById(R.id.image2);
        //set second random image to interface
        imageCar02.setImageResource(images[randImgNum2]);

        //pass third image ID to variable
        ImageView imageCar03 = findViewById(R.id.image3);
        //set third random image to interface
        imageCar03.setImageResource(images[randImgNum3]);

        //pass text view ID to variable
        textView01 = findViewById(R.id.text1);

        //check first image and choose random name
        if (randomN == 0){
            if(randImgNum1<=2){
                //get brand name with array
                String brand = carBrandNamesArray[0];
                //set brand name to text view
                textView01.setText(brand);
            }  else if (randImgNum1>=3  && randImgNum1<=5){
                //get brand name with array
                String brand = carBrandNamesArray[1];
                //set brand name to text view
                textView01.setText(brand);
            } else if (randImgNum1>=6  && randImgNum1<=8){
                //get brand name with array
                String brand = carBrandNamesArray[2];
                //set brand name to text view
                textView01.setText(brand);
            } else if (randImgNum1>=9  && randImgNum1<=11){
                //get brand name with array
                String brand = carBrandNamesArray[3];
                //set brand name to text view
                textView01.setText(brand);
            } else if (randImgNum1>=12  && randImgNum1<=14){
                //get brand name with array
                String brand = carBrandNamesArray[4];
                //set brand name to text view
                textView01.setText(brand);
            } else if (randImgNum1>=15  && randImgNum1<=17){
                //get brand name with array
                String brand = carBrandNamesArray[5];
                //set brand name to text view
                textView01.setText(brand);
            } else if (randImgNum1>=18  && randImgNum1<=20){
                //get brand name with array
                String brand = carBrandNamesArray[6];
                //set brand name to text view
                textView01.setText(brand);
            } else if (randImgNum1>=21  && randImgNum1<=23){
                //get brand name with array
                String brand = carBrandNamesArray[7];
                //set brand name to text view
                textView01.setText(brand);
            } else if (randImgNum1>=24  && randImgNum1<=26){
                //get brand name with array
                String brand = carBrandNamesArray[8];
                //set brand name to text view
                textView01.setText(brand);
            } else if (randImgNum1>=27  && randImgNum1<=29){
                //get brand name with array
                String brand = carBrandNamesArray[9];
                //set brand name to text view
                textView01.setText(brand);
            }
        }

        //check second image and choose random name
        if (randomN == 1){
            if(randImgNum2<=2){
                //get brand name with array
                String brand = carBrandNamesArray[0];
                //set brand name to text view
                textView01.setText(brand);
            }  else if (randImgNum2>=3  && randImgNum2<=5){
                //get brand name with array
                String brand = carBrandNamesArray[1];
                //set brand name to text view
                textView01.setText(brand);
            } else if (randImgNum2>=6  && randImgNum2<=8){
                //get brand name with array
                String brand = carBrandNamesArray[2];
                //set brand name to text view
                textView01.setText(brand);
            } else if (randImgNum2>=9  && randImgNum2<=11){
                //get brand name with array
                String brand = carBrandNamesArray[3];
                //set brand name to text view
                textView01.setText(brand);
            } else if (randImgNum2>=12  && randImgNum2<=14){
                //get brand name with array
                String brand = carBrandNamesArray[4];
                //set brand name to text view
                textView01.setText(brand);
            } else if (randImgNum2>=15  && randImgNum2<=17){
                //get brand name with array
                String brand = carBrandNamesArray[5];
                //set brand name to text view
                textView01.setText(brand);
            } else if (randImgNum2>=18  && randImgNum2<=20){
                //get brand name with array
                String brand = carBrandNamesArray[6];
                //set brand name to text view
                textView01.setText(brand);
            } else if (randImgNum2>=21  && randImgNum2<=23){
                //get brand name with array
                String brand = carBrandNamesArray[7];
                //set brand name to text view
                textView01.setText(brand);
            } else if (randImgNum2>=24  && randImgNum2<=26){
                //get brand name with array
                String brand = carBrandNamesArray[8];
                //set brand name to text view
                textView01.setText(brand);
            } else if (randImgNum2>=27  && randImgNum2<=29){
                //get brand name with array
                String brand = carBrandNamesArray[9];
                //set brand name to text view
                textView01.setText(brand);
            }
        }

        //check third image and choose random name
        if (randomN == 2){
            if(randImgNum3<=2){
                //get brand name with array
                String brand = carBrandNamesArray[0];
                //set brand name to text view
                textView01.setText(brand);
            }  else if (randImgNum3>=3  && randImgNum3<=5){
                //get brand name with array
                String brand = carBrandNamesArray[1];
                //set brand name to text view
                textView01.setText(brand);
            } else if (randImgNum3>=6  && randImgNum3<=8){
                //get brand name with array
                String brand = carBrandNamesArray[2];
                //set brand name to text view
                textView01.setText(brand);
            } else if (randImgNum3>=9  && randImgNum3<=11){
                //get brand name with array
                String brand = carBrandNamesArray[3];
                //set brand name to text view
                textView01.setText(brand);
            } else if (randImgNum3>=12  && randImgNum3<=14){
                //get brand name with array
                String brand = carBrandNamesArray[4];
                //set brand name to text view
                textView01.setText(brand);
            } else if (randImgNum3>=15  && randImgNum3<=17){
                //get brand name with array
                String brand = carBrandNamesArray[5];
                //set brand name to text view
                textView01.setText(brand);
            } else if (randImgNum3>=18  && randImgNum3<=20){
                //get brand name with array
                String brand = carBrandNamesArray[6];
                //set brand name to text view
                textView01.setText(brand);
            } else if (randImgNum3>=21  && randImgNum3<=23){
                //get brand name with array
                String brand = carBrandNamesArray[7];
                //set brand name to text view
                textView01.setText(brand);
            } else if (randImgNum3>=24  && randImgNum3<=26){
                //get brand name with array
                String brand = carBrandNamesArray[8];
                //set brand name to text view
                textView01.setText(brand);
            } else if (randImgNum3>=27  && randImgNum3<=29){
                //get brand name with array
                String brand = carBrandNamesArray[9];
                //set brand name to text view
                textView01.setText(brand);
            }
        }

        //set brand name to text view
        String brandName =(String) textView01.getText();

        //action to click first image
        imageCar01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //next button visible to user
                buttonCar01.setVisibility(v.VISIBLE);

                //image click count
                if (touchCount < 1){
                    //check random image
                    if (randImgNum1 <= 2) {
                        //check brand name with image
                        if (brandName == "AUDI") {
                            //call correct answer method
                            correctAnswer();
                        } else {
                            //call wrong answer method
                            wrongAnswer();
                        }
                    }

                    //check random image
                    if (randImgNum1 >= 3 && randImgNum1 <= 5) {
                        //check brand name with image
                        if (brandName == "BENZ") {
                            //call correct answer method
                            correctAnswer();
                        } else {
                            //call wrong answer method
                            wrongAnswer();
                        }
                    }

                    //check random image
                    if (randImgNum1 >= 6 && randImgNum1 <= 8) {
                        //check brand name with image
                        if (brandName == "BMW") {
                            //call correct answer method
                            correctAnswer();
                        } else {
                            //call wrong answer method
                            wrongAnswer();
                        }
                    }
                }
                //calculate image click count
                touchCount += 1;
            }
        });

        //action to click second image
        imageCar02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //next button visible to user
                buttonCar01.setVisibility(v.VISIBLE);

                //image click count
                if (touchCount < 1){
                    //check random image
                    if (randImgNum2 >= 9 && randImgNum2 <= 11) {
                        //check brand name with image
                        if (brandName == "FERRARI") {
                            //call correct answer method
                            correctAnswer();
                        } else {
                            //call wrong answer method
                            wrongAnswer();
                        }
                    }

                    //check random image
                    if (randImgNum2 >= 12 && randImgNum2 <= 14) {
                        //check brand name with image
                        if (brandName == "JAGUAR") {
                            //call correct answer method
                            correctAnswer();
                        } else {
                            //call wrong answer method
                            wrongAnswer();
                        }
                    }

                    //check random image
                    if (randImgNum2 >= 15 && randImgNum2 <= 17) {
                        //check brand name with image
                        if (brandName == "KIA") {
                            //call correct answer method
                            correctAnswer();
                        } else {
                            //call wrong answer method
                            wrongAnswer();
                        }
                    }
                }
                //calculate image click count
                touchCount += 1;
            }
        });

        //action to click third image
        imageCar03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //next button visible to user
                buttonCar01.setVisibility(v.VISIBLE);

                //image click count
                if (touchCount <1){
                    //check random image
                    if (randImgNum3 >= 18 && randImgNum3 <= 20) {
                        //check brand name with image
                        if (brandName == "NISSAN") {
                            //call correct answer method
                            correctAnswer();
                        } else {
                            //call wrong answer method
                            wrongAnswer();
                        }
                    }

                    //check random image
                    if (randImgNum3 >= 21 && randImgNum3 <= 23) {
                        //check brand name with image
                        if (brandName == "RENAULT") {
                            //call correct answer method
                            correctAnswer();
                        } else {
                            //call wrong answer method
                            wrongAnswer();
                        }
                    }

                    //check random image
                    if (randImgNum3 >= 24 && randImgNum3 <= 26) {
                        //check brand name with image
                        if (brandName == "SUZUKI") {
                            //call correct answer method
                            correctAnswer();
                        } else {
                            //call wrong answer method
                            wrongAnswer();
                        }
                    }

                    //check random image
                    if (randImgNum3 >= 27 && randImgNum3 <= 29) {
                        //check brand name with image
                        if (brandName == "TOYOTA") {
                            //call correct answer method
                            correctAnswer();
                        } else {
                            //call wrong answer method
                            wrongAnswer();
                        }
                    }
                }
                //calculate image click count
                touchCount += 1;
            }
        });
    }
}