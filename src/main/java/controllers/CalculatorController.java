package controllers;

import models.*;
import views.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {
    private ViewMain view;
    private CalculatorMain calculatorMain;

    public CalculatorController(ViewMain view, CalculatorMain calculatorMain) {
        this.view = view;

        this.calculatorMain = calculatorMain;

        this.view.addAdditionListener(new AdditionListener());
        this.view.addSubtractionListener(new SubtractionListener());
        this.view.addMultiplicationListener(new MultiplicationListener());
        this.view.addDivisionListener(new DivisionListener());
        this.view.addIntegrateP1Listener(new IntegrateP1Listener());
        this.view.addIntegrateP2Listener(new IntegrateP2Listener());
        this.view.addDifferentiateP1Listener(new DifferentiateP1Listener());
        this.view.addDifferentiateP2Listener(new DifferentiateP2Listener());
        this.view.addClearP1Listener(e -> {
                    this.view.getTextAreaPoly1().setText(null);
            }
        );
        this.view.addClearP2Listener(e -> {
                    this.view.getTextAreaPoly2().setText(null);
            }
        );
        this.view.addSwapOrderListener(e -> {
                    String temp = this.view.getTextAreaPoly1().getText();
                    this.view.getTextAreaPoly1().setText(this.view.getTextAreaPoly2().getText());
                    this.view.getTextAreaPoly2().setText(temp);
            }
        );
    }

    class AdditionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                Operations operations = new Operations();
                if(view.getTextAreaPoly1().getText().isEmpty() || view.getTextAreaPoly2().getText().isEmpty()) {
                    throw new NullInputException("Empty input text");
                }
                Polynomial p1 = operations.readPolynomial(view.getTextAreaPoly1().getText());

                Polynomial p2 = operations.readPolynomial(view.getTextAreaPoly2().getText());

                Polynomial additionResult = operations.addPolynomials(p1, p2);


                view.getTextAreaResult().setText(additionResult.toString());
            }
            catch (ReadPolynomialException readEx) {
                view.showErrorMessage("Error reading polynomial!");
            }
            catch(NullInputException nullInputException) {
                view.showErrorMessage(nullInputException.getMessage());
            }
            catch (Exception ex) {
                view.showErrorMessage("An uncategorized error has occured!");
            }
        }
    }
    class SubtractionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {

            }
            catch (Exception ex) {
                view.showErrorMessage("Error!");
            }
        }
    }
    class MultiplicationListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {

            }
            catch (Exception ex) {
                view.showErrorMessage("Error!");
            }
        }
    }
    class DivisionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {

            }
            catch (Exception ex) {
                view.showErrorMessage("Error!");
            }
        }
    }
    class IntegrateP1Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {

            }
            catch (Exception ex) {
                view.showErrorMessage("Error!");
            }
        }
    }
    class IntegrateP2Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {

            }
            catch (Exception ex) {
                view.showErrorMessage("Error!");
            }
        }
    }
    class DifferentiateP1Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {

            }
            catch (Exception ex) {
                view.showErrorMessage("Error!");
            }
        }
    }
    class DifferentiateP2Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {

            }
            catch (Exception ex) {
                view.showErrorMessage("Error!");
            }
        }
    }
}
