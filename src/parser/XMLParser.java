/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.io.File;
import java.util.Set;

/**
 *
 * @author bruno
 */
public class XMLParser extends Thread{
    
    private Set<File> files;
    private String nameProject;

    public XMLParser(Set<File> files, String name) {
        this.files = files;
        this.nameProject = name;
    }

    @Override
    public void run() {
        //Put here the code of CSV parse.
    }

    void finish() {
        //Closes the progress bar.
    }

    public void incrementProgress() {
        //Counter of progress bar
    }
}
