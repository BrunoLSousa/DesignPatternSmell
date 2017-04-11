/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns;

import designpatterns.roles.Client;
import designpatterns.roles.PrototypeRole;
import java.util.ArrayList;
import java.util.List;
import org.jdom2.Element;
import designpatterns.structure.Attribute;
import designpatterns.structure.Method;
import designpatterns.structure.MethodBadSmell;
import designpatterns.structure.Statement;
import designpatterns.structure.Type;

/**
 *
 * @author bruno
 */
public class Prototype extends DesignPattern {

    private List<PrototypeRole> prototypes;

    public Prototype(String name) {
        super(name);
        this.prototypes = new ArrayList<>();
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
            int indexPrototype = -1;
            Client client = null;
            for (Element r : roles) {
                if (r.getAttributeValue("name").equals("Prototype")) {
                    indexPrototype = addPrototypeUpperCase(r.getAttributeValue("element"), client);
                } else if (r.getAttributeValue("name").equals("Client")) {
                    client = addClient(r.getAttributeValue("element"), indexPrototype);
                    addClass();
                } else if (r.getAttributeValue("name").equals("prototype")) {
                    addPrototypeLowerCase(r.getAttributeValue("element"), indexPrototype, r.getAttributeValue("name"));
                } else if (r.getAttributeValue("name").equals("Operation()")) {
                    addOperation(r.getAttributeValue("element"), indexPrototype, r.getAttributeValue("name"));
                    addMethod();
                }
            }
        }
        return element;
    }

    private int addPrototypeUpperCase(String prototype, Client client) {
        Type newPrototype = new PrototypeRole(prototype);
        int index = 0;
        for (Type c : this.prototypes) {
            if (c.getName().equals(newPrototype.getName()) && c.getPack().equals(newPrototype.getPack())) {
                addClientException(client, index);
                return index;
            }
            index++;
        }
        this.prototypes.add((PrototypeRole) newPrototype);
        addClass();
        addClientException(client, index);
        return index;
    }

    private void addClientException(Client client, int indexPrototype) {
        if (client != null) {
            PrototypeRole prototype = this.prototypes.get(indexPrototype);
            prototype.addClient(client);
        }
    }

    private Client addClient(String client, int indexPrototype) {
        Client newClient = new Client(client);
        if (indexPrototype != -1) {
            PrototypeRole prototype = this.prototypes.get(indexPrototype);
            prototype.addClient(newClient);
        }
        return newClient;
    }

    public void addPrototypeLowerCase(String prototypeLowerCase, int indexPrototype, String roleDesignPattern) {
        Statement newAttribute = new Attribute(prototypeLowerCase, roleDesignPattern);
        PrototypeRole prototype = this.prototypes.get(indexPrototype);
        Client client = prototype.lastClient();
        client.addPrototype((Attribute) newAttribute);
    }

    public void addOperation(String operation, int indexPrototype, String roleDesignPattern) {
        Statement newOperation = new Method(operation, roleDesignPattern);
        PrototypeRole prototype = this.prototypes.get(indexPrototype);
        Client client = prototype.lastClient();
        client.addOperation((Method) newOperation);
    }

    @Override
    public Type verifyIfTypeExist(Type type) {
        for (PrototypeRole prototype : this.prototypes) {
            if (prototype.isEquals(type)) {
                return prototype;
            }
            for (Client client : prototype.getClients()) {
                if (client.isEquals(type)) {
                    return client;
                }
            }
        }
        return null;
    }

    @Override
    public Method verifyIfMethodExist(MethodBadSmell method) {
        for (PrototypeRole prototype : this.prototypes) {
            for (Client client : prototype.getClients()) {
                for (Method operation : client.getOperations()) {
                    if (method.isEquals(operation, client)) {
                        return operation;
                    }
                }
            }
        }
        return null;
    }

}
