package com.example.facebook;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.facebook.Adapter.MarketAdapter;
import com.example.facebook.Adapter.VideoAdapter;
import com.example.facebook.Obj.Video;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SecondFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecondFragment extends Fragment {
    private RecyclerView rvVideo;
    private ArrayList<Video> videos;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SecondFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SecondFragment newInstance(String param1, String param2) {
        SecondFragment fragment = new SecondFragment();
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
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        rvVideo = view.findViewById(R.id.rvVideo);
        videos = new ArrayList<>();
        videos.add(new Video("Ngoc Anh", true, "Ngày 18 tháng 4", "Content", R.drawable.thumb1, true, "https://icdn.dantri.com.vn/thumb_w/640/2018/5/23/net-cuoi-be-gai-9-1527053440039156820618.jpg"));
        videos.add(new Video("Ngoc Anh", true, "Ngày 18 tháng 4", "Content", R.drawable.thumb1, true, "https://i.pinimg.com/564x/92/26/5c/92265c40c8e428122e0b32adc1994594.jpg"));
        videos.add(new Video("Ngoc Anh", true, "Ngày 18 tháng 4", "Content", R.drawable.thumb1, true, "https://toanthaydinh.com/wp-content/uploads/2020/04/hinh-anh-con-gai-buon-roi-nuoc-mat-.jpg"));
        videos.add(new Video("Ngoc Anh", true, "Ngày 18 tháng 4", "Content", R.drawable.thumb1, true, "https://haycafe.vn/wp-content/uploads/2021/12/Hinh-anh-bao-ve-moi-truong-1.jpg"));
        videos.add(new Video("Ngoc Anh", true, "Ngày 18 tháng 4", "Content", R.drawable.thumb1, true, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRXpyl9XyBbun_MqGSVEXips0DXfuLNzKKQ7A&usqp=CAU"));
        rvVideo.setHasFixedSize(true);
        VideoAdapter adapter1 = new VideoAdapter(getActivity().getApplicationContext(),videos);
        rvVideo.setAdapter(adapter1);
        adapter1.notifyDataSetChanged();

        // Inflate the layout for this fragment
        return view;

    }
}