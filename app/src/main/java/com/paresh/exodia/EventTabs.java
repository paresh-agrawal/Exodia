package com.paresh.exodia;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.paresh.exodia.EventsType.Cultural_Events;
import com.paresh.exodia.EventsType.Fashion_Events;
import com.paresh.exodia.EventsType.TechnicalEvents;
import com.paresh.exodia.Schedule_Package.Schedule;
import com.paresh.exodia.Schedule_Package.Schedule_Day1;
import com.paresh.exodia.Schedule_Package.Schedule_Day2;
import com.paresh.exodia.Schedule_Package.Schedule_Day3;

import static android.content.Intent.getIntent;
import static android.content.Intent.getIntentOld;


/**
 * A simple {@link Fragment} subclass.
 */
public class EventTabs extends Fragment {


    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int a;

    public EventTabs() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ((Main_Home) getActivity())
                .setActionBarTitle("Events");
        View EventTabs = inflater.inflate(R.layout.fragment_event_tabs, container, false);

        // Inflate the layout for this fragment
        viewPager = (ViewPager)EventTabs.findViewById(R.id.viewpager);
        //viewPager.setAdapter(new Pager(getActivity().getSupportFragmentManager(),tabLayout.getTabCount()));
        tabLayout= (TabLayout)EventTabs.findViewById(R.id.tablayout);

        LinearLayout linearLayout = (LinearLayout)tabLayout.getChildAt(0);
        linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        GradientDrawable drawable = new GradientDrawable();
        drawable.setColor(Color.GRAY);
        drawable.setSize(1, 1);
        linearLayout.setDividerPadding(30);
        linearLayout.setDividerDrawable(drawable);

        //Adding the tabs using addTab() method
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        Pager adapter = new Pager(getActivity().getSupportFragmentManager(), tabLayout.getTabCount());

        //Adding adapter to pager
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        getInt();

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                //tabLayout.setVisibility(View.GONE);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                // tabLayout.setVisibility(View.VISIBLE);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // tabLayout.setVisibility(View.VISIBLE);
            }
        });
        return EventTabs;
    }

    private void getInt() {
        a=((Main_Home)getActivity()).b;
        viewPager.setCurrentItem(a);
    }

    public class Pager extends FragmentStatePagerAdapter {
        private String fragments[]={"Technical","Cultural","Fashion"};
        //integer to count number of tabs
        int tabCount;

        //Constructor to the class
        public Pager(FragmentManager fm, int tabCount) {
            super(fm);
            //Initializing tab count
            this.tabCount= tabCount;
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return fragments[position];
        }
        //Overriding method getItem
        @Override
        public Fragment getItem(int position) {
            //Returning the current tabs
            switch (position) {
                case 0:
                    TechnicalEvents tab1 = new TechnicalEvents();
                    return tab1;
                case 1:
                    Cultural_Events tab2 = new Cultural_Events();
                    return tab2;
                case 2:
                    Fashion_Events tab3 = new Fashion_Events();
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

}
