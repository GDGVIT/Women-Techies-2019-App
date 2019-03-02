package com.example.wtmapp.About;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.wtmapp.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

public class AboutActivity extends AppCompatActivity {
/*
//    private View rootView;
//
//    public AboutActivity() {
//    }
//
//    public static AboutActivity newInstance() {
//        return new AboutActivity();
//    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_about, container, false);


        ImageButton btnToDSC;
        ImageButton btnToWTM;

        btnToDSC = rootView.findViewById(R.id.btn_dsc);
        btnToWTM = rootView.findViewById(R.id.btn_wtm);

        btnToDSC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment selectedScreen = AboutDSCFragment.newInstance();
                Toast.makeText(getActivity(),"HELLO",Toast.LENGTH_SHORT).show();
                showFragment(selectedScreen);
            }
        });

//        btnToWTM.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intentToWTM = new Intent(AboutActivity.this,AboutWTM.class);
//                startActivity(intentToWTM);
//            }
//        });

        return rootView;
    }

    private void showFragment(Fragment fragment) {
        getFragmentManager().beginTransaction()
                .replace(R.id.frame_layout_dsc, fragment)
                .commit();
    }*/

    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_about);

        ImageButton btnToDSC;
        ImageButton btnToWTM;

//        toolbar = (Toolbar) findViewById(R.id.toolbar_other);
//        toolbar.setTitle("About DSC");
//        setSupportActionBar(toolbar);


        btnToDSC = findViewById(R.id.btn_dsc);
        btnToWTM = findViewById(R.id.btn_dsc);

        btnToDSC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(AboutActivity.this, AboutDSCFragment.class);
                startActivity(intent);
//                Fragment selectedScreen = AboutDSCFragment.newInstance();
//                showFragment(selectedScreen);

//                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//                ft.replace(R.id.frame_layout_about_dsc, AboutDSCFragment.newInstance());
//                ft.commit();
            }
        });

//        btnToWTM.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intentToWTM = new Intent(AboutActivity.this,AboutWTM.class);
//                startActivity(intentToWTM);
//            }
//        });

    }

    private void showFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_layout_about_dsc, fragment)
                .commit();
    }

    @Override
    public void onBackPressed() {

            super.onBackPressed();

    }
}
