package com.paresh.exodia.Schedule_Package;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.paresh.exodia.DividerItemDecoration;
import com.paresh.exodia.Home;
import com.paresh.exodia.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Schedule_Day2 extends Fragment {

    private List<Schedule_Recycler> list = new ArrayList<>();
    private RecyclerView recyclerView;
    private ScheduleAdapter mAdapter;
    private int c=0;

    public Schedule_Day2() {
        // Required empty public constructor
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View scheduleDay2 = inflater.inflate(R.layout.fragment_schedule__day2, container, false);
        recyclerView = (RecyclerView) scheduleDay2.findViewById(R.id.recycler_view_day2);

        mAdapter = new ScheduleAdapter(list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);

        if(c==0) {
            list_creater();
            c++;
        }
        return scheduleDay2;
    }

    private void list_creater() {
        prepareScheduleData("acb","adas","2014");
        prepareScheduleData("acb","adas","2014");
        prepareScheduleData("acb","adas","2014");
    }

    private void prepareScheduleData(String a,String b, String c) {
        Schedule_Recycler schedule_day2_list = new Schedule_Recycler(a, b, c);
        list.add(schedule_day2_list);
    }
    //onBackKeyPress
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
                    Fragment fragment = new Home();
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.content_frame, fragment);
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