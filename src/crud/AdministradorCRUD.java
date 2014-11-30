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
import java.util.ArrayList;

/**
 *
 * @author allexiusw
 */
public class AdministradorCRUD{
    Connection mycon;
    
    public AdministradorCRUD(Connection con) {
        this.mycon = con;
    }
    
    public boolean add(Administrador admin){
        PreparedStatement ps;
        try {
            ps = mycon.prepareStatement("INSERT INTO Administradores VALUES(?,?,?)");
            ps.setString(1, admin.getNombre());
            ps.setString(2, admin.getPassword());
            ps.setString(3, admin.getDNI());
            return (ps.executeUpdate()>0);
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
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
    
    public ArrayList<Administrador> getAll(){
        PreparedStatement ps;
        ArrayList<Administrador> admins = new ArrayList<>();
        try {
            ps = mycon.prepareStatement("SELECT * FROM Administradores");
            ResultSet rs = ps.executeQuery();
            if(rs!=null){
                try {
                    while(rs.next()){
                        admins.add(
                            new Administrador(
                                rs.getString("userName"), 
                                rs.getString("passwd"),
                                rs.getString("dni")
                            )
                        );
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Administrador.class.getName()).
                            log(Level.SEVERE, null, ex);
                }
            }else{
                System.out.println("Total de registros encontrados es: 0");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return admins;
    }
    
    public boolean delete(Administrador admin){
        PreparedStatement ps;
        try {
            ps = mycon.prepareStatement("DELETE FROM Administradores WHERE userName=?");
            ps.setString(1, admin.getNombre());
            return (ps.executeUpdate()>0);
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean update(Administrador admin){
        PreparedStatement ps;
        try {
            ps = mycon.prepareStatement(
                "UPDATE Administradores "+ 
                "SET passwd=?, dni=? "+ 
                "WHERE userName=?"
            );
            ps.setString(1, admin.getPassword());
            ps.setString(2, admin.getDNI());
            ps.setString(3, admin.getNombre());
            return (ps.executeUpdate()>0);
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public ArrayList<Administrador> getById(Administrador admin){
        PreparedStatement ps;
        ArrayList<Administrador> admins = new ArrayList<>();
        try {
            ps = mycon.prepareStatement("SELECT * FROM Administradores WHERE userName=?");
            ps.setString(1, admin.getNombre());
            ResultSet rs = ps.executeQuery();
            if(rs!=null){
                try {
                    while(rs.next()){
                        admins.add(
                            new Administrador(
                                rs.getString("userName"), 
                                rs.getString("passwd"),
                                rs.getString("dni")
                            )
                        );
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Administrador.class.getName()).
                            log(Level.SEVERE, null, ex);
                }
            }else{
                System.out.println("Total de registros encontrados es: 0");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return admins;
    }
    
    
    public ArrayList<Administrador> getByNombre(Administrador admin){
        PreparedStatement ps;
        ArrayList<Administrador> admins = new ArrayList<>();
        try {
            ps = mycon.prepareStatement("SELECT * FROM Administradores WHERE userName LIKE ?");
            ps.setString(1, "%"+admin.getNombre()+"%");
            ResultSet rs = ps.executeQuery();
            if(rs!=null){
                try {
                    while(rs.next()){
                        admins.add(
                            new Administrador(
                                rs.getString("userName"), 
                                rs.getString("passwd"),
                                rs.getString("dni")
                            )
                        );
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Administrador.class.getName()).
                            log(Level.SEVERE, null, ex);
                }
            }else{
                System.out.println("Total de registros encontrados es: 0");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return admins;
    }
    
    public ArrayList<Administrador> getByDNI(Administrador admin){
        PreparedStatement ps;
        ArrayList<Administrador> admins = new ArrayList<>();
        try {
            ps = mycon.prepareStatement("SELECT * FROM Administradores WHERE dni=?");
            ps.setString(1, admin.getDNI());
            ResultSet rs = ps.executeQuery();
            if(rs!=null){
                try {
                    while(rs.next()){
                        admins.add(
                            new Administrador(
                                rs.getString("userName"), 
                                rs.getString("passwd"),
                                rs.getString("dni")
                            )
                        );
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Administrador.class.getName()).
                            log(Level.SEVERE, null, ex);
                }
            }else{
                System.out.println("Total de registros encontrados es: 0");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return admins;
    }
    
}
