package com.jagusan.bidean.serviciosLogica;

import android.content.res.Resources;
import android.util.Log;

import com.jagusan.bidean.R;
import com.jagusan.bidean.modelView.OpcionNavigationDrawer;

import java.util.ArrayList;
import java.util.List;

public class RecuperarOpcionesNavigationDrawer {

    public static List<OpcionNavigationDrawer> getListaOpciones(Resources resources) {
        List<OpcionNavigationDrawer> listaOpciones = new ArrayList<>();
        String[] textos = resources.getStringArray(R.array.opciones_navigation_drawer);
        String[] iconos = resources.getStringArray(R.array.iconos_navigation_drawer);
        for (int i=0; i<textos.length; i++){
            Log.d("BIDEAN", "recuperando info " + textos[i] + " " + iconos[i]);
            listaOpciones.add(new OpcionNavigationDrawer(textos[i], resources.getIdentifier(iconos[i],"drawable", "com.jaguwsan.bidean")));
        }
        return listaOpciones;
    }

}
