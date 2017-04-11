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
public class AdapteeReceiver extends Type{

    private List<AdapterConcrete> adapterConcretes;
    
    public AdapteeReceiver(String completeName) {
        super(completeName);
        this.adapterConcretes = new ArrayList<>();
    }
    
    public List<AdapterConcrete> getAdapterConcretes(){
        return this.adapterConcretes;
    }
    
    public void addAdapterConcrete(AdapterConcrete adapterConcrete){
        this.adapterConcretes.add(adapterConcrete);
    }
    
    public AdapterConcrete lastAdapterConcrete(){
        int size = this.adapterConcretes.size();
        return this.adapterConcretes.get(size - 1);
    }

    @Override
    public String toString() {
        return "Adaptee/Receiver";
    }
    
}
