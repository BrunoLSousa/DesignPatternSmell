/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns.roles;

import designpatterns.structure.Attribute;
import designpatterns.structure.Method;
import designpatterns.structure.Statement;
import designpatterns.structure.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bruno
 */
public class AbstractionBridge extends Type{

    private Attribute implementor;
    private List<Method> operations;
    
    public AbstractionBridge(String completeName) {
        super(completeName);
        this.operations = new ArrayList<>();
    }
    
    public Attribute getImplementor(){
        return this.implementor;
    }
    
    public List<Method> getOperations(){
        return this.operations;
    }
    
    public void setImplementor(String implementor, String roleDesignPattern){
        this.implementor = (Attribute) new Attribute(implementor, roleDesignPattern);
    }
    
    public void addOperation(String operation, String roleDesignPattern){
        Statement newMethod = new Method(operation, roleDesignPattern);
        this.operations.add((Method) newMethod);
    }
    
    @Override
    public String toString(){
        return "Abstraction";
    }
    
}
