/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns.roles;

import designpatterns.structure.Attribute;
import designpatterns.structure.Method;
import designpatterns.structure.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bruno
 */
public class Decorator extends Type{

    private List<Attribute> components;
    private List<Method> operations;
    
    public Decorator(String completeName) {
        super(completeName);
        this.components = new ArrayList<>();
        this.operations = new ArrayList<>();
    }
    
    public List<Method> getOperations(){
        return this.operations;
    }
    
    public List<Attribute> getComponents(){
        return this.components;
    }
    
    public void addComponent(Attribute component){
        this.components.add(component);
    }
    
    public void addOperation(Method method){
        this.operations.add(method);
    }

    @Override
    public String toString() {
        return "Decorator";
    }
    
}
