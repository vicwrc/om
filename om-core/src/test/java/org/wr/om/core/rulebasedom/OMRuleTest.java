package org.wr.om.core.rulebasedom;

import junit.framework.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.wr.om.core.TransitionExecutionException;

import java.util.Collections;

import static org.mockito.Mockito.*;

public class OMRuleTest {


    private OMRule rule = new OMRule();

    @Test
    public void testExecute_whenActionIsMatched() throws Exception {

        /* Model initialization */
        OMCondition condition = Mockito.mock(OMCondition.class);
        OMAction action = Mockito.mock(OMAction.class);

        Object order = new Object();
        Object instance = new Object();
        /* Relationship and behavior building */

        rule.setCondition(condition);
        rule.setActions(Collections.singletonList(action));

        when(condition.isApplicable(order,instance)).thenReturn(true);

        Assert.assertTrue(rule.execute(order, instance));

        verify(action, times(1)).execute(order,instance);

    }

    @Test
    public void testExecute_whenActionIsNotMatched() throws Exception {

        /* Model initialization */
        OMCondition condition = Mockito.mock(OMCondition.class);
        OMAction action = Mockito.mock(OMAction.class);

        Object order = new Object();
        Object instance = new Object();
        /* Relationship and behavior building */

        rule.setCondition(condition);
        rule.setActions(Collections.singletonList(action));

        when(condition.isApplicable(order,instance)).thenReturn(false);

        Assert.assertFalse(rule.execute(order, instance));

        verify(action, never()).execute(order,instance);

    }

    @Test(expected = TransitionExecutionException.class)
    public void testExecute_doThrowException_when() throws Exception {

        /* Model initialization */
        OMCondition condition = Mockito.mock(OMCondition.class);
        OMAction action = Mockito.mock(OMAction.class);

        Object order = new Object();
        Object instance = new Object();
        /* Relationship and behavior building */

        rule.setCondition(condition);
        rule.setActions(Collections.singletonList(action));

        when(condition.isApplicable(order,instance)).thenReturn(true);
        doThrow(new TransitionExecutionException()).when(action).execute(order,instance);


        rule.execute(order, instance);
    }
}
