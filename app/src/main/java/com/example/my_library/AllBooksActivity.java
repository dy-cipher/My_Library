package com.example.my_library;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class AllBooksActivity extends AppCompatActivity {

    private static final String TAG = "AllBooksActivity";
    private RecyclerView rvBooks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books2);

        rvBooks = (RecyclerView) findViewById(R.id.rvBooks);

        ArrayList<String> books = new ArrayList<>();

        books.add("Shakespear");
        books.add("Harrington");
        books.add("novel");

    }
}