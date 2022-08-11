package com.example.facebook.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.facebook.Obj.Video;
import com.example.facebook.R;

import java.util.ArrayList;

public class VideoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<Video> videos;

    public VideoAdapter(Context context, ArrayList<Video> videos) {
        this.context = context;
        this.videos = videos;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view =layoutInflater.inflate(R.layout.video_items_v2,parent,false);
        return new VideoVH(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VideoVH videoVH = (VideoVH) holder;
        Glide.with(context)
                .load(videos.get(position).getImage())
                .fitCenter()
                .into(videoVH.ivImageUser);
        Glide.with(context)
                .load(videos.get(position).getUrl())
                .fitCenter()
                .into(videoVH.ivThumbVideo);

        videoVH.tvDateVideo.setText(videos.get(position).getDate());
        videoVH.tvContentVideo.setText(videos.get(position).getContent());
        videoVH.tvName.setText(videos.get(position).getAnchor());
        if(videos.get(position).isFollow){
            videoVH.tvFollow.setText("Đã theo dõi");
        }else{
            videoVH.tvFollow.setText("Theo dõi");
        }

    }

    @Override
    public int getItemCount() {
        return videos.size();
    }

    public class VideoVH extends RecyclerView.ViewHolder {
        TextView tvContentVideo;
        TextView tvDateVideo;
        ImageView ivThumbVideo;
        CheckBox check_like;
        ImageView ivImageUser;
        TextView tvFollow;
        TextView tvDots;
        TextView tvName;


        public VideoVH(@NonNull View itemView) {
            super(itemView);
            tvContentVideo = itemView.findViewById(R.id.tvContentVideo);
            tvDateVideo = itemView.findViewById(R.id.tvDateVideo);
            ivThumbVideo = itemView.findViewById(R.id.ivThumbVideo);
            check_like = itemView.findViewById(R.id.check_like);
            ivImageUser = itemView.findViewById(R.id.ivImageUser);
            tvName = itemView.findViewById(R.id.tvName);
            tvFollow = itemView.findViewById(R.id.tvFollow);
        }
    }


}
