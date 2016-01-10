package com.udacity.yashika.myappportfolio.popular_movies.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.udacity.yashika.myappportfolio.R;

/**
 * An activity representing a single Movie detail screen. This activity is only used narrow width
 * devices. On tablet-size devices, item details are presented side-by-side with a list of items in
 * a {@link MovieListActivity}.
 */
public class MovieDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        // savedInstanceState is non-null when there is fragment state
        // saved from previous configurations of this activity
        // (e.g. when rotating the screen from portrait to landscape).
        // In this case, the fragment will automatically be re-added
        // to its container so we don't need to manually add it.
        if(savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putParcelable(MovieDetailFragment.MOVIE_DETAIL_TAG,
                                    getIntent().getParcelableExtra(MovieDetailFragment.MOVIE_DETAIL_TAG));
            MovieDetailFragment fragment = new MovieDetailFragment();
            fragment.setArguments(arguments);
            getFragmentManager().beginTransaction()
                    .add(R.id.movie_detail_container, fragment)
                    .commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. Use NavUtils to allow users
            // to navigate up one level in the application structure. For
            // more details
//            NavUtils.navigateUpTo(this, new Intent(this, MovieListActivity.class));
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
