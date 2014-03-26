package org.wr.om.statefull.instancecreator;

import org.wr.om.core.rulebasedom.OMCondition;

import java.io.Serializable;

public class CreationRule implements Serializable {

    private static final long serialVersionUID = -5287096571982952963L;

    private String name;
    private OMCondition condition;
    private Class instanceClass;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OMCondition getCondition() {
        return condition;
    }

    public void setCondition(OMCondition condition) {
        this.condition = condition;
    }

    public Class getInstanceClass() {
        return instanceClass;
    }

    public void setInstanceClass(Class instanceClass) {
        this.instanceClass = instanceClass;
    }
}
