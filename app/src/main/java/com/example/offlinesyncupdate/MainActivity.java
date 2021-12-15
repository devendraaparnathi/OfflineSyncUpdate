package com.example.offlinesyncupdate;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CommentViewModel commentViewModel;

    RecyclerView recyclerView;
    CommentAdapter adapter;
    EditText editText;
    Button button;

    //Extra Code
    BroadcastReceiver br;
    IntentFilter filter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.etAddComment);
        button = findViewById(R.id.btnAddComment);

        commentViewModel = new ViewModelProvider(this).get(CommentViewModel.class);
        commentViewModel.getListComment().observe(this, comments -> {
            adapter.submitList(comments);
        });

        br = new MyBroadcastReceiver();
        filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        this.registerReceiver(br,filter);

        recyclerView = findViewById(R.id.rvCommentsView);
        adapter = new CommentAdapter(new CommentAdapter.CommentDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(editText.getText())) {
                    editText.setError("Require field");
                } else {
                    String tempComm = editText.getText().toString();
                    Comment comment = new Comment(tempComm);
                    commentViewModel.insert(comment);
                    editText.setText("");
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}