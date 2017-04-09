/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns;

import designpatterns.roles.SingletonRole;
import designpatterns.structure.Attribute;
import designpatterns.structure.Statement;
import designpatterns.structure.Type;
import java.util.ArrayList;
import java.util.List;
import org.jdom2.Element;

/**
 *
 * @author bruno
 */
public class Singleton extends DesignPattern {

    private List<SingletonRole> singletons;

    public Singleton(String name) {
        super(name);
        this.singletons = new ArrayList<>();
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
                if (r.getAttributeValue("name").equals("Singleton")) {
                    addSingleton(r.getAttributeValue("element"));
                    addClass();
                } else if (r.getAttributeValue("name").equals("uniqueInstance")) {
                    addUniqueInstance(r.getAttributeValue("element"), r.getAttributeValue("name"));
                    addMethod();
                }
            }
        }
        return element;
    }

    private void addSingleton(String singleton) {
        Type newSingleton = new SingletonRole(singleton);
        this.singletons.add((SingletonRole) newSingleton);
    }

    private void addUniqueInstance(String uniqueInstance, String roleDesignPattern) {
        Statement newUniqueInstance = new Attribute(uniqueInstance, roleDesignPattern);
        SingletonRole singleton = this.singletons.get(instances - 1);
        singleton.addUniqueInstance((Attribute) newUniqueInstance);
    }

    private List<SingletonRole> getSingletons() {
        return this.singletons;
    }

    private SingletonRole getSingletonByIndex(int index) {
        return this.singletons.get(index);
    }

}
