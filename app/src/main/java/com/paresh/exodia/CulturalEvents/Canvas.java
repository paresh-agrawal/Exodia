package com.paresh.exodia.CulturalEvents;


import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.google.firebase.database.DatabaseReference;
import com.paresh.exodia.EventsType.Cultural_Events;
import com.paresh.exodia.EventsType.TechnicalEvents;
import com.paresh.exodia.Main_Home;
import com.paresh.exodia.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Canvas extends Fragment {

    private Firebase myFirebaseRef;
    public String value,value_taken;
    private TextView round1,call_canvas_vishnu,call_canvas_abhijeet;
    private SharedPreferences sharedprefs, shared;
    private SharedPreferences.Editor editor;
    private DatabaseReference mDatabase;
    private CardView schedule,prize,description,contacts;

    public Canvas() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View Canvas = inflater.inflate(R.layout.fragment_canvas, container, false);

        ((Main_Home) getActivity()).setActionBarTitle("Canvas");

        schedule = (CardView)Canvas.findViewById(R.id.schedule);
        prize = (CardView)Canvas.findViewById(R.id.prize);
        description = (CardView)Canvas.findViewById(R.id.description);
        contacts = (CardView)Canvas.findViewById(R.id.contacts);
        call_canvas_abhijeet=(TextView)Canvas.findViewById(R.id.call_canvas_abhijeet);
        call_canvas_vishnu=(TextView)Canvas.findViewById(R.id.call_canvas_vishnu);
        round1 = (TextView)Canvas.findViewById(R.id.canvas_round1_schedule_tv);

        loadSchedule();
        call();
        animation();

        return Canvas;
    }

    private void call() {
        call_canvas_abhijeet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+919234567385")));
            }
        });
        call_canvas_vishnu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+919234567385")));
            }
        });
    }

    private void loadSchedule() {
        myFirebaseRef = new Firebase("https://exodia-1002f.firebaseio.com/Schdule/CulturalEvents/Canvas");
        getDataFromServer();
    }

    private void animation() {
        Animation pop_out = AnimationUtils.loadAnimation(getActivity(), R.anim.pop_out);
        Animation pop_out_1 = AnimationUtils.loadAnimation(getActivity(), R.anim.pop_out_1);
        Animation pop_out_2 = AnimationUtils.loadAnimation(getActivity(), R.anim.pop_out_2);
        Animation pop_out_3 = AnimationUtils.loadAnimation(getActivity(), R.anim.pop_out_3);

        schedule.setAnimation(pop_out);
        prize.setAnimation(pop_out_1);
        description.setAnimation(pop_out_2);
        contacts.setAnimation(pop_out_3);
    }

    private void getDataFromServer() {
        myFirebaseRef.addValueEventListener(new com.firebase.client.ValueEventListener() {
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {
                
                System.out.println(dataSnapshot.getValue());
                value = (String)dataSnapshot.getValue();
                Log.d("abc",value);
                round1.setText(value);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();

        if (getView() == null) {
            return;
        }

        getView().setFocusableInTouchMode(true);
        getView().requestFocus();
        getView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                DrawerLayout drawer = (DrawerLayout)getActivity().findViewById(R.id.drawer_layout);
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                    return true;
                }
                else if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK) {
                    Fragment fragment = new Cultural_Events();
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.content_frame, fragment);
                    ft.commit();
                    return true;
                }
                return false;
            }
        });

    }
}
