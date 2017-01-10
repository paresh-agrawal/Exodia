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
import android.support.v7.widget.CardView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Contact_Us extends Fragment {

    private CardView cardView_kislaya,cardView_aditya,cardView_abhishek,cardView_atul,cardView_mukesh,cardView_anuksha,cardView_rahul,cardView_pulkit,cardView_rahulSingh,cardView_mohit,cardView_aakash,cardView_himanshu,cardView_aman,cardView_mayuresh,cardView_dheeraj,cardView_akshit,cardView_pankaj;
    private TextView textView_convenor,textView_spon,textView_publicity,textView_media,textView_desingers,textView_planning,textView_finance,textView_hospitality,textView_control;

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
                .setActionBarTitle("Our Team");

        cardView_kislaya = (CardView) contact_us.findViewById(R.id.cardview_kislaya);
        cardView_aditya = (CardView) contact_us.findViewById(R.id.cardview_aditya);
        cardView_abhishek = (CardView) contact_us.findViewById(R.id.cardview_abhishek);
        cardView_atul = (CardView) contact_us.findViewById(R.id.cardview_atul);
        cardView_mukesh = (CardView) contact_us.findViewById(R.id.cardview_mukesh);
        cardView_anuksha = (CardView) contact_us.findViewById(R.id.cardview_anuksha);
        cardView_rahul = (CardView) contact_us.findViewById(R.id.cardview_rahul);
        cardView_pulkit = (CardView) contact_us.findViewById(R.id.cardview_pulkit);
        cardView_rahulSingh = (CardView) contact_us.findViewById(R.id.cardview_rahulSingh);
        cardView_mohit = (CardView) contact_us.findViewById(R.id.cardview_mohit);
        cardView_aakash = (CardView) contact_us.findViewById(R.id.cardview_aakash);
        cardView_himanshu = (CardView) contact_us.findViewById(R.id.cardview_himanshu);
        cardView_aman = (CardView) contact_us.findViewById(R.id.cardview_aman);
        cardView_mayuresh = (CardView) contact_us.findViewById(R.id.cardview_mayuresh);
        cardView_dheeraj = (CardView) contact_us.findViewById(R.id.cardview_dheeraj);
        cardView_akshit = (CardView) contact_us.findViewById(R.id.cardview_akshit);
        cardView_pankaj = (CardView) contact_us.findViewById(R.id.cardview_pankaj);
        textView_convenor = (TextView)contact_us.findViewById(R.id.tv_convenor);
        textView_spon = (TextView)contact_us.findViewById(R.id.tv_spon);
        textView_publicity = (TextView)contact_us.findViewById(R.id.tv_publicity);
        textView_media = (TextView)contact_us.findViewById(R.id.tv_media);
        textView_desingers = (TextView)contact_us.findViewById(R.id.tv_designers);
        textView_planning = (TextView)contact_us.findViewById(R.id.tv_planning);
        textView_finance = (TextView)contact_us.findViewById(R.id.tv_finance);
        textView_hospitality = (TextView)contact_us.findViewById(R.id.tv_hospitality);
        textView_control = (TextView)contact_us.findViewById(R.id.tv_control);

        animation();
        call();
        return contact_us;
    }

    private void animation() {
        Animation pop_out1 = AnimationUtils.loadAnimation(getActivity(), R.anim.pop_out_1);
        cardView_kislaya.setAnimation(pop_out1);
        cardView_aditya.setAnimation(pop_out1);
        cardView_abhishek.setAnimation(pop_out1);
        cardView_atul.setAnimation(pop_out1);
        cardView_mukesh.setAnimation(pop_out1);
        cardView_anuksha.setAnimation(pop_out1);
        cardView_rahul.setAnimation(pop_out1);
        cardView_pulkit.setAnimation(pop_out1);
        cardView_pankaj.setAnimation(pop_out1);
        cardView_akshit.setAnimation(pop_out1);
        cardView_dheeraj.setAnimation(pop_out1);
        cardView_mayuresh.setAnimation(pop_out1);
        cardView_aman.setAnimation(pop_out1);
        cardView_himanshu.setAnimation(pop_out1);
        cardView_aakash.setAnimation(pop_out1);
        cardView_mohit.setAnimation(pop_out1);
        cardView_rahulSingh.setAnimation(pop_out1);
        textView_convenor.setAnimation(pop_out1);
        textView_spon.setAnimation(pop_out1);
        textView_publicity.setAnimation(pop_out1);
        textView_media.setAnimation(pop_out1);
        textView_desingers.setAnimation(pop_out1);
        textView_planning.setAnimation(pop_out1);
        textView_finance.setAnimation(pop_out1);
        textView_hospitality.setAnimation(pop_out1);
        textView_control.setAnimation(pop_out1);
    }

    private void call() {
        cardView_kislaya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+918629015413")));
            }
        });
        cardView_aditya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+918629015395")));
            }
        });
        cardView_abhishek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+918629015394")));
            }
        });
        cardView_atul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+918629015414")));
            }
        });
        cardView_mukesh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+918350939554")));
            }
        });
        cardView_anuksha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+918629015407")));
            }
        });
        cardView_rahul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+918989587883")));
            }
        });
        cardView_pulkit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+919882650863")));
            }
        });
        cardView_rahulSingh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+918504023766")));
            }
        });
        cardView_mohit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+918629015362")));
            }
        });
        cardView_aakash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:-")));
            }
        });
        cardView_himanshu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+919736260510")));
            }
        });
        cardView_aman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+918629015159")));
            }
        });
        cardView_mayuresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+919459086596")));
            }
        });
        cardView_dheeraj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+917827807695")));
            }
        });
        cardView_akshit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+917807153087")));
            }
        });
        cardView_pankaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+917807054950")));
            }
        });

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
