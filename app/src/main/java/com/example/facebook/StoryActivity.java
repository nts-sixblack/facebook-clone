package com.example.facebook;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.beardedhen.androidbootstrap.BootstrapCircleThumbnail;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.example.facebook.Obj.Story;
import com.stone.pile.libs.PileLayout;

import java.util.ArrayList;

import eightbitlab.com.blurview.BlurView;
import eightbitlab.com.blurview.RenderScriptBlur;

public class StoryActivity extends AppCompatActivity {

    private PileLayout pileLayout;
    private ArrayList<Story> stories;
    private BlurView blurView;
    private ConstraintLayout constraintLayout;
    private float Screen_height,Screen_width;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("TIÊU ĐỀ ACTIVITY"); //Thiết lập tiêu đề nếu muốn
        String title = actionBar.getTitle().toString(); //Lấy tiêu đề nếu muốn
        actionBar.hide();//Ẩn ActionBar nếu muốn
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        Screen_height = displayMetrics.heightPixels;
        Screen_width = displayMetrics.widthPixels;
        pileLayout=findViewById(R.id.pileLayout);
        blurView=findViewById(R.id.blurSto);
        constraintLayout=findViewById(R.id.bgStory);
        stories=new ArrayList<>();
        stories.add(new Story("Hạnh","https://cdn.nguyenkimmall.com/images/detailed/555/may-anh-cho-nguoi-moi.jpg","https://images.wallpaperscraft.com/image/single/astronaut_ring_neon_156673_1920x1080.jpg"));
        stories.add(new Story("Hạnh","https://cdn.nguyenkimmall.com/images/detailed/555/may-anh-cho-nguoi-moi.jpg","https://images.hdqwalls.com/download/cs-go-4k-du-1920x1080.jpg"));
        stories.add(new Story("Hạnh","https://cdn.nguyenkimmall.com/images/detailed/555/may-anh-cho-nguoi-moi.jpg","https://images.wallpapersden.com/image/download/fallen-stars-4k_bGltaWiUmZqaraWkpJRma21lrWZlamVnZWZubGZs.jpg"));
        stories.add(new Story("Hạnh","https://cdn.nguyenkimmall.com/images/detailed/555/may-anh-cho-nguoi-moi.jpg","https://images7.alphacoders.com/899/899919.jpg"));
        stories.add(new Story("Hạnh","https://cdn.nguyenkimmall.com/images/detailed/555/may-anh-cho-nguoi-moi.jpg","https://bloghay.vn/wp-content/uploads/2021/10/Wallpaper-4k-Hi%CC%80nh-ne%CC%82%CC%80n-4k-hi%CC%80nh-a%CC%89nh-ve%CC%82%CC%80-ruo%CC%A3%CC%82ng-ba%CC%A3%CC%82c-thang-de%CC%A3p-scaled.jpg"));

        PileLayout.Adapter adt = new PileLayout.Adapter() {
            @Override
            public int getLayoutId() {
                return R.layout.item_pile;
            }

            @Override
            public void bindView(View view, int position) {
                super.bindView(view, position);
                ViewHolder viewHolder = (ViewHolder) view.getTag();
                if (viewHolder==null){
                    viewHolder=new ViewHolder();
                    viewHolder.imageView=view.findViewById(R.id.main_logo);
                    viewHolder.avt=view.findViewById(R.id.story_avt);
                    viewHolder.txtname=view.findViewById(R.id.story_name);
                    view.setTag(viewHolder);
                }
                Glide.with(getApplicationContext())
                        .load(stories.get(position).getSrc())
                        .override((int)Screen_width-20,(int)Screen_height)
                        .into(viewHolder.imageView);
                Glide.with(getApplicationContext())
                        .load(stories.get(position).getAvt())
                        .into(viewHolder.avt);
                viewHolder.txtname.setText(stories.get(position).getName());
            }

            @Override
            public int getItemCount() {
                return stories.size();
            }

            @Override
            public void displaying(int position) {
                Glide.with(getApplicationContext()).load(stories.get(position).getSrc()).into(new SimpleTarget<Drawable>() {
                    @Override
                    public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            constraintLayout.setBackground(resource);
                        }
                    }
                });
                //super.displaying(position);
//                descriptionView.setText("dfafsa");
//                if (lastDisplay<0){
//                    initScene(position);
//                    lastDisplay=0;
//                }
//                else if (lastDisplay!=position){
//                    transitionScene(position);
//                    lastDisplay=position;
//                }

            }

            @Override
            public void onItemClick(View view, int position) {
                super.onItemClick(view, position);
            }
        };
        float radius = 20f;

        View decorView = getWindow().getDecorView();
        //ViewGroup you want to start blur from. Choose root as close to BlurView in hierarchy as possible.
        ViewGroup rootView = (ViewGroup) decorView.findViewById(android.R.id.content);
        //Set drawable to draw in the beginning of each blurred frame (Optional).
        //Can be used in case your layout has a lot of transparent space and your content
        //gets kinda lost after after blur is applied.
        Drawable windowBackground = decorView.getBackground();

        blurView.setupWith(rootView)
                .setFrameClearDrawable(windowBackground)
                .setBlurAlgorithm(new RenderScriptBlur(this))
                .setBlurRadius(radius)
                .setHasFixedTransformationMatrix(true);

        pileLayout.setAdapter(adt);



    }
    public class ViewHolder{
        ImageView imageView;
        BootstrapCircleThumbnail avt;
        TextView txtname;
    }
}