/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns.roles;

import designpatterns.structure.Attribute;
import designpatterns.structure.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bruno
 */
public class Handler extends Type{
    
    private List<Attribute> successor;
    
    public Handler(String completeName) {
        super(completeName);
        this.successor = new ArrayList<>();
    }
    
    public List<Attribute> getSuccessors(){
        return this.successor;
    }
    
    public Attribute getSuccessorByIndex(int index){
        return this.successor.get(index);
    }
    
    public void addSuccessor(Attribute uniqueInstance){
        this.successor.add(uniqueInstance);
    }

    @Override
    public String toString() {
        return "Chain of Responsability";
    }
    
}
