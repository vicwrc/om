package org.wr.om.core.rulebasedom;

import org.wr.om.core.HierarchicalOrder;

public class TestOrder implements HierarchicalOrder{

    private String productName;
    private Integer amount;
    private Integer pricePerItem;
    private String action = "New";

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getPricePerItem() {
        return pricePerItem;
    }

    public void setPricePerItem(Integer pricePerItem) {
        this.pricePerItem = pricePerItem;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "TestOrder{" +
                "productName='" + productName + '\'' +
                ", amount=" + amount +
                ", pricePerItem=" + pricePerItem +
                ", action='" + action + '\'' +
                '}';
    }

    @Override
    public String getId() {
        return "1";
    }

    @Override
    public String getParentId() {
        return null;
    }
}
