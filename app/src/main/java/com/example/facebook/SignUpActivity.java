package com.example.facebook;

import android.content.Intent;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.beardedhen.androidbootstrap.TypefaceProvider;
import com.example.facebook.Obj.SignUpObj;
import com.example.facebook.Obj.UserV2;
import com.example.facebook.StaticParam.PrivateParam;
import com.example.facebook.service.ApiService;
import com.google.gson.Gson;


public class SignUpActivity extends AppCompatActivity {
    private BootstrapEditText edtFirstName;
    private BootstrapEditText edtLastName;
    private BootstrapEditText edtPhone;
    private BootstrapEditText edtEmail;
    public BootstrapEditText edtPassword;
    private BootstrapButton btnSignUp;
    private Gson gson;
    private String TAG = this.getClass().getName();
    public static SignUpObj SIGNUPOBJ;
    private DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TypefaceProvider.registerDefaultIconSets();
        setContentView(R.layout.activity_sign_up);

        edtFirstName = findViewById(R.id.editTxtFirstName);
        edtLastName = findViewById(R.id.editTxtLastName);
        edtEmail = findViewById(R.id.editTxtEmail);
        edtPhone = findViewById(R.id.edtxtPhone);
        edtPassword = findViewById(R.id.editTxtpasswordSignup);
        gson = new Gson();

        btnSignUp = findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                ApiService apiService = new ApiService();
                UserV2 userV2 = apiService.signUp(
                        edtFirstName.getText().toString(),
                        edtLastName.getText().toString(),
                        edtEmail.getText().toString(),
                        edtPhone.getText().toString(),
                        edtPassword.getText().toString()
                );
                if (userV2 == null) {
                    Toast.makeText(SignUpActivity.this, "Đã tồn tại email này", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(SignUpActivity.this, "Đăng ký thành công", Toast.LENGTH_LONG).show();
                    clear();
                    finish();
                }
            }
        });
    }

    private void clear() {
        edtFirstName.setText("");
        edtLastName.setText("");
        edtEmail.setText("");
        edtPhone.setText("");
        edtPassword.setText("");
    }
//    private String getTodaysDate() {
//        Calendar cal = Calendar.getInstance();
//        int year = cal.get(Calendar.YEAR);
//        int month = cal.get(Calendar.MONTH);
//        month = month +1;
//        int day = cal.get(Calendar.DAY_OF_MONTH);
//        return makeDataString(day,month,year);
//    }

//    private String makeDataString(int day, int month, int year) {
//        return getMonthFormat( month) + " " + day +" " + year;
//    }

//    private String getMonthFormat(int month) {
//        if(month == 1){
//            return "JAN";
//        }
//        if(month == 2){
//            return "FEB";
//        }
//        if(month == 3){
//            return "MAR";
//        }
//        if(month == 4){
//            return "APR";
//        }
//        if(month == 5){
//            return "MAY";
//        }
//        if(month == 6){
//            return "JUN";
//        }
//        if(month == 7){
//            return "JULY";
//        }
//        if(month == 8){
//            return "AUG";
//        }
//        if(month == 9){
//            return "SEP";
//        }
//        if(month == 10){
//            return "OCT";
//        }
//        if(month == 11){
//            return "NOV";
//        }
//        if(month == 12){
//            return "DEC";
//        }
//        return "JAN";
//    }

//    private void initDatePicker() {
//        DatePickerDialog.OnDateSetListener dataSetListener = new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
//                month = month + 1;
//                String date = makeDataString(day , month , year);
//                dateButton.setText(date);
//
//            }
//    };
//        Calendar cal = Calendar.getInstance();
//        int year = cal.get(Calendar.YEAR);
//        int month = cal.get(Calendar.MONTH);
//        int day = cal.get(Calendar.DAY_OF_MONTH);
//
//
//        int style = AlertDialog.THEME_HOLO_LIGHT;
//
//
//
//        datePickerDialog = new DatePickerDialog(this,style,dataSetListener,year,month,day);
//
//
//    }
//
//    public void openDatePicker(View view) {
//    datePickerDialog.show();
//    }


}