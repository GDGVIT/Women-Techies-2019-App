package com.example.wtmapp.About;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wtmapp.R;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

public class AboutWTMActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Fragment selectedScreen;
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_wtm);

        View v = getLayoutInflater().inflate(R.layout.activity_about_wtm, null);
        toolbar = (Toolbar) v.findViewById(R.id.toolbar_other_wtm);
        toolbar.setTitleTextAppearance(this, R.style.BarlowTextAppearance);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);


        showFragment(AboutWtmAboutFragment.newInstance());

        final TextView btnToWTMFAQ = findViewById(R.id.btn_wtm_faq);
        final TextView btnToWTMAbout = findViewById(R.id.btn_wtm_about);

        btnToWTMAbout.setTextColor(Color.WHITE);
        btnToWTMAbout.setBackgroundResource(R.drawable.about_background);

        btnToWTMFAQ.setTextColor(Color.BLACK);
        btnToWTMFAQ.setBackgroundResource(R.drawable.faq_background_white);


        btnToWTMFAQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btnToWTMFAQ.setTextColor(Color.WHITE);
                btnToWTMFAQ.setBackgroundResource(R.drawable.faq_background);

                btnToWTMAbout.setTextColor(Color.BLACK);
                btnToWTMAbout.setBackgroundResource(R.drawable.about_background_white);

                selectedScreen = AboutWtmFaqFragment.newInstance();
                showFragment(selectedScreen);

            }
        });

        btnToWTMAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btnToWTMAbout.setTextColor(Color.WHITE);
                btnToWTMAbout.setBackgroundResource(R.drawable.about_background);

                btnToWTMFAQ.setTextColor(Color.BLACK);
                btnToWTMFAQ.setBackgroundResource(R.drawable.faq_background_white);

                selectedScreen = AboutWtmAboutFragment.newInstance();
                showFragment(selectedScreen);

            }
        });
    }

    private void showFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.about_wtm_content, fragment)
                .commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id==R.id.home){
            this.finish();
        }
//
//        if (item.getItemId() == android.R.id.home) {
//            Toast.makeText(getApplicationContext(),"hello",Toast.LENGTH_SHORT).show();
////            selectedScreen = AboutActivityFragment.newInstance();
////            showFragment(selectedScreen);
////            finish();
//            onBackPressed();
//        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }
}
