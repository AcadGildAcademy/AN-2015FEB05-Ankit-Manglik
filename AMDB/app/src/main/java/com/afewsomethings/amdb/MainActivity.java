package com.afewsomethings.amdb;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends ListActivity {

    ListView movielist;
    private ProgressDialog pDialog;
    private static String urllatest = "http://api.themoviedb.org/3/movie/latest?api_key=8496be0b2149805afa458ab8ec27560c";

    private static final String TAG_TITLE = "original_title";
    private static final String TAG_ID = "id";
    private static final String TAG_RELEASEDT = "release_date";
    private static final String TAG_RATING_AVG= "vote_average";
    private static final String TAG_POSTER_PATH= "poster_path";
    JSONArray movies = null;
    ArrayList<HashMap<String, String>> mlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mlist = new ArrayList<HashMap<String, String>>();
        movielist = getListView();




        getActionBar();
        new GetMovies().execute();
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
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class GetMovies extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        protected Void doInBackground(Void... arg0) {
            // Creating service handler class instance
            HandleJSON sh = new HandleJSON();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(urllatest, HandleJSON.GET);

            Log.d("Response: ", "> " + jsonStr);

            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting JSON Array node
                    movies = jsonObj.getJSONArray(TAG_TITLE);

                    // looping through All Contacts
                    for (int i = 0; i < movies.length(); i++) {
                        JSONObject c = movies.getJSONObject(i);

                        String id = c.getString(TAG_ID);
                        String name = c.getString(TAG_TITLE);
                        String releaseDate = c.getString(TAG_RELEASEDT);
                        String rating = c.getString(TAG_RATING_AVG);
                        String posterPath = c.getString(TAG_POSTER_PATH);


                        // tmp hashmap for single contact
                        HashMap<String, String> movie = new HashMap<String, String>();
                        // adding each child node to HashMap key => value
                        movie.put(TAG_ID, id);
                        movie.put(TAG_TITLE, name);
                        movie.put(TAG_RELEASEDT, releaseDate);
                        movie.put(TAG_RATING_AVG, rating);

                        // adding contact to contact list
                        mlist.add(movie);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                Log.e("ServiceHandler", "Couldn't get any data from the url");
            }
            return null;
        }

        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();

            ListAdapter adapter = new SimpleAdapter(
                    MainActivity.this, mlist,
                    R.layout.movielisting, new String[]{TAG_TITLE, TAG_RELEASEDT,
                    TAG_RATING_AVG}, new int[]{R.id.tv_movieName,
                    R.id.tv_releasedDate, R.id.tv_ratingDetails});

            setListAdapter(adapter);


        }
    }
}