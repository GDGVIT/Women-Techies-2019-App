package com.womentechmakers.wtmapp.About;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.womentechmakers.wtmapp.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AboutWtmAboutFragment extends Fragment {
    private View rootView;

    public AboutWtmAboutFragment() {
    }

    public static AboutWtmAboutFragment newInstance() {
        return new AboutWtmAboutFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_about_wtm_about, container, false);
        return rootView;
    }
}
