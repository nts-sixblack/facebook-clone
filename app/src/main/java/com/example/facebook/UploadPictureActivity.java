package com.example.facebook;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.facebook.Obj.NewPost;
import com.example.facebook.StaticParam.PrivateParam;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UploadPictureActivity extends AppCompatActivity {

    private static final int SECOND_ACTIVITY_REQUEST_CODE = 0;
    private ImageView imgFromGallery, imgMoreAddOptions, imgAddPicture;
    private Toolbar toolbar;
    private String path="";
    private ImageView img_avatar;
    private TextView tv_user_name;
    private TextView tvSubmitPicture;
    private ImageButton btnShowBackgroundStatusBar, btnHideBackgroundStatusBar, btnRemovePicture;
    private LinearLayout layoutBackgroundStatusBar;
    private Spinner spnViewMode;
    private EditText edt_status;
    private Button btnAddAlbum;
    private RecyclerView recyclerViewBackgroundStatus;
    private BackgroundStatusAdapter backgroundStatusAdapter;
    private ArrayList<BackgroundStatus> backgroundStatusArrayList = new ArrayList<BackgroundStatus>();
    private final int MY_REQUEST_CODE = 10;
    private Intent tmpData;
    static String albumName = "";
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_picture);

        /* Toolbar */

        toolbar = findViewById(R.id.toolbar_upload_picture);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_25);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        edt_status = findViewById(R.id.edt_status);

        //Axa Avatar va Name

        img_avatar = findViewById(R.id.img_avatar);
        tv_user_name = findViewById(R.id.tv_user_name);


        //Set AvatarUser va NameUser

        Glide.with(this.getApplicationContext())
                .load(PrivateParam.getUSER().getAvatar())
                .into(img_avatar);

        tv_user_name.setText(PrivateParam.getUSER().getName());
        tvSubmitPicture = findViewById(R.id.tv_submit_picture);
        // Click to ĐĂNG
        tvSubmitPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (path == null) {
                    // No upload picture
                    Toast.makeText(UploadPictureActivity.this,"Hãy chọn ảnh!", Toast.LENGTH_LONG).show();
                } else {
                    // Picture is uploaded
//                    onBackPressed();
                    UploadFiles(path);
                }
            }
        });

        /* Screen */

        imgFromGallery = findViewById(R.id.img_from_gallery);
        spnViewMode = findViewById(R.id.spn_edit_profile_view_mode);

        List<String> listViewMode = new ArrayList<>();
        listViewMode.add("Công khai");
        listViewMode.add("Bạn bè");
        listViewMode

                .add("Chỉ mình tôi");

        ArrayAdapter<String> adapterViewMode = new ArrayAdapter(this, android.R.layout.simple_spinner_item,listViewMode);
        adapterViewMode.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);

        spnViewMode.setAdapter(adapterViewMode);
        spnViewMode.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ((TextView) adapterView.getChildAt(0)).setTextColor(Color.WHITE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        imgMoreAddOptions = findViewById(R.id.img_upload_picture_more_add_options);
        imgMoreAddOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomMenuUploadPictureMoreAddOptions();
            }
        });

        btnShowBackgroundStatusBar = findViewById(R.id.btn_show_background_status_bar);
        btnHideBackgroundStatusBar = findViewById(R.id.btn_hide_background_status_bar);
        layoutBackgroundStatusBar = findViewById(R.id.layout_background_status_bar);
        btnShowBackgroundStatusBar.setVisibility(View.VISIBLE);
        layoutBackgroundStatusBar.setVisibility(View.GONE);
        btnShowBackgroundStatusBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnShowBackgroundStatusBar.setVisibility(View.GONE);
                layoutBackgroundStatusBar.setVisibility(View.VISIBLE);
            }
        });
        btnHideBackgroundStatusBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnShowBackgroundStatusBar.setVisibility(View.VISIBLE);
                layoutBackgroundStatusBar.setVisibility(View.GONE);
            }
        });

        recyclerViewBackgroundStatus = findViewById(R.id.recycler_view_background_status);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewBackgroundStatus.setLayoutManager(layoutManager);
        backgroundStatusAdapter = new BackgroundStatusAdapter(this,backgroundStatusArrayList);
        recyclerViewBackgroundStatus.setAdapter(backgroundStatusAdapter);
        backgroundStatusArrayList.add(new BackgroundStatus(R.color.bootstrap_gray));
        backgroundStatusArrayList.add(new BackgroundStatus(R.drawable.background_status_1));
        backgroundStatusArrayList.add(new BackgroundStatus(R.drawable.background_status_2));
        backgroundStatusArrayList.add(new BackgroundStatus(R.drawable.background_status_3));
        backgroundStatusArrayList.add(new BackgroundStatus(R.drawable.background_status_4));
        backgroundStatusArrayList.add(new BackgroundStatus(R.drawable.background_status_5));
        backgroundStatusArrayList.add(new BackgroundStatus(R.drawable.background_status_6));
        backgroundStatusArrayList.add(new BackgroundStatus(R.drawable.background_status_7));
        backgroundStatusAdapter.notifyDataSetChanged();

        imgAddPicture = findViewById(R.id.img_upload_picture_add_picture);
        imgAddPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickRequestPermission();
            }
        });

        btnRemovePicture = findViewById(R.id.btn_remove_picture);
        btnRemovePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgFromGallery.setImageBitmap(null);
            }
        });

        btnAddAlbum = findViewById(R.id.btn_edit_profile_add_album);
        btnAddAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), SelectAlbumActivity.class);
                intent.putExtra("DATA", "value");
                intent.putExtra("Activity name", SelectAlbumActivity.class.getName());
                //Log.i("Activity name", SelectAlbumActivity.class.getName());
                startActivityForResult(intent, SECOND_ACTIVITY_REQUEST_CODE);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==MY_REQUEST_CODE && resultCode==RESULT_OK && data!=null){
            Uri uri=data.getData();
            path=getRealPathFromURI(uri);
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
                        .into(imgFromGallery);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
    }

    private void showBottomMenuUploadPictureMoreAddOptions() {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.bottom_menu_upload_picture_more_add_options);
        LinearLayout layoutAddPicture = bottomSheetDialog.findViewById(R.id.layout_upload_picture_add_picture);
        layoutAddPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickRequestPermission();
                bottomSheetDialog.dismiss();
            }
        });
        LinearLayout layoutAddTagPerson = bottomSheetDialog.findViewById(R.id.layout_upload_picture_add_tag_person);
        layoutAddTagPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialog.dismiss();
            }
        });
        LinearLayout layoutAddEmotion = bottomSheetDialog.findViewById(R.id.layout_upload_picture_add_emotion);
        layoutAddEmotion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialog.dismiss();
            }
        });
        LinearLayout layoutAddLocation = bottomSheetDialog.findViewById(R.id.layout_upload_picture_add_location);
        layoutAddLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialog.dismiss();
            }
        });
        LinearLayout layoutAddLiveVideo = bottomSheetDialog.findViewById(R.id.layout_upload_picture_add_live_video);
        layoutAddLiveVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialog.dismiss();
            }
        });
        LinearLayout layoutAddBackgroundColor = bottomSheetDialog.findViewById(R.id.layout_upload_picture_add_background_color);
        layoutAddBackgroundColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnShowBackgroundStatusBar = findViewById(R.id.btn_show_background_status_bar);
                layoutBackgroundStatusBar = findViewById(R.id.layout_background_status_bar);
                btnShowBackgroundStatusBar.setVisibility(View.GONE);
                layoutBackgroundStatusBar.setVisibility(View.VISIBLE);
                bottomSheetDialog.dismiss();
            }
        });
        LinearLayout layoutAddCamera = bottomSheetDialog.findViewById(R.id.layout_upload_picture_add_camera);
        layoutAddCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialog.dismiss();
            }
        });
        LinearLayout layoutAddGif = bottomSheetDialog.findViewById(R.id.layout_upload_picture_add_gif);
        layoutAddGif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialog.dismiss();
            }
        });
        LinearLayout layoutAddQaOrganization = bottomSheetDialog.findViewById(R.id.layout_upload_picture_add_QA_organization);
        layoutAddQaOrganization.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialog.dismiss();
            }
        });
        LinearLayout layoutAddLayout = bottomSheetDialog.findViewById(R.id.layout_upload_picture_add_layout);
        layoutAddLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.show();
    }
    //Yeu cau quyen truy cap bo nho trong
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

    public void UploadFiles(String uri){
        Log.e(TAG, "UploadFiles: "+uri );
        if(uri==null) return;
        File file = new File(uri);
        RequestBody requestBody = RequestBody.create(MediaType.parse(getType(uri)),file);
        MultipartBody.Part part = MultipartBody.Part.createFormData("files",file.getName(),requestBody);
        Util.getInstance().getRetrofitInstance().uploadNews(edt_status.getText().toString(),part,"Bearer "+ PrivateParam.getUSER().getToken()).enqueue(new Callback<NewPost>() {
            @Override
            public void onResponse(Call<NewPost> call, Response<NewPost> response) {
                if(response.body()!=null){
                    Log.e(TAG, "onResponse: "+response.body().getMessage());
                    Toast.makeText(UploadPictureActivity.this,"Đăng ảnh thành công.", Toast.LENGTH_LONG).show();
                    onBackPressed();
                }else{
                    Log.e(TAG, "onResponse: body null" );
                    Toast.makeText(UploadPictureActivity.this,"Đăng ảnh thất bại. Server Err", Toast.LENGTH_LONG).show();
                }
//                Log.e(TAG, "onResponse: "+response.code() );
//                Log.e(TAG, "onResponse: "+PrivateParam.getUSER().getToken() );


            }

            @Override
            public void onFailure(Call<NewPost> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t.getMessage() );
            }
        });

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
    private String getType(String paths) {
        String extendt= MimeTypeMap.getFileExtensionFromUrl(paths);
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(extendt);
    }
}