package com.afewsomethings.learnintent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.bluetooth.BluetoothAdapter;
import android.widget.TextView;

/**
 * Created by ankit on 07-03-2015.
 */
public class settingmenu extends ActionBarActivity {

    Button wifi;
    Button blue;
    Button user;
    TextView searcht;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        searcht=(TextView)findViewById(R.id.tv_search);
        Bundle bund=getIntent().getExtras();

        if (bund!=null){
            String searchtxt = bund.getString("KEY_SEARCH");
            searcht.setText(searchtxt);
        }


        wifi = (Button) findViewById(R.id.bt_wifi);
        blue = (Button) findViewById(R.id.bt_blue);
        user = (Button) findViewById(R.id.bt_account);



        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it_wifi=new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);

                startActivity(it_wifi);
            }
        });






    }
}
