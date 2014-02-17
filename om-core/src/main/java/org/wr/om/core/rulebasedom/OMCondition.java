package org.wr.om.core.rulebasedom;


public interface OMCondition<O, I> {

    boolean isApplicable(O order, I instance);

}
