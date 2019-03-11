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

public class AboutDscFaqFragment extends Fragment {

    private View rootView;
    RecyclerView faqRecyclerView;
    ArrayList<FAQ> faqList;

    public AboutDscFaqFragment() {
    }

    public static AboutDscFaqFragment newInstance() {
        return new AboutDscFaqFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_about_dsc_faq, container,false);

        faqList = new ArrayList<>();

        faqList.add(new FAQ("When is the event?", "The event will commence at 7 PM on 28th October."));
        faqList.add(new FAQ("Where is the event taking place?", "Venue details will be up soon," +
                " they will also be forwarded to all participants via mail and SMS on their" +
                " registered mobile numbers."));
        faqList.add(new FAQ("Who can participate in the event?", "Only freshers can participate in" +
                " the Ideathon. The Hackathon is open to all, however, a participant can only" +
                " participate in one of those two events."));
        faqList.add(new FAQ("Can I switch between events?", "Yes you can, but only until 12 AM." +
                " You are allowed to switch only once. You can’t go back after switching, so be" +
                " mindful of that fact."));
        faqList.add(new FAQ("What do equipment I need to carry to the Ideathon?", "The participants" +
                " are expected to carry their laptops and chargers to the event along with any " +
                "other equipment you may require."));
        faqList.add(new FAQ("Are there any rules?", "Adhere to our Code of Conduct and Rules and" +
                " Regulations while you participate in the event."));
        faqList.add(new FAQ("Do I need a team?", "Yes, you would be working in a team of minimum " +
                "2 members and maximum 3 members."));
        faqList.add(new FAQ("What are problem statements?", "Problem statements are a description " +
                "of the issues you will be working on. Multiple problem statements will be given " +
                "across domains, and your team can choose to work on any one of them."));
        faqList.add(new FAQ("What do I do once the problem statements are handed out?", "You have" +
                " to brainstorm with your team and come up with an idea and present it to your " +
                "mentors. They will visit you to hear out your idea and plan of action. They will " +
                "also provide you with suggestions for further course of action."));
        faqList.add(new FAQ("How many ideas do I have to work on?", "You can brainstorm across" +
                " multiple domains, but your final idea and its corresponding model should " +
                "correspond to only one domain."));
        faqList.add(new FAQ("What happens once we finalize our idea?", "Start working on making" +
                " a model for your idea. Coding is not required, but is accepted nonetheless. " +
                "Mentors will assist you with your implementation, clarify your doubts as well as " +
                "point out the potential mistakes you might make. They’re there to help, so don’t" +
                " be shy about asking your doubts."));
        faqList.add(new FAQ("What will a model of an idea comprise of?", "You would be required " +
                "to work on building a complete model, including the management and technical " +
                "aspects of the problem.\n" +
                "The management part would include the description of your solution, resources," +
                " optimization, among others. The technical part would describe the approach, " +
                "technology used and the like.\n"));
        faqList.add(new FAQ("What are the Judging parameters?", "A team comprising of GDG members" +
                " will evaluate your performance according to the criteria mentioned in the Rules" +
                " of Ideathon and then declare the results. The top teams would be selected to " +
                "pitch their idea the next evening in front of a panel of judges who will decide " +
                "the eventual winner."));
        faqList.add(new FAQ("Help", "If you need any assistance you can write to us at " +
                "gdgvitvellore@gmail.com or approach any of our coordinators present during the" +
                " event. All the best, and happy brainstorming!"));


        faqList.add(new FAQ("When is the event taking place?", "The event will commence at 7 PM" +
                " on 28th October."));
        faqList.add(new FAQ("Where is the event taking place?", "Venue details will be up soon, " +
                "they will also be forwarded to all participants via mail and SMS on their " +
                "registered mobile numbers."));
        faqList.add(new FAQ("Who can participate in the event?", "Only freshers can participate" +
                " in the Ideathon. The Hackathon is open to all, however, a participant can only" +
                " participate in one of those two events."));
        faqList.add(new FAQ("Can I switch between events?", "Yes you can, but only until 12 AM." +
                " You are allowed to switch only once. You can’t go back after switching, so be " +
                "mindful of that fact."));
        faqList.add(new FAQ("What do equipment I need to carry to the Hackathon?", "The " +
                "participants are expected to carry their laptops and chargers to the event along" +
                " with any other equipment you may require."));
        faqList.add(new FAQ("Are there any rules?", "Adhere to our Code of Conduct and Rules and" +
                " Regulations while you participate in the event."));
        faqList.add(new FAQ("Do I need a team?", "Yes, you would be working in a team of minimum 2" +
                " members and maximum 3 members."));
        faqList.add(new FAQ("What are problem statements?", "Problem statements are a description" +
                " of the issues you will be working on. Multiple problem statements will be given" +
                " across domains, and you can choose to work on any one of them."));
        faqList.add(new FAQ("How do I start working on my problem?", "Understand what the problem " +
                "requires of you. Work with your team to come up with a plan to solve it. You may " +
                "ask our coordinators present for help, and they will assist you the best they can."));
        faqList.add(new FAQ("Will I be provided with food?", "We will be serving dinner," +
                " snacks as well as breakfast during the event."));
        faqList.add(new FAQ("What do I need for the final pitch?", "You will need to make a " +
                "presentation as well as a demo of what you worked on."));
        faqList.add(new FAQ("What are the Judging parameters?", "A judging panel will evaluate" +
                " your performance according to the criteria mentioned in the Rules of Hackathon " +
                "then declare the results."));
        faqList.add(new FAQ("Help", "If you need any assistance you can write to us at " +
                "gdgvitvellore@gmail.com or approach any of our coordinators present during the " +
                "event. All the best, and happy hacking!"));


        faqRecyclerView = rootView.findViewById(R.id.faq_recyclerview);
        faqRecyclerView.setHasFixedSize(true);
        faqRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        ((SimpleItemAnimator) faqRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        faqRecyclerView.setAdapter(new AboutDscFaqAdapter(faqList));

        return rootView;
    }
}
