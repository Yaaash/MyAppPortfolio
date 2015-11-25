package com.udacity.yashika.myappportfolio;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // setting view ID's
        Button spotifyStreamer = (Button) findViewById(R.id.spotify_streamer);
        Button footballScore = (Button) findViewById(R.id.football_score);
        Button libraryApp = (Button) findViewById(R.id.library);
        Button buildItBigger = (Button) findViewById(R.id.build_it_bigger);
        Button xyzReader = (Button) findViewById(R.id.xyz_reader);
        Button capstone = (Button) findViewById(R.id.capstone);

        // setting on Click listeners
        spotifyStreamer.setOnClickListener(this);
        footballScore.setOnClickListener(this);
        libraryApp.setOnClickListener(this);
        buildItBigger.setOnClickListener(this);
        xyzReader.setOnClickListener(this);
        capstone.setOnClickListener(this);
    }

    @Override
    public void onClick (View v) {
        int id = v.getId();

        switch (id) {

            case R.id.spotify_streamer:
                Toast.makeText(this, getString(R.string.button_toast) + " " + getString(R.string.spoitfy_streamer), Toast.LENGTH_SHORT).show();
                break;

            case R.id.football_score:
                Toast.makeText(this, getString(R.string.button_toast) +  " " + getString(R.string.football_scores_app), Toast.LENGTH_SHORT).show();
                break;

            case R.id.library:
                Toast.makeText(this, getString(R.string.button_toast) +  " " + getString(R.string.library_app), Toast.LENGTH_SHORT).show();
                break;

            case R.id.build_it_bigger:
                Toast.makeText(this, getString(R.string.button_toast) +  " " + getString(R.string.build_it_bigger), Toast.LENGTH_SHORT).show();
                break;

            case R.id.xyz_reader:
                Toast.makeText(this, getString(R.string.button_toast) +  " " + getString(R.string.xyz_reader), Toast.LENGTH_SHORT).show();
                break;

            case R.id.capstone:
                Toast.makeText(this, getString(R.string.button_toast) +  " " + getString(R.string.capstone), Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
