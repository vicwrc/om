package org.wr.om.core.rulebasedom.mvel;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.wr.om.core.rulebasedom.TestInstance;
import org.wr.om.core.rulebasedom.TestOrder;

public class MvelApplyInstanceFieldValueTest {

    private TestOrder order = new TestOrder();
    private TestInstance instance = new TestInstance();
    private MvelApplyInstanceFieldValue action = new MvelApplyInstanceFieldValue();

    @Before
    public void setUp() throws Exception {
        order.setAmount(100);
        order.setProductName("Product");
        order.setPricePerItem("123");
    }

    @Test
    public void testIsApplicable_TrueResult() throws Exception {
        action.setExpression(" order.productName; ");
        action.setFieldName("product");
        action.execute(order, instance);
        Assert.assertEquals(order.getProductName(), instance.getProduct());
    }

}
