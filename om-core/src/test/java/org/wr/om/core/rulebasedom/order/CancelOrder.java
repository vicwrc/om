package org.wr.om.core.rulebasedom.order;

public class CancelOrder {

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
}
