package com.example.facebook;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {

    ArrayList<Album> listAlbums;
    LayoutInflater inflater;
    Context context;

    public AlbumAdapter(Context context, ArrayList<Album> listAlbums) {
        this.listAlbums = listAlbums;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.album_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.thumbnail.setImageResource(listAlbums.get(position).getThumbnailId());
        holder.albumName.setText(listAlbums.get(position).getAlbumName());
        holder.pictureNumber.setText(listAlbums.get(position).getPictureNumber() + " ảnh");
        holder.itemView.setOnClickListener(view -> {
            Intent intent = ((Activity) context).getIntent();
            if (intent.getStringExtra("Activity name").indexOf("SelectAlbumActivity")!=-1) {
                intent = new Intent();
                intent.putExtra("Selected album", listAlbums.get(position).getAlbumName());
                ((Activity) context).setResult(Activity.RESULT_OK, intent);
                ((Activity) context).finish();
            } else {
                //
            }

        });

    }

    @Override
    public int getItemCount() {
        return listAlbums.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView thumbnail;
        TextView albumName;
        TextView pictureNumber;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            thumbnail = itemView.findViewById(R.id.img_album_thumbnail);
            albumName = itemView.findViewById(R.id.tv_album_name);
            pictureNumber = itemView.findViewById(R.id.tv_album_picture_number);
        }
    }


}
