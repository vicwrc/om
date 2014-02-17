package org.wr.om.core.rulebasedom;

public class TestOrder {

    private String productName;
    private Integer amount;
    private String pricePerItem;

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

    public String getPricePerItem() {
        return pricePerItem;
    }

    public void setPricePerItem(String pricePerItem) {
        this.pricePerItem = pricePerItem;
    }

    @Override
    public String toString() {
        return "TestOrder{" +
                "productName='" + productName + '\'' +
                ", amount=" + amount +
                ", pricePerItem='" + pricePerItem + '\'' +
                '}';
    }
}
