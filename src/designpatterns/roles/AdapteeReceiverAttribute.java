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
public class AdapteeReceiverAttribute extends Type{

    private List<AdapterConcreteAttribute> adapterConcretes;
    
    public AdapteeReceiverAttribute(String completeName) {
        super(completeName);
        this.adapterConcretes = new ArrayList<>();
    }
    
    public List<AdapterConcreteAttribute> getAdapterConcretes(){
        return this.adapterConcretes;
    }
    
    public void addAdapterConcrete(AdapterConcreteAttribute adapterConcrete){
        this.adapterConcretes.add(adapterConcrete);
    }
    
    public AdapterConcreteAttribute lastAdapterConcrete(){
        int size = this.adapterConcretes.size();
        return this.adapterConcretes.get(size - 1);
    }

    @Override
    public String toString() {
        return "Adaptee/Receiver";
    }
    
}
