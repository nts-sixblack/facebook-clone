package com.example.facebook.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.facebook.Obj.Market;
import com.example.facebook.R;

import java.util.ArrayList;

public class MarketAdapter extends  RecyclerView.Adapter<MarketAdapter.MarketVH> {
    private Context context;
    public ArrayList<Market> list ;

    public MarketAdapter(Context context, ArrayList<Market> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MarketVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view =layoutInflater.inflate(R.layout.market_item,parent,false);
        return new MarketVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MarketVH holder, int position) {
        MarketVH viMarketVH = (MarketVH) holder;
        Glide.with(context)
                .load(list.get(position).getImage())
                .fitCenter()
                .into(viMarketVH.ivImage);
        viMarketVH.tvPrice.setText(list.get(position).getPrice());
        viMarketVH.tvDes.setText(list.get(position).getDes());
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MarketVH extends RecyclerView.ViewHolder {
        AppCompatImageView ivImage;
        AppCompatTextView tvPrice;
        AppCompatTextView tvDes;

        public MarketVH(@NonNull View itemView) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.ivImage);
            tvDes =itemView.findViewById(R.id.tvDes);
            tvPrice= itemView.findViewById(R.id.tvPrice);
        }
    }
}

