package org.wr.om.statefull.storage;

import org.wr.om.core.PublicCloneable;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public abstract class AbstractInMemoryOIStorage<O, I extends PublicCloneable> extends AbstractOrderInstanceStorage<O, I> {

    private Map<O, I> instanceStorage = new ConcurrentHashMap<O, I>();

    @Override
    public void saveByRoot(O rootOrder, I curInstance) {
        instanceStorage.put(rootOrder, curInstance);
    }

    @Override
    protected I getInstanceByRoot(O rootOrder) {
        return instanceStorage.get(rootOrder);
    }

}
