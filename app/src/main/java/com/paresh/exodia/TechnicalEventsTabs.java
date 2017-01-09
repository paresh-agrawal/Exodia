package com.paresh.exodia;


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

import com.paresh.exodia.TechnicalEvents.Iot;
import com.paresh.exodia.TechnicalEvents.JunkyardWars;
import com.paresh.exodia.TechnicalEvents.LaserTag;
import com.paresh.exodia.TechnicalEvents.LineFollower;
import com.paresh.exodia.TechnicalEvents.Nirman;
import com.paresh.exodia.TechnicalEvents.RoboWars;


/**
 * A simple {@link Fragment} subclass.
 */
public class TechnicalEventsTabs extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int a;

    public TechnicalEventsTabs() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ((Main_Home) getActivity())
                .setActionBarTitle("Technical Events");
        View technicalEventTabs = inflater.inflate(R.layout.fragment_technical_events_tabs, container, false);

        // Inflate the layout for this fragment
        viewPager = (ViewPager)technicalEventTabs.findViewById(R.id.viewpager);
        //viewPager.setAdapter(new Pager(getActivity().getSupportFragmentManager(),tabLayout.getTabCount()));
        tabLayout= (TabLayout)technicalEventTabs.findViewById(R.id.tablayout);

        //Adding the tabs using addTab() method
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
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
        return technicalEventTabs;
    }

    private void getInt() {
        a=((Main_Home)getActivity()).b;
        viewPager.setCurrentItem(a);
    }

    public class Pager extends FragmentStatePagerAdapter {
        private String fragments[]={"Line Follower","IOT","Robowars","Junkyard Wars","Lase Tag","Nirman"};
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
                    LineFollower tab1 = new LineFollower();
                    return tab1;
                case 1:
                    Iot tab2 = new Iot();
                    return tab2;
                case 2:
                    RoboWars tab3 = new RoboWars();
                    return tab3;
                case 3:
                    JunkyardWars tab4 = new JunkyardWars();
                    return tab4;
                case 4:
                    LaserTag tab5 = new LaserTag();
                    return tab5;
                case 5:
                    Nirman tab6 = new Nirman();
                    return tab6;
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
                    Fragment fragment = new EventTabs();
                    ((Main_Home)getActivity()).setInt(0);
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
