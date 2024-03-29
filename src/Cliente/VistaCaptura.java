/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * VistaCaptura.java
 *
 * Created on 10-oct-2013, 11:25:16
 */
package Cliente;

import Servidor.Candidato;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class VistaCaptura extends javax.swing.JFrame {

    private Candidato candidato1;
    private Candidato candidato2;
    private ArrayList<Candidato> candidatos;
    private ProxyCliente proxyClientes;

    public VistaCaptura() throws UnknownHostException, IOException {
        initComponents();
         //Inicialización, revisar 
        proxyClientes = new ProxyCliente();
        candidatos = new ArrayList<Candidato>();
        
        //Código de prueba
        candidato1 = new Candidato("Maximiliano de Hadsburgo", "Conservadores");
        candidato2 = new Candidato("Benito Juárez", "Liberales");
        candidatos.add(candidato1);
        candidatos.add(candidato2);
        
        for (int i = 0; i < candidatos.size(); i++) {
            opcionarioCandidatos.addItem(candidatos.get(i).getNombre());
       }
     

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        etiquetaCandidatos = new javax.swing.JLabel();
        opcionarioCandidatos = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        etiquetaCandidatos.setText("Candidatos");

        jButton1.setText("Votar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(opcionarioCandidatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiquetaCandidatos))
                .addContainerGap(314, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(etiquetaCandidatos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(opcionarioCandidatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    proxyClientes.recibirMensaje(procesarOpcion());
    proxyClientes .empaquetarDatos();
        try {
            proxyClientes.enviarMensaje();
        } catch (IOException ex) {
            
        }
}//GEN-LAST:event_jButton1ActionPerformed

/**Sirve para tomar la opción elegida en String y regresarla en tipo Candidato*/
private Candidato procesarOpcion(){
    Candidato candidatoElegido = null;
    for (int i = 0; i < candidatos.size(); i++) {
        if (candidatos.get(i).getNombre().equals(opcionarioCandidatos.getSelectedItem())) {
            candidatoElegido = candidatos.get(i);
            break;
        }
    }
    return candidatoElegido;
}

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
            java.util.logging.Logger.getLogger(VistaCaptura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaCaptura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaCaptura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaCaptura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    new VistaCaptura().setVisible(true);
                } catch (UnknownHostException ex) {
                    Logger.getLogger(VistaCaptura.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(VistaCaptura.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel etiquetaCandidatos;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox opcionarioCandidatos;
    // End of variables declaration//GEN-END:variables
}
