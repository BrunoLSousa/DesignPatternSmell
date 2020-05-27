/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns;

import designpatterns.roles.Context;
import designpatterns.roles.StrategyRole;
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
public class Strategy extends DesignPattern{
    
    private List<StrategyRole> strategies;

    public Strategy(String name) {
        super(name);
        this.strategies = new ArrayList<>();
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
                } else if (r.getAttributeValue("name").equals("Strategy")) {
                    indexStateStrategy = addStrategyUpperCase(r.getAttributeValue("element"), context);
                } else if (r.getAttributeValue("name").equals("strategy")) {
                    addStrategyLowerCase(r.getAttributeValue("element"), indexStateStrategy, r.getAttributeValue("name"));
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
            this.strategies.get(indexStateStrategy).addStrategy(newContext);
        }
        return newContext;
    }

    private int addStrategyUpperCase(String stateStrategy, Context context) {
        StrategyRole newStateStrategy = new StrategyRole(stateStrategy);
        int index = 0;
        for (StrategyRole s : this.strategies) {
            if (s.getName().equals(newStateStrategy.getName()) && s.getPack().equals(newStateStrategy.getPack())) {
                s.addStrategy(context);
                return index;
            }
            index++;
        }
        newStateStrategy.addStrategy(context);
        this.strategies.add(newStateStrategy);
        addClass();
        return index;
    }

    private void addStrategyLowerCase(String stateStrategy, int indexStateStrategy, String roleDesignPattern) {
        Statement newStateStrategy = new Attribute(stateStrategy, roleDesignPattern);
        Context context = this.strategies.get(indexStateStrategy).lastContextStrategy();
        context.addAttribute((Attribute) newStateStrategy);
    }

    private void addRequest(String notify, int indexStateStrategy, String roleDesignPattern) {
        Statement newRequest = new Method(notify, roleDesignPattern);
        Context context = this.strategies.get(indexStateStrategy).lastContextStrategy();
        context.addRequest((Method) newRequest);
    }

    @Override
    public Type verifyIfTypeExist(Type type) {
        for (StrategyRole stateStrategy : this.strategies) {
            if (stateStrategy.isEquals(type)) {
                return stateStrategy;
            }
            for (Context context : stateStrategy.getContextStrategy()) {
                if (context.isEquals(type)) {
                    return context;
                }
            }
        }
        return null;
    }

    @Override
    public Method verifyIfMethodExist(MethodBadSmell method) {
        for (StrategyRole stateStrategy : this.strategies) {
            for (Context contextStateStrategy : stateStrategy.getContextStrategy()) {
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
