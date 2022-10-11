package com.example.my_library;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.my_library.adapters.BooksAdapter;
import com.example.my_library.model.Book;
import com.example.my_library.utilities.Utils;

import java.util.List;

public class CurrentlyReadingActivity extends AppCompatActivity {

    private RecyclerView rvBooks;
    private BooksAdapter adapter;
    List<Book> books;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currently_reading);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rvBooks = findViewById(R.id.rvBooks);
        adapter = new BooksAdapter(this, books);

        rvBooks.setAdapter(adapter);
        rvBooks.setLayoutManager(new GridLayoutManager(this, 2));

        adapter.setBooks(Utils.getCurrentBooks());
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                super.onBackPressed();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}