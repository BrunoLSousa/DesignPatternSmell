/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import data.Data;
import designpatterns.DesignPattern;
import designpatterns.config.PropertiesManager;
import factory.DesignPatternFactory;
import factory.DesignPatternFactoryImpl;
import gui.DPSForm;
import java.awt.Dimension;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author bruno
 */
public class XMLParser extends Thread {

    private Set<File> files;
    private String nameProject;
    private Data data;
    private DPSForm screen;

    public XMLParser(Set<File> files, String name, DPSForm screen) {
        this.files = files;
        this.nameProject = name;
        this.data = Data.getInstance();
        this.screen = screen;
    }

    @Override
    public void run() {
        //Put here the code of CSV parse.
        configureProgressBar();
        for (File f : this.files) {
            try {
                Iterator i = openXML(f);
                DesignPattern designPattern = null;
                while (i.hasNext()) {
                    Element e = (Element) i.next();
                    if (e.getName().equals("pattern")) {
                        if (this.data.getDesignPatternByKey(e.getAttributeValue("name")) != null) {
                            designPattern = this.data.getDesignPatternByKey(e.getAttributeValue("name"));
                        } else {
                            DesignPatternFactory el = new DesignPatternFactoryImpl();
                            designPattern = el.createDesignPattern(e);
                            this.data.getDesignPatterns().put(designPattern.getName(), designPattern);
                        }
                        e = designPattern.convertElement(e);
                        incrementProgress();
                    }
                }
            } catch (JDOMException ex) {
                Logger.getLogger(XMLParser.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(XMLParser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        finish();
    }

    private Iterator openXML(File file) throws IOException, JDOMException {
        SAXBuilder builder = new SAXBuilder();
        Document doc = builder.build(file);
        Element root = (Element) doc.getRootElement();
        List<Element> element = root.getChildren();
        element.iterator();
        return element.iterator();
    }

    private void configureProgressBar() {
        Properties properties = PropertiesManager.getInstance().getProperties();
        screen.getProgress().setMaximum(this.files.size() * 13);
        screen.getLoadingDialog().setTitle(properties.getProperty("progressBarXMLConvert"));
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
}
