/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import data.Data;
import designpatterns.DesignPattern;
import designpatterns.config.PropertiesManager;
import designpatterns.structure.Method;
import designpatterns.structure.MethodBadSmell;
import designpatterns.structure.Type;
import gui.DPSForm;
import java.awt.Dimension;
import java.awt.Point;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author bruno
 */
public class IntersectionParser extends Thread{

    private Data data;
    private Properties properties;
    private HashMap<String, Set<Type>> intersectionType;
    private HashMap<String, Set<Method>> intersectionMethod;
    private DPSForm screen;

    public IntersectionParser(DPSForm screen) {
        this.data = Data.getInstance();
        this.properties = PropertiesManager.getInstance().getProperties();
        initializeMapType();
        initializeMapMethod();
        this.screen = screen;
    }
    
    @Override
    public void run() {
        //Put here the code of CSV parse.
        configureProgressBar();
        intersection();
        finish();
        this.screen.enableCSVPanel(false);
        JOptionPane.showMessageDialog(null, this.properties.getProperty("confirmationIntersection"), this.properties.getProperty("titleConfirmation"), JOptionPane.INFORMATION_MESSAGE, null);
    }

    private void configureProgressBar() {
        Properties properties = PropertiesManager.getInstance().getProperties();
        List<Object> badSmells = (List<Object>) this.data.badSmellData();
        screen.getProgress().setMaximum(badSmells.size());
        screen.getLoadingDialog().setTitle(properties.getProperty("progressBarIntersection"));
        screen.getLoadingDialog().setSize(200, 40);
    }

    private void finish() {
        //Closes the progress bar.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                screen.getProgress().setValue(0);
                screen.getLoadingDialog().setVisible(false);
            }
        });
        screen.enablePanel(true);
    }

    public void incrementProgress() {
        //Counter of progress bar
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                if (!screen.getLoadingDialog().isVisible()) {
                    Dimension dsize = screen.getLoadingDialog().getSize();
                    Dimension fsize = screen.getSize();
                    Point p = new Point((fsize.width - dsize.width) / 2, (fsize.height - dsize.height) / 2);
                    SwingUtilities.convertPointToScreen(p, screen);
                    screen.getLoadingDialog().setLocation(p);
                    screen.getLoadingDialog().setVisible(true);
                }
                screen.getProgress().setValue(screen.getProgress().getValue() + 1);

            }
        });
    }

    public void intersection() {
        List<Object> badSmells = (List<Object>) this.data.badSmellData();
        if (badSmells.get(0) instanceof Type) {
            intersectionClass(badSmells);
        } else {
            intersectionMethod(badSmells);
        }
    }

    private void intersectionClass(List<Object> badSmellList) {
        for (Object object : badSmellList) {
            Type t = (Type) object;
            Collection<DesignPattern> designPatterns = Data.getInstance().getDesignPatterns().values();
            for (DesignPattern dp : designPatterns) {
                Type type = dp.verifyIfTypeExist(t);
                if (type != null) {
                    intersectionType.get(dp.getName()).add(type);
                }
            }
            incrementProgress();
        }
        this.data.setIntersectionType(intersectionType);
    }

    private void intersectionMethod(List<Object> badSmellList) {
        for (Object object : badSmellList) {
            MethodBadSmell m = (MethodBadSmell) object;
            Collection<DesignPattern> designPatterns = Data.getInstance().getDesignPatterns().values();
            for (DesignPattern dp : designPatterns) {
                Method method = dp.verifyIfMethodExist(m);
                if (method != null) {
                    intersectionMethod.get(dp.getName()).add(method);
                }
            }
            incrementProgress();
        }
        this.data.setIntersectionMethod(intersectionMethod);
    }
    
    private void initializeMapType(){
        this.intersectionType = new HashMap<>();
        this.intersectionType.put("(Object)Adapter-Command", new LinkedHashSet<Type>());
        this.intersectionType.put("Bridge", new LinkedHashSet<Type>());
        this.intersectionType.put("Composite", new LinkedHashSet<Type>());
        this.intersectionType.put("Decorator", new LinkedHashSet<Type>());
        this.intersectionType.put("Factory Method", new LinkedHashSet<Type>());
        this.intersectionType.put("Observer", new LinkedHashSet<Type>());
        this.intersectionType.put("Prototype", new LinkedHashSet<Type>());
        this.intersectionType.put("Proxy", new LinkedHashSet<Type>());
        this.intersectionType.put("Proxy2", new LinkedHashSet<Type>());
        this.intersectionType.put("Singleton", new LinkedHashSet<Type>());
        this.intersectionType.put("State-Strategy", new LinkedHashSet<Type>());
        this.intersectionType.put("Template Method", new LinkedHashSet<Type>());
        this.intersectionType.put("Visitor", new LinkedHashSet<Type>());
    }
    
    private void initializeMapMethod(){
        this.intersectionMethod = new HashMap<>();
        this.intersectionMethod.put("(Object)Adapter-Command", new LinkedHashSet<Method>());
        this.intersectionMethod.put("Bridge", new LinkedHashSet<Method>());
        this.intersectionMethod.put("Composite", new LinkedHashSet<Method>());
        this.intersectionMethod.put("Decorator", new LinkedHashSet<Method>());
        this.intersectionMethod.put("Factory Method", new LinkedHashSet<Method>());
        this.intersectionMethod.put("Observer", new LinkedHashSet<Method>());
        this.intersectionMethod.put("Prototype", new LinkedHashSet<Method>());
        this.intersectionMethod.put("Proxy", new LinkedHashSet<Method>());
        this.intersectionMethod.put("Proxy2", new LinkedHashSet<Method>());
        this.intersectionMethod.put("Singleton", new LinkedHashSet<Method>());
        this.intersectionMethod.put("State-Strategy", new LinkedHashSet<Method>());
        this.intersectionMethod.put("Template Method", new LinkedHashSet<Method>());
        this.intersectionMethod.put("Visitor", new LinkedHashSet<Method>());
    }
    
}
