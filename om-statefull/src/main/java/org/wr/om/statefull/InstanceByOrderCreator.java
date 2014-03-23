package org.wr.om.statefull;

import org.wr.om.core.PublicCloneable;

public interface InstanceByOrderCreator<O, I  extends PublicCloneable> {

    I create(O order);
}
