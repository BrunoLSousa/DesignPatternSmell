/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics;

import data.Data;
import designpatterns.config.PropertiesManager;
import java.util.HashMap;
import java.util.Properties;

/**
 *
 * @author bruno
 */
public class AssociationRule {

    private Data data;
    private Properties properties;
    private Integer transaction;
    
    public AssociationRule(Integer transaction) {
        this.data = Data.getInstance();
        this.properties = PropertiesManager.getInstance().getProperties();
        this.transaction = transaction;
    }
    
    public HashMap<String, Double> calculate(String designPattern){
        HashMap<String, Double> rules = new HashMap<>();
        rules.put(AssociationRuleEnum.SUPPORT.toString(), ruleSupport(designPattern));
        rules.put(AssociationRuleEnum.CONFIDENCE.toString(), ruleConfidence(designPattern));
        rules.put(AssociationRuleEnum.LIFT.toString(), ruleLift(designPattern));
        rules.put(AssociationRuleEnum.CONVICTION.toString(), ruleSupport(designPattern));
        return rules;
    }
    
    private Double ruleSupport(String designPattern){
        Integer rule = this.data.totalIntersection(designPattern);
        return Double.parseDouble(String.valueOf(rule/transaction));
    }
    
    private Double antecedentSupport(String designPattern){
        Integer antecedent = (this.data.getTypeBadSmell().equals(this.properties.getProperty("optionClass"))) ? this.data.getDesignPatternByKey(designPattern).getSumClass() : this.data.getDesignPatternByKey(designPattern).getSumMethod();
        return Double.parseDouble(String.valueOf(antecedent/transaction));
    }
    
    private Double consequentSupport(){
        Integer consequent = this.data.totalBadSmells();
        return Double.parseDouble(String.valueOf(consequent/transaction));
    }
    
    private Double ruleConfidence(String designPattern){
        return (ruleSupport(designPattern)/antecedentSupport(designPattern));
    }
    
    private Double ruleLift(String designPattern){
        return (ruleConfidence(designPattern)/consequentSupport());
    }
    
    private Double ruleConviction(String designPattern){
        Double operation1 = 1 - consequentSupport();
        Double operation2 = 1 - ruleConfidence(designPattern);
        return (operation1/operation2);
    }
    
}
