package com.udacity.yashika.myappportfolio.popular_movies.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.udacity.yashika.myappportfolio.R;
import com.udacity.yashika.myappportfolio.popular_movies.PopularMoviesUtils;
import com.udacity.yashika.myappportfolio.popular_movies.model.Movie;
import com.udacity.yashika.myappportfolio.popular_movies.model.MovieResponse;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * This activity is used in Popular movies application to show most popular movies
 * <p/>
 * An activity representing a list of Movies. This activity has different presentations for handset
 * and tablet-size devices. On handsets, the activity presents a list of items, which when touched,
 * lead to a {@link MovieDetailActivity} representing item details. On tablets, the activity
 * presents the list of items and item details side-by-side using two vertical panes.
 */
public class MovieListActivity extends Activity {

    private static final String TAG = MovieListActivity.class.getSimpleName();
    private static final int COLUMN_2 = 2;
    private static final int COLUMN_3 = 3;
    @Bind(R.id.movie_list)
    View recyclerView;
    MovieListRecycleViewAdapter movieListRecycleViewAdapter;
    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet device.
     */
    private boolean twoPane;
    private MovieResponse movieResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        ButterKnife.bind(this);
        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle != null) {
            movieResponse = bundle.getParcelable(TAG);
        }

        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);

        if(findViewById(R.id.movie_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            twoPane = true;
        }
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {

        if(twoPane) {
            recyclerView.setLayoutManager(new GridLayoutManager(this, COLUMN_3));
        } else {
            recyclerView.setLayoutManager(new GridLayoutManager(this, COLUMN_2));
        }
        if(movieResponse != null) {
            if(movieResponse.getMovies() != null) {
                movieListRecycleViewAdapter = new MovieListRecycleViewAdapter(this);
                int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.spacing);
                recyclerView.addItemDecoration(new SpacesItemDecoration(spacingInPixels));
                recyclerView.setAdapter(movieListRecycleViewAdapter);
                movieListRecycleViewAdapter.setMovies(movieResponse.getMovies());
            }
        }
    }

    /**
     * This adapter is used in popular movies application for showing Movie Posters
     *
     * @author yashika.
     */
    public class MovieListRecycleViewAdapter
            extends RecyclerView.Adapter<MovieListRecycleViewAdapter.ViewHolder> {

        private List<Movie> movies;
        private Context context;

        public MovieListRecycleViewAdapter(Context context) {
            this.context = context;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.movie_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {

            StringBuilder stringBuilder = new StringBuilder(PopularMoviesUtils.IMAGE_BASE_URL);
            if(!movies.isEmpty() && movies.get(position) != null) {
                holder.movie = movies.get(position);

                stringBuilder.append(PopularMoviesUtils.W185);
                stringBuilder.append(movies.get(position).getMoviePoster());
                String imagePath = stringBuilder.toString();

                if(!TextUtils.isEmpty(imagePath)) {
                    Picasso.with(context)
                            .load(imagePath)
                            .error(android.R.drawable.arrow_down_float)
                            .into(holder.moviePoster);
                }
            }

            holder.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(twoPane) {
                        Bundle arguments = new Bundle();
                        arguments.putParcelable(MovieDetailFragment.MOVIE_DETAIL_TAG, holder.movie);
                        MovieDetailFragment fragment = new MovieDetailFragment();
                        fragment.setArguments(arguments);
                        if(context instanceof MovieListActivity) {
                            ((MovieListActivity) context).getFragmentManager().beginTransaction()
                                    .replace(R.id.movie_detail_container, fragment)
                                    .commit();
                        }
                    } else {
                        Context context = v.getContext();
                        Intent intent = new Intent(context, MovieDetailActivity.class);
                        intent.putExtra(MovieDetailFragment.MOVIE_DETAIL_TAG, holder.movie);

                        context.startActivity(intent);
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            if(!movies.isEmpty()) {
                return movies.size();
            }
            return 0;
        }

        public void setMovies(ArrayList<Movie> movies) {
            this.movies = movies;
            notifyDataSetChanged();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            public View view;
            public Movie movie;
            @Bind(R.id.movie_image)
            ImageView moviePoster;

            public ViewHolder(View view) {
                super(view);
                this.view = view;
                ButterKnife.bind(this, view);
            }

            @Override
            public String toString() {
                if(movie != null) {
                    return super.toString() + " '" + movie.getMovieTitle() + "'";
                }
                return null;
            }
        }
    }
}
