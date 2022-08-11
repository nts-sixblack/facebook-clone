package com.example.facebook.Adapter;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.facebook.DetailNewsItems2Activity;
import com.example.facebook.HomeActivity;
import com.example.facebook.Obj.DeletePostObj;
import com.example.facebook.Obj.LikeStatus;
import com.example.facebook.Obj.NewsItemProfile;
import com.example.facebook.Obj.News_items;
import com.example.facebook.R;
import com.example.facebook.StaticParam.PrivateParam;
import com.example.facebook.Util;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.example.facebook.dialog.bottom_sheet_comments;
import com.example.facebook.service.ApiService;

public class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private FragmentManager fragmentManager;
    private ArrayList<News_items> newsItems;
    private String TAG = getClass().toString();
    private int postId=0;
    private ApiService apiService;

    public NewsAdapter(Context context, ArrayList<News_items> newsItems,FragmentManager fragmentManager ) {
        this.context = context;
        this.fragmentManager = fragmentManager;
        this.newsItems = newsItems;
        apiService = new ApiService();
    }

    public NewsAdapter(Context context, ArrayList<News_items> baiViets) {
        this.context = context;
        this.newsItems = baiViets;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view =layoutInflater.inflate(R.layout.news_items,parent,false);
        return new ViewHolder(view);
    }

    private void showDialog(int IDBV) {
        bottom_sheet_comments bottomSheetComments = new bottom_sheet_comments();
        Bundle bundle=new Bundle();
        bundle.putInt("IDBV",IDBV);
        bottomSheetComments.setArguments(bundle);
        bottomSheetComments.show(fragmentManager,"");
//        Dialog dialog = new Dialog(fragmentManager);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.setContentView(R.layout.dialog_comment);
//        dialog.show();
//        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        dialog.getWindow().getAttributes().windowAnimations = R.style.DialoAnimationComment;
//        dialog.getWindow().setGravity(Gravity.BOTTOM);

    }

    private void showPopup(View v,int IDBV ){
        PopupMenu popupMenu = new PopupMenu(context , v);
        popupMenu.inflate(R.menu.popup_menu);

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {

                if(menuItem.getItemId()==R.id.deletePost){
                    Util.getInstance().getRetrofitInstance().deletePostCall(IDBV,"Bearer "+ PrivateParam.getUSER().getToken()).enqueue(new Callback<DeletePostObj>() {
                        @Override
                        public void onResponse(Call<DeletePostObj> call, Response<DeletePostObj> response) {
                            if(response.body()!=null){
                                Log.e(TAG, "onResponse: "+response.body() );
                                Log.e(TAG, "onResponse: "+response.code() );
                                Toast.makeText(context, "Xóa bài viết thành công", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<DeletePostObj> call, Throwable t) {
                            Log.e(TAG, "onFailure: "+t.getMessage() );
                        }
                    });
                }
                return false;
            }
        });
        popupMenu.show();

    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        Glide.with(context)
                .load(newsItems.get(position).getImgAvaNews())
                .fitCenter()
                .into(viewHolder.imgAvaNews);
        Glide.with(context)
                .load(newsItems.get(position).getImgNews())
                .centerCrop()
                .into(viewHolder.imgNews);
        viewHolder.txtNameNews.setText(newsItems.get(position).getName());
        viewHolder.txtTimeNews.setText(newsItems.get(position).getTime());
        viewHolder.txtThinkNews.setText(newsItems.get(position).getTxtThinkNews());
        viewHolder.tv_comment_number_1.setText(newsItems.get(position).getCountComment()+" Bình luận");
        viewHolder.imgNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailNewsItems2Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("newsId",newsItems.get(position).getPostsId());
                context.startActivity(intent);
            }
        });
        viewHolder.btn_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(newsItems.get(position).getPostsId());
            }
        });
        viewHolder.btn_like.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                apiService.feelPosts(newsItems.get(position).getPostsId());

                if (b){
                    newsItems.get(position).setCountFeel(newsItems.get(position).getCountFeel()+1);
                } else {
                    newsItems.get(position).setCountFeel(newsItems.get(position).getCountFeel()-1);
                }
                viewHolder.totalFeel.setText(newsItems.get(position).getCountFeel()+"");
            }
        });

        viewHolder.btn_like.setChecked(newsItems.get(position).isFeel());
        viewHolder.totalFeel.setText(String.valueOf(newsItems.get(position).getCountFeel()));

        viewHolder.btn_picture_options_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopup(view,newsItems.get(position).getPostsId());
            }
        });

    }



    @Override
    public int getItemCount() {
        return newsItems.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgAvaNews;
        ImageView imgNews;
        TextView txtNameNews;
        TextView txtTimeNews;
        TextView txtThinkNews;
        CheckBox btn_like;
        CheckBox btn_comment;
        TextView totalFeel;
        TextView tv_comment_number_1;
        ImageButton btn_picture_options_1;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAvaNews = itemView.findViewById(R.id.imgComment);
            imgNews = itemView.findViewById(R.id.imgNews);
            totalFeel = itemView.findViewById(R.id.totalFeel);
            tv_comment_number_1 = itemView.findViewById(R.id.tv_comment_number_1);
            txtNameNews = itemView.findViewById(R.id.txtNameNews);
            txtTimeNews = itemView.findViewById(R.id.txtTimeNews);
            txtThinkNews = itemView.findViewById(R.id.txtThinkNews);
            btn_like = itemView.findViewById(R.id.btn_like);
            btn_comment = itemView.findViewById(R.id.btn_comment);
            btn_picture_options_1 = itemView.findViewById(R.id.btn_picture_options_1);
        }
    }
}
