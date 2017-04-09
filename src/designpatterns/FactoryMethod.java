/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns;

import designpatterns.roles.Creator;
import java.util.ArrayList;
import java.util.List;
import org.jdom2.Element;
import designpatterns.structure.Method;
import designpatterns.structure.MethodBadSmell;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author bruno
 */
public class FactoryMethod extends DesignPattern {

    private List<Creator> creators;

    public FactoryMethod(String name) {
        super(name);
        this.creators = new ArrayList<>();
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
                if (r.getAttributeValue("name").equals("Creator")) {
                    addCreator(r.getAttributeValue("element"));
                    addClass();
                } else if (r.getAttributeValue("name").equals("FactoryMethod()")) {
                    this.creators.get(instances - 1).addFactoryMethod(r.getAttributeValue("element"), r.getAttributeValue("name"));
                    addMethod();
                }
            }
        }
        return element;
    }

    private void addCreator(String creator) {
        Creator newCreator = new Creator(creator);
        this.creators.add((Creator) newCreator);
    }

}
