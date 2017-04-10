/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import designpatterns.DesignPattern;
import designpatterns.structure.MethodBadSmell;
import designpatterns.structure.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author bruno
 */
public class Data {
    
    private HashMap<String, DesignPattern> designPatterns;
    private List<Type> typesBadSmells;
    private List<MethodBadSmell> methodsBadSmells;
    private static Data instance;
    
    private Data(){
        this.designPatterns = new HashMap<>();
        this.typesBadSmells = new ArrayList<>();
        this.methodsBadSmells = new ArrayList<>();
    }
    
    public static Data getInstance(){
        if (instance == null) {
            instance = new Data();
        }
        return instance;
    }
    
    public HashMap<String, DesignPattern> getDesignPatterns(){
        return this.designPatterns;
    }
    
    public DesignPattern getDesignPatternByKey(String key){
        return this.designPatterns.get(key);
    }
    
    public void addDesignPattern(String key, DesignPattern designPattern){
        this.designPatterns.put(key, designPattern);
    }
    
    public void addTypeBadSmell(Type type){
        this.typesBadSmells.add(type);
    }
    
    public void addMethodBadSmell(MethodBadSmell method){
        this.methodsBadSmells.add(method);
    }
    
    public void clear(){
        this.designPatterns.clear();
        this.typesBadSmells.clear();
        this.methodsBadSmells.clear();
    }
    
}
