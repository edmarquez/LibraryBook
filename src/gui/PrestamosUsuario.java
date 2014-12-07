/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import crud.LibrosCRUD;
import crud.PrestamosCRUD;
import db.MyConnection;
import entity.Libros;
import entity.Prestamos;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.Date;
import java.util.Calendar;
/**
 *
 * @author allexiusw
 */
public class PrestamosUsuario extends javax.swing.JDialog {

    /**
     * Creates new form ModuloLibros
     */
    public PrestamosUsuario() {
        setModal(true);
        initComponents();
        crearModelo();
        this.getRootPane().setDefaultButton(btnBuscar);
        btnBuscar.setVisible(false);
    }
    //@method crearModelo permite crear la estructura de la tabla
    public void crearModelo(){
        jTable1 = new JTable();
        jTable1.setModel(
            new DefaultTableModel(
                new Object[][]{},
                new String[]{"Nombre","Autor", "Cantidad", "Prestados", "Object"}
            )
        );
        jScrollPane1.setViewportView(jTable1);
        jTable1.removeColumn(jTable1.getColumn("Object"));
    }
    
    public void volcarDatos(ArrayList<Libros> rows){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        while(model.getRowCount()>0)model.removeRow(0);
        for(Libros row : rows){
            Object[] fila = {
                    row.getNombrelibro(),
                    row.getAutorlibro(), 
                    row.getCantidad(),
                    row.getPrestados(),
                    row
            };
            model.addRow(fila);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        btnPrestar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jLabel1.setText("Interfaz para prestamo de Libros");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnPrestar.setText("Prestar");
        btnPrestar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrestarActionPerformed(evt);
            }
        });

        jLabel2.setText("Buscar:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Por Nombre", "Por Autor" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(293, 293, 293)
                        .addComponent(btnPrestar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar)))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrestar)
                    .addComponent(btnBuscar))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrestarActionPerformed
        String text = txtBuscar.getText().toString();
        ArrayList<Libros> rows = new ArrayList<>();
        LibrosCRUD pdao =  new LibrosCRUD(MyConnection.getConnection());
        Libros lib;
        if(jTable1.getModel().getValueAt(
            jTable1.getSelectedRow(), 2)==jTable1.getModel().getValueAt(
            jTable1.getSelectedRow(), 3)){
            JOptionPane.showMessageDialog(this, "Este Libro se encuentra en prestamo");
        }else{
            Libros lb = (Libros) jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 4);
            PrestamosCRUD p = new PrestamosCRUD(MyConnection.getConnection());
            Calendar cal = Calendar.getInstance();
            Prestamos pnew =  new Prestamos(0, new Date(cal.getTimeInMillis()), "pendiente", lb.getCodigolibro(), MenuPrincipalViews.user.getCodigo());
            if(p.add(pnew)){
                LibrosCRUD crud = new LibrosCRUD(MyConnection.getConnection());
                crud.updatePrestado(lb);
                JOptionPane.showMessageDialog(this, "Prestamo registrado correctamente!!!");
                if(text.isEmpty()){
                    rows = pdao.getAll();
                }else{
                    lib = new Libros("", text, "", "", 0);
                    String option = jComboBox1.getSelectedItem().toString();
                    switch(option){
                        case "Por Nombre":
                            rows = pdao.getByNombre(lib);
                            break;

                        case "Por Autor":
                            rows = pdao.getByAutor(lib);
                            break;
                    }
                }
                volcarDatos(rows);
            }
            //volcarDatos(usuarios);
        }
    }//GEN-LAST:event_btnPrestarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String text = txtBuscar.getText().toString();
        LibrosCRUD pdao =  new LibrosCRUD(MyConnection.getConnection());
        ArrayList<Libros> rows = new ArrayList<>();
        Libros p;
        if(text.isEmpty()){
            rows = pdao.getAll();
        }else{
            String option = jComboBox1.getSelectedItem().toString();
            switch(option){
                case "Por Nombre":
                    p = new Libros("", text, "", "", 0);
                    rows = pdao.getByNombre(p);
                    break;
                    
                case "Por Autor":
                    p = new Libros("", "", "", text, 0);
                    rows = pdao.getByAutor(p);
                    break;
            }
        }
        volcarDatos(rows);
    }//GEN-LAST:event_btnBuscarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PrestamosUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrestamosUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrestamosUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrestamosUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrestamosUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnPrestar;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
