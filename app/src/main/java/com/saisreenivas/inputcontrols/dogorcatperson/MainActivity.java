package com.saisreenivas.inputcontrols.dogorcatperson;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private RadioGroup radioGroupCanine, radioGroupDrool;
    private SeekBar seekBar;
    private TextView seekBarTextView;
    private CheckBox dogCheck,catCheck,parrotCheck;
    private Button resultButton;
    int dogCounter;
    int catCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUp();

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarTextView.setText("Comfortableness: " + progress + "/" + seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarTextView.setText("Comfortableness: " + seekBar.getProgress() + "/" + seekBar.getMax());
    }

    public void setUp(){
        dogCounter = 0;
        catCounter = 0;

        seekBarTextView = (TextView) findViewById(R.id.seekBarValue);
        radioGroupDrool = (RadioGroup) findViewById(R.id.radioGroupDrool);
        radioGroupCanine = (RadioGroup) findViewById(R.id.radioGroupFenine);

        catCheck = (CheckBox) findViewById(R.id.catCheck);
        parrotCheck = (CheckBox) findViewById(R.id.parrotCheck);
        dogCheck = (CheckBox) findViewById(R.id.dogCheck);

        //Call Methods
        Drool(radioGroupDrool);
        Canine(radioGroupCanine);
//        processCutest(dogCheck, catCheck, parrotCheck);

        resultButton = (Button) findViewById(R.id.resultBtn);
        resultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Drool(radioGroupDrool);
//                Canine(radioGroupCanine);
                processCutest(dogCheck, catCheck, parrotCheck);

                Intent i  = new Intent(MainActivity.this, ResultActivity.class);
                i.putExtra("catCounter", catCounter);
                i.putExtra("dogCounter", dogCounter);
                startActivity(i);
            }
        });
    }

    public void processCutest(CheckBox dogCheck, CheckBox catCheck, CheckBox parrotCheck){

        if(dogCheck.isChecked() && !catCheck.isChecked() && !parrotCheck.isChecked()){
            dogCounter += 5;
            Log.v("Cutest", dogCounter + " " + catCounter);
        }
        if(catCheck.isChecked() && !dogCheck.isChecked() && !parrotCheck.isChecked()){
            catCounter += 5;
            Log.v("Cutest", dogCounter + " " + catCounter);
        }
        else{
            //nothing should be done.
        }

    }

    public void Canine(RadioGroup radioGroupCanine){

        radioGroupCanine.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int radioBtnId = checkedId;
                RadioButton radioButton = (RadioButton) findViewById(radioBtnId);
                if(radioButton.getText().equals("Yes")){
                    dogCounter += 5;
                    Log.v("Canine", dogCounter + " " + catCounter);
                }
            }
        });
    }

    public void Drool(RadioGroup radioGroupDrool){

        radioGroupDrool.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int radioBtnId = checkedId;
                RadioButton radioButton = (RadioButton) findViewById(radioBtnId);
                if(radioButton.getText().equals("Yes")){
                    catCounter += 5;
                    Log.v("Drool", dogCounter + " " + catCounter);
                }
            }
        });
    }
}
