package com.paresh.exodia;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import com.github.clans.fab.FloatingActionMenu;


/**
 * A simple {@link Fragment} subclass.
 */
public class About_Us extends Fragment {

    FloatingActionMenu materialDesignFAM;
    FloatingActionButton floatingActionButton1, floatingActionButton2, floatingActionButton3;

    public About_Us() {
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
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View about_us = inflater.inflate(R.layout.fragment_about__us, container, false);
        ((Main_Home) getActivity())
                .setActionBarTitle("About Us");
        materialDesignFAM = (FloatingActionMenu) about_us.findViewById(R.id.material_design_android_floating_action_menu);
        floatingActionButton1 = (FloatingActionButton) about_us.findViewById(R.id.material_design_floating_action_menu_item1);
        floatingActionButton2 = (FloatingActionButton) about_us.findViewById(R.id.material_design_floating_action_menu_item2);
        floatingActionButton3 = (FloatingActionButton) about_us.findViewById(R.id.material_design_floating_action_menu_item3);

        floatingActionButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO something when floating action menu first item clicked
                TextView about_us_exodia = (TextView)about_us.findViewById(R.id.about_us_exodia);
                about_us_exodia.setText("Exodia IIT Mandi");
                TextView about_us_exodia_description = (TextView)about_us.findViewById(R.id.about_us_exodia_description);
                about_us_exodia_description.setText("Exodia is the annual technical cum cultural fest of IIT Mandi. It is a three-day event held towards the start of April. It is one of biggest event of Himachal Pradesh, which gathers a lot of crowd from schools and colleges of India. Started in 2012 by group of enthusiast IITians, it is a student-run non-profit organization which caters primarily to the youth. Exodia '12 and Exodia '13 were set in the transit campus of IIT Mandi while Exodia'14 was held in our permanent campus. Over the years the fest have hosted technical events like The Dalal Street(Virtual stock market game), Junkyard Warz , Electrowars and Nitro-Blaze(Clash of miniature racing cars) and cultural events like Band Slam, Alap, Instrumania, Big Stink, Envision(Documentary-making contest), Synchronians (group dance) and Groove fanatics (solo dance) which turned out to be a huge attraction. Also Exodia hosts fashion events like Mr and Mrs Exodia, Miss Femina Earth Auditions and Couture-Fashion show which witnessed some talented girls and boys from the college's in north India . In its previous editions, the fest has seen a participation of thousands of students from different reputed technical institutes from all over India like IIT Kanpur, IIT Ropar, IIIT Hyderabad, BITS Goa and so on. The band of ex-euphoria member, EKA, Kathak performance by Monisa Nayak and musical show by YouTube artistes were some of the highlights of the fest.\n\n\n\n\n");
            }
        });
        floatingActionButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO something when floating action menu second item clicked
                TextView about_us_exodia = (TextView)about_us.findViewById(R.id.about_us_exodia);
                about_us_exodia.setText("IIT Mandi");
                TextView about_us_exodia_description = (TextView)about_us.findViewById(R.id.about_us_exodia_description);
                about_us_exodia_description.setText("Founded in 2009, IIT Mandi is the only IIT located in the Himalayas. IIT Mandi's vision is to be the leader in science and technology education, knowledge creation and innovation, in an India marching towards a just, inclusive and sustainable society.\n" +
                        "\n" +
                        "The Institute's main campus, in Kamand, is located in the picturesque Uhl river valley, which is situated at about 15 kms from the historic town of Mandi in Himachal Pradesh. A transit campus of IIT Mandi, is also maintained in the premises of the Vallabh Degree College in Mandi. Mandi is located at a distance of around 475 km from Delhi and around 200 km from Chandigarh on Delhi-Manali route.\n" +
                        "\n" +
                        "IIT Mandi is the first among new IITs to develop and use its main campus. The move to the main campus which began in July-September 2012 has been steadily gaining momentum. By early 2015, it is expected that the shifting to the fully residential campus will be essentially complete and that all activities of IIT Mandi will be carried out at the Kamand Campus. The residential campus in the serene landscape by the river Uhl offers a world-class academic environment with a high quality of life in a setting of natural splendour.\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "\n");
                }
        });
        floatingActionButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO something when floating action menu third item clicked
                TextView about_us_exodia = (TextView)about_us.findViewById(R.id.about_us_exodia);
                about_us_exodia.setText("Social Cause");
                TextView about_us_exodia_description = (TextView)about_us.findViewById(R.id.about_us_exodia_description);
                about_us_exodia_description.setText("Last year our emphasis was on promoting higher education and improving the educational standards in Himachal Pradesh. Himachal Pradesh has one of the highest literacy rates and one of the most extensive systems of schools in the country but it's representation in higher education institutes and industry is not proportionately high. After a series of surveys by NSS IIT Mandi, it was found that the root cause of this disparity is lack of awareness of available higher education opportunities and career options that one may have after different levels of education and not financial limitations. Through the awareness that was spread under the banner of EXODIA'14 there was a considerable number of students enrolled in the higher education institutes from the nearby villages and towns. This was a outcome of the continuous motivation of students, parents and teachers to put forward a foot for progress of the generations to come. We sincerely hope that this year too we will be able to continue the same good work and con make more significant change in the society for its betterment. We have some new aims for EXODIA'15. As the past year made us realize that there are far too many problems and serious one too than education like Healthcare and Women empowerment. We as a part of esteemed institute want to leave impact in the society in every field. Women empowerment is one such aspect that can change the course of life of many generations, they say rightly, If you educate a man you educate an individual, but if you educate a woman you educate a family (nation). so with this aim and idea in mind we make a effort to change the society and with your help we can make a considerable difference on the lives of many.\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "\n");
            }
        });



        return about_us;
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
