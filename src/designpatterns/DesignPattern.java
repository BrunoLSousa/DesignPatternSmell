/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns;

import org.jdom2.Element;

/**
 *
 * @author bruno
 */
public abstract class DesignPattern {
    protected int instances;
    protected int sumClasses;
    protected int sumMethods;
    private String name;
    
    public DesignPattern(String name){
        this.instances = 0;
        this.sumClasses = 0;
        this.sumMethods = 0;
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void addInstance(){
        this.instances++;
    }
    
    public void addClass(){
        this.sumClasses++;
    }
    
    public void addMethod(){
        this.sumMethods++;
    }
    
    public int getSumClass(){
        return sumClasses;
    }
    
    public int getSumMethod(){
        return this.sumMethods;
    }
    
    public int getInstaces(){
        return this.instances;
    }
    
    public abstract void countInstaces(Element element);
    
    public abstract Element convertElement(Element element); 
    
}
