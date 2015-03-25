package com.afewsomethings.todos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.List;

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
    private static final String KEY_STATUS= "status";



    public DatabaseHand(Context context){super (context,DATABASE_NAME, null,DATABASE_VERSION);}

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_NOTES_TABLE = "CREATE TABLE "+ TABLE_NOTES + "("
                + KEY_ID +" INTEGER PRIMARY KEY,"
                + KEY_DATE + " DATE,"
                + KEY_NOTE + " TEXT"
                + KEY_NOTE_DETAILS + " TEXT"
                + KEY_STATUS + " INTEGER"
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
        values.put(KEY_STATUS,"0");
        db.insert(TABLE_NOTES,null,values);
        db.close();


        void getNote (int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NOTES, new String[]{ KEY_ID, KEY_DATE,KEY_NOTE,
                KEY_NOTE_DETAILS},KEY_ID+"=?",
                new String[]{String.valueOf(id) }, null, null,null,null);
                if (cursor !=null)
                    cursor.moveToFirst();
                Notes note = new Notes(Integer.parseInt(cursor.getString(0)),
                        cursor.getString(1), cursor.getString(2), cursor.getString(3));

            return note;
    }

    public List<Notes> getAllNotes(){

        List<Notes> notesList= new ArrayList<Notes>();
        String selectQuery = "SELECT * FROM " + TABLE_NOTES;

        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()){
            do {
             Notes notes = new Notes();
             notes.setId(Integer.parseInt(cursor.getString(0)));
             notes.setNote(cursor.getString(1));
                notesList.add(notes);
            } while (cursor.moveToNext());
        }

        return notesList;

    }



    }

















}
