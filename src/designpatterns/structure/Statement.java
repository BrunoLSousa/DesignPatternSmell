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
public abstract class Statement {
    protected String type;
    protected String name;
    private String roleDesignPattern;
    
    public Statement(String roleDesignPattern){
        this.roleDesignPattern = roleDesignPattern;
    }
    
    public Statement(String name, String type, String roleDesignPattern) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }
    
    public String getRoleDesignPattern(){
        return this.roleDesignPattern;
    }
        
}
