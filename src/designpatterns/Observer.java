/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns;

import designpatterns.roles.ObserverRole;
import designpatterns.roles.SubjectObserver;
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
public class Observer extends DesignPattern {

    private List<SubjectObserver> subjects;

    public Observer(String name) {
        super(name);
        this.subjects = new ArrayList<>();
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
            int indexSuject = -1;
            ObserverRole observer = null;
            for (Element r : roles) {
                if (r.getAttributeValue("name").equals("Observer")) {
                    observer = addObserver(r.getAttributeValue("element"));
                    addClass();
                } else if (r.getAttributeValue("name").equals("Subject")) {
                    indexSuject = addSubject(r.getAttributeValue("element"), observer);
                } else if (r.getAttributeValue("name").equals("Notify()")) {
                    addNotify(r.getAttributeValue("element"), indexSuject, r.getAttributeValue("name"));
                    addMethod();
                }
            }
        }
        return element;
    }

    private ObserverRole addObserver(String observer) {
        ObserverRole newObserver = new ObserverRole(observer);
        return newObserver;
    }

    private int addSubject(String subject, ObserverRole observer) {
        SubjectObserver newSubject = new SubjectObserver(subject);
        int index = 0;
        for (SubjectObserver s : this.subjects) {
            if (s.getName().equals(newSubject.getName()) && s.getPack().equals(newSubject.getPack())) {
                s.addObserver(observer);
                return index;
            }
            index++;
        }
        newSubject.addObserver(observer);
        this.subjects.add(newSubject);
        addClass();
        return index;
    }

    private void addNotify(String notify, int indexSubject, String roleDesignPattern) {
        Statement newNotify = new Method(notify, roleDesignPattern);
        this.subjects.get(indexSubject).addNotify((Method) newNotify);
    }

    @Override
    public Type verifyIfTypeExist(Type type) {
        for (SubjectObserver subject : this.subjects) {
            if (subject.isEquals(type)) {
                return subject;
            }
            for (ObserverRole observer : subject.getObservers()) {
                if (observer.isEquals(type)) {
                    return observer;
                }
            }
        }
        return null;
    }

    @Override
    public Method verifyIfMethodExist(MethodBadSmell method) {
        for (SubjectObserver subject : this.subjects) {
            for (Method notify : subject.getNotify()) {
                if (method.isEquals(notify, subject)) {
                    return notify;
                }
            }
        }
        return null;
    }

}
