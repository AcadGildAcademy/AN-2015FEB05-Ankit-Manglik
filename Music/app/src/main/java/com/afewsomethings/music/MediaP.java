package com.afewsomethings.music;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import java.io.IOException;

/**
 * Created by ankit on 31-03-2015.
 */
public class MediaP extends Service {
    MediaPlayer mp = MediaPlayer.create(this, R.raw.aap);

    @Override
    public IBinder onBind(Intent intent) {
        return null;

    }

    public void onCreate(){
        super.onCreate();
        try {

            mp.prepare();
            mp.start();
            mp.setLooping(true);
        } catch (IOException e) {
            e.printStackTrace();
        }

            }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mp.stop();
        mp.release();
    }
}
