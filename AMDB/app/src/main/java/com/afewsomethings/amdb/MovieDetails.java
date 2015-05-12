package com.afewsomethings.amdb;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;


public class MovieDetails extends ActionBarActivity {
    private ProgressDialog pDialog;
    public final static int GET = 1;
    private static final String TAG_RESULT = "results";
    private static final String TAG_TITLE = "original_title";
    private static final String TAG_ID = "id";
    private static final String TAG_RELEASEDT = "release_date";
    private static final String TAG_RATING_AVG= "vote_average";
    private static final String TAG_POSTER_PATH= "poster_path";
    TextView movieName,movieRelease,movieRevenue,movieTagline,movieBudget,movieStatus;
    JSONObject moviesDetails = null;
    MovieDetailsDB movieD;
    private static String urlUpcoming =
            "http://api.themoviedb.org/3/movie/76170?api_key=8496be0b2149805afa458ab8ec27560c";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        getActionBar();
        new GetMovies().execute(urlUpcoming);
        movieName = (TextView)findViewById(R.id.tv_movieNameD);
        movieName.setText(movieD.getMname());


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_movie_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class GetMovies extends AsyncTask<String, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(MovieDetails.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        protected Void doInBackground(String... arg0) {
            // Creating service handler class instance
            HandleJSON sh = new HandleJSON();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(arg0[0], HandleJSON.GET);

            Log.d("Response: ", "> " + jsonStr);

            if (jsonStr != null) {
                try {
                    moviesDetails = new JSONObject(jsonStr);

                        String id = moviesDetails.getString(TAG_ID);
                        String name = moviesDetails.getString(TAG_TITLE);
                        String releaseDate = moviesDetails.getString(TAG_RELEASEDT);
                        String rating = moviesDetails.getString(TAG_RATING_AVG);
                        String posterPath = moviesDetails.getString(TAG_POSTER_PATH);
                        movieD = new MovieDetailsDB();

                        movieD.setmId(id);
                        movieD.setMname(name);
                        movieD.setMreleasedate(releaseDate);
                        movieD.setMvoteavg(rating);
                        movieD.setMposterpath(posterPath);
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


        }


    }
}
