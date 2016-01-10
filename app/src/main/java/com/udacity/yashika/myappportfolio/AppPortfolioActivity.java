package com.udacity.yashika.myappportfolio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.octo.android.robospice.SpiceManager;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;
import com.udacity.yashika.myappportfolio.popular_movies.PopularMoviesUtils;
import com.udacity.yashika.myappportfolio.popular_movies.model.MovieResponse;
import com.udacity.yashika.myappportfolio.popular_movies.request.MovieRequest;
import com.udacity.yashika.myappportfolio.popular_movies.service.MovieService;
import com.udacity.yashika.myappportfolio.popular_movies.ui.MovieListActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AppPortfolioActivity extends AppCompatActivity {

    private static final String TAG = MovieListActivity.class.getSimpleName();
    @Bind(R.id.app_progress_frame_layout)
    FrameLayout progressBarFrame;
    @Bind(R.id.app_progress_bar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.spotify_streamer)
    public void onSpotifyClick(View view) {
        final SpiceManager movieSpiceManger = new SpiceManager(MovieService.class);
        MovieRequest movieRequest = new MovieRequest(PopularMoviesUtils.MOVIE_API_KEY);
        if(!movieSpiceManger.isStarted()) {
            movieSpiceManger.start(this);
        }
        progressBarFrame.setVisibility(View.VISIBLE);
        progressBarFrame.setClickable(true);
        movieSpiceManger.execute(movieRequest, new MovieResponseListener());
    }

    @OnClick(R.id.football_score)
    public void onFootballScoreClick(View view) {
        Toast.makeText(this, getString(R.string.button_toast) + " " + getString(R.string.football_scores_app), Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.library)
    public void onLibraryClick(View view) {
        Toast.makeText(this, getString(R.string.button_toast) + " " + getString(R.string.library_app), Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.build_it_bigger)
    public void onBuildItBiggerClick(View view) {
        Toast.makeText(this, getString(R.string.button_toast) + " " + getString(R.string.build_it_bigger), Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.xyz_reader)
    public void onXyzReaderClick(View view) {
        Toast.makeText(this, getString(R.string.button_toast) + " " + getString(R.string.xyz_reader), Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.capstone)
    public void onCapstoneClick(View view) {
        Toast.makeText(this, getString(R.string.button_toast) + " " + getString(R.string.capstone), Toast.LENGTH_SHORT).show();
    }

    private class MovieResponseListener implements RequestListener<MovieResponse> {

        @Override
        public void onRequestFailure(SpiceException spiceException) {
            if(progressBarFrame != null && progressBarFrame.getVisibility() == View.VISIBLE) {
                progressBarFrame.setVisibility(View.GONE);
            }
            // Todo: This is to be filled with whatever has to happen when it fails.
            Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onRequestSuccess(MovieResponse movieResponse) {
            if(progressBarFrame != null && progressBarFrame.getVisibility() == View.VISIBLE) {
                progressBarFrame.setVisibility(View.GONE);
            }
            // Todo: This is when the call goes through and you get a response. Check if success and do the needful.
            Toast.makeText(getApplicationContext(), "SUCCESS", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(AppPortfolioActivity.this, MovieListActivity.class);
            Bundle bundle = new Bundle();
            bundle.putParcelable(TAG, movieResponse);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }
}
