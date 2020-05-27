/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns;

import designpatterns.roles.Context;
import designpatterns.roles.StateRole;
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
public class State extends DesignPattern{
    
    private List<StateRole> statesStrategies;

    public State(String name) {
        super(name);
        this.statesStrategies = new ArrayList<>();
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
            int indexStateStrategy = -1;
            Context context = null;
            for (Element r : roles) {
                if (r.getAttributeValue("name").equals("Context")) {
                    context = addContext(r.getAttributeValue("element"), indexStateStrategy);
                    addClass();
                } else if (r.getAttributeValue("name").equals("State")) {
                    indexStateStrategy = addStateUpperCase(r.getAttributeValue("element"), context);
                } else if (r.getAttributeValue("name").equals("state")) {
                    addStateLowerCase(r.getAttributeValue("element"), indexStateStrategy, r.getAttributeValue("name"));
                } else if (r.getAttributeValue("name").equals("Request()")) {
                    addRequest(r.getAttributeValue("element"), indexStateStrategy, r.getAttributeValue("name"));
                    addMethod();
                }
            }
        }
        return element;
    }
    
    private Context addContext(String context, int indexStateStrategy) {
        Context newContext = new Context(context);
        if (indexStateStrategy != -1) {
            this.statesStrategies.get(indexStateStrategy).addState(newContext);
        }
        return newContext;
    }

    private int addStateUpperCase(String stateStrategy, Context context) {
        StateRole newStateStrategy = new StateRole(stateStrategy);
        int index = 0;
        for (StateRole s : this.statesStrategies) {
            if (s.getName().equals(newStateStrategy.getName()) && s.getPack().equals(newStateStrategy.getPack())) {
                s.addState(context);
                return index;
            }
            index++;
        }
        newStateStrategy.addState(context);
        this.statesStrategies.add(newStateStrategy);
        addClass();
        return index;
    }

    private void addStateLowerCase(String stateStrategy, int indexStateStrategy, String roleDesignPattern) {
        Statement newStateStrategy = new Attribute(stateStrategy, roleDesignPattern);
        Context context = this.statesStrategies.get(indexStateStrategy).lastContextState();
        context.addAttribute((Attribute) newStateStrategy);
    }

    private void addRequest(String notify, int indexStateStrategy, String roleDesignPattern) {
        Statement newRequest = new Method(notify, roleDesignPattern);
        Context context = this.statesStrategies.get(indexStateStrategy).lastContextState();
        context.addRequest((Method) newRequest);
    }

    @Override
    public Type verifyIfTypeExist(Type type) {
        for (StateRole stateStrategy : this.statesStrategies) {
            if (stateStrategy.isEquals(type)) {
                return stateStrategy;
            }
            for (Context context : stateStrategy.getContextState()) {
                if (context.isEquals(type)) {
                    return context;
                }
            }
        }
        return null;
    }

    @Override
    public Method verifyIfMethodExist(MethodBadSmell method) {
        for (StateRole stateStrategy : this.statesStrategies) {
            for (Context contextStateStrategy : stateStrategy.getContextState()) {
                for (Method request : contextStateStrategy.getRequests()) {
                    if (method.isEquals(request, contextStateStrategy)) {
                        return request;
                    }
                }
            }
        }
        return null;
    }
    
}
