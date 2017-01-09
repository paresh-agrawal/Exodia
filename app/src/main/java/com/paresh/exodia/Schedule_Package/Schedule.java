package com.paresh.exodia.Schedule_Package;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.paresh.exodia.Home;
import com.paresh.exodia.Main_Home;
import com.paresh.exodia.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Schedule extends Fragment implements TabLayout.OnTabSelectedListener {


    private TabLayout tabLayout;

    private ViewPager viewPager;

    public Schedule() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View schedule = inflater.inflate(R.layout.fragment_schedule, container, false);
        ((Main_Home) getActivity()).setActionBarTitle("Schedule");

        tabLayout = (TabLayout) schedule.findViewById(R.id.tabLayout);

        //Adding the tabs using addTab() method
        tabLayout.addTab(tabLayout.newTab().setText("Day 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Day 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Day 3"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //Initializing viewPager
        viewPager = (ViewPager) schedule.findViewById(R.id.pager);

        //Creating our pager adapter
        Schedule.Pager adapter = new Schedule.Pager(getActivity().getSupportFragmentManager(), tabLayout.getTabCount());

        //Adding adapter to pager
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        //Adding onTabSelectedListener to swipe views
        tabLayout.setOnTabSelectedListener(this);
        return schedule;
    }
    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
        viewPager.getCurrentItem();
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

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
                    Fragment fragment = new Home();
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

    public class Pager extends FragmentStatePagerAdapter {

        //integer to count number of tabs
        int tabCount;

        //Constructor to the class
        public Pager(FragmentManager fm, int tabCount) {
            super(fm);
            //Initializing tab count
            this.tabCount= tabCount;
        }

        //Overriding method getItem
        @Override
        public Fragment getItem(int position) {
            //Returning the current tabs
            switch (position) {
                case 0:
                    Schedule_Day1 tab1 = new Schedule_Day1();
                    return tab1;
                case 1:
                    Schedule_Day2 tab2 = new Schedule_Day2();
                    return tab2;
                case 2:
                    Schedule_Day3 tab3 = new Schedule_Day3();
                    return tab3;
                default:
                    return null;
            }
        }

        //Overriden method getCount to get the number of tabs
        @Override
        public int getCount() {

            return tabCount;
        }
    }
}

