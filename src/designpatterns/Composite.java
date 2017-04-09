/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns;

import designpatterns.roles.ComponentComposite;
import designpatterns.roles.CompositeRole;
import designpatterns.structure.Attribute;
import designpatterns.structure.Method;
import designpatterns.structure.Statement;
import designpatterns.structure.Type;
import java.util.ArrayList;
import java.util.List;
import org.jdom2.Element;

/**
 *
 * @author bruno
 */
public class Composite extends DesignPattern {

    private List<ComponentComposite> components;

    public Composite(String name) {
        super(name);
        this.components = new ArrayList<>();
    }

    @Override
    public void addInstance() {
        this.instances++;
    }

    @Override
    public int getInstaces() {
        return this.instances;
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
                if (r.getAttributeValue("name").equals("Component")) {
                    addComponetUpperCase(r.getAttributeValue("element"));
                    addClass();
                } else if (r.getAttributeValue("name").equals("Composite")) {
                    addComposite(r.getAttributeValue("element"));
                    addClass();
                } else if (r.getAttributeValue("name").equals("component")) {
                    addComponenteLowerCase(r.getAttributeValue("element"), r.getAttributeValue("name"));
                } else if (r.getAttributeValue("name").equals("Operation()")) {
                    addOperation(r.getAttributeValue("element"), r.getAttributeValue("name"));
                    addMethod();
                }
            }
        }
        return element;
    }

    public void addComponetUpperCase(String component) {
        Type newComponent = new ComponentComposite(component);
        this.components.add((ComponentComposite) newComponent);
    }

    public void addComposite(String composite) {
        CompositeRole newComposite = new CompositeRole(composite);
        this.components.get(instances - 1).setComposite(newComposite);
    }

    public void addComponenteLowerCase(String component, String rolesDesignPattern) {
        Statement newAttribute = new Attribute(component, rolesDesignPattern);
        this.components.get(instances - 1).getComposite().setAttribute((Attribute) newAttribute);
    }

    public void addOperation(String operation, String rolesDesignPattern) {
        Statement newMethod = new Method(operation, rolesDesignPattern);
        this.components.get(instances - 1).getComposite().addOperation((Method) newMethod);
    }

}
