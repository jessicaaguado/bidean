package com.jagusan.bidean.listeners;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.jagusan.bidean.R;


public class OpcionesNavigationDrawerItemClickListener implements ListView.OnItemClickListener {

    DrawerLayout drawerLayout;
    ListView listView;
    ActionBarActivity activity;

    public OpcionesNavigationDrawerItemClickListener(DrawerLayout navigationDrawerLayout,
                                                     ListView opcionesListView,
                                                     ActionBarActivity parentActivity) {
        drawerLayout = navigationDrawerLayout;
        listView = opcionesListView;
        activity = parentActivity;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mostrarPantallaOpcionSeleccionada(position);
    }

    private void mostrarPantallaOpcionSeleccionada(int position) {
        // update the main content by replacing fragments
        //Fragment fragment = new PlanetFragment();
        //Bundle args = new Bundle();
        //args.putInt(PlanetFragment.ARG_PLANET_NUMBER, position);
        //fragment.setArguments(args);
        Fragment fragment = new Fragment();
        activity.getFragmentManager().beginTransaction().replace(R.id.contenido, fragment).commit();

        activity.getSupportActionBar().setTitle(""+position);
        // update selected item and title, then close the drawer
        listView.setItemChecked(position, true);
        drawerLayout.closeDrawer(listView);
    }
}

