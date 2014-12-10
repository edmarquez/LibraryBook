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
import entity.Prestamos;
import entity.Usuarios;

/**
 *
 * @author allexiusw
 */
public class PrestamosCRUD {
    private Connection mycon;
    
    public PrestamosCRUD(Connection con){
        this.mycon = con;
    }
    
    public boolean add(Prestamos p){
        PreparedStatement ps;
        try {
            ps = mycon.prepareStatement("INSERT INTO Prestamos VALUES(null,?,?,?,?)");
            ps.setDate(1, p.getFecha());
            ps.setString(2, p.getEstado());
            ps.setString(3, p.getIdLibro());
            ps.setString(4, p.getIdUsuario());
            return (ps.executeUpdate()>0);
        } catch (SQLException ex) {
            Logger.getLogger(PrestamosCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean delete(Prestamos p){
        PreparedStatement ps;
        try {
            ps = mycon.prepareStatement("DELETE FROM Prestamos WHERE id=?");
            ps.setInt(1, p.getId());
            return (ps.executeUpdate()>0);
        } catch (SQLException ex) {
            Logger.getLogger(PrestamosCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
    public boolean update(Prestamos p){
        PreparedStatement ps;
        try {
            ps = mycon.prepareStatement(
                "UPDATE Prestamos "+ 
                "SET fecha=?, estado=?, id_libro=?, id_usuario=? "+ 
                "WHERE id=?"
            );
            ps.setDate(1, p.getFecha());
            ps.setString(2, p.getEstado());
            ps.setString(3, p.getIdLibro());
            ps.setString(4, p.getIdUsuario());
            ps.setInt(5, p.getId());
            return (ps.executeUpdate()>0);
        } catch (SQLException ex) {
            Logger.getLogger(PrestamosCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean updateStateDevuelto(Prestamos p){
        PreparedStatement ps;
        try {
            ps = mycon.prepareStatement(
                "UPDATE Prestamos "+ 
                "SET estado='devuelto' "+ 
                "WHERE id=?"
            );
            ps.setInt(1, p.getId());
            return (ps.executeUpdate()>0);
        } catch (SQLException ex) {
            Logger.getLogger(PrestamosCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public ArrayList<Prestamos> getAll(){
        PreparedStatement ps;
        ArrayList<Prestamos> rows = new ArrayList<>();
        try {
            ps = mycon.prepareStatement("SELECT * FROM Prestamos");
            ResultSet rs = ps.executeQuery();
            if(rs!=null){
                try {
                    while(rs.next()){
                        rows.add(
                            new Prestamos(
                                    rs.getInt("id"),
                                    rs.getDate("fecha"),
                                    rs.getString("estado"),
                                    rs.getString("id_libro"),
                                    rs.getString("id_usuario")
                            )
                        );
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Prestamos.class.getName()).
                            log(Level.SEVERE, null, ex);
                }
            }else{
                System.out.println("Total de registros encontrados es: 0");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PrestamosCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rows;
    }
    
    public ArrayList<Prestamos> getPendientes(){
        PreparedStatement ps;
        ArrayList<Prestamos> rows = new ArrayList<>();
        try {
            ps = mycon.prepareStatement("SELECT DISTINCT Prestamos.*, Libros.nombre as lnombre, Usuarios.nombre as unombre  FROM Prestamos, Libros, Usuarios WHERE Prestamos.id_libro = Libros.codigo AND Prestamos.id_usuario=Usuarios.codigo AND Prestamos.estado='pendiente'");
            ResultSet rs = ps.executeQuery();
            if(rs!=null){
                try {
                    Prestamos p;
                    while(rs.next()){
                        p = new Prestamos(
                            rs.getInt("id"),
                            rs.getDate("fecha"),
                            rs.getString("estado"),
                            rs.getString("id_libro"),
                            rs.getString("id_usuario")
                        );
                        p.setNombreLibro(rs.getString("lnombre"));
                        p.setNombreUsuario(rs.getString("unombre"));
                        rows.add(p);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Prestamos.class.getName()).
                            log(Level.SEVERE, null, ex);
                }
            }else{
                System.out.println("Total de registros encontrados es: 0");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PrestamosCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rows;
    }
    
    public ArrayList<Prestamos> getPendientesByUser(Usuarios u){
        PreparedStatement ps;
        ArrayList<Prestamos> rows = new ArrayList<>();
        try {
            ps = mycon.prepareStatement(
                    "SELECT DISTINCT "
                            + "Prestamos.*, Libros.nombre as lnombre, Usuarios.nombre as unombre "
                        + "FROM "
                            + "Prestamos, Libros, Usuarios "
                        + "WHERE "
                            + "Prestamos.id_usuario=? "
                            + "AND Usuarios.codigo=Prestamos.id_usuario "
                            + "AND Prestamos.id_libro = Libros.codigo "
                            + "AND Prestamos.estado='pendiente' ");
            ps.setString(1, u.getCodigo());
            ResultSet rs = ps.executeQuery();
            if(rs!=null){
                try {
                    Prestamos p;
                    while(rs.next()){
                        p = new Prestamos(
                            rs.getInt("id"),
                            rs.getDate("fecha"),
                            rs.getString("estado"),
                            rs.getString("id_libro"),
                            rs.getString("id_usuario")
                        );
                        p.setNombreLibro(rs.getString("lnombre"));
                        p.setNombreUsuario(rs.getString("unombre"));
                        rows.add(p);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Prestamos.class.getName()).
                            log(Level.SEVERE, null, ex);
                }
            }else{
                System.out.println("Total de registros encontrados es: 0");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PrestamosCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rows;
    }
    
    
    public int getNumeroDePrestamos(Usuarios u){
        int numero = 0;
        PreparedStatement ps;
        try {
            ps = mycon.prepareStatement(
                    "SELECT "
                            + "COUNT(Usuarios.nombre) as total "
                        + "FROM "
                            + "Prestamos, Libros, Usuarios "
                        + "WHERE "
                            + "Prestamos.id_usuario=? "
                            + "AND Usuarios.codigo=Prestamos.id_usuario "
                            + "AND Prestamos.id_libro = Libros.codigo "
                            + "AND Prestamos.estado='pendiente' ");
            ps.setString(1, u.getCodigo());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                numero = rs.getInt("total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PrestamosCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return numero;
    }
    
    
    public ArrayList<Prestamos> getAllByUser(Usuarios u){
        PreparedStatement ps;
        ArrayList<Prestamos> rows = new ArrayList<>();
        try {
            ps = mycon.prepareStatement(
                    "SELECT DISTINCT "
                            + "Prestamos.*, Libros.nombre as lnombre, Usuarios.nombre as unombre "
                        + "FROM "
                            + "Prestamos, Libros, Usuarios "
                        + "WHERE "
                            + "Prestamos.id_usuario=? "
                            + "AND Usuarios.codigo=Prestamos.id_usuario "
                            + "AND Prestamos.id_libro = Libros.codigo "
            );
            ps.setString(1, u.getCodigo());
            ResultSet rs = ps.executeQuery();
            if(rs!=null){
                try {
                    Prestamos p;
                    while(rs.next()){
                        p = new Prestamos(
                            rs.getInt("id"),
                            rs.getDate("fecha"),
                            rs.getString("estado"),
                            rs.getString("id_libro"),
                            rs.getString("id_usuario")
                        );
                        p.setNombreLibro(rs.getString("lnombre"));
                        p.setNombreUsuario(rs.getString("unombre"));
                        rows.add(p);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Prestamos.class.getName()).
                            log(Level.SEVERE, null, ex);
                }
            }else{
                System.out.println("Total de registros encontrados es: 0");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PrestamosCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rows;
    }
    
    public ArrayList<Prestamos> getById(Prestamos p){
        PreparedStatement ps;
        ArrayList<Prestamos> rows = new ArrayList<>();
        try {
            ps = mycon.prepareStatement("SELECT * FROM Prestamos WHERE id=?");
            ps.setInt(1, p.getId());
            ResultSet rs = ps.executeQuery();
            if(rs!=null){
                try {
                    while(rs.next()){
                        rows.add(
                            new Prestamos(
                                rs.getInt("id"), 
                                rs.getDate("fecha"),
                                rs.getString("estado"),
                                rs.getString("id_libro"),
                                rs.getString("id_usuario")
                            )
                        );
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Prestamos.class.getName()).
                            log(Level.SEVERE, null, ex);
                }
            }else{
                System.out.println("Total de registros encontrados es: 0");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PrestamosCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rows;
    }
}
