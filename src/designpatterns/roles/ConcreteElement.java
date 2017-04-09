/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns.roles;

import designpatterns.structure.Method;
import designpatterns.structure.Statement;
import designpatterns.structure.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bruno
 */
public class ConcreteElement extends Type{

    private List<Method> accepts;
    
    public ConcreteElement(String completeName) {
        super(completeName);
        this.accepts = new ArrayList<>();
    }
    
    public List<Method> getAccepts(){
        return this.accepts;
    }
    
    public void addAccept(String accept, String roleDesignPattern){
        Statement method = new Method(accept, roleDesignPattern);
        this.accepts.add((Method) method);
    }

    @Override
    public String toString() {
        return "ConcretElement";
    }
    
}
