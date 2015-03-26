package com.afewsomethings.todos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.util.Log;

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
                + KEY_NOTE + " TEXT,"
                + KEY_NOTE_DETAILS + " TEXT"
                + KEY_STATUS + " INTEGER"
                +")";

        db.execSQL(CREATE_NOTES_TABLE);

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NOTES);
        onCreate(db);

    }

    void addNote (Notes notes) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_DATE, notes.getDate());
        values.put(KEY_NOTE, notes.getNote());
        values.put(KEY_NOTE_DETAILS, notes.getNoteDetails());
        values.put(KEY_STATUS, "0");
        db.insert(TABLE_NOTES, null, values);
        db.close();
    }

        public Notes getNote(int id) {

        String query = "SELECT * FROM " + TABLE_NOTES + "WHERE "+ KEY_ID + " = \"" + id;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        Notes note = new Notes();
            if (cursor.moveToFirst()){
                    cursor.moveToFirst();
                    note.setId(Integer.parseInt(cursor.getString(0)));
                    note.setDate(cursor.getString(1));
                    note.setNote(cursor.getString(2));
                note.setNoteDetails(cursor.getString(3));
                cursor.close();
            } else note = null;

            db.close();
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
             notes.setDate(cursor.getString(1));
             notes.setNote(cursor.getString(2));
             notesList.add(notes);

            } while (cursor.moveToNext());
        }

        return notesList;

    }


    }
