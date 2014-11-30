/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import java.io.Serializable;
/**
 *
 * @author allexiusw
 */
public class Libros implements Serializable {
    private String codigolibro;
    private String nombrelibro;
    private String titulolibro;
    private String autorlibro;
    private int cantidad = 0;

    public Libros() {
    }

    public Libros(String cl, String nl, String tl, String al, int cant) {
        this.codigolibro = cl;
        this.nombrelibro = nl;
        this.titulolibro = tl;
        this.autorlibro = al;
        this.cantidad = cant;

    }

    public String getNombrelibro() {
        return nombrelibro;
    }

    public void setNombrelibro(String nombrelibro) {
        this.nombrelibro = nombrelibro;
    }

    public String getCodigolibro() {
        return codigolibro;
    }

    public void setCodigolibro(String codigolibro) {
        this.codigolibro = codigolibro;
    }

    public String getTitulolibro() {
        return titulolibro;
    }

    public void setTitulolibro(String titulolibro) {
        this.titulolibro = titulolibro;
    }

    public String getAutorlibro() {
        return autorlibro;
    }

    public void setAutorlibro(String autorlibro) {
        this.autorlibro = autorlibro;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    

    @Override
    public String toString() {
        return "Codigo: " + codigolibro
            + "\nTitulo: " + titulolibro
            + "\nAutor : " + autorlibro
            + "cantidad: " + cantidad;
    }
}
