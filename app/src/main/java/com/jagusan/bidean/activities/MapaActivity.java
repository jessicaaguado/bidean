package com.jagusan.bidean.activities;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.jagusan.bidean.R;

public class MapaActivity extends ActionBarActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mapa, menu);
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

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng origen = new LatLng(43.302721, -1.979934); //donosti
        LatLng destino = new LatLng(43.131400, -2.062364); //ibarra
        LatLngBounds recorridoCompleto = new LatLngBounds(destino, origen); //depende de cual más al sur
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(recorridoCompleto.getCenter(), 20));

        googleMap.addMarker(new MarkerOptions()
                .position(origen)
                .title("ORIGEN Donosti"));

        googleMap.addMarker(new MarkerOptions()
                .position(destino)
                .title("DESTION Ibarra"));
    }
}