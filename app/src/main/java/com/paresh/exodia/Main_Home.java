package com.paresh.exodia;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;
import com.firebase.client.Firebase;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.paresh.exodia.Schedule_Package.Schedule;

public class Main_Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private boolean viewIsAtHome;
    private static final int TIME_INTERVAL = 2000; // # milliseconds, desired time passed between two back presses.
    private long mBackPressed;
    public DrawerLayout drawer;
    FloatingActionMenu materialDesignFAM;
    FloatingActionButton floatingActionButton1, floatingActionButton2, floatingActionButton3, floatingActionButton4, floatingActionButton5;
    public int b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Firebase.setAndroidContext(this);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        displayView(R.id.content_frame);
        materialDesignFAM = (FloatingActionMenu) findViewById(R.id.material_design_android_floating_action_menu);
        floatingActionButton1 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_fb);
        floatingActionButton2 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_website);
        floatingActionButton3 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_instagram);
        floatingActionButton4 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_googlePlus);
        floatingActionButton5 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_twitter);


        floatingButton();
        animate();
    }
    private void animate() {
        Animation pop_out = AnimationUtils.loadAnimation(this,R.anim.pop_out);

        materialDesignFAM.setAnimation(pop_out);
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
    public void onBackPressed() {
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (!viewIsAtHome) { //if the current view is not the News fragment
            displayView(R.id.content_frame); //display the News fragment
            //Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT).show();
            final Toast toast = Toast.makeText(getApplicationContext(), "Press back again to exit", Toast.LENGTH_SHORT);
            toast.show();

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    toast.cancel();
                }
            }, 500);
            if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis()) {
                finish();
            }
            mBackPressed = System.currentTimeMillis();//If view is in Home fragment, exit application
        } else {
            //Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT).show();
            final Toast toast = Toast.makeText(getApplicationContext(), "Press back again to exit", Toast.LENGTH_SHORT);
            toast.show();

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    toast.cancel();
                }
            }, 500);
            if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis()) {
                finish();
            }
            mBackPressed = System.currentTimeMillis();//If view is in Home fragment, exit application

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.action_exit) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            displayView(R.id.nav_home);
        } else if (id == R.id.nav_events) {
            displayView(R.id.nav_events);
        } else if (id == R.id.nav_schedule) {
            displayView(R.id.nav_schedule);
        } else if (id == R.id.nav_directions) {
            startActivity(new Intent(Main_Home.this, Map_activity.class));
            return true;
        } else if (id == R.id.nav_app_credits) {
            displayView(R.id.nav_app_credits);
        } else if (id == R.id.nav_contact_us) {
            displayView(R.id.nav_contact_us);
        } else if (id == R.id.nav_sponsors) {
            displayView(R.id.nav_sponsors);
        } else if (id == R.id.nav_about_us) {
            displayView(R.id.nav_about_us);
        } else if (id == R.id.nav_share) {
            displayView(R.id.nav_share);
        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void displayView(int viewId) {
        Fragment fragment = null;
        String title = getString(R.string.app_name);

        switch (viewId) {
            case R.id.nav_contact_us:
                fragment = new Contact_Us();
                viewIsAtHome = true;
                title = "Contacts";
                break;

            case R.id.nav_sponsors:
                fragment = new Sponsors();
                viewIsAtHome = true;
                title = "Sponsors";
                break;

            case R.id.nav_events:
                fragment = new Events();
                viewIsAtHome = true;
                title = "Events";
                break;

            case R.id.nav_home:
                fragment = new Home();
                viewIsAtHome = true;
                title = "Exodia";
                break;
            case R.id.nav_about_us:
                fragment = new About_Us();
                viewIsAtHome = true;
                title = "About Us";
                break;
            case R.id.nav_schedule:
                fragment = new Schedule();
                viewIsAtHome = true;
                title = "About Us";
                break;
            case R.id.nav_app_credits:
                fragment = new AppCredits();
                viewIsAtHome = true;
                title = "About Us";
                break;
            case R.id.nav_share:
                fragment = new EventTabs();
                viewIsAtHome = true;
                title = "About Us";
                break;
        }

        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(R.anim.fade_in,
                    R.anim.fade_out);
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }

        // set the toolbar title
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    public void setInt(int a){
        b=a;
    }
}

