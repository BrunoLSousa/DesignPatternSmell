/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns.structure;

/**
 *
 * @author bruno
 */
public class Attribute extends Statement{
    
    public Attribute(String completeName, String roleDesignPattern) {
        super(roleDesignPattern);
        convertAttributes(completeName);
    }
    
    private void convertAttributes(String completeName){
        String[] split = completeName.split("::|:");
        split = completeName.split(":");
        this.name = split[2];
        this.type = split[3];
    }
    
}
