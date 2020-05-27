/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns;

import designpatterns.roles.Handler;
import designpatterns.structure.Attribute;
import designpatterns.structure.Method;
import designpatterns.structure.MethodBadSmell;
import designpatterns.structure.Statement;
import designpatterns.structure.Type;
import java.util.ArrayList;
import java.util.List;
import org.jdom2.Element;

/**
 *
 * @author bruno
 */
public class ChainResponsability extends DesignPattern {

    private List<Handler> handlers;

    public ChainResponsability(String name) {
        super(name);
        this.handlers = new ArrayList<>();
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
                if (r.getAttributeValue("name").equals("Handler")) {
                    ChainResponsability.this.addSuccessor(r.getAttributeValue("element"));
                    addClass();
                } else if (r.getAttributeValue("name").equals("successor")) {
                    addSuccessor(r.getAttributeValue("element"), r.getAttributeValue("name"));
                    addMethod();
                }
            }
        }
        return element;
    }

    private void addSuccessor(String successor) {
        Type newHandler = new Handler(successor);
        this.handlers.add((Handler) newHandler);
    }

    private void addSuccessor(String successor, String roleDesignPattern) {
        Statement newSuccessor = new Attribute(successor, roleDesignPattern);
        Handler handler = this.handlers.get(instances - 1);
        handler.addSuccessor((Attribute) newSuccessor);
    }

    private List<Handler> getHandlers() {
        return this.handlers;
    }

    private Handler getHandlerByIndex(int index) {
        return this.handlers.get(index);
    }

    @Override
    public Type verifyIfTypeExist(Type type) {
        for (Handler handler : this.handlers) {
            if (handler.isEquals(type)) {
                return handler;
            }
        }
        return null;
    }

    @Override
    public Method verifyIfMethodExist(MethodBadSmell method) {
        return null;
    }

}
