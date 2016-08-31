package mx.unam.mascotamenus;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //private Toolbar toolbar2;
    private TabLayout tabLayout;
    private ViewPager vpPager;

    Mascota mascota;
    ArrayList<Mascota> listMacotas;
    private RecyclerView rvMascotas;
    private TextView tvfavorito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //
        toolbar =(Toolbar) findViewById(R.id.toolbar);
        tabLayout =(TabLayout) findViewById(R.id.tabLayout);
        vpPager =(ViewPager) findViewById(R.id.vpPager);
        setUpViewPager();

        if (toolbar==null){
            setSupportActionBar(toolbar);
        }

        vpPager.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                /*Log.i("***","***");
                Toast.makeText(getActivity(), "XXXX", Toast.LENGTH_SHORT).show();*/
                Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        //

/*
        rvMascotas=(RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm=new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvMascotas.setLayoutManager(llm);

        //listMacotas=mascota.InicializarLista();

        InicializarLista();

        InicializarAdaptdor();
        */

        tvfavorito=(TextView)  findViewById(R.id.tvfavorito);

        tvfavorito.setOnClickListener(new AdapterView.OnClickListener() {
                                          @Override
                                          public void onClick(View view) {
                                              Intent intent=new Intent(MainActivity.this,Favoritos.class);
                                              startActivity(intent);
                                          }
                                      }
        );

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent intent;
        switch (id){
            case R.id.mContacto:
                intent=new Intent(this,Activity_Contacto.class);
                startActivity(intent);
                break;
            case R.id.mAcerca:
                intent=new Intent(this,Activity_Acercade.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);

    }
    /*
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
*/
    private  ArrayList<Fragment> agregarFraments(){
        ArrayList<Fragment> fragments=new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new fragment_favoritos());

        return fragments;
    }
    private  void setUpViewPager(){
        vpPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFraments()));
        tabLayout.setupWithViewPager(vpPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(0).setText("Lista");
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_favorito);
        tabLayout.getTabAt(1).setText("Mascota");
    }
}
