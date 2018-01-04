package com.example.ashraf.survey;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TriangleView2 extends AppCompatActivity {
    private EditText L1,L2,percent,Inc1,Inc2;
    private Button calculate;
    private double d1,d2,percenD,dSquare,dtotalPerc,dTotalLand;
    private String strL1,strL2,strI1,strI2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangle_view2);
        L1= (EditText) findViewById(R.id.lenght1);
        L2= (EditText) findViewById(R.id.lenght2);


        Inc1= (EditText) findViewById(R.id.inch1);
        Inc2= (EditText) findViewById(R.id.inch2);


        percent= (EditText) findViewById(R.id.Quardpercent);

        calculate = (Button) findViewById(R.id.calculateQuard);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Compute();
                //Toast.makeText(TriangleView.this,""+dSquare, Toast.LENGTH_SHORT).show();
               /* Intent i = new Intent(TriangleView2.this,TriangleViewShow2.class);
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

        strI1=Inc1.getText().toString();
        strI2=Inc2.getText().toString();


        if(TextUtils.isEmpty(strL1)){
            L1.setError("Please Enter Base!!");
        }
        else if(TextUtils.isEmpty(strL2)){
            L2.setError("Please Enter Higth!!");
        }

        else if(TextUtils.isEmpty(strI1)){
            Inc1.setError("Please Enter Inch 1!!");
        }
        else if(TextUtils.isEmpty(strI2)){
            Inc2.setError("Please Enter Inch 2!!");
        }

        else{

            d1= Double.parseDouble(strL1)+(Double.parseDouble(strI1)/12);
            d2= Double.parseDouble(strL2)+(Double.parseDouble(strI2)/12);

            percenD= Double.parseDouble(percent.getText().toString()); //1.5

            dSquare = (d1*d2)*0.5;
            dtotalPerc= dSquare/435.6;
            dTotalLand=dtotalPerc/percenD;

            Intent i = new Intent(TriangleView2.this,TriangleViewShow2.class);
            i.putExtra("Square",dSquare);
            i.putExtra("Percentage",dtotalPerc);
            i.putExtra("Land",dTotalLand);
            startActivity(i);

        }



        /*d1= Double.parseDouble(L1.getText().toString())+(Double.parseDouble(Inc1.getText().toString())/12);
        d2= Double.parseDouble(L2.getText().toString())+(Double.parseDouble(Inc2.getText().toString())/12);

        percenD= Double.parseDouble(percent.getText().toString()); //1.5

        dSquare = (d1*d2)*0.5;
        dtotalPerc= dSquare/435.6;
        dTotalLand=dtotalPerc/percenD;*/

    }
}