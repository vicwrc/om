package org.wr.om.core.rulebasedom.mvel;

import java.util.Date;

public class MvelHelper {

    private static MvelHelper instance = new MvelHelper();

    public static MvelHelper getInstance() {
        return instance;
    }


    public Object nvl(Object o1, Object o2) {
        return o1 == null ? o2 : o1;
    }

    public Date now() {
        return new Date();
    }

}
