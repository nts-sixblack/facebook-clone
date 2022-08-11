package com.example.facebook.service;

import android.util.Log;
import android.widget.Toast;
import com.example.facebook.Adapter.CommentAdapter;
import com.example.facebook.Adapter.NewsProfileAdapter;
import com.example.facebook.Adapter.SearchAdapter;
import com.example.facebook.Obj.*;
import com.example.facebook.StaticParam.PrivateParam;
import com.example.facebook.Util;
import com.example.facebook.YourProfileActivity;
import com.example.facebook.form.RegisterForm;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;

public class ApiService {
    private Gson gson = new Gson();
    public UserV2 signUp(String firstName, String lastName, String email, String phone, String password){
        UserV2[] userV2s = {new UserV2()};
        RegisterForm registerForm = new RegisterForm(firstName, lastName, email, phone, password);

        Util.getInstance().getRetrofitInstance().getSignUp(registerForm).enqueue(new Callback<ResponObject>() {
            @Override
            public void onResponse(Call<ResponObject> call, Response<ResponObject> response) {
                ResponObject responObject = response.body();
                if (responObject==null){
                    return;
                } else {
                    JsonObject jsonObject = gson.toJsonTree(responObject.getData()).getAsJsonObject();
                    userV2s[0] = gson.fromJson(jsonObject, UserV2.class);
                    Log.e("regisrer","register success");
                }
            }

            @Override
            public void onFailure(Call<ResponObject> call, Throwable t) {

            }
        });

        return userV2s[0];
    }

