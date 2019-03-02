package com.example.wtmapp.Sponsor;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wtmapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.yarolegovich.discretescrollview.DiscreteScrollView;
import com.yarolegovich.discretescrollview.InfiniteScrollAdapter;
import com.yarolegovich.discretescrollview.Orientation;
import com.yarolegovich.discretescrollview.transform.ScaleTransformer;

import java.util.Arrays;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import saschpe.android.customtabs.CustomTabsHelper;
import saschpe.android.customtabs.WebViewFallback;

public class SponsorFragment extends Fragment implements DiscreteScrollView.OnItemChangedListener,
        View.OnClickListener {

    private View rootView;


    private TextView currentSponsorName;
    private TextView currentSponsorType;
    private ImageView previousSponsorButton;
    private ImageView nextSponsorButton;
    private FloatingActionButton websiteButton;
    private DiscreteScrollView itemPicker;
    private InfiniteScrollAdapter infiniteAdapter;

    private List<Sponsor> sponsorData;


    public SponsorFragment() {
    }

    public static SponsorFragment newInstance() {
        return new SponsorFragment();
    }

    public static void smoothScrollToNextPosition(final DiscreteScrollView scrollView, int pos) {
        final RecyclerView.Adapter adapter = scrollView.getAdapter();
        int destination = pos + 1;
        if (adapter instanceof InfiniteScrollAdapter) {
            destination = ((InfiniteScrollAdapter) adapter).getClosestPosition(destination);
        }
        scrollView.smoothScrollToPosition(destination);
    }

    public static void smoothScrollToPreviousPosition(final DiscreteScrollView scrollView, int pos) {
        final RecyclerView.Adapter adapter = scrollView.getAdapter();
        int destination = pos - 1;
        if (adapter instanceof InfiniteScrollAdapter) {
            destination = ((InfiniteScrollAdapter) adapter).getClosestPosition(destination);
        }
        scrollView.smoothScrollToPosition(destination);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.activity_sponsors, container, false);

        sponsorData = Arrays.asList(
                new Sponsor("WTM", "Sponsor", "https://www.womentechmakers.com/india", R.drawable.dsc_logo),
                new Sponsor("LBRY", "Sponsor", "https://lbry.io/", R.drawable.dsc_logo),
                new Sponsor("Turbot", "Sponsor", "https://turbot.com/", R.drawable.dsc_logo),
                new Sponsor("UpCloud", "Sponsor", "https://upcloud.com/", R.drawable.dsc_logo),
                new Sponsor("Hackerearth", "Sponsor", "https://www.hackerearth.com/", R.drawable.dsc_logo),
                new Sponsor("C9 Bistro", "Sponsor", "https://www.facebook.com/c9bistro/", R.drawable.dsc_logo),
                new Sponsor("MSG91", "Sponsor", "https://msg91.com/", R.drawable.dsc_logo));

        currentSponsorName = (TextView) rootView.findViewById(R.id.sponsor_name);
        currentSponsorType = (TextView) rootView.findViewById(R.id.sponsor_type);
        previousSponsorButton = (ImageView) rootView.findViewById(R.id.previous_sponsor_button);
        nextSponsorButton = (ImageView) rootView.findViewById(R.id.next_sponsor_button);
        websiteButton = (FloatingActionButton) rootView.findViewById(R.id.sponsor_website_button);

        itemPicker = (DiscreteScrollView) rootView.findViewById(R.id.item_picker);
        itemPicker.setOrientation(Orientation.HORIZONTAL);
        itemPicker.addOnItemChangedListener(this);
        infiniteAdapter = InfiniteScrollAdapter.wrap(new SponsorAdapter(sponsorData));
        itemPicker.setAdapter(infiniteAdapter);
        itemPicker.setItemTransitionTimeMillis(150);
        itemPicker.setItemTransformer(new ScaleTransformer.Builder()
                .setMinScale(0.8f)
                .build());

        onItemChanged(sponsorData.get(0));

        rootView.findViewById(R.id.sponsor_name).setOnClickListener(this);
        rootView.findViewById(R.id.sponsor_type).setOnClickListener(this);
        rootView.findViewById(R.id.previous_sponsor_button).setOnClickListener(this);
        rootView.findViewById(R.id.next_sponsor_button).setOnClickListener(this);
        rootView.findViewById(R.id.sponsor_website_button).setOnClickListener(this);

        itemPicker.setSlideOnFling(true);
        itemPicker.setSlideOnFlingThreshold(2100);

        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sponsor_website_button:
                int realPosition = infiniteAdapter.getRealPosition(itemPicker.getCurrentItem());
                Sponsor current = sponsorData.get(realPosition);

                CustomTabsIntent customTabsIntent = new CustomTabsIntent.Builder()
                        .addDefaultShareMenuItem()
                        .setToolbarColor(ContextCompat.getColor(rootView.getContext(), R.color.colorPrimary))
                        .setShowTitle(true)
//                        .setCloseButtonIcon(backArrow)
                        .build();

                CustomTabsHelper.addKeepAliveExtra(rootView.getContext(), customTabsIntent.intent);

                CustomTabsHelper.openCustomTab(rootView.getContext(), customTabsIntent,
                        Uri.parse(current.getSponsorWebsite()),
                        new WebViewFallback());
                break;
            case R.id.previous_sponsor_button:
                realPosition = infiniteAdapter.getRealPosition(itemPicker.getCurrentItem());
                current = sponsorData.get(realPosition);
                smoothScrollToPreviousPosition(itemPicker, realPosition);
                break;
            case R.id.next_sponsor_button:
                realPosition = infiniteAdapter.getRealPosition(itemPicker.getCurrentItem());
                current = sponsorData.get(realPosition);
                smoothScrollToNextPosition(itemPicker, realPosition);
                break;
            default:
                break;
        }
    }

    private void onItemChanged(Sponsor sponsor) {
        currentSponsorName.setText(sponsor.getSponsorName());
        currentSponsorType.setText(sponsor.getSponsorType());
    }

    @Override
    public void onCurrentItemChanged(@Nullable RecyclerView.ViewHolder viewHolder, int adapterPosition) {
        int positionInDataSet = infiniteAdapter.getRealPosition(adapterPosition);
        onItemChanged(sponsorData.get(positionInDataSet));
    }

}


     /*   @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            rootView = inflater.inflate(R.layout.activity_sponsors, container, false);

            sponsorData = Arrays.asList(
                    new Sponsor("TECHGIG", "Platform Sponsor", "https://www.techgig.com/", R.drawable.dsc_logo),
                    new Sponsor("balsamiq", "Sponsor", "https://balsamiq.com/", R.drawable.dsc_logo),
                    new Sponsor("Google Developers", "Sponsor", "https://developers.google.com/", R.drawable.dsc_logo),
                    new Sponsor("GitLab", "Sponsor", "https://gitlab.com/", R.drawable.dsc_logo));

            currentSponsorName = (TextView) rootView.findViewById(R.id.sponsor_name);
            currentSponsorType = (TextView) rootView.findViewById(R.id.sponsor_type);
            previousSponsorButton = (ImageView) rootView.findViewById(R.id.previous_sponsor_button);
            nextSponsorButton = (ImageView) rootView.findViewById(R.id.next_sponsor_button);
            websiteButton = (FloatingActionButton) rootView.findViewById(R.id.sponsor_website_button);

            itemPicker = (DiscreteScrollView) rootView.findViewById(R.id.item_picker);
            itemPicker.setOrientation(Orientation.HORIZONTAL);
            itemPicker.addOnItemChangedListener(this);
            infiniteAdapter = InfiniteScrollAdapter.wrap(new SponsorAdapter(sponsorData));
            itemPicker.setAdapter(infiniteAdapter);
            itemPicker.setItemTransitionTimeMillis(150);
            itemPicker.setItemTransformer(new ScaleTransformer.Builder()
                    .setMinScale(0.8f)
                    .build());

            onItemChanged(sponsorData.get(0));

            rootView.findViewById(R.id.sponsor_name).setOnClickListener(this);
            rootView.findViewById(R.id.sponsor_type).setOnClickListener(this);
            rootView.findViewById(R.id.previous_sponsor_button).setOnClickListener(this);
            rootView.findViewById(R.id.next_sponsor_button).setOnClickListener(this);
            rootView.findViewById(R.id.sponsor_website_button).setOnClickListener(this);

            itemPicker.setSlideOnFling(true);
            itemPicker.setSlideOnFlingThreshold(2100);

            return rootView;
        }
/*
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.sponsor_website_button:
                    int realPosition = infiniteAdapter.getRealPosition(itemPicker.getCurrentItem());
                    Sponsor current = sponsorData.get(realPosition);

                    CustomTabsIntent customTabsIntent = new CustomTabsIntent.Builder()
                            .addDefaultShareMenuItem()
                            .setToolbarColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary))
                            .setShowTitle(true)
//                        .setCloseButtonIcon(backArrow)
                            .build();

                    CustomTabsHelper.addKeepAliveExtra(getApplicationContext(), customTabsIntent.intent);

                    CustomTabsHelper.openCustomTab(getApplicationContext(), customTabsIntent,
                            Uri.parse(current.getSponsorWebsite()),
                            new WebViewFallback());
                    break;
                case R.id.previous_sponsor_button:
                    realPosition = infiniteAdapter.getRealPosition(itemPicker.getCurrentItem());
                    current = sponsorData.get(realPosition);
                    smoothScrollToPreviousPosition(itemPicker, realPosition);
                    break;
                case R.id.next_sponsor_button:
                    realPosition = infiniteAdapter.getRealPosition(itemPicker.getCurrentItem());
                    current = sponsorData.get(realPosition);
                    smoothScrollToNextPosition(itemPicker, realPosition);
                    break;
                default:
                    break;
            }
        }

        private void onItemChanged(Sponsor sponsor) {
            currentSponsorName.setText(sponsor.getSponsorName());
            currentSponsorType.setText(sponsor.getSponsorType());
        }

        @Override
        public void onCurrentItemChanged(@Nullable RecyclerView.ViewHolder viewHolder, int adapterPosition) {
            int positionInDataSet = infiniteAdapter.getRealPosition(adapterPosition);
            onItemChanged(sponsorData.get(positionInDataSet));
        }

    }
*/