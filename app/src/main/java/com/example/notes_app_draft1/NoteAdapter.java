package com.example.notes_app_draft1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

//    @Override
//    public int getCount() {
//        return notes.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return notes.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }

public class NoteAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private List<Note> notes;

    public NoteAdapter(Context context, List<Note> notes) {
        inflater = LayoutInflater.from(context);
        this.notes = notes;
    }

    @Override
    public int getCount() {
        return notes.size();
    }

    @Override
    public Note getItem(int position) {
        return notes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.note_list_item, parent, false);
            holder = new ViewHolder();
            holder.personName = convertView.findViewById(R.id.person_name_value_text_view);
            holder.drugName = convertView.findViewById(R.id.drug_name_value_text_view);
            holder.drugDosage = convertView.findViewById(R.id.drug_dosage_value_text_view);
            holder.drugFrequency = convertView.findViewById(R.id.drug_frequency_value_text_view);
            holder.drugRoute = convertView.findViewById(R.id.drug_route_value_text_view);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Note note = notes.get(position);

        holder.personName.setText(note.getPersonName());
        holder.drugName.setText(note.getDrugName());
        holder.drugDosage.setText(note.getDrugDosage());
        holder.drugFrequency.setText(note.getDrugFrequency());
        holder.drugRoute.setText(note.getDrugRoute());

        return convertView;
    }

    static class ViewHolder {
        TextView personName;
        TextView drugName;
        TextView drugDosage;
        TextView drugFrequency;
        TextView drugType;
        TextView drugRoute;
    }
}

