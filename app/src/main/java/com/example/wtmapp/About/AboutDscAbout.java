package com.example.wtmapp.About;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wtmapp.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AboutDscAbout extends Fragment {
    private View rootView;

    public AboutDscAbout() {
    }

    public static AboutDscAbout newInstance() {
        return new AboutDscAbout();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.activity_about_dsc_about, container, false);
        return rootView;
    }
}
