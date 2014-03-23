package org.wr.om.statefull.instancecreator;

import org.wr.om.core.PublicCloneable;
import org.wr.om.statefull.InstanceByOrderCreator;

import java.util.Map;

public class SimpleInstanceCreator<O, I  extends PublicCloneable> implements InstanceByOrderCreator<O, I> {

    private Map<Class, Class> order2instanceDataTypeMap;

    public void setOrder2instanceDataTypeMap(Map<Class, Class> order2instanceDataTypeMap) {
        this.order2instanceDataTypeMap = order2instanceDataTypeMap;
    }

    @Override
    public I create(O order) {
        Class instanceClass = order2instanceDataTypeMap.get(order.getClass());
        try {
            return (I)instanceClass.newInstance();
        } catch (InstantiationException e) {
            throw new InstanceCreationException(e);
        } catch (IllegalAccessException e) {
            throw new InstanceCreationException(e);
        } catch (NullPointerException e) {
            throw new InstanceCreationException(e);
        }
    }

}
