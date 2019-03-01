package com.example.wtmapp.Agenda;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wtmapp.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class AgendaFragment extends Fragment {

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<Agenda> data;
    private static ArrayList<Integer> removedItems;


    private View rootView;

    public AgendaFragment() {
    }

    public static AgendaFragment newInstance() {
        return new AgendaFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.activity_agenda, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(rootView.getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        data = new ArrayList<Agenda>();
        for (int i = 0; i < AgendaData.nameArray.length; i++) {
            data.add(new Agenda(
                    AgendaData.nameArray[i],
                    AgendaData.versionArray[i],
                    AgendaData.id_[i],
                    AgendaData.drawableArray[i]
            ));
        }

        removedItems = new ArrayList<Integer>();

        adapter = new AgendaAdapter(data);
        recyclerView.setAdapter(adapter);
        return rootView;
    }
/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_another);
//        toolbar.setTitle("Agenda");
//        toolbar.setTitleTextColor(getResources().getColor(R.color.colorBlue));
//        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        data = new ArrayList<Agenda>();
        for (int i = 0; i < AgendaData.nameArray.length; i++) {
            data.add(new Agenda(
                    AgendaData.nameArray[i],
                    AgendaData.versionArray[i],
                    AgendaData.id_[i],
                    AgendaData.drawableArray[i]
            ));
        }

        removedItems = new ArrayList<Integer>();

        adapter = new AgendaAdapter(data);
        recyclerView.setAdapter(adapter);
    }

*/
}
