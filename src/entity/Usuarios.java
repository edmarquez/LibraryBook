/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import java.io.Serializable;
import libreria.Personas;

public class Usuarios extends Personas implements Serializable {

    private String codigo;
    //private Libro lib;

    public Usuarios() {
    }

    public Usuarios(String codigo, String nombre, String DNI) {
        super(nombre, DNI);
        this.codigo = codigo;

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nCodigo de Estudiante: " + codigo;
    }
}
