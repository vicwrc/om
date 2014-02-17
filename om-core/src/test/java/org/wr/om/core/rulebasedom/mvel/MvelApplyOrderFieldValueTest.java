package org.wr.om.core.rulebasedom.mvel;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.wr.om.core.rulebasedom.TestInstance;
import org.wr.om.core.rulebasedom.TestOrder;


public class MvelApplyOrderFieldValueTest {

    private TestOrder order = new TestOrder();
    private TestInstance instance = new TestInstance();
    private MvelApplyOrderFieldValue action = new MvelApplyOrderFieldValue();

    @Before
    public void setUp() throws Exception {
        order.setAmount(100);
        order.setProductName("Product");
        instance.setProduct("testProduct");
        order.setPricePerItem("123");
    }

    @Test
    public void testApplyField() throws Exception {
        action.setExpression(" instance.product ");
        action.setFieldName("productName");
        action.execute(order, instance);
        Assert.assertEquals(order.getProductName(), instance.getProduct());
        Assert.assertEquals(order.getProductName(),"testProduct");

    }
}
