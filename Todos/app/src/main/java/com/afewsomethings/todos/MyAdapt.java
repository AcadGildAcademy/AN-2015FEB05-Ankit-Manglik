package com.afewsomethings.todos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ankit on 21-03-2015.
 */
public class MyAdapt extends ArrayAdapter {

    Context context;
    ArrayList<Notes>notesArrayList;


    public MyAdapt(Context context, ArrayList<Notes> notesArrayList){

        super(context,R.layout.noteview);
        this.context = context;
        this.notesArrayList =notesArrayList;
    }

    public int getCount(){
        return notesArrayList.size();

    }


@Override

    public View getView(int position, View convertView,ViewGroup parent){

    LayoutInflater inflater= (LayoutInflater)
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    View rowView = inflater.inflate(R.layout.noteview, parent, false);
    TextView noteTitle = (TextView) rowView.findViewById(R.id.tv_NoteTitle);
    TextView noteDetails = (TextView) rowView.findViewById(R.id.tv_NoteDetails);
    TextView notedate = (TextView) rowView.findViewById(R.id.tv_Noteduedate);

    noteTitle.setText(notesArrayList.get(position).getNote());
    noteDetails.setText(notesArrayList.get(position).getNoteDetails());
    notedate.setText(notesArrayList.get(position).getDate());



    return rowView;
}



}
