package com.afewsomethings.todos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ankit on 21-03-2015.
 */
public class MyAdapt extends ArrayAdapter {

    Context context;
    List<Notes> notesList;


    public MyAdapt(Context context, List<Notes> notesList){

        super(context,R.layout.noteview);
        this.context = context;
        this.notesList =notesList;
    }

    public int getCount(){
        if (notesList.size()>0)
        return notesList.size();
        else
            return 0;

    }


@Override

    public View getView(int position, View convertView,ViewGroup parent){

    LayoutInflater inflater= (LayoutInflater)
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    View rowView = inflater.inflate(R.layout.noteview, parent, false);
    TextView noteTitle = (TextView) rowView.findViewById(R.id.tv_NoteTitle);
    TextView noteDetails = (TextView) rowView.findViewById(R.id.tv_NoteDetails);
    TextView notedate = (TextView) rowView.findViewById(R.id.tv_Noteduedate);

    noteTitle.setText(notesList.get(position).getNote());
    noteDetails.setText(notesList.get(position).getNoteDetails());
    notedate.setText(notesList.get(position).getDate());



    return rowView;
}



}
