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
public class RealSubjectProxy extends Type{

    private List<ProxyRole> proxyAttribute;
    
    public RealSubjectProxy(String completeName) {
        super(completeName);
        this.proxyAttribute = new ArrayList<>();
    }
    
    public List<ProxyRole> getProxy(){
        return this.proxyAttribute;
    }
    
    public void addProxy(ProxyRole proxy){
        this.proxyAttribute.add(proxy);
    }
    
    public ProxyRole lastProxyAttribute(){
        int size = this.proxyAttribute.size();
        return this.proxyAttribute.get(size - 1);
    }

    @Override
    public String toString() {
        return "Real Subject";
    }
    
}
