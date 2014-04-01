/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.view;

import com.controller.UserController;
import com.repository.UserRepository;
import com.security.UserManager;
import com.view.controller.ConsultaViewController;
import com.view.controller.PacienteViewController;
import com.view.controller.ProntuarioViewController;

/**
 *
 * @author Gustavo
 */
public class Principal extends javax.swing.JFrame {

    private PacienteViewController pacienteViewController;
    private ProntuarioViewController prontuarioViewController;
    private ConsultaViewController consultaViewController;
    private UserManager userManager;
    GerenciamentoConsulta gerenciamentoConsulta;
    GerenciarPaciente gerenciarPaciente;
    BuscarPaciente buscarPaciente;

    public UserManager getUserManager() {
        return userManager;
    }

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    public PacienteViewController getPacienteViewController() {
        return pacienteViewController;
    }

    public void setPacienteViewController(PacienteViewController pacienteViewController) {
        this.pacienteViewController = pacienteViewController;
    }

    public ProntuarioViewController getProntuarioViewController() {
        return prontuarioViewController;
    }

    public void setProntuarioViewController(ProntuarioViewController prontuarioViewController) {
        this.prontuarioViewController = prontuarioViewController;
    }

    public ConsultaViewController getConsultaViewController() {
        return consultaViewController;
    }

    public void setConsultaViewController(ConsultaViewController consultaViewController) {
        this.consultaViewController = consultaViewController;
    }
    
    
    
    /**
     * Creates new form Principal
     */
    public Principal(ConsultaViewController consultaViewController, 
                     PacienteViewController pacienteViewController, 
                     ProntuarioViewController prontuarioViewController, 
                     UserManager userManager) {
        
        this.consultaViewController = consultaViewController;
        this.pacienteViewController = pacienteViewController;
        this.prontuarioViewController = prontuarioViewController;
        this.userManager = userManager;
        
        initComponents();
        buildMenuItens();
        setLocationRelativeTo(null);
    }

    private void buildMenuItens(){        
        
        gerenciamentoConsulta = new GerenciamentoConsulta(new UserController(userManager), pacienteViewController.getController(), consultaViewController.getController());
        try{gerenciamentoConsulta.setMaximum(true);}catch(Exception e){}
        this.container.add(gerenciamentoConsulta);
        
        gerenciarPaciente = new GerenciarPaciente(pacienteViewController);
        try{gerenciarPaciente.setMaximum(true);}catch(Exception e){}
        this.container.add(gerenciarPaciente);
        
        buscarPaciente = new BuscarPaciente(pacienteViewController, gerenciarPaciente);
        try{buscarPaciente.setMaximum(true);}catch(Exception e){}
        this.container.add(buscarPaciente);
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        container = new javax.swing.JPanel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        gerenciamentoDePacienteMenuItem = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        gerenciamentoDeConsultaMenuItem = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 644, Short.MAX_VALUE)
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 689, Short.MAX_VALUE)
        );

        jMenu3.setText("Paciente");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, 0));
        jMenuItem1.setText("Pesquisar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        gerenciamentoDePacienteMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, 0));
        gerenciamentoDePacienteMenuItem.setText("Cadastrar");
        gerenciamentoDePacienteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gerenciamentoDePacienteMenuItemActionPerformed(evt);
            }
        });
        jMenu3.add(gerenciamentoDePacienteMenuItem);

        jMenuBar2.add(jMenu3);

        jMenu4.setText("Consulta");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, 0));
        jMenuItem3.setText("Pesquisar");
        jMenu4.add(jMenuItem3);

        gerenciamentoDeConsultaMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, 0));
        gerenciamentoDeConsultaMenuItem.setText("Cadastrar");
        gerenciamentoDeConsultaMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gerenciamentoDeConsultaMenuItemActionPerformed(evt);
            }
        });
        jMenu4.add(gerenciamentoDeConsultaMenuItem);

        jMenuBar2.add(jMenu4);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void gerenciamentoDeConsultaMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gerenciamentoDeConsultaMenuItemActionPerformed
        gerenciamentoConsulta.refreshFiels();
        gerenciamentoConsulta.setVisible(true);
    }//GEN-LAST:event_gerenciamentoDeConsultaMenuItemActionPerformed

    private void gerenciamentoDePacienteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gerenciamentoDePacienteMenuItemActionPerformed
        gerenciarPaciente.setVisible(true);
    }//GEN-LAST:event_gerenciamentoDePacienteMenuItemActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        buscarPaciente.setVisible(true);
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel container;
    private javax.swing.JMenuItem gerenciamentoDeConsultaMenuItem;
    private javax.swing.JMenuItem gerenciamentoDePacienteMenuItem;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    // End of variables declaration//GEN-END:variables
}
