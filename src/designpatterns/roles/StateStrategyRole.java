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
public class StateStrategyRole extends Type {

    private List<Context> contextStateStrategy;

    public StateStrategyRole(String completeName) {
        super(completeName);
        contextStateStrategy = new ArrayList<>();
    }

    public List<Context> getContextStateStrategy() {
        return this.contextStateStrategy;
    }

    public Context lastContextStateStrategy() {
        int size = this.contextStateStrategy.size();
        return this.contextStateStrategy.get(size - 1);
    }

    public void addStateStrategy(Context contextStateStrategy) {
        if (contextStateStrategy != null) {
            this.contextStateStrategy.add(contextStateStrategy);
        }
    }

    @Override
    public String toString() {
        return "State/Strategy";
    }

}
