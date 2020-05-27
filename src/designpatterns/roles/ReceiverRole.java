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
public class ReceiverRole extends Type{

    private List<ConcreteRole> concretes;
    
    public ReceiverRole(String completeName) {
        super(completeName);
        this.concretes = new ArrayList<>();
    }
    
    public List<ConcreteRole> getAdapterConcretes(){
        return this.concretes;
    }
    
    public void addAdapterConcrete(ConcreteRole concrete){
        this.concretes.add(concrete);
    }
    
    public ConcreteRole lastAdapterConcrete(){
        int size = this.concretes.size();
        return this.concretes.get(size - 1);
    }

    @Override
    public String toString() {
        return "Receiver";
    }
    
}
