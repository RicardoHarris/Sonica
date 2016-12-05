package com.example.student.sonica;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer song1;
    Button playButtonVar;
    Button pauseButtonVar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        song1 = MediaPlayer.create(this, R.raw.glaringlyablaze);
        playButtonVar = (Button) findViewById(R.id.ply);
        pauseButtonVar = (Button) findViewById(R.id.pse);
    }
    public void playSong(View view) {
        song1.start();
        pauseButtonVar.setEnabled(false);
        playButtonVar.setEnabled(true);
    }
    public void pauseSong(View view) {
        song1.start();
        pauseButtonVar.setEnabled(true);
        playButtonVar.setEnabled(false);
    }
}
