package org.wr.mvel;


import org.mvel2.MVEL;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CompiledMVEL {

    private static Map<String, Serializable> expressions = new ConcurrentHashMap<String, Serializable>();

    public static Object executeExpression(String expr, Map vars) {
        Serializable compiled = compileExpression(expr);
        return MVEL.executeExpression(compiled, vars);
    }

    public static Serializable compileExpression(String expr) {
        Serializable compiled =  expressions.get(expr);
        if (null == compiled) {
            compiled = MVEL.compileExpression(expr);
            expressions.put(expr, compiled);
        }
        return compiled;
    }

    public static void clear() {
        expressions.clear();
    }

}
