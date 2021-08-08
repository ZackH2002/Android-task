package com.example.mynote;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Note> noteList = new ArrayList<>();
    boolean up = false;
    NoteAdapter noteAdapter = new NoteAdapter(noteList);

    @Override
    public void onPause() {
        super.onPause();
        up = true;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (up) {
            refreshNotes();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingActionButton buttonCreate = findViewById(R.id.btn_add);
        LitePal.getDatabase();
        //创建数据库
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(noteAdapter);
        initNote();
        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreateActivity.class);
                intent.putExtra("mode", 4);//新建的note的mode为4
                startActivity(intent);
            }
        });

    }

    public void initNote() {
        List<Note> notes = LitePal.findAll(Note.class);
        for (Note note : notes) {
            Note note1 = new Note();
            note1.setTime(note.getTime());
            note1.setTitle(note.getTitle());
            note1.setContent(note.getContent());
            note1.setId(note.getId());
            noteList.add(note1);
        }
    }

    public void refreshNotes() {
        if (noteList.size() > 0)
            noteList.clear();
        List<Note> notes = LitePal.findAll(Note.class);
        for (Note note : notes) {
            Note note1 = new Note();
            note1.setTime(note.getTime());
            note1.setTitle(note.getTitle());
            note1.setContent(note.getContent());
            note1.setId(note.getId());
            noteList.add(note1);
        }
        noteAdapter.notifyDataSetChanged();

    }

}