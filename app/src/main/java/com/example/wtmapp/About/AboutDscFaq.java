package com.example.wtmapp.About;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wtmapp.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AboutDscFaq extends Fragment {

    private View rootView;

    public AboutDscFaq() {
    }

    public static AboutDscFaq newInstance() {
        return new AboutDscFaq();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.activity_about_dsc_faq, container,false);
        return rootView;
    }
}
