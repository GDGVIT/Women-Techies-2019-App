package com.womentechmakers.wtmapp;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.womentechmakers.wtmapp.About.AboutActivityFragment;
import com.womentechmakers.wtmapp.Agenda.AgendaFragment;
import com.womentechmakers.wtmapp.Question.Question;
import com.womentechmakers.wtmapp.Question.QuestionFragment;
import com.womentechmakers.wtmapp.Quiz.QuizIntroFragment;
import com.womentechmakers.wtmapp.R;
import com.womentechmakers.wtmapp.Sponsor.Sponsor;
import com.womentechmakers.wtmapp.Sponsor.SponsorFragment;
import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    Toolbar toolbar;

    TextView mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);

        //toolbar.setTitle("Agenda");
        mTitle.setText("Agenda");
        toolbar.setTitleTextAppearance(this, R.style.BarlowTextAppearance);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.colorGradientBlue));

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        final String[] menus = {"Agenda", "Scratch Card", "Quiz", "Questions", "Sponsors", "About", "Sign In"};

        ListView navlist = (ListView) findViewById(R.id.list);
        NavPanelListAdapter adapter = new NavPanelListAdapter(this, menus);
        navlist.setAdapter(adapter);

        getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.frame_layout);
                if (fragment != null) {
                    String className = fragment.getClass().getName();

                    if (className.equals(AgendaFragment.class.getName())) {
                        mTitle.setText("Agenda");
                    } else if (className.equals(ScratchFragment.class.getName())){
                        mTitle.setText("Scratch Card");
                    }
                    else if (className.equals(SponsorFragment.class.getName())){
                        mTitle.setText("Sponsors");
                    }
                    else if (className.equals(AboutActivityFragment.class.getName())){
                        mTitle.setText("About");
                    }
                    else if (className.equals(SignInFragment.class.getName())){
                        mTitle.setText("Sign In");
                    }
                    else if (className.equals(QuestionFragment.class.getName())){
                        mTitle.setText("Question");
                    }
                    else if (className.equals(QuizIntroFragment.class.getName())){
                        mTitle.setText("Quiz");
                    }
                }
            }
        });

        navlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String selectedMenu = menus[i];

                switch (selectedMenu) {

                    case "Agenda":
                        AgendaFragment cameraImportFragment = new AgendaFragment();
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frame_layout, cameraImportFragment)
                                .addToBackStack(null)
                                .commit();
                        mTitle.setText("Agenda");

                       // toolbar.setTitle("Agenda");
                        break;

                    case "About":
                        AboutActivityFragment galleryFragment = new AboutActivityFragment();
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frame_layout, galleryFragment)
                                .addToBackStack(null)
                                .commit();
                        mTitle.setText("About");

//                        toolbar.setTitle("About");
                        break;

                    case "Sponsors":
                        SponsorFragment slideShowFragment = new SponsorFragment();
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frame_layout, slideShowFragment)
                                .addToBackStack(null)
                                .commit();
                        mTitle.setText("Sponsors");

//                        toolbar.setTitle("Sponsors");
                        break;

                    case "Sign In":
                        SignInFragment toolsFragment = new SignInFragment();
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frame_layout, toolsFragment)
                                .addToBackStack(null)
                                .commit();
                        //toolbar.setTitle("Sign In");
                        mTitle.setText("Sign In");

                        break;

                    case "Scratch Card":
                        ScratchFragment shareFragment = new ScratchFragment();
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frame_layout, shareFragment)
                                .addToBackStack(null)
                                .commit();
                        //toolbar.setTitle("Scratch Card");
                        mTitle.setText("Scratch Card");

                        break;

                    case "Questions":
                        QuestionFragment sendFragment = new QuestionFragment();
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frame_layout, sendFragment)
                                .addToBackStack(null)
                                .commit();
                        mTitle.setText("Questions");
                      //  toolbar.setTitle("Questions");
                        break;

                    case "Quiz":
                        QuizIntroFragment quizFragment = new QuizIntroFragment();
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frame_layout, quizFragment)
                                .addToBackStack(null)
                                .commit();
                        mTitle.setText("Quiz");

                        // toolbar.setTitle("Quiz");
                        break;


                }

                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);


            }
        });


        FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
        tx.replace(R.id.frame_layout, new AgendaFragment());
        tx.commit();

    }

    public void updateToolbarTitle(String title){
        mTitle.setText(title);
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

        switch (id) {
            case (R.id.nav_agenda):
                selectedScreen = AgendaFragment.newInstance();
                showFragment(selectedScreen);
                toolbar.setTitle("Agenda");
                break;
            case (R.id.nav_about):
                selectedScreen = AboutActivityFragment.newInstance();
                showFragment(selectedScreen);
                toolbar.setTitle("About");
                break;
            case (R.id.nav_sponsors):
                selectedScreen = SponsorFragment.newInstance();
                showFragment(selectedScreen);
                toolbar.setTitle("Sponsors");
                break;
            case (R.id.nav_sign_in):
                selectedScreen = SignInFragment.newInstance();
                showFragment(selectedScreen);
                toolbar.setTitle("Sign In");
                break;
            case (R.id.nav_scratch_card):
                selectedScreen = ScratchFragment.newInstance();
                showFragment(selectedScreen);
                toolbar.setTitle("Scratch card");
                break;
            case (R.id.nav_questions):
                selectedScreen = QuestionFragment.newInstance();
                showFragment(selectedScreen);
                toolbar.setTitle("Questions");
                break;
            case (R.id.nav_quiz):
                selectedScreen = QuizIntroFragment.newInstance();
                showFragment(selectedScreen);
                toolbar.setTitle("Quiz");
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void showFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_layout, fragment)
                .commit();
    }

}
