package org.wr.om.core.rulebasedom.impl;

import org.wr.om.core.PublicCloneable;
import org.wr.om.core.rulebasedom.OMRule;
import org.wr.om.core.rulebasedom.RuleBasedOrderManagement;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class InMemoryRBOrderManagement<O, I extends PublicCloneable> implements RuleBasedOrderManagement<O, I> {

    private List<OMRule> rules = new LinkedList<OMRule>();

    @Override
    public void addRule(OMRule rule) {
        rules.add(rule);
    }

    @Override
    public OMRule getRule(String ruleName) {
        for(OMRule rule : rules) {
            if(ruleName.equals(rule.getName())) {
                return rule;
            }
        }
        return null;
    }

    @Override
    public void removeAllRules() {
        rules.clear();
    }

    @Override
    public void addAllRules(List<OMRule> rules) {
        rules.addAll(rules);
    }

    @Override
    public OMRule removeRule(String ruleName) {
        Iterator<OMRule> ruleIterator = rules.iterator();
        while (ruleIterator.hasNext()) {
            OMRule rule = ruleIterator.next();
            if(ruleName.equals(rule.getName())) {
                ruleIterator.remove();
                return rule;
            }
        }
        return null;
    }

    @Override
    public I apply(O order, I curInstance) {
        for( OMRule rule : rules) {
            I ruleInstance = (I)curInstance.clone();

            if(rule.execute(order, ruleInstance)) {
                return ruleInstance;
            }
        }
        return null;
    }
}
