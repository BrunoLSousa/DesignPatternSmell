/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns.roles;

import designpatterns.structure.Attribute;
import designpatterns.structure.Method;
import designpatterns.structure.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bruno
 */
public class Context extends Type{

    private List<Attribute> attributes;
    private List<Method> request;
    
    public Context(String completeName) {
        super(completeName);
        this.attributes = new ArrayList<>();
        this.request = new ArrayList<>();
    }
    
    public List<Attribute> getAttributes(){
        return this.attributes;
    }
    
    public List<Method> getRequests(){
        return this.request;
    }
    
    public void addAttribute(Attribute attribute){
        this.attributes.add(attribute);
    }
    
    public void addRequest(Method method){
        this.request.add(method);
    }

    @Override
    public String toString() {
        return "Context";
    }
    
}
