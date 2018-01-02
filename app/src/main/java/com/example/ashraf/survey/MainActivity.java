package com.example.ashraf.survey;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.app.Activity;

public class MainActivity extends AppCompatActivity {
    ListView list;
    String[] web = {
            "Quad",
            "Triangle",
            "Triangle2",
            "Circle",

    } ;
    Integer[] imageId = {
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomList adapter = new
                CustomList(MainActivity.this, web, imageId);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(MainActivity.this, "You Clicked at " +web[+position], Toast.LENGTH_SHORT).show();
                if(web[position]=="Quad"){
                    Intent appInfo = new Intent(MainActivity.this, QuardView.class);
                    startActivity(appInfo);

                }
                if(web[position]=="Triangle"){
                    Intent appInfo = new Intent(MainActivity.this, TriangleView.class);
                    startActivity(appInfo);

                }
                if(web[position]=="Triangle2"){
                    Intent appInfo = new Intent(MainActivity.this, TriangleView2.class);
                    startActivity(appInfo);

                }
                if(web[position]=="Circle"){
                    Intent appInfo = new Intent(MainActivity.this, CircleView.class);
                    startActivity(appInfo);

                }


            }
        });

    }

}