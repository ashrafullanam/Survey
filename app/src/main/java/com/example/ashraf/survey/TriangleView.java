package com.example.ashraf.survey;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TriangleView extends AppCompatActivity {
    private EditText L1,L2,L3,percent,Inc1,Inc2,Inc3;
    private Button calculate;
    private double d1,d2,d3,percenD,dSquare,dtotalPerc,dTotalLand;
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
                Intent i = new Intent(TriangleView.this,TriangleViewShow.class);
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

        double s=(d1+d2+d3)/2;
        percenD= Double.parseDouble(percent.getText().toString());

        dSquare = Math.sqrt(s*(s-d1)*(s-d2)*(s-d3));
        dtotalPerc= dSquare/435.6;
        dTotalLand=dtotalPerc/percenD;

    }
}