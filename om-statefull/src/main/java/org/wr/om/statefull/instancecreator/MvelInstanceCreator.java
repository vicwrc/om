package org.wr.om.statefull.instancecreator;

import org.wr.mvel.CompiledMVEL;
import org.wr.om.core.PublicCloneable;
import org.wr.om.statefull.InstanceByOrderCreator;

import java.util.HashMap;
import java.util.Map;

public class MvelInstanceCreator <O, I  extends PublicCloneable> implements InstanceByOrderCreator<O, I> {

    private String expression;

    public void setExpression(String expression) {
        this.expression = expression;
    }

    @Override
    public I create(O order) {
        Map vars = new HashMap();
        vars.put("order", order);
        return (I) CompiledMVEL.executeExpression(expression, vars);
    }
}
