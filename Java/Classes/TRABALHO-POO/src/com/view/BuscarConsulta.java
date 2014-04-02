/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.view;

import com.domain.Consulta;
import com.domain.Paciente;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Junior
 */
public class BuscarConsulta extends javax.swing.JPanel {

    /**
     * Creates new form BuscarConsulta
     */
    public BuscarConsulta() {
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
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        searchResultTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        jLabel1.setText("Nome do Paciente");

        searchResultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Editar", "Paciente", "Data", "Medico"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(searchResultTable);

        jButton1.setText("Buscar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable searchResultTable;
    // End of variables declaration//GEN-END:variables

    class ButtonColumn extends AbstractCellEditor  
        implements TableCellRenderer, TableCellEditor, ActionListener  {  
        JTable table;  
        JButton renderButton;  
        JButton editButton;  
        String text;  
        Consulta consulta;
        GerenciamentoConsulta gerenciamentoConsulta;
        BuscarConsulta buscarConsulta;
        
        private static final String TITLE = "Editar"; 

        private ButtonColumn(JTable table, int column, GerenciamentoConsulta gerenciamentoConsulta, BuscarConsulta buscarConsulta) {
            
            super();  
            this.table = table;  
            renderButton = new JButton();  
   
            editButton = new JButton();  
            editButton.setFocusPainted( false );  
            editButton.addActionListener( this );  
   
            TableColumnModel columnModel = table.getColumnModel();  
            columnModel.getColumn(column).setCellRenderer( this );  
            columnModel.getColumn(column).setCellEditor( this );
            
            this.gerenciamentoConsulta = gerenciamentoConsulta;
            this.buscarConsulta = buscarConsulta;
  
        }
   
        public Component getTableCellRendererComponent(  
            JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)  
        {  
            if (hasFocus)  
            {  
                renderButton.setForeground(table.getForeground());  
                renderButton.setBackground(UIManager.getColor("Button.background"));  
            }  
            else if (isSelected)  
            {  
                renderButton.setForeground(table.getSelectionForeground());  
                 renderButton.setBackground(table.getSelectionBackground());  
            }  
            else  
            {  
                renderButton.setForeground(table.getForeground());  
                renderButton.setBackground(UIManager.getColor("Button.background"));  
            }  
            
            try{
                consulta = (Consulta) value;
            }catch(Exception e){}
   
            renderButton.setText( TITLE  );  
            return renderButton;  
        }  
   
        public Component getTableCellEditorComponent(  
            JTable table, Object value, boolean isSelected, int row, int column)  
        {  
            try{
                consulta = (Consulta) value;
            }catch(Exception e){}
            
            editButton.setText( TITLE );  
            return editButton;  
        }  
   
        public Object getCellEditorValue()  
        {  
            return TITLE;  
        }  
   
        public void actionPerformed(ActionEvent e)  
        {  
            fireEditingStopped();
            buscarConsulta.setVisible(false);
            buscarConsulta.cleanResultTable();
            gerenciamentoConsulta.editarConsulta(consulta);
        }  
    }
    
    public void cleanResultTable(){
        
        DefaultTableModel dtm =  (DefaultTableModel) searchResultTable.getModel();
        
        for(int index = 0; index < dtm.getRowCount(); index++){
            dtm.removeRow(index);
        }
    }
}
