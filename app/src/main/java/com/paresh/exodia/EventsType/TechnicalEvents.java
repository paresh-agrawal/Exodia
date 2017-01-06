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


import com.paresh.exodia.Events;
import com.paresh.exodia.Main_Home;
import com.paresh.exodia.R;
import com.paresh.exodia.TechnicalEvents.Iot;
import com.paresh.exodia.TechnicalEvents.JunkyardWars;
import com.paresh.exodia.TechnicalEvents.LaserTag;
import com.paresh.exodia.TechnicalEvents.LineFollower;
import com.paresh.exodia.TechnicalEvents.Nirman;
import com.paresh.exodia.TechnicalEvents.RoboWars;

/**
 * A simple {@link Fragment} subclass.
 */
public class TechnicalEvents extends Fragment {


    private ImageButton lineFollowerib, iotib, roboWarsib, junkyardWarsib, laserTagib, nirmanib;

    public TechnicalEvents() {
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
        View tech_events = inflater.inflate(R.layout.fragment_technical_events, container, false);
        ((Main_Home) getActivity())
                .setActionBarTitle("Technical Events");
        lineFollowerib = (ImageButton) tech_events.findViewById(R.id.event_tech_lineFollower);
        iotib = (ImageButton) tech_events.findViewById(R.id.event_tech_iot);
        roboWarsib = (ImageButton) tech_events.findViewById(R.id.event_tech_roboWars);
        junkyardWarsib = (ImageButton) tech_events.findViewById(R.id.event_tech_junkyardWars);
        laserTagib = (ImageButton) tech_events.findViewById(R.id.event_tech_laserTag);
        nirmanib = (ImageButton) tech_events.findViewById(R.id.event_tech_nirman);

        animation();
        open_events();

        return tech_events;
    }

    private void open_events() {
        lineFollowerib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new LineFollower();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.content_frame,fragment);
                ft.commit();
            }
        });
        iotib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new Iot();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.content_frame,fragment);
                ft.commit();
            }
        });
        roboWarsib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new RoboWars();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.content_frame,fragment);
                ft.commit();
            }
        });
        junkyardWarsib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new JunkyardWars();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.content_frame,fragment);
                ft.commit();
            }
        });
        laserTagib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new LaserTag();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.content_frame,fragment);
                ft.commit();
            }
        });
        nirmanib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new Nirman();
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
        Animation pop_out_4 = AnimationUtils.loadAnimation(getActivity(), R.anim.pop_out_4);
        Animation pop_out_5 = AnimationUtils.loadAnimation(getActivity(), R.anim.pop_out_5);

        lineFollowerib.setAnimation(pop_out);
        iotib.setAnimation(pop_out_1);
        roboWarsib.setAnimation(pop_out_2);
        junkyardWarsib.setAnimation(pop_out_3);
        laserTagib.setAnimation(pop_out_4);
        nirmanib.setAnimation(pop_out_5);
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
