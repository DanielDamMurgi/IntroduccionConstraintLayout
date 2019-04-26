package com.udemyandroid.introduccionconstraintlayout;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;
import java.util.List;

public class NotaFragment extends Fragment{

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 2;

    private List<NotaEntity> notaEntityList;
    private MyNotaRecyclerViewAdapter adapterNotas;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public NotaFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static NotaFragment newInstance(int columnCount) {
        NotaFragment fragment = new NotaFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nota_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (view.getId() == R.id.list){
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();

                float dpWith = displayMetrics.widthPixels / displayMetrics.density;
                int numeroColumnas = (int) dpWith / 180;

                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(numeroColumnas, StaggeredGridLayoutManager.VERTICAL));
            }

            notaEntityList = new ArrayList<>();

            notaEntityList.add(new NotaEntity("Lista de la compra", "Comprar pan tostado", true, android.R.color.holo_blue_light));
            notaEntityList.add(new NotaEntity("Recordar", "He aparcado el coche en la calle repoublica argentinaaaa, No olvidarme pagar el parking..... =)", false, android.R.color.holo_green_light));
            notaEntityList.add(new NotaEntity("Cumpleaños fista", "No olvidar las velas..... =(", true, android.R.color.holo_orange_light));
            notaEntityList.add(new NotaEntity("Lista de la compra", "Comprar pan tostado", true, android.R.color.holo_blue_light));
            notaEntityList.add(new NotaEntity("Recordar", "He aparcado el coche en la calle repoublica argentinaaaa, No olvidarme pagar el parking..... =)", false, android.R.color.holo_green_light));
            notaEntityList.add(new NotaEntity("Cumpleaños fista", "No olvidar las velas..... =(", true, android.R.color.holo_orange_light));
            notaEntityList.add(new NotaEntity("Lista de la compra", "Comprar pan tostado", true, android.R.color.holo_blue_light));
            notaEntityList.add(new NotaEntity("Recordar", "He aparcado el coche en la calle repoublica argentinaaaa, No olvidarme pagar el parking..... =)", false, android.R.color.holo_green_light));
            notaEntityList.add(new NotaEntity("Cumpleaños fista", "No olvidar las velas..... =(", true, android.R.color.holo_orange_light));
            notaEntityList.add(new NotaEntity("Lista de la compra", "Comprar pan tostado", true, android.R.color.holo_blue_light));
            notaEntityList.add(new NotaEntity("Recordar", "He aparcado el coche en la calle repoublica argentinaaaa, No olvidarme pagar el parking..... =)", false, android.R.color.holo_green_light));
            notaEntityList.add(new NotaEntity("Cumpleaños fista", "No olvidar las velas..... =(", true, android.R.color.holo_orange_light));

            adapterNotas = new MyNotaRecyclerViewAdapter(notaEntityList, getActivity());
            recyclerView.setAdapter(adapterNotas);
        }
        return view;
    }

}
