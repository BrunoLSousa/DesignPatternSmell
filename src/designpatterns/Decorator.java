/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns;

import designpatterns.roles.ComponentDecorator;
import designpatterns.roles.DecoratorRole;
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
public class Decorator extends DesignPattern {

    private List<ComponentDecorator> decorators;

    public Decorator(String name) {
        super(name);
        this.decorators = new ArrayList<>();
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
            int indexComponent = -1;
            for (Element r : roles) {
                if (r.getAttributeValue("name").equals("Component")) {
                    indexComponent = addComponentUpperCase(r.getAttributeValue("element"));
                } else if (r.getAttributeValue("name").equals("Decorator")) {
                    addDecorator(r.getAttributeValue("element"), indexComponent);
                    addClass();
                } else if (r.getAttributeValue("name").equals("component")) {
                    addComponentLowerCase(r.getAttributeValue("element"), indexComponent, r.getAttributeValue("name"));
                } else if (r.getAttributeValue("name").equals("Operation()")) {
                    addOperation(r.getAttributeValue("element"), indexComponent, r.getAttributeValue("name"));
                    addMethod();
                }
            }
        }
        return element;
    }

    private int addComponentUpperCase(String component) {
        Type newDecorator = new ComponentDecorator(component);
        int index = 0;
        for (Type c : this.decorators) {
            if (c.getName().equals(newDecorator.getName()) && c.getPack().equals(newDecorator.getPack())) {
                return index;
            }
            index++;
        }
        addClass();
        this.decorators.add((ComponentDecorator) newDecorator);
        return index;
    }

    private void addDecorator(String decorator, int indexDecorator) {
        DecoratorRole newDecorator = new DecoratorRole(decorator);
        ComponentDecorator component = this.decorators.get(indexDecorator);
        component.addDecorator(newDecorator);
    }

    private void addComponentLowerCase(String prototypeLowerCase, int indexDecorator, String roleDesignPattern) {
        Statement newAttribute = new Attribute(prototypeLowerCase, roleDesignPattern);
        DecoratorRole decoratorAttribute = this.decorators.get(indexDecorator).lastDecorator();
        decoratorAttribute.addComponent((Attribute) newAttribute);
    }

    private void addOperation(String operation, int indexDecorator, String roleDesignPattern) {
        Statement newOperation = new Method(operation, roleDesignPattern);
        DecoratorRole decoratorAttribute = this.decorators.get(indexDecorator).lastDecorator();
        decoratorAttribute.addOperation((Method) newOperation);
    }

}
