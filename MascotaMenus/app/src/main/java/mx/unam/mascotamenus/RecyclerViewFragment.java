package mx.unam.mascotamenus;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by john on 29/08/2016.
 */
public class RecyclerViewFragment extends Fragment {

    Mascota mascota;
    ArrayList<Mascota> listMacotas;
    private RecyclerView rvMascotas;
    private TextView tvfavorito;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_recyclerview,container,false);


        rvMascotas=(RecyclerView) v.findViewById(R.id.rvMascotas);

        LinearLayoutManager llm=new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvMascotas.setLayoutManager(llm);

        //listMacotas=mascota.InicializarLista();
        InicializarLista();

        InicializarAdaptdor();

        return v;
    }

    public void InicializarAdaptdor(){
        MascotaAdaptador adaptador=new MascotaAdaptador(listMacotas);
        rvMascotas.setAdapter(adaptador);
    }


    public void InicializarLista(){
        listMacotas=new ArrayList<Mascota>();
        listMacotas.add(new Mascota("Boby",R.drawable.perro1,2));
        listMacotas.add(new Mascota("Fido",R.drawable.perro2,1));
        listMacotas.add(new Mascota("Spy",R.drawable.perro3,2));
        listMacotas.add(new Mascota("Chester",R.drawable.perro4,1));
        listMacotas.add(new Mascota("Yago",R.drawable.perro5,2));
    }
}
