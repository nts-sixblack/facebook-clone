package com.example.facebook;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.facebook.Obj.NewPost;
import com.example.facebook.Obj.ResponObject;
import com.example.facebook.StaticParam.PrivateParam;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class EditProfileActivity extends AppCompatActivity {

    private static final int MY_REQUEST_CODE = 10;
    private Toolbar toolbar;
    private TextView tvSaveProfile, tvChangeBackground, tvChangeAvatar;
    private ImageView imgMyAvatar, imgMyBackground;
    private TextView tv_save_profile;
    private boolean AvatarBackground = false;
    private String path;
    private String TAG = getClass().getName().toString();
    public String getRealPathFromURI(Uri contentUri) {


        String[] proj = { MediaStore.Images.Media.DATA };
        Cursor cursor = managedQuery(contentUri, proj,
                null, null, null);
        int column_index = cursor
                .getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==MY_REQUEST_CODE && resultCode==RESULT_OK && data!=null){
            Uri uri=data.getData();
            path=getRealPathFromURI(uri);
            Log.e(TAG, "onActivityResult: path: "+path );

            try {
                InputStream inputStream=getContentResolver().openInputStream(uri);
                Bitmap bitmap= BitmapFactory.decodeStream(inputStream);
                Glide.with(getApplicationContext())
                        .load(bitmap)
                        .fitCenter()
                        .timeout(5000)
                        .skipMemoryCache(false)
                        .fitCenter()
                        .centerCrop()
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .error(R.drawable.ic_baseline_error_24_dark_gray)
                        .into(imgMyAvatar);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        /* Toolbar */

        toolbar = findViewById(R.id.toolbar_edit_profile);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_25);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        tvSaveProfile = findViewById(R.id.tv_save_profile);
        tvSaveProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(EditProfileActivity.this,"Chỉnh sửa thành công", Toast.LENGTH_LONG).show();
                //onBackPressed();
            }
        });

        tvChangeAvatar = findViewById(R.id.tv_change_avatar);
        tvChangeAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AvatarBackground = false;
                onClickRequestPermission();
            }
        });

        tvChangeBackground = findViewById(R.id.tv_change_background);
        tvChangeBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AvatarBackground = true;
                onClickRequestPermission();
            }
        });

        imgMyAvatar = findViewById(R.id.img_my_avatar);

        Glide.with(this.getApplicationContext())
                .load(PrivateParam.getUSER().getAvatar())
                .into(imgMyAvatar);
        imgMyBackground = findViewById(R.id.img_my_background);

        tv_save_profile = findViewById(R.id.tv_save_profile);
        tv_save_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UploadFiles(path);
            }
        });

    }

    public void UploadFiles(String uri){
        Log.e(TAG, "UploadFiles: "+uri );
        if(uri==null) return;
        File file = new File(uri);
        RequestBody requestBody = RequestBody.create(MediaType.parse(getType(uri)),file);
        MultipartBody.Part part = MultipartBody.Part.createFormData("file",file.getName(),requestBody);
        Util.getInstance().getRetrofitInstance().updateAvatar(part,"Bearer "+ PrivateParam.getUSER().getToken()).enqueue(new Callback<ResponObject>() {
            @Override
            public void onResponse(Call<ResponObject> call, Response<ResponObject> response) {
                Log.e(TAG, "onResponse: code"+response.code() );
                if(response.body()!=null){
                    Log.e(TAG, "onResponse: "+response.body().getMessage());
                    Toast.makeText(EditProfileActivity.this,"Đăng ảnh thành công.", Toast.LENGTH_LONG).show();
                    onBackPressed();
                }else{
                    Log.e(TAG, "onResponse: body null" );
                    Toast.makeText(EditProfileActivity.this,"Đăng ảnh thất bại. Server Err", Toast.LENGTH_LONG).show();
                }
//                Log.e(TAG, "onResponse: "+PrivateParam.getUSER().getToken() );


            }

            @Override
            public void onFailure(Call<ResponObject> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t.getMessage() );
            }
        });

    }
    private String getType(String paths) {
        String extendt= MimeTypeMap.getFileExtensionFromUrl(paths);
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(extendt);
    }

    private void onClickRequestPermission() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            openGallery();
            return;
        }
        if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            openGallery();
        } else {
            String[] permission = {Manifest.permission.READ_EXTERNAL_STORAGE};
            requestPermissions(permission, MY_REQUEST_CODE);
        }
    }

    private void openGallery() {
        Intent intent =new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent,MY_REQUEST_CODE);
    }

    public void onRequestPermissionResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode,permissions, grantResults);
        if (requestCode == MY_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openGallery();
            }
        }

    }

    private void setSupportActionBar(Toolbar toolbar) {
    }
}