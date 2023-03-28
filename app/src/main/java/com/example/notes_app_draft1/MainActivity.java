package com.example.notes_app_draft1;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

public class MainActivity extends AppCompatActivity {

    static ArrayList<Note> notes = new ArrayList<>();
    static String todayDate = DateFormat.getDateInstance().format(new Date());
    static NoteAdapter noteAdapter;

    private ListView listView;
    private TextView todayDateTextView;
    private FloatingActionButton addNoteButton;


    // Creating options Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_note_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    // Selecting options on menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);

        if (item.getItemId() == R.id.add_note) {

            // Going from MainActivity to NotesEditorActivity
            Intent intent = new Intent(getApplicationContext(), NoteEditorActivity.class);
            startActivity(intent);
            return true;
        }
        if (item.getItemId() == R.id.dummy) {

            // Going from MainActivity to NotesEditorActivity
            Log.d("optionMenu","dummy clicked!");
        }

        return false;
    }
    // onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ListView is accessed
        listView = findViewById(R.id.listView);
        todayDateTextView = findViewById(R.id.today_date_text_view);
        todayDateTextView.setText(todayDate);
        addNoteButton = findViewById(R.id.add_note_fab);


        // Store in phone local memory
//        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.example.notes", Context.MODE_PRIVATE);
//        HashSet<String> set = (HashSet<String>) sharedPreferences.getStringSet("notes", null);

        // TODO 1. CHANGE NOTES (INIT)
//        if (set == null) {
//
////            notes2.add("Testing This");
//            Note newNote = new Note("New Note Title", "New Note Body");
//            notes.add(newNote);
//
//
//        } else {
//            notes2 = new ArrayList(set);
//
//
//        }
        notes = new ArrayList<>();
        Note newNote = new Note("Justin Looi", "Paracetemol",
                "2 tables","Every 2 days/Every Monday and Wedsnesday","Oral");
        notes.add(newNote);


        // Using custom listView Provided by Android Studio

        noteAdapter = new NoteAdapter(this,notes);


//        listView.setAdapter(arrayAdapter);
        listView.setAdapter(noteAdapter);

        // Click on note to edit
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                // Going from MainActivity to NotesEditorActivity
                Intent intent = new Intent(getApplicationContext(), NoteEditorActivity.class);
                intent.putExtra("noteId", i);
                startActivity(intent);

            }
        });

        // Long click on note to delete
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                final int itemToDelete = i;
                // To delete the data from the App
                new AlertDialog.Builder(MainActivity.this)
                        .setIcon(R.drawable.ic_launcher_foreground)
                        .setTitle("Are you sure?")
                        .setMessage("Do you want to delete this note?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                // TODO 2. CHANGE NOTES (DELETE)

                                notes.remove(itemToDelete);

                                noteAdapter.notifyDataSetChanged();
                                // store data in local storage
//                                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.example.notes", Context.MODE_PRIVATE);
//                                HashSet<String> set = new HashSet(MainActivity.notes2);
//                                sharedPreferences.edit().putStringSet("notes", set).apply();
                            }
                        }).setNegativeButton("No", null).show();
                return true;
            }
        });

        FloatingActionButton addNoteButton = findViewById(R.id.add_note_fab);
        addNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle button click here
                // Going from MainActivity to NotesEditorActivity
                Intent intent = new Intent(getApplicationContext(), NoteEditorActivity.class);
                startActivity(intent);

            }
        });
    }
}
