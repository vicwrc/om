package org.wr.om.core.rulebasedom.mvel;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.wr.om.core.rulebasedom.TestInstance;
import org.wr.om.core.rulebasedom.TestOrder;

public class MvelConditionTest {

    private TestOrder order = new TestOrder();
    private TestInstance instance = new TestInstance();
    private MvelCondition condition = new MvelCondition();

    @Before
    public void setUp() throws Exception {
        order.setAmount(100);
        order.setProductName("Product");
        order.setPricePerItem("123");
    }

    @Test
    public void testIsApplicable_TrueResult() throws Exception {
        condition.setExpression(" order.amount > 50 ");
        Assert.assertTrue(condition.isApplicable(order, instance));
    }

    @Test
    public void testIsApplicable_FalseResult() throws Exception {
        condition.setExpression(" order.amount < 50 ");
        Assert.assertFalse(condition.isApplicable(order, instance));
    }
}
