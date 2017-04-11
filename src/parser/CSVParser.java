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
public class CSVParser extends Thread{
    
    private Set<File> files;

    public CSVParser(Set<File> files) {
        this.files = files;
    }

    @Override
    public void run() {
        //Put here the code of CSV parse.
    }

    public void addArtifact(String line) {
        //Makes the parser of each class or method in the CSV file.
    }

    private void finish() {
        //Closes the progress bar.
    }

    private int sum() {
        //Calculates the sum of files.
        return 0;
    }

    private void incrementProgress(final int length) {
        //Counter of progress bar
    }
}
