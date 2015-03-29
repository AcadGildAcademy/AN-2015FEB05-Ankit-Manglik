package com.afewsomethings.todos;

/**
 * Created by ankit on 17-03-2015.
 */
public class Notes {
    int _id;
   String _note;
    String _date;
    String _time;
    String _noteDetails;
    private int status;

    public Notes(){
            }

    public Notes(String date, String note, String noteDetails, int status){
        super();

        this._date=date;
        this._note=note;
        this._noteDetails=noteDetails;
        this.status=status;
            }


    public Notes(String date, String note, String noteDetails){
        this._date=date;
        this._note=note;
        this._noteDetails=noteDetails;

    }

    public String getDate(){return this._date;}
    public String getNote(){return this._note;}
    public String getNoteDetails(){return this._noteDetails;}
    public  int getId(){return _id;}

    public void setId(int id){
        this._id = _id;
    }
    public void setDate(String date){this._date = date;}
    public void setNote(String note){this._note = note;}
    public void  setNoteDetails(String noteDetails){this._noteDetails=noteDetails;}


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
