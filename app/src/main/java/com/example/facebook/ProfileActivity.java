package com.example.facebook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapCircleThumbnail;
import com.bumptech.glide.Glide;
import com.example.facebook.Adapter.NewsAdapter;
import com.example.facebook.Adapter.NewsProfileAdapter;
import com.example.facebook.Obj.NewsItemProfile;
import com.example.facebook.StaticParam.PrivateParam;
import com.example.facebook.service.ApiService;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;

import at.markushi.ui.CircleButton;

public class ProfileActivity extends AppCompatActivity {
    private RoundedImageView profile_imgpage;
    private BootstrapCircleThumbnail imgAvaProfile;
    private TextView nameProfile;
    private BootstrapCircleThumbnail avaProfile;
    private BootstrapButton btnEdit;
    private Toolbar toolbar;
    private TextView txtNewThinks;
    private ImageView imageViewFollower;
    private RecyclerView rcvNewsProfile;
    private ArrayList<NewsItemProfile> newsItemProfiles;
    private NewsProfileAdapter adapter;
    private ApiService apiService;
    private CircleButton profile_imgChangeAvt;

    private void Mapping() {
        profile_imgpage = findViewById(R.id.profile_imgpage);
        imgAvaProfile = findViewById(R.id.imgAvaProfile);
        nameProfile = findViewById(R.id.nameProfile);
        avaProfile = findViewById(R.id.avaProfile);
        btnEdit = findViewById(R.id.btnEdit);
        txtNewThinks = findViewById(R.id.txtNewThinks);
        rcvNewsProfile = findViewById(R.id.rcvNewsProfile);
        profile_imgChangeAvt = findViewById(R.id.profile_imgChangeAvt);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        apiService = new ApiService();

        toolbar = findViewById(R.id.toolbar_my_profile);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_25);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        Mapping();
        newsItemProfiles = new ArrayList<>();
        rcvNewsProfile.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        rcvNewsProfile.setLayoutManager(linearLayoutManager);
        adapter = new NewsProfileAdapter(this.getApplicationContext(), newsItemProfiles);
        rcvNewsProfile.setAdapter(adapter);

        adapter.notifyDataSetChanged();
        if (PrivateParam.getUSER() != null) {
            Glide.with(getApplicationContext())
                    .load(PrivateParam.getUSER().getAvatar())
                    .into(imgAvaProfile);
            Glide.with(getApplicationContext())
                    .load(PrivateParam.getUSER().getAvatar())
                    .into(avaProfile);
            Glide.with(getApplicationContext())
                    .load(PrivateParam.getUSER().getBackground())
                    .into(profile_imgpage);
            nameProfile.setText(PrivateParam.getUSER().getName());

            int userId = PrivateParam.getUSER().getUserId();
            apiService.listPostsOfUser(userId, adapter, newsItemProfiles);

        }
        profile_imgChangeAvt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this,EditProfileActivity.class);
                startActivity(intent);
            }
        });
        Glide.with(this.getApplicationContext())
                .load(PrivateParam.getUSER().getAvatar())
                .into(imgAvaProfile);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this, EditProfileActivity.class);
                startActivity(intent);
            }
        });
        txtNewThinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this, UploadPictureActivity.class);
                startActivity(intent);
            }
        });
    }
    private void setSupportActionBar(Toolbar toolbar) {
    }



}