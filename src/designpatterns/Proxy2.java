/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns;

import designpatterns.roles.ProxyRole;
import designpatterns.roles.RealSubjectProxy2;
import designpatterns.roles.SubjectProxy2;
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
public class Proxy2 extends DesignPattern {

    private List<RealSubjectProxy2> realSubjects;
    private List<SubjectProxy2> subjects;
    private List<ProxyRole> proxies;

    public Proxy2(String name) {
        super(name);
        this.realSubjects = new ArrayList<>();
        this.subjects = new ArrayList<>();
        this.proxies = new ArrayList<>();
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
                    this.proxies.add(new ProxyRole(r.getAttributeValue("element")));
                    addClass();
                } else if (r.getAttributeValue("name").equals("RealSubject")) {
                    this.realSubjects.add(new RealSubjectProxy2(r.getAttributeValue("element")));
                    addClass();
                } else if (r.getAttributeValue("name").equals("Subject")) {
                    this.subjects.add(new SubjectProxy2(r.getAttributeValue("element")));
                    addClass();
                } else if (r.getAttributeValue("name").equals("Request()")) {
                    this.proxies.get(instances - 1).addRequest(r.getAttributeValue("element"), r.getAttributeValue("name"));
                    addMethod();
                }
            }
        }
        return element;
    }

    @Override
    public Type verifyIfTypeExist(Type type) {
        for (RealSubjectProxy2 realSubject : this.realSubjects) {
            if (realSubject.isEquals(type)) {
                return realSubject;
            }
        }
        for (SubjectProxy2 subject : this.subjects) {
            if (subject.isEquals(type)) {
                return subject;
            }
        }
        for (ProxyRole proxy : this.proxies) {
            if (proxy.isEquals(type)) {
                return proxy;
            }
        }
        return null;
    }

    @Override
    public Method verifyIfMethodExist(MethodBadSmell method) {
        for (ProxyRole proxyAttribute : this.proxies) {
            for (Method request : proxyAttribute.getRequest()) {
                if (method.isEquals(request, proxyAttribute)) {
                    return request;
                }
            }
        }
        return null;
    }

}
