/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns;

import designpatterns.roles.ConcreteRole;
import designpatterns.roles.ReceiverRole;
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
public class Command extends DesignPattern{

    private List<ReceiverRole> receivers;
    
    public Command(String name) {
        super(name);
        this.receivers = new ArrayList<>();
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
            ConcreteRole concrete = null;
            int indexReceiver = -1;
            for (Element r : roles) {
                if (r.getAttributeValue("name").equals("Receiver")) {
                    indexReceiver = addReceiver(r.getAttributeValue("element"), concrete);
                } else if (r.getAttributeValue("name").equals("ConcreteCommand")) {
                    concrete = addConcreteAttribute(r.getAttributeValue("element"), indexReceiver);
                    addClass();
                } else if (r.getAttributeValue("name").equals("receiver")) {
                    this.receivers.get(indexReceiver).lastAdapterConcrete().addAttribute(r.getAttributeValue("element"), r.getAttributeValue("name"));
                } else if (r.getAttributeValue("name").equals("Execute()")) {
                    this.receivers.get(indexReceiver).lastAdapterConcrete().addRequest(r.getAttributeValue("element"), r.getAttributeValue("name"));
                    addMethod();
                }
            }
        }
        return element;
    }
    
    private int addReceiver(String adapteeReceiver, ConcreteRole concrete) {
        ReceiverRole adapteeReceiverAttribute = new ReceiverRole(adapteeReceiver);
        int index = 0;
        for (ReceiverRole adaptee : this.receivers) {
            if (adaptee.getName().equals(adapteeReceiverAttribute.getName()) && adaptee.getPack().equals(adapteeReceiverAttribute.getPack())) {
                addConcreteAttributeException(concrete, index);
                return index;
            }
            index++;
        }
        this.receivers.add(adapteeReceiverAttribute);
        addClass();
        addConcreteAttributeException(concrete, index);
        return index;
    }

    private void addConcreteAttributeException(ConcreteRole concrete, int indexReceiver) {
        if (concrete != null) {
            ReceiverRole receiverAttribute = this.receivers.get(indexReceiver);
            receiverAttribute.addAdapterConcrete(concrete);
        }
    }

    private ConcreteRole addConcreteAttribute(String  concrete, int indexReceiver) {
        ConcreteRole newConcrete = new ConcreteRole(concrete);
        if (indexReceiver != -1) {
            ReceiverRole receiver = this.receivers.get(indexReceiver);
            receiver.addAdapterConcrete(newConcrete);
        }
        return newConcrete;
    }

    @Override
    public Type verifyIfTypeExist(Type type) {
        for (ReceiverRole adapteeReceiver : this.receivers) {
            if (adapteeReceiver.isEquals(type)) {
                return adapteeReceiver;
            }
            for (ConcreteRole adapterConcrete : adapteeReceiver.getAdapterConcretes()) {
                if (adapterConcrete.isEquals(type)) {
                    return adapterConcrete;
                }
            }
        }
        return null;
    }

    @Override
    public Method verifyIfMethodExist(MethodBadSmell method) {
        for (ReceiverRole adapteeReceiver : this.receivers) {
            for (ConcreteRole adapterConcrete : adapteeReceiver.getAdapterConcretes()) {
                for (Method request : adapterConcrete.getRequest()) {
                    if (method.isEquals(request, adapterConcrete)) {
                        return  request;
                    }
                }
            }
        }
        return null;
    }
    
}
