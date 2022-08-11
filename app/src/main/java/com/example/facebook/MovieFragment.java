//package com.example.facebook;
//
//
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.fragment.app.Fragment;
//import java.util.ArrayList;
//
//public class VideoFragment extends Fragment {
//
//    private VideoFragmentBinding binding;
//    private VideoAdapter adapter = new VideoAdapter();
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        binding = VideoFragmentBinding.inflate(inflater, container, false);
//        View view = binding.getRoot();
//        return view;
//    }
//
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        adapter.context = this.getContext();
//        adapter.list = getData();
//        binding.rvVideo.setAdapter(adapter);
//    }
//
//    private ArrayList<Video_items> getData() {
//        Video_items item1 = new Video_items("Ngoc Anh", true, "Ngày 18 tháng 4", "Content", R.drawable.thumb1, true, "Iphone",R.drawable.doctor);
//        Video_items item2 = new Video_items("An", false, "Ngày 4 tháng 4", "Không cần chú thích, chỉ cần em thích!\n", R.drawable.thumb2, true, "Iphone",R.drawable.customer);
//        Video_items item3 = new Video_items("Justin", true, "Ngày 18 tháng 1", "Núi này xanh quá =)))", R.drawable.thumb3, true, "Iphone",R.drawable.man);
//        Video_items item4 = new Video_items("Jacob", false, "Ngày 1 tháng 10", "Biển này trắng quá =)))", R.drawable.thumb4, true, "Air pod",R.drawable.man1);
//        Video_items item5 = new Video_items("Johny", true, "Ngày 2 tháng 12", "Content", R.drawable.thumb5, true, "Air pod",R.drawable.doctor);
//        Video_items item6 = new Video_items("Ha An Nguyen", true, "Ngày 3 tháng 8", "Đọc báo tốt cho sức đề kháng, tránh dịch bệnh :))", R.drawable.thumb6, true, "Case",R.drawable.doctor);
//        Video_items item7 = new Video_items("Hanh Hong", false, "Ngày 5 tháng 4", "Gọi anh là đồ ba phải\n" +
//                "Phải ăn,phải ngủ,phải lòng em!", R.drawable.mk6, true, "Case");
//        ArrayList<Video_items> list = new ArrayList<>();
//        list.add(item1);
//        list.add(item2);
//        list.add(item3);
//        list.add(item4);
//        list.add(item5);
//        list.add(item6);
//        list.add(item7);
//        return list;
//    }
//}
