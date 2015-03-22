package com.afewsomethings.learnintent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class activity_home extends ActionBarActivity {

    Button ap;
    Button dev;
    Button search;
    Button download;
    EditText searchtxt;

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
                Intent intentdev = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com/search?q=pub:<google>"));

                startActivity(intentdev);
            }


        });

        search = (Button) findViewById(R.id.bt_search);
        searchtxt = (EditText) findViewById(R.id.et_search);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent isearch = new Intent(activity_home.this, settingmenu.class);

                Bundle bund = new Bundle();
                bund.putString("KEY_SEARCH", searchtxt.getText().toString());
                isearch.putExtras(bund);
                startActivity(isearch);

            }
        });

        download = (Button) findViewById(R.id.bt_download);

        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               Intent idownload= new Intent(activity_home.this, downloadbars.class);

                startActivity(idownload);


            }
        });

    }



    public void setmenu(View view) {

        Intent intentset = new Intent(activity_home.this, settingmenu.class);

        startActivity(intentset);

    }




}