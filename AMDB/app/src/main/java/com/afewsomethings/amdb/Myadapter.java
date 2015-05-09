package com.afewsomethings.amdb;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ankit on 29-04-2015.
 */
public class Myadapter extends ArrayAdapter<MoviesDB> {
Context context;
Activity activity;
List<MoviesDB> moviesDBList;

ImageLoader imageLoader;

    public Myadapter(Context context, List<MoviesDB> moviesDBList) {
        super(context, R.layout.activity_main);

        this.context=context;
        this.moviesDBList=moviesDBList;
        imageLoader = new ImageLoader(this.getContext());

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
        RatingBar ratingStars = (RatingBar)rowView.findViewById(R.id.ratingBar);
        String ratingString =  moviesDBList.get(position).getMvoteavg();
        float ratingval = Float.parseFloat(ratingString);
        String imageURL= "http://image.tmdb.org/t/p/" +"w500"+moviesDBList.get(position).getMposterpath();

        //"http://image.tmdb.org/t/p/w500/8uO0gUM8aNqYLs1OsTBQiXu0fEv.jpg\n";


        ImageView poster= (ImageView)rowView.findViewById(R.id.iv_movieposter);

        moviewName.setText(moviesDBList.get(position).getMname());
        releaseDate.setText(moviesDBList.get(position).getMreleasedate());
        ratingDetails.setText(moviesDBList.get(position).getMvoteavg());
        ratingStars.setRating((ratingval/2));
       imageLoader.DisplayImage(imageURL,poster);

        return rowView;
    }




}
