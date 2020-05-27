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
public class StrategyRole extends Type {

    private List<Context> contextStrategy;

    public StrategyRole(String completeName) {
        super(completeName);
        contextStrategy = new ArrayList<>();
    }

    public List<Context> getContextStrategy() {
        return this.contextStrategy;
    }

    public Context lastContextStrategy() {
        int size = this.contextStrategy.size();
        return this.contextStrategy.get(size - 1);
    }

    public void addStrategy(Context contextStrategy) {
        if (contextStrategy != null) {
            this.contextStrategy.add(contextStrategy);
        }
    }

    @Override
    public String toString() {
        return "Strategy";
    }

}
