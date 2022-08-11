package com.example.facebook.Api;

import com.example.facebook.Obj.*;

import java.util.HashMap;

import com.example.facebook.form.RegisterForm;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface SignInApi {
//    @POST("api/auth/login")
//    @FormUrlEncoded
//    Call<LoginObj> getLogin( @Field("email") String email , @Field("password") String password);

    @POST("/user/login")
    Call<LoginObjv2> getLoginObjv2Call(@Body HashMap<String , String> body);

    @DELETE("posts/{id}")
    Call<DeletePostObj> deletePostCall(@Path("id") int postId,@Header("Authorization") String authHeader);

    @POST("posts/comment")
    Call<CreatCommentObj> creatCommentCall(@Body HashMap<String,Object> body,@Header("Authorization") String authHeader);

    @GET("posts/listComment/{id}")
    Call<CommentListObj> getListCommentCall(@Path("id") int postId,@Header("Authorization") String authHeader);

//    @GET("/posts/abcd")
    @GET("posts/myPosts")
    Call<NewPost> getNewPostCall(@Header("Authorization") String authHeader);

    @GET("posts/{id}")
    Call<NewPostV2> getPostCallById(@Path("id") int postId ,@Header("Authorization") String authHeader);

    @GET("posts/like/{id}")
    Call<LikeStatus> getLikeStatusCall(@Header("Authorization") String authHeader,@Path("id") int postId);//Hanh

    @POST("/posts/new")
    @Multipart
    Call<NewPost> uploadNews(@Part("caption")String caption, @Part MultipartBody.Part files , @Header("Authorization") String authHeader);

    @POST("user/updateAvatar")
    @Multipart
    Call<ResponObject> updateAvatar( @Part MultipartBody.Part files , @Header("Authorization") String authHeader);


    @GET("api/auth/user-profile")
    Call<User> getProfileUser(@Header("Authorization") String auth);

//    //////////////////////
    @POST("user/register")
    Call<ResponObject> getSignUp(@Body RegisterForm registerForm);

    @GET("user/find/name={name}")
    Call<ResponObject> findByName(@Header("Authorization") String authHeader, @Path("name") String name);

    @GET("posts/user/{userId}")
    Call<ResponObject> listPostOfUser(@Header("Authorization") String authHeader, @Path("userId") String userId);

    @GET("user/{userId}")
    Call<ResponObject> inforOfUser(@Header("Authorization") String authHeader, @Path("userId") int userId);

    @GET("follow/send/{userId}")
    Call<ResponObject> sendRequestFollow(@Header("Authorization") String authHeader, @Path("userId") int userId);

    @GET("posts/like/{postsId}")
    Call<ResponObject> feelPosts(@Header("Authorization") String authHeader, @Path("postsId") int postsId);//Sau

    @GET("posts/listComment/{postsId}")
    Call<ResponObject> listCommentOfPosts(@Header("Authorization") String authHeader, @Path("postsId") int postsId);

}
