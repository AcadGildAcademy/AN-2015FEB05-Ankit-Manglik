package com.afewsomethings.todos;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    Button newNote;
    Button newTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
           DatabaseHand db = new DatabaseHand(this);
            db.addNote(new Notes("12/03/2014","to do","to do app"));



    }



}
