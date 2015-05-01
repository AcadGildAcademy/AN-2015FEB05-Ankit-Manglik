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

List<MoviesDB> moviesDBList;

    public Myadapter(Context context, List<MoviesDB> moviesDBList) {
        super(context, R.layout.activity_main);

        this.context=context;
        this.moviesDBList=moviesDBList;
    }

    public int getCount(){
        if (moviesDBList.size()>0)
            return moviesDBList.size();
        else
            return 0;
    }

    @Override
    public View getView(int position, View convertView,ViewGroup parent){
        LayoutInflater inflater= (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.movielisting, parent, false);
        TextView moviewName = (TextView) rowView.findViewById(R.id.tv_movieName);
        TextView releaseDate = (TextView) rowView.findViewById(R.id.tv_releasedDate);
        TextView ratingDetails = (TextView) rowView.findViewById(R.id.tv_ratingDetails);

        moviewName.setText(moviesDBList.get(position).getMname());
        releaseDate.setText(moviesDBList.get(position).getMreleasedate());
        ratingDetails.setText(moviesDBList.get(position).getMvoteavg());


        return rowView;
    }




}
