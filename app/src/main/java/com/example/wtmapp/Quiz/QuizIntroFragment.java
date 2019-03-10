package com.example.wtmapp.Quiz;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wtmapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class QuizIntroFragment extends Fragment {

    TextView quizInstructions;
    Button startQuiz;
    RelativeLayout placeholder;
    RelativeLayout layout_quiz;
    String permission = "0";
    TextView quizStatus;
    FirebaseUser user;
    private FirebaseAuth mAuth;
    String name = null;
    String number_of_attempts = "3";
    View rootView;
    Dialog lableDialog;
    Button lableConfirmButton;
    Button lableCancelButton;

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference refToUser = database.getReference("users");

    public QuizIntroFragment() {
    }

    public static QuizIntroFragment newInstance() {
        return new QuizIntroFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_quiz_intro, container, false);

        quizInstructions = rootView.findViewById(R.id.quiz_instructions);
        quizInstructions.setText("You will have 10 seconds for every " +
                "question\n\n" +
                "You can attempt this quiz only once\n\n" +
                "Wrong answer will end the quiz");

        startQuiz = rootView.findViewById(R.id.btn_start_quiz);
        placeholder = rootView.findViewById(R.id.layout_quiz_placeholder);
        layout_quiz = rootView.findViewById(R.id.layout_quiz);
        quizStatus = rootView.findViewById(R.id.quiz_status);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference enabledRef = database.getReference("quiz").child("quizEnabled");

        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();

        enabledRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                permission = dataSnapshot.getValue().toString();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        startQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (user != null) {
                    name = user.getDisplayName();


                    refToUser.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            try {
                                number_of_attempts = dataSnapshot.child(name).getValue().toString();
                            } catch (Exception e) {
                                number_of_attempts = "0";
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                    if (number_of_attempts.equals("0")) {
                        if (permission.equals("1")) {

                            lableDialog = new Dialog(getActivity());
                            lableDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                            lableDialog.setContentView(R.layout.quiz_dialog_box);
                            lableDialog.show();

                            lableConfirmButton = lableDialog.findViewById(R.id.lable_quiz_confirm_button);
                            lableCancelButton = lableDialog.findViewById(R.id.lable_quiz_cancel_button);

                            lableConfirmButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    startQuiz();
                                }
                            });

                            lableCancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    lableDialog.cancel();
                                }
                            });

                        } else {
                            quizStatus.setVisibility(View.VISIBLE);
                        }
                    } else {
                        Log.d("QuizIntroFragment", "You can only attempt quiz once");
                       // Toast.makeText(getActivity(), "You can only attempt quiz once", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getActivity(), "Log in first to attempt quiz", Toast.LENGTH_SHORT).show();
                }
            }
        });


        return rootView;
    }


    public void startQuiz() {
        startActivity(new Intent(getActivity(), QuizActivity.class));
    }


}
