/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bruno
 */
public class PropertiesManager {
    
    private static PropertiesManager propertiesManager;
    private static Properties properties;
    
    private PropertiesManager(){
        try {
            getProperties();
        } catch (IOException ex) {
            Logger.getLogger(PropertiesManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static PropertiesManager getInstance(){
        if(propertiesManager == null){
            propertiesManager = new PropertiesManager();
        }
        return propertiesManager;
    }
    
    private Properties getProperties() throws IOException{
        properties = new Properties();
        InputStream input = this.getClass().getResourceAsStream("english.properties");
        properties.load(input);
        return properties;
    }
    
    public String getMenu1() {
        return properties.getProperty("menu1");
    }

    public String getSubMenu1_1() {
        return properties.getProperty("submenu1_1");
    }

    public String getSubMenu1_2() {
        return properties.getProperty("submenu1_2");
    }

    public String getSubMenu1_3() {
        return properties.getProperty("submenu1_3");
    }

    public String getPanelDesignPattern() {
        return properties.getProperty("panelDesignPattern");
    }

    public String getLabelNameProject() {
        return properties.getProperty("labelProject");
    }

    public String getLabelFilesXML() {
        return properties.getProperty("labelFileXML");
    }

    public String getButtonSelectFilesXML() {
        return properties.getProperty("buttonSelectXML");
    }

    public String getButtonCleanFiles() {
        return properties.getProperty("buttonClearFiles");
    }

    public String getButtonConvert() {
        return properties.getProperty("buttonConvert");
    }

    public String getPanelBadSmell() {
        return properties.getProperty("panelBadSmell");
    }

    public String getLabelNameBadSmell() {
        return properties.getProperty("labelBadSmell");
    }

    public String getLabelTypeBadSmell() {
        return properties.getProperty("labelType");
    }

    public String getOptionClass() {
        return properties.getProperty("optionClass");
    }

    public String getOptionMethod() {
        return properties.getProperty("optionMethod");
    }

    public String getLabelFilesCSV() {
        return properties.getProperty("fileCSV");
    }

    public String getButtonSelectFilesCSV() {
        return properties.getProperty("buttonSelectCSV");
    }

    public String getButtonIntersection() {
        return properties.getProperty("buttonIntersection");
    }

    public String getNameWindowProgressLoadXML() {
        return properties.getProperty("loadXML");
    }

    public String getNameWindowIntersectionXMLWithCSV() {
        return properties.getProperty("intersectionXMLCSV");
    }

    public String getNameWindowProgressLoadCSV() {
        return properties.getProperty("loadCSV");
    }

    public String getMenu2() {
        return properties.getProperty("menu2");
    }

    public String getSubMenu2_1() {
        return properties.getProperty("submenu2_1");
    }

    public String getPanelAmountInstances() {
        return properties.getProperty("panelAmountInstances");
    }

    public String getAmountInstances() {
        return properties.getProperty("amountInstances");
    }

    public String getButtonExportCSV() {
        return properties.getProperty("exportCSV");
    }

    public String getLabelTableDesignPattern() {
        return properties.getProperty("tableDesignPattern");
    }

    public String getLabelTableAmount() {
        return properties.getProperty("tableAmount");
    }

    public String getLabelTablePercentual() {
        return properties.getProperty("tablePercentual");
    }

    public String getLabelIntersectionData() {
        return properties.getProperty("labelIntersectionData");
    }

    public String getLabelTotalClassWithBadSmell() {
        return properties.getProperty("classesBadSmell");
    }

    public String getLabelAmount() {
        return properties.getProperty("labelAmount");
    }

    public String getLabelTableAmountAffected() {
        return properties.getProperty("amountAffected");
    }

    public String getLabelTablePercentualAffected() {
        return properties.getProperty("percentualAffected");
    }

    public String getVisualizeArtifactsAffected() {
        return properties.getProperty("vizualizeArtifacts");
    }

    public String getLabelClassAffected() {
        return properties.getProperty("classAffected");
    }

    public String getMessageExportReport() {
        return properties.getProperty("errorReport");
    }

    public String getMessageWarningDoneDesignPatterns() {
        return properties.getProperty("warningDesignPattern");
    }

    public String getMessageWarningDoneBadSmells() {
        return properties.getProperty("warningBadSmell");
    }

    public String getMessageWarningVisualizeInstancesOfPatterns() {
        return properties.getProperty("warningInstances");
    }

    public String getLabelTotalMethodWithBadSmell() {
        return properties.getProperty("methodsBadSmell");
    }

    public String getLabelMethodAffected() {
        return properties.getProperty("methodAffected");
    }

    public String getMessageTitleWarning() {
        return properties.getProperty("warning");
    }

    public String getMessageErrorExportReport() {
        return properties.getProperty("errorExportReport");
    }
    
}
