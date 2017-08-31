package com.example.heetae.popmovies;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by hsMacbook on 2017. 8. 29..
 */

public class MovieDetailActivity extends AppCompatActivity implements View.OnClickListener{
    public static final String EXTRA_MOVIE = "movie";

    private Movie mMovie;
    FloatingActionButton floatingAction;
    ImageView backdrop;
    ImageView poster;
    TextView title;
    TextView description;
    TextView ratings;
    TextView releaseDate;

    @Override
    protected void onCreate(Bundle savedInstances) {
        super.onCreate(savedInstances);
        setContentView(R.layout.activity_movie_detail);
        if (getIntent().hasExtra(EXTRA_MOVIE)) {
            mMovie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        } else
            throw new IllegalArgumentException();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolbarLayout.setTitle(mMovie.getTitle());

        backdrop = (ImageView) findViewById(R.id.backdrop);
        title = (TextView) findViewById(R.id.movie_title);
        description = (TextView) findViewById(R.id.movie_description);
        poster = (ImageView) findViewById(R.id.movie_poster);
        ratings = (TextView) findViewById(R.id.movie_ratings);
        releaseDate = (TextView) findViewById(R.id.movie_release);

        //Button not being used for now.
//        floatingAction = (FloatingActionButton) findViewById(R.id.fab);
//        floatingAction.setOnClickListener(this);

        title.setText(mMovie.getTitle());
        description.setText(mMovie.getDescription());
        ratings.setText(mMovie.getRating());
        releaseDate.setText(mMovie.getReleaseDate());
        Picasso.with(this)
                .load(mMovie.getPoster())
                .into(poster);
        Picasso.with(this)
                .load(mMovie.getBackdrop())
                .into(backdrop);
    }

    //To redirect to the movie page
    @Override
    public void onClick (View v) {
        String url = "market://details?id=<package_name>";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
}
