package org.wr.om.core.rulebasedom.mvel;

import org.mvel2.MVEL;

public class MvelApplyInstanceFieldValue<O, I> extends MvelApplyOrderFieldValue<O, I>{

    @Override
    protected void compile() {
        if (null == compiled) {
            compiled = MVEL.compileExpression("instance."+this.getFieldName()+" = ("+expression+");");
        }
    }

}
