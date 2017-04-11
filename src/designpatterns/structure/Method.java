/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns.structure;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bruno
 */
public class Method extends Statement {

    private List<String> params;

    public Method(String completeName, String roleDesignPattern) {
        super(roleDesignPattern);
        this.params = new ArrayList<>();
        convertAttributes(completeName);
    }

    public List<String> getParams() {
        return params;
    }

    private void convertAttributes(String completeName) {
        if (completeName.contains("::")) {
            createMethod(completeName);
        } else {
            createConstructor(completeName);
        }
    }

    private void createConstructor(String completeName) {
        String[] split = completeName.split("\\(|\\)");
        addParams(split[1]);
        String[] methodComplete = split[0].split("\\.");
        this.name = methodComplete[methodComplete.length - 1];
    }

    private void createMethod(String completeName) {
        String[] split = completeName.split("::|\\(|\\)");
        addParams(split[2]);
        this.name = split[1];
        String[] typeMethod = split[3].split(":");
        this.type = typeMethod[1];
    }

    public void addParams(String params) {
        if (!params.equals("")) {
            if (params.contains(",")) {
                String[] vectorParams = params.split(",");
                for (String param : vectorParams) {
                    this.params.add(param);
                }
            } else {
                this.params.add(params);
            }
        }
    }

}
