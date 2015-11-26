package com.udacity.yashika.myappportfolio;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.spotify_streamer)
    public void onSpotifyClick (View view) {
        Toast.makeText(this, getString(R.string.button_toast) + " " + getString(R.string.spoitfy_streamer), Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.football_score)
    public void onFootballScoreClick (View view) {
        Toast.makeText(this, getString(R.string.button_toast) + " " + getString(R.string.football_scores_app), Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.library)
    public void onLibraryClick (View view) {
        Toast.makeText(this, getString(R.string.button_toast) + " " + getString(R.string.library_app), Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.build_it_bigger)
    public void onBuildItBiggerClick (View view) {
        Toast.makeText(this, getString(R.string.button_toast) + " " + getString(R.string.build_it_bigger), Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.xyz_reader)
    public void onXyzReaderClick (View view) {
        Toast.makeText(this, getString(R.string.button_toast) + " " + getString(R.string.xyz_reader), Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.capstone)
    public void onCapstoneClick (View view) {
        Toast.makeText(this, getString(R.string.button_toast) + " " + getString(R.string.capstone), Toast.LENGTH_SHORT).show();
    }
}
