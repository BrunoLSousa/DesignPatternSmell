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
public class Type {

    private String name;
    private String pack;

    public Type(String completeName) {
        convertAttributes(completeName);
    }

    public Type(String name, String pack) {
        this.name = name;
        this.pack = pack;
    }

    public String getName() {
        return this.name;
    }

    public String getPack() {
        return this.pack;
    }

    private void convertAttributes(String completeName) {
        String split[] = completeName.split("\\.");
        this.name = split[split.length - 1];
        String pack = split[0];
        for (int index = 1; index < (split.length - 1); index++) {
            pack += "." + split[index];
        }
        this.pack = pack;
    }
    
    public boolean isEquals(Type c){
        if(this.name.equals(c.getName()) && this.pack.equals(c.getPack())){
            return true;
        }
        return false;
    }
}
