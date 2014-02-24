package org.wr.om.statefull;

import org.wr.om.core.PublicCloneable;

public interface StatefulOrderManagement <O, I extends PublicCloneable> {

    I apply(O order);

}
