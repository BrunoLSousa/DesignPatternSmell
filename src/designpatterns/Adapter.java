/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns;

import designpatterns.roles.Adaptee;
import designpatterns.roles.AdapterRole;
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
public class Adapter extends DesignPattern{

    private List<Adaptee> adaptees;
    
    public Adapter(String name) {
        super(name);
        this.adaptees = new ArrayList<>();
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
            AdapterRole adapter = null;
            int indexAdapteeReceiver = -1;
            for (Element r : roles) {
                if (r.getAttributeValue("name").equals("Adaptee")) {
                    indexAdapteeReceiver = addAdaptee(r.getAttributeValue("element"), adapter);
                } else if (r.getAttributeValue("name").equals("Adapter")) {
                    adapter = addAdapterAttribute(r.getAttributeValue("element"), indexAdapteeReceiver);
                    addClass();
                } else if (r.getAttributeValue("name").equals("adaptee")) {
                    this.adaptees.get(indexAdapteeReceiver).lastAdapterConcrete().addAttribute(r.getAttributeValue("element"), r.getAttributeValue("name"));
                } else if (r.getAttributeValue("name").equals("Request()")) {
                    this.adaptees.get(indexAdapteeReceiver).lastAdapterConcrete().addRequest(r.getAttributeValue("element"), r.getAttributeValue("name"));
                    addMethod();
                }
            }
        }
        return element;
    }
    
    private int addAdaptee(String adapteeReceiver, AdapterRole adapter) {
        Adaptee adapteeAttribute = new Adaptee(adapteeReceiver);
        int index = 0;
        for (Adaptee adaptee : this.adaptees) {
            if (adaptee.getName().equals(adapteeAttribute.getName()) && adaptee.getPack().equals(adapteeAttribute.getPack())) {
                addAdapterAttributeException(adapter, index);
                return index;
            }
            index++;
        }
        this.adaptees.add(adapteeAttribute);
        addClass();
        addAdapterAttributeException(adapter, index);
        return index;
    }

    private void addAdapterAttributeException(AdapterRole adapter, int indexAdapteeReceiver) {
        if (adapter != null) {
            Adaptee adapteeAttribute = this.adaptees.get(indexAdapteeReceiver);
            adapteeAttribute.addAdapterConcrete(adapter);
        }
    }

    private AdapterRole addAdapterAttribute(String adapterConcrete, int indexAdapteeReceiver) {
        AdapterRole newAdapter = new AdapterRole(adapterConcrete);
        if (indexAdapteeReceiver != -1) {
            Adaptee adapteeReceiver = this.adaptees.get(indexAdapteeReceiver);
            adapteeReceiver.addAdapterConcrete(newAdapter);
        }
        return newAdapter;
    }

    @Override
    public Type verifyIfTypeExist(Type type) {
        for (Adaptee adaptee : this.adaptees) {
            if (adaptee.isEquals(type)) {
                return adaptee;
            }
            for (AdapterRole adapter : adaptee.getAdapterConcretes()) {
                if (adapter.isEquals(type)) {
                    return adapter;
                }
            }
        }
        return null;
    }

    @Override
    public Method verifyIfMethodExist(MethodBadSmell method) {
        for (Adaptee adaptee : this.adaptees) {
            for (AdapterRole adapter : adaptee.getAdapterConcretes()) {
                for (Method request : adapter.getRequest()) {
                    if (method.isEquals(request, adapter)) {
                        return  request;
                    }
                }
            }
        }
        return null;
    }
    
}
