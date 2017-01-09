package com.paresh.exodia.EventsType;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

import com.paresh.exodia.CulturalEvents.BandSlam;
import com.paresh.exodia.CulturalEvents.BigStink;
import com.paresh.exodia.CulturalEvents.Canvas;
import com.paresh.exodia.CulturalEvents.ExodiaIdol;
import com.paresh.exodia.CulturalEvents.GrooveFanatics;
import com.paresh.exodia.CulturalEvents.Synchronians;
import com.paresh.exodia.Events;
import com.paresh.exodia.FashionEvents.Couture;
import com.paresh.exodia.FashionEvents.MrMrsExodia;
import com.paresh.exodia.Main_Home;
import com.paresh.exodia.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fashion_Events extends Fragment {

    private ImageButton coutureib,mrMrsExodia;

    public Fashion_Events() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fashion_events = inflater.inflate(R.layout.fragment_fashion__events, container, false);
        coutureib = (ImageButton)fashion_events.findViewById(R.id.event_fashion_couture);
        mrMrsExodia =(ImageButton)fashion_events.findViewById(R.id.event_fashion_MrMrsExodia);

        animation();
        open_events();

        return fashion_events;
    }

    private void open_events() {
        coutureib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new Couture();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.content_frame,fragment);
                ft.commit();
            }
        });
        mrMrsExodia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new MrMrsExodia();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.content_frame,fragment);
                ft.commit();
            }
        });
    }

    private void animation() {
        Animation pop_out = AnimationUtils.loadAnimation(getActivity(), R.anim.pop_out);
        Animation pop_out_1 = AnimationUtils.loadAnimation(getActivity(), R.anim.pop_out_1);
        Animation pop_out_2 = AnimationUtils.loadAnimation(getActivity(), R.anim.pop_out_2);
        Animation pop_out_3 = AnimationUtils.loadAnimation(getActivity(), R.anim.pop_out_3);

        coutureib.setAnimation(pop_out);
        mrMrsExodia.setAnimation(pop_out_1);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
