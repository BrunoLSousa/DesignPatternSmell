/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import data.Data;
import designpatterns.config.PropertiesManager;
import designpatterns.structure.MethodBadSmell;
import designpatterns.structure.Type;
import gui.DPSForm;
import java.awt.Dimension;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 *
 * @author bruno
 */
public class CSVParser extends Thread {

    private File file;
    private DPSForm screen;
    private Properties properties;
    private Data data;

    public CSVParser(File file, DPSForm screen) {
        this.file = file;
        this.screen = screen;
        this.properties = PropertiesManager.getInstance().getProperties();
        this.data = Data.getInstance();
    }

    @Override
    public void run() {
        //Put here the code of CSV parse.
        screen.getLoadingDialog().setTitle("Carregando Bad Smell...");
        screen.getProgress().setMaximum(sum());
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(this.file.getAbsolutePath()));
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                addArtifact(line);
                incrementProgress(line.length());
            }
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CSVParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CSVParser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException ex) {
                Logger.getLogger(CSVParser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        finish();
        activeIntersection();
    }

    public void addArtifact(String line) {
        //Makes the parser of each class or method in the CSV file.
        String delimit = "";
        delimit = (line.contains(";")) ? ";" : ",";
        String[] split = line.split(delimit);
        if (this.data.getTypeBadSmell().equals(this.properties.getProperty("optionClass"))) {
            Type type = new Type(split[0], split[2]);
            this.data.addTypeBadSmell(type);
        } else if (this.data.getTypeBadSmell().equals(this.properties.getProperty("optionMethod"))) {
            String[] nameType = split[1].split("\\.");
            Type type = new Type(nameType[0], split[2]);
            MethodBadSmell method = new MethodBadSmell(type, split[0], "");
            this.data.addMethodBadSmell(method);
        }
    }

    private void activeIntersection(){
        IntersectionParser intersection = new IntersectionParser(screen);
        intersection.start();
    }
    
    private void finish() {
        //Closes the progress bar.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                screen.getProgress().setValue(0);
                screen.getLoadingDialog().setVisible(false);
            }
        });
    }

    private int sum() {
        //Calculates the sum of files.
        int sum = 0;
        sum += (int) this.file.length();
        return sum;
    }

    private void incrementProgress(final int length) {
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
                screen.getProgress().setValue(screen.getProgress().getValue() + length);
            }
        });
    }
}
