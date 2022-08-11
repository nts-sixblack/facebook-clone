package com.example.facebook;

import android.content.SharedPreferences;

import com.example.facebook.Api.SignInApi;
import com.example.facebook.StaticParam.PrivateParam;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import android.content.SharedPreferences;
import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Util {
    static Util instance;
    public static final String API_ENDPOINT = "http://35.206.242.141:9080";//"https://nts-sixblack-api-hexa.herokuapp.com";
//    public static final String API_ENDPOINT = "http://ec2-13-250-111-248.ap-southeast-1.compute.amazonaws.com:8080";//"https://nts-sixblack-api-hexa.herokuapp.com";

    public static Util getInstance(){
        if(instance==null){
            instance = new Util();
        }
        return instance;
    }

    private Retrofit retrofit;
    public SignInApi getRetrofitInstance(){
        if(retrofit==null){
            OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(1*24*60*60, TimeUnit.SECONDS)
                    .readTimeout(1*24*60*60, TimeUnit.SECONDS)
                    .writeTimeout(1*24*60*60, TimeUnit.SECONDS)
                    .addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    if(PrivateParam.getUSER()!=null){
                        Log.e("Utils Token", "intercept: "+PrivateParam.getUSER().getToken() );
                        Request request = chain.request().newBuilder().addHeader("Authorizantion","Bearer "+ PrivateParam.getUSER().getToken()).build();
                        return chain.proceed(request);

                    }else
                    {
                        Request request = chain.request().newBuilder().build();
                        return chain.proceed(request);
                    }


                }
            }).build();

            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();
            retrofit = new Retrofit.Builder()
                    .client(client)

                    .baseUrl(API_ENDPOINT)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();


        }
        return retrofit.create(SignInApi.class);
    }
}
