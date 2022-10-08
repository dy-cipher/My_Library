package com.example.my_library.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.my_library.R;
import com.example.my_library.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.ViewHolder> {

    private static final String TAG = "BooksAdapter";
    List<Book> bookList;
    Context context;
    View view;

    public BooksAdapter( Context context, List<Book> bookList ) {
        this.context = context;
        this.bookList = bookList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_books_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called");
        Book book = bookList.get(position);
        holder.bind(book);

    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivBookImage;
        private TextView tvBookName;
        private CardView cvContainer;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivBookImage = itemView.findViewById(R.id.ivBookImage);
            tvBookName =  itemView.findViewById(R.id.tvBookName);
            cvContainer = itemView.findViewById(R.id.cvContainer);
        }

        public void bind(Book book){
            tvBookName.setText(book.getName());

            Glide.with(context)
                    .asBitmap()
                    .load(book.getImageUrl())
                    .into(ivBookImage);

            cvContainer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, book.getName(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public void setBooks(ArrayList<Book> books) {
        this.bookList = books;
        notifyDataSetChanged();
    }
}
