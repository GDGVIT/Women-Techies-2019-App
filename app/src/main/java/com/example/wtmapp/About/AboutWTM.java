package com.example.wtmapp.About;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.wtmapp.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AboutWTM extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Button btnToDSCFAQ = findViewById(R.id.btn_dsc_faq);
        Button btnToDSCAbout = findViewById(R.id.btn_dsc_about);

        btnToDSCAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                FragmentManager fragmentManager = getFragmentManager ();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction ();
//
//                AboutDscAbout myfragment = new AboutDscAbout();
//                fragmentTransaction.add (R.id.about_dc_content, myfragment);
//                fragmentTransaction.commit ();

            }
        });
    }
}
