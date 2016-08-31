package mx.unam.mascotamenus;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by john on 20/08/2016.
 */
public class MascotaAdaptadorFotos extends RecyclerView.Adapter<MascotaAdaptadorFotos.MascotaViewHolder> {
    private TextView tvfavorito;
   // ListMascotasFavoritas listMascotasFavoritas= new ListMascotasFavoritas();
    ArrayList<Mascota> listMacotas;

   // ArrayList<Mascota> listMacotasFavoritas;

   public MascotaAdaptadorFotos(ArrayList<Mascota> listMacotas){
        this.listMacotas=listMacotas;
   }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota_fotos,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota=listMacotas.get(position);
        mascotaViewHolder.ivMascota.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvRate.setText(String.valueOf(mascota.getRaiting()));
    }

    @Override
    public int getItemCount() {
        return listMacotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{


        private ImageView ivMascota;
        private TextView tvRate;

        public MascotaViewHolder(final View itemView) {
            super(itemView);
            ivMascota=(ImageView) itemView.findViewById(R.id.ivMascota);
            tvRate=(TextView)  itemView.findViewById(R.id.tvRate);
        }
    }
}
