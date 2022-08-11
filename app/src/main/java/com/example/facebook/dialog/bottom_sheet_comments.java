package com.example.facebook.dialog;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.example.facebook.Adapter.CommentAdapter;
import com.example.facebook.Adapter.FriendsAdapter;
import com.example.facebook.Obj.Comment;
import com.example.facebook.Obj.CommentListObj;
import com.example.facebook.Obj.CreatCommentObj;
import com.example.facebook.R;
import com.example.facebook.StaticParam.PrivateParam;
import com.example.facebook.Util;
import com.example.facebook.service.ApiService;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class bottom_sheet_comments extends BottomSheetDialogFragment {
    private RecyclerView bts_list_cmt;
    private ArrayList<Comment> comments;
    private BootstrapEditText bts_ipcmt;
    private BootstrapButton bts_sendcmt;
    private String TAG=this.getClass().getSimpleName();
    private View view;
    private int postId=0;
    private CommentAdapter adapter;
    private ApiService apiService;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.dialog_comment,container,false);
        mapping();
        postId = getArguments().getInt("IDBV",0);
        bts_list_cmt.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        bts_list_cmt.setLayoutManager(linearLayoutManager);
        adapter = new CommentAdapter(getActivity().getApplicationContext(),comments);
        bts_list_cmt.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        LoadComment(adapter);

        bts_sendcmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bts_ipcmt.getText().toString().trim().length()!=0){
                    HashMap<String,Object> map = new HashMap<>();
                    map.put("comment",bts_ipcmt.getText().toString().trim());
                    map.put("tusId",postId);
                    Util.getInstance().getRetrofitInstance().creatCommentCall(map,"Bearer "+ PrivateParam.getUSER().getToken()).enqueue(new Callback<CreatCommentObj>() {
                        @Override
                        public void onResponse(Call<CreatCommentObj> call, Response<CreatCommentObj> response) {
                            if(response.body()!=null&&response.code()==200){
                                Log.e(TAG, "onResponse: comment success" );
                                bts_ipcmt.setText("");
                                LoadComment(adapter);
                            }else
                            Log.e(TAG, "onResponse: comment fail "+response.code() );
                        }

                        @Override
                        public void onFailure(Call<CreatCommentObj> call, Throwable t) {
                            Log.e(TAG, "onFailure: "+t.getMessage() );
                        }
                    });

                }
            }
        });
        return view;
    }

    private void mapping(){
        comments = new ArrayList<>();
        bts_list_cmt = view.findViewById(R.id.bts_list_cmt);
        bts_ipcmt = view.findViewById(R.id.bts_ipcmt);
        bts_sendcmt = view.findViewById(R.id.bts_sendcmt);
    }
    private void LoadComment(CommentAdapter adapter){

        Util.getInstance().getRetrofitInstance().getListCommentCall(postId,"Bearer "+ PrivateParam.getUSER().getToken()).enqueue(new Callback<CommentListObj>() {
            @Override
            public void onResponse(Call<CommentListObj> call, Response<CommentListObj> response) {
                if(response.body()!=null){

                    Log.e(TAG, "onResponse:bodyDataListcomment "+response.body().getData().length );
                    Log.e(TAG, "onResponse:bodyDataListcomment "+response.body().getMessage() );
                    Log.e(TAG, "onResponse: IDBV"+postId );
                    comments.removeAll(comments);
                    for (Comment c:response.body().getData()) {
                        comments.add(c);
                    }
                    adapter.notifyDataSetChanged();
                }
                Log.e(TAG, "onResponse: getListCommentCall"+response.code() );

            }

            @Override
            public void onFailure(Call<CommentListObj> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t.getMessage() );
            }
        });
    }
}
