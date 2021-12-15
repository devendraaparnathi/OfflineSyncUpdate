package com.example.offlinesyncupdate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CommentViewHolder extends RecyclerView.ViewHolder {

    private final TextView textView;

    public CommentViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.comment);
    }

    public void bind(String text) {
        textView.setText(text);
    }

    static CommentViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.comment_data, parent, false);
        return new CommentViewHolder(view);
    }

}
