package com.example.facebook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.ArrayList;

public class SelectAlbumActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private RecyclerView recyclerView;
    private ArrayList<Album> listAlbums;
    private ConstraintLayout layoutCreateNewAlbum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_album);

        /* Toolbar */

        toolbar = findViewById(R.id.toolbar_select_album);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        /* Screen */

        listAlbums = new ArrayList<Album>();

        recyclerView = findViewById(R.id.recycler_view_select_album);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        AlbumAdapter albumAdapter = new AlbumAdapter(this, listAlbums);
        recyclerView.setAdapter(albumAdapter);

        listAlbums.add(new Album(3,"Demo album", 99, R.drawable.background_status_4));
        albumAdapter.notifyDataSetChanged();

        layoutCreateNewAlbum = findViewById(R.id.layout_create_new_album);
        layoutCreateNewAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), CreateAlbumActivity.class);
                startActivity(intent);
            }
        });

    }

    private void setSupportActionBar(Toolbar toolbar) {
    }
}