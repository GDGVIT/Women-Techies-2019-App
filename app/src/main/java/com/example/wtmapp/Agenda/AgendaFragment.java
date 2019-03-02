package com.example.wtmapp.Agenda;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.wtmapp.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class AgendaFragment extends Fragment {

    private static RecyclerView.Adapter adapter;
    private static RecyclerView.Adapter anotherAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.LayoutManager anotherLayoutManager;
    private static RecyclerView recyclerView;
    private static RecyclerView anotherRecyclerView;
    private static ArrayList<Agenda> data;
    private static ArrayList<Agenda> anotherData;
    ImageView image1;
    ImageView image2;



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

        layoutManager = new LinearLayoutManager(rootView.getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        image1 = rootView.findViewById(R.id.image_one);
        image2 = rootView.findViewById(R.id.image_two);

        data = new ArrayList<Agenda>();
        for (int i = 0; i < AgendaData.nameArray.length; i++) {
            data.add(new Agenda(
                    AgendaData.nameArray[i],
                    AgendaData.timeArray[i],
                    AgendaData.id_[i],
                    AgendaData.drawableArray[i]
            ));
        }



        adapter = new AgendaAdapter(data);
        recyclerView.setAdapter(adapter);

//        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
//
//            @Override
//            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
//
//                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
//
//                int firstCompleteVisibleItemPosition = -1;
//                int lastCompleteVisibleItemPosition = -1;
//                int visibleItemCount = layoutManager.getChildCount();
//                int totalItemCount = layoutManager.getItemCount();
//
//                if(layoutManager instanceof GridLayoutManager)
//                {
//                    GridLayoutManager gridLayoutManager = (GridLayoutManager)layoutManager;
//                    firstCompleteVisibleItemPosition = gridLayoutManager.findFirstCompletelyVisibleItemPosition();
//                    lastCompleteVisibleItemPosition = gridLayoutManager.findLastCompletelyVisibleItemPosition();
//                }else if(layoutManager instanceof  LinearLayoutManager)
//                {
//                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager)layoutManager;
//                    firstCompleteVisibleItemPosition = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
//                    lastCompleteVisibleItemPosition = linearLayoutManager.findLastCompletelyVisibleItemPosition();
//                }
//
//                String message = "";
//
//                // Means scroll at beginning ( top to bottom or left to right).
//                if(firstCompleteVisibleItemPosition == 0)
//                {
//                    // dy < 0 means scroll to bottom, dx < 0 means scroll to right at beginning.
//                    if(dy < 0 || dx < 0)
//                    {
//                        // Means scroll to bottom.
//                        if(dy < 0)
//                        {
//                            Toast.makeText(getContext(), "First scroll to bottom", Toast.LENGTH_SHORT).show();
//                        }
//
//                        // Means scroll to right.
//                        if(dx < 0 )
//                        {
//                            Toast.makeText(getContext(), "First scroll to right", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                }
//                // Means scroll at ending ( bottom to top or right to left )
//                else if(lastCompleteVisibleItemPosition == (totalItemCount - 1))
//                {
//                    // dy > 0 means scroll to up, dx > 0 means scroll to left at ending.
//                    if(dy > 0 || dx > 0)
//                    {
//                        // Scroll to top
//                        if(dy > 0)
//                        {
//                            Toast.makeText(getContext(), "First scroll to top", Toast.LENGTH_SHORT).show();
//                        }
//
//                        // Scroll to left
//                        if(dx > 0 )
//                        {
//                            Toast.makeText(getContext(), "First scroll to left", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                }
//
//                if(message.length() > 0) {
//                    Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
//                }
//            }
//        });


        anotherRecyclerView = (RecyclerView) rootView.findViewById(R.id.my_recycler_view_other);
        anotherRecyclerView.setHasFixedSize(true);

        anotherLayoutManager = new LinearLayoutManager(rootView.getContext(), LinearLayoutManager.HORIZONTAL, false);
        anotherRecyclerView.setLayoutManager(anotherLayoutManager);
        anotherRecyclerView.setItemAnimator(new DefaultItemAnimator());

        anotherData = new ArrayList<Agenda>();
        for (int i = 0; i < AgendaAnotherData.nameArray.length; i++) {
            anotherData.add(new Agenda(
                    AgendaAnotherData.nameArray[i],
                    AgendaAnotherData.timeArray[i],
                    AgendaAnotherData.id_[i],
                    AgendaAnotherData.drawableArray[i]
            ));
        }

        anotherAdapter = new AgendaAdapter(anotherData);
        anotherRecyclerView.setAdapter(anotherAdapter);
        return rootView;
    }


}
