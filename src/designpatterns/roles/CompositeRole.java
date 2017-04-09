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
public class CompositeRole extends Type{

    private Attribute component;
    private List<Method> operations;
    
    public CompositeRole(String completeName) {
        super(completeName);
        this.operations = new ArrayList<>();
    }
    
    public Attribute getAttribute(){
        return this.component;
    }
    
    public List<Method> getOperations(){
        return this.operations;
    }
    
    public Method getOperationByIndex(int index){
        return this.operations.get(index);
    }
    
    public void addOperation(Method operation){
        this.operations.add(operation);
    }
    
    public void setAttribute(Attribute component){
        this.component = component;
    }

    @Override
    public String toString() {
        return "Composite";
    }
    
}
