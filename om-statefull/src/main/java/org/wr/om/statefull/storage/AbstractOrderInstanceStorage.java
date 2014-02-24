package org.wr.om.statefull.storage;

import org.wr.om.core.PublicCloneable;
import org.wr.om.statefull.OrderInstanceStorage;

public abstract class AbstractOrderInstanceStorage<O, I extends PublicCloneable> implements OrderInstanceStorage<O, I> {

    @Override
    public void save(O order, I curInstance) {
        saveByRoot(getRoot(order), curInstance);
    }

    public abstract void saveByRoot(O rootOrder, I curInstance);

    protected  abstract I createNewInstanceByOrder(O rootOrder);

    @Override
    public I getInstance(O order) {
        O root = getRoot(order);
        I instance =  getInstanceByRoot(root);
        if(null == instance) {
            instance = createNewInstanceByOrder(root);
        }
        return instance;
    }

    protected abstract I getInstanceByRoot(O rootOrder);

    protected O getRoot(O order) {
        O parent = getParent(order);
        return null == parent ? order : getRoot(parent);
    }

}
