package com.afewsomethings.learnintent;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

/**
 * Created by ankit on 16-03-2015.
 */
public class downloadbars extends ActionBarActivity{
    Button downloadbar;
    ProgressBar progbar1;
    ProgressBar progbar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.download);

        downloadbar = (Button)findViewById(R.id.bt_downbar);
        progbar1=(ProgressBar)findViewById(R.id.pb_1);
        progbar2=(ProgressBar)findViewById(R.id.pb_2);

        downloadbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Async AT= new Async();
                AT.execute("Start");

            }

            class Async extends AsyncTask<String,Integer,String> {

                @Override
                protected String doInBackground(String... params) {
                   for(int i=1;i<100;i++){

                       publishProgress(i);

                       try {
                           Thread.sleep(1000);
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                   }
                    return null;
                }


                @Override
                protected void onPreExecute() {
                    super.onPreExecute();
                    progbar1.setProgress(0);
                }


                @Override
                protected void onPostExecute(String s) {
                    super.onPostExecute(s);
                    progbar1.setVisibility(View.INVISIBLE);
                }


                @Override
                protected void onProgressUpdate(Integer... values) {
                    super.onProgressUpdate(values);

                    progbar1.setProgress(values[0]);


                }
            }
        });
    }
}
