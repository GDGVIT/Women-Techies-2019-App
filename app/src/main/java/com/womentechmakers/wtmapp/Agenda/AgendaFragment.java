package com.womentechmakers.wtmapp.Agenda;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.womentechmakers.wtmapp.R;
import com.yarolegovich.discretescrollview.DiscreteScrollView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class AgendaFragment extends Fragment {

    private static RecyclerView.Adapter adapter;
    private static RecyclerView.Adapter anotherAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.LayoutManager anotherLayoutManager;
    private static RecyclerView recyclerView;
    // private static RecyclerView anotherRecyclerView;
    private static ArrayList<Agenda> data;
    private static ArrayList<Agenda> anotherData;

    //private DiscreteScrollView recyclerView;
    // private InfiniteScrollAdapter adapter;

    private DiscreteScrollView anotherRecyclerView;
    // private InfiniteScrollAdapter anotherAdapter;

    private View rootView;

    ImageView image;

    public AgendaFragment() {
    }

    public static AgendaFragment newInstance() {
        return new AgendaFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_agenda, container, false);

        // recyclerView = rootView.findViewById(R.id.my_recycler_view);
//        recyclerView.setHasFixedSize(true);
//
//        layoutManager = new LinearLayoutManager(rootView.getContext(), LinearLayoutManager.HORIZONTAL, false);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
//


        data = new ArrayList<Agenda>();
        for (int i = 0; i < AgendaData.nameArray.length; i++) {
            data.add(new Agenda(
                    AgendaData.nameArray[i],
                    AgendaData.timeArray[i],
                    AgendaData.id_[i]
            ));
        }

        AgendaAdapter adapter = new AgendaAdapter(data);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(rootView.getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView = rootView.findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);


//        recyclerView = (DiscreteScrollView) rootView.findViewById(R.id.my_recycler_view);
//        recyclerView.setOrientation(Orientation.HORIZONTAL);
//        // recyclerView.addOnItemChangedListener((DiscreteScrollView.OnItemChangedListener<?>) this.getActivity());
//        adapter = new AgendaAdapter(data);
//        recyclerView.setAdapter(adapter);
//        recyclerView.setItemTransitionTimeMillis(150);
//        recyclerView.setItemTransformer(new ScaleTransformer.Builder()
//                .setMinScale(0.95f)
//                .build());
//
//
//        //onItemChanged(data.get(0));
//        recyclerView.setSlideOnFling(true);
//        recyclerView.setSlideOnFlingThreshold(2100);

        image = rootView.findViewById(R.id.agenda_image_view);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {

                    int position = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
                    // int position = recyclerView.getLayoutManager().getPosition(rootView);

                    if (AgendaData.id_[position] == AgendaData.TEXT_TYPE) {
                        image.setImageResource(R.drawable.tenmar);
                    }
                    if (AgendaData.id_[position] == AgendaData.IMAGE_TYPE) {
                        image.setImageResource(R.drawable.elevenmar);
                    }
                }
            }
        });


//        recyclerView = (DiscreteScrollView) rootView.findViewById(R.id.my_recycler_view);
//        recyclerView.setOrientation(Orientation.HORIZONTAL);
//        // recyclerView.addOnItemChangedListener((DiscreteScrollView.OnItemChangedListener<?>) this.getActivity());
//        adapter = new AgendaAdapter(data);
//        recyclerView.setAdapter(adapter);
//        recyclerView.setItemTransitionTimeMillis(150);
//        recyclerView.setItemTransformer(new ScaleTransformer.Builder()
//                .setMinScale(0.95f)
//                .build());
//
//        //onItemChanged(data.get(0));
//        recyclerView.setSlideOnFling(true);
//        recyclerView.setSlideOnFlingThreshold(2100);

//        anotherRecyclerView = (RecyclerView) rootView.findViewById(R.id.my_recycler_view_other);
//        anotherRecyclerView.setHasFixedSize(true);
//
//        anotherLayoutManager = new LinearLayoutManager(rootView.getContext(), LinearLayoutManager.HORIZONTAL, false);
//        anotherRecyclerView.setLayoutManager(anotherLayoutManager);
//        anotherRecyclerView.setItemAnimator(new DefaultItemAnimator());

//        anotherData = new ArrayList<Agenda>();
//        for (int i = 0; i < AgendaAnotherData.nameArray.length; i++) {
//            anotherData.add(new Agenda(
//                    AgendaAnotherData.nameArray[i],
//                    AgendaAnotherData.timeArray[i],
//                    AgendaAnotherData.id_[i]
//            ));
//        }

//        anotherAdapter = new AgendaAdapter(anotherData);
//        anotherRecyclerView.setAdapter(anotherAdapter);


//        anotherRecyclerView = (DiscreteScrollView) rootView.findViewById(R.id.my_recycler_view);
//        anotherRecyclerView.setOrientation(Orientation.HORIZONTAL);
//        // recyclerView.addOnItemChangedListener((DiscreteScrollView.OnItemChangedListener<?>) this.getActivity());
//        anotherAdapter = (new AgendaAdapter(anotherData));
//        anotherRecyclerView.setAdapter(anotherAdapter);
//        anotherRecyclerView.setItemTransitionTimeMillis(150);
//        anotherRecyclerView.setItemTransformer(new ScaleTransformer.Builder()
//                .setMinScale(0.95f)
//                .build());
//
//        //onItemChanged(data.get(0));
//        anotherRecyclerView.setSlideOnFling(true);
//        anotherRecyclerView.setSlideOnFlingThreshold(2100);


        return rootView;
    }


}
