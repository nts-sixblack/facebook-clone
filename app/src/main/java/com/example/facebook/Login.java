package com.example.facebook;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.TypefaceProvider;
import com.example.facebook.Obj.LoginObjv2;
import com.example.facebook.Obj.User;
import com.example.facebook.StaticParam.PrivateParam;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    private EditText editTxtEmail;
    private EditText editTxtPassword;
    private BootstrapButton btnLogin;
    private TextView txtSignup;
    private CheckBox check_bock;
    public static String USERNAME="";
    public static String PASSWORD="";
    public static LoginObjv2 LOGINOBJ;
    private String TAG = this.getClass().getName();
    SharedPreferences sharedPreferences;
    private Dialog dialog ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TypefaceProvider.registerDefaultIconSets();
        setContentView(R.layout.activity_main);
        txtSignup = findViewById(R.id.txtSignup);
        btnLogin = findViewById(R.id.btnLogin);
        editTxtEmail = findViewById(R.id.editTxtFirstName);
        check_bock = findViewById(R.id.check_bock);
        editTxtPassword = findViewById(R.id.editTxtPassword);
        sharedPreferences = getSharedPreferences("dataLogin",MODE_PRIVATE);

        if (!sharedPreferences.getString("access_token","").equals("")){
            dialog = new Dialog(this);
            dialog.setContentView(R.layout.dialog_login);
            dialog.setTitle("Loging...");
            dialog.show();

            Util.getInstance().getRetrofitInstance().getProfileUser("Bearer "+ sharedPreferences.getString("access_token",""))
                    .enqueue(new Callback<User>() {
                        @Override
                        public void onResponse(Call<User> call, Response<User> response) {
                            if(response.body()!=null){
//                                LOGINOBJ = new LoginObj(sharedPreferences.getString("access_token",""),"Bearer",3600,response.body());
                                Intent intent = new Intent(Login.this,HomeActivity.class);
                                startActivity(intent);
                            }
                        }

                        @Override
                        public void onFailure(Call<User> call, Throwable t) {

                        }
                    });
        }
//        editTxtEmail.setText(sharedPreferences.getString("access_token",""));
        txtSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new Dialog(Login.this);
                dialog.setContentView(R.layout.dialog_login);
                dialog.setTitle("Loging...");
                dialog.show();
                HashMap<String , String> bodyData = new HashMap<>();
                bodyData.put("userName",editTxtEmail.getText().toString().trim());
                bodyData.put("password",editTxtPassword.getText().toString().trim());
                Util.getInstance().getRetrofitInstance()
                        .getLoginObjv2Call(bodyData)
                        .enqueue(new Callback<LoginObjv2>() {
                            @Override
                            public void onResponse(Call<LoginObjv2> call, Response<LoginObjv2> response) {
                                if (response.body()!=null){
                                    LOGINOBJ = response.body();
                                    Toast.makeText(getApplicationContext(), "Login Access", Toast.LENGTH_SHORT).show();
                                    Log.e(TAG, "onResponse: "+LOGINOBJ.getData().getToken() );
                                    if(check_bock.isChecked()){
                                        SharedPreferences.Editor editor = sharedPreferences.edit();
                                        editor.putString("access_token",LOGINOBJ.getData().getToken());
                                        editor.putBoolean("checked",true);
                                        editor.commit();
                                    }
                                    PrivateParam.setUSER(LOGINOBJ.getData());
                                    Intent intent = new Intent(Login.this,HomeActivity.class);
                                    startActivity(intent);

                                }
                            }

                            @Override
                            public void onFailure(Call<LoginObjv2> call, Throwable t) {
                                Log.e(TAG, "onFailure: "+t.getMessage() );
                            }

                        });


            }
        });

    }
}