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
import com.example.facebook.Obj.Notice_items_Obj;
import com.example.facebook.R;

import java.util.ArrayList;

public class NoticeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<Notice_items_Obj> notice_items_objs;

    public NoticeAdapter(Context context, ArrayList<Notice_items_Obj> notice_items_objs) {
        this.context = context;
        this.notice_items_objs = notice_items_objs;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.notice_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHodler = (ViewHolder) holder;
        Glide.with(context).load(notice_items_objs.get(position).getNoticeImg())
                .fitCenter()
                .into(viewHodler.noticeImg);
        viewHodler.noticeName.setText(notice_items_objs.get(position).getNoticeName());
        viewHodler.noticeContent.setText(notice_items_objs.get(position).getNoticeContent());
        viewHodler.noticeTime.setText(notice_items_objs.get(position).getNoticeTime());

    }

    @Override
    public int getItemCount() {
        return notice_items_objs.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        BootstrapCircleThumbnail noticeImg;
        TextView noticeName;
        TextView noticeContent;
        TextView noticeTime;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            noticeImg = itemView.findViewById(R.id.noti_avt);
            noticeName = itemView.findViewById(R.id.item_notifi_name);
            noticeContent = itemView.findViewById(R.id.item_notifi_content);
            noticeTime = itemView.findViewById(R.id.item_notifi_time);
        }
    }
}
