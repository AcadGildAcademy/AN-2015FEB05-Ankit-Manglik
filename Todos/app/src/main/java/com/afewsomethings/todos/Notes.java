package com.afewsomethings.todos;

/**
 * Created by ankit on 17-03-2015.
 */
public class Notes {
    int _id;
   String note;
    String date;
    String time;
    String noteDetails;

    public Notes(){
            }

    public Notes(int id,String date, String note, String noteDetails){
        super();
        this._id=id;
        this.date=date;
        this.note=note;
        this.noteDetails=noteDetails;
            }

    public String getDate(){return date;}
    public String getNote(){return note;}
    public String getNoteDetails(){return noteDetails;}
    public  int getId(){return _id;}
    public void setId(int id){
        this._id = id;
    }
    public void setDate(String date){this.date = date;}
    public void setNote(String note){this.note = note;}
    public void  setNoteDetails(String noteDetails){this.noteDetails=noteDetails;}




}
