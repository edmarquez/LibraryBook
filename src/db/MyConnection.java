/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author allexiusw
 */
public class MyConnection {
    public Connection  con = null;
    private static MyConnection instance;
    private MyConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MyConnection.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(MyConnection.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(MyConnection.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        
        try {
            this.con = DriverManager.getConnection(
                    "jdbc:mysql://192.168.56.21:3306/Biblioteca",
                    "testing",
                    "021$"
            );
        } catch (SQLException ex) {
            Logger.getLogger(MyConnection.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }
    
    public static Connection getConnection(){
        if(MyConnection.instance==null){
            MyConnection.instance = new MyConnection();
        }
        return instance.con;
    }
    
}