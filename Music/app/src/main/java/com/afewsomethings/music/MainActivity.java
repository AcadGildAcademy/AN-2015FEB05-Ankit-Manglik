package com.afewsomethings.music;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {
    MediaPlayer mp = MediaPlayer.create(this, R.raw.aap);
    Button start, stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       start = (Button)findViewById(R.id.bt_play);
        stop = (Button)findViewById(R.id.bt_stop);

       start.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

             Intent intent = new Intent(MainActivity.this,MediaP.class);
             startService(intent);

           }

        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MediaP.class);
                stopService(intent);
            }
        });



    }


}
