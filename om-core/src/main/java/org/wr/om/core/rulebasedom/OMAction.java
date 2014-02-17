package org.wr.om.core.rulebasedom;


public interface OMAction<O, I> {

    void execute(O order, I instance);

}
