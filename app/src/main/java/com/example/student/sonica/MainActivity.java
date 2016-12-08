package com.example.student.sonica;

import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer song1;
    public Button playButtonVar, pauseButtonVar, rewindButtonVar, fastForwardButtonVar, stopButtonVar;
    public TextView currentTimeVar, endTimeVar;
    public double endTimeMS = song1.getDuration();
    public Handler myHandler = new Handler();
    public int currentTimeMS = song1.getCurrentPosition();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        song1 = MediaPlayer.create(this, R.raw.glaringlyablaze);

        playButtonVar = (Button) findViewById(R.id.ply);
        pauseButtonVar = (Button) findViewById(R.id.pse);
        rewindButtonVar = (Button) findViewById(R.id.rwn);
        stopButtonVar = (Button) findViewById(R.id.stop);
        fastForwardButtonVar = (Button) findViewById(R.id.fwd) ;

        pauseButtonVar.setEnabled(false);
        stopButtonVar.setEnabled(false);
        int endTimeMin = (int) endTimeMS/1000/60;
        int endTimeS = (int) (endTimeMS/1000) % 60;
        int currentMinutes =(int) (currentTimeMS/1000/60);
        int currentSeconds = (int)((currentTimeMS/1000) %60);

        myHandler.postDelayed(UpdateSongTime, 100);
        //endTimeMS.setText("Text");
    }
    public void playSong(View view) {
        Toast.makeText(getApplicationContext(), "Playing song",Toast.LENGTH_SHORT).show();
        song1.start();
        pauseButtonVar.setEnabled(true);
        playButtonVar.setEnabled(false);
        stopButtonVar.setEnabled(true);
    }
    public void pauseSong(View view) {
        Toast.makeText(getApplicationContext(), "Pausing song",Toast.LENGTH_SHORT).show();
        song1.pause();
        pauseButtonVar.setEnabled(false);
        playButtonVar.setEnabled(true);
    }


    public void stopSong(View view){
        Toast.makeText(getApplicationContext(), "Stopping song",Toast.LENGTH_SHORT).show();
        song1.pause();
        pauseButtonVar.setEnabled(false);
        playButtonVar.setEnabled(true);
        stopButtonVar.setEnabled(false);
        song1.seekTo(0);
        song1.pause();
    }

    public void fastForwardSong(View view){

    }

    public void rewindSong(View view){

    }
    private Runnable UpdateSongTime = new Runnable() {
        @Override
        public void run() {
            currentTimeMS = song1.getCurrentPosition();
            int currentTimeMin = (int) currentTimeMS/1000/60;
            int currentTimeMS = (int) (currentTimeMin/1000) % 60;

            myHandler.postDelayed(this, 100);
        }
    };
}
