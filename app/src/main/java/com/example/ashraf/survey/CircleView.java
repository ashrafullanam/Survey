package com.example.ashraf.survey;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CircleView extends AppCompatActivity {
    private EditText L1,percent,Inc1;
    private Button calculate;
    private double d1,percenD,dSquare,dtotalPerc,dTotalLand;
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
                Intent i = new Intent(CircleView.this,CircleViewShow.class);
                i.putExtra("Square",dSquare);
                i.putExtra("Percentage",dtotalPerc);
                i.putExtra("Land",dTotalLand);
                startActivity(i);

            }
        });
    }

    private void Compute() {

        d1= Double.parseDouble(L1.getText().toString())+(Double.parseDouble(Inc1.getText().toString())/12);


        percenD= Double.parseDouble(percent.getText().toString()); //1.5

        dSquare = (d1*d1)*3.1416;
        dtotalPerc= dSquare/435.6;
        dTotalLand=dtotalPerc/percenD;

    }
}