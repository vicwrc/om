package org.wr.om.core.rulebasedom.order;

public class ApproveOrder {

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
}
