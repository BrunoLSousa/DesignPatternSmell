/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns;

import designpatterns.roles.ConcreteElement;
import designpatterns.roles.VisitorRole;
import designpatterns.structure.Method;
import designpatterns.structure.MethodBadSmell;
import designpatterns.structure.Type;
import java.util.ArrayList;
import java.util.List;
import org.jdom2.Element;

/**
 *
 * @author bruno
 */
public class Visitor extends DesignPattern {

    private List<VisitorRole> visitors;

    public Visitor(String name) {
        super(name);
        this.visitors = new ArrayList<>();
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
            int indexVisitor = -1;
            ConcreteElement concreteElement = null;
            for (Element r : roles) {
                if (r.getAttributeValue("name").equals("Visitor")) {
                    indexVisitor = addVisitor(r.getAttributeValue("element"), concreteElement);
                } else if (r.getAttributeValue("name").equals("ConcreteElement")) {
                    concreteElement = addConcreteElement(r.getAttributeValue("element"), indexVisitor);
                    addClass();
                } else if (r.getAttributeValue("name").equals("Accept()")) {
                    this.visitors.get(indexVisitor).lastConcreteElementAttribute().addAccept(r.getAttributeValue("element"), r.getAttributeValue("name"));
                    addMethod();
                }
            }
        }
        return element;
    }

    private int addVisitor(String visitor, ConcreteElement concreteElement) {
        VisitorRole newVisitor = new VisitorRole(visitor);
        int index = 0;
        for (VisitorRole v : this.visitors) {
            if (v.getName().equals(newVisitor.getName()) && v.getPack().equals(newVisitor.getPack())) {
                addConcreteElementException(concreteElement, index);
                return index;
            }
            index++;
        }
        this.visitors.add(newVisitor);
        addClass();
        addConcreteElementException(concreteElement, index);
        return index;
    }

    private void addConcreteElementException(ConcreteElement concreteElement, int indexVisitor) {
        if (concreteElement != null) {
            VisitorRole visitor = this.visitors.get(indexVisitor);
            visitor.addConcretElement(concreteElement);
        }
    }

    private ConcreteElement addConcreteElement(String concreteElement, int indexVisitor) {
        ConcreteElement concreteElementAttribute = new ConcreteElement(concreteElement);
        if (indexVisitor != -1) {
            this.visitors.get(indexVisitor).addConcretElement(concreteElementAttribute);
        }
        return concreteElementAttribute;
    }

    @Override
    public Type verifyIfTypeExist(Type type) {
        for (VisitorRole visitor : this.visitors) {
            if (visitor.isEquals(type)) {
                return visitor;
            }
            for (ConcreteElement concreteElement : visitor.getConcretElements()) {
                if (concreteElement.isEquals(type)) {
                    return concreteElement;
                }
            }
        }
        return null;
    }

    @Override
    public Method verifyIfMethodExist(MethodBadSmell method) {
        for (VisitorRole visitor : this.visitors) {
            for (ConcreteElement concreteElement : visitor.getConcretElements()) {
                for (Method accept : concreteElement.getAccepts()) {
                    if (method.isEquals(accept, concreteElement)) {
                        return accept;
                    }
                }
            }
        }
        return null;
    }

}
