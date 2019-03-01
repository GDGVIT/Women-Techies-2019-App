package com.example.wtmapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.wtmapp.About.AboutActivity;
import com.example.wtmapp.Agenda.AgendaFragment;
import com.example.wtmapp.Question.QuestionFragment;
import com.example.wtmapp.Sponsor.SponsorFragment;
import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        Fragment selectedScreen = null;
        int id = item.getItemId();

        if (id == R.id.nav_agenda) {
            selectedScreen = AgendaFragment.newInstance();
//            Intent intentToAgenda = new Intent(MainActivity.this, AgendaActivity.class);
//            startActivity(intentToAgenda);
            showFragment(selectedScreen);
            toolbar.setTitle("Agenda");
        }
        else if (id == R.id.nav_about) {
            Intent intentToAbout = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intentToAbout);
//            selectedScreen = AboutActivity.newInstance();
//            showFragment(selectedScreen);
            toolbar.setTitle("About");
        }
        else if (id == R.id.nav_sponsors) {
            selectedScreen = SponsorFragment.newInstance();
            showFragment(selectedScreen);
            toolbar.setTitle("Sponsors");
        }

        else if (id == R.id.nav_sign_in) {
            selectedScreen = SignInFragment.newInstance();
            showFragment(selectedScreen);
            toolbar.setTitle("Sign In");
        }

        else if (id == R.id.nav_scratch_card) {
            selectedScreen = ScratchFragment.newInstance();
            showFragment(selectedScreen);
            toolbar.setTitle("Scratch card");
        }
        else if (id == R.id.nav_questions) {
            selectedScreen = QuestionFragment.newInstance();
            showFragment(selectedScreen);
            toolbar.setTitle("Questions");
        }


//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

       // showFragment(selectedScreen);
    }

    private void showFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_layout, fragment)
                .commit();
    }

}
