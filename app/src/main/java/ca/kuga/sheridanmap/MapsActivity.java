package ca.kuga.sheridanmap;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

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



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // setting campuses locations
        LatLng davis = new LatLng(43.656054, -79.739344);
        LatLng trafalgar = new LatLng(43.469015, -79.698624);
        LatLng hmc = new LatLng(43.591075, -79.647047);

        //enable zoom control
        mMap.getUiSettings().setZoomControlsEnabled(true);


        //marker for davis
        Marker davMrkr = mMap.addMarker(new MarkerOptions()
                            .position(davis)
                            .title("Davis Campus")
                            .snippet("Brampton")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        //marker for trafalger
        Marker traMrkr = mMap.addMarker(new MarkerOptions()
                            .position(trafalgar)
                            .title("Trafalgar Campus")
                            .snippet("Oakville")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        //marker for hmc
        Marker hmcMrkr = mMap.addMarker(new MarkerOptions()
                            .position(hmc)
                            .title("HMC Campus")
                            .snippet("Mississauga")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        //set initial zoom and animation at davis
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(davis,10));

        //polyline connect campuses
        Polyline line = mMap.addPolyline(new PolylineOptions()
                .add(davis, hmc, trafalgar)
                .width(9)
                .color(Color.RED));


    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }
}
