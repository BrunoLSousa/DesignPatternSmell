/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns.roles;

import designpatterns.structure.Method;
import designpatterns.structure.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bruno
 */
public class SubjectObserver extends Type{
    
    private List<ObserverRole> observers;
    private List<Method> notify;

    public SubjectObserver(String completeName) {
        super(completeName);
        this.observers = new ArrayList<>();
        this.notify = new ArrayList<>();
    }
    
    public List<ObserverRole> getObservers(){
        return this.observers;
    }
    
    public ObserverRole getObserverByIndex(int index){
        return this.observers.get(index);
    }
    
    public void addObserver(ObserverRole observer){
        this.observers.add(observer);
    }    
    
    public List<Method> getNotify(){
        return this.notify;
    }
    
    public Method getNotifyByIndex(int index){
        return this.notify.get(index);
    }
    
    public void addNotify(Method notify){
        this.notify.add(notify);
    }    

    @Override
    public String toString() {
        return "Subject";
    }
    
}
