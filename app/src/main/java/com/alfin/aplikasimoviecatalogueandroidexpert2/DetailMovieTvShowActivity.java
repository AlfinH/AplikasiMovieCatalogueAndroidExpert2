package com.alfin.aplikasimoviecatalogueandroidexpert2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailMovieTvShowActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE_TVSHOW = "movie_tvshow";

    private TextView txtJudul,txtGenre,txtTanggal,txtDeskripsi;
    private ImageView imgGambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie_tv_show);

        MovieTvShow movieTvShow = getIntent().getParcelableExtra(EXTRA_MOVIE_TVSHOW);

        txtJudul = findViewById(R.id.tv_judul_detail);
        txtGenre = findViewById(R.id.tv_genre_detail);
        txtTanggal = findViewById(R.id.tv_tanggal_detail);
        txtDeskripsi = findViewById(R.id.tv_deskripsi_detail);
        imgGambar = findViewById(R.id.iv_gambar_detail);

        txtJudul.setText(movieTvShow.getJudul());
        txtGenre.setText(movieTvShow.getGenre());
        txtTanggal.setText(movieTvShow.getTanggal_rilis());
        txtDeskripsi.setText(movieTvShow.getDeskripsi());
        imgGambar.setImageResource(movieTvShow.getGambar());
    }
}
