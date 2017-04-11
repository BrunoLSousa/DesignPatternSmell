/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns.roles;

import designpatterns.structure.Method;
import designpatterns.structure.Statement;
import designpatterns.structure.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bruno
 */
public class ProxyRole extends Type{

    private List<Method> request;
    
    public ProxyRole(String completeName) {
        super(completeName);
        this.request = new ArrayList<>();
    }
    
    public List<Method> getRequest(){
        return this.request;
    }
    
    public void addRequest(String request, String roleDesignPattern){
        Statement newRequest = new Method(request, roleDesignPattern);
        this.request.add((Method) newRequest);
    }

    @Override
    public String toString() {
        return "Proxy";
    }
    
}
