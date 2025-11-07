package at.campus02.swe.E2ETest;

import at.campus02.swe.logic.CalculatorImpl;
import at.campus02.swe.parser.Parser;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class E2ETestSin {
    @Test
    public void testSubDivideOperation() throws Exception {

        CalculatorImpl calc = new CalculatorImpl();
        Parser par = new Parser(calc);

        double result = par.parse(new File("src/test/resources/test07.xml"));

        Assert.assertEquals(0.909, result, 0.01);
    }
}


