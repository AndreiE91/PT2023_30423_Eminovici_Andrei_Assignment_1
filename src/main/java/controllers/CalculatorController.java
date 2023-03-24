package controllers;

import models.Polynomial;
import models.CalculatorMain;
import models.Operations;
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
    }

    class AdditionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                Operations operations = new Operations();
                Polynomial p1 = operations.readPolynomial(view.getTextAreaPoly1().getText());

                Polynomial p2 = operations.readPolynomial(view.getTextAreaPoly2().getText());

                Polynomial additionResult = operations.addPolynomials(p1, p2);

                view.getTextAreaResult().setText(additionResult.toString());
            }
            catch (Exception ex) {
                view.showErrorMessage("Error!");
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
