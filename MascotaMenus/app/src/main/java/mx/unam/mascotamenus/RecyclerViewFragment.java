package mx.unam.mascotamenus;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
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

       // GridLayoutManager glm=new GridLayoutManager(getActivity(),2);

        LinearLayoutManager llm=new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvMascotas.setLayoutManager(llm);
/*
        ItemClickSupport.addTo(mRecyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                // do it
            }
        });
        */

/*
        rvMascotas.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {

            @Override
            public void onTouchEvent(RecyclerView recycler, MotionEvent event) {
                // Handle on touch events here
            }

            @Override
            public boolean onInterceptTouchEvent(RecyclerView recycler, MotionEvent event) {
                return false;
            }

        });

        */

        rvMascotas.addOnItemTouchListener(
                 new RecyclerItemClickListener(getContext(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                       // Intent intent = new Intent(view.getContext(), fragment_favoritos.class);
                        //intent=new Intent(this,Activity_Contacto.class);
                       // startActivity(intent);
                        Snackbar.make(view, "Mascota : "+position, Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                })
        );

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
