/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns.roles;

import designpatterns.structure.Attribute;
import designpatterns.structure.Method;
import designpatterns.structure.Statement;
import designpatterns.structure.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bruno
 */
public class ConcreteRole extends Type{

    private List<Attribute> attributes;
    private List<Method> request;
    
    public ConcreteRole(String completeName) {
        super(completeName);
        this.attributes = new ArrayList<>();
        this.request = new ArrayList<>();
    }
    
    public List<Attribute> getAttributes(){
        return this.attributes;
    }
    
    public List<Method> getRequest(){
        return this.request;
    }
    
    public void addAttribute(String attribute, String role){
        Statement newAttribute = new Attribute(attribute, role);
        this.attributes.add((Attribute) newAttribute);
    }
    
    public void addRequest(String request, String role){
        Statement newRequest = new Method(request, role);
        this.request.add((Method) newRequest);
    }

    @Override
    public String toString() {
        return "ConcreteCommand";
    }
    
}
