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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import libreria.Libros;

/**
 *
 * @author allexiusw
 */
public class LibrosCRUD {
    private Connection mycon;
    
    public LibrosCRUD(Connection con){
        this.mycon = con;
    }
    
    public boolean add(Libros l){
        PreparedStatement ps;
        try {
            ps = mycon.prepareStatement("INSERT INTO Libros VALUES(?,?,?,?,?)");
            ps.setString(1, l.getCodigolibro());
            ps.setString(2, l.getNombrelibro());
            ps.setString(3, l.getTitulolibro());
            ps.setString(4, l.getAutorlibro());
            ps.setInt(5, l.getCantidad());
            return (ps.executeUpdate()>0);
        } catch (SQLException ex) {
            Logger.getLogger(LibrosCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean delete(Libros l){
        PreparedStatement ps;
        try {
            ps = mycon.prepareStatement("DELETE FROM Libros WHERE codigo=?");
            ps.setString(1, l.getCodigolibro());
            return (ps.executeUpdate()>0);
        } catch (SQLException ex) {
            Logger.getLogger(LibrosCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
    public boolean update(Libros l){
        PreparedStatement ps;
        try {
            ps = mycon.prepareStatement(
                "UPDATE Libros "+ 
                "SET nombre=?, titulo=?, autor=?, cantidad=? "+ 
                "WHERE codigo=?"
            );
            ps.setString(1, l.getNombrelibro());
            ps.setString(2, l.getTitulolibro());
            ps.setString(3, l.getAutorlibro());
            ps.setInt(4, l.getCantidad());
            ps.setString(5, l.getCodigolibro());
            return (ps.executeUpdate()>0);
        } catch (SQLException ex) {
            Logger.getLogger(LibrosCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public ArrayList<Libros> getAll(){
        PreparedStatement ps;
        ArrayList<Libros> libros = new ArrayList<>();
        try {
            ps = mycon.prepareStatement("SELECT * FROM Libros");
            ResultSet rs = ps.executeQuery();
            if(rs!=null){
                try {
                    while(rs.next()){
                        libros.add(
                            new Libros(
                                rs.getString("codigo"), 
                                rs.getString("nombre"),
                                rs.getString("titulo"),
                                rs.getString("autor"),
                                rs.getInt("cantidad")
                            )
                        );
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Libros.class.getName()).
                            log(Level.SEVERE, null, ex);
                }
            }else{
                System.out.println("Total de registros encontrados es: 0");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LibrosCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return libros;
    }
    public ArrayList<Libros> getById(Libros l){
        PreparedStatement ps;
        ArrayList<Libros> libros = new ArrayList<>();
        try {
            ps = mycon.prepareStatement("SELECT * FROM Libros WHERE codigo=?");
            ps.setString(1, l.getCodigolibro());
            ResultSet rs = ps.executeQuery();
            if(rs!=null){
                try {
                    while(rs.next()){
                        libros.add(
                            new Libros(
                                rs.getString("codigo"), 
                                rs.getString("nombre"),
                                rs.getString("titulo"),
                                rs.getString("autor"),
                                rs.getInt("cantidad")
                            )
                        );
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Libros.class.getName()).
                            log(Level.SEVERE, null, ex);
                }
            }else{
                System.out.println("Total de registros encontrados es: 0");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LibrosCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return libros;
    }
}
