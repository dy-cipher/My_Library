package com.example.my_library.network;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.my_library.adapters.BooksAdapter;
import com.example.my_library.model.Book;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.example.my_library.utilities.Utils;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.List;

import okhttp3.Headers;

public class BookClient {

    private BooksAdapter adapter;
    private List<Book> books;
    private final String TAG;
    public static final String url = "https://raw.githubusercontent.com/bvaughn/infinite-list-reflow-examples/master/books.json";

    public BookClient(BooksAdapter adapter, List<Book> books, String TAG) {
        this.adapter = adapter;
        this.books = books;
        this.TAG = TAG;
    }

    public void mainActivityClient(){
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Headers headers, JSON json) {
                Log.d(TAG, "OnSuccess");
                JSONArray jsonArray = json.jsonArray;

                try {
                    books.addAll(Book.fromJsonArray(jsonArray));
                    adapter.notifyDataSetChanged();
                    Log.i(TAG, "Books: " + books.toString());
//                    Toast.makeText(context, books.toString(), Toast.LENGTH_LONG).show();
                } catch (JSONException e) {
                    Log.e(TAG, "Hit json exception");
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {
                Log.e(TAG,"OnFailure", throwable);
            }
        });
    }
}
