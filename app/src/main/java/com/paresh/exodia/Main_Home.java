package com.paresh.exodia;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.database.FirebaseDatabase;

import static com.paresh.exodia.R.drawable.notification_logo1;

public class Main_Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

        private NavigationView navigationView;
        private boolean viewIsAtHome;
        private static final int TIME_INTERVAL = 2000; // # milliseconds, desired time passed between two back presses.
        private long mBackPressed;
        private Firebase myFirebaseRef;
        public static String val;
        private NotificationCompat.Builder mBuilder,mBuilder1;
        private String NotificationString;
        public DrawerLayout drawer;

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

        NotificationFirebase();

    }

    public void NotificationFirebase() {
        int color = getResources().getColor(R.color.colorPrimary);
        mBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                //.setLargeIcon(largeIcon)
                .setSmallIcon(R.drawable.ic_notification_icon)
                .setColor(color)
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
        mBuilder1 = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                //.setLargeIcon(largeIcon)
                .setSmallIcon(R.drawable.ic_notification_icon)
                .setColor(color)
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
        getNotification();
    }

    private void getNotification() {
        //Notification 1
        myFirebaseRef = new Firebase("https://exodia-1002f.firebaseio.com/Value");
        myFirebaseRef.addValueEventListener(new com.firebase.client.ValueEventListener() {
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot data) {

                System.out.println(data.getValue());
                val = (String)data.getValue();
                Log.d("def",val);
                if(val.equals("yes1")){
                    myFirebaseRef = new Firebase("https://exodia-1002f.firebaseio.com/Flag/NotificationDetail");
                    myFirebaseRef.addValueEventListener(new com.firebase.client.ValueEventListener() {
                        @Override
                        public void onDataChange(com.firebase.client.DataSnapshot notification) {
                            System.out.println(notification.getValue());
                            mBuilder.setContentText((String)notification.getValue());
                        }
                        @Override
                        public void onCancelled(FirebaseError firebaseError) {
                        }
                    });
                    myFirebaseRef = new Firebase("https://exodia-1002f.firebaseio.com/Flag/NotificationTitle");
                    myFirebaseRef.addValueEventListener(new com.firebase.client.ValueEventListener() {
                        @Override
                        public void onDataChange(com.firebase.client.DataSnapshot notification) {
                            System.out.println(notification.getValue());
                            mBuilder.setContentTitle((String)notification.getValue());
                        }
                        @Override
                        public void onCancelled(FirebaseError firebaseError) {
                        }
                    });
                    buildNotification(1);
                }
                else if(val.equals("yes2")){
                    myFirebaseRef = new Firebase("https://exodia-1002f.firebaseio.com/Flag1/NotificationDetail");
                    myFirebaseRef.addValueEventListener(new com.firebase.client.ValueEventListener() {
                        @Override
                        public void onDataChange(com.firebase.client.DataSnapshot notification) {
                            System.out.println(notification.getValue());
                            mBuilder1.setContentText((String)notification.getValue());
                        }
                        @Override
                        public void onCancelled(FirebaseError firebaseError) {
                        }
                    });
                    myFirebaseRef = new Firebase("https://exodia-1002f.firebaseio.com/Flag1/NotificationTitle");
                    myFirebaseRef.addValueEventListener(new com.firebase.client.ValueEventListener() {
                        @Override
                        public void onDataChange(com.firebase.client.DataSnapshot notification) {
                            System.out.println(notification.getValue());
                            mBuilder1.setContentTitle((String)notification.getValue());
                        }
                        @Override
                        public void onCancelled(FirebaseError firebaseError) {
                        }
                    });
                    buildNotification(2);
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });
    }

    private void buildNotification(int i) {
        if(i==1) {
            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(1, mBuilder.build());
        }
        else if(i==2){
            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(1, mBuilder1.build());
        }
    }

    @Override
    public void onBackPressed() {
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else if (!viewIsAtHome) { //if the current view is not the News fragment
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
                if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis())
                {
                    finish();}
                mBackPressed = System.currentTimeMillis();//If view is in Home fragment, exit application
        }else {
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
                if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis())
                {
                    finish();}
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
        }
        else if (id == R.id.action_exit){
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

        } else if (id == R.id.nav_directions) {
            startActivity(new Intent(Main_Home.this,Map_activity.class));
            return true;
        } else if (id == R.id.nav_app_credits) {

        } else if (id == R.id.nav_contact_us) {
            displayView(R.id.nav_contact_us);
        } else if (id == R.id.nav_sponsors) {
            displayView(R.id.nav_sponsors);
        } else if (id == R.id.nav_about_us) {

        } else if (id == R.id.nav_share) {

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
                title  = "Contacts";
                break;

            case R.id.nav_sponsors:
                fragment = new Sponsors();
                viewIsAtHome = true;
                title  = "Sponsors";
                break;

            case R.id.nav_events:
                fragment = new Events();
                viewIsAtHome = true;
                title  = "Events";
                break;

            case R.id.nav_home:
                fragment = new Home();
                viewIsAtHome = true;
                title  = "Exodia";
                break;
        }

        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
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
}
