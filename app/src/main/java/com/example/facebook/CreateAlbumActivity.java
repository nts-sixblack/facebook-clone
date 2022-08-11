package com.example.facebook;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class CreateAlbumActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView tvSubmitCreatedAlbum;
    private Spinner spnCreateAlbumViewMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creat_album2);

        /* Toolbar */

        toolbar = findViewById(R.id.toolbar_create_album);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        tvSubmitCreatedAlbum = findViewById(R.id.tv_submit_created_album);
        tvSubmitCreatedAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CreateAlbumActivity.this,"Tạo album mới thành công", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        /* Screen */

        spnCreateAlbumViewMode = findViewById(R.id.spn_create_album_view_mode);
        List<String> listViewMode = new ArrayList<>();
        listViewMode.add("Công khai");
        listViewMode.add("Bạn bè");
        listViewMode.add("Chỉ mình tôi");
        ArrayAdapter<String> adapterViewMode = new ArrayAdapter(this, android.R.layout.simple_spinner_item,listViewMode);
        adapterViewMode.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);

        spnCreateAlbumViewMode.setAdapter(adapterViewMode);
        spnCreateAlbumViewMode.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void setSupportActionBar(Toolbar toolbar) {
    }
}