package org.wr.om.core.rulebasedom;


import junit.framework.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.wr.om.core.OrderManagement;
import org.wr.om.core.rulebasedom.order.ApproveOrder;
import org.wr.om.core.rulebasedom.order.CancelOrder;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:test-rule-config.xml"})
public class ITRBOM {

    @Autowired
    private OrderManagement orderManagement;

    @Test
    public void testNewTransition() {
        TestOrder order = new TestOrder();

        order.setProductName("product 123");
        order.setAmount(123);
        order.setPricePerItem(10);

        TestInstance instance = (TestInstance)orderManagement.apply(order, new TestInstance());
        System.out.println(instance);
        Assert.assertEquals("product 123", instance.getProduct());
        Assert.assertEquals(2, instance.getVersion() );
        Assert.assertEquals("Pending", instance.getStatus());
    }


    @Test
    public void testNewApproveTransition() {
        TestOrder order = new TestOrder();

        order.setProductName("product 123");
        order.setAmount(123);
        order.setPricePerItem(10);

        TestInstance instance = (TestInstance)orderManagement.apply(order, new TestInstance());
        System.out.println(instance);

        instance = (TestInstance)orderManagement.apply(new ApproveOrder(), instance);

        System.out.println(instance);
        Assert.assertEquals("product 123", instance.getProduct());
        Assert.assertEquals(3, instance.getVersion() );
        Assert.assertEquals("Completed", instance.getStatus());
    }

    @Test
    public void testNewModifyTransition() {
        TestOrder order = new TestOrder();

        order.setProductName("product 123");
        order.setAmount(123);
        order.setPricePerItem(10);

        TestInstance instance = (TestInstance)orderManagement.apply(order, new TestInstance());
        System.out.println(instance);

        order.setProductName("New Product");

        instance = (TestInstance)orderManagement.apply(order, instance);

        System.out.println(instance);
        Assert.assertEquals("New Product", instance.getProduct());
        Assert.assertEquals(3, instance.getVersion() );
        Assert.assertEquals("Pending", instance.getStatus());
    }

    @Test
    public void testNewCancelTransition() {
        TestOrder order = new TestOrder();

        order.setProductName("product 123");
        order.setAmount(123);
        order.setPricePerItem(10);

        TestInstance instance = (TestInstance)orderManagement.apply(order, new TestInstance());
        System.out.println(instance);

        instance = (TestInstance)orderManagement.apply(new CancelOrder(), instance);

        System.out.println(instance);
        Assert.assertEquals("product 123", instance.getProduct());
        Assert.assertEquals(3, instance.getVersion() );
        Assert.assertEquals("Cancelled", instance.getStatus());
    }

}
