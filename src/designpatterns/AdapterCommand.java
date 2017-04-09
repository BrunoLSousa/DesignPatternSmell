/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns;

import designpatterns.roles.AdapteeReceiver;
import designpatterns.roles.AdapterConcrete;
import java.util.ArrayList;
import java.util.List;
import org.jdom2.Element;

/**
 *
 * @author bruno
 */
public class AdapterCommand extends DesignPattern {

    private List<AdapteeReceiver> adapteeReceivers;

    public AdapterCommand(String name) {
        super(name);
        this.adapteeReceivers = new ArrayList<>();
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
            AdapterConcrete adapterConcrete = null;
            int indexAdapteeReceiver = -1;
            for (Element r : roles) {
                if (r.getAttributeValue("name").equals("Adaptee/Receiver")) {
                    indexAdapteeReceiver = addAdapteeReceiver(r.getAttributeValue("element"), adapterConcrete);
                } else if (r.getAttributeValue("name").equals("Adapter/ConcreteCommand")) {
                    adapterConcrete = addAdapterConcreteAttribute(r.getAttributeValue("element"), indexAdapteeReceiver);
                    addClass();
                } else if (r.getAttributeValue("name").equals("adaptee/receiver")) {
                    this.adapteeReceivers.get(indexAdapteeReceiver).lastAdapterConcrete().addAttribute(r.getAttributeValue("element"), r.getAttributeValue("name"));
                } else if (r.getAttributeValue("name").equals("Request()/Execute()")) {
                    this.adapteeReceivers.get(indexAdapteeReceiver).lastAdapterConcrete().addRequest(r.getAttributeValue("element"), r.getAttributeValue("name"));
                    addMethod();
                }
            }
        }
        return element;
    }

    private int addAdapteeReceiver(String adapteeReceiver, AdapterConcrete adapterConcrete) {
        AdapteeReceiver adapteeReceiverAttribute = new AdapteeReceiver(adapteeReceiver);
        int index = 0;
        for (AdapteeReceiver adaptee : this.adapteeReceivers) {
            if (adaptee.getName().equals(adapteeReceiverAttribute.getName()) && adaptee.getPack().equals(adapteeReceiverAttribute.getPack())) {
                addAdapterConcreteAttributeException(adapterConcrete, index);
                return index;
            }
            index++;
        }
        this.adapteeReceivers.add(adapteeReceiverAttribute);
        addClass();
        addAdapterConcreteAttributeException(adapterConcrete, index);
        return index;
    }

    private void addAdapterConcreteAttributeException(AdapterConcrete adapterConcrete, int indexAdapteeReceiver) {
        if (adapterConcrete != null) {
            AdapteeReceiver adapteeReceiverAttribute = this.adapteeReceivers.get(indexAdapteeReceiver);
            adapteeReceiverAttribute.addAdapterConcrete(adapterConcrete);
        }
    }

    private AdapterConcrete addAdapterConcreteAttribute(String adapterConcrete, int indexAdapteeReceiver) {
        AdapterConcrete newAdapterConcrete = new AdapterConcrete(adapterConcrete);
        if (indexAdapteeReceiver != -1) {
            AdapteeReceiver adapteeReceiver = this.adapteeReceivers.get(indexAdapteeReceiver);
            adapteeReceiver.addAdapterConcrete(newAdapterConcrete);
        }
        return newAdapterConcrete;
    }    

}
