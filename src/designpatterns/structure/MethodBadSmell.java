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
public class MethodBadSmell extends Method{
   
    private final Type file;

    public MethodBadSmell(Type file, String name) {
        super(name);
        this.file = file;
    }
    
    public String getNameFile(){
        return this.file.getName();
    }
    
    public String getPackFile(){
        return this.file.getPack();
    }
    
    public boolean isEquals(Method m, Type creator){
        return this.name.equals(m.getName()) && file.isEquals(creator);
    }
    
}
