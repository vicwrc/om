package org.wr.om.core.rulebasedom.order;

import org.wr.om.core.HierarchicalOrder;

public class ApproveOrder implements HierarchicalOrder{

    private String action = "Approve";

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "ApproveOrder{" +
                "action='" + action + '\'' +
                '}';
    }

    @Override
    public String getId() {
        return "2";  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getParentId() {
        return "1";  //To change body of implemented methods use File | Settings | File Templates.
    }
}
