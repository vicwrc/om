package org.wr.om.core.rulebasedom.mvel;

import org.mvel2.MVEL;

public class MvelApplyOrderFieldValue<O, I> extends MvelAction<O, I>{

    protected String fieldName;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    protected void compile() {
        if (null == compiled) {
            compiled = MVEL.compileExpression("order." + this.getFieldName() + " = (" + expression + ");");
        }
    }
}
