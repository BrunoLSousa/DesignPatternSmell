/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns.roles;

import designpatterns.structure.Method;
import designpatterns.structure.Statement;
import designpatterns.structure.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bruno
 */
public class AbstractTemplateMethod extends Type{

    private List<Method> templateMethods;
    
    public AbstractTemplateMethod(String completeName) {
        super(completeName);
        this.templateMethods = new ArrayList<>();
    }
    
    public List<Method> getTemplateMethods(){
        return this.templateMethods;
    }
    
    public Method getTemplateMethodByIndex(int index){
        return this.templateMethods.get(index);
    }
    
    public void addTemplateMethod(String templateMethod, String roleDesignPattern){
        Statement newFactoryMethod = new Method(templateMethod, roleDesignPattern);
        this.templateMethods.add((Method) newFactoryMethod);
    }
    
}
