/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import back.Usuario;
import back.Validadores;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JOptionPane;

/**
 *
 * @author 
 */
public class dlgNuevaCuenta extends javax.swing.JDialog {
    private Validadores validador;
    private Usuario usuario;
    
    /**
     * Creates new form dlgNuevaCuenta
     */
    public dlgNuevaCuenta(java.awt.Frame parent, boolean modal, Usuario usuario) {
        super(parent, modal);
        
        this.usuario = usuario;
        this.validador = new Validadores();
        
        initComponents();
        
        centraCuadroDialogo(parent);
        setVisible(true);
    }

    public void centraCuadroDialogo(java.awt.Frame parent) {
        Dimension frameSize = parent.getSize();
        Point loc = parent.getLocation();
        
        Dimension dlgSize = getPreferredSize();
        
        setLocation((frameSize.width - dlgSize.width) / 2 + loc.x, 
                    (frameSize.height - dlgSize.height) / 2 + loc.y);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JTextField();
        btnCrear = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnRestaurar = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ingresa los datos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        jLabel2.setText("Nombre");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, -1, -1));

        jLabel3.setText("Correo");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, -1, -1));

        jLabel4.setText("Usuario");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, -1));

        jLabel5.setText("Contraseña");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, -1, -1));
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 110, -1));
        getContentPane().add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 110, -1));
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 110, -1));
        getContentPane().add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 110, -1));

        btnCrear.setText("Crear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });
        getContentPane().add(btnCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, -1));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, -1, -1));

        btnRestaurar.setText("Restaurar");
        btnRestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestaurarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRestaurar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, -1, -1));
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestaurarActionPerformed
        txtNombre.setText("");
        txtCorreo.setText("");
        txtUsuario.setText("");
        txtContraseña.setText("");
    }//GEN-LAST:event_btnRestaurarActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        while(true) {
            if(validador.validarNombre(txtNombre.getText())) {
                this.usuario.setNombre(txtNombre.getText());
                break;
            }else {
                JOptionPane.showMessageDialog(this.getParent(), "Formato de nombre incorrecto!!", "Escriba correctamente su nombre.", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        while(true) {
            if(validador.validarCorreo(txtCorreo.getText())) {
                this.usuario.setCorreo(txtCorreo.getText());
                break;
            }else {
                JOptionPane.showMessageDialog(this.getParent(), "Formato de correo incorrecto!!", "Escriba correctamente su correo.", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        while(true) {
            if(validador.validarUsuario(txtUsuario.getText())) {
                this.usuario.setUsuario(txtUsuario.getText());
                break;
            }else {
                JOptionPane.showMessageDialog(this.getParent(), "Formato de usuario incorrecto!!", "Escriba correctamente su usuario.", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        while(true) {
            if(validador.validarCorreo(txtCorreo.getText())) {
                this.usuario.setCorreo(txtCorreo.getText());
                break;
            }else {
                JOptionPane.showMessageDialog(this.getParent(), "Formato de correo incorrecto!!", "Escriba correctamente su correo.", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        
        JOptionPane.showMessageDialog(this.getParent(), "Registro exitoso!", "Su usuario se ha creado exitosamente.", JOptionPane.PLAIN_MESSAGE);
        dispose();
    }//GEN-LAST:event_btnCrearActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnRestaurar;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtContraseña;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
