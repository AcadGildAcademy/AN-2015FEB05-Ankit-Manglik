package com.afewsomethings.amdb;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends ActionBarActivity {


    private ProgressDialog pDialog;
    private static String urlUpcoming =
            "http://api.themoviedb.org/3/movie/upcoming?api_key=8496be0b2149805afa458ab8ec27560c";
    private static String urlmostpopular =
            "http://api.themoviedb.org/3/movie/popular?api_key=8496be0b2149805afa458ab8ec27560c";
    private static String urlLatest =
            "http://api.themoviedb.org/3/movie/latest?api_key=8496be0b2149805afa458ab8ec27560c";
    private static String urlNowplaying =
            "http://api.themoviedb.org/3/movie/now_playing?api_key=8496be0b2149805afa458ab8ec27560c";
    private static String urlTopRated =
            "http://api.themoviedb.org/3/movie/top_rated?api_key=8496be0b2149805afa458ab8ec27560c";
    private static String urlMyfavs =
            "http://api.themoviedb.org/3/guest_session/bd1591b96f0dda267427894b19d07502/rated_movies?api_key=8496be0b2149805afa458ab8ec27560c";
    private static String urlMywatchList =
            "http://api.themoviedb.org/3/guest_session/bd1591b96f0dda267427894b19d07502/rated_movies?api_key=8496be0b2149805afa458ab8ec27560c";


    public String urltoUse = null;



    ListView mlistview;
    public List<HashMap<String, String>> list =null;
    public final static int GET = 1;
    private static final String TAG_RESULT = "results";
    private static final String TAG_TITLE = "original_title";
    private static final String TAG_ID = "id";
    private static final String TAG_RELEASEDT = "release_date";
    private static final String TAG_RATING_AVG= "vote_average";
    private static final String TAG_POSTER_PATH= "poster_path";


    JSONArray movies = null;

    ArrayList<MoviesDB> all_movies;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mlistview = (ListView)findViewById(R.id.lv_movielist);

        getActionBar();
        new GetMovies().execute(urlUpcoming);
        mlistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MoviesDB pos = all_movies.get(position);
                String movieName = pos.getMname();
                Toast.makeText(getApplicationContext(), movieName, Toast.LENGTH_SHORT).show();
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()){
            case R.id.mostpopular:
                new GetMovies().execute(urlmostpopular);
                urltoUse = urlmostpopular;
                break;
            case R.id.upcoming:
                new GetMovies().execute(urlUpcoming);
                urltoUse = urlUpcoming;
                break;

            case R.id.latest:
                new GetMovies().execute(urlLatest);
                urltoUse = urlLatest;
                break;

            case R.id.nowplaying:
                new GetMovies().execute(urlNowplaying);
                urltoUse = urlNowplaying;
                break;

            case R.id.toprated:

                new GetMovies().execute(urlTopRated);
                urltoUse = urlTopRated;

                break;
            case R.id.myFavorites:
                new GetMovies().execute(urlMyfavs);
                break;

            case R.id.myWatchlist:
                new GetMovies().execute(urlMywatchList);
                break;
        }

        //int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       // if (id == R.id.action_settings) {
         //   return true;
       // }

        return super.onOptionsItemSelected(item);
    }

    private class GetMovies extends AsyncTask<String, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        protected Void doInBackground(String... arg0) {
            // Creating service handler class instance
            HandleJSON sh = new HandleJSON();
            all_movies = new ArrayList<MoviesDB>();
            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(arg0[0], HandleJSON.GET);

            Log.d("Response: ", "> " + jsonStr);

            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting JSON Array node
                    movies = jsonObj.getJSONArray(TAG_RESULT);

                    // looping through All Contacts
                    for (int i = 0; i < movies.length(); i++) {
                        JSONObject c = movies.getJSONObject(i);
                        MoviesDB single_movie = new MoviesDB();
                        String id = c.getString(TAG_ID);
                        String name = c.getString(TAG_TITLE);
                        String releaseDate = c.getString(TAG_RELEASEDT);
                        String rating = c.getString(TAG_RATING_AVG);
                        String posterPath = c.getString(TAG_POSTER_PATH);


                        // tmp hashmap for single contact
                        //HashMap<String, String> movie = new HashMap<String, String>();
                        // adding each child node to HashMap key => value
                        //movie.put(TAG_ID, id);
                        //movie.put(TAG_TITLE, name);
                        //movie.put(TAG_RELEASEDT, releaseDate);
                        //movie.put(TAG_RATING_AVG, rating);

                        // adding contact to contact list

                        single_movie.setmId(id);
                        single_movie.setMname(name);
                        single_movie.setMreleasedate(releaseDate);
                        single_movie.setMvoteavg(rating);
                        single_movie.setMposterpath(posterPath);

                        all_movies.add(single_movie);

                        //list.add(movie);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                Log.e("ServiceHandler", "Couldn't get any data from the url");
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            pDialog.cancel();
            Myadapter myadapter = new Myadapter(MainActivity.this,all_movies);
            mlistview.setAdapter(myadapter);

        }


    }



}