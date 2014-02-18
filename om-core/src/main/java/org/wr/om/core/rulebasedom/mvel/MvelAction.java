package org.wr.om.core.rulebasedom.mvel;

import org.mvel2.MVEL;
import org.wr.om.core.rulebasedom.OMAction;

import java.util.Map;

public class MvelAction<O,I> extends AbstractMvelUnit<O,I> implements OMAction<O,I>{

    @Override
    public void execute(O order, I instance) {
        compile();

        Map vars = this.prepareVars(order,instance);

        MVEL.executeExpression(getCompiled(), vars);
    }

    @Override
    public String toString() {
        return "MvelAction{" +
                "expression='" + expression + '\'' +
                '}';
    }
}
