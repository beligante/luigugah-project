/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.view;

import com.controller.ConsultaController;
import com.controller.PacienteController;
import com.controller.UserController;
import com.domain.Consulta;
import com.domain.Medico;
import com.domain.Paciente;
import com.enums.TipoConsulta;
import com.repository.Repository;
import com.repository.UserRepository;
import com.utils.StringUtils;
import com.view.controller.ConsultaViewController;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import sun.swing.StringUIClientPropertyKey;

/**
 *
 * @author Gustavo
 */
public class GerenciamentoConsulta extends javax.swing.JInternalFrame {

    private UserController userController;
    private PacienteController pacienteController;
    private ConsultaViewController consultaViewController;
    private boolean isEditing;
    private Consulta consulta;
    
    private static final SimpleDateFormat DATA_SEM_HORA_SDF = new SimpleDateFormat("dd/MM/yyyy");
    private static final SimpleDateFormat HORA_SDF = new SimpleDateFormat("HH:mm");
    
    /**
     * Creates new form GerenciamentoConsulta
     */
    public GerenciamentoConsulta(UserController userController, PacienteController pacienteController,ConsultaViewController  consultaViewController) {
        super();
        this.userController = userController;
        this.pacienteController = pacienteController;
        this.consultaViewController = consultaViewController;
        initComponents();
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
        jLabel6 = new javax.swing.JLabel();
        dataConsultaTextField = new javax.swing.JFormattedTextField();
        horaConsultaTextField = new javax.swing.JFormattedTextField();
        selectMedico = new javax.swing.JComboBox();
        selectPessoa = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        selectTipoConsulta = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel1.setText("Gereciamento de Consulta");

        jLabel2.setText("Data Consulta (dd/mm/aaaa)");

        jLabel3.setText("Horario consulta (hh:mm)");

        jLabel4.setText("Medico");

        jLabel5.setText("Paciente");

        jLabel6.setText("Tipo Consulta");

        dataConsultaTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        horaConsultaTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT))));

        selectMedico.setModel(new DefaultComboBoxModel(userController.getAllMedicos().toArray())
        );

        selectPessoa.setEditable(true);
        selectPessoa.setModel(new DefaultComboBoxModel(pacienteController.getAll().toArray()));
        selectPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectPessoaActionPerformed(evt);
            }
        });

        jButton1.setText("Salvar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        selectTipoConsulta.setModel(new DefaultComboBoxModel(TipoConsulta.values())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(28, 28, 28))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2)
                            .addComponent(selectMedico, 0, 199, Short.MAX_VALUE)
                            .addComponent(dataConsultaTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                            .addComponent(horaConsultaTextField)
                            .addComponent(selectPessoa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(selectTipoConsulta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(dataConsultaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(horaConsultaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectTipoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selectPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectPessoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectPessoaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        //START VALIDATION CODE
        if(StringUtils.isBlank(this.dataConsultaTextField.getText())){
            JOptionPane.showMessageDialog(this, "Especifique a data da consulta.");
            return;
        }
        if(StringUtils.isBlank(this.horaConsultaTextField.getText())){
            JOptionPane.showMessageDialog(this, "Especifique a hora da consulta.");
            return;
        }
        //END VALIDATION CODE
        
        SimpleDateFormat fullDataConsulta = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        
        Date dataConsulta = null;
        try{
            dataConsulta = fullDataConsulta.parse(dataConsultaTextField.getText() + 
                                                  " " +
                                                  horaConsultaTextField.getText());
        }catch(Exception e){}
        
        TipoConsulta tipoConsulta = (TipoConsulta) selectTipoConsulta.getModel().getSelectedItem();
        
        if(consultaViewController.getController().isExisteConsultaMarcadaParaHorario(dataConsulta, tipoConsulta)){
            //JOPTIONPANE MESSAGE AQUI
            return;
        }
        
        Medico medico = (Medico) selectMedico.getModel().getSelectedItem();
        Paciente paciente = (Paciente) selectPessoa.getModel().getSelectedItem();
        
        Consulta consulta = (isEditing) ? this.consulta :new Consulta();
        consulta.setDataConsulta(dataConsulta);
        consulta.setTipoConsulta(tipoConsulta);
        consulta.setPaciente(paciente);
        consulta.setMedico(medico);
        
        consultaViewController.getController().save(consulta);
        this.setVisible(false);
        if(isEditing){
            JOptionPane.showMessageDialog(this, "Consulta editada com Sucesso!");
        }else{
            JOptionPane.showMessageDialog(this, "Consulta salva com Sucesso!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(GerenciamentoConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GerenciamentoConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GerenciamentoConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GerenciamentoConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new GerenciamentoConsulta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField dataConsultaTextField;
    private javax.swing.JFormattedTextField horaConsultaTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JComboBox selectMedico;
    private javax.swing.JComboBox selectPessoa;
    private javax.swing.JComboBox selectTipoConsulta;
    // End of variables declaration//GEN-END:variables

    void refreshFiels() {
        selectPessoa.setModel(new DefaultComboBoxModel(pacienteController.getAll().toArray()));
        selectMedico.setModel(new DefaultComboBoxModel(userController.getAllMedicos().toArray()));

    }

    void editarConsulta(Consulta consulta) {
        if(consulta == null){isEditing = false; return;}
        
        this.consulta = consulta;
        
        dataConsultaTextField.setText(DATA_SEM_HORA_SDF.format(consulta.getDataConsulta()));
        horaConsultaTextField.setText(HORA_SDF.format(consulta.getDataConsulta()));
        
        refreshFiels();
        
        selectMedico.setSelectedItem(consulta.getMedico());
        selectPessoa.setSelectedItem(consulta.getPaciente());
        selectTipoConsulta.setSelectedItem(consulta.getTipoConsulta());
        
        this.setVisible(true);
    }
}
