package com.jagusan.bidean.activities;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.jagusan.bidean.R;
import com.jagusan.bidean.adapters.OpcionesNavigationDrawerAdapter;
import com.jagusan.bidean.listeners.OpcionesNavigationDrawerItemClickListener;
import com.jagusan.bidean.modelView.OpcionNavigationDrawer;
import com.jagusan.bidean.serviciosLogica.RecuperarOpcionesNavigationDrawer;

import java.util.List;

public class MainActivity extends ActionBarActivity {

    ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        DrawerLayout navigationDrawerLayout = (DrawerLayout) findViewById(R.id.main_activity);
        navigationDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);

        List<OpcionNavigationDrawer> opciones = RecuperarOpcionesNavigationDrawer.getListaOpciones(getResources());
        ListView opcionesListView = (ListView) findViewById(R.id.navigation_drawer);
        opcionesListView.setAdapter(new OpcionesNavigationDrawerAdapter(this, R.layout.navigation_drawer_opciones_row, opciones));
        opcionesListView.setOnItemClickListener(new OpcionesNavigationDrawerItemClickListener(navigationDrawerLayout, opcionesListView, this));

        mDrawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                navigationDrawerLayout,         /* DrawerLayout object */
                R.string.navigation_drawer_open,  /* "open drawer" description for accessibility */
                R.string.navigation_drawer_close  /* "close drawer" description for accessibility */
        ) {
            public void onDrawerClosed(View view) {
                getSupportActionBar().setTitle("titulillo al cerrar");
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle("titulillo al abrir");
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };
        navigationDrawerLayout.setDrawerListener(mDrawerToggle);

        if (savedInstanceState == null) {

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        switch(item.getItemId()) {
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        mDrawerToggle.onConfigurationChanged(newConfig);
    }
}
