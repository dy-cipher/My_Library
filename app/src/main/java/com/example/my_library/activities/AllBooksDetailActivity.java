package com.example.my_library.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.my_library.R;
import com.example.my_library.model.Book;
import com.example.my_library.utilities.Utils;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

public class AllBooksDetailActivity extends AppCompatActivity {
    private static final String TAG = "AllBooksDetailActivity";
    private TextView tvAuthors, tvBookName, tvBookDescription, tvPages;
    private ImageView ivBookImage;
    private Button btnCurrent, btnDoneReading, btnWantTo;
    Book books;
    Boolean doesExist = false;
    List<Book> currReading, doneReading, wantTo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initWidgets();

        books = Parcels.unwrap(getIntent().getParcelableExtra("book"));

        tvBookName.setText(books.getName());
        tvBookDescription.setText(books.getDescription());
        tvPages.setText(books.getPages() + " Pages ");


        setOnCLickListeners();

        tvAuthors.setText(books.getAuthor().toString());

        Glide.with(this)
                .asBitmap()
                .load(books.getImageUrl())
                .into(ivBookImage);

    }

    private void setOnCLickListeners() {
        btnWantTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnWantToTapped();
                
            }
        });

        btnCurrent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnCurrentReadingTapped();
            }
        });

        btnDoneReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnDoneReadingTapped();
            }
        });
    }

    private void btnDoneReadingTapped() {
        doesExist = false;
        Log.d(TAG, "btnDoneReading  Started");
        doneReading = Utils.getFinishedBooks();
        for (Book book: doneReading){
            if (book.getId() == books.getId()){
                doesExist = true;
            }
        }

        if (doesExist){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("You've already added that book into your Finished list");
            builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            builder.setCancelable(true);
            builder.create().show();
        }else{
            Utils.addFinishedBooks(books);
            Toast.makeText(this, "Books added successfully", Toast.LENGTH_SHORT).show();
        }
    }

    private void btnWantToTapped() {
        doesExist = false;
        Log.d(TAG, "button Want to read books tapped Started");
        wantTo = Utils.getToRead();
        for (Book book: wantTo){
            if (book.getId() == books.getId()){
                doesExist = true;
            }
        }

        if (doesExist){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("You've already added that book into your want to read Shelf");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            builder.setCancelable(true);
            builder.create().show();
        }else{
            Utils.addToReadBooks(books);
            Toast.makeText(this, "Books added successfully", Toast.LENGTH_SHORT).show();
        }

    }

    private void btnCurrentReadingTapped() {
        doesExist = false;
        Log.d(TAG, "btnCurrentTapped Started");
        currReading = Utils.getCurrentBooks();
        for (Book book: currReading){
            if (book.getId() == books.getId()){
                doesExist = true;
            }
        }

        if (doesExist){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("You've already added that book into your currently reading list");
            builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            builder.setCancelable(true);
            builder.create().show();
        }else{
            Utils.addCurrReadingBooks(books);
            Toast.makeText(this, "Books added successfully", Toast.LENGTH_SHORT).show();
        }
    }

    private void initWidgets() {
        tvAuthors = findViewById(R.id.tvAuthors);
        tvBookName = findViewById(R.id.tvBookName);
        tvBookDescription = findViewById(R.id.tvBookDescription);
        ivBookImage = findViewById(R.id.ivBookImage);
        tvPages = findViewById(R.id.tvPages);
        btnCurrent = findViewById(R.id.btnCurrent);
        btnDoneReading = findViewById(R.id.btnDoneReading);
        btnWantTo = findViewById(R.id.btnWantTo);

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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}