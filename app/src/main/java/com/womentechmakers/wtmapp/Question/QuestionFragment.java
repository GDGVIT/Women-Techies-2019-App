package com.womentechmakers.wtmapp.Question;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.ValueEventListener;
import com.womentechmakers.wtmapp.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class QuestionFragment extends Fragment {

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mMessagesDatabaseReference;
    View rootView;
    private QuestionAdapter mQuestionAdapter;
    private RecyclerView questionRecyclerView;
    private ArrayList<Question> question_list = new ArrayList<Question>();
    private RecyclerView.LayoutManager questionLayoutManager;
    Dialog lableDialog;
    Button lableConfirmButton;
    Button lableCancelButton;
    EditText newQuestion;

    FirebaseUser user;
    private FirebaseAuth mAuth;
    String mail;
    String status;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_question, container, false);

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mMessagesDatabaseReference = mFirebaseDatabase.getReference().child("questions");
        questionRecyclerView = rootView.findViewById(R.id.rv_question);
        questionLayoutManager = new LinearLayoutManager(getActivity());
        mQuestionAdapter = new QuestionAdapter(question_list);
        questionRecyclerView.setLayoutManager(questionLayoutManager);
        questionRecyclerView.setAdapter(mQuestionAdapter);

    //    mAuth = FirebaseAuth.getInstance();
       // user = mAuth.getCurrentUser();
//        mail = user.getDisplayName();


        mMessagesDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                question_list.clear();
                HashMap<String, String>  map = (HashMap<String, String>) dataSnapshot.getValue();
                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    HashMap<String, String> childMap = (HashMap<String, String>) data.getValue();
                    int x = 0;

                    for (String value : childMap.values()) {
                        question_list.add(new Question(value));
                    }
                    mQuestionAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

//        mMessagesDatabaseReference.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//                question_list.clear();
//                for(DataSnapshot data : dataSnapshot.getChildren()) {
//                    String question = data.getValue().toString();
//                    question_list.add(new Question(question));
//                    mQuestionAdapter.notifyDataSetChanged();
//                }
//            }
//
//            @Override
//            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//                for(DataSnapshot data : dataSnapshot.getChildren()) {
//                    String question = data.getValue().toString();
//                    question_list.add(new Question(question));
//                    mQuestionAdapter.notifyDataSetChanged();
//                }
//
//            }
//
//            @Override
//            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });

        FloatingActionButton fab = rootView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lableDialog = new Dialog(getActivity());
                lableDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                lableDialog.setContentView(R.layout.layout_dialog_box);
                lableDialog.show();

                lableConfirmButton = lableDialog.findViewById(R.id.lable_confirm_button);
                lableCancelButton = lableDialog.findViewById(R.id.lable_cancel_button);
                newQuestion = lableDialog.findViewById(R.id.edit_text_new_question);

                lableConfirmButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        try {
                            mAuth = FirebaseAuth.getInstance();
                            user = mAuth.getCurrentUser();
                            mail = user.getDisplayName();
                            status =  "1";
                        }catch (Exception e){
                            status = "0" ;
                            Toast.makeText(getContext(), "You have to log in to post questions", Toast.LENGTH_SHORT).show();
                            lableDialog.cancel();
                        }
                        if (status.equals("0")) {
                            Toast.makeText(getContext(), "You have to log in to post questions", Toast.LENGTH_SHORT).show();
                            lableDialog.cancel();
                        } else {
                            String question = newQuestion.getText().toString();
                            if(question.isEmpty()){
                                Toast.makeText(getContext(), "Enter text", Toast.LENGTH_SHORT).show();
                            } else {
                                mMessagesDatabaseReference.push().child(mail).setValue(question)
                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void aVoid) {
                                                Toast.makeText(getContext(), "Successful", Toast.LENGTH_SHORT).show();
                                                lableDialog.cancel();


                                            }
                                        })
                                        .addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                Toast.makeText(getContext(), "Not inserted", Toast.LENGTH_SHORT).show();
                                                lableDialog.cancel();
                                            }
                                        });
                            }
                        }
                    }
                });

                lableCancelButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        lableDialog.cancel();
                    }
                });

            }
        });


        return rootView;
    }

    public QuestionFragment() {
    }

    public static QuestionFragment newInstance() {
        return new QuestionFragment();
    }


}
