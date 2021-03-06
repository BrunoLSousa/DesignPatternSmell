/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns.roles;

import designpatterns.structure.Type;

/**
 *
 * @author bruno
 */
public class ComponentComposite extends Type{

    private CompositeRole composite;
    
    public ComponentComposite(String completeName) {
        super(completeName);
    }
    
    public CompositeRole getComposite(){
        return this.composite;
    }
    
    public void setComposite(CompositeRole composite){
        this.composite = composite;
    }

    @Override
    public String toString() {
        return "Component";
    }
    
}
