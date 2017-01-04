package com.paresh.exodia;

import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class Map_activity extends AppCompatActivity
        implements OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener {

    GoogleMap mGoogleMap;
    SupportMapFragment mapFrag;
    LocationRequest mLocationRequest;
    GoogleApiClient mGoogleApiClient;
    Location mLastLocation;
    Marker mCurrLocationMarker;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.fragment_map);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkLocationPermission();
        }

        mapFrag = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFrag.getMapAsync(this);
    }

    private void goToLocationZoom(double lat, double lng, float zoom) {
        LatLng ll = new LatLng(lat, lng);
        CameraUpdate upadatezoom = CameraUpdateFactory.newLatLngZoom(ll, zoom);
        mGoogleMap.moveCamera(upadatezoom);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.map_type_menu, menu);
        return true;
    }


    @Override
    public void onPause() {
        super.onPause();

        //stop location updates when Activity is no longer active
        if (mGoogleApiClient != null) {
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        mGoogleMap=googleMap;
        mGoogleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        goToLocationZoom(31.773214, 76.984563, 16);
        Toast.makeText(this, "Make sure location services is enabled", Toast.LENGTH_LONG).show();
        //Initialize Google Play Services
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this,
                    android.Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                buildGoogleApiClient();
                mGoogleMap.setMyLocationEnabled(true);
                Marker b1 = mGoogleMap.addMarker(new MarkerOptions()
                        .position(new LatLng(31.772611, 76.984004))
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.droppin2))
                        .title("B1")
                        .snippet("Boys Hostel"));
                Marker b3 = mGoogleMap.addMarker(new MarkerOptions()
                        .position(new LatLng(31.772018, 76.983950))
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.droppin2))
                        .title("B3")
                        .snippet("Girls Hostel"));
                Marker b4 = mGoogleMap.addMarker(new MarkerOptions()
                        .position(new LatLng(31.772339, 76.984334))
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.droppin2))
                        .title("B4")
                        .snippet("Girls Hostel"));
                Marker b2 = mGoogleMap.addMarker(new MarkerOptions()
                        .position(new LatLng(31.772267, 76.983918))
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.droppin2))
                        .title("B2")
                        .snippet("Boys Hostel"));
                Marker b5 = mGoogleMap.addMarker(new MarkerOptions()
                        .position(new LatLng(31.771562, 76.983500))
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.droppin2))
                        .title("B5")
                        .snippet("Boys Hostel"));
                Marker b6 = mGoogleMap.addMarker(new MarkerOptions()
                        .position(new LatLng(31.771811, 76.983173))
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.droppin2))
                        .title("B6")
                        .snippet("Boys Hostel"));
                Marker b7 = mGoogleMap.addMarker(new MarkerOptions()
                        .position(new LatLng(31.771177, 76.982883))
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.droppin2))
                        .title("B7")
                        .snippet("Boys Hostel"));
                Marker g3 = mGoogleMap.addMarker(new MarkerOptions()
                        .position(new LatLng(31.771815, 76.983723))
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.droppin2))
                        .title("G3")
                        .snippet("Boys Hostel"));
                Marker g4 = mGoogleMap.addMarker(new MarkerOptions()
                        .position(new LatLng(31.771043, 76.983174))
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.droppin2))
                        .title("G4")
                        .snippet("Boys Hostel"));
                Marker a1 = mGoogleMap.addMarker(new MarkerOptions()
                        .position(new LatLng(31.775356, 76.985414))
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.droppin4))
                        .title("A1")
                        .snippet("Academic Building"));
                Marker grnd = mGoogleMap.addMarker(new MarkerOptions()
                        .position(new LatLng(31.773698, 76.984170))
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.droppin3))
                        .title("Football")
                        .snippet("Ground"));
                Marker baddy = mGoogleMap.addMarker(new MarkerOptions()
                        .position(new LatLng(31.770549, 76.982936))
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.droppin3))
                        .title("Badminton")
                        .snippet("court"));
                Marker tt = mGoogleMap.addMarker(new MarkerOptions()
                        .position(new LatLng(31.770628, 76.982970))
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.droppin3))
                        .title("TT")
                        .snippet("court"));
                Marker gym = mGoogleMap.addMarker(new MarkerOptions()
                        .position(new LatLng(31.770622, 76.982891))
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.droppin3))
                        .title("Gym"));
            }
        }
        else {
            buildGoogleApiClient();
            mGoogleMap.setMyLocationEnabled(true);
        }


    }

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();
    }

    @Override
    public void onConnected(Bundle bundle) {
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(100);
        mLocationRequest.setFastestInterval(100);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        if (ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
        }
    }

    @Override
    public void onConnectionSuspended(int i) {}

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {}

    @Override
    public void onLocationChanged(Location location)
    {
        mLastLocation = location;
        if (mCurrLocationMarker != null) {
            mCurrLocationMarker.remove();
        }

        //Place current location marker
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.title("Current Position");
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
        //move map camera
        mGoogleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mGoogleMap.animateCamera(CameraUpdateFactory.zoomTo(16));

        //stop location updates
        if (mGoogleApiClient != null) {
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
        }
    }

    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    public boolean checkLocationPermission(){
        if (ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    android.Manifest.permission.ACCESS_FINE_LOCATION)) {

                //TODO:
                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

                //Prompt the user once explanation has been shown
                //(just doing it here for now, note that with this code, no explanation is shown)
                ActivityCompat.requestPermissions(this,
                        new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);


            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(this,
                        new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
            }
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // location-related task you need to do.
                    if (ContextCompat.checkSelfPermission(this,
                            android.Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED) {

                        if (mGoogleApiClient == null) {
                            buildGoogleApiClient();
                        }
                        mGoogleMap.setMyLocationEnabled(true);
                    }

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(this, "permission denied", Toast.LENGTH_LONG).show();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mapTpyeNormal:
                mGoogleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                break;
            case R.id.mapTpyeSatellite:
                mGoogleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                break;
            case R.id.mapTpyeTerrain:
                mGoogleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                break;
            case R.id.mapTpyeHybrid:
                mGoogleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                break;
            case R.id.action_campus_view:
                goToLocationZoom(31.773214, 76.984563, 16);
                break;
            case android.R.id.home:

                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}