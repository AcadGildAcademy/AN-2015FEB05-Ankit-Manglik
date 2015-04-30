package com.afewsomethings.amdb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ankit on 29-04-2015.
 */
public class Myadapter extends ArrayAdapter {
Context context;

    public Myadapter(Context context, int resource) {
        super(context, resource);

        this.context=context;

    }

//    public int getCount(){
//        if (notesList.size()>0)
//            return notesList.size();
//        else
//            return 0;
//    }

    @Override
    public View getView(int position, View convertView,ViewGroup parent){
        LayoutInflater inflater= (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.movielisting, parent, false);
        TextView moviewName = (TextView) rowView.findViewById(R.id.tv_movieName);
        TextView releaseDate = (TextView) rowView.findViewById(R.id.tv_releasedDate);
        TextView ratingDetails = (TextView) rowView.findViewById(R.id.tv_ratingDetails);
        return rowView;
    }




}
