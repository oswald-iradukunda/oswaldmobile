package com.example.recyclerview;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private final LinkedList<String> mWordList = new LinkedList<>();

    RecyclerView mRecyclerView;
    WordListAdapter wordListAdapter;
    FloatingActionButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.fab);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wordListSize = mWordList.size();
                // Add a new word to the wordList.
                mWordList.addLast("+ Word " + wordListSize);
                // Notify the adapter, that the data has changed.
                mRecyclerView.getAdapter().notifyItemInserted(wordListSize);
                // Scroll to the bottom.
                mRecyclerView.smoothScrollToPosition(wordListSize);
            }
        });
        mRecyclerView = (RecyclerView)findViewById(R.id.my_recycler);
        for (int i = 0; i < 20; i++) {
            mWordList.addLast("Word " + i);
        }
        wordListAdapter = new WordListAdapter(this,mWordList);
        mRecyclerView.setAdapter(wordListAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}