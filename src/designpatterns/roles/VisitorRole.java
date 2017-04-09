/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns.roles;

import designpatterns.structure.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bruno
 */
public class VisitorRole extends Type{

    private List<ConcreteElement> concretElements;
    
    public VisitorRole(String completeName) {
        super(completeName);
        this.concretElements = new ArrayList<>();
    }
    
    public List<ConcreteElement> getConcretElements(){
        return this.concretElements;
    }
    
    public ConcreteElement lastConcreteElementAttribute(){
        int size = concretElements.size();
        return this.concretElements.get(size - 1);
    }
    
    public void addConcretElement(ConcreteElement concreteElementAttribute){
        this.concretElements.add(concreteElementAttribute);
    }

    @Override
    public String toString() {
        return "Visitor";
    }
    
}
