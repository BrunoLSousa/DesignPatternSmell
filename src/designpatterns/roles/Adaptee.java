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
public class Adaptee extends Type{

    private List<AdapterRole> adapters;
    
    public Adaptee(String completeName) {
        super(completeName);
        this.adapters = new ArrayList<>();
    }
    
    public List<AdapterRole> getAdapterConcretes(){
        return this.adapters;
    }
    
    public void addAdapterConcrete(AdapterRole adapter){
        this.adapters.add(adapter);
    }
    
    public AdapterRole lastAdapterConcrete(){
        int size = this.adapters.size();
        return this.adapters.get(size - 1);
    }

    @Override
    public String toString() {
        return "Adaptee";
    }
    
}
