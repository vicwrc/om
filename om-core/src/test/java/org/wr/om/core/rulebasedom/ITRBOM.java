package org.wr.om.core.rulebasedom;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.wr.om.core.OrderManagement;


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

        System.out.println(orderManagement.apply(order, new TestInstance()));
    }


}
