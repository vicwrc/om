package org.wr.om.core;

public interface OrderManagement<O, I extends PublicCloneable> {

    I apply(O order, I curInstance);


}
