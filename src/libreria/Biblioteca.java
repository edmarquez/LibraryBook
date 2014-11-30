package libreria;
import gui.PantallaPrincipal;
import javax.swing.JFrame;
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
