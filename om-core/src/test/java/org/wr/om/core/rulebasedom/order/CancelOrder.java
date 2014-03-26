package org.wr.om.core.rulebasedom.order;

import org.wr.om.core.HierarchicalOrder;

public class CancelOrder implements HierarchicalOrder
{

    private String action = "Cancel";

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "CancelOrder{" +
                "action='" + action + '\'' +
                '}';
    }

    @Override
    public String getId() {
        return "3";  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getParentId() {
        return "1";  //To change body of implemented methods use File | Settings | File Templates.
    }
}
