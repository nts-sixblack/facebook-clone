package com.example.facebook;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.beardedhen.androidbootstrap.BootstrapCircleThumbnail;
import com.bumptech.glide.Glide;
import com.example.facebook.Adapter.StoryAdapter;
import com.example.facebook.Obj.story_items;
import com.example.facebook.StaticParam.PrivateParam;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StoryFragment extends Fragment {
    private static RecyclerView rcvStory;
    private static ArrayList<story_items> storyItems;
    private BootstrapCircleThumbnail img;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public StoryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StoryFragment newInstance(String param1, String param2) {
        StoryFragment fragment = new StoryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_story, container, false);
        rcvStory = view.findViewById(R.id.rcvStory);
        storyItems = new ArrayList<>();
        storyItems.add(new story_items("https://cdn.nguyenkimmall.com/images/detailed/555/may-anh-cho-nguoi-moi.jpg","https://i.pinimg.com/736x/97/6e/d7/976ed774dfe37806ab5fa1b9ab1a2c9c.jpg","Hạnh"));
        storyItems.add(new story_items("https://cdn.nguyenkimmall.com/images/detailed/555/may-anh-cho-nguoi-moi.jpg","https://images.wallpapersden.com/image/download/fallen-stars-4k_bGltaWiUmZqaraWkpJRma21lrWZlamVnZWZubGZs.jpg","Hạnh"));
        storyItems.add(new story_items("https://cdn.nguyenkimmall.com/images/detailed/555/may-anh-cho-nguoi-moi.jpg","https://images7.alphacoders.com/899/899919.jpg","Hạnh"));
        storyItems.add(new story_items("https://cdn.nguyenkimmall.com/images/detailed/555/may-anh-cho-nguoi-moi.jpg","https://d9i9nmwzijaw9.cloudfront.net/450/774/576/-29996968-1tfd7tc-gpggmmc5d0og3a0/original/image.jpg","Hạnh"));
        rcvStory.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        rcvStory.setLayoutManager(linearLayoutManager);
        StoryAdapter adapter = new StoryAdapter(getActivity().getApplicationContext(),storyItems);
        rcvStory.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        return view;
    }
}