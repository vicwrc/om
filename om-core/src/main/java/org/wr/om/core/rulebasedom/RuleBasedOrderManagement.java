package org.wr.om.core.rulebasedom;

import org.wr.om.core.HierarchicalOrder;
import org.wr.om.core.OrderManagement;
import org.wr.om.core.PublicCloneable;

import java.util.List;

public interface RuleBasedOrderManagement<O extends HierarchicalOrder, I extends PublicCloneable> extends OrderManagement<O, I> {

    void addRule(OMRule rule);

    OMRule getRule(String ruleName);

    void removeAllRules();

    void addAllRules(List<OMRule> rules);

    OMRule removeRule(String ruleName);

}
