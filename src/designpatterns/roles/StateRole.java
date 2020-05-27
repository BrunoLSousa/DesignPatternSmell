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
public class StateRole extends Type {

    private List<Context> contextState;

    public StateRole(String completeName) {
        super(completeName);
        contextState = new ArrayList<>();
    }

    public List<Context> getContextState() {
        return this.contextState;
    }

    public Context lastContextState() {
        int size = this.contextState.size();
        return this.contextState.get(size - 1);
    }

    public void addState(Context contextState) {
        if (contextState != null) {
            this.contextState.add(contextState);
        }
    }

    @Override
    public String toString() {
        return "State";
    }

}
