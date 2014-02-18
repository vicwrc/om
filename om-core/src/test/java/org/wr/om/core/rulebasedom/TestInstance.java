package org.wr.om.core.rulebasedom;

import org.wr.om.core.PublicCloneable;

public class TestInstance implements PublicCloneable {

    private String product;
    private String status = "New";
    private int version = 1;

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public TestInstance clone() {
        try {
            return (TestInstance)super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public String toString() {
        return "TestInstance{" +
                "product='" + product + '\'' +
                ", status='" + status + '\'' +
                ", version=" + version +
                '}';
    }
}
