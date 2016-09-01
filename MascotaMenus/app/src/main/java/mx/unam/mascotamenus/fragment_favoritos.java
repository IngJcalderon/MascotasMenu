package mx.unam.mascotamenus;


import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

import mx.unam.mascotamenus.Mascota;
import mx.unam.mascotamenus.MascotaAdaptador;
import mx.unam.mascotamenus.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class fragment_favoritos extends Fragment {

    ArrayList<Mascota> listMacotasFavoritas;
    ArrayList<Mascota> listMacotasFotosFavorita;
    private RecyclerView rvMascotaFavorita;
    private RecyclerView rvFotosMascotaFavorita;
    private TextView tvNombreMascota;

    public fragment_favoritos() {
        // Required empty public constructor
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_fragment_favoritos, container, false);

       // rvMascotaFavorita=(RecyclerView) v.findViewById(R.id.rvMascotaFavorita);

        rvFotosMascotaFavorita=(RecyclerView) v.findViewById(R.id.rvFotosMascotaFavorita);
        tvNombreMascota= (TextView) v.findViewById(R.id.tvNombreMascota);
        //Imagen redondeada
        Bitmap icon = BitmapFactory.decodeResource(getResources(),R.drawable.perro22);

        CircularImageView circularImageView = (CircularImageView) v.findViewById(R.id.civMascotaFavorita);
        // Set Border
        //circularImageView.setBorderColor(getResources().getColor(R.color.colorAccent));
        //circularImageView.setBorderWidth(10);
        circularImageView.setImageBitmap(icon);

        // Add Shadow with default param
        circularImageView.addShadow();
        // or with custom param
        circularImageView.setShadowRadius(15);
        circularImageView.setShadowColor(Color.GREEN);

        tvNombreMascota.setText("Fido");
        //Fin de imagen redondeada
        //Mascota principal
/*
        LinearLayoutManager llm=new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvMascotaFavorita.setLayoutManager(llm);
        //listMacotasFavoritas=mascota.ListaFavoritos();
        InicializarLista();
        InicializarAdaptdor();
*/
        //Fotos de Mascota principal

        GridLayoutManager glm=new GridLayoutManager(getActivity(),3);
        glm.setOrientation(GridLayoutManager.VERTICAL);

        rvFotosMascotaFavorita.setLayoutManager(glm);

        InicializarListaFotosMascota();

        InicializarAdaptdorFotos();
//        */
        return v;
    }

    public void InicializarAdaptdor(){
        MascotaAdaptador adaptador=new MascotaAdaptador(listMacotasFavoritas);
        rvMascotaFavorita.setAdapter(adaptador);
    }

    public void InicializarLista(){
        listMacotasFavoritas=new ArrayList<Mascota>();
        listMacotasFavoritas.add(new Mascota("Fido",R.drawable.perro2,2));
    }

    public void InicializarAdaptdorFotos(){
        MascotaAdaptadorFotos adaptadorFotos=new MascotaAdaptadorFotos(listMacotasFotosFavorita);
        rvFotosMascotaFavorita.setAdapter(adaptadorFotos);
    }
    public void InicializarListaFotosMascota(){
        listMacotasFotosFavorita=new ArrayList<Mascota>();
        listMacotasFotosFavorita.add(new Mascota("Fido",R.drawable.perro2,2));
        listMacotasFotosFavorita.add(new Mascota("Fido",R.drawable.perro2,1));
        listMacotasFotosFavorita.add(new Mascota("Fido",R.drawable.perro2,3));
        listMacotasFotosFavorita.add(new Mascota("Fido",R.drawable.perro2,4));
        listMacotasFotosFavorita.add(new Mascota("Fido",R.drawable.perro2,1));
        listMacotasFotosFavorita.add(new Mascota("Fido",R.drawable.perro2,0));
    }

}
