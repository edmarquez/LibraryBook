package libreria;
import crud.AdministradorCRUD;
import db.MyConnection;
import gui.PantallaPrincipal;
import javax.swing.JFrame;
import java.sql.Connection;
import javax.swing.JOptionPane;
/**
 *
 * @author allexiusw
 */
public class Biblioteca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PantallaPrincipal pp = new PantallaPrincipal();
        pp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pp.setVisible(true);
    }
    
}
