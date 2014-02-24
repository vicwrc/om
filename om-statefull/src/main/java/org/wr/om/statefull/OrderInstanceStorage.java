package org.wr.om.statefull;

import org.wr.om.core.PublicCloneable;

public interface OrderInstanceStorage <O, I extends PublicCloneable> {

    void save(O order, I curInstance);

    O getParent(O order);

    I getInstance(O order);
}
