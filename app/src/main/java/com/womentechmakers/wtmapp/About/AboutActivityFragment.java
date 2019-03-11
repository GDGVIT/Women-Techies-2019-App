package com.womentechmakers.wtmapp.About;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.womentechmakers.wtmapp.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AboutActivityFragment extends Fragment {


    public AboutActivityFragment() {
    }

    public static AboutActivityFragment newInstance() {
        return new AboutActivityFragment();
    }

    View rootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_about, container, false);


        ImageButton btnToDSC;
        ImageButton btnToWTM;

        btnToDSC = rootView.findViewById(R.id.btn_dsc);
        btnToWTM = rootView.findViewById(R.id.btn_wtm);

        btnToDSC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), AboutDSCActivity.class);
                startActivity(intent);
            }
        });

        btnToWTM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentToWTM = new Intent(getActivity(), AboutWTMActivity.class);
                startActivity(intentToWTM);
            }
        });

        return rootView;
    }
}
