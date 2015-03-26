package com.afewsomethings.todos;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends ActionBarActivity {

    Button newNote;
    Button newTask;
    DatabaseHand db = new DatabaseHand(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

            db.addNote(new Notes(1,"12/03/2014","to do","to do app"));


    }








}
