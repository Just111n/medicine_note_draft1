package com.example.notes_app_draft1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class NoteAdapter extends BaseAdapter {
    private List<Note> notes;

    public NoteAdapter(MainActivity mainActivity, List<Note> notes) {
        this.notes = notes;
    }

    @Override
    public int getCount() {
        return notes.size();
    }

    @Override
    public Object getItem(int position) {
        return notes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_list_item, parent, false);
        }

        TextView titleTextView = convertView.findViewById(R.id.title_text_view);
        TextView bodyTextView = convertView.findViewById(R.id.body_text_view);

        Note note = notes.get(position);
        titleTextView.setText(note.getTitle());
        bodyTextView.setText(note.getBody());

        return convertView;
    }
}

