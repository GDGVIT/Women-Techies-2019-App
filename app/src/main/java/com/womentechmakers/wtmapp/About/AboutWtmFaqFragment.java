package com.womentechmakers.wtmapp.About;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.womentechmakers.wtmapp.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class AboutWtmFaqFragment extends Fragment {

    private View rootView;
    RecyclerView faqRecyclerView;
    ArrayList<FAQ> faqList;

    public AboutWtmFaqFragment() {
    }

    public static AboutWtmFaqFragment newInstance() {
        return new AboutWtmFaqFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_about_wtm_faq, container,false);

        faqList = new ArrayList<>();

        faqList.add(new FAQ("Is there any registration fees for the Hackathon?"," No. You do not have to pay anything to anyone to register yourself for the Hackathon."));
        faqList.add(new FAQ("Do I need to have any specific qualifications to be a participant for the Hackathon?"," If you love to code, you are more than welcome to participate in the Hackathon."));
        faqList.add(new FAQ("How do I submit what I have made for the Hackathon? "," You have to develop the application on your local system and submit it on HackerEarth in tar/zip file format along with instructions to run the application and source code."));
        faqList.add(new FAQ("Do we need to have the entire idea fully working? "," The entire idea need not be fully implemented however, the submission should be functional so that it can be reviewed by the judges"));
        faqList.add(new FAQ("How is the environment? Will your environment support any language? Will you provide any IDE and DB for us to work on ideas?"," You have to develop the entire software application on your local system and submit it on HackerEarth in tar/zip file format along with instructions to run the application and source code."));
        faqList.add(new FAQ("Does one have to be online and available for the entire duration of the Hackathon?"," No, one does not need to be logged in on HackerEarth or be online for the entire duration. You can develop the application on your local system based on the given themes and then submit it on HackerEarth, on the specific challenge page."));
        faqList.add(new FAQ("Since there is no specific technology mentioned, are there any restrictions on using number of pre-built libraries?"," There is no restriction to use any language, technology stack, or libraries. You can use any of them to create the web/mobile application."));
        faqList.add(new FAQ("Do I need to give a demo for the product that I have built?"," If you want you can submit a small presentation or video that demos your submission, however it's not mandatory, and only good to have. In case you are one of the winners, you might be invited to demo your application at a physical event, details of which will be shared with sufficient advance notice."));
        faqList.add(new FAQ("A fully developed application need to have a solid backend for data storage like SQL, SharePoint etc. since its online, is it accepted to show only the proto type of it?"," Yes it's absolutely fine to submit just the prototype. If you use any database like MySQL or PostgresSQL you can also submit a database dump along with your submission. However you are allowed to submit just the prototype."));
        faqList.add(new FAQ("If it is a team submission, does that mean all team members will have access to work at the same time?"," Yes, all team members can login from their account and do application submission on HackerEarth."));
        faqList.add(new FAQ("Who will own the IP (Intellectual Property) Rights to the product that I have built?"," The developer/developers of the web/mobile application will have all rights and own the IP of the product. However, all code needs to be in public domain (open source) so that it can be evaluated by the judges."));
        faqList.add(new FAQ("Is this a women - centric hackathon?"," No, this is not a women - only hackathon. For a team to be eligible to participate, there is a requirement of 50% of the members to be girls.."));

        faqRecyclerView = rootView.findViewById(R.id.wtm_faq_recyclerview);
        faqRecyclerView.setHasFixedSize(true);
        faqRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        ((SimpleItemAnimator) faqRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        faqRecyclerView.setAdapter(new AboutWtmFaqAdapter(faqList));

        return rootView;
    }
}
