/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns.roles;

import java.util.ArrayList;
import java.util.List;
import designpatterns.structure.Method;
import designpatterns.structure.Statement;
import designpatterns.structure.Type;

/**
 *
 * @author bruno
 */
public class Creator extends Type{

    private List<Method> factoryMethods;
    
    public Creator(String completeName) {
        super(completeName);
        this.factoryMethods = new ArrayList<>();
    }
    
    public List<Method> getFactoryMethods(){
        return this.factoryMethods;
    }
    
    public Method getFactoryMethodById(int index){
        return this.factoryMethods.get(index);
    }
    
    public void addFactoryMethod(String factoryMethod, String roleDesignPattern){
        Statement newFactoryMethod = new Method(factoryMethod, roleDesignPattern);
        this.factoryMethods.add((Method) newFactoryMethod);
    }

    @Override
    public String toString() {
        return "Creator";
    }
    
}
