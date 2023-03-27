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
            if(ViewMain.isStonkMode()) {
                ViewMain.playSound("hitButton.wav");
            }
                    this.view.getTextAreaPoly1().setText(null);
            }
        );
        this.view.addClearP2Listener(e -> {
            if(ViewMain.isStonkMode()) {
                ViewMain.playSound("hitButton.wav");
            }
                    this.view.getTextAreaPoly2().setText(null);
            }
        );
        this.view.addSwapOrderListener(e -> {
            if(ViewMain.isStonkMode()) {
                ViewMain.playSound("hitButton.wav");
            }

            String temp = this.view.getTextAreaPoly1().getText();
                    this.view.getTextAreaPoly1().setText(this.view.getTextAreaPoly2().getText());
                    this.view.getTextAreaPoly2().setText(temp);
            }
        );
        this.view.addStonkListener(e -> {
                    ViewMain.playSound("hitButton.wav");
                    this.view.playClip("money.wav");
                    this.view.setStonkMode(!ViewMain.isStonkMode());
        }
        );
    }

    class AdditionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                if(ViewMain.isStonkMode()) {
                    ViewMain.playSound("hitButton.wav");
                }
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
                if(ViewMain.isStonkMode()) {
                    ViewMain.playSound("error.wav");
                }
                view.showErrorMessage("Error reading polynomial!");
            }
            catch(NullInputException nullInputException) {
                if(ViewMain.isStonkMode()) {
                    ViewMain.playSound("error.wav");
                }
                view.showErrorMessage(nullInputException.getMessage());
            }
            catch (Exception ex) {
                if(ViewMain.isStonkMode()) {
                    ViewMain.playSound("error.wav");
                }
                view.showErrorMessage("An uncategorized error has occured!");
            }
        }
    }
    class SubtractionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                if(ViewMain.isStonkMode()) {
                    ViewMain.playSound("hitButton.wav");
                }
                Operations operations = new Operations();
                if(view.getTextAreaPoly1().getText().isEmpty() || view.getTextAreaPoly2().getText().isEmpty()) {
                    throw new NullInputException("Empty input text");
                }
                Polynomial p1 = operations.readPolynomial(view.getTextAreaPoly1().getText());

                Polynomial p2 = operations.readPolynomial(view.getTextAreaPoly2().getText());

                Polynomial subtractionResult = operations.subtractPolynomials(p1, p2);


                view.getTextAreaResult().setText(subtractionResult.toString());
            }
            catch (ReadPolynomialException readEx) {
                if(ViewMain.isStonkMode()) {
                    ViewMain.playSound("error.wav");
                }
                view.showErrorMessage("Error reading polynomial!");
            }
            catch(NullInputException nullInputException) {
                if(ViewMain.isStonkMode()) {
                    ViewMain.playSound("error.wav");
                }
                view.showErrorMessage(nullInputException.getMessage());
            }
            catch (Exception ex) {
                if(ViewMain.isStonkMode()) {
                    ViewMain.playSound("error.wav");
                }
                view.showErrorMessage("An uncategorized error has occured!");
            }
        }
    }
    class MultiplicationListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                if(ViewMain.isStonkMode()) {
                    ViewMain.playSound("hitButton.wav");
                }

            }
            catch (Exception ex) {
                if(ViewMain.isStonkMode()) {
                    ViewMain.playSound("error.wav");
                }
                view.showErrorMessage("Error!");
            }
        }
    }
    class DivisionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                if(ViewMain.isStonkMode()) {
                    ViewMain.playSound("hitButton.wav");
                }

            }
            catch (Exception ex) {
                if(ViewMain.isStonkMode()) {
                    ViewMain.playSound("error.wav");
                }
                view.showErrorMessage("Error!");
            }
        }
    }
    class IntegrateP1Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                if(ViewMain.isStonkMode()) {
                    ViewMain.playSound("hitButton.wav");
                }

            }
            catch (Exception ex) {
                if(ViewMain.isStonkMode()) {
                    ViewMain.playSound("error.wav");
                }
                view.showErrorMessage("Error!");
            }
        }
    }
    class IntegrateP2Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                if(ViewMain.isStonkMode()) {
                    ViewMain.playSound("hitButton.wav");
                }

            }
            catch (Exception ex) {
                if(ViewMain.isStonkMode()) {
                    ViewMain.playSound("error.wav");
                }
                view.showErrorMessage("Error!");
            }
        }
    }
    class DifferentiateP1Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                if(ViewMain.isStonkMode()) {
                    ViewMain.playSound("hitButton.wav");
                }

            }
            catch (Exception ex) {
                if(ViewMain.isStonkMode()) {
                    ViewMain.playSound("error.wav");
                }
                view.showErrorMessage("Error!");
            }
        }
    }
    class DifferentiateP2Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                if(ViewMain.isStonkMode()) {
                    ViewMain.playSound("hitButton.wav");
                }

            }
            catch (Exception ex) {
                if(ViewMain.isStonkMode()) {
                    ViewMain.playSound("error.wav");
                }
                view.showErrorMessage("Error!");
            }
        }
    }
}
