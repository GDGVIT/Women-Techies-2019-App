package com.example.wtmapp.About;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.wtmapp.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

public class AboutDSCFragment extends AppCompatActivity {
/*
    Fragment selectedScreen;

    private View rootView;

    public AboutDSCFragment() {
    }

    public static AboutDSCFragment newInstance() {
        return new AboutDSCFragment();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.activity_about_dsc, container, false);

        Button btnToDSCFAQ = rootView.findViewById(R.id.btn_dsc_faq);
        Button btnToDSCAbout = rootView.findViewById(R.id.btn_dsc_about);


        btnToDSCFAQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedScreen = AboutDscFaq.newInstance();
                showFragment(selectedScreen);

            }
        });

        btnToDSCAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedScreen = AboutDscAbout.newInstance();
                showFragment(selectedScreen);

            }
        });

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        Fragment childFragment = new AboutDscFaq();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.about_dsc_content, childFragment).commit();

        super.onViewCreated(view, savedInstanceState);
    }

    private void showFragment(Fragment fragment) {
        getFragmentManager().beginTransaction()
                .replace(R.id.about_dsc_content, fragment)
                .commit();
    }
*/

    Fragment selectedScreen;
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_dsc);


        toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbar_other);
        toolbar.setTitle("About DSC");
        setSupportActionBar(toolbar);

        Button btnToDSCFAQ = findViewById(R.id.btn_dsc_faq);
        Button btnToDSCAbout = findViewById(R.id.btn_dsc_about);


        btnToDSCFAQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedScreen = AboutDscFaq.newInstance();
                showFragment(selectedScreen);

            }
        });

        btnToDSCAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedScreen = AboutDscAbout.newInstance();
                showFragment(selectedScreen);

            }
        });
    }

    private void showFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.about_dsc_content, fragment)
                .commit();
    }

    @Override
    public void onBackPressed() {

            super.onBackPressed();

    }
}
