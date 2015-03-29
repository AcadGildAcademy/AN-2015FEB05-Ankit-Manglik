package com.afewsomethings.todos;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends ActionBarActivity {

    Button newNote;
    Button newTask;
    DatabaseHand db = new DatabaseHand(this);
    ListView lv;
    List<Notes> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

      //  db.addNote(new Notes("12/03/2014","to do","to do app",0));
        lv=(ListView)findViewById(R.id.listView) ;
        list =db.getAllNotes();
        MyAdapt adap=new MyAdapt(this,list);
        lv.setAdapter(adap);
        getActionBar();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menubar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //@Override
    private void notesdialog (){
        LayoutInflater nd=LayoutInflater.from(this);
        View promptnote=nd.inflate(R.layout.activity_save_note,null);
        final AlertDialog.Builder alertnote=new AlertDialog.Builder(this);
        alertnote.setView(promptnote);
        alertnote.setCancelable(false);
        alertnote.setPositiveButton("SAVE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EditText date1 = (EditText)findViewById(R.id.et_date);
                EditText NoteHead1 = (EditText)findViewById(R.id.et_newnotehead);
                EditText NoteDetails1 = (EditText)findViewById(R.id.et_notedetails);
                String date = date1.getText().toString();
                String NoteHead=NoteHead1.getText().toString();
                String NoteDetails=NoteDetails1.getText().toString();
                db.addNote(new Notes(date,NoteHead,NoteDetails,0));
            }
        });
        alertnote.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertnote.show();

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.not: notesdialog();
            break;
        }
        return super.onOptionsItemSelected(item);

    }


}
