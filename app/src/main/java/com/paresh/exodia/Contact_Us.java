package com.paresh.exodia;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class Contact_Us extends Fragment {


    public Contact_Us() {
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
        View contact_us = inflater.inflate(R.layout.fragment_contact_us, container, false);
        ((Main_Home) getActivity())
                .setActionBarTitle("Contact Us");
        RelativeLayout ivcall = (RelativeLayout) contact_us.findViewById(R.id.item_linear_layout_kislaya);
        ivcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+918629015413")));
            }
        });
        RelativeLayout ivcall1 = (RelativeLayout) contact_us.findViewById(R.id.item_linear_layout_aditya);
        ivcall1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+918629015395")));
            }
        });
        RelativeLayout ivcall2 = (RelativeLayout) contact_us.findViewById(R.id.item_linear_layout_abhishek);
        ivcall2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+918629015394")));
            }
        });
        RelativeLayout ivcall3 = (RelativeLayout) contact_us.findViewById(R.id.item_linear_layout_atul);
        ivcall3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+918629015414")));
            }
        });
        RelativeLayout ivcall4 = (RelativeLayout) contact_us.findViewById(R.id.item_linear_layout_mukesh);
        ivcall4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+918350939554")));
            }
        });
        RelativeLayout ivcall5 = (RelativeLayout) contact_us.findViewById(R.id.item_linear_layout_anuksha);
        ivcall5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+918629015407")));
            }
        });
        RelativeLayout ivcall6 = (RelativeLayout) contact_us.findViewById(R.id.item_linear_layout_rahul);
        ivcall6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+918989587883")));
            }
        });
        RelativeLayout ivcall7 = (RelativeLayout) contact_us.findViewById(R.id.item_linear_layout_pulkit);
        ivcall7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+919882650863")));
            }
        });
        return contact_us;
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
}
