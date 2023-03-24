package models;

import java.util.TreeMap;

public class Polynomial  {
    private String name;
    //Use a treeMap as it maintains a sorted order. The idea is to have a list of sorted exponents for iterating through them later
    //Each exponent is linked to a coefficient
    private TreeMap<Integer, Double> monomes;

    public Polynomial(String name) {
        this.name = name;
        this.monomes = new TreeMap<Integer, Double>();
    }

    public Polynomial(TreeMap<Integer, Double> monomes) {
        this.monomes = monomes;
    }

    public Polynomial() {
        this.monomes = new TreeMap<Integer, Double>();
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

    public void concatMonome(Monomial monome) {
        monomes.put(monome.getExponent(), monome.getCoefficient());
    }

    public String toString() {
        String result = "";
        for(int i = monomes.size() - 1; i >= 0; --i) {
            Double coefficient = monomes.get(i);
            //Remove plus sign if negative term
            if(coefficient < 0 && i != monomes.size() - 1) {
                result = result.substring(0, result.length() - 1);
            }
            if(coefficient == null) {
                continue;
            }
            String tempString = coefficient.toString() + "x^" + i;
            result += tempString;
            if(i != 0) {
                result += "+";
            }
        }
        return result;
    }
}
