package com.example.my_library;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.my_library.adapters.BooksAdapter;
import com.example.my_library.model.Book;
import com.example.my_library.network.BookClient;

import java.util.ArrayList;
import java.util.List;

public class AllBooksActivity extends AppCompatActivity {

    private static final String TAG = "AllBooksActivity";
    private RecyclerView rvBooks;
    BooksAdapter adapter;
    private List<Book> bookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books2);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rvBooks = (RecyclerView) findViewById(R.id.rvBooks);

        bookList = new ArrayList<>();
        adapter = new BooksAdapter(this, bookList);
        rvBooks.setAdapter(adapter);

        rvBooks.setLayoutManager(new GridLayoutManager(this, 2));

        BookClient bookClient = new BookClient(adapter, bookList, TAG);
        bookClient.mainActivityClient();


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