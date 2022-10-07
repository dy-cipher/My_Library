package com.example.my_library;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnAllBooks, btnCurrent, btnWantTo, btnDoneReading, btnAbout;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // method for widgets initialization
        initWigets();
        setOnClickListeners();
    }

    private void setOnClickListeners() {
        btnAllBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AllBooksActivity.class);
                startActivity(i);
            }
        });

        btnCurrent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, CurrentlyReadingActivity.class);
                startActivity(i);
            }
        });

        btnWantTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AllBooksActivity.class);
                startActivity(i);
            }
        });

        btnDoneReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, FinishedReading.class);
                startActivity(i);
            }
        });

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(i);
            }
        });
    }

    private void initWigets() {

        btnAllBooks = findViewById(R.id.btnAllBooks);
        btnCurrent = findViewById(R.id.btnCurrent);
        btnDoneReading = findViewById(R.id.btnDoneReading);
        btnWantTo = findViewById(R.id.btnWantTo);
        btnAbout = findViewById(R.id.btnAbout);
    }
}