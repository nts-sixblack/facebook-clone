package com.example.facebook;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;

public class NewFeeds extends AppCompatActivity {
        private Button bottemShet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_feeds);
        bottemShet = findViewById(R.id.button_sheet);
        bottemShet.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                        showDialog();
                }
        });


        }

        private void showDialog() {
            final Dialog dialog = new Dialog(this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.bottomsheet_layout);

            LinearLayout editLayoutAnh = dialog.findViewById(R.id.layout_anh);
            LinearLayout editLayoutGanthe = dialog.findViewById(R.id.layout_ganthe);
            LinearLayout editLayoutCamxuc = dialog.findViewById(R.id.layout_camxuc);
            LinearLayout editLayoutCheckin = dialog.findViewById(R.id.layout_checkin);
            LinearLayout editLayoutVideo = dialog.findViewById(R.id.layout_video);
            LinearLayout editLayoutMau = dialog.findViewById(R.id.layout_mau);
            LinearLayout editLayoutCamera = dialog.findViewById(R.id.layout_camera);
            LinearLayout editLayoutFile = dialog.findViewById(R.id.layout_file);
            LinearLayout editLayoutMeet = dialog.findViewById(R.id.layout_meet);

            editLayoutAnh.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                    Toast.makeText(NewFeeds.this,"Anh is complete",Toast.LENGTH_SHORT).show();
                }
            });
            dialog.show();
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.getWindow().getAttributes().windowAnimations = R.style.DialoAnimation;
            dialog.getWindow().setGravity(Gravity.BOTTOM);

        }

        ;

//        //get the spinner from the xml.
//        Spinner dropdown = findViewById(R.id.spinner1);
////create a list of items for the spinner.
//        String[] items = new String[]{"Chỉ mình tôi", "2", "three"};
////create an adapter to describe how the items are displayed, adapters are used in several places in android.
////There are multiple variations of this, but this is the basic variant.
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
////set the spinners adapter to the previously created one.
//        dropdown.setAdapter(adapter);
//        //get the spinner from the xml.
//        Spinner dropdown1 = findViewById(R.id.spinner2);
////create a list of items for the spinner.
//        String[] items1 = new String[]{"Chỉ mình tôi", "2", "three"};
////create an adapter to describe how the items are displayed, adapters are used in several places in android.
////There are multiple variations of this, but this is the basic variant.
//        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
////set the spinners adapter to the previously created one.
//        dropdown.setAdapter(adapter);
    }
