package com.nikesh.project.shoppingcart;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;

import com.google.android.gms.maps.model.Marker;
import com.nikesh.project.shoppingcart.View.Payment;

import android.os.Bundle;
import com.nikesh.project.shoppingcart.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        googleMap.setOnMarkerClickListener(this);
        LatLng x = new LatLng(48.9555567, -93.70275);
        mMap.addMarker(new MarkerOptions().position(x).title("Marker in Onterio"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(x));


    }
    @Override
    public boolean onMarkerClick(final Marker marker) {
        final String newString;
        Bundle extras = getIntent().getExtras();
            if(extras == null) {
                newString= null;
            } else {
                newString= extras.getString("Total");

            }

        Intent intent = new Intent(MapsActivity.this, Payment.class);
        intent.putExtra("Total", String.valueOf(newString));
        startActivity(intent);
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}