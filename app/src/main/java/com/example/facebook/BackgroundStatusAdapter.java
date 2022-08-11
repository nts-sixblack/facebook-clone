package com.example.facebook;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BackgroundStatusAdapter extends RecyclerView.Adapter<BackgroundStatusAdapter.ViewHolder> {
    ArrayList<BackgroundStatus> listBackgroundStatus;
    LayoutInflater inflater;

    public BackgroundStatusAdapter(Context context, ArrayList<BackgroundStatus> listBackgroundStatus) {
        this.inflater = LayoutInflater.from(context);
        this.listBackgroundStatus = listBackgroundStatus;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        public ViewHolder (@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.img_background_status_item);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.background_status_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.itemView.setOnClickListener(view -> {
            //Log.d("Background Status ID", String.valueOf(listBackgroundStatus.get(position).getBackgroundStatusId()));
            /*  if (tvFavorite.getCurrentTextColor() == ResourcesCompat.getColor(getResources(), android.R.color.tab_indicator_text, null)) {
                tvFavorite.setTextColor(ResourcesCompat.getColor(getResources(), R.color.red, null));
                tvFavoriteNumber.setText(String.valueOf(favoriteNumber+1));
            } */
        });

        holder.image.setImageResource(listBackgroundStatus.get(position).getBackgroundStatusId());
    }

    @Override
    public int getItemCount() {
        return listBackgroundStatus.size();
    }
}
