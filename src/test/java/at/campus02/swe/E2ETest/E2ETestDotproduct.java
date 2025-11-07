package at.campus02.swe.E2ETest;

import at.campus02.swe.CalculatorException;
import at.campus02.swe.logic.CalculatorImpl;
import at.campus02.swe.parser.Parser;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.FileNotFoundException;

public class E2ETestDotproduct {

    @Test
    public void testDotproductOperator() throws CalculatorException, XMLStreamException, FileNotFoundException {

        CalculatorImpl calc = new CalculatorImpl();
        Parser par = new Parser(calc);

        double result = par.parse(new File("src/test/resources/test09.xml"));

        Assert.assertEquals(14.0, result, 0);
    }
}
