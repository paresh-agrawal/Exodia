package com.paresh.exodia;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebView;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment {

    FloatingActionMenu materialDesignFAM;
    FloatingActionButton floatingActionButton1, floatingActionButton2, floatingActionButton3, floatingActionButton4, floatingActionButton5;

    public Home() {
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
        View home = inflater.inflate(R.layout.content_home, container, false);
        ((Main_Home) getActivity()).setActionBarTitle("Exodia");
        materialDesignFAM = (FloatingActionMenu) home.findViewById(R.id.material_design_android_floating_action_menu);
        floatingActionButton1 = (FloatingActionButton) home.findViewById(R.id.material_design_floating_action_menu_fb);
        floatingActionButton2 = (FloatingActionButton) home.findViewById(R.id.material_design_floating_action_menu_website);
        floatingActionButton3 = (FloatingActionButton) home.findViewById(R.id.material_design_floating_action_menu_instagram);
        floatingActionButton4 = (FloatingActionButton) home.findViewById(R.id.material_design_floating_action_menu_googlePlus);
        floatingActionButton5 = (FloatingActionButton) home.findViewById(R.id.material_design_floating_action_menu_twitter);


        floatingButton();

        return home;
    }

    private void floatingButton() {
        floatingActionButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO something when floating action menu first item clicked
                Uri uri = Uri.parse("https://www.facebook.com/Exodia.IITMandi");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        floatingActionButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO something when floating action menu second item clicked
                Uri uri = Uri.parse("http://exodia.in/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        floatingActionButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO something when floating action menu third item clicked
                Uri uri = Uri.parse("https://www.instagram.com/exodia.in/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        floatingActionButton4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO something when floating action menu third item clicked
                Uri uri = Uri.parse("https://plus.google.com/107061928856921334485");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        floatingActionButton5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO something when floating action menu third item clicked
                Uri uri = Uri.parse("https://twitter.com/exodia_iitmandi");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
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