    public void findByName(String name, SearchAdapter adapter, ArrayList<Search_itemObj> list){
        String token = PrivateParam.getUSER().getToken();
        Util.getInstance().getRetrofitInstance().findByName(token, name).enqueue(new Callback<ResponObject>() {
            @Override
            public void onResponse(Call<ResponObject> call, Response<ResponObject> response) {
                ResponObject responObject = response.body();
                if (responObject != null){
                    list.removeAll(list);
                    JsonArray jsonArray = gson.toJsonTree(responObject.getData()).getAsJsonArray();
                    for (int i = 0; i<jsonArray.size(); i++){
                        JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
                        int id = jsonObject.get("userId").getAsInt();
                        String avt = "";
                        if (jsonObject.has("avatar")){
                        avt = jsonObject.get("avatar").getAsString();
                        }
                        String name = jsonObject.get("name").getAsString();
//                        int co = Integer.parseInt(jsonObject.get("numberOfFollowing").getAsInt()+"");
                        int co = jsonObject.get("numberOfFollowing").getAsInt();
                        String count = co+"";
                        Search_itemObj search_itemObj = new Search_itemObj(id, avt, name, count);
                        list.add(search_itemObj);
                    }
                } else {
                    Log.e("fail","fail");
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ResponObject> call, Throwable t) {
                Log.e("fail", t.getMessage());
            }
        });
    }

    public void listPostsOfUser(int userId, NewsProfileAdapter adapter, ArrayList<NewsItemProfile> list){
        String token = PrivateParam.getUSER().getToken();
        Util.getInstance().getRetrofitInstance().listPostOfUser("Bearer "+token, userId+"").enqueue(new Callback<ResponObject>() {
            @Override
            public void onResponse(Call<ResponObject> call, Response<ResponObject> response) {
                ResponObject responObject = response.body();
                if (responObject!=null){
                    Post[] posts = {new Post()};
                    JsonArray jsonArray = gson.toJsonTree(responObject.getData()).getAsJsonArray();
                    for (int i = 0; i<jsonArray.size(); i++){
                        JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
                        posts[0] = gson.fromJson(jsonObject, Post.class);

                        NewsItemProfile newsItemProfile = new NewsItemProfile();
                        newsItemProfile.setPostsId(posts[0].getPostsId());
                        newsItemProfile.setImgNewsProfile(posts[0].getPostsImageList()[0].getImage());
                        newsItemProfile.setImgAvaProfile(posts[0].getPostsUserList()[0].getImage());
                        newsItemProfile.setTxtThinkNewsProfile(posts[0].getCaption());
                        newsItemProfile.setTxtTimeNewsProfile(posts[0].getDateCreate());
                        newsItemProfile.setTxtNameProfile(posts[0].getPostsUserList()[0].getName());
                        newsItemProfile.setCountFeel(posts[0].getTotalFeel());
                        newsItemProfile.setCountComment(posts[0].getTotalComment());
                        newsItemProfile.setFeel(posts[0].isFeel());
                        list.add(newsItemProfile);
                    }
                    adapter.notifyDataSetChanged();
                } else {
                    Log.e("error", "null response");

                }
            }

            @Override
            public void onFailure(Call<ResponObject> call, Throwable t) {
                Log.e("error","error list posts of user");
            }
        });
    }

    public UserV2 inforOfUser(int userId, YourProfileActivity.LoadingData loadingData){
        String token = PrivateParam.getUSER().getToken();

        UserV2[] userV2s = {new UserV2()};
        Util.getInstance().getRetrofitInstance().inforOfUser("Bearer "+token, userId).enqueue(new Callback<ResponObject>() {
            @Override
            public void onResponse(Call<ResponObject> call, Response<ResponObject> response) {
                ResponObject responObject = response.body();
                if (responObject == null){
                    Log.e("error", "null");
                } else {
                    JsonObject jsonObject = gson.toJsonTree(responObject.getData()).getAsJsonObject();
                    userV2s[0] = gson.fromJson(jsonObject, UserV2.class);

                    loadingData.load(userV2s[0]);
                }
            }

            @Override
            public void onFailure(Call<ResponObject> call, Throwable t) {

            }
        });
        return userV2s[0];
    }

    public void sendRequestFollow(int userId){
        String token = PrivateParam.getUSER().getToken();
        Util.getInstance().getRetrofitInstance().sendRequestFollow("Bearer "+token, userId).enqueue(new Callback<ResponObject>() {
            @Override
            public void onResponse(Call<ResponObject> call, Response<ResponObject> response) {
                if (response.body()!=null){
                    Log.e("Call","send request success");
                } else {
                    Log.e("Call","send request fail");
                }
            }
            @Override
            public void onFailure(Call<ResponObject> call, Throwable t) {
                Log.e("error", t.getMessage());
            }
        });
    }

    public void feelPosts(int postsId){
        String token = PrivateParam.getUSER().getToken();
        Util.getInstance().getRetrofitInstance().feelPosts("Bearer "+token, postsId).enqueue(new Callback<ResponObject>() {
            @Override
            public void onResponse(Call<ResponObject> call, Response<ResponObject> response) {
                if (response.body()!=null){
                    Log.e("call","feel success");
                } else {
                    Log.e("call","feel faul");
                }
            }
            @Override
            public void onFailure(Call<ResponObject> call, Throwable t) {

            }
        });
    }

    public void listComment(int postsId, CommentAdapter adapter, ArrayList<Comment> list){
        String token = PrivateParam.getUSER().getToken();
        Util.getInstance().getRetrofitInstance().listCommentOfPosts("Bearer "+token, postsId).enqueue(new Callback<ResponObject>() {
            @Override
            public void onResponse(Call<ResponObject> call, Response<ResponObject> response) {
                ResponObject responObject = response.body();
                if (responObject==null){
                    Log.e("call","response null");
                } else {
                    Log.e("call","list comment success");
                    Comment[] comments = {new Comment()};
                    JsonArray jsonArray = gson.toJsonTree(responObject.getData()).getAsJsonArray();
                    for (int i = 0; i<jsonArray.size(); i++){
                        JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
                        comments[0] = gson.fromJson(jsonObject, Comment.class);
                        list.add(comments[0]);
                    }
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<ResponObject> call, Throwable t) {
                Log.e("call","list comment error");
            }
        });

    }
}
