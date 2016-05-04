package com.juliannunez.navdrawer;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String [] opciones;
    private ListView listView;
    private DrawerLayout drawerLayout;
    private CharSequence tituloSec;
    private CharSequence tituloApp;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private Button boton1;
    private int y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        y=0;

        opciones = new String [] {"Inicio", "Bares", "Hoteles", "Sitios turisticos", "Info. demografica"};
        drawerLayout = (DrawerLayout)findViewById(R.id.contenedorprincipal);
        listView = (ListView)findViewById(R.id.menuIzq);

        listView.setAdapter(new ArrayAdapter<String>(getSupportActionBar().getThemedContext(), android.R.layout.simple_list_item_1, opciones));
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.contenedorFragment, new InicioFragment()).commit();

        final ActionBar ab = getSupportActionBar();
        if (ab!=null){
            ab.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
            ab.setDisplayHomeAsUpEnabled(true);
        }

        Fragment fragment = null;
        if(y==0){

            fragment = new InicioFragment();
            y=1;
        }




        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fragment fragment = null;
                switch (position) {
                    case 0:
                        fragment = new InicioFragment();
                        break;
                    case 1:
                        fragment = new BaresFragment();
                        break;
                    case 2:
                        fragment = new HotelesFragment();
                        break;
                    case 3:
                        fragment = new TuristicosFragment();
                        break;
                    case 4:
                        fragment = new DemografiaFragment();
                        break;
                    default:
                        fragment = new InicioFragment();
                        break;
                }
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.contenedorFragment, fragment).commit();
                listView.setItemChecked(position, true);
                tituloSec = opciones[position];
                getSupportActionBar().setTitle(tituloSec);
                drawerLayout.closeDrawer(listView);
            }
        });

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.drawable.ic_menu_white_24dp, R.string.abierto, R.string.cerrado);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void boton1(View v){

        Intent i = new Intent(this, MapsActivity.class);
        i.putExtra("Lat", 6.3478913);
        i.putExtra("Long", -75.5074894);
        startActivityForResult(i, 1234);
    }

    public void boton2(View v){

        Intent i = new Intent(this, MapsActivity.class);
        i.putExtra("Lat", 6.362925);
        i.putExtra("Long", -75.510964);
        startActivityForResult(i, 1235);
    }

    public void boton3(View v){

        Intent i = new Intent(this, MapsActivity.class);
        i.putExtra("Lat", 6.363898);
        i.putExtra("Long", -75.512581);
        startActivityForResult(i, 1236);
    }

    public void boton11(View v){

        Intent i = new Intent(this, MapsActivity.class);
        i.putExtra("Lat", 6.347825);
        i.putExtra("Long", -75.508524);
        startActivityForResult(i, 1237);
    }

    public void boton12(View v){

        Intent i = new Intent(this, MapsActivity.class);
        i.putExtra("Lat", 6.363651);
        i.putExtra("Long", -75.502949);
        startActivityForResult(i, 1238);
    }

    public void boton13(View v){

        Intent i = new Intent(this, MapsActivity.class);
        i.putExtra("Lat", 6.347825 );
        i.putExtra("Long", -75.508524);
        startActivityForResult(i, 1239);
    }

    public void boton21(View v){

        Intent i = new Intent(this, MapsActivity.class);
        i.putExtra("Lat", 6.327073);
        i.putExtra("Long", -75.496269);
        startActivityForResult(i, 1230);
    }

    public void boton22(View v){

        Intent i = new Intent(this, MapsActivity.class);
        i.putExtra("Lat", 6.3560583);
        i.putExtra("Long", -75.4976177);
        startActivityForResult(i, 1231);
    }

    public void boton23(View v){

        Intent i = new Intent(this, MapsActivity.class);
        i.putExtra("Lat", 6.3762884);
        i.putExtra("Long", -75.4848178);
        startActivityForResult(i, 1232);
    }

    public void boton30(View v){

        Intent i = new Intent(this, MapsActivity.class);
        i.putExtra("Lat", 6.344913);
        i.putExtra("Long", -75.510335);
        startActivityForResult(i, 1233);
    }
}
