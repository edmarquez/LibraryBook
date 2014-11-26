package libreria;

import java.io.Serializable;

public class Administrador extends Personas implements Serializable {

    private String password;

    public Administrador() {
    }

    public Administrador(String nombre, String DNI, String password) {
        super(nombre, DNI);
        this.password = password;

    }

    public String getPassword() {
        return password;
    }   

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nPassword: " + password;

    }
}