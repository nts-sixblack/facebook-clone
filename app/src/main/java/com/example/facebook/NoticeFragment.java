package com.example.facebook;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.facebook.Adapter.FriendsAdapter;
import com.example.facebook.Adapter.NewsAdapter;
import com.example.facebook.Adapter.NoticeAdapter;
import com.example.facebook.Obj.Friend_items_Obj;
import com.example.facebook.Obj.Notice_items_Obj;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NoticeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NoticeFragment extends Fragment {
    private RecyclerView recyclerView_adviseF;
    private ArrayList<Friend_items_Obj> friend_items_objs;
    private RecyclerView notifi_reNotification;
    private ArrayList<Notice_items_Obj> notice_items_objs;
    private RecyclerView notifiold_reNotification;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NoticeFragment() {
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
    public static NoticeFragment newInstance(String param1, String param2) {
        NoticeFragment fragment = new NoticeFragment();
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
        View view =  inflater.inflate(R.layout.fragment_notice, container, false);

        //Loi moi ket ban
        recyclerView_adviseF = view.findViewById(R.id.recyclerView_adviseF);
        friend_items_objs = new ArrayList<>();
        friend_items_objs.add(new Friend_items_Obj("https://baoninhbinh.org.vn//DATA/ARTICLES/2021/5/17/cuoc-dua-lot-vao-top-100-anh-dep-di-san-van-hoa-va-thien-7edf3.jpg","Hong Hanh","1 gio truoc"));
        friend_items_objs.add(new Friend_items_Obj("https://baoninhbinh.org.vn//DATA/ARTICLES/2021/5/17/cuoc-dua-lot-vao-top-100-anh-dep-di-san-van-hoa-va-thien-7edf3.jpg","Hong Hanh","1 gio truoc"));
        friend_items_objs.add(new Friend_items_Obj("https://baoninhbinh.org.vn//DATA/ARTICLES/2021/5/17/cuoc-dua-lot-vao-top-100-anh-dep-di-san-van-hoa-va-thien-7edf3.jpg","Hong Hanh","1 gio truoc"));
        recyclerView_adviseF.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView_adviseF.setLayoutManager(linearLayoutManager);
        FriendsAdapter adapter = new FriendsAdapter(getActivity().getApplicationContext(),friend_items_objs);
        recyclerView_adviseF.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        //Moi
        notifi_reNotification = view.findViewById(R.id.notifi_reNotification);
        notice_items_objs = new ArrayList<>();
        notice_items_objs.add(new Notice_items_Obj("https://hinhnen123.com/wp-content/uploads/2021/06/hinh-nen-dep.jpg","Hong Hanh","da thich hinh anh cua ban","5 phut truoc"));
        notice_items_objs.add(new Notice_items_Obj("https://hinhnen123.com/wp-content/uploads/2021/06/hinh-nen-dep.jpg","Hong Hanh","da thich hinh anh cua ban","5 phut truoc"));
        notice_items_objs.add(new Notice_items_Obj("https://hinhnen123.com/wp-content/uploads/2021/06/hinh-nen-dep.jpg","Hong Hanh","da thich hinh anh cua ban","5 phut truoc"));
        notifi_reNotification.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getActivity().getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        notifi_reNotification.setLayoutManager(linearLayoutManager1);
        NoticeAdapter adapter1 = new NoticeAdapter(getActivity().getApplicationContext(),notice_items_objs);
        notifi_reNotification.setAdapter(adapter1);
        adapter1.notifyDataSetChanged();


//Truoc do
        notifiold_reNotification = view.findViewById(R.id.notifiold_reNotification);
        notice_items_objs = new ArrayList<>();
        notice_items_objs.add(new Notice_items_Obj("https://hinhnen123.com/wp-content/uploads/2021/06/hinh-nen-dep.jpg","Hong Hanh","da thich hinh anh cua ban","5 phut truoc"));
        notice_items_objs.add(new Notice_items_Obj("https://hinhnen123.com/wp-content/uploads/2021/06/hinh-nen-dep.jpg","Hong Hanh","da thich hinh anh cua ban","5 phut truoc"));
        notice_items_objs.add(new Notice_items_Obj("https://hinhnen123.com/wp-content/uploads/2021/06/hinh-nen-dep.jpg","Hong Hanh","da thich hinh anh cua ban","5 phut truoc"));
        notifiold_reNotification.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getActivity().getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        notifiold_reNotification.setLayoutManager(linearLayoutManager2);
        NoticeAdapter adapter2 = new NoticeAdapter(getActivity().getApplicationContext(),notice_items_objs);
        notifiold_reNotification.setAdapter(adapter2);
        adapter2.notifyDataSetChanged();
        return view;
    }
}