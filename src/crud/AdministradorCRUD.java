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
import entity.Administrador;

/**
 *
 * @author allexiusw
 */
public class AdministradorCRUD{
    Connection mycon;
    
    public AdministradorCRUD(Connection con) {
        this.mycon = con;
    }
    
    public boolean checkAccess(Administrador admin){
        try {
            PreparedStatement ps =
                    this.mycon.prepareStatement("SELECT * FROM Administradores WHERE userName=? AND passwd=?");
            ps.setString(1, admin.getNombre());
            ps.setString(2, admin.getPassword());
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
