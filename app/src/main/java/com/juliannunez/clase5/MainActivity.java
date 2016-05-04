package com.juliannunez.clase5;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Lista_Entrada [] datos = new Lista_Entrada [] {
            new Lista_Entrada(R.drawable.superman, "Superman", "Clark Kent" ,"1938"),
            new Lista_Entrada(R.drawable.batman, "Batman", "Bruce Wayne", "1939"),
            new Lista_Entrada(R.drawable.flash, "Flash", "Barry Allen  " , "1940"),};
    ListView lstNombres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Adapter adaptador = new Adapter(this, datos);

        lstNombres = (ListView)findViewById(R.id.lista);
        lstNombres.setAdapter(adaptador);

        lstNombres.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String opSel = ((Lista_Entrada)parent.getItemAtPosition(position)).getNombre();

                Toast.makeText(MainActivity.this, opSel, Toast.LENGTH_SHORT).show();
            }
        });
    }

    class Adapter extends ArrayAdapter<Lista_Entrada>{

        public Adapter (Context context, Lista_Entrada[] datos){
            super(context, R.layout.listitem, datos);
        }

        public View getView(int position, View convertView, ViewGroup parent){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.listitem, null);

            TextView nombre = (TextView) item.findViewById(R.id.tNombre);
            nombre.setText(datos[position].getNombre());
            TextView nombrePila = (TextView) item.findViewById(R.id.tNombrePila);
            nombrePila.setText(datos[position].getNomnbrePila());
            TextView year = (TextView) item.findViewById(R.id.Fecha);
            year.setText(datos[position].getFecha());
            ImageView imagen = (ImageView) item.findViewById(R.id.imagen);
            imagen.setImageResource(datos[position].getIdImagen());

            return item;
        }
    }
}
