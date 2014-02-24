package org.wr.om.statefull.storage;

import org.wr.mvel.CompiledMVEL;
import org.wr.om.core.PublicCloneable;
import org.wr.om.statefull.ParentOrderNotFoundException;
import org.wr.om.statefull.model.HierarchicalOrder;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryMvelOIStorage<O extends HierarchicalOrder, I extends PublicCloneable> extends AbstractInMemoryOIStorage<O, I>  {

    private String createNewInstanceExpression;
    private Map<String, O> orderStorage = new ConcurrentHashMap<String, O>();

    @Override
    protected I createNewInstanceByOrder(O rootOrder) {
        Map vars = new HashMap();
        vars.put("order", rootOrder);
        return (I)CompiledMVEL.executeExpression(createNewInstanceExpression, vars);
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

    public String getCreateNewInstanceExpression() {
        return createNewInstanceExpression;
    }

    public void setCreateNewInstanceExpression(String createNewInstanceExpression) {
        this.createNewInstanceExpression = createNewInstanceExpression;
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
