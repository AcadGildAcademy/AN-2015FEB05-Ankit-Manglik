package com.afewsomethings.amdb;

/**
 * Created by ankit on 12-05-2015.
 */
public class MovieDetailsDB {
    String mname,mreleasedate,mvoteavg,mposterpath,mId,mtagLine,moverView,mrevenue,mStatus;


    public MovieDetailsDB(){}

    public MovieDetailsDB(String mId,String mname, String mreleasedate,
                          String mvoteavg, String mposterpath,String mtagLine,String moverView, String mrevenue,
    String mStatus){
        this.mId=mId;
        this.mname=mname;
        this.mreleasedate=mreleasedate;
        this.mvoteavg=mvoteavg;
        this.mposterpath=mposterpath;
        this.mtagLine=mtagLine;
        this.moverView=moverView;
        this.mrevenue=mrevenue;

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

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getMtagLine() {
        return mtagLine;
    }

    public void setMtagLine(String mtagLine) {
        this.mtagLine = mtagLine;
    }

    public String getMoverView() {
        return moverView;
    }

    public void setMoverView(String moverView) {
        this.moverView = moverView;
    }

    public String getMrevenue() {
        return mrevenue;
    }

    public void setMrevenue(String mrevenue) {
        this.mrevenue = mrevenue;
    }

    public String getmStatus() {
        return mStatus;
    }

    public void setmStatus(String mStatus) {
        this.mStatus = mStatus;
    }
}
