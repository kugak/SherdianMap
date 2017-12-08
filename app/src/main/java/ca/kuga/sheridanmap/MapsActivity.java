package ca.kuga.sheridanmap;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

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
        mMap.addMarker(new MarkerOptions()
                            .position(davis)
                            .title("Davis Campus")
                            .snippet("Brampton")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        //marker for trafalger
        mMap.addMarker(new MarkerOptions()
                            .position(trafalgar)
                            .title("Trafalgar Campus")
                            .snippet("Oakville")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        //marker for hmc
        mMap.addMarker(new MarkerOptions()
                            .position(hmc)
                            .title("HMC Campus")
                            .snippet("Mississauga")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

        //set initial zoom and animation at davis
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(davis,10));

    }
}
