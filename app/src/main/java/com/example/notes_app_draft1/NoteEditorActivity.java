package com.example.notes_app_draft1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashSet;

public class NoteEditorActivity extends AppCompatActivity {
    int noteId;
    EditText editTextNoteTitle;
    EditText editTextNoteBody;

    EditText person_name_edit_text;
    EditText drug_name_edit_text;
    EditText drug_dosage_edit_text;
    EditText drug_frequency_edit_text;
    EditText drug_route_edit_text;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_editor);

//        editTextNoteTitle = findViewById(R.id.editTextNoteTitle);
//        editTextNoteBody = findViewById(R.id.editTextNoteBody);
        person_name_edit_text = findViewById(R.id.person_name_edit_text);
        drug_name_edit_text = findViewById(R.id.drug_name_edit_text);
        drug_dosage_edit_text = findViewById(R.id.drug_dosage_edit_text);
        drug_frequency_edit_text=findViewById(R.id.drug_frequency_edit_text);
        drug_route_edit_text=findViewById(R.id.drug_route_edit_text);

        // Fetch data that is passed from MainActivity
        Intent intent = getIntent();

        // Accessing the data using key and value
        noteId = intent.getIntExtra("noteId", -1);

        // TODO 3. CHANGE NOTES (CREATE)
        if (noteId != -1) {
//            editText.setText(MainActivity.notes2.get(noteId));

//            editTextNoteTitle.setText(MainActivity.notes.get(noteId).getTitle());
//            editTextNoteBody.setText(MainActivity.notes.get(noteId).getBody());

            person_name_edit_text.setText(MainActivity.notes.get(noteId).getPersonName());
            drug_name_edit_text.setText(MainActivity.notes.get(noteId).getDrugName());
            drug_dosage_edit_text.setText(MainActivity.notes.get(noteId).getDrugDosage());
            drug_frequency_edit_text.setText(MainActivity.notes.get(noteId).getDrugFrequency());
            drug_route_edit_text.setText(MainActivity.notes.get(noteId).getDrugRoute());


        } else {

//            MainActivity.notes2.add("");
//            noteId = MainActivity.notes2.size() - 1;
//            MainActivity.arrayAdapter.notifyDataSetChanged();

            MainActivity.notes.add(new Note("Write Name Here","Drug Name",
                    "drug dosage","drug frequency","drug route"));
            noteId = MainActivity.notes.size() -1;
            MainActivity.noteAdapter.notifyDataSetChanged();

        }

        person_name_edit_text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // add your code here
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // TODO 4. CHANGE NOTES (UPDATE)
//                MainActivity.notes2.set(noteId, String.valueOf(charSequence));
//                MainActivity.arrayAdapter.notifyDataSetChanged();

                Note noteUpdated = MainActivity.notes.get(noteId);
                noteUpdated.setPersonName(String.valueOf(charSequence));

                MainActivity.notes.set(noteId,noteUpdated);
                MainActivity.noteAdapter.notifyDataSetChanged();


                // Creating Object of SharedPreferences to store data in the phone
//                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.example.notes", Context.MODE_PRIVATE);
//                HashSet<String> set = new HashSet(MainActivity.notes2);
//                sharedPreferences.edit().putStringSet("notes", set).apply();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // add your code here
            }
        });
        drug_name_edit_text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // add your code here
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // TODO 4. CHANGE NOTES (UPDATE)
//                MainActivity.notes2.set(noteId, String.valueOf(charSequence));
//                MainActivity.arrayAdapter.notifyDataSetChanged();

                Note noteUpdated = MainActivity.notes.get(noteId);
                noteUpdated.setDrugName(String.valueOf(charSequence));

                MainActivity.notes.set(noteId,noteUpdated);
                MainActivity.noteAdapter.notifyDataSetChanged();


                // Creating Object of SharedPreferences to store data in the phone
//                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.example.notes", Context.MODE_PRIVATE);
//                HashSet<String> set = new HashSet(MainActivity.notes2);
//                sharedPreferences.edit().putStringSet("notes", set).apply();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // add your code here
            }
        });
        drug_dosage_edit_text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // add your code here
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // TODO 4. CHANGE NOTES (UPDATE)
//                MainActivity.notes2.set(noteId, String.valueOf(charSequence));
//                MainActivity.arrayAdapter.notifyDataSetChanged();

                Note noteUpdated = MainActivity.notes.get(noteId);
                noteUpdated.setDrugDosage(String.valueOf(charSequence));

                MainActivity.notes.set(noteId,noteUpdated);
                MainActivity.noteAdapter.notifyDataSetChanged();


                // Creating Object of SharedPreferences to store data in the phone
//                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.example.notes", Context.MODE_PRIVATE);
//                HashSet<String> set = new HashSet(MainActivity.notes2);
//                sharedPreferences.edit().putStringSet("notes", set).apply();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // add your code here
            }
        });
        drug_frequency_edit_text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // add your code here
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // TODO 4. CHANGE NOTES (UPDATE)
//                MainActivity.notes2.set(noteId, String.valueOf(charSequence));
//                MainActivity.arrayAdapter.notifyDataSetChanged();

                Note noteUpdated = MainActivity.notes.get(noteId);
                noteUpdated.setDrugFrequency(String.valueOf(charSequence));

                MainActivity.notes.set(noteId,noteUpdated);
                MainActivity.noteAdapter.notifyDataSetChanged();


                // Creating Object of SharedPreferences to store data in the phone
//                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.example.notes", Context.MODE_PRIVATE);
//                HashSet<String> set = new HashSet(MainActivity.notes2);
//                sharedPreferences.edit().putStringSet("notes", set).apply();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // add your code here
            }
        });
        drug_route_edit_text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // add your code here
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // TODO 4. CHANGE NOTES (UPDATE)
//                MainActivity.notes2.set(noteId, String.valueOf(charSequence));
//                MainActivity.arrayAdapter.notifyDataSetChanged();

                Note noteUpdated = MainActivity.notes.get(noteId);
                noteUpdated.setDrugRoute(String.valueOf(charSequence));

                MainActivity.notes.set(noteId,noteUpdated);
                MainActivity.noteAdapter.notifyDataSetChanged();


                // Creating Object of SharedPreferences to store data in the phone
//                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.example.notes", Context.MODE_PRIVATE);
//                HashSet<String> set = new HashSet(MainActivity.notes2);
//                sharedPreferences.edit().putStringSet("notes", set).apply();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // add your code here
            }
        });


    }
}
