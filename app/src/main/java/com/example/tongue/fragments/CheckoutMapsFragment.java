package com.example.tongue.fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tongue.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Dash;
import com.google.android.gms.maps.model.Gap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PatternItem;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.SphericalUtil;

import java.util.Arrays;
import java.util.List;

public class CheckoutMapsFragment extends Fragment {

    //Fields

    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {
            LatLng origin = new LatLng(-0.2086989341940772, -78.4889380995957);
            LatLng restaurant = new LatLng(-0.17674340625709623, -78.47893045337151);
            googleMap.addMarker(new MarkerOptions().position(origin).title("Origin")).
                    setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
            googleMap.addMarker(new MarkerOptions().position(restaurant).title("Store")).
                    setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));;
            //googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(origin,12));
            drawCurvedPolyline(googleMap,origin,restaurant,0.65);
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_checkout_maps,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }

    private void drawCurvedPolyline(GoogleMap googleMap, LatLng p1, LatLng p2, double k){

        // Maths
        double distance = SphericalUtil.computeDistanceBetween(p1,p2);
        double heading = SphericalUtil.computeHeading(p1,p2);
        LatLng center = SphericalUtil.computeOffset(p1,distance*0.5,heading);
        double x = (1-k*k)*distance*0.5/(2*k);
        double r = (1+k*k)*distance*0.5/(2*k);
        LatLng c = SphericalUtil.computeOffset(center, x, heading + 90.0);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(c,12));
        // Polyline
        PolylineOptions options = new PolylineOptions();

        List<PatternItem> patternItemList = Arrays.<PatternItem>asList(new Dash(30), new Gap(20));
        double h1 = SphericalUtil.computeHeading(c,p1);
        double h2 = SphericalUtil.computeHeading(c,p2);
        int num_points = 150;
        double step = (h2-h1)/(num_points);

        for (int i = 0; i < num_points; i++){
            LatLng pi = SphericalUtil.computeOffset(c,r,h1+i*step);
            options.add(pi);
        }
        googleMap.addPolyline(options.width(5).color(Color.BLACK).geodesic(false).pattern(patternItemList));

    }

}