package com.example.api;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

       TextView titlee = findViewById(R.id.mytitle);
       TextView desc = findViewById(R.id.mydescr);

        Intent intent = getIntent();
        String thistitle = intent.getExtras().getString("atitle");
        String thisdescription = intent.getExtras().getString("adescription");


        titlee.setText(thistitle);
        desc.setText(thisdescription);



    }

}