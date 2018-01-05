package com.example.ashraf.survey;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TriangleView extends AppCompatActivity {
    private EditText L1,L2,L3,percent,Inc1,Inc2,Inc3;
    private Button calculate;
    private double d1,d2,d3,percenD,dSquare,dtotalPerc,dTotalLand;
    private String strL1,strL2,strL3,strI1,strI2,strI3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangle_view);
        L1= (EditText) findViewById(R.id.lenght1);
        L2= (EditText) findViewById(R.id.lenght2);
        L3= (EditText) findViewById(R.id.lenght3);

        Inc1= (EditText) findViewById(R.id.inch1);
        Inc2= (EditText) findViewById(R.id.inch2);
        Inc3= (EditText) findViewById(R.id.inch3);

        percent= (EditText) findViewById(R.id.Quardpercent);

        calculate = (Button) findViewById(R.id.calculateQuard);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Compute();
                //Toast.makeText(TriangleView.this,""+dSquare, Toast.LENGTH_SHORT).show();
               /* Intent i = new Intent(TriangleView.this,TriangleViewShow.class);
                i.putExtra("Square",dSquare);
                i.putExtra("Percentage",dtotalPerc);
                i.putExtra("Land",dTotalLand);
                startActivity(i);*/

            }
        });
    }

    private void Compute() {

        strL1=L1.getText().toString();
        strL2=L2.getText().toString();
        strL3=L3.getText().toString();


        strI1=Inc1.getText().toString();
        strI2=Inc2.getText().toString();
        strI3=Inc3.getText().toString();


        if(TextUtils.isEmpty(strL1)){
            L1.setError("Please Enter Length 1!!");
        }
        else if(TextUtils.isEmpty(strL2)){

            L2.requestFocus();
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(L2, InputMethodManager.SHOW_IMPLICIT);

            L2.setError("Please Enter Length 2!!");
        }
        else if(TextUtils.isEmpty(strL3)){

            L3.requestFocus();
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(L3, InputMethodManager.SHOW_IMPLICIT);

            L3.setError("Please Enter Length 3!!");
        }

        else if(TextUtils.isEmpty(strI1)){

            Inc1.requestFocus();
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(Inc1, InputMethodManager.SHOW_IMPLICIT);

            Inc1.setError("Please Enter Inch 1!!");
        }
        else if(TextUtils.isEmpty(strI2)){

            Inc2.requestFocus();
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(Inc2, InputMethodManager.SHOW_IMPLICIT);

            Inc2.setError("Please Enter Inch 2!!");
        }
        else if(TextUtils.isEmpty(strI3)){

            Inc3.requestFocus();
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(Inc3, InputMethodManager.SHOW_IMPLICIT);

            Inc3.setError("Please Enter Inch 3!!");
        }

        else{


            d1= Double.parseDouble(strL1)+(Double.parseDouble(strI1)/12);
            d2= Double.parseDouble(strL2)+(Double.parseDouble(strI2)/12);
            d3= Double.parseDouble(strL3)+(Double.parseDouble(strI3)/12);

            double s=(d1+d2+d3)/2;
            percenD= Double.parseDouble(percent.getText().toString());

            dSquare = Math.sqrt(s*(s-d1)*(s-d2)*(s-d3));
            dtotalPerc= dSquare/435.6;
            dTotalLand=dtotalPerc/percenD;

            Intent i = new Intent(TriangleView.this,TriangleViewShow.class);
            i.putExtra("Square",dSquare);
            i.putExtra("Percentage",dtotalPerc);
            i.putExtra("Land",dTotalLand);
            startActivity(i);

        }

/*
        d1= Double.parseDouble(L1.getText().toString())+(Double.parseDouble(Inc1.getText().toString())/12);
        d2= Double.parseDouble(L2.getText().toString())+(Double.parseDouble(Inc2.getText().toString())/12);
        d3= Double.parseDouble(L3.getText().toString())+(Double.parseDouble(Inc3.getText().toString())/12);

        double s=(d1+d2+d3)/2;
        percenD= Double.parseDouble(percent.getText().toString());

        dSquare = Math.sqrt(s*(s-d1)*(s-d2)*(s-d3));
        dtotalPerc= dSquare/435.6;
        dTotalLand=dtotalPerc/percenD;
        */



    }
}