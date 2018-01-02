package com.example.ashraf.survey;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class QuardViewShow extends AppCompatActivity {
    private TextView squareText,percentageText,totalLandText;
    private double squareDouble,percentageDouble,totalLandDouble;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quard_view_show);

        squareText= (TextView) findViewById(R.id.SqueView);
        percentageText = (TextView) findViewById(R.id.percetageText);
        totalLandText = (TextView) findViewById(R.id.totalLandText);

        squareDouble=getIntent().getDoubleExtra("Square",0);
        percentageDouble=getIntent().getDoubleExtra("Percentage",0);
        totalLandDouble=getIntent().getDoubleExtra("Land",0);

       /* squareText.setText(Double.toString(squareDouble)+"  square feet");
        percentageText.setText(Double.toString(percentageDouble)+"  percentage");
        totalLandText.setText(Double.toString(totalLandDouble)+"  Land");*/


        squareText.setText(String.format( "%.2f", squareDouble)+"  square feet");
        percentageText.setText(String.format( "%.2f", percentageDouble)+"  percentage");
        totalLandText.setText(String.format( "%.2f", totalLandDouble)+"  Land");


    }
}