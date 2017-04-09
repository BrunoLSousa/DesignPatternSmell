/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns;

import designpatterns.roles.Context;
import designpatterns.roles.StateStrategyRole;
import designpatterns.structure.Attribute;
import designpatterns.structure.Method;
import designpatterns.structure.Statement;
import java.util.ArrayList;
import java.util.List;
import org.jdom2.Element;

/**
 *
 * @author bruno
 */
public class StateStrategy extends DesignPattern{

    private List<StateStrategyRole> statesStrategies;
    
    public StateStrategy(String name) {
        super(name);
        this.statesStrategies = new ArrayList<>();
    }
    
    @Override
    public void countInstaces(Element element) {
        List<Element> elements = element.getChildren();
        for(Element e : elements){
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
                } else if (r.getAttributeValue("name").equals("State/Strategy")) {
                    indexStateStrategy = addStateStrategyUpperCase(r.getAttributeValue("element"), context);
                } else if (r.getAttributeValue("name").equals("state/strategy")) {
                    addStateStrategyLowerCase(r.getAttributeValue("element"), indexStateStrategy, r.getAttributeValue("name"));
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
        if(indexStateStrategy != -1){
            this.statesStrategies.get(indexStateStrategy).addStateStrategy(newContext);
        }
        return newContext;
    }

    private int addStateStrategyUpperCase(String stateStrategy, Context context) {
        StateStrategyRole newStateStrategy = new StateStrategyRole(stateStrategy);
        int index = 0;
        for(StateStrategyRole s: this.statesStrategies){
            if(s.getName().equals(newStateStrategy.getName()) && s.getPack().equals(newStateStrategy.getPack())){
                s.addStateStrategy(context);
                return index;
            }
            index++;
        }
        newStateStrategy.addStateStrategy(context);
        this.statesStrategies.add(newStateStrategy);
        addClass();
        return index;
    }

    private void addStateStrategyLowerCase(String stateStrategy, int indexStateStrategy, String roleDesignPattern) {
        Statement newStateStrategy = new Attribute(stateStrategy, roleDesignPattern);
        Context context = this.statesStrategies.get(indexStateStrategy).lastContextStateStrategy();
        context.addAttribute((Attribute) newStateStrategy);
    }

    private void addRequest(String notify, int indexStateStrategy, String roleDesignPattern) {
        Statement newRequest = new Method(notify, roleDesignPattern);
        Context context = this.statesStrategies.get(indexStateStrategy).lastContextStateStrategy();
        context.addRequest((Method) newRequest);
    }
    
}
