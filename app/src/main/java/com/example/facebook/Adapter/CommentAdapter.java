package com.example.facebook.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.facebook.Obj.Comment;
import com.example.facebook.Obj.CommentListObj;
import com.example.facebook.R;

import java.util.ArrayList;

public class CommentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<Comment> comment;

    public CommentAdapter(Context context, ArrayList<Comment> comment) {
        this.context = context;
        this.comment = comment;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.comment_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        Glide.with(context).load(comment.get(position).getImage())
                .fitCenter()
                .into(viewHolder.imgComment);
        viewHolder.cmtitem_name.setText(comment.get(position).getName());
        viewHolder.cmtitem_content.setText(comment.get(position).getComment());
        viewHolder.cmtitem_time.setText(comment.get(position).getDateCreate());

    }

    @Override
    public int getItemCount() {
        return comment.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgComment;
        TextView cmtitem_name;
        TextView cmtitem_content;
        TextView cmtitem_time;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgComment =itemView.findViewById(R.id.imgComment);
            cmtitem_name = itemView.findViewById(R.id.cmtitem_name);
            cmtitem_content = itemView.findViewById(R.id.cmtitem_content);
            cmtitem_time = itemView.findViewById(R.id.cmtitem_time);
        }
    }
}
