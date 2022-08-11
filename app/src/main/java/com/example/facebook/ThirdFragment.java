package com.example.facebook;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.facebook.Adapter.MarketAdapter;
import com.example.facebook.Adapter.NoticeAdapter;
import com.example.facebook.Obj.Market;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ThirdFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ThirdFragment extends Fragment {
    private RecyclerView rvMarket;
    private ArrayList<Market> markets;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ThirdFragment() {
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
    public static ThirdFragment newInstance(String param1, String param2) {
        ThirdFragment fragment = new ThirdFragment();
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
        View view = inflater.inflate(R.layout.market_fragment, container, false);
        rvMarket = view.findViewById(R.id.rvMarket);
        markets = new ArrayList<>();
        markets.add(new Market(R.drawable.mk1, "1.000.000 đ", "Iphone"));
        markets.add(new Market(R.drawable.mk1, "1.000.000 đ", "Iphone"));
        markets.add(new Market(R.drawable.mk1, "1.000.000 đ", "Iphone"));
        markets.add(new Market(R.drawable.mk1, "1.000.000 đ", "Iphone"));
        rvMarket.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getActivity().getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        rvMarket.setLayoutManager(linearLayoutManager1);
        MarketAdapter adapter1 = new MarketAdapter(getActivity().getApplicationContext(),markets);
        rvMarket.setAdapter(adapter1);
        adapter1.notifyDataSetChanged();
        return view;
    }
}