package org.wr.om.statefull.impl;

import org.wr.om.core.HierarchicalOrder;
import org.wr.om.core.OrderManagement;
import org.wr.om.core.PublicCloneable;
import org.wr.om.statefull.OrderInstanceStorage;
import org.wr.om.statefull.StatefulOrderManagement;

public class StatefulOrderManagementImpl<O extends HierarchicalOrder, I extends PublicCloneable> implements StatefulOrderManagement<O, I> {

    private OrderInstanceStorage<O, I> orderInstanceStorage;
    private OrderManagement<O, I> orderManagement;

    @Override
    public I apply(O order) {
        I orderInstance = orderInstanceStorage.getInstance(order);

        I newOrderInstance = orderManagement.apply(order, orderInstance);
        orderInstanceStorage.save(order, newOrderInstance);
        return newOrderInstance;
    }

    public void setOrderInstanceStorage(OrderInstanceStorage<O, I> orderInstanceStorage) {
        this.orderInstanceStorage = orderInstanceStorage;
    }

    public void setOrderManagement(OrderManagement<O, I> orderManagement) {
        this.orderManagement = orderManagement;
    }
}
