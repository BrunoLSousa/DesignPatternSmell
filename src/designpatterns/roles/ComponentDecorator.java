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
public class ComponentDecorator extends Type{
    
    private List<Decorator> decorators;
    
    public ComponentDecorator(String completeName) {
        super(completeName);
        this.decorators = new ArrayList<>();
    }
    
    public List<Decorator> getDecorators(){
        return this.decorators;
    }
    
    public Decorator getDecoratorByIndex(int index){
        return this.decorators.get(index);
    }
    
    public void addDecorator(Decorator decorator){
        this.decorators.add(decorator);
    }
    
    public Decorator lastDecorator(){
        int size = this.decorators.size();
        return this.decorators.get(size - 1);
    }

    @Override
    public String toString() {
        return "Component";
    }
    
}
