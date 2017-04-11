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
public class Client extends Type{

    private List<Attribute> prototypes;
    private List<Method> operations;
    
    public Client(String completeName) {
        super(completeName);
        this.prototypes = new ArrayList<>();
        this.operations = new ArrayList<>();
    }
    
    public List<Method> getOperations(){
        return this.operations;
    }
    
    public List<Attribute> getPrototypes(){
        return this.prototypes;
    }
    
    public void addPrototype(Attribute prototype){
        this.prototypes.add(prototype);
    }
    
    public void addOperation(Method method){
        this.operations.add(method);
    }

    @Override
    public String toString() {
        return "Prototype";
    }
    
}
