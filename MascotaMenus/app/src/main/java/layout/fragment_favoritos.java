package layout;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mx.unam.mascotamenus.Mascota;
import mx.unam.mascotamenus.MascotaAdaptador;
import mx.unam.mascotamenus.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class fragment_favoritos extends Fragment {

    ArrayList<Mascota> listMacotasFavoritas;
    private RecyclerView rvMascotasFavoritas;

    public fragment_favoritos() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_fragment_favoritos, container, false);

        rvMascotasFavoritas=(RecyclerView) v.findViewById(R.id.rvMascotasFavoritas);

        LinearLayoutManager llm=new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvMascotasFavoritas.setLayoutManager(llm);

        //listMacotasFavoritas=mascota.ListaFavoritos();
        InicializarLista();

        InicializarAdaptdor();
        return v;
    }

    public void InicializarAdaptdor(){
        MascotaAdaptador adaptador=new MascotaAdaptador(listMacotasFavoritas);
        rvMascotasFavoritas.setAdapter(adaptador);
    }

    public void InicializarLista(){
        listMacotasFavoritas=new ArrayList<Mascota>();
        listMacotasFavoritas.add(new Mascota("Boby",R.drawable.perro1,2));
        listMacotasFavoritas.add(new Mascota("Fido",R.drawable.perro2,1));
    }

}
