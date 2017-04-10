/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns;

import designpatterns.roles.ProxyRole;
import designpatterns.roles.RealSubjectProxy;
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
public class Proxy extends DesignPattern {

    private List<RealSubjectProxy> realSubjects;

    public Proxy(String name) {
        super(name);
        this.realSubjects = new ArrayList<>();
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
            int indexRealSubject = -1;
            ProxyRole proxy = null;
            for (Element r : roles) {
                if (r.getAttributeValue("name").equals("Proxy")) {
                    proxy = addProxyAttribute(r.getAttributeValue("element"), indexRealSubject);
                    addClass();
                } else if (r.getAttributeValue("name").equals("RealSubject")) {
                    indexRealSubject = addRealSubject(r.getAttributeValue("element"), proxy);
                } else if (r.getAttributeValue("name").equals("Request()")) {
                    this.realSubjects.get(indexRealSubject).lastProxyAttribute().addRequest(r.getAttributeValue("element"), r.getAttributeValue("name"));
                    addMethod();
                }
            }
        }
        return element;
    }

    private int addRealSubject(String realSubject, ProxyRole proxy) {
        RealSubjectProxy realSubjectAttribute = new RealSubjectProxy(realSubject);
        int index = 0;
        for (RealSubjectProxy r : this.realSubjects) {
            if (r.getName().equals(realSubjectAttribute.getName()) && r.getPack().equals(realSubjectAttribute.getPack())) {
                addProxyAttributeException(proxy, index);
                return index;
            }
            index++;
        }
        this.realSubjects.add(realSubjectAttribute);
        addClass();
        addProxyAttributeException(proxy, index);
        return index;
    }

    private void addProxyAttributeException(ProxyRole proxy, int indexSubject) {
        if (proxy != null) {
            this.realSubjects.get(indexSubject).addProxy(proxy);
        }
    }

    private ProxyRole addProxyAttribute(String proxy, int indexRealSubject) {
        ProxyRole proxyAttribute = new ProxyRole(proxy);
        if (indexRealSubject != -1) {
            this.realSubjects.get(indexRealSubject).addProxy(proxyAttribute);
        }
        return proxyAttribute;
    }

    @Override
    public Type verifyIfTypeExist(Type type) {
        for (RealSubjectProxy realSubject : this.realSubjects) {
            if (realSubject.isEquals(type)) {
                return realSubject;
            }
            for (ProxyRole proxy : realSubject.getProxy()) {
                if (proxy.isEquals(type)) {
                    return proxy;
                }
            }
        }
        return null;
    }

    @Override
    public Method verifyIfMethodExist(MethodBadSmell method) {
        for (RealSubjectProxy realSubject : this.realSubjects) {
            for (ProxyRole proxyAttribute : realSubject.getProxy()) {
                for (Method request : proxyAttribute.getRequest()) {
                    if (method.isEquals(request, proxyAttribute)) {
                        return request;
                    }
                }
            }
        }
        return null;
    }

}
