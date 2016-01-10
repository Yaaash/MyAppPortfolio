package com.udacity.yashika.myappportfolio.popular_movies.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.udacity.yashika.myappportfolio.R;
import com.udacity.yashika.myappportfolio.popular_movies.PopularMoviesUtils;
import com.udacity.yashika.myappportfolio.popular_movies.model.Movie;

import java.io.File;

import butterknife.Bind;
import butterknife.ButterKnife;

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
    private static final int TEN = 10;
    @Bind(R.id.movie_title_text_view)
    TextView movieTitle;
    @Bind(R.id.movie_backdrop_image_view)
    ImageView movieBackDrop;
    @Bind(R.id.release_year_text_view)
    TextView movieReleaseYear;
    @Bind(R.id.movie_duration_text_view)
    TextView movieDuration;
    @Bind(R.id.movie_rating_text_view)
    TextView movieRating;
    @Bind(R.id.favorite_button)
    Button favorite;
    @Bind(R.id.movie_detail_text_view)
    TextView movieDetail;
    @Bind(R.id.number_of_trailers_linear_layout)
    LinearLayout trailerLinearLayout;
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
            movie = getArguments().getParcelable(MOVIE_DETAIL_TAG);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.movie_detail, container, false);
        ButterKnife.bind(this, view);
        setContent();
        return view;
    }

    private void setContent() {
        if(movie != null) {

            if(!TextUtils.isEmpty(movie.getOriginalMovieTitle())) {
                movieTitle.setText(movie.getOriginalMovieTitle());
            }

            if(!TextUtils.isEmpty(movie.getMoviePoster())) {
                String image = PopularMoviesUtils.IMAGE_BASE_URL + PopularMoviesUtils.W185 + movie.getMoviePoster();

                if(!TextUtils.isEmpty(image)) {
                    Picasso.with(getActivity())
                            .load(image)
                            .error(android.R.drawable.arrow_down_float)
                            .into(movieBackDrop);
                }
            }

            if(!TextUtils.isEmpty(movie.getReleaseDate())) {
                String release[] = movie.getReleaseDate().split("-");
                movieReleaseYear.setText(release[0]);
            }

            if(movie.getAverageVote() != 0) {
                String rating = movie.getAverageVote() + File.separator + TEN;
                movieRating.setText(rating);
            }

            if(!TextUtils.isEmpty(movie.getMovieOverview())) {
                movieDetail.setText(movie.getMovieOverview());
            }

            if(movie.hasVideo()) {
                View trailer = getActivity().getLayoutInflater().inflate(R.layout.trailers_layout, trailerLinearLayout, false);
                trailerLinearLayout.addView(trailer);
            } else {
                LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                lparams.gravity = Gravity.CENTER;
                TextView tv = new TextView(getActivity());
                tv.setLayoutParams(lparams);
                tv.setText(R.string.no_trailers);
                trailerLinearLayout.addView(tv);
            }
        }
    }
}
