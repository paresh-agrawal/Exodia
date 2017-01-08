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
public class Schedule_Day1 extends Fragment {

    private List<Schedule_Recycler> list_9 = new ArrayList<>();
    private List<Schedule_Recycler> list_10 = new ArrayList<>();
    private RecyclerView recyclerView_9,recyclerView_10;
    private ScheduleAdapter mAdapter_9,mAdapter_10;
    private int c=0;

    public Schedule_Day1() {
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
        View scheduleDay1 = inflater.inflate(R.layout.fragment_schedule__day1, container, false);
        recyclerView_9 = (RecyclerView) scheduleDay1.findViewById(R.id.recycler_view_day1_9);
        recyclerView_10 = (RecyclerView) scheduleDay1.findViewById(R.id.recycler_view_day1_10);
        mAdapter_9 = new ScheduleAdapter(list_9);
        mAdapter_10 = new ScheduleAdapter(list_10);

        setAdapter();
        if(c==0) {
            list_creater();
            c++;
        }
        return scheduleDay1;
    }

    private void setAdapter() {
        RecyclerView.LayoutManager mLayoutManager_9 = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView_9.setLayoutManager(mLayoutManager_9);
        recyclerView_9.setItemAnimator(new DefaultItemAnimator());
        recyclerView_9.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        recyclerView_9.setAdapter(mAdapter_9);
        RecyclerView.LayoutManager mLayoutManager_10 = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView_10.setLayoutManager(mLayoutManager_10);
        recyclerView_10.setItemAnimator(new DefaultItemAnimator());
        recyclerView_10.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        recyclerView_10.setAdapter(mAdapter_10);

    }

    private void list_creater() {
        prepareScheduleData_9("acb","adas","2015");
        prepareScheduleData_9("acb","adas","2015");
        prepareScheduleData_9("acb","adas","2015");
        prepareScheduleData_10("acb","adas","2015");
        prepareScheduleData_10("acb","adas","2015");
        prepareScheduleData_10("acb","adas","2015");
    }

    private void prepareScheduleData_9(String a, String b, String c) {
        Schedule_Recycler schedule_day1_list = new Schedule_Recycler(a, b, c);
        list_9.add(schedule_day1_list);
        mAdapter_9.notifyDataSetChanged();
    }
    private void prepareScheduleData_10(String a, String b, String c) {
        Schedule_Recycler schedule_day1_list = new Schedule_Recycler(a, b, c);
        list_10.add(schedule_day1_list);
        mAdapter_10.notifyDataSetChanged();
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
