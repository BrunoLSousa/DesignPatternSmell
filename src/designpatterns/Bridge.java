/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns;

import designpatterns.roles.AbstractionBridge;
import designpatterns.roles.Implementor;
import java.util.ArrayList;
import java.util.List;
import org.jdom2.Element;

/**
 *
 * @author bruno
 */
public class Bridge extends DesignPattern {

    private List<AbstractionBridge> abstraction;
    private List<Implementor> implementor;

    public Bridge(String name) {
        super(name);
        this.abstraction = new ArrayList<>();
        this.implementor = new ArrayList<>();
    }

    @Override
    public void countInstaces(Element element) {
        List<Element> elements = element.getChildren();
        for (Element e : elements) {
            addInstance();
        }
    }

    @Override
    public Element convertElement(Element element) {
        List<Element> elements = element.getChildren();
        for (Element e : elements) {
            addInstance();
            List<Element> roles = e.getChildren();
            for (Element r : roles) {
                if (r.getAttributeValue("name").equals("Abstraction")) {
                    addAbstraction(r.getAttributeValue("element"));
                    addClass();
                } else if (r.getAttributeValue("name").equals("Implementor")) {
                    addImplementor(r.getAttributeValue("element"));
                    addClass();
                } else if (r.getAttributeValue("name").equals("implementor")) {
                    this.abstraction.get(instances - 1).setImplementor(r.getAttributeValue("element"), r.getAttributeValue("name"));
                } else if (r.getAttributeValue("name").equals("Operation()")) {
                    this.abstraction.get(instances - 1).addOperation(r.getAttributeValue("element"), r.getAttributeValue("name"));
                    addMethod();
                }
            }
        }
        return element;
    }

    private void addAbstraction(String abstraction) {
        AbstractionBridge abstractionBridge = new AbstractionBridge(abstraction);
        this.abstraction.add(abstractionBridge);
    }

    private void addImplementor(String implementor) {
        Implementor implementorBridge = new Implementor(implementor);
        this.implementor.add(implementorBridge);
    }

}
