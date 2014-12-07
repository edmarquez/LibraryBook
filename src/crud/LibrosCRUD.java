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
import entity.Libros;

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
            ps = mycon.prepareStatement("INSERT INTO Libros VALUES(?,?,?,?,?,?)");
            ps.setString(1, l.getCodigolibro());
            ps.setString(2, l.getNombrelibro());
            ps.setString(3, l.getTitulolibro());
            ps.setString(4, l.getAutorlibro());
            ps.setInt(5, l.getCantidad());
            ps.setInt(5, l.getPrestados());
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
    
    
    public boolean updatePrestados(Libros l){
        PreparedStatement ps;
        try {
            ps = mycon.prepareStatement(
                "UPDATE Libros "+ 
                "SET prestados=prestados+1 "+ 
                "WHERE codigo=?"
            );
            ps.setString(1, l.getCodigolibro());
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
                        Libros l = new Libros(
                                rs.getString("codigo"), 
                                rs.getString("nombre"),
                                rs.getString("titulo"),
                                rs.getString("autor"),
                                rs.getInt("cantidad")
                            );
                        l.setPrestados(rs.getInt("prestados"));
                        libros.add(l);
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
                        Libros l1 = new Libros(
                                rs.getString("codigo"), 
                                rs.getString("nombre"),
                                rs.getString("titulo"),
                                rs.getString("autor"),
                                rs.getInt("cantidad")
                        );
                        l1.setPrestados(rs.getInt("prestados"));
                        libros.add(l1);
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
    
    public ArrayList<Libros> getByNombre(Libros l){
        PreparedStatement ps;
        ArrayList<Libros> libros = new ArrayList<>();
        try {
            ps = mycon.prepareStatement("SELECT * FROM Libros WHERE nombre LIKE ?");
            ps.setString(1, "%"+l.getNombrelibro()+"%");
            ResultSet rs = ps.executeQuery();
            if(rs!=null){
                try {
                    while(rs.next()){
                        Libros l1 = new Libros(
                                rs.getString("codigo"), 
                                rs.getString("nombre"),
                                rs.getString("titulo"),
                                rs.getString("autor"),
                                rs.getInt("cantidad")
                        );
                        l1.setPrestados(rs.getInt("prestados"));
                        libros.add(l1);
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
    
    
    public ArrayList<Libros> getByTitulo(Libros l){
        PreparedStatement ps;
        ArrayList<Libros> libros = new ArrayList<>();
        try {
            ps = mycon.prepareStatement("SELECT * FROM Libros WHERE titulo LIKE ?");
            ps.setString(1, "%"+l.getTitulolibro()+"%");
            ResultSet rs = ps.executeQuery();
            if(rs!=null){
                try {
                    while(rs.next()){
                        Libros l1 = new Libros(
                                rs.getString("codigo"), 
                                rs.getString("nombre"),
                                rs.getString("titulo"),
                                rs.getString("autor"),
                                rs.getInt("cantidad")
                        );
                        l1.setPrestados(rs.getInt("prestados"));
                        libros.add(l1);
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
    
    public ArrayList<Libros> getByAutor(Libros l){
        PreparedStatement ps;
        ArrayList<Libros> libros = new ArrayList<>();
        try {
            ps = mycon.prepareStatement("SELECT * FROM Libros WHERE autor LIKE ?");
            ps.setString(1, "%"+l.getAutorlibro()+"%");
            ResultSet rs = ps.executeQuery();
            if(rs!=null){
                try {
                    while(rs.next()){
                        Libros l1 = new Libros(
                                rs.getString("codigo"), 
                                rs.getString("nombre"),
                                rs.getString("titulo"),
                                rs.getString("autor"),
                                rs.getInt("cantidad")
                        );
                        l1.setPrestados(rs.getInt("prestados"));
                        libros.add(l1);
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
