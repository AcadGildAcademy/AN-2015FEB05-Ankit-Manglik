package com.afewsomethings.learnintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.net.URI;


public class activity_home extends ActionBarActivity {

    Button ap;
    Button dev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_home);

        ap = (Button) findViewById(R.id.bt_app);

        ap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.techsupportalert.com/"));

                startActivity(intent);
            }
        });

        dev = (Button) findViewById(R.id.bt_dev);

        dev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentdev = new Intent(Intent.ACTION_VIEW, Uri.parse("market://search?q=pub:<google>"));

                startActivity(intentdev);
            }


        });


    }


    public void setmenu(View view) {

        Intent intentset = new Intent(this, settingmenu.class);

        startActivity(intentset);

    }
}