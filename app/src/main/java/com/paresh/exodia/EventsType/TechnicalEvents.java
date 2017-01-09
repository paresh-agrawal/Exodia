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
import com.paresh.exodia.TechnicalEventsTabs;

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
        lineFollowerib = (ImageButton) tech_events.findViewById(R.id.event_tech_lineFollower);
        iotib = (ImageButton) tech_events.findViewById(R.id.event_tech_iot);
        roboWarsib = (ImageButton) tech_events.findViewById(R.id.event_tech_roboWars);
        junkyardWarsib = (ImageButton) tech_events.findViewById(R.id.event_tech_junkyardWars);
        laserTagib = (ImageButton) tech_events.findViewById(R.id.event_tech_laserTag);
        nirmanib = (ImageButton) tech_events.findViewById(R.id.event_tech_nirman);

        animation();
        setInt();

        return tech_events;
    }

    private void setInt() {
        lineFollowerib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Main_Home)getActivity()).setInt(0);
                openEventTab();
            }
        });
        iotib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Main_Home)getActivity()).setInt(1);
                openEventTab();
            }
        });
        roboWarsib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Main_Home)getActivity()).setInt(2);
                openEventTab();
            }
        });
        junkyardWarsib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Main_Home)getActivity()).setInt(3);
                openEventTab();
            }
        });
        laserTagib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Main_Home)getActivity()).setInt(4);
                openEventTab();
            }
        });
        nirmanib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Main_Home)getActivity()).setInt(5);
                openEventTab();
            }
        });
    }
    private void openEventTab() {
        Fragment fragment = new TechnicalEventsTabs();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame,fragment);
        ft.commit();
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
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
