package at.campus02.swe.E2ETest;

import at.campus02.swe.CalculatorException;
import at.campus02.swe.logic.CalculatorImpl;
import at.campus02.swe.parser.Parser;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.Assert.fail;

public class E2ETestDotproduct {

    @Test
    public void testDotproductOperator() throws CalculatorException, XMLStreamException, FileNotFoundException {

        CalculatorImpl calc = new CalculatorImpl();
        Parser par = new Parser(calc);

        double result = par.parse(new File("src/test/resources/test09.xml"));

        Assert.assertEquals(14.0, result, 0);
    }

    @Test
    public void testDotproductOperator2() throws CalculatorException, XMLStreamException, FileNotFoundException {

        CalculatorImpl calc = new CalculatorImpl();
        Parser par = new Parser(calc);

        double result = par.parse(new File("src/test/resources/test10.xml"));

        Assert.assertEquals(126.0, result, 0);
    }

    @Test
    public void testDotproductOperatorNeg() throws CalculatorException, XMLStreamException, FileNotFoundException {

        CalculatorImpl calc = new CalculatorImpl();
        Parser par = new Parser(calc);

        try {
            double result = par.parse(new File("src/test/resources/test11.xml"));
            fail("Exception expected");
        } catch (CalculatorException e) {
            Assert.assertEquals("Number of elements per vector must be > 0", e.getMessage());
        }
    }
}
