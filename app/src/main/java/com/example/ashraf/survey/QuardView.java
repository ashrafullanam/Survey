package com.example.ashraf.survey;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static java.lang.Double.parseDouble;

public class QuardView extends AppCompatActivity {
    private EditText L1,L2,L3,L4,percent,Inc1,Inc2,Inc3,Inc4;
    private Button calculate;
    private double d1,d2,d3,d4,percenD,dSquare,dtotalPerc,dTotalLand;
    private String string;
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
                Intent i = new Intent(QuardView.this,QuardViewShow.class);
                i.putExtra("Square",dSquare);
                i.putExtra("Percentage",dtotalPerc);
                i.putExtra("Land",dTotalLand);
                startActivity(i);

            }
        });
    }

    private void Compute() {

        d1= Double.parseDouble(L1.getText().toString())+(Double.parseDouble(Inc1.getText().toString())/12);
        d2= Double.parseDouble(L2.getText().toString())+(Double.parseDouble(Inc2.getText().toString())/12);
        d3= Double.parseDouble(L3.getText().toString())+(Double.parseDouble(Inc3.getText().toString())/12);
        d4= Double.parseDouble(L4.getText().toString())+(Double.parseDouble(Inc4.getText().toString())/12);

        percenD= Double.parseDouble(percent.getText().toString());

        dSquare = Math.sqrt(d1*d2*d3*d4);
        dtotalPerc= dSquare/435.6;
        dTotalLand=dtotalPerc/percenD;

    }
}
