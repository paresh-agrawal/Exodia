package com.paresh.exodia;


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

import com.paresh.exodia.CulturalEvents.BigStink;
import com.paresh.exodia.CulturalEvents.Canvas;


/**
 * A simple {@link Fragment} subclass.
 */
public class Cultural_Events extends Fragment {

    boolean click = false;
    View cult_events;
    private ImageButton canvasib,bStinkib,bSlamib,syncib;


    public Cultural_Events() {
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
        View events = inflater.inflate(R.layout.fragment_cultural__events, container, false);
        ((Main_Home) getActivity())
                .setActionBarTitle("Cultural Events");
        canvasib = (ImageButton) events.findViewById(R.id.event_cult_canvas);
        bStinkib = (ImageButton) events.findViewById(R.id.event_cult_bigStink);
        bSlamib = (ImageButton) events.findViewById(R.id.event_cult_exodiaIdol);
        syncib = (ImageButton) events.findViewById(R.id.event_cult_synchronians);

        animation();

        canvasib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new Canvas();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.content_frame,fragment);
                ft.commit();
            }
        });
        bStinkib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new BigStink();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.content_frame,fragment);
                ft.commit();
            }
        });
        return events;
    }

    private void animation() {
        Animation pop_out = AnimationUtils.loadAnimation(getActivity(), R.anim.pop_out);
        Animation pop_out_1 = AnimationUtils.loadAnimation(getActivity(), R.anim.pop_out_1);
        Animation pop_out_2 = AnimationUtils.loadAnimation(getActivity(), R.anim.pop_out_2);
        Animation pop_out_3 = AnimationUtils.loadAnimation(getActivity(), R.anim.pop_out_3);

        canvasib.setAnimation(pop_out);
        bStinkib.setAnimation(pop_out_1);
        bSlamib.setAnimation(pop_out_2);
        syncib.setAnimation(pop_out_3);
    }

    @Override
    public void onResume() {
        super.onResume();

        if(getView() == null){
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
                else if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK){
                    Fragment fragment = new Events();
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.content_frame,fragment);
                    ft.commit();
                    return true;
                }
                return false;
            }
        });
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
