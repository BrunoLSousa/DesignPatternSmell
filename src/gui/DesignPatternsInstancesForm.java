package gui;

import data.Data;
import designpatterns.DesignPattern;
import designpatterns.config.PropertiesManager;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bruno
 */
public class DesignPatternsInstancesForm extends javax.swing.JFrame {

    /**
     * Creates new form DesignPatternsInstancesForm
     */
    public DesignPatternsInstancesForm() {
        this.properties = PropertiesManager.getInstance().getProperties();
        this.data = Data.getInstance();
        this.designPatterns = new TreeMap<>();
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableResult = new javax.swing.JTable();
        jButtonExport = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabelTotalInstances = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelNameProject = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(this.properties.getProperty("panelAmountInstances")));

        jTableResult.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableResult.setEnabled(false);
        tableResults();
        jScrollPane1.setViewportView(jTableResult);

        jButtonExport.setText(this.properties.getProperty("buttonExportCSVValuesInstances"));
        jButtonExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExportActionPerformed(evt);
            }
        });

        jLabel1.setText(this.properties.getProperty("labelAmountInstances") + ":");

        jLabel2.setText(this.properties.getProperty("labelProject") + ":");

        jLabelNameProject.setText("jLabel3");
        jLabelNameProject.setText(this.data.getNameProject());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonExport))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 881, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelTotalInstances))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelNameProject)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabelNameProject))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabelTotalInstances))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonExport)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExportActionPerformed
        JFileChooser jfileChooser = new JFileChooser();
        int returnVal = jfileChooser.showSaveDialog(this);
        int confirm = 0;
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                File xls = jfileChooser.getSelectedFile();
                xls.createNewFile();
                confirm = toExcel(jTableResult, xls);
            } catch (IOException ex) {
                Logger.getLogger(DesignPatternsInstancesForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (confirm == 1) {
            JOptionPane.showMessageDialog(this, this.properties.getProperty("confirmationExportAmountInstances"), this.properties.getProperty("titleConfirmation"), JOptionPane.INFORMATION_MESSAGE, null);
        } else {
            JOptionPane.showMessageDialog(this, this.properties.getProperty("errorExportAmountInstances"), this.properties.getProperty("titleError"), JOptionPane.ERROR_MESSAGE, null);
        }
    }//GEN-LAST:event_jButtonExportActionPerformed

    public int toExcel(JTable table, File file) {
        try {
            TableModel model = table.getModel();
            FileWriter excel = new FileWriter(file);

            for (int i = 0; i < model.getColumnCount(); i++) {
                excel.write("\"" + model.getColumnName(i) + "\"" + ",");
            }

            excel.write("\n");

            for (int i = 0; i < model.getRowCount(); i++) {
                for (int j = 0; j < model.getColumnCount(); j++) {
                    excel.write("\"" + model.getValueAt(i, j).toString() + "\"" + ",");
                }
                excel.write("\n");
            }
            
            excel.write("\n");

            excel.close();

            return 1;
        } catch (IOException e) {
            System.out.println(e);
        }

        return 0;
    }

    private void tableResults() {
        String[] colunas = new String[]{this.properties.getProperty("labelDesignPatternTable"), this.properties.getProperty("labelAmountArtifactDesignPattern"), this.properties.getProperty("labelPercentualArtifactDesignPattern")};
        String[][] dados = getData();
        jTableResult = new JTable(dados, colunas);
        DefaultTableCellRenderer cellRender = new DefaultTableCellRenderer();
        cellRender.setHorizontalAlignment(SwingConstants.CENTER);
        jTableResult.setEnabled(false);
    }

    private String[][] getData() {
        this.designPatterns.putAll(this.data.getDesignPatterns());
        Collection<DesignPattern> dp = this.designPatterns.values();
        int instacesTotal = sumInstances(dp);
        this.jLabelTotalInstances.setText(String.valueOf(instacesTotal) + " instância(s)");
        String[][] data = new String[this.designPatterns.size()][3];
        int index = 0;
        for (DesignPattern d : dp) {
            Float percentual = (Float.parseFloat(String.valueOf(d.getInstaces())) / Float.parseFloat(String.valueOf(instacesTotal))) * 100;
            data[index] = new String[]{d.getName(), String.valueOf(d.getInstaces()), String.format("%.2f", percentual)};
            index++;
        }
        return data;
    }

    private int sumInstances(Collection<DesignPattern> dp) {
        int sum = 0;
        for (DesignPattern d : dp) {
            sum += d.getInstaces();
        }
        return sum;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonExport;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelNameProject;
    private javax.swing.JLabel jLabelTotalInstances;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableResult;
    // End of variables declaration//GEN-END:variables
    private Properties properties;
    private TreeMap<String, DesignPattern> designPatterns;
    private Data data;

}
