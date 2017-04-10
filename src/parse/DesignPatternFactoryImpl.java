/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parse;

import designpatterns.AdapterCommand;
import designpatterns.Bridge;
import designpatterns.Composite;
import designpatterns.Decorator;
import designpatterns.DesignPattern;
import designpatterns.FactoryMethod;
import designpatterns.Observer;
import designpatterns.Prototype;
import designpatterns.Proxy;
import designpatterns.Proxy2;
import designpatterns.Singleton;
import designpatterns.StateStrategy;
import designpatterns.TemplateMethod;
import designpatterns.Visitor;
import org.jdom2.Element;

/**
 *
 * @author bruno
 */
public class DesignPatternFactoryImpl implements DesignPatternFactory{

    @Override
    public DesignPattern createDesignPattern(Element element) {
        DesignPattern designPattern = null;
        String name = element.getAttributeValue("name");
        switch(name){
            case "Factory Method":
                designPattern = new FactoryMethod(name);
                break;
            case "Prototype":
                designPattern = new Prototype(name);
                break;
            case "Singleton":
                designPattern = new Singleton(name);
                break;
            case "(Object)Adapter-Command":
                designPattern = new AdapterCommand(name);
                break;
            case "Composite":
                designPattern = new Composite(name);
                break;
            case "Decorator":
                designPattern = new Decorator(name);
                break;
            case "Observer":
                designPattern = new Observer(name);
                break;
            case "State-Strategy":
                designPattern = new StateStrategy(name);
                break;
            case "Bridge":
                designPattern = new Bridge(name);
                break;
            case "Template Method":
                designPattern = new TemplateMethod(name);
                break;
            case "Visitor":
                designPattern = new Visitor(name);
                break;
            case "Proxy":
                designPattern = new Proxy(name);
                break;
            case "Proxy2":
                designPattern = new Proxy2(name);
                break;
        }
        return designPattern;
    }
    
}
