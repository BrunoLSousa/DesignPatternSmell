/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import designpatterns.DesignPattern;
import org.jdom2.Element;

/**
 *
 * @author bruno
 */
public interface DesignPatternFactory {
    
    public DesignPattern createDesignPattern(Element element);
    
}
