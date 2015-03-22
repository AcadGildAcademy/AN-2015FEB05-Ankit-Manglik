package com.afewsomethings.todos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ankit on 17-03-2015.
 */
public class DatabaseHand extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "notestask";
    private static final String TABLE_NOTES= "notes";
    private static final String KEY_ID = "id";
    private static final String KEY_DATE ="date";
    private static final String KEY_NOTE = "note";
    private static final String KEY_NOTE_DETAILS ="details";


    public DatabaseHand(Context context){super (context,DATABASE_NAME, null,DATABASE_VERSION);}




    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_NOTES_TABLE = "CREATE TABLE "+ TABLE_NOTES + "("
                + KEY_ID +" INTEGER PRIMARY KEY,"
                + KEY_DATE + " DATE,"
                + KEY_NOTE + " TEXT"
                + KEY_NOTE_DETAILS + " TEXT"
                +")";

        db.execSQL(CREATE_NOTES_TABLE);


    }


    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NOTES);
        onCreate(db);

    }

    void addNote (Notes notes){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_DATE, notes.getDate());
        values.put(KEY_NOTE,notes.getNote());
        values.put(KEY_NOTE_DETAILS,notes.getNoteDetails());
        db.insert(TABLE_NOTES,null,values);
        db.close();


    }

















}
