package com.example.coursework01new;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    Button btIdentifyCarMake;
    Switch switchMain;

    boolean switchBool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //connect with main activity XML file
        setContentView(R.layout.activity_main);

        //pass switch button ID to variable
        switchMain = findViewById(R.id.switch1);
        //set action to switch button
        switchMain.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //switch on
                if (isChecked == true){
                    switchBool = true;
                }
                //switch off
                else {
                    switchBool = false;
                }
            }
        });

        //pass identify the car make button ID to variable
        btIdentifyCarMake = findViewById(R.id.button_Car_Make);
        //set action to identify the car make button
        btIdentifyCarMake.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                OpenIdentifyTheCarMake();
            }
        });

        //pass hints button ID to variable
        Button btHint = findViewById(R.id.button_Hints);
        //set action to hint button
        btHint.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openHints();
            }
        });

        //pass identify the car image button ID to variable
        Button btCarImage = findViewById(R.id.button_Car_Image);
        //set action to identify the car image button
        btCarImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openCarImage();
            }
        });

        //pass advanced level button ID to variable
        Button btAdvancedLevel = findViewById(R.id.button_Advanced_Level);
        //set action to advanced level button
        btAdvancedLevel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openAdvancedLevel();
            }
        });
    }

    //create new bundle for pass data between other activities
    Bundle bundle = new Bundle();

    //identify the car make button
    public void OpenIdentifyTheCarMake(){
        //create a new object to start new activity
        Intent intent = new Intent(this, IdentifyTheCarMake.class);
        //put boolean in to bundle
        bundle.putBoolean("switch",switchBool);
        //put bundle into intent object
        intent.putExtras(bundle);
        //pass object to startActivity method
        startActivity(intent);
    }

    //hints button
    public void openHints(){
        //create a new object to start new activity
        Intent intent = new Intent(this, Hint.class);
        //put boolean in to bundle
        bundle.putBoolean("switch",switchBool);
        //put bundle into intent object
        intent.putExtras(bundle);
        //pass object to startActivity method
        startActivity(intent);
    }

    //identify the car image button
    public void openCarImage(){
        //create a new object to start new activity
        Intent intent = new Intent(this, IdentifyTheCarImage.class);
        //put boolean in to bundle
        bundle.putBoolean("switch",switchBool);
        //put bundle into intent object
        intent.putExtras(bundle);
        //pass object to startActivity method
        startActivity(intent);
    }

    //advanced level button
    public void openAdvancedLevel(){
        //create a new object to start new activity
        Intent intent = new Intent(this, AdvancedLevel.class);
        //put boolean in to bundle
        bundle.putBoolean("switch",switchBool);
        //put bundle into intent object
        intent.putExtras(bundle);
        //pass object to startActivity method
        startActivity(intent);
    }


}