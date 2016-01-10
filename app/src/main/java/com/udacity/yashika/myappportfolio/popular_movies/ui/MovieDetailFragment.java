package com.udacity.yashika.myappportfolio.popular_movies.ui;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.udacity.yashika.myappportfolio.R;
import com.udacity.yashika.myappportfolio.popular_movies.dummy.DummyContent;
import com.udacity.yashika.myappportfolio.popular_movies.model.Movie;

/**
 * A fragment representing a single Movie detail screen. This fragment is either contained in a
 * {@link MovieListActivity} in two-pane mode (on tablets) or a {@link MovieDetailActivity} on
 * handsets.
 */
public class MovieDetailFragment extends Fragment {
    /**
     * The fragment argument representing the movie object that this fragment represents.
     */
    public static final String MOVIE_DETAIL_TAG = MovieDetailFragment.class.getSimpleName();

    private Movie movie;
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the fragment (e.g. upon
     * screen orientation changes).
     */
    public MovieDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getArguments().containsKey(MOVIE_DETAIL_TAG)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            movie = getArguments().getParcelable(MOVIE_DETAIL_TAG);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.movie_detail, container, false);

        // Show the dummy content as text in a TextView.
        if(movie != null) {
            ((TextView) view.findViewById(R.id.movie_detail)).setText(movie.getMovieOverview());
        }

        return view;
    }
}
