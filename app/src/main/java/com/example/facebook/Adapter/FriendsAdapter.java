package com.example.facebook.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.beardedhen.androidbootstrap.BootstrapCircleThumbnail;
import com.bumptech.glide.Glide;
import com.example.facebook.Obj.Friend_items_Obj;
import com.example.facebook.R;

import java.util.ArrayList;

public class FriendsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<Friend_items_Obj>friend_items_objs;

    public FriendsAdapter(Context context, ArrayList<Friend_items_Obj> friend_items_objs) {
        this.context = context;
        this.friend_items_objs = friend_items_objs;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.friend_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        Glide.with(context).load(friend_items_objs.get(position).getFrImg())
                .fitCenter()
                .into(viewHolder.frImg);
        viewHolder.frName.setText(friend_items_objs.get(position).getFrName()+" đã gửi cho bạn lời mời kết bạn");
        viewHolder.frTime.setText(friend_items_objs.get(position).getFrTime());

    }

    @Override
    public int getItemCount() {
        return friend_items_objs.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        BootstrapCircleThumbnail frImg;
        TextView frName;
        TextView frTime;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            frImg = itemView.findViewById(R.id.Fr_img);
            frName = itemView.findViewById(R.id.fr_name);
            frTime = itemView.findViewById(R.id.fr_time);

        }
    }
}
