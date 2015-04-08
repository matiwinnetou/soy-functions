package pl.matisoft.soy.function;

import com.google.common.collect.ImmutableList;
import com.google.template.soy.data.SoyValue;
import com.google.template.soy.data.restricted.StringData;
import com.google.template.soy.jssrc.restricted.JsExpr;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LowerCaseFunctionTest {

    @Test
    public void testComputeForJava() {
        LowerCaseFunction lowerCaseFunction = new LowerCaseFunction();
        SoyValue calculated = lowerCaseFunction.computeForJava(ImmutableList.of(StringData.forValue("HellO")));

        assertEquals(StringData.forValue("hello"), calculated);
    }

    @Test
    public void testComputeForJsSrc() {
        LowerCaseFunction lowerCaseFunction = new LowerCaseFunction();

        JsExpr expr = new JsExpr("JS_CODE", Integer.MAX_VALUE);

        JsExpr computed = lowerCaseFunction.computeForJsSrc(ImmutableList.of(expr));

        assertEquals(new JsExpr("JS_CODE.toLowerCase()", Integer.MAX_VALUE), computed);
    }

}
