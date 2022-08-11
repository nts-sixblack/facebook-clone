package com.example.facebook;

import android.content.Intent;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.beardedhen.androidbootstrap.BootstrapButton;
import com.bumptech.glide.Glide;
import com.example.facebook.Adapter.NewsProfileAdapter;
import com.example.facebook.Obj.NewsItemProfile;
import com.example.facebook.Obj.UserV2;
import com.example.facebook.service.ApiService;

import java.util.ArrayList;

public class YourProfileActivity extends AppCompatActivity {
    private ImageView imgAvt;
    private ImageView imgBackground;
    private BootstrapButton btnFollow;
    private TextView txtName;
    private TextView txtFollower;
    private TextView txtFollowing;
    private RecyclerView recyclerView;
    private ArrayList<NewsItemProfile> newsItemProfiles;
    private NewsProfileAdapter adapter;
    private ApiService apiService;


    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_profile);
        toolbar = findViewById(R.id.toolbar_your_profile);
        setSupportActionBar(toolbar);
        apiService = new ApiService();

        imgAvt = findViewById(R.id.imgAvaProfile);
        imgBackground = findViewById(R.id.profile_imgpage);
        btnFollow = findViewById(R.id.btnFollow);
        txtName = findViewById(R.id.nameProfile);
        recyclerView = findViewById(R.id.rcvListPostUser);

        Intent intent = getIntent();
        int userId = intent.getIntExtra("userId", 1);
        apiService.inforOfUser(userId, new LoadingData() {
            @Override
            public void load(UserV2 userV2) {
                txtName.setText(userV2.getName());
                Glide.with(getApplicationContext())
                        .load(userV2.getAvatar())
                        .fitCenter()
                        .into(imgAvt);
                Glide.with(getApplicationContext())
                        .load(userV2.getBackground())
                        .fitCenter()
                        .into(imgBackground);
                if (userV2.getFollow()==-1){
                    btnFollow.setText("Theo dõi");
                } else if (userV2.getFollow() == 0){
                    btnFollow.setText("Chờ xác nhận");
                } else {
                    btnFollow.setText("Đang theo dõi");
                }
            }
        });

        newsItemProfiles = new ArrayList<>();
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new NewsProfileAdapter(this.getApplicationContext(), newsItemProfiles);
        recyclerView.setAdapter(adapter);
        apiService.listPostsOfUser(userId, adapter, newsItemProfiles);

        btnFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apiService.sendRequestFollow(userId);
                if (btnFollow.getText().equals("Theo dõi")){
                    btnFollow.setText("Đang theo dõi");
                } else {
                    btnFollow.setText("Theo dõi");
                }
            }
        });

        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_25);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
    private void setSupportActionBar(Toolbar toolbar) {
    }

    public interface LoadingData {
        public void load(UserV2 userV2);
    }
}