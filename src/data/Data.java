/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import designpatterns.DesignPattern;
import designpatterns.structure.Method;
import designpatterns.structure.MethodBadSmell;
import designpatterns.structure.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 *
 * @author bruno
 */
public class Data {
    
    private String nameProject;
    private String nameBadSmell;
    private String typeBadSmell;
    private HashMap<String, DesignPattern> designPatterns;
    private List<Type> typesBadSmells;
    private List<MethodBadSmell> methodsBadSmells;
    private static Data instance;
    private HashMap<String, Set<Type>> instersectionType;
    private HashMap<String, Set<Method>> instersectionMethod;
    
    private Data(){
        this.designPatterns = new HashMap<>();
        this.typesBadSmells = new ArrayList<>();
        this.methodsBadSmells = new ArrayList<>();
        this.instersectionType = new HashMap<>();
        this.instersectionMethod = new HashMap<>();
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
    
    public Object badSmellData(){
        if(!this.typesBadSmells.isEmpty()){
            return this.typesBadSmells;
        }else if(!this.methodsBadSmells.isEmpty()){
            return this.methodsBadSmells;
        }
        return null;
    }
    
    public void setNameProject(String nameProject){
        this.nameProject = nameProject;
    }
    
    public void setNameBadSmell(String nameBadSmell){
        this.nameBadSmell = nameBadSmell;
    }
    
    public void setTypeBadSmell(String typeBadSmell){
        this.typeBadSmell = typeBadSmell;
    }
    
    public String getNameProject(){
        return this.nameProject;
    }
    
    public String getNameBadSmell(){
        return this.nameBadSmell;
    }
    
    public String getTypeBadSmell(){
        return this.typeBadSmell;
    }
    
    public void setIntersectionType(HashMap<String, Set<Type>> intersection){
        this.instersectionType = intersection;
    }
    
    public HashMap<String, Set<Type>> getIntersectionType(){
        return this.instersectionType;
    }
    
    public void setIntersectionMethod(HashMap<String, Set<Method>> intersection){
        this.instersectionMethod = intersection;
    }
    
    public HashMap<String, Set<Method>> getIntersectionMethod(){
        return this.instersectionMethod;
    }
    
    public void clear(){
        this.designPatterns.clear();
        this.typesBadSmells.clear();
        this.methodsBadSmells.clear();
        this.instersectionType.clear();
        this.instersectionMethod.clear();
    }
    
    public void clearCSV(){
        this.typesBadSmells.clear();
        this.methodsBadSmells.clear();
        this.instersectionType.clear();
        this.instersectionMethod.clear();
    }
    
}
