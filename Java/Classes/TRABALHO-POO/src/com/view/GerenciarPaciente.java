/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.view;

import com.controller.ProntuarioController;
import com.domain.Paciente;
import com.domain.Secretaria;
import com.enums.Sexo;
import com.enums.TipoAtendimento;
import com.utils.CollectionUtils;
import com.utils.StringUtils;
import com.view.controller.PacienteViewController;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Junior
 */
public class GerenciarPaciente extends javax.swing.JInternalFrame {

    private PacienteViewController pacienteViewController;
    private Paciente paciente;
    private boolean isEditing;
    private boolean isInitialized;
    private static final SimpleDateFormat DATA_NASCIMENTO_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    private ProntuarioController prontuarioController;

    /**
     * Creates new form GerenciarPaciente
     */
    public GerenciarPaciente(PacienteViewController pacienteViewController) {
        this.pacienteViewController = pacienteViewController;
        initComponents();
        isEditing = false;
        disableFieldsByUser();
        isInitialized = true;
    }

    public GerenciarPaciente(PacienteViewController pacienteViewController, Paciente paciente) {
        this.pacienteViewController = pacienteViewController;
        initComponents();

        if (paciente != null) {
            isEditing = true;
            editarPaciente(paciente);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        pacienteTipoAtendimento = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        pacienteIsFumante = new javax.swing.JCheckBox();
        pacienteIsAlcolatra = new javax.swing.JCheckBox();
        pacienteIsDiabetico = new javax.swing.JCheckBox();
        pacienteIsCardiaco = new javax.swing.JCheckBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        pacienteCirurgias = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        pacienteAlergias = new javax.swing.JTable();
        pacienteColesterol = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        pacienteName = new javax.swing.JTextField();
        pacienteCPF = new javax.swing.JTextField();
        pacienteRG = new javax.swing.JTextField();
        pacienteSexo = new javax.swing.JComboBox();
        pacienteTelefone = new javax.swing.JTextField();
        pacienteDataNascimento = new javax.swing.JFormattedTextField();
        pacienteEndereco = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        pacienteEmail = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        pacienteButtomSalvar = new javax.swing.JButton();
        pacienteButtomCancelar = new javax.swing.JButton();
        pacienteButtomCirurgiasAdicionar = new javax.swing.JButton();
        pacienteButtomAlergiasAdicionar = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();

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

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pacienteTipoAtendimento.setModel(new DefaultComboBoxModel(TipoAtendimento.values()));

        jLabel1.setText("Tipo do atendimento");

        pacienteIsFumante.setText("Fuma");
        pacienteIsFumante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pacienteIsFumanteActionPerformed(evt);
            }
        });

        pacienteIsAlcolatra.setText("Bebe");

        pacienteIsDiabetico.setText("Diabetico");

        pacienteIsCardiaco.setText("Cardiaco");

        pacienteCirurgias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cirurgias"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(pacienteCirurgias);

        pacienteAlergias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Alergias"
            }
        ));
        jScrollPane4.setViewportView(pacienteAlergias);

        pacienteColesterol.setText("0");

        jLabel3.setText("Colesterol");

        jLabel4.setText("Nome");

        jLabel5.setText("CPF");

        jLabel6.setText("RG");

        jLabel7.setText("Data de nascimento (dd/mm/yyyy)");

        jLabel8.setText("Endereço");

        jLabel9.setText("Telefone");

        jLabel10.setText("E-mail");

        jLabel11.setText("Sexo");

        pacienteSexo.setModel(new DefaultComboBoxModel(Sexo.values()));
        pacienteSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pacienteSexoActionPerformed(evt);
            }
        });

        pacienteDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        pacienteDataNascimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pacienteDataNascimentoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Gerenciamento de Paciente");

        pacienteButtomSalvar.setText("Salvar");
        pacienteButtomSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pacienteButtomSalvarActionPerformed(evt);
            }
        });

        pacienteButtomCancelar.setText("Cancelar");
        pacienteButtomCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pacienteButtomCancelarActionPerformed(evt);
            }
        });

        pacienteButtomCirurgiasAdicionar.setText("Adicionar");
        pacienteButtomCirurgiasAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pacienteButtomCirurgiasAdicionarActionPerformed(evt);
            }
        });

        pacienteButtomAlergiasAdicionar.setText("Adicionar");
        pacienteButtomAlergiasAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pacienteButtomAlergiasAdicionarActionPerformed(evt);
            }
        });

        removeButton.setText("Remover");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pacienteColesterol, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(pacienteButtomCirurgiasAdicionar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pacienteButtomAlergiasAdicionar)
                .addGap(76, 76, 76))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel5)
                        .addGap(4, 4, 4)
                        .addComponent(pacienteCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel6)
                        .addGap(4, 4, 4)
                        .addComponent(pacienteRG, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel9)
                        .addGap(4, 4, 4)
                        .addComponent(pacienteTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel11)
                        .addGap(7, 7, 7)
                        .addComponent(pacienteSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel10)
                        .addGap(4, 4, 4)
                        .addComponent(pacienteEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel7)
                        .addGap(4, 4, 4)
                        .addComponent(pacienteDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel8)
                        .addGap(4, 4, 4)
                        .addComponent(pacienteEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pacienteIsFumante)
                                .addGap(19, 19, 19)
                                .addComponent(pacienteIsCardiaco))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pacienteIsAlcolatra)
                                .addGap(21, 21, 21)
                                .addComponent(pacienteIsDiabetico))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pacienteTipoAtendimento, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(pacienteButtomSalvar)
                        .addGap(18, 18, 18)
                        .addComponent(pacienteButtomCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(removeButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel4)
                        .addGap(4, 4, 4)
                        .addComponent(pacienteName, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel2)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel4))
                    .addComponent(pacienteName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pacienteCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pacienteRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(pacienteTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel11))
                    .addComponent(pacienteSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel10))
                    .addComponent(pacienteEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pacienteDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel8))
                    .addComponent(pacienteEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pacienteTipoAtendimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pacienteIsFumante)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(pacienteColesterol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pacienteIsCardiaco))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pacienteIsAlcolatra)
                    .addComponent(pacienteIsDiabetico))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pacienteButtomCirurgiasAdicionar)
                            .addComponent(pacienteButtomAlergiasAdicionar))
                        .addGap(0, 49, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 49, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pacienteButtomCancelar)
                            .addComponent(pacienteButtomSalvar)
                            .addComponent(removeButton))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pacienteIsFumanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pacienteIsFumanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pacienteIsFumanteActionPerformed

    private void pacienteSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pacienteSexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pacienteSexoActionPerformed

    private void pacienteDataNascimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pacienteDataNascimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pacienteDataNascimentoActionPerformed

    private void pacienteButtomSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pacienteButtomSalvarActionPerformed

        //START VALIDATION CODES
        if (StringUtils.isBlank(this.pacienteName.getText())) {
            JOptionPane.showMessageDialog(this, "Especifique o nome do paciente.");
            return;
        }
        if (StringUtils.isBlank(this.pacienteCPF.getText())) {
            JOptionPane.showMessageDialog(this, "Especifique o CPF do paciente.");
            return;
        }
        if (StringUtils.isBlank(this.pacienteRG.getText())) {
            JOptionPane.showMessageDialog(this, "Especifique o RG do paciente.");
            return;
        }
        if (StringUtils.isBlank(this.pacienteName.getText())) {
            JOptionPane.showMessageDialog(this, "Especifique o nome do paciente.");
            return;
        }
        if (StringUtils.isBlank(this.pacienteTelefone.getText())) {
            JOptionPane.showMessageDialog(this, "Especifique o telefone do paciente.");
            return;
        }
        if (StringUtils.isBlank(this.pacienteEmail.getText())) {
            JOptionPane.showMessageDialog(this, "Especifique o e-mail do paciente.");
            return;
        }
        if (StringUtils.isBlank(this.pacienteDataNascimento.getText())) {
            JOptionPane.showMessageDialog(this, "Especifique a data de nascimento do paciente.");
            return;
        }
        if (StringUtils.isBlank(this.pacienteEndereco.getText())) {
            JOptionPane.showMessageDialog(this, "Especifique o endereço do paciente.");
            return;
        }
        if (this.pacienteSexo.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Especifique o sexo do paciente.");
            return;
        }
        if (this.pacienteTipoAtendimento.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Especifique o tipo de atendimento do paciente.");
            return;
        }
        //END VALIDATION CODES

        String nome = pacienteName.getText();
        String cpf = pacienteCPF.getText();
        String rg = pacienteRG.getText();
        String telefone = pacienteTelefone.getText();
        Sexo sexo = (Sexo) pacienteSexo.getModel().getSelectedItem();
        String email = pacienteEmail.getText();
        Date dataNascimento = null;
        try {
            dataNascimento = DATA_NASCIMENTO_FORMAT.parse(pacienteDataNascimento.getText());
        } catch (Exception e) {
        }

        String endereco = pacienteEndereco.getText();

        TipoAtendimento tipoAtendimento
                = (TipoAtendimento) pacienteTipoAtendimento.getModel().getSelectedItem();

        boolean isFumante = pacienteIsFumante.isSelected();
        boolean isCardiaco = pacienteIsCardiaco.isSelected();
        boolean isAlcolatra = pacienteIsAlcolatra.isSelected();
        boolean isDiabetico = pacienteIsDiabetico.isSelected();

        float colesterol = 0F;
        try {
            colesterol = Float.parseFloat(pacienteColesterol.getText());
        } catch (Exception e) {
        }

        ArrayList<String> alergias = getAlergias();
        ArrayList<String> cirurgias = getCirurgias();

        Paciente paciente = (isEditing) ? this.paciente : new Paciente();
        paciente.setAlergias(alergias);
        paciente.setCirurgias(cirurgias);
        paciente.setIsAlcolatra(isAlcolatra);
        paciente.setIsCardiaco(isCardiaco);
        paciente.setIsDiabetico(isDiabetico);
        paciente.setIsFumante(isFumante);
        paciente.setColesterol(colesterol);
        paciente.setNome(nome);
        paciente.setRg(rg);
        paciente.setCpf(cpf);
        paciente.setSexo(sexo);
        paciente.setTelefone(telefone);
        paciente.setEmail(email);
        paciente.setDataNascimento(dataNascimento);
        paciente.setTipoAtendimento(tipoAtendimento);
        paciente.setEndereco(endereco);

        pacienteViewController.getController().save(paciente);
        if (isEditing) {
            JOptionPane.showMessageDialog(this, "Paciente editado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(this, "Paciente salvo com sucesso!");
        }
        this.setVisible(false);

    }//GEN-LAST:event_pacienteButtomSalvarActionPerformed

    private void pacienteButtomCirurgiasAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pacienteButtomCirurgiasAdicionarActionPerformed
        Object[] dados = {""};
        DefaultTableModel modelo = (DefaultTableModel) pacienteCirurgias.getModel();
        modelo.addRow(dados);
    }//GEN-LAST:event_pacienteButtomCirurgiasAdicionarActionPerformed

    private void pacienteButtomAlergiasAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pacienteButtomAlergiasAdicionarActionPerformed
        Object[] dados = {""};
        DefaultTableModel modelo = (DefaultTableModel) pacienteAlergias.getModel();
        modelo.addRow(dados);
    }//GEN-LAST:event_pacienteButtomAlergiasAdicionarActionPerformed

    private void pacienteButtomCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pacienteButtomCancelarActionPerformed

        this.setVisible(false);

    }//GEN-LAST:event_pacienteButtomCancelarActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed

        if (paciente == null) {
            return;
        }

        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir este Paciente?");
        if (resposta == 0) {
            pacienteViewController.getController().remove(paciente);
            JOptionPane.showMessageDialog(this, "Paciente removida com Sucesso!");
            this.paciente = null;
            this.isEditing = false;
            this.setVisible(false);
        }

    }//GEN-LAST:event_removeButtonActionPerformed

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
            java.util.logging.Logger.getLogger(GerenciarPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GerenciarPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GerenciarPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GerenciarPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new GerenciarPaciente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable pacienteAlergias;
    private javax.swing.JButton pacienteButtomAlergiasAdicionar;
    private javax.swing.JButton pacienteButtomCancelar;
    private javax.swing.JButton pacienteButtomCirurgiasAdicionar;
    private javax.swing.JButton pacienteButtomSalvar;
    private javax.swing.JTextField pacienteCPF;
    private javax.swing.JTable pacienteCirurgias;
    private javax.swing.JTextField pacienteColesterol;
    private javax.swing.JFormattedTextField pacienteDataNascimento;
    private javax.swing.JTextField pacienteEmail;
    private javax.swing.JTextField pacienteEndereco;
    private javax.swing.JCheckBox pacienteIsAlcolatra;
    private javax.swing.JCheckBox pacienteIsCardiaco;
    private javax.swing.JCheckBox pacienteIsDiabetico;
    private javax.swing.JCheckBox pacienteIsFumante;
    private javax.swing.JTextField pacienteName;
    private javax.swing.JTextField pacienteRG;
    private javax.swing.JComboBox pacienteSexo;
    private javax.swing.JTextField pacienteTelefone;
    private javax.swing.JComboBox pacienteTipoAtendimento;
    private javax.swing.JButton removeButton;
    // End of variables declaration//GEN-END:variables

    private ArrayList<String> getAlergias() {
        int numeroDeLinhas = pacienteAlergias.getModel().getRowCount();

        ArrayList<String> alergias = new ArrayList<String>();
        for (int linha = 0; linha < numeroDeLinhas; linha++) {
            String toAdd = (String) pacienteAlergias.getModel().getValueAt(linha, 0);
            if (StringUtils.isNotBlank(toAdd)) {
                alergias.add(toAdd);
            }
        }

        return alergias;
    }

    private ArrayList<String> getCirurgias() {
        int numeroDeLinhas = pacienteCirurgias.getModel().getRowCount();

        ArrayList<String> cirurgias = new ArrayList<String>();
        for (int linha = 0; linha < numeroDeLinhas; linha++) {
            String toAdd = (String) pacienteCirurgias.getModel().getValueAt(linha, 0);

            if (StringUtils.isNotBlank(toAdd)) {
                cirurgias.add(toAdd);
            }
        }

        return cirurgias;
    }

    public void editarPaciente(Paciente paciente) {
        if (paciente == null) {
            isEditing = false;
            return;
        }

        isEditing = true;
        cleanupFields();

        this.paciente = paciente;

        pacienteName.setText(paciente.getNome());
        pacienteCPF.setText(paciente.getCpf());
        pacienteRG.setText(paciente.getRg());
        pacienteTelefone.setText(paciente.getTelefone());
        pacienteSexo.setSelectedItem(paciente.getSexo());
        pacienteDataNascimento.setText(DATA_NASCIMENTO_FORMAT.format(paciente.getDataNascimento()));
        pacienteEndereco.setText(paciente.getEndereco());
        pacienteEmail.setText(paciente.getEmail());
        pacienteTipoAtendimento.setSelectedItem(paciente.getTipoAtendimento());
        pacienteIsFumante.setSelected(paciente.getIsFumante());
        pacienteIsCardiaco.setSelected(paciente.getIsCardiaco());
        pacienteIsDiabetico.setSelected(paciente.getIsDiabetico());
        pacienteIsAlcolatra.setSelected(paciente.getIsAlcolatra());
        pacienteColesterol.setText(paciente.getColesterol().toString());

        if (CollectionUtils.isNotEmpty(paciente.getAlergias())) {
            DefaultTableModel alergiasModel = (DefaultTableModel) pacienteAlergias.getModel();
            alergiasModel.addRow(paciente.getAlergias().toArray());
        }

        if (CollectionUtils.isNotEmpty(paciente.getAlergias())) {
            DefaultTableModel cirurgiasModel = (DefaultTableModel) pacienteCirurgias.getModel();
            cirurgiasModel.addRow(paciente.getCirurgias().toArray());
        }

        this.setVisible(true);

    }

    public void cadastrarPaciente() {
        cleanupFields();
        isEditing = false;
        this.setVisible(true);
    }

    private void disableFieldsByUser() {

        if (pacienteViewController.getSessionUser() instanceof Secretaria) {
            pacienteIsFumante.setEnabled(false);
            pacienteIsCardiaco.setEnabled(false);
            pacienteIsDiabetico.setEnabled(false);
            pacienteIsAlcolatra.setEnabled(false);
            pacienteColesterol.setEnabled(false);
            pacienteAlergias.setEnabled(false);
            pacienteCirurgias.setEnabled(false);
            pacienteButtomAlergiasAdicionar.setEnabled(false);
            pacienteButtomCirurgiasAdicionar.setEnabled(false);
        }
    }

    private void cleanupFields() {
        this.pacienteName.setText("");
        this.pacienteCPF.setText("");
        this.pacienteRG.setText("");
        this.pacienteTelefone.setText("");
        this.pacienteSexo.setSelectedIndex(-1);
        this.pacienteEmail.setText("");
        this.pacienteDataNascimento.setText("");
        this.pacienteEndereco.setText("");
        this.pacienteTipoAtendimento.setSelectedIndex(-1);
        this.pacienteColesterol.setText("0");
        this.pacienteIsAlcolatra.setSelected(false);
        this.pacienteIsCardiaco.setSelected(false);
        this.pacienteIsDiabetico.setSelected(false);
        this.pacienteIsFumante.setSelected(false);
    }

    @Override
    public void setVisible(boolean bln) {
        super.setVisible(bln); //To change body of generated methods, choose Tools | Templates.

        if (isInitialized) {

            if (isEditing) {
                removeButton.setVisible(true);
                removeButton.setEnabled(true);
            } else {
                removeButton.setVisible(false);
                removeButton.setEnabled(false);
            }
        }
    }

}
