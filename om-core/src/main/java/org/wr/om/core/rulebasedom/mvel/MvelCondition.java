package org.wr.om.core.rulebasedom.mvel;

import org.mvel2.MVEL;
import org.wr.om.core.rulebasedom.OMCondition;

import java.util.Map;

public class MvelCondition<O,I> extends AbstractMvelUnit<O,I> implements OMCondition<O,I>{

    @Override
    public boolean isApplicable(O order, I instance) {
        compile();

        Map vars = this.prepareVars(order,instance);

        return (Boolean)MVEL.executeExpression(getCompiled(), vars);
    }

}
