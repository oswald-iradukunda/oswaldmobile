package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    private LinkedList data;
    private Context ct;
    public WordListAdapter(Context ct, LinkedList data){
        this.data = data;
        this.ct = ct;
    }
    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(ct);
        View v = inflater.inflate(R.layout.wordlist_item,parent,false);
        return new WordViewHolder(v, this);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull WordListAdapter.WordViewHolder holder, int position) {
        holder.word.setText(String.valueOf(data.get(position)));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView word;
        final WordListAdapter mAdapter;
        public WordViewHolder(@NonNull @NotNull View itemView, WordListAdapter mAdapter) {
            super(itemView);
            this.mAdapter = mAdapter;
            itemView.setOnClickListener(this);
            word = itemView.findViewById(R.id.word);
        }

        @Override
        public void onClick(View v) {
            // Get the position of the item that was clicked.
            int mPosition = getLayoutPosition();
            // Use that to access the affected item in mWordList.
            String element = String.valueOf(data.get(mPosition));
            // Change the word in the mWordList.
            data.set(mPosition, "Clicked! " + element);
            // Notify the adapter, that the data has changed so it can
            // update the RecyclerView to display the data.
            mAdapter.notifyDataSetChanged();

        }
    }
}
