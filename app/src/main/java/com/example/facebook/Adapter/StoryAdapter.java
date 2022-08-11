package com.example.facebook.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.beardedhen.androidbootstrap.BootstrapCircleThumbnail;
import com.bumptech.glide.Glide;
import com.example.facebook.Obj.story_items;
import com.example.facebook.R;
import com.example.facebook.StoryActivity;

import java.util.ArrayList;

public class StoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static Context context;
    private static ArrayList<story_items> storyItems;

    public StoryAdapter(Context context, ArrayList<story_items> storyItems) {
        this.context = context;
        this.storyItems = storyItems;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.story_items,parent,false);
        return new ViewHodler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHodler viewHodler = (ViewHodler) holder;
        Glide.with(context)
                .load(storyItems.get(position).getImgAva())
                .fitCenter()
                .into(viewHodler.imgAvatar);
        Glide.with(context)
                .load(storyItems.get(position).getImg())
                .fitCenter()
                .into(viewHodler.img);
        viewHodler.txtNameStory.setText(storyItems.get(position).getTxtNameStory());
        viewHodler.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, StoryActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return storyItems.size();
    }
    public class ViewHodler extends RecyclerView.ViewHolder{
        BootstrapCircleThumbnail imgAvatar;
        ImageView img;
        TextView txtNameStory;
        View item;

        public ViewHodler(@NonNull View itemView) {
            super(itemView);
            imgAvatar = itemView.findViewById(R.id.imgAvatar);
            img = itemView.findViewById(R.id.img);
            txtNameStory = itemView.findViewById(R.id.txtNameStory);
            item = itemView;
        }
    }
}
