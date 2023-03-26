package models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.*;
import static java.lang.Math.max;

public class Operations {

    public Polynomial readPolynomial(String input) throws ReadPolynomialException{
        Polynomial result = new Polynomial();
        //First and foremost remove any spaces because that can and WILL cause problems
        if(input.contains(" ")) {
            input = input.replace(" ", "");
        }

        if(input.charAt(0) != '-') {
            input = "+" + input;
        }
        input = input.replaceAll("-", "+-");
        String[] splitMonomes = input.split("\\+");

        //Iterate over each of the split substrings and extract the coefficient and exponent of each term.
        for(String splitMonome : splitMonomes) {
            if(splitMonome.equals("")) {
                continue;
            }
            int exponent = 0;
            double coefficient = 0;
            String[] termParts = null;

            if(splitMonome.contains("x^")) {
                termParts = splitMonome.split("x\\^");
                try {
                    if (termParts[0].equals("")) {
                        coefficient = 1.0;
                    } else {
                        coefficient = Double.parseDouble(termParts[0]);
                    }
                    exponent = Integer.parseInt(termParts[1]);
                } catch (NullPointerException nullPointerException) {
                    throw new ReadPolynomialException("termParts was null. Error splitting monome");
                }
            } else {
                if (splitMonome.contains("x")) {
                    termParts = splitMonome.split("x");
                    exponent = 1;
                    if (termParts.length != 0 && !termParts[0].equals("")) {
                        coefficient = Double.parseDouble(termParts[0]);
                    } else {
                        coefficient = 1.0;
                    }
                } else {
                    try {
                        coefficient = Double.parseDouble(splitMonome);
                        exponent = 0;
                    } catch(NumberFormatException numberFormatException) {
                        throw new ReadPolynomialException("Error parsing coefficient for 0 exponent term!");
                    }
                }
            }
            result.concatMonome(exponent, coefficient);
        }
        return result;
    }

    public Polynomial addPolynomials(Polynomial p1, Polynomial p2) {
        //Create new polynomial for storing the final result
        Polynomial result = new Polynomial();

        // Iterate over each term in the polynomials
        TreeMap<Integer, Double> p1Monomes = new TreeMap<>(p1.getMonomes());
        TreeMap<Integer, Double> p2Monomes = new TreeMap<>(p2.getMonomes());
        for (Map.Entry<Integer, Double> monome : p1Monomes.entrySet()) {
            if (p2Monomes.containsKey(monome.getKey())) { // If exponents match
                result.concatMonome(monome.getKey(), monome.getValue() + p2Monomes.get(monome.getKey()));
                p2Monomes.remove(monome.getKey());
            } else {
                result.concatMonome(monome.getKey(), monome.getValue());
            }
        }

        // Add leftovers from p2
        for (Map.Entry<Integer, Double> monome : p2Monomes.entrySet()) {
            result.concatMonome(monome.getKey(), monome.getValue());
        }
        return result;
    }
}
