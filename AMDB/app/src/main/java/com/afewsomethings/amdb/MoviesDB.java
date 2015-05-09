package com.afewsomethings.amdb;

/**
 * Created by ankit on 01-05-2015.
 */
public class MoviesDB {
    String mname,mreleasedate,mvoteavg,mposterpath,mId;

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public MoviesDB(){}

    public MoviesDB (String mId,String mname, String mreleasedate, String mvoteavg, String mposterpath){
        this.mId=mId;
        this.mname=mname;
        this.mreleasedate=mreleasedate;
        this.mvoteavg=mvoteavg;
        this.mposterpath=mposterpath;


    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMreleasedate() {
        return mreleasedate;
    }

    public void setMreleasedate(String mreleasedate) {
        this.mreleasedate = mreleasedate;
    }

    public String getMvoteavg() {
        return mvoteavg;
    }

    public void setMvoteavg(String mvoteavg) {
        this.mvoteavg = mvoteavg;
    }

    public String getMposterpath() {
        return mposterpath;
    }

    public void setMposterpath(String mposterpath) {
        this.mposterpath = mposterpath;
    }
}
