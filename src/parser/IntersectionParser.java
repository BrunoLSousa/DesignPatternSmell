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
import gui.ResultsIntersectionForm;
import java.awt.Dimension;
import java.awt.Point;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import javax.swing.SwingUtilities;

/**
 *
 * @author bruno
 */
public class IntersectionParser extends Thread{

    private Data data;
    private HashMap<String, Set<Object>> intersection;
    private DPSForm screen;

    public IntersectionParser(DPSForm screen) {
        this.data = Data.getInstance();
        initializeMap();
        this.screen = screen;
    }
    
    @Override
    public void run() {
        //Put here the code of CSV parse.
        configureProgressBar();
        intersection();
        finish();
        this.screen.enableCSVPanel(false);
        ResultsIntersectionForm results = new ResultsIntersectionForm();
        results.setVisible(true);
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
                    intersection.get(dp.getName()).add(type);
                    break;
                }
            }
            incrementProgress();
        }
        this.data.setIntersection(intersection);
    }

    private void intersectionMethod(List<Object> badSmellList) {
        for (Object object : badSmellList) {
            MethodBadSmell m = (MethodBadSmell) object;
            Collection<DesignPattern> designPatterns = Data.getInstance().getDesignPatterns().values();
            for (DesignPattern dp : designPatterns) {
                Method method = dp.verifyIfMethodExist(m);
                if (method != null) {
                    intersection.get(dp.getName()).add(method);
                    break;
                }
            }
            incrementProgress();
        }
        this.data.setIntersection(intersection);
    }
    
    private void initializeMap(){
        this.intersection = new HashMap<>();
        this.intersection.put("(Object)Adapter/Command", new LinkedHashSet<>());
        this.intersection.put("Bridge", new LinkedHashSet<>());
        this.intersection.put("Composite", new LinkedHashSet<>());
        this.intersection.put("Decorator", new LinkedHashSet<>());
        this.intersection.put("Factory Method", new LinkedHashSet<>());
        this.intersection.put("Observer", new LinkedHashSet<>());
        this.intersection.put("Prototype", new LinkedHashSet<>());
        this.intersection.put("Proxy", new LinkedHashSet<>());
        this.intersection.put("Proxy2", new LinkedHashSet<>());
        this.intersection.put("Singleton", new LinkedHashSet<>());
        this.intersection.put("State-Strategy", new LinkedHashSet<>());
        this.intersection.put("Template Method", new LinkedHashSet<>());
        this.intersection.put("Visitor", new LinkedHashSet<>());
    }
    
}
