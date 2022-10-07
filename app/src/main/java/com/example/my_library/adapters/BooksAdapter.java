package com.example.my_library.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.my_library.R;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.ViewHolder> {

    private static final String TAG = "BooksAdapter";

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivBookImage;
        private TextView tvBookName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivBookImage = (ImageView) itemView.findViewById(R.id.ivBookImage);
            tvBookName = (TextView) itemView.findViewById(R.id.tvBookName);
        }
    }
}
