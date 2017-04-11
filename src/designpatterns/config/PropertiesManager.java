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
            openProperties();
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
    
    private Properties openProperties() throws IOException{
        properties = new Properties();
        InputStream input = this.getClass().getResourceAsStream("english.properties");
        properties.load(input);
        return properties;
    }
    
    public Properties getProperties(){
        return properties;
    }
    
}
