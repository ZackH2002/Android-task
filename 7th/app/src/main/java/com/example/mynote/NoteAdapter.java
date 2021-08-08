package com.example.mynote;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {
    private List<Note> mNoteList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView NoteTitle, NoteTime, NoteContent;
        View noteView;

        public ViewHolder(View view) {
            super(view);
            noteView = view;
            NoteTitle = (TextView) view.findViewById(R.id.text_title);
            NoteTime = (TextView) view.findViewById(R.id.text_time);
            NoteContent = (TextView) view.findViewById(R.id.text_content);
        }
    }

    public NoteAdapter(List<Note> noteList) {
        mNoteList = noteList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.noteView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Note note = mNoteList.get(position);
                Intent intent = new Intent(v.getContext(), CreateActivity.class);
                intent.putExtra("mode", 3);
                intent.putExtra("id", note.getId());
                intent.putExtra("content", note.getContent());
                intent.putExtra("title", note.getTitle());
                intent.putExtra("time", note.getTime());
                v.getContext().startActivity(intent);
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Note note = mNoteList.get(position);
        holder.NoteTime.setText(note.getTime());
        holder.NoteTitle.setText(note.getTitle());
        holder.NoteContent.setText(note.getContent());
    }

    @Override
    public int getItemCount() {
        return mNoteList.size();
    }


}
