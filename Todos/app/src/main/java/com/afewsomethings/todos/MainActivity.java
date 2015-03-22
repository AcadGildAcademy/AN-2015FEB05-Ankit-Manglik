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
        setContentView(R.layout.activity_note);




        DatabaseHand db = new DatabaseHand(this);



    }



}
