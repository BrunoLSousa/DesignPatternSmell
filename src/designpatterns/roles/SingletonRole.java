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
public class SingletonRole extends Type{

    private List<Attribute> uniqueInstances;
    
    public SingletonRole(String completeName) {
        super(completeName);
        this.uniqueInstances = new ArrayList<>();
    }
    
    public List<Attribute> getUniqueInstances(){
        return this.uniqueInstances;
    }
    
    public Attribute getUniqueInstanceByIndex(int index){
        return this.uniqueInstances.get(index);
    }
    
    public void addUniqueInstance(Attribute uniqueInstance){
        this.uniqueInstances.add(uniqueInstance);
    }
    
}
