package models;

import java.util.regex.*;
import static java.lang.Math.max;

public class Operations {

    public Polynomial readPolynomial(String input) {
        //Create a new empty polynomial for storing the final result of the reading
        Polynomial result = new Polynomial();
        //Add a plus sign before any minus for splitting purposes
        String[] splitMonomes = input.replaceAll("-", "+-").split("\\+");
        //Iterate over each of the split substrings and extract the coefficient and exponent of each term.
        for(int i = splitMonomes.length - 1; i >= 0; --i) {
            //Create a monomial which will be concatenated to the final polynomial
            Monomial tempTerm;
            //Split again to have easily parsable substrings with coefficient and exponent
            String[] termParts = splitMonomes[i].split("x\\^");

            tempTerm = new Monomial(Double.parseDouble(termParts[0]), Integer.parseInt(termParts[1]));

            //Add the newly extracted monome to the final result.
            result.concatMonome(tempTerm);
        }
        return result;
    }

    public Polynomial addPolynomials(Polynomial p1, Polynomial p2) {
        //Create new polynomial for storing the final result
        Polynomial result = new Polynomial();
        //Compute the largest size of the two polynomials in order to not skip over any term
        int maxSize = max(p1.getMonomes().size(), p2.getMonomes().size());

        // Iterate over each term in the polynomials, including possible blanks(terms with zero coefficient)
        for(int i = 0; i < maxSize; ++i) {
            Monomial tempMonome = null;
            //If the exponents of the two polynomials match, simply add their coefficients
            if(p1.getMonomes().get(i) != null && p2.getMonomes().get(i) != null) {
                tempMonome = new Monomial(p1.getMonomes().get(i) + p2.getMonomes().get(i), i);
            } else if(p1.getMonomes().get(i) != null) {
                tempMonome = new Monomial(p1.getMonomes().get(i), i);
            } else if(p2.getMonomes().get(i) != null) {
                tempMonome = new Monomial(p2.getMonomes().get(i), i);
            }
            if(tempMonome != null) {
                result.concatMonome(tempMonome);
            }
        }
        return result;
    }
}
