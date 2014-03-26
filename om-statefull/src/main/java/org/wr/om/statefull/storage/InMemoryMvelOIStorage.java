package org.wr.om.statefull.storage;

import org.wr.om.core.PublicCloneable;
import org.wr.om.statefull.InstanceByOrderCreator;
import org.wr.om.statefull.ParentOrderNotFoundException;
import org.wr.om.core.HierarchicalOrder;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryMvelOIStorage<O extends HierarchicalOrder, I extends PublicCloneable> extends AbstractInMemoryOIStorage<O, I>  {

    private InstanceByOrderCreator<O,I> instanceByOrderCreator;
    private Map<String, O> orderStorage = new ConcurrentHashMap<String, O>();

    @Override
    protected I createNewInstanceByOrder(O rootOrder) {
        return instanceByOrderCreator.create(rootOrder);
    }

    @Override
    public void save(O order, I curInstance) {
        super.save(order,curInstance);
        this.saveOrder(order);
    }

    @Override
    public O getParent(O order) {
        O parent = orderStorage.get(order.getParentId());

        if( null != order.getParentId() && null == parent) {
            throw new ParentOrderNotFoundException("Can't find parent order for order "+ order);
        }
        return parent;
    }

    public InstanceByOrderCreator<O, I> getInstanceByOrderCreator() {
        return instanceByOrderCreator;
    }

    public void setInstanceByOrderCreator(InstanceByOrderCreator<O, I> instanceByOrderCreator) {
        this.instanceByOrderCreator = instanceByOrderCreator;
    }

    public void saveOrder(O order) {
        if( null == order.getParentId() || orderStorage.containsKey(order.getParentId())) {
            orderStorage.put(order.getId(), order);
        }
    }

    public O remove(String key) {
        return orderStorage.remove(key);
    }

    public Map<String, O> getOrderStorage() {
        return orderStorage;
    }

    public void setOrderStorage(Map<String, O> orderStorage) {
        this.orderStorage = orderStorage;
    }
}
