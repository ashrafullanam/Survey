package com.example.ashraf.survey;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static java.lang.Double.parseDouble;

public class QuardView extends AppCompatActivity {
    private EditText L1,L2,L3,L4,percent,Inc1,Inc2,Inc3,Inc4;
    private Button calculate;
    private double d1,d2,d3,d4,percenD,dSquare,dtotalPerc,dTotalLand;
    private String strL1,strL2,strL3,strL4,strI1,strI2,strI3,strI4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quard_view);

        L1= (EditText) findViewById(R.id.lenght1);
        L2= (EditText) findViewById(R.id.lenght2);
        L3= (EditText) findViewById(R.id.lenght3);
        L4= (EditText) findViewById(R.id.lenght4);

        Inc1= (EditText) findViewById(R.id.inch1);
        Inc2= (EditText) findViewById(R.id.inch2);
        Inc3= (EditText) findViewById(R.id.inch3);
        Inc4= (EditText) findViewById(R.id.inch4);


        percent= (EditText) findViewById(R.id.Quardpercent);

        calculate = (Button) findViewById(R.id.calculateQuard);


        //string=L1.getText().toString();
        // d1=Double.parseDouble(L1.getText().toString());



        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Compute();
                //Toast.makeText(QuardView.this,""+dSquare, Toast.LENGTH_SHORT).show();


          /*      Intent i = new Intent(QuardView.this,QuardViewShow.class);
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
        strL4=L4.getText().toString();

        strI1=Inc1.getText().toString();
        strI2=Inc2.getText().toString();
        strI3=Inc3.getText().toString();
        strI4=Inc4.getText().toString();

        if(TextUtils.isEmpty(strL1)){
            L1.setError("Please Enter Length 1!!");
        }
        else if(TextUtils.isEmpty(strL2)){
            L2.setError("Please Enter Length 2!!");
        }
        else if(TextUtils.isEmpty(strL3)){
            L3.setError("Please Enter Length 3!!");
        }
        else if(TextUtils.isEmpty(strL4)){
            L4.setError("Please Enter Length 4!!");
        }
        else if(TextUtils.isEmpty(strI1)){
            Inc1.setError("Please Enter Inch 1!!");
        }
        else if(TextUtils.isEmpty(strI2)){
            Inc2.setError("Please Enter Inch 2!!");
        }
        else if(TextUtils.isEmpty(strI3)){
            Inc3.setError("Please Enter Inch 3!!");
        }
        else if(TextUtils.isEmpty(strI4)){
            Inc4.setError("Please Enter Inch 4!!");
        }
        else{

            d1= Double.parseDouble(strL1)+(Double.parseDouble(strI1)/12);
            d2= Double.parseDouble(strL2)+(Double.parseDouble(strI2)/12);
            d3= Double.parseDouble(strL3)+(Double.parseDouble(strI3)/12);
            d4= Double.parseDouble(strL4)+(Double.parseDouble(strI4)/12);

            percenD= Double.parseDouble(percent.getText().toString());

            dSquare = Math.sqrt(d1*d2*d3*d4);
            dtotalPerc= dSquare/435.6;
            dTotalLand=dtotalPerc/percenD;


            Intent i = new Intent(QuardView.this,QuardViewShow.class);
            i.putExtra("Square",dSquare);
            i.putExtra("Percentage",dtotalPerc);
            i.putExtra("Land",dTotalLand);
            startActivity(i);

        }


       /* d1= Double.parseDouble(L1.getText().toString())+(Double.parseDouble(Inc1.getText().toString())/12);
        d2= Double.parseDouble(L2.getText().toString())+(Double.parseDouble(Inc2.getText().toString())/12);
        d3= Double.parseDouble(L3.getText().toString())+(Double.parseDouble(Inc3.getText().toString())/12);
        d4= Double.parseDouble(L4.getText().toString())+(Double.parseDouble(Inc4.getText().toString())/12);

        percenD= Double.parseDouble(percent.getText().toString());

        dSquare = Math.sqrt(d1*d2*d3*d4);
        dtotalPerc= dSquare/435.6;
        dTotalLand=dtotalPerc/percenD;*/

    }
}
