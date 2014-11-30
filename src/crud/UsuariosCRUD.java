/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import entity.Libros;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import entity.Usuarios;
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
    
    public boolean add(Usuarios u){
        PreparedStatement ps;
        try {
            ps = mycon.prepareStatement("INSERT INTO Usuarios VALUES(?,?,?)");
            ps.setString(1, u.getCodigo());
            ps.setString(2, u.getNombre());
            ps.setString(3, u.getDNI());
            return (ps.executeUpdate()>0);
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public ArrayList<Usuarios> isValid(Usuarios user){
        ArrayList<Usuarios> usuarios = new ArrayList<>();
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
    
    public ArrayList<Usuarios> getAll(){
        PreparedStatement ps;
        ArrayList<Usuarios> usuarios = new ArrayList<>();
        try {
            ps = mycon.prepareStatement("SELECT * FROM Usuarios");
            ResultSet rs = ps.executeQuery();
            if(rs!=null){
                try {
                    while(rs.next()){
                        usuarios.add(
                            new Usuarios(
                                rs.getString("codigo"), 
                                rs.getString("nombre"),
                                rs.getString("dni")
                            )
                        );
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Usuarios.class.getName()).
                            log(Level.SEVERE, null, ex);
                }
            }else{
                System.out.println("Total de registros encontrados es: 0");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LibrosCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return usuarios;
    }
    
    public boolean delete(Usuarios u){
        PreparedStatement ps;
        try {
            ps = mycon.prepareStatement("DELETE FROM Usuarios WHERE codigo=?");
            ps.setString(1, u.getCodigo());
            return (ps.executeUpdate()>0);
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean update(Usuarios u){
        PreparedStatement ps;
        try {
            ps = mycon.prepareStatement(
                "UPDATE Usuarios "+ 
                "SET nombre=?, dni=? "+ 
                "WHERE codigo=?"
            );
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getDNI());
            ps.setString(3, u.getCodigo());
            return (ps.executeUpdate()>0);
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public ArrayList<Usuarios> getById(Usuarios u){
        PreparedStatement ps;
        ArrayList<Usuarios> usuarios = new ArrayList<>();
        try {
            ps = mycon.prepareStatement("SELECT * FROM Usuarios WHERE codigo=?");
            ps.setString(1, u.getCodigo());
            ResultSet rs = ps.executeQuery();
            if(rs!=null){
                try {
                    while(rs.next()){
                        usuarios.add(
                            new Usuarios(
                                rs.getString("codigo"), 
                                rs.getString("nombre"),
                                rs.getString("dni")
                            )
                        );
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Usuarios.class.getName()).
                            log(Level.SEVERE, null, ex);
                }
            }else{
                System.out.println("Total de registros encontrados es: 0");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return usuarios;
    }
    
    
    public ArrayList<Usuarios> getByNombre(Usuarios u){
        PreparedStatement ps;
        ArrayList<Usuarios> usuarios = new ArrayList<>();
        try {
            ps = mycon.prepareStatement("SELECT * FROM Usuarios WHERE nombre LIKE ?");
            ps.setString(1, "%"+u.getNombre()+"%");
            ResultSet rs = ps.executeQuery();
            if(rs!=null){
                try {
                    while(rs.next()){
                        usuarios.add(
                            new Usuarios(
                                rs.getString("codigo"), 
                                rs.getString("nombre"),
                                rs.getString("dni")
                            )
                        );
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Usuarios.class.getName()).
                            log(Level.SEVERE, null, ex);
                }
            }else{
                System.out.println("Total de registros encontrados es: 0");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return usuarios;
    }
    
    public ArrayList<Usuarios> getByDNI(Usuarios u){
        PreparedStatement ps;
        ArrayList<Usuarios> usuarios = new ArrayList<>();
        try {
            ps = mycon.prepareStatement("SELECT * FROM Usuarios WHERE dni=?");
            ps.setString(1, u.getDNI());
            ResultSet rs = ps.executeQuery();
            if(rs!=null){
                try {
                    while(rs.next()){
                        usuarios.add(
                            new Usuarios(
                                rs.getString("codigo"), 
                                rs.getString("nombre"),
                                rs.getString("dni")
                            )
                        );
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Usuarios.class.getName()).
                            log(Level.SEVERE, null, ex);
                }
            }else{
                System.out.println("Total de registros encontrados es: 0");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return usuarios;
    }
}
