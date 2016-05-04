package com.juliannunez.clase5;

/**
 * Created by Usuario on 13/04/2016.
 */
public class Lista_Entrada {

    private int idImagen;
    private  String nombre;
    private String nomnbrePila;
    private String fecha;

    public Lista_Entrada(int idImagen, String nombre, String nomnbrePila, String fecha){
        this.idImagen = idImagen;
        this.nombre = nombre;
        this.nomnbrePila = nomnbrePila;
        this.fecha = fecha;
    }


    public String getNombre() {
        return nombre;
    }



    public int getIdImagen() {
        return idImagen;
    }



    public String getNomnbrePila() {
        return nomnbrePila;
    }


    public String getFecha() {
        return fecha;
    }


}
