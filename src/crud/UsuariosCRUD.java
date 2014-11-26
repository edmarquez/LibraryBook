/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import libreria.Usuarios;
import java.util.ArrayList;

/**
 *
 * @author allexiusw
 */
public class UsuariosCRUD {
    Connection mycon;
    
    public UsuariosCRUD(Connection con) {
        this.mycon = con;
    }
    
    public ArrayList<Usuarios> isValid(Usuarios user){
        ArrayList<Usuarios> usuarios = null;
        try {
            PreparedStatement ps =
                    this.mycon.prepareStatement("SELECT * FROM Usuarios WHERE codigo=?");
            ps.setString(1, user.getCodigo());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Usuarios us = new Usuarios(
                    rs.getString("codigo"), 
                    rs.getString("nombre"), 
                    rs.getString("dni")
                );
                usuarios.add(us);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }
}
