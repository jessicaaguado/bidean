package com.jagusan.bidean.adapters;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jagusan.bidean.R;
import com.jagusan.bidean.modelView.OpcionNavigationDrawer;

import java.util.List;


public class OpcionesNavigationDrawerAdapter extends ArrayAdapter<OpcionNavigationDrawer> {

    Context context;
    int rowLayoutId;
    List<OpcionNavigationDrawer> opciones;


    public OpcionesNavigationDrawerAdapter(Context context, int rowLayoutId, List<OpcionNavigationDrawer> opciones) {

        super(context, rowLayoutId, opciones);

        this.context = context;
        this.rowLayoutId = rowLayoutId;
        this.opciones = opciones;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            convertView = inflater.inflate(rowLayoutId, parent, false);
        }

        OpcionNavigationDrawer opcion = opciones.get(position);
        Log.d("BIDEAN","Get view "+position+" "+opcion.texto+" "+opcion.icono);
        ((TextView) convertView.findViewById(R.id.texto_opcion)).setText(opcion.texto);
        try {

          ((ImageView) convertView.findViewById(R.id.icono_opcion)).setImageResource(opcion.icono);

        } catch (Exception e) {
            Log.e("BIDEAN", "No hemos podido poner icono.... " + e);
        }

        return convertView;
    }

}
