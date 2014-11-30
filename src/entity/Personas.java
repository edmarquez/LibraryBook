/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import java.io.Serializable;

public abstract class Personas implements Serializable {

    private String nombre;
    private String DNI;

    //constructor sin parámetros
    public Personas() {
    }

    //constructor con parámetros
    public Personas(String nombre, String DNI) {
        this.nombre = nombre;
        this.DNI = DNI;
    }

    //metodos de acceso a los atributos privados
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    //redefiniendo el método toString de la clase Object
    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nDNI: " + DNI;

    }
}
