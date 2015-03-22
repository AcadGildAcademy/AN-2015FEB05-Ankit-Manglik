package com.afewsomethings.todos;

/**
 * Created by ankit on 17-03-2015.
 */
public class Notes {

   String note;
    String date;
    String time;
    String noteDetails;

    public Notes(){
            }

    public Notes(String date, String note, String noteDetails){
        super();
        this.date=date;
        this.note=note;
        this.noteDetails=noteDetails;
            }

    public String getDate(){return date;}
    public String getNote(){return note;}
    public String getNoteDetails(){return noteDetails;}





}
