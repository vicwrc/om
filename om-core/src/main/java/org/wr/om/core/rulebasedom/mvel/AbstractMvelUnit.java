package org.wr.om.core.rulebasedom.mvel;

import org.mvel2.MVEL;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class AbstractMvelUnit<O, I> {

    protected String expression;
    protected Serializable compiled;

    protected Map prepareVars(O order, I instance) {

        Map vars = new HashMap();
        vars.put("order", order);
        vars.put("instance", instance);
        vars.put("helper", MvelHelper.getInstance());

        return vars;
    }

    protected void compile() {
        if (null == compiled) {
            compiled = MVEL.compileExpression(expression);
        }
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }

    public Serializable getCompiled() {
        return compiled;
    }
}
