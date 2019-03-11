package com.womentechmakers.wtmapp.About;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.womentechmakers.wtmapp.MainActivity;
import com.womentechmakers.wtmapp.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

public class AboutDSCActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Fragment selectedScreen;
    Toolbar toolbar;
    ImageView backButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_dsc);

        View v = getLayoutInflater().inflate(R.layout.activity_about_dsc, null);
        toolbar = v.findViewById(R.id.toolbar_other_dsc);
        toolbar.setTitleTextAppearance(this, R.style.BarlowTextAppearance);
        setSupportActionBar(toolbar);
//
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setHomeButtonEnabled(true);
//        actionBar.setDisplayHomeAsUpEnabled(true);


        backButton = findViewById(R.id.back_button_dsc);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AboutDSCActivity.this, MainActivity.class));
            }
        });

        showFragment(AboutDscAboutFragment.newInstance());

        final TextView btnToDSCFAQ = findViewById(R.id.btn_dsc_faq);
        final TextView btnToDSCAbout = findViewById(R.id.btn_dsc_about);

        btnToDSCAbout.setTextColor(Color.WHITE);
        btnToDSCAbout.setBackgroundResource(R.drawable.about_background);

        btnToDSCFAQ.setTextColor(Color.BLACK);
        btnToDSCFAQ.setBackgroundResource(R.drawable.faq_background_white);


        btnToDSCFAQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btnToDSCFAQ.setTextColor(Color.WHITE);
                btnToDSCFAQ.setBackgroundResource(R.drawable.faq_background);

                btnToDSCAbout.setTextColor(Color.BLACK);
                btnToDSCAbout.setBackgroundResource(R.drawable.about_background_white);

                selectedScreen = AboutDscFaqFragment.newInstance();
                showFragment(selectedScreen);

            }
        });

        btnToDSCAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btnToDSCAbout.setTextColor(Color.WHITE);
                btnToDSCAbout.setBackgroundResource(R.drawable.about_background);

                btnToDSCFAQ.setTextColor(Color.BLACK);
                btnToDSCFAQ.setBackgroundResource(R.drawable.faq_background_white);

                selectedScreen = AboutDscAboutFragment.newInstance();
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
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.home) {
            this.finish();
        }

//        if (item.getItemId() == android.R.id.home) {
//            onBackPressed();
//           Toast.makeText(getApplicationContext(),"hello",Toast.LENGTH_SHORT).show();
////            selectedScreen = AboutActivityFragment.newInstance();
////            showFragment(selectedScreen);
////            finish();
//
//        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }
}
