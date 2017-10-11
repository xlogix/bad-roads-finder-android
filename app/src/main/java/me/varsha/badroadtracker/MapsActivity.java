package me.varsha.badroadtracker;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
  private static final String TAG = MapsActivity.class.getSimpleName();

  private GoogleMap mMap;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_maps);
    // Obtain the SupportMapFragment and get notified when the map is ready to be used.
    SupportMapFragment mapFragment =
        (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
    mapFragment.getMapAsync(this);
  }

  /**
   * Manipulates the map once available.
   * This callback is triggered when the map is ready to be used.
   * This is where we can add markers or lines, add listeners or move the camera.
   * If Google Play services is not installed on the device, the user will be prompted to install
   * it inside the SupportMapFragment. This method will only be triggered once the user has
   * installed Google Play services and returned to the app.
   */
  @Override public void onMapReady(GoogleMap googleMap) {
    mMap = googleMap;
    // Showing / hiding your current location
    try {
      googleMap.setMyLocationEnabled(true);
    } catch (SecurityException e) {
      Log.d(TAG, "Permission Denied");
    }
    googleMap.setTrafficEnabled(true);
    // Enable / Disable zooming controls
    googleMap.getUiSettings().setZoomControlsEnabled(true);
    // Enable / Disable my location button
    googleMap.getUiSettings().setMyLocationButtonEnabled(true);
    // Enable / Disable Compass icon
    googleMap.getUiSettings().setCompassEnabled(true);
    // Enable / Disable Rotate gesture
    googleMap.getUiSettings().setRotateGesturesEnabled(true);
    // Enable / Disable zooming functionality
    googleMap.getUiSettings().setZoomGesturesEnabled(true);

    // Add a marker in Indore and move the camera
    LatLng university = new LatLng(13.032548, 80.1732187);
    mMap.addMarker(new MarkerOptions().position(university).title("SRM University")
        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_block)));
    mMap.addMarker(new MarkerOptions().position(new LatLng(13.031758, 80.183740)).title("Bad Road Ahead")
        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_block)));
    mMap.addMarker(new MarkerOptions().position(new LatLng(13.031634, 80.180672)).title("Bad Road Ahead")
        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_block)));
    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(university, 17.0f));
  }
}
