/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns.roles;

import designpatterns.structure.Type;

/**
 *
 * @author bruno
 */
public class ObserverRole extends Type{

    public ObserverRole(String completeName) {
        super(completeName);
    }

    @Override
    public String toString() {
        return "Observer";
    }
    
}
