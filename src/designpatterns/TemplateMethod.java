/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns;

import designpatterns.roles.AbstractTemplateMethod;
import java.util.ArrayList;
import java.util.List;
import org.jdom2.Element;

/**
 *
 * @author bruno
 */
public class TemplateMethod extends DesignPattern {

    private List<AbstractTemplateMethod> templateMethods;

    public TemplateMethod(String name) {
        super(name);
        this.templateMethods = new ArrayList<>();
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
                if (r.getAttributeValue("name").equals("AbstractClass")) {
                    addAbstractClass(r.getAttributeValue("element"));
                    addClass();
                } else if (r.getAttributeValue("name").equals("TemplateMethod()")) {
                    this.templateMethods.get(instances - 1).addTemplateMethod(r.getAttributeValue("element"), r.getAttributeValue("name"));
                    addMethod();
                }
            }
        }
        return element;
    }

    private void addAbstractClass(String abstractClass) {
        AbstractTemplateMethod newTemplateMethod = new AbstractTemplateMethod(abstractClass);
        this.templateMethods.add(newTemplateMethod);
    }

}
