package org.wr.om.core;

public interface OrderManagement<O extends HierarchicalOrder, I extends PublicCloneable> {

    I apply(O order, I curInstance);


}
