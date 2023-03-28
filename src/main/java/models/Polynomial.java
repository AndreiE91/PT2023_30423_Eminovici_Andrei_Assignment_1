package models;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Polynomial  {
    private String name;
    //Use a treeMap as it maintains a sorted order. The idea is to have a list of sorted exponents for iterating through them later
    //Each exponent is linked to a coefficient
    private TreeMap<Integer, Double> monomes;

    public Polynomial(String name) {
        this.name = name;
        this.monomes = new TreeMap<Integer, Double>(Collections.reverseOrder());
    }

    public Polynomial(TreeMap<Integer, Double> monomes) {
        this.monomes = monomes;
    }

    public Polynomial() {
        this.monomes = new TreeMap<Integer, Double>(Collections.reverseOrder());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeMap<Integer, Double> getMonomes() {
        return monomes;
    }

    public void setMonomes(TreeMap<Integer, Double> monomes) {
        this.monomes = monomes;
    }

    public void concatMonome(int exponent, double coefficient) {
        monomes.put(exponent, coefficient);
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for(Map.Entry<Integer, Double> monome : monomes.entrySet()) {
            double coefficient = monome.getValue();
            int exponent = monome.getKey();
            if(coefficient == 0 && exponent == 0) {
                result.append("+");
                continue;
            }
//            System.out.println(coefficient);
//            System.out.println(exponent);

            //Remove plus sign if negative term
            if(coefficient <= 0 && !result.isEmpty()) {
                result = new StringBuilder(result.substring(0, result.length() - 1));
            }
            String tempString;
            if(coefficient == 1.0) {
                tempString = "x^";
            } else if(coefficient == -1.0) {
                tempString = "-x^";
            } else if(coefficient == 0.0){
                tempString = "";
            }
             else {
                String formattedValue = String.format("%.2f", coefficient);
                tempString = formattedValue + "x^";
            }
            if(exponent == 1 && !tempString.isEmpty()) {
                tempString = tempString.substring(0, tempString.length() - 1);
            } else if(exponent == 0){
                if(coefficient != 1) {
                    tempString = tempString.substring(0, tempString.length() - 2);
                    if(coefficient == -1.0) {
                        tempString += "1,00";
                    }
                } else {
                    tempString = "1,00";
                }
            } else {
                if(coefficient != 0) {
                    tempString += monome.getKey().toString();
                }
            }
            result.append(tempString);
            result.append("+");
        }
        //Remove last plus sign which leads to no term
        if(!result.isEmpty()) {
            result = new StringBuilder(result.substring(0, result.length() - 1));
        }
        if(result.isEmpty()) {
            result.append("0");
        }
        return result.toString();
    }
}
