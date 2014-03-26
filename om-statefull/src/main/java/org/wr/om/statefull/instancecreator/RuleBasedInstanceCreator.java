package org.wr.om.statefull.instancecreator;

import org.wr.om.core.PublicCloneable;
import org.wr.om.statefull.InstanceByOrderCreator;

import java.util.List;

public class RuleBasedInstanceCreator<O, I  extends PublicCloneable> implements InstanceByOrderCreator<O, I> {

    private List<CreationRule> creationRules;

    public List<CreationRule> getCreationRules() {
        return creationRules;
    }

    public void setCreationRules(List<CreationRule> creationRules) {
        this.creationRules = creationRules;
    }

    @Override
    public I create(O order) {
        for(CreationRule rule : creationRules) {
            if(rule.getCondition().isApplicable(order,null)) {
                try {
                    return (I) rule.getInstanceClass().newInstance();
                } catch (IllegalAccessException |InstantiationException e) {
                    throw  new InstanceCreationException(e);
                }
            }
        }
        return null;
    }

}
