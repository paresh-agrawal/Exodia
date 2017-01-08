package com.paresh.exodia;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AppCredits extends Fragment {


    private Animation pop_out1;
    private CardView app_credits_cardView;

    public AppCredits() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View appCredits = inflater.inflate(R.layout.fragment_app_credits, container, false);
        ((Main_Home) getActivity())
                .setActionBarTitle("App Credits");

        TextView tv_app_developer = (TextView)appCredits.findViewById(R.id.tv_app_developer);
        app_credits_cardView =(CardView)appCredits.findViewById(R.id.app_developer_cardView);

        pop_out1 = AnimationUtils.loadAnimation(getActivity(), R.anim.pop_out_1);
        tv_app_developer.setAnimation(pop_out1);

        animate1();

        return appCredits;
    }
    private void animate1() {
        app_credits_cardView.setAnimation(pop_out1);
        animate2();
    }
    private void animate2() {
        app_credits_cardView.clearAnimation();
        TranslateAnimation transAnim = new TranslateAnimation(0,0,-600,0);
        transAnim.setStartOffset(350);
        transAnim.setDuration(2500);
        transAnim.setFillAfter(true);
        transAnim.setInterpolator(new BounceInterpolator());
        transAnim.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationEnd(Animation animation) {


            }
        });
        app_credits_cardView.startAnimation(transAnim);
    }



    private int getDisplayHeight() {
        return this.getResources().getDisplayMetrics().heightPixels;
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
}
