/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import data.Data;
import designpatterns.config.PropertiesManager;
import designpatterns.structure.Method;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;

/**
 *
 * @author bruno
 */
public class ResultsIntersectionForm extends javax.swing.JFrame {

    /**
     * Creates new form ResultsIntersectionForm
     */
    public ResultsIntersectionForm(JFrame mainScreen) {
        this.properties = PropertiesManager.getInstance().getProperties();
        this.data = Data.getInstance();
        this.mainScreen = mainScreen;
        getResults();
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle(this.properties.getProperty("titleDPS"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelIntersectionData = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelNameProject = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelNameBadSmell = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelTypeBadSmell = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableIntersection = new javax.swing.JTable();
        jButtonExportTable = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabelAmountBadSmell = new javax.swing.JLabel();
        jButtonBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        jPanelIntersectionData.setBorder(javax.swing.BorderFactory.createTitledBorder(this.properties.getProperty("panelAmountIntersectionInstances")));
        jPanelIntersectionData.setToolTipText("");

        jLabel1.setText(this.properties.getProperty("labelProject") + ":");

        jLabelNameProject.setText(this.data.getNameProject());

        jLabel2.setText(this.properties.getProperty("labelBadSmell") + ":");

        jLabelNameBadSmell.setText(this.data.getNameBadSmell());

        jLabel3.setText(this.properties.getProperty("labelType") + ":");

        jLabelTypeBadSmell.setText(this.data.getTypeBadSmell());

        jTableIntersection.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Padrão de Projeto", "Quantidade", "Quantidade Afetada", "Percentual Afetado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableResults();
        jScrollPane1.setViewportView(jTableIntersection);

        jButtonExportTable.setText(this.properties.getProperty("buttonExportCSVValuesIntersection"));
        jButtonExportTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExportTableActionPerformed(evt);
            }
        });

        if(this.data.getTypeBadSmell().equals(this.properties.getProperty("optionClass"))){
            jLabel4.setText(this.properties.getProperty("labelTotalClassesBadSmell") + ":");
        }else{
            jLabel4.setText(this.properties.getProperty("labelTotalMethodsBadSmell") + ":");
        }

        List<Object> amountBadSmell = (List<Object>)this.data.badSmellData();
        if(this.data.getTypeBadSmell().equals(this.properties.getProperty("optionClass"))){
            jLabelAmountBadSmell.setText(amountBadSmell.size() + " classes");
        }else{
            jLabelAmountBadSmell.setText(amountBadSmell.size() + " métodos");
        }

