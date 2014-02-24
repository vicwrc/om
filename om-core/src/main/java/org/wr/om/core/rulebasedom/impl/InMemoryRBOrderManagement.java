package org.wr.om.core.rulebasedom.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wr.om.core.PublicCloneable;
import org.wr.om.core.TransitionExecutionException;
import org.wr.om.core.rulebasedom.OMRule;
import org.wr.om.core.rulebasedom.RuleBasedOrderManagement;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class InMemoryRBOrderManagement<O, I extends PublicCloneable> implements RuleBasedOrderManagement<O, I> {

    private static final Log LOG = LogFactory.getLog(InMemoryRBOrderManagement.class);

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

            try{
                if(rule.execute(order, ruleInstance)) {
                    LOG.info("rule "+ rule.getName()+" was applied to order "+order);
                    return ruleInstance;
                }
            } catch (Exception e) {
                throw new TransitionExecutionException(e.getMessage(), e);
            }
        }
        return null;
    }

    public void setRules(List<OMRule> rules) {
        this.rules = rules;
    }
}
