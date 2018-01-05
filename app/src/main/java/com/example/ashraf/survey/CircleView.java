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

public class CircleView extends AppCompatActivity {
    private EditText L1,percent,Inc1;
    private Button calculate;
    private double d1,percenD,dSquare,dtotalPerc,dTotalLand;
    String str1,str2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_view);


        L1= (EditText) findViewById(R.id.lenght1);

        Inc1= (EditText) findViewById(R.id.inch1);

        percent= (EditText) findViewById(R.id.Quardpercent);

        calculate = (Button) findViewById(R.id.calculateQuard);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Compute();


                //Toast.makeText(TriangleView.this,""+dSquare, Toast.LENGTH_SHORT).show();
        /*        Intent i = new Intent(CircleView.this,CircleViewShow.class);
                i.putExtra("Square",dSquare);
                i.putExtra("Percentage",dtotalPerc);
                i.putExtra("Land",dTotalLand);
                startActivity(i);  */

            }
        });
    }

    private void Compute() {

        str1=L1.getText().toString();
        str2=Inc1.getText().toString();

        if(TextUtils.isEmpty(str1)){
            L1.setError("Please Enter Radius!!");
            return;
        }
        else if(TextUtils.isEmpty(str2)){
            Inc1.requestFocus();
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(Inc1, InputMethodManager.SHOW_IMPLICIT);

            Inc1.setError("Please Enter Inch!!");
            return;
        }
        else{

            d1= Double.parseDouble(str1)+(Double.parseDouble(str2)/12);


            percenD= Double.parseDouble(percent.getText().toString()); //1.5

            dSquare = (d1*d1)*3.1416;
            dtotalPerc= dSquare/435.6;
            dTotalLand=dtotalPerc/percenD;


            Intent i = new Intent(CircleView.this,CircleViewShow.class);
            i.putExtra("Square",dSquare);
            i.putExtra("Percentage",dtotalPerc);
            i.putExtra("Land",dTotalLand);
            startActivity(i);

        }

/*
        d1= Double.parseDouble(L1.getText().toString())+(Double.parseDouble(Inc1.getText().toString())/12);


        percenD= Double.parseDouble(percent.getText().toString()); //1.5

        dSquare = (d1*d1)*3.1416;
        dtotalPerc= dSquare/435.6;
        dTotalLand=dtotalPerc/percenD;

*/


    }
}