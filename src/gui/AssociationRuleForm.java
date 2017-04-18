/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import data.Data;
import designpatterns.config.PropertiesManager;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import statistics.AssociationRule;
import statistics.AssociationRuleEnum;

/**
 *
 * @author bruno
 */
public class AssociationRuleForm extends javax.swing.JFrame {

    /**
     * Creates new form AssociationRuleForm
     */
    public AssociationRuleForm(JFrame mainScreen) {
        this.data = Data.getInstance();
        this.properties = PropertiesManager.getInstance().getProperties();
        this.rules = new HashMap<>();
        this.mainScreen = mainScreen;
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle(this.properties.getProperty("titleDPS"));
        checkAll();
        initializeFilter();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMain3 = new javax.swing.JPanel();
        jPanelDataAssociatonRule = new javax.swing.JPanel();
        jButtonCalculate = new javax.swing.JButton();
        jLabelTransactionNumber = new javax.swing.JLabel();
        jTextFieldTransactonNumber = new javax.swing.JTextField();
        jPanelFilter = new javax.swing.JPanel();
        jCheckBoxSupport = new javax.swing.JCheckBox();
        jCheckBoxConfidence = new javax.swing.JCheckBox();
        jCheckBoxLift = new javax.swing.JCheckBox();
        jCheckBoxConviction = new javax.swing.JCheckBox();
        jPanelAssociationRulesResults = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAssociationRules = new javax.swing.JTable();
        jButtonExport = new javax.swing.JButton();
        jLabelAssociation = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButtonBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        jPanelMain3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanelDataAssociatonRule.setBorder(javax.swing.BorderFactory.createTitledBorder("Input and Filter"));

        jButtonCalculate.setText("Calculate");
        jButtonCalculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCalculateActionPerformed(evt);
            }
        });

        jLabelTransactionNumber.setText(this.properties.getProperty("labelTransactionsNumber"));

        jPanelFilter.setBorder(javax.swing.BorderFactory.createTitledBorder("Rules"));

        jCheckBoxSupport.setText("Support");
        jCheckBoxSupport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxSupportActionPerformed(evt);
            }
        });

        jCheckBoxConfidence.setText("Confidence");
        jCheckBoxConfidence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxConfidenceActionPerformed(evt);
            }
        });

        jCheckBoxLift.setText("Lift");
        jCheckBoxLift.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxLiftActionPerformed(evt);
            }
        });

        jCheckBoxConviction.setText("Conviction");
        jCheckBoxConviction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxConvictionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelFilterLayout = new javax.swing.GroupLayout(jPanelFilter);
        jPanelFilter.setLayout(jPanelFilterLayout);
        jPanelFilterLayout.setHorizontalGroup(
            jPanelFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFilterLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jCheckBoxSupport)
                .addGap(77, 77, 77)
                .addComponent(jCheckBoxConfidence)
                .addGap(78, 78, 78)
                .addComponent(jCheckBoxLift)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addComponent(jCheckBoxConviction)
                .addGap(54, 54, 54))
        );
        jPanelFilterLayout.setVerticalGroup(
            jPanelFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFilterLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanelFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxSupport)
                    .addComponent(jCheckBoxConfidence)
                    .addComponent(jCheckBoxLift)
                    .addComponent(jCheckBoxConviction))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelDataAssociatonRuleLayout = new javax.swing.GroupLayout(jPanelDataAssociatonRule);
        jPanelDataAssociatonRule.setLayout(jPanelDataAssociatonRuleLayout);
        jPanelDataAssociatonRuleLayout.setHorizontalGroup(
            jPanelDataAssociatonRuleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDataAssociatonRuleLayout.createSequentialGroup()
                .addGroup(jPanelDataAssociatonRuleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDataAssociatonRuleLayout.createSequentialGroup()
                        .addGap(329, 329, 329)
                        .addComponent(jButtonCalculate))
                    .addGroup(jPanelDataAssociatonRuleLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanelDataAssociatonRuleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelDataAssociatonRuleLayout.createSequentialGroup()
                                .addComponent(jLabelTransactionNumber)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldTransactonNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanelDataAssociatonRuleLayout.setVerticalGroup(
            jPanelDataAssociatonRuleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDataAssociatonRuleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDataAssociatonRuleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTransactionNumber)
                    .addComponent(jTextFieldTransactonNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonCalculate)
                .addContainerGap())
        );

        jPanelAssociationRulesResults.setBorder(javax.swing.BorderFactory.createTitledBorder("Association Rules Results"));

        jTableAssociationRules.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Título 4", "Title 5"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableAssociationRules.setUpdateSelectionOnSort(false);
        jScrollPane1.setViewportView(jTableAssociationRules);
        tableResults();

        jButtonExport.setText("Export");
        jButtonExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExportActionPerformed(evt);
            }
        });

        jLabelAssociation.setText(this.properties.getProperty("labelAssociation") + ":");

        jLabel3.setText("Design Pattern => " + this.data.getNameBadSmell());

        jButtonBack.setText(this.properties.getProperty("buttonBack"));
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelAssociationRulesResultsLayout = new javax.swing.GroupLayout(jPanelAssociationRulesResults);
        jPanelAssociationRulesResults.setLayout(jPanelAssociationRulesResultsLayout);
        jPanelAssociationRulesResultsLayout.setHorizontalGroup(
            jPanelAssociationRulesResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAssociationRulesResultsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAssociationRulesResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAssociationRulesResultsLayout.createSequentialGroup()
                        .addComponent(jLabelAssociation)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelAssociationRulesResultsLayout.createSequentialGroup()
                        .addGroup(jPanelAssociationRulesResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAssociationRulesResultsLayout.createSequentialGroup()
                                .addComponent(jButtonBack)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonExport)))
                        .addContainerGap())))
        );
        jPanelAssociationRulesResultsLayout.setVerticalGroup(
            jPanelAssociationRulesResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAssociationRulesResultsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelAssociationRulesResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAssociation)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelAssociationRulesResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonExport)
                    .addComponent(jButtonBack))
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout jPanelMain3Layout = new javax.swing.GroupLayout(jPanelMain3);
        jPanelMain3.setLayout(jPanelMain3Layout);
        jPanelMain3Layout.setHorizontalGroup(
            jPanelMain3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMain3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMain3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelDataAssociatonRule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelAssociationRulesResults, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelMain3Layout.setVerticalGroup(
            jPanelMain3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMain3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelDataAssociatonRule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelAssociationRulesResults, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMain3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelMain3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCalculateActionPerformed
        if (!this.jTextFieldTransactonNumber.getText().isEmpty()) {
            this.rules.clear();
            AssociationRule statistic = new AssociationRule(Integer.parseInt(this.jTextFieldTransactonNumber.getText()));
            for (String dp : this.data.getDesignPatterns().keySet()) {
                rules.put(dp, statistic.calculate(dp));
            }
            tableResults();
        } else {
            JOptionPane.showMessageDialog(this, this.properties.getProperty("warningAssociationRulesInput"), this.properties.getProperty("titleWarning"), JOptionPane.WARNING_MESSAGE, null);
        }
    }//GEN-LAST:event_jButtonCalculateActionPerformed

    private void jButtonExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExportActionPerformed
        JFileChooser jfileChooser = new JFileChooser();
        int returnVal = jfileChooser.showSaveDialog(this);
        int confirm = 0;
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                File xls = jfileChooser.getSelectedFile();
                xls.createNewFile();
                confirm = toExcel(this.jTableAssociationRules, xls);
            } catch (IOException ex) {
                Logger.getLogger(AssociationRuleForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (confirm == 1) {
            JOptionPane.showMessageDialog(this, this.properties.getProperty("confirmationExportAssociationRules"), this.properties.getProperty("titleConfirmation"), JOptionPane.INFORMATION_MESSAGE, null);
        } else {
            JOptionPane.showMessageDialog(this, this.properties.getProperty("errorExportAssociationRules"), this.properties.getProperty("titleError"), JOptionPane.ERROR_MESSAGE, null);
        }
    }//GEN-LAST:event_jButtonExportActionPerformed

    private void jCheckBoxSupportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxSupportActionPerformed
        if (!this.jCheckBoxSupport.isSelected()) {
            this.filter.remove(AssociationRuleEnum.SUPPORT);
        } else {
            this.filter.add(AssociationRuleEnum.SUPPORT);
        }
    }//GEN-LAST:event_jCheckBoxSupportActionPerformed

    private void jCheckBoxConfidenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxConfidenceActionPerformed
        if (!this.jCheckBoxConfidence.isSelected()) {
            this.filter.remove(AssociationRuleEnum.CONFIDENCE);
        } else {
            this.filter.add(AssociationRuleEnum.CONFIDENCE);
        }
    }//GEN-LAST:event_jCheckBoxConfidenceActionPerformed

    private void jCheckBoxLiftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxLiftActionPerformed
        if (!this.jCheckBoxLift.isSelected()) {
            this.filter.remove(AssociationRuleEnum.LIFT);
        } else {
            this.filter.add(AssociationRuleEnum.LIFT);
        }
    }//GEN-LAST:event_jCheckBoxLiftActionPerformed

    private void jCheckBoxConvictionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxConvictionActionPerformed
        if (!this.jCheckBoxConviction.isSelected()) {
            this.filter.remove(AssociationRuleEnum.CONVICTION);
        } else {
            this.filter.add(AssociationRuleEnum.CONVICTION);
        }
    }//GEN-LAST:event_jCheckBoxConvictionActionPerformed

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        this.setVisible(false);
        this.mainScreen.setVisible(true);
    }//GEN-LAST:event_jButtonBackActionPerformed

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
        if (!this.rules.isEmpty() && !this.filter.isEmpty()) {
            DefaultTableModel model = getColumns();
            model = getData(model);
            jTableAssociationRules = new JTable();
            jTableAssociationRules.setModel(model);
            jTableAssociationRules.setShowGrid(true);
            DefaultTableCellRenderer cellRender = new DefaultTableCellRenderer();
            cellRender.setHorizontalAlignment(SwingConstants.RIGHT);
            ((DefaultTableCellRenderer) jTableAssociationRules.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
            int index = 1;
            for (AssociationRuleEnum rule : this.filter) {
                this.jTableAssociationRules.getColumnModel().getColumn(index).setCellRenderer(cellRender);
                index++;
            }
            jTableAssociationRules.getTableHeader().setReorderingAllowed(false);
            jTableAssociationRules.setEnabled(false);
            jScrollPane1.setViewportView(jTableAssociationRules);
        } else {
            JLabel emptyLabel = new JLabel("There aren't artifacts for this filter!!!");
            emptyLabel.setHorizontalAlignment(SwingConstants.CENTER);
            jScrollPane1.setViewportView(emptyLabel);
        }
    }

    private DefaultTableModel getData(DefaultTableModel model) {
        int line = 0;
        TreeSet<String> designPattern = new TreeSet<>();
        designPattern.addAll(this.data.getDesignPatterns().keySet());
        for (String dp : designPattern) {
            model.addRow(new Object[0]);
            model.setValueAt(dp, line, 0);
            HashMap<String, Double> values = this.rules.get(dp);
            int column = 1;
            for (AssociationRuleEnum r : AssociationRuleEnum.values()) {
                if (this.filter.contains(r)) {
                    if (!Double.isNaN(values.get(r.toString()))) {
                        DecimalFormat df = new DecimalFormat("0.00000");
                        model.setValueAt(df.format(values.get(r.toString())).replace(",", "."), line, column);
                    } else {
                        model.setValueAt(values.get(r.toString()), line, column);
                    }
                    column++;
                }
            }
            line++;
        }
        return model;
    }

    private DefaultTableModel getColumns() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Design Pattern");
        for (AssociationRuleEnum rule : AssociationRuleEnum.values()) {
            if (this.filter.contains(rule)) {
                model.addColumn(rule.toString().toLowerCase());
            }
        }
        return model;
    }

    private void initializeFilter() {
        this.filter = new ArrayList<>();
        for (AssociationRuleEnum rule : AssociationRuleEnum.values()) {
            this.filter.add(rule);
        }
    }

    private void checkAll() {
        this.jCheckBoxSupport.setSelected(true);
        this.jCheckBoxConfidence.setSelected(true);
        this.jCheckBoxLift.setSelected(true);
        this.jCheckBoxConviction.setSelected(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonCalculate;
    private javax.swing.JButton jButtonExport;
    private javax.swing.JCheckBox jCheckBoxConfidence;
    private javax.swing.JCheckBox jCheckBoxConviction;
    private javax.swing.JCheckBox jCheckBoxLift;
    private javax.swing.JCheckBox jCheckBoxSupport;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelAssociation;
    private javax.swing.JLabel jLabelTransactionNumber;
    private javax.swing.JPanel jPanelAssociationRulesResults;
    private javax.swing.JPanel jPanelDataAssociatonRule;
    private javax.swing.JPanel jPanelFilter;
    private javax.swing.JPanel jPanelMain3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableAssociationRules;
    private javax.swing.JTextField jTextFieldTransactonNumber;
    // End of variables declaration//GEN-END:variables
    private List<AssociationRuleEnum> filter;
    private Data data;
    private Properties properties;
    private HashMap<String, HashMap<String, Double>> rules;
    private JFrame mainScreen;
}
