package com.saisreenivas.inputcontrols.dogorcatperson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView resultText;
    private ImageView resultImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultText = (TextView) findViewById(R.id.resultText);
        resultImage = (ImageView) findViewById(R.id.resultImage);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            int dogCounter = extras.getInt("dogCounter");
            int catCounter = extras.getInt("catCounter");
            Log.v("extras", dogCounter +"" + catCounter);

            if(dogCounter > catCounter){
                resultText.setText("Dog Person");
                resultImage.setImageDrawable(getResources().getDrawable(R.drawable.dog_img));
            } else if(catCounter > dogCounter ){
                resultText.setText("Cat Person");
                resultImage.setImageDrawable(getResources().getDrawable(R.drawable.cat_img));
            } else {
                resultText.setText("Neither...");
            }
        }

    }
}
