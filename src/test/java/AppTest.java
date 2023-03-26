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
        assertEquals("3.0x^2+2.0x-5.0", p.toString());
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
        assertEquals("3.0x^2+2.0x-5.0", p.toString());
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
        assertEquals("-3.0x^2-2.0x-5.0", p.toString());
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
        assertEquals("3.0x^2+2.0x-5.0", p.toString());
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
        assertEquals("3.0x^2", p.toString());
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
        assertEquals("-3.0x^2", p.toString());
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
        assertEquals("-1.0", p.toString());
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
        assertEquals("1.0", p.toString());
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
        assertEquals("7.0x^2+3.0x+3.0", result.toString());
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
        assertEquals("3.0x^7+4.0x^2+3.0x+3.0", result.toString());
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
        assertEquals("2.0x", result.toString());
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
        assertEquals("2.0", result.toString());
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
        assertEquals("10.0x^10+3.0x^2+2.0x+3.0", result.toString());
    }
}