        jButtonBack.setText(this.properties.getProperty("buttonBack"));
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelIntersectionDataLayout = new javax.swing.GroupLayout(jPanelIntersectionData);
        jPanelIntersectionData.setLayout(jPanelIntersectionDataLayout);
        jPanelIntersectionDataLayout.setHorizontalGroup(
            jPanelIntersectionDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelIntersectionDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelIntersectionDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 902, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelIntersectionDataLayout.createSequentialGroup()
                        .addComponent(jButtonBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonExportTable))
                    .addGroup(jPanelIntersectionDataLayout.createSequentialGroup()
                        .addGroup(jPanelIntersectionDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelIntersectionDataLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelNameBadSmell))
                            .addGroup(jPanelIntersectionDataLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelNameProject)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelIntersectionDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelIntersectionDataLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelTypeBadSmell))
                            .addGroup(jPanelIntersectionDataLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelAmountBadSmell)))
                        .addGap(66, 66, 66)))
                .addContainerGap())
        );
        jPanelIntersectionDataLayout.setVerticalGroup(
            jPanelIntersectionDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelIntersectionDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelIntersectionDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabelNameProject)
                    .addComponent(jLabelTypeBadSmell)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelIntersectionDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabelNameBadSmell)
                    .addComponent(jLabel4)
                    .addComponent(jLabelAmountBadSmell))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jPanelIntersectionDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonExportTable)
                    .addComponent(jButtonBack))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelIntersectionData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelIntersectionData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonExportTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExportTableActionPerformed
        JFileChooser jfileChooser = new JFileChooser();
        int returnVal = jfileChooser.showSaveDialog(this);
        int confirm = 0;
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                File xls = jfileChooser.getSelectedFile();
                xls.createNewFile();
                confirm = toExcel(this.jTableIntersection, xls);
            } catch (IOException ex) {
                Logger.getLogger(ResultsIntersectionForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (confirm == 1) {
            JOptionPane.showMessageDialog(this, this.properties.getProperty("confirmationExportIntersection"), this.properties.getProperty("titleConfirmation"), JOptionPane.INFORMATION_MESSAGE, null);
        } else {
            JOptionPane.showMessageDialog(this, this.properties.getProperty("errorExportIntersection"), this.properties.getProperty("titleError"), JOptionPane.ERROR_MESSAGE, null);
        }
    }//GEN-LAST:event_jButtonExportTableActionPerformed

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
        String[] colunas = new String[]{this.properties.getProperty("labelDesignPatternTable"), this.properties.getProperty("labelAmountTable"), this.properties.getProperty("labelAmountAffectedTable"), this.properties.getProperty("labelPercentualAffectedTable")};
        String[][] dados = getData();
        jTableIntersection = new JTable(dados, colunas);
        DefaultTableCellRenderer cellRender = new DefaultTableCellRenderer();
        cellRender.setHorizontalAlignment(SwingConstants.CENTER);
        jTableIntersection.setEnabled(false);
    }

    private String[][] getData() {
        String[][] d = null;
        if (data.getTypeBadSmell().equals(this.properties.getProperty("optionClass"))) {
            d = getDataClass();
        } else {
            d = getDataMethod();
        }
        return d;
    }

    public String[][] getDataClass() {
        Collection<Set<designpatterns.structure.Type>> badSmellPerPattern = intersectionClass.values();
        Object[] namePatterns = intersectionClass.keySet().toArray();
        int index = 0;
        String[][] data = new String[badSmellPerPattern.size()][4];
        for (Set<designpatterns.structure.Type> list : badSmellPerPattern) {
            String namePattern = String.valueOf(namePatterns[index]);
            int amount = Data.getInstance().getDesignPatternByKey(namePattern).getSumClass();
            int classWithBadSmell = list.size();
            Float percentage = (amount > 0) ? (Float.parseFloat(String.valueOf(classWithBadSmell)) / Float.parseFloat(String.valueOf(amount))) * 100 : 0;
            data[index] = new String[]{namePattern, String.valueOf(amount), String.valueOf(classWithBadSmell), String.format("%.2f", percentage)};
            index++;
        }
        return data;
    }

    public String[][] getDataMethod() {
        Collection<Set<Method>> badSmellPerPattern = intersectionMethod.values();
        Object[] namePatterns = intersectionMethod.keySet().toArray();
        int index = 0;
        String[][] data = new String[badSmellPerPattern.size()][4];
        for (Set<Method> list : badSmellPerPattern) {
            String namePattern = String.valueOf(namePatterns[index]);
            int amount = Data.getInstance().getDesignPatternByKey(namePattern).getSumMethod();
            int methodsWithBadSmell = list.size();
            Float percentage = (amount > 0) ? (Float.parseFloat(String.valueOf(methodsWithBadSmell)) / Float.parseFloat(String.valueOf(amount))) * 100 : 0;
            data[index] = new String[]{namePattern, String.valueOf(amount), String.valueOf(methodsWithBadSmell), String.format("%.2f", percentage)};
            index++;
        }
        return data;
    }

    public void init() {
        initComponents();
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        this.setTitle(this.properties.getProperty("titleResultsIntersectionForm"));
        this.setVisible(true);
    }

    private void getResults() {
        if (!this.data.getIntersectionType().isEmpty()) {
            this.intersectionClass = new TreeMap<>();
            this.intersectionClass.putAll(this.data.getIntersectionType());
        } else {
            this.intersectionMethod = new TreeMap<>();
            this.intersectionMethod.putAll(this.data.getIntersectionMethod());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonExportTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelAmountBadSmell;
    private javax.swing.JLabel jLabelNameBadSmell;
    private javax.swing.JLabel jLabelNameProject;
    private javax.swing.JLabel jLabelTypeBadSmell;
    private javax.swing.JPanel jPanelIntersectionData;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableIntersection;
    // End of variables declaration//GEN-END:variables
    private TreeMap<String, Set<designpatterns.structure.Type>> intersectionClass;
    private TreeMap<String, Set<Method>> intersectionMethod;
    private Data data;
    private Properties properties;
    private JFrame mainScreen;
}
