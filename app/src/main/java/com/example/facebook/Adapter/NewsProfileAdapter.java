package com.example.facebook.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.facebook.Obj.NewsItemProfile;
import com.example.facebook.R;
import com.example.facebook.dialog.bottom_sheet_comments;
import com.example.facebook.service.ApiService;

import java.util.ArrayList;

public class NewsProfileAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<NewsItemProfile> newsItemProfiles;
    private ApiService apiService;

    public NewsProfileAdapter(Context context, ArrayList<NewsItemProfile> newsItemProfiles) {
        this.context = context;
        this.newsItemProfiles = newsItemProfiles;
        apiService = new ApiService();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.news_profile_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        NewsProfileAdapter.ViewHolder viewHolder = (NewsProfileAdapter.ViewHolder) holder;
        NewsItemProfile newsItemProfile = newsItemProfiles.get(position);
        Glide.with(context)
                .load(newsItemProfile.getImgAvaProfile())
                .fitCenter()
                .into(viewHolder.imgAvaProfile);
        Glide.with(context)
                .load(newsItemProfile.getImgNewsProfile())
                .centerCrop()
                .into(viewHolder.imgNewsProfile);
        viewHolder.txtNameProfile.setText(newsItemProfile.getTxtNameProfile());
        viewHolder.txtTimeNewsProfile.setText(newsItemProfile.getTxtTimeNewsProfile());
        viewHolder.txtThinkNewsProfile.setText(newsItemProfile.getTxtThinkNewsProfile());
        viewHolder.totalFeel.setText(newsItemProfile.getCountFeel()+"");
        viewHolder.totalComment.setText(newsItemProfile.getCountComment()+" bình luận");
        viewHolder.btn_like.setChecked(newsItemProfile.isFeel());
        viewHolder.btn_like.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                apiService.feelPosts(newsItemProfile.getPostsId());
                if (b){
                    newsItemProfile.setCountFeel(newsItemProfile.getCountFeel()+1);
                } else {
                    newsItemProfile.setCountFeel(newsItemProfile.getCountFeel()-1);
                }
                viewHolder.totalFeel.setText(newsItemProfile.getCountFeel()+"");
            }
        });
        viewHolder.btn_comment.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                bottom_sheet_comments bottomSheetComments = new bottom_sheet_comments();
                Bundle bundle=new Bundle();
                bundle.putInt("IDBV",newsItemProfile.getPostsId());
                bottomSheetComments.setArguments(bundle);
//                bottomSheetComments.show(fragmentManager,"");
                Log.e("click","click comment");
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsItemProfiles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgAvaProfile;
        ImageView imgNewsProfile;
        TextView txtNameProfile;
        TextView txtTimeNewsProfile;
        TextView txtThinkNewsProfile;
        CheckBox btn_like;
        CheckBox btn_comment;
        ImageButton btn_picture_options_1;
        TextView totalFeel;
        TextView totalComment;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAvaProfile = itemView.findViewById(R.id.imgAvaProfile);
            imgNewsProfile = itemView.findViewById(R.id.imgNewsProfile);
            txtNameProfile = itemView.findViewById(R.id.txtNameProfile);
            txtTimeNewsProfile = itemView.findViewById(R.id.txtTimeNewsProfile);
            txtThinkNewsProfile = itemView.findViewById(R.id.txtThinkNewsProfile);
            btn_like = itemView.findViewById(R.id.btn_like);
            btn_comment = itemView.findViewById(R.id.btn_comment);
            btn_picture_options_1 = itemView.findViewById(R.id.btn_picture_options_1);
            totalFeel = itemView.findViewById(R.id.totalFeel);
            totalComment = itemView.findViewById(R.id.tv_comment_number_1);
        }
    }
}
