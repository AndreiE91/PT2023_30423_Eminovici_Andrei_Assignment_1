package models;

import java.util.*;

import static java.lang.Math.max;

public class Operation {

    public Polynomial readPolynomial(String input) throws ReadPolynomialException{
        Polynomial result = new Polynomial();

        input = input.replaceAll("X", "x");
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
                    } else if(termParts[0].equals("-")){
                        coefficient = -1.0;
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

        // Iterate over each term in the first polynomial
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

    public Polynomial subtractPolynomials(Polynomial p1, Polynomial p2) {
        //Create new polynomial for storing the final result
        Polynomial result = new Polynomial();

        // Iterate over each term in the first polynomial
        TreeMap<Integer, Double> p1Monomes = new TreeMap<>(p1.getMonomes());
        TreeMap<Integer, Double> p2Monomes = new TreeMap<>(p2.getMonomes());
        for (Map.Entry<Integer, Double> monome : p1Monomes.entrySet()) {
            if (p2Monomes.containsKey(monome.getKey())) { // If exponents match
                result.concatMonome(monome.getKey(), monome.getValue() - p2Monomes.get(monome.getKey()));
                p2Monomes.remove(monome.getKey());
            } else {
                result.concatMonome(monome.getKey(), monome.getValue());
            }
        }

        // Subtract leftovers from p2
        for (Map.Entry<Integer, Double> monome : p2Monomes.entrySet()) {
            result.concatMonome(monome.getKey(), -1 * monome.getValue());
        }
        return result;
    }

    public Polynomial integratePolynomial(Polynomial p1) {
        Polynomial result = new Polynomial();

        for(Map.Entry<Integer, Double> monome : p1.getMonomes().entrySet()) {
            if(monome.getValue() == 0) { //Skip over 0 coefficient terms if any
                continue;
            }
            result.concatMonome(monome.getKey() + 1, monome.getValue() * 1 / (monome.getKey() + 1));
        }
        return result;
    }

    public Polynomial differentiatePolynomial(Polynomial p1) {
        Polynomial result = new Polynomial();

        for(Map.Entry<Integer, Double> monome : p1.getMonomes().entrySet()) {
            if(monome.getValue() == 0 || monome.getKey() == 0) { //Skip over 0 coefficient or constant terms if any
                continue;
            }
            result.concatMonome(monome.getKey() - 1, monome.getValue() * monome.getKey());
        }
        return result;
    }

    public Polynomial multiplyPolynomials(Polynomial p1, Polynomial p2) {
        Polynomial result = new Polynomial(); // Final result
        ArrayList<Polynomial> intermediateResults = new ArrayList<>();

        for(Map.Entry<Integer, Double> monome_p1 : p1.getMonomes().entrySet()) {
            Polynomial tempResult = new Polynomial(); // Intermediate result for storing all permutations of a term with all the others
            for(Map.Entry<Integer, Double> monome_p2 : p2.getMonomes().entrySet()) {
                //Create a list of intermediate results for storing each permutation of the multiplication steps
                tempResult.concatMonome(monome_p1.getKey() + monome_p2.getKey(), monome_p1.getValue() * monome_p2.getValue());
            }
            intermediateResults.add(tempResult);
        }
        //Add all of the intermediate result polynomials for the final solution
        Operation operations = new Operation();
        for(Polynomial tempResult : intermediateResults) {
            result = operations.addPolynomials(result, tempResult);
        }
        return result;
    }

    public Polynomial dividePolynomials(Polynomial p1, Polynomial p2) throws ArithmeticException {
        if (p2.getDegree() == 0 && p2.getMonomes().get(0) == 0.0) {
            throw new ArithmeticException("Division by zero");
        }

        Polynomial remainder = new Polynomial(); // Rest
        Polynomial result = new Polynomial();
        remainder.setMonomes(p1.getMonomes()); // Rest equal to dividend initially
        remainder.setDegree(p1.getDegree());


        // As long as p2 "fits" into remainder and remainder is not empty, keep going
        while (remainder.getDegree() >= p2.getDegree() && !remainder.getMonomes().isEmpty()) {
            // Compute difference of exponents and divide coefficients for constructing the term
            int expDiff = remainder.getDegree() - p2.getDegree();
            double coef = remainder.getMonomes().get(remainder.getDegree()) / p2.getMonomes().get(p2.getDegree());
            Polynomial quotient = new Polynomial();
            quotient.concatMonome(expDiff, coef); // Create the quotient

            result = addPolynomials(result, quotient); // Add the division quotient to the final result
            Polynomial term = multiplyPolynomials(p2, quotient); // Multiply divisor by quotient and subtract it from remainder

            remainder = subtractPolynomials(remainder, term);
            if(remainder.getDegree() == 0 && p2.getDegree() == 0) { // Avoid endless loop by terminating if both p1 and p2 are constants
                break;
            }
        }
        return result;
    }

}
