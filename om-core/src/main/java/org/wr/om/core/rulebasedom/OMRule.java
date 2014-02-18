package org.wr.om.core.rulebasedom;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.Serializable;
import java.util.List;

public class OMRule<O, I> implements Serializable {

    private static final Log LOG = LogFactory.getLog(OMRule.class);

    private String name;
    private OMCondition condition;
    private List<OMAction> actions;

    public OMCondition getCondition() {
        return condition;
    }

    public void setCondition(OMCondition condition) {
        this.condition = condition;
    }

    public List<OMAction> getActions() {
        return actions;
    }

    public void setActions(List<OMAction> actions) {
        this.actions = actions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean execute(O order, I instance) {
        LOG.debug("start execute rule : "+this + " for order = "+ order + ", instance = "+instance);
        if(null == order) {
            throw new NullPointerException("Order can not be null!");
        }
        if(null == instance) {
            throw new NullPointerException("Instance can not be null!");
        }
        boolean canBeExecuted = condition.isApplicable(order, instance);
        LOG.debug("canBeExecuted : "+canBeExecuted + ", condition = "+condition);
        if( canBeExecuted) {
            for(OMAction action : actions) {
                action.execute(order, instance);
                LOG.debug("Action executed: "+action);
            }
        }
        LOG.debug("end execute rule : "+this);
        return canBeExecuted;
    }

    @Override
    public String toString() {
        return "OMRule{" +
                "name='" + name + '\'' +
                ", condition=" + condition +
                ", actions=" + actions +
                '}';
    }
}
