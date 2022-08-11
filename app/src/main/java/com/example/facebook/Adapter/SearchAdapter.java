package com.example.facebook.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.beardedhen.androidbootstrap.BootstrapCircleThumbnail;
import com.bumptech.glide.Glide;
import com.example.facebook.Obj.SearchObj;
import com.example.facebook.Obj.Search_itemObj;
import com.example.facebook.R;
import com.example.facebook.SearchActivity;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<Search_itemObj>search_itemObjs;
    private SearchActivity.ChooseUser chooseUser;

    public SearchAdapter(Context context, ArrayList<Search_itemObj> search_itemObjs, SearchActivity.ChooseUser chooseUser) {
        this.context = context;
        this.search_itemObjs = search_itemObjs;
        this.chooseUser = chooseUser;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.search_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        SearchAdapter.ViewHolder viewHolder = (SearchAdapter.ViewHolder) holder;
        Search_itemObj search_itemObj = search_itemObjs.get(position);
        Glide.with(context).load(search_itemObjs.get(position).getItSearch_avt())
                .fitCenter()
                .into(viewHolder.itSearch_avt);
        viewHolder.itSearch_txtName.setText(search_itemObjs.get(position).getItSearch_txtName());
        viewHolder.itSearch_txtBC.setText(search_itemObjs.get(position).getItSearch_txtBC());
        viewHolder.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseUser.click(search_itemObj);
            }
        });
    }

    @Override
    public int getItemCount() {
        return search_itemObjs.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        BootstrapCircleThumbnail itSearch_avt;
        TextView itSearch_txtName;
        TextView itSearch_txtBC;
        ImageButton imageButton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itSearch_avt = itemView.findViewById(R.id.itSearch_avt);
            itSearch_txtName = itemView.findViewById(R.id.itSearch_txtName);
            itSearch_txtBC = itemView.findViewById(R.id.itSearch_txtBC);
            imageButton = itemView.findViewById(R.id.imgInfor);

        }
    }
}
