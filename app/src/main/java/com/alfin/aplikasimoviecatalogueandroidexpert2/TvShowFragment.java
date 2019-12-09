package com.alfin.aplikasimoviecatalogueandroidexpert2;


import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TvShowFragment extends Fragment {

    private RecyclerView rvTvShows;
    private ArrayList<MovieTvShow> list = new ArrayList<>();

    public TvShowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_show, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvTvShows = view.findViewById(R.id.rv_tvshows);
        rvTvShows.setHasFixedSize(true);

        list.addAll(getListMovies());
        showRecyclerView();
    }

    private void showRecyclerView(){
        rvTvShows.setLayoutManager(new LinearLayoutManager(getContext()));
        MovieTvShowAdapter movieTvShowAdapter = new MovieTvShowAdapter(list);
        rvTvShows.setAdapter(movieTvShowAdapter);
    }

    private ArrayList<MovieTvShow> getListMovies() {
        TypedArray dataGambar = getResources().obtainTypedArray(R.array.gambar_tv_show);
        String[] dataName = getResources().getStringArray(R.array.judul_tv_show);
        String[] dataDate = getResources().getStringArray(R.array.tgl_release_tv_show);
        String[] dataDescription = getResources().getStringArray(R.array.deskripsi_tv_show);
        ArrayList<MovieTvShow> listMovieTvShow = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            MovieTvShow movieTvShow = new MovieTvShow();
            movieTvShow.setGambar(dataGambar.getResourceId(i,0));
            movieTvShow.setJudul(dataName[i]);
            movieTvShow.setTanggal_rilis(dataDate[i]);
            movieTvShow.setDeskripsi(dataDescription[i]);
            listMovieTvShow.add(movieTvShow);
        }
        return listMovieTvShow;
    }
}
