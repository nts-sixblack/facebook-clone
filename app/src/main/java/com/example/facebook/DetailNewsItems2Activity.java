package com.example.facebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.facebook.Obj.NewPost;
import com.example.facebook.Obj.NewPostV2;
import com.example.facebook.StaticParam.PrivateParam;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailNewsItems2Activity extends AppCompatActivity {
    private ImageView ImgDetail;
    private TextView txtNameDetail2;
    private TextView txtContentDetail;
    private TextView txtTimeDetail2;
    private TextView txtCountFeel;
    private TextView txtCountComment;
    private String TAG = getClass().getName().toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_news_items2);
        Mappin();
        Intent intent = getIntent();
        int imgId = intent.getIntExtra("newsId",1);
        Util.getInstance().getRetrofitInstance().getPostCallById(imgId,"Bearer "+ PrivateParam.getUSER().getToken()).enqueue(new Callback<NewPostV2>() {
            @Override
            public void onResponse(Call<NewPostV2> call, Response<NewPostV2> response) {
                if(response.body()!=null){
                    NewPostV2 postV2 = response.body();
                    Glide.with(getApplicationContext())
                            .load(postV2.getData().getPostsImageList()[0].getImage())
                            .fitCenter()
                            .into(ImgDetail);
                    txtContentDetail.setText(postV2.getData().getCaption());
                    txtNameDetail2.setText(postV2.getData().getPostsUserList()[0].getName());

                    Log.e(TAG, "onResponse: hồng hạnh "+postV2.getData().getPostsUserList()[0].getName() );
                    txtTimeDetail2.setText(postV2.getData().getDateCreate());
                    txtCountFeel.setText(postV2.getData().getTotalFeel()+"");
                    txtCountComment.setText(postV2.getData().getTotalComment()+" bình luận");
                }
                Log.e(TAG, "onResponse: code"+response.code() );
            }

            @Override
            public void onFailure(Call<NewPostV2> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t.getMessage() );
            }
        });
    }
    private void Mappin(){
        ImgDetail = findViewById(R.id.ImgDetail);
        txtNameDetail2 = findViewById(R.id.txtNameDetail2);
        txtContentDetail = findViewById(R.id.txtContentDetail);
        txtTimeDetail2 = findViewById(R.id.txtTimeDetail2);
        txtCountFeel = findViewById(R.id.txtCountLike);
        txtCountComment = findViewById(R.id.txtCountComment);
    }
}