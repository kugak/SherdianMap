package ca.kuga.sheridanmap;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
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

        // Sheridan Brampton Campus
        LatLng davis = new LatLng(43.656054, -79.739344);
        mMap.addMarker(new MarkerOptions().position(davis).title("Davis Campus"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(davis));

        // Sheridan Oakville Campus
        LatLng trafalgar = new LatLng(43.469015, -79.698624);
        mMap.addMarker(new MarkerOptions().position(trafalgar).title("Trafalgar Campus"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(trafalgar));

        // Sheridan Mississauga Campus
        LatLng hmc = new LatLng(43.591075, -79.647047);
        mMap.addMarker(new MarkerOptions().position(hmc).title("HMC Campus"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(hmc));
    }
}
