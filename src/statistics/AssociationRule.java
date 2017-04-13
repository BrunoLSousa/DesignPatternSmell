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
    private Double transaction;

    public AssociationRule(Integer transaction) {
        this.data = Data.getInstance();
        this.properties = PropertiesManager.getInstance().getProperties();
        this.transaction = Double.parseDouble(String.valueOf(transaction));
    }

    public HashMap<String, Double> calculate(String designPattern) {
        HashMap<String, Double> rules = new HashMap<>();
        rules.put(AssociationRuleEnum.SUPPORT.toString(), ruleSupport(designPattern));
        rules.put(AssociationRuleEnum.CONFIDENCE.toString(), ruleConfidence(designPattern));
        rules.put(AssociationRuleEnum.LIFT.toString(), ruleLift(designPattern));
        rules.put(AssociationRuleEnum.CONVICTION.toString(), ruleConviction(designPattern));
        return rules;
    }

    private Double ruleSupport(String designPattern) {
        Double rule = Double.parseDouble(String.valueOf(this.data.totalIntersection(designPattern)));
        return (rule / transaction);
    }

    private Double antecedentSupport(String designPattern) {
        Double antecedent = (this.data.getTypeBadSmell().equals(this.properties.getProperty("optionClass"))) ? Double.parseDouble(String.valueOf(this.data.getDesignPatternByKey(designPattern).getSumClass())) : Double.parseDouble(String.valueOf(this.data.getDesignPatternByKey(designPattern).getSumMethod()));
        return (antecedent / transaction);
    }

    private Double consequentSupport() {
        Integer consequent = this.data.totalBadSmells();
        return (double) (consequent / transaction);
    }

    private Double ruleConfidence(String designPattern) {
        Double antecedentSupport = antecedentSupport(designPattern);
        return (ruleSupport(designPattern) / antecedentSupport);
    }

    private Double ruleLift(String designPattern) {
        Double consequentSupport = consequentSupport();
        return (ruleConfidence(designPattern) / consequentSupport);
    }

    private Double ruleConviction(String designPattern) {
        Double antecedentSupport = antecedentSupport(designPattern);
        Double operation1 = antecedentSupport * (1 - consequentSupport());
        Double operation2 = antecedentSupport - ruleSupport(designPattern);
        return (operation1 / operation2);
    }

}
