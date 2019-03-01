package com.example.wtmapp.About;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wtmapp.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;

public class AboutDscFaq extends Fragment {

    private View rootView;
    RecyclerView faqRecyclerView;
    ArrayList<Faq> faqArrayList;

    public AboutDscFaq() {
    }

    public static AboutDscFaq newInstance() {
        return new AboutDscFaq();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.activity_about_dsc_faq, container,false);

        faqArrayList = new ArrayList<>();
        faqArrayList.add(new Faq(getString(R.string.sampleQuestion),getString(R.string.sampleAnswer)));
        faqArrayList.add(new Faq(getString(R.string.sampleQuestion),getString(R.string.sampleAnswer)));
        faqArrayList.add(new Faq(getString(R.string.sampleQuestion),getString(R.string.sampleAnswer)));
        faqArrayList.add(new Faq(getString(R.string.sampleQuestion),getString(R.string.sampleAnswer)));
        faqArrayList.add(new Faq(getString(R.string.sampleQuestion),getString(R.string.sampleAnswer)));
        faqArrayList.add(new Faq(getString(R.string.sampleQuestion),getString(R.string.sampleAnswer)));
        faqArrayList.add(new Faq(getString(R.string.sampleQuestion),getString(R.string.sampleAnswer)));
        faqArrayList.add(new Faq(getString(R.string.sampleQuestion),getString(R.string.sampleAnswer)));

        faqRecyclerView = rootView.findViewById(R.id.faq_recyclerview);
        faqRecyclerView.setHasFixedSize(true);
        faqRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        ((SimpleItemAnimator) faqRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        faqRecyclerView.setAdapter(new AboutDscFaqAdapter(faqArrayList));

        return rootView;
    }
}
