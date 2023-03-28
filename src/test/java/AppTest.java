import models.Operations;
import models.Polynomial;
import models.ReadPolynomialException;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class AppTest {
    @Test
    public void testReadPrint() {
        Polynomial p = null;
        try {
            Operations operation = new Operations();
            p = operation.readPolynomial("3x^2+2x-5");
        } catch (ReadPolynomialException e) {
            throw new RuntimeException(e);
        }
        assertEquals("3,00x^2+2,00x-5,00", p.toString());
    }

    @Test
    public void testReadPrintSpaces() {
        Polynomial p = null;
        try {
            Operations operation = new Operations();
            p = operation.readPolynomial("   3   x  ^  2 + 2 x - 5  ");
        } catch (ReadPolynomialException e) {
            throw new RuntimeException(e);
        }
        assertEquals("3,00x^2+2,00x-5,00", p.toString());
    }

    @Test
    public void testReadPrintNegative() {
        Polynomial p = null;
        try {
            Operations operation = new Operations();
            p = operation.readPolynomial("-3x^2-2x-5");
        } catch (ReadPolynomialException e) {
            throw new RuntimeException(e);
        }
        assertEquals("-3,00x^2-2,00x-5,00", p.toString());
    }

    @Test
    public void testReadPrintExplicitSyntax() {
        Polynomial p = null;
        try {
            Operations operation = new Operations();
            p = operation.readPolynomial("3.0x^2+2.0x^1-5.0x^0");
        } catch (ReadPolynomialException e) {
            throw new RuntimeException(e);
        }
        assertEquals("3,00x^2+2,00x-5,00", p.toString());
    }

    @Test
    public void testReadPrintSingleTerm() {
        Polynomial p = null;
        try {
            Operations operation = new Operations();
            p = operation.readPolynomial("3x^2");
        } catch (ReadPolynomialException e) {
            throw new RuntimeException(e);
        }
        assertEquals("3,00x^2", p.toString());
    }

    @Test
    public void testReadPrintSingleNegativeTerm() {
        Polynomial p = null;
        try {
            Operations operation = new Operations();
            p = operation.readPolynomial("-3x^2");
        } catch (ReadPolynomialException e) {
            throw new RuntimeException(e);
        }
        assertEquals("-3,00x^2", p.toString());
    }

    @Test
    public void testReadPrintZeroExponent() {
        Polynomial p = null;
        try {
            Operations operation = new Operations();
            p = operation.readPolynomial("-1x^0");
        } catch (ReadPolynomialException e) {
            throw new RuntimeException(e);
        }
        assertEquals("-1,00", p.toString());
    }

    @Test
    public void testReadPrintOne() {
        Polynomial p = null;
        try {
            Operations operation = new Operations();
            p = operation.readPolynomial("1");
        } catch (ReadPolynomialException e) {
            throw new RuntimeException(e);
        }
        assertEquals("1,00", p.toString());
    }

    @Test
    public void testReadPrintEx() {
        Polynomial p = null;
        try {
            Operations operation = new Operations();
            p = operation.readPolynomial("x");
        } catch (ReadPolynomialException e) {
            throw new RuntimeException(e);
        }
        assertEquals("x", p.toString());
    }

    @Test
    public void testAdditionBasic() {
        Polynomial p1 = null;
        Polynomial p2 = null;
        Polynomial result = null;
        try {
            Operations operation = new Operations();
            p1 = operation.readPolynomial("3x^2+2x+2");
            p2 = operation.readPolynomial("4x^2+x+1");
            result = operation.addPolynomials(p1, p2);
        } catch (ReadPolynomialException e) {
            throw new RuntimeException(e);
        }
        assertEquals("7,00x^2+3,00x+3,00", result.toString());
    }

    @Test
    public void testAdditionNoCommonExponent() {
        Polynomial p1 = null;
        Polynomial p2 = null;
        Polynomial result = null;
        try {
            Operations operation = new Operations();
            p1 = operation.readPolynomial("3x^7+2x+2");
            p2 = operation.readPolynomial("4x^2+x+1");
            result = operation.addPolynomials(p1, p2);
        } catch (ReadPolynomialException e) {
            throw new RuntimeException(e);
        }
        assertEquals("3,00x^7+4,00x^2+3,00x+3,00", result.toString());
    }

    @Test
    public void testAdditionJustEx() {
        Polynomial p1 = null;
        Polynomial p2 = null;
        Polynomial result = null;
        try {
            Operations operation = new Operations();
            p1 = operation.readPolynomial("x");
            p2 = operation.readPolynomial("x");
            result = operation.addPolynomials(p1, p2);
        } catch (ReadPolynomialException e) {
            throw new RuntimeException(e);
        }
        assertEquals("2,00x", result.toString());
    }

    @Test
    public void testAdditionJustConstants() {
        Polynomial p1 = null;
        Polynomial p2 = null;
        Polynomial result = null;
        try {
            Operations operation = new Operations();
            p1 = operation.readPolynomial("1");
            p2 = operation.readPolynomial("1");
            result = operation.addPolynomials(p1, p2);
        } catch (ReadPolynomialException e) {
            throw new RuntimeException(e);
        }
        assertEquals("2,00", result.toString());
    }

    @Test
    public void testAdditionLongScrambledShort() {
        Polynomial p1 = null;
        Polynomial p2 = null;
        Polynomial result = null;
        try {
            Operations operation = new Operations();
            p1 = operation.readPolynomial("3x^2+10x^10+2x+2");
            p2 = operation.readPolynomial("1");
            result = operation.addPolynomials(p1, p2);
        } catch (ReadPolynomialException e) {
            throw new RuntimeException(e);
        }
        assertEquals("10,00x^10+3,00x^2+2,00x+3,00", result.toString());
    }

    @Test
    public void testSubtractionTailEx() {
        Polynomial p1 = null;
        Polynomial p2 = null;
        Polynomial result = null;
        try {
            Operations operation = new Operations();
            p1 = operation.readPolynomial("2x^2+x^6+x");
            p2 = operation.readPolynomial("x");
            result = operation.subtractPolynomials(p1, p2);
        } catch (ReadPolynomialException e) {
            throw new RuntimeException(e);
        }
        assertEquals("x^6+2,00x^2", result.toString());
    }
    @Test
    public void testSubtractionIdentical() {
        Polynomial p1 = null;
        Polynomial p2 = null;
        Polynomial result = null;
        try {
            Operations operation = new Operations();
            p1 = operation.readPolynomial("2x^2+x^6+x");
            p2 = operation.readPolynomial("2x^2+x^6+x");
            result = operation.subtractPolynomials(p1, p2);
        } catch (ReadPolynomialException e) {
            throw new RuntimeException(e);
        }
        assertEquals("0", result.toString());
    }
    @Test
    public void testSubtractionNegativeMiddleEx() {
        Polynomial p1 = null;
        Polynomial p2 = null;
        Polynomial result = null;
        try {
            Operations operation = new Operations();
            p1 = operation.readPolynomial("-2x^2-x^6+x");
            p2 = operation.readPolynomial("-x^6");
            result = operation.subtractPolynomials(p1, p2);
        } catch (ReadPolynomialException e) {
            throw new RuntimeException(e);
        }
        assertEquals("-2,00x^2+x", result.toString());
    }

    @Test
    public void testSubtractionConstants() {
        Polynomial p1 = null;
        Polynomial p2 = null;
        Polynomial result = null;
        try {
            Operations operation = new Operations();
            p1 = operation.readPolynomial("2");
            p2 = operation.readPolynomial("2");
            result = operation.subtractPolynomials(p1, p2);
        } catch (ReadPolynomialException e) {
            throw new RuntimeException(e);
        }
        assertEquals("0", result.toString());
    }

    @Test
    public void testSubtractionExx() {
        Polynomial p1 = null;
        Polynomial p2 = null;
        Polynomial result = null;
        try {
            Operations operation = new Operations();
            p1 = operation.readPolynomial("x");
            p2 = operation.readPolynomial("x");
            result = operation.subtractPolynomials(p1, p2);
        } catch (ReadPolynomialException e) {
            throw new RuntimeException(e);
        }
        assertEquals("0", result.toString());
    }

    @Test
    public void testIntegrationBasic() {
        Polynomial p1 = null;
        Polynomial result = null;
        try {
            Operations operation = new Operations();
            p1 = operation.readPolynomial("x^2+2x+1");
            result = operation.integratePolynomial(p1);
        } catch (ReadPolynomialException e) {
            throw new RuntimeException(e);
        }
        assertEquals("0,33x^3+x^2+x", result.toString());
    }

    @Test
    public void testIntegrationSmall() {
        Polynomial p1 = null;
        Polynomial result = null;
        try {
            Operations operation = new Operations();
            p1 = operation.readPolynomial("1");
            result = operation.integratePolynomial(p1);
        } catch (ReadPolynomialException e) {
            throw new RuntimeException(e);
        }
        assertEquals("x", result.toString());
    }
    @Test
    public void testIntegrationBig() {
        Polynomial p1 = null;
        Polynomial result = null;
        try {
            Operations operation = new Operations();
            p1 = operation.readPolynomial("100x^100");
            result = operation.integratePolynomial(p1);
        } catch (ReadPolynomialException e) {
            throw new RuntimeException(e);
        }
        assertEquals("0,99x^101", result.toString());
    }
    @Test
    public void testIntegrationZero() {
        Polynomial p1 = null;
        Polynomial result = null;
        try {
            Operations operation = new Operations();
            p1 = operation.readPolynomial("0");
            result = operation.integratePolynomial(p1);
        } catch (ReadPolynomialException e) {
            throw new RuntimeException(e);
        }
        assertEquals("0", result.toString());
    }

    @Test
    public void testIntegrationNegative() {
        Polynomial p1 = null;
        Polynomial result = null;
        try {
            Operations operation = new Operations();
            p1 = operation.readPolynomial("-4x^2");
            result = operation.integratePolynomial(p1);
        } catch (ReadPolynomialException e) {
            throw new RuntimeException(e);
        }
        assertEquals("-1,33x^3", result.toString());
    }

    @Test
    public void testDifferentiationBasic() {
        Polynomial p1 = null;
        Polynomial result = null;
        try {
            Operations operation = new Operations();
            p1 = operation.readPolynomial("2x^2+3x+2");
            result = operation.differentiatePolynomial(p1);
        } catch (ReadPolynomialException e) {
            throw new RuntimeException(e);
        }
        assertEquals("4,00x+3,00", result.toString());
    }

    @Test
    public void testDifferentiationEx() {
        Polynomial p1 = null;
        Polynomial result = null;
        try {
            Operations operation = new Operations();
            p1 = operation.readPolynomial("3x");
            result = operation.differentiatePolynomial(p1);
        } catch (ReadPolynomialException e) {
            throw new RuntimeException(e);
        }
        assertEquals("3,00", result.toString());
    }

    @Test
    public void testDifferentiationConstant() {
        Polynomial p1 = null;
        Polynomial result = null;
        try {
            Operations operation = new Operations();
            p1 = operation.readPolynomial("2");
            result = operation.differentiatePolynomial(p1);
        } catch (ReadPolynomialException e) {
            throw new RuntimeException(e);
        }
        assertEquals("0", result.toString());
    }

    @Test
    public void testDifferentiationZero() {
        Polynomial p1 = null;
        Polynomial result = null;
        try {
            Operations operation = new Operations();
            p1 = operation.readPolynomial("0");
            result = operation.differentiatePolynomial(p1);
        } catch (ReadPolynomialException e) {
            throw new RuntimeException(e);
        }
        assertEquals("0", result.toString());
    }

    @Test
    public void testDifferentiationNegative() {
        Polynomial p1 = null;
        Polynomial result = null;
        try {
            Operations operation = new Operations();
            p1 = operation.readPolynomial("-3x^4-2");
            result = operation.differentiatePolynomial(p1);
        } catch (ReadPolynomialException e) {
            throw new RuntimeException(e);
        }
        assertEquals("-12,00x^3", result.toString());
    }
}


