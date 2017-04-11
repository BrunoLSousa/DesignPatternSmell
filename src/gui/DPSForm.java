/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import data.Data;
import designpatterns.config.PropertiesManager;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashSet;
import java.util.Properties;
import java.util.Set;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.filechooser.FileNameExtensionFilter;
import parser.CSVParser;
import parser.XMLParser;

/**
 *
 * @author bruno
 */
public class DPSForm extends javax.swing.JFrame {

    /**
     * Creates new form DPSForm
     */
    public DPSForm() {
        this.xmlFiles = new LinkedHashSet<>();
        this.data = Data.getInstance();
        this.properties = PropertiesManager.getInstance().getProperties();
        initComponents();
        enablePanel(false);
        this.loadingDialog.add(progress);
        this.loadingDialog.pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBadSmell = new javax.swing.JPanel();
        jLabelBadSmellName = new javax.swing.JLabel();
        jTextFieldBadSmellName = new javax.swing.JTextField();
        jLabelCsvFile = new javax.swing.JLabel();
        jButtonSelectCSV = new javax.swing.JButton();
        jButtonIntersection = new javax.swing.JButton();
        jLabelTypeBadSmell = new javax.swing.JLabel();
        jComboBoxTypeBadSmell = new javax.swing.JComboBox();
        jButtonCleanCsv = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaCsvFile = new javax.swing.JTextArea();
        jPanelDesignPattern = new javax.swing.JPanel();
        jLabelProjectName = new javax.swing.JLabel();
        jTextFieldProjectName = new javax.swing.JTextField();
        jLabelXmlFiles = new javax.swing.JLabel();
        jButtonSelectXml = new javax.swing.JButton();
        jButtonConvert = new javax.swing.JButton();
        jButtonCleanXml = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaXmlFiles = new javax.swing.JTextArea();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuNew = new javax.swing.JMenuItem();
        jMenuNewCSV = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuExit = new javax.swing.JMenuItem();
        jMenuResults = new javax.swing.JMenu();
        jMenuInstancesDesignPattern = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(null);

        jPanelBadSmell.setBorder(javax.swing.BorderFactory.createTitledBorder(this.properties.getProperty("panelBadSmell")));

        jLabelBadSmellName.setText(this.properties.getProperty("labelBadSmell"));

        jLabelCsvFile.setText(this.properties.getProperty("labelCSVFile"));

        jButtonSelectCSV.setText(this.properties.getProperty("buttonSelectCSV"));
        jButtonSelectCSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelectCSVActionPerformed(evt);
            }
        });

        jButtonIntersection.setText(this.properties.getProperty("buttonIntersection"));
        jButtonIntersection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIntersectionActionPerformed(evt);
            }
        });

        jLabelTypeBadSmell.setText(this.properties.getProperty("labelType"));

        jComboBoxTypeBadSmell.setModel(new javax.swing.DefaultComboBoxModel(new String[] { this.properties.getProperty("optionClass"), this.properties.getProperty("optionMethod")}));

        jButtonCleanCsv.setText(this.properties.getProperty("buttonClearCSVFiles"));
        jButtonCleanCsv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCleanCsvActionPerformed(evt);
            }
        });

        jTextAreaCsvFile.setEditable(false);
        jTextAreaCsvFile.setColumns(20);
        jTextAreaCsvFile.setRows(5);
        jScrollPane1.setViewportView(jTextAreaCsvFile);

        javax.swing.GroupLayout jPanelBadSmellLayout = new javax.swing.GroupLayout(jPanelBadSmell);
        jPanelBadSmell.setLayout(jPanelBadSmellLayout);
        jPanelBadSmellLayout.setHorizontalGroup(
            jPanelBadSmellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBadSmellLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBadSmellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBadSmellLayout.createSequentialGroup()
                        .addComponent(jLabelBadSmellName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldBadSmellName))
                    .addGroup(jPanelBadSmellLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanelBadSmellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonIntersection, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                            .addComponent(jButtonCleanCsv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonSelectCSV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanelBadSmellLayout.createSequentialGroup()
                        .addGroup(jPanelBadSmellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCsvFile)
                            .addGroup(jPanelBadSmellLayout.createSequentialGroup()
                                .addComponent(jLabelTypeBadSmell)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBoxTypeBadSmell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelBadSmellLayout.setVerticalGroup(
            jPanelBadSmellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBadSmellLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBadSmellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelBadSmellName)
                    .addComponent(jTextFieldBadSmellName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanelBadSmellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTypeBadSmell)
                    .addComponent(jComboBoxTypeBadSmell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabelCsvFile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelBadSmellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBadSmellLayout.createSequentialGroup()
                        .addComponent(jButtonSelectCSV)
                        .addGap(27, 27, 27)
                        .addComponent(jButtonCleanCsv)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addComponent(jButtonIntersection))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        jPanelDesignPattern.setBorder(javax.swing.BorderFactory.createTitledBorder(this.properties.getProperty("panelDesignPattern")));

        jLabelProjectName.setText(this.properties.getProperty("labelProject"));

        jLabelXmlFiles.setText(this.properties.getProperty("labelFileXML"));

        jButtonSelectXml.setText(this.properties.getProperty("buttonSelectXML"));
        jButtonSelectXml.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelectXmlActionPerformed(evt);
            }
        });

        jButtonConvert.setText(this.properties.getProperty("buttonXMLParser"));
        jButtonConvert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConvertActionPerformed(evt);
            }
        });

        jButtonCleanXml.setText(this.properties.getProperty("buttonClearXMLFiles"));
        jButtonCleanXml.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCleanXmlActionPerformed(evt);
            }
        });

        jTextAreaXmlFiles.setEditable(false);
        jTextAreaXmlFiles.setColumns(20);
        jTextAreaXmlFiles.setRows(5);
        jScrollPane3.setViewportView(jTextAreaXmlFiles);

        javax.swing.GroupLayout jPanelDesignPatternLayout = new javax.swing.GroupLayout(jPanelDesignPattern);
        jPanelDesignPattern.setLayout(jPanelDesignPatternLayout);
        jPanelDesignPatternLayout.setHorizontalGroup(
            jPanelDesignPatternLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDesignPatternLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDesignPatternLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDesignPatternLayout.createSequentialGroup()
                        .addComponent(jLabelProjectName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldProjectName))
                    .addGroup(jPanelDesignPatternLayout.createSequentialGroup()
                        .addGroup(jPanelDesignPatternLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelXmlFiles)
                            .addGroup(jPanelDesignPatternLayout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanelDesignPatternLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButtonSelectXml, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                                    .addComponent(jButtonCleanXml, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonConvert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(6, 6, 6)))
                .addContainerGap())
        );
        jPanelDesignPatternLayout.setVerticalGroup(
            jPanelDesignPatternLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDesignPatternLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDesignPatternLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelProjectName)
                    .addComponent(jTextFieldProjectName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabelXmlFiles)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDesignPatternLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDesignPatternLayout.createSequentialGroup()
                        .addComponent(jButtonSelectXml)
                        .addGap(27, 27, 27)
                        .addComponent(jButtonCleanXml)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(jButtonConvert))
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );

        jMenuFile.setText(this.properties.getProperty("menu1"));

        jMenuNew.setText(this.properties.getProperty("submenu1_1"));
        jMenuNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuNewActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuNew);

        jMenuNewCSV.setText(this.properties.getProperty("submenu1_2"));
        jMenuNewCSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuNewCSVActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuNewCSV);
        jMenuFile.add(jSeparator1);

        jMenuExit.setText(this.properties.getProperty("submenu1_4"));
        jMenuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuExitActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuExit);

        jMenuBar.add(jMenuFile);

        jMenuResults.setText(this.properties.getProperty("menu2"));

        jMenuInstancesDesignPattern.setText(this.properties.getProperty("submenu2_1"));
        jMenuInstancesDesignPattern.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuInstancesDesignPatternActionPerformed(evt);
            }
        });
        jMenuResults.add(jMenuInstancesDesignPattern);

        jMenuItem1.setText(this.properties.getProperty("submenu2_2"));
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuResults.add(jMenuItem1);

        jMenuItem2.setText(this.properties.getProperty("submenu2_3"));
        jMenuResults.add(jMenuItem2);

        jMenuBar.add(jMenuResults);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelDesignPattern, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelBadSmell, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelDesignPattern, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelBadSmell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSelectCSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelectCSVActionPerformed
        JFileChooser c = new JFileChooser();
        FileNameExtensionFilter csvfilter = new FileNameExtensionFilter("csv files (*.csv)", "csv");
        c.setFileFilter(csvfilter);
        c.showOpenDialog(this);
        File file = c.getSelectedFile();

        try {
            if (file != null && file.getName().contains("csv")) {
                long length = 0;
                this.csvFile = file;
                length += file.length();
                Path path = Paths.get(file.getName());
                this.jTextAreaCsvFile.setText(path.toString());
            }

        } catch (Exception e1) {
            JOptionPane.showMessageDialog(this, this.properties.getProperty("errorCSVParser"), this.properties.getProperty("titleError"), JOptionPane.ERROR_MESSAGE, null);
        }
    }//GEN-LAST:event_jButtonSelectCSVActionPerformed

    private void jButtonIntersectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIntersectionActionPerformed
        if (csvFile != null && !jTextFieldBadSmellName.getText().isEmpty()) {
            this.data.setNameBadSmell(jTextFieldBadSmellName.getText());
            this.data.setTypeBadSmell(jComboBoxTypeBadSmell.getSelectedItem().toString());
            new CSVParser(csvFile, this).start();
        } else {
            JOptionPane.showMessageDialog(this, this.properties.getProperty("warningCSVParser"), this.properties.getProperty("titleWarning"), JOptionPane.WARNING_MESSAGE, null);
        }
    }//GEN-LAST:event_jButtonIntersectionActionPerformed

    private void jButtonCleanCsvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCleanCsvActionPerformed
        this.csvFile = null;
        this.jTextAreaCsvFile.setText("");
    }//GEN-LAST:event_jButtonCleanCsvActionPerformed

    private void jButtonSelectXmlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelectXmlActionPerformed
        JFileChooser c = new JFileChooser();
        c.setMultiSelectionEnabled(true);
        FileNameExtensionFilter xmlfilter = new FileNameExtensionFilter("xml files (*.xml)", "xml");
        c.setDialogTitle("Open schedule file");
        c.setFileFilter(xmlfilter);
        c.showOpenDialog(this);
        File[] files = c.getSelectedFiles();

        try {
            if (files != null) {
                long length = 0;
                for (File f : files) {
                    if (f.getName().contains("xml")) {
                        this.xmlFiles.add(f);
                        length += f.length();
                        Path path = Paths.get(f.getName());
                        if (this.jTextAreaXmlFiles.getText().equals("")) {
                            this.jTextAreaXmlFiles.setText(path.toString());
                        } else {
                            this.jTextAreaXmlFiles.setText(this.jTextAreaXmlFiles.getText() + "\n" + path.toString());
                        }
                    }
                }
            }

        } catch (Exception e1) {
            JOptionPane.showMessageDialog(this, this.properties.getProperty("errorXMLParser"), this.properties.getProperty("titleError"), JOptionPane.ERROR_MESSAGE, null);
        }
    }//GEN-LAST:event_jButtonSelectXmlActionPerformed

    private void jButtonConvertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConvertActionPerformed
        if (!xmlFiles.isEmpty() && !jTextFieldProjectName.getText().isEmpty()) {
            this.data.setNameProject(jTextFieldProjectName.getText());
            new XMLParser(this.xmlFiles, this).start();
        } else {
            JOptionPane.showMessageDialog(this, this.properties.getProperty("warningXMLParser"), this.properties.getProperty("titleWarning"), JOptionPane.WARNING_MESSAGE, null);
        }
    }//GEN-LAST:event_jButtonConvertActionPerformed

    private void jButtonCleanXmlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCleanXmlActionPerformed
        this.xmlFiles.clear();
        this.jTextAreaXmlFiles.setText("");
    }//GEN-LAST:event_jButtonCleanXmlActionPerformed

    private void jMenuNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuNewActionPerformed
        clearFields();
        enablePanel(false);
    }//GEN-LAST:event_jMenuNewActionPerformed

    private void jMenuInstancesDesignPatternActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuInstancesDesignPatternActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuInstancesDesignPatternActionPerformed

    private void jMenuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuExitActionPerformed

    private void jMenuNewCSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuNewCSVActionPerformed
        if (!this.data.getDesignPatterns().isEmpty()) {
            clearCSVFields();
            enableCSVPanel(true);
        }
    }//GEN-LAST:event_jMenuNewCSVActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if(!this.data.getDesignPatterns().isEmpty() && (!this.data.getIntersectionType().isEmpty()) || !this.data.getIntersectionMethod().isEmpty()){
            ResultsIntersectionForm screenIntersection = new ResultsIntersectionForm();
            screenIntersection.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, this.properties.getProperty("warningViewIntersection"), this.properties.getProperty("titleWarning"), JOptionPane.WARNING_MESSAGE, null);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void clearFields() {
        this.data.clear();
        this.xmlFiles = new LinkedHashSet<>();
        this.csvFile = null;
        this.jTextFieldBadSmellName.setText("");
        this.jTextAreaCsvFile.setText("");
        this.jComboBoxTypeBadSmell.setSelectedIndex(0);
        this.jTextFieldProjectName.setText("");
        this.jTextAreaXmlFiles.setText("");
    }

    private void clearCSVFields() {
        this.data.clearCSV();
        this.csvFile = null;
        this.jTextFieldBadSmellName.setText("");
        this.jTextAreaCsvFile.setText("");
        this.jComboBoxTypeBadSmell.setSelectedIndex(0);
    }

    public JDialog getLoadingDialog() {
        return this.loadingDialog;
    }

    public JProgressBar getProgress() {
        return this.progress;
    }

    public void enablePanel(boolean enable) {
        enableCSVPanel(enable);
        enableXMLPanel(enable);
    }

    private void enableXMLPanel(boolean enable) {
        this.jLabelProjectName.setEnabled(!enable);
        this.jTextFieldProjectName.setEnabled(!enable);
        this.jLabelXmlFiles.setEnabled(!enable);
        this.jTextAreaXmlFiles.setEnabled(!enable);
        this.jButtonSelectXml.setEnabled(!enable);
        this.jButtonCleanXml.setEnabled(!enable);
        this.jButtonConvert.setEnabled(!enable);
    }

    public void enableCSVPanel(boolean enable) {
        this.jLabelBadSmellName.setEnabled(enable);
        this.jTextFieldBadSmellName.setEnabled(enable);
        this.jLabelTypeBadSmell.setEnabled(enable);
        this.jComboBoxTypeBadSmell.setEnabled(enable);
        this.jLabelCsvFile.setEnabled(enable);
        this.jTextAreaCsvFile.setEnabled(enable);
        this.jButtonSelectCSV.setEnabled(enable);
        this.jButtonCleanCsv.setEnabled(enable);
        this.jButtonIntersection.setEnabled(enable);
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
            java.util.logging.Logger.getLogger(DPSForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DPSForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DPSForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DPSForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DPSForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCleanCsv;
    private javax.swing.JButton jButtonCleanXml;
    private javax.swing.JButton jButtonConvert;
    private javax.swing.JButton jButtonIntersection;
    private javax.swing.JButton jButtonSelectCSV;
    private javax.swing.JButton jButtonSelectXml;
    private javax.swing.JComboBox jComboBoxTypeBadSmell;
    private javax.swing.JLabel jLabelBadSmellName;
    private javax.swing.JLabel jLabelCsvFile;
    private javax.swing.JLabel jLabelProjectName;
    private javax.swing.JLabel jLabelTypeBadSmell;
    private javax.swing.JLabel jLabelXmlFiles;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jMenuExit;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenuItem jMenuInstancesDesignPattern;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuNew;
    private javax.swing.JMenuItem jMenuNewCSV;
    private javax.swing.JMenu jMenuResults;
    private javax.swing.JPanel jPanelBadSmell;
    private javax.swing.JPanel jPanelDesignPattern;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTextArea jTextAreaCsvFile;
    private javax.swing.JTextArea jTextAreaXmlFiles;
    private javax.swing.JTextField jTextFieldBadSmellName;
    private javax.swing.JTextField jTextFieldProjectName;
    // End of variables declaration//GEN-END:variables
    private Set<File> xmlFiles;
    private File csvFile;
    private JDialog loadingDialog = new JDialog(this, "", true);
    private JProgressBar progress = new JProgressBar(0, 0);
    private Data data;
    private Properties properties;
}
