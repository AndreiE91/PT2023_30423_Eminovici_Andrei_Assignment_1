package controllers;

import models.*;
import views.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {
    private ViewMain view;
    public CalculatorController(ViewMain view) {
        this.view = view;

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
                ViewMain.playSound("hitSmall.wav");
            }
                    this.view.getTextAreaPoly1().setText(null);
            }
        );
        this.view.addClearP2Listener(e -> {
            if(ViewMain.isStonkMode()) {
                ViewMain.playSound("hitSmall.wav");
            }
                    this.view.getTextAreaPoly2().setText(null);
            }
        );
        this.view.addSwapOrderListener(e -> {
            if(ViewMain.isStonkMode()) {
                ViewMain.playSound("hitSmall.wav");
            }

            String temp = this.view.getTextAreaPoly1().getText();
                    this.view.getTextAreaPoly1().setText(this.view.getTextAreaPoly2().getText());
                    this.view.getTextAreaPoly2().setText(temp);
            }
        );
        this.view.addStonkListener(e -> {
                    ViewMain.playSound("hitSmall.wav");
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
                    view.buttonClickGif();
                    ViewMain.playSound("hitButton.wav", 500);
                }
                Operation operations = new Operation();
                if(view.getTextAreaPoly1().getText().isEmpty() || view.getTextAreaPoly2().getText().isEmpty()) {
                    throw new NullInputException("Empty input text");
                }
                Polynomial p1 = operations.readPolynomial(view.getTextAreaPoly1().getText());

                Polynomial p2 = operations.readPolynomial(view.getTextAreaPoly2().getText());

                Polynomial additionResult = operations.addPolynomials(p1, p2);

                if(ViewMain.isStonkMode()) {
                    Timer timer = new Timer(500, f -> view.getTextAreaResult().setText(additionResult.toString()));
                    timer.setRepeats(false);
                    timer.start();
                } else {
                    view.getTextAreaResult().setText(additionResult.toString());
                }
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
                    view.buttonClickGif();
                    ViewMain.playSound("hitButton.wav", 500);
                }
                Operation operations = new Operation();
                if(view.getTextAreaPoly1().getText().isEmpty() || view.getTextAreaPoly2().getText().isEmpty()) {
                    throw new NullInputException("Empty input text");
                }
                Polynomial p1 = operations.readPolynomial(view.getTextAreaPoly1().getText());

                Polynomial p2 = operations.readPolynomial(view.getTextAreaPoly2().getText());

                Polynomial subtractionResult = operations.subtractPolynomials(p1, p2);

                if(ViewMain.isStonkMode()) {
                    Timer timer = new Timer(500, f -> view.getTextAreaResult().setText(subtractionResult.toString()));
                    timer.setRepeats(false);
                    timer.start();
                } else {
                    view.getTextAreaResult().setText(subtractionResult.toString());
                }
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
                    view.buttonClickGif();
                    ViewMain.playSound("hitButton.wav", 500);
                }
                Operation operations = new Operation();
                if(view.getTextAreaPoly1().getText().isEmpty() || view.getTextAreaPoly2().getText().isEmpty()) {
                    throw new NullInputException("Empty input text");
                }
                Polynomial p1 = operations.readPolynomial(view.getTextAreaPoly1().getText());

                Polynomial p2 = operations.readPolynomial(view.getTextAreaPoly2().getText());

                Polynomial multiplicationResult = operations.multiplyPolynomials(p1, p2);

                if(ViewMain.isStonkMode()) {
                    Timer timer = new Timer(500, f -> view.getTextAreaResult().setText(multiplicationResult.toString()));
                    timer.setRepeats(false);
                    timer.start();
                } else {
                    view.getTextAreaResult().setText(multiplicationResult.toString());
                }
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
    class DivisionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                if(ViewMain.isStonkMode()) {
                    view.buttonClickGif();
                    ViewMain.playSound("hitButton.wav", 500);
                }
                Operation operations = new Operation();
                if(view.getTextAreaPoly1().getText().isEmpty() || view.getTextAreaPoly2().getText().isEmpty()) {
                    throw new NullInputException("Empty input text");
                }
                Polynomial p1 = operations.readPolynomial(view.getTextAreaPoly1().getText());

                Polynomial p2 = operations.readPolynomial(view.getTextAreaPoly2().getText());

                Polynomial divisionResult = operations.dividePolynomials(p1, p2);

                if(ViewMain.isStonkMode()) {
                    Timer timer = new Timer(500, f -> view.getTextAreaResult().setText(divisionResult.toString()));
                    timer.setRepeats(false);
                    timer.start();
                } else {
                    view.getTextAreaResult().setText(divisionResult.toString());
                }
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
            catch (ArithmeticException ex) {
                if(ViewMain.isStonkMode()) {
                    ViewMain.playSound("error.wav");
                }
                view.showErrorMessage(ex.getMessage());
            }
            catch (Exception ex) {
                if(ViewMain.isStonkMode()) {
                    ViewMain.playSound("error.wav");
                }
                view.showErrorMessage("An uncategorized error has occured!");
            }
        }
    }
    class IntegrateP1Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                if(ViewMain.isStonkMode()) {
                    view.buttonClickGif();
                    ViewMain.playSound("hitButton.wav", 500);
                }
                Operation operations = new Operation();
                if(view.getTextAreaPoly1().getText().isEmpty()) {
                    throw new NullInputException("Empty input text");
                }
                Polynomial p1 = operations.readPolynomial(view.getTextAreaPoly1().getText());

                Polynomial integrationResult = operations.integratePolynomial(p1);

                if(ViewMain.isStonkMode()) {
                    Timer timer = new Timer(500, f -> view.getTextAreaResult().setText(integrationResult.toString()));
                    timer.setRepeats(false);
                    timer.start();
                } else {
                    view.getTextAreaResult().setText(integrationResult.toString());
                }

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
    class IntegrateP2Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                if(ViewMain.isStonkMode()) {
                    view.buttonClickGif();
                    ViewMain.playSound("hitButton.wav", 500);
                }
                Operation operations = new Operation();
                if(view.getTextAreaPoly1().getText().isEmpty()) {
                    throw new NullInputException("Empty input text");
                }
                Polynomial p2 = operations.readPolynomial(view.getTextAreaPoly2().getText());

                Polynomial integrationResult = operations.integratePolynomial(p2);

                if(ViewMain.isStonkMode()) {
                    Timer timer = new Timer(500, f -> view.getTextAreaResult().setText(integrationResult.toString()));
                    timer.setRepeats(false);
                    timer.start();
                } else {
                    view.getTextAreaResult().setText(integrationResult.toString());
                }
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
    class DifferentiateP1Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                if(ViewMain.isStonkMode()) {
                    view.buttonClickGif();
                    ViewMain.playSound("hitButton.wav", 500);
                }
                Operation operations = new Operation();
                if(view.getTextAreaPoly1().getText().isEmpty()) {
                    throw new NullInputException("Empty input text");
                }
                Polynomial p1 = operations.readPolynomial(view.getTextAreaPoly1().getText());

                Polynomial differentiationResult = operations.differentiatePolynomial(p1);

                if(ViewMain.isStonkMode()) {
                    Timer timer = new Timer(500, f -> view.getTextAreaResult().setText(differentiationResult.toString()));
                    timer.setRepeats(false);
                    timer.start();
                } else {
                    view.getTextAreaResult().setText(differentiationResult.toString());
                }

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
    class DifferentiateP2Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                if(ViewMain.isStonkMode()) {
                    view.buttonClickGif();
                    ViewMain.playSound("hitButton.wav", 500);
                }
                Operation operations = new Operation();
                if(view.getTextAreaPoly1().getText().isEmpty()) {
                    throw new NullInputException("Empty input text");
                }
                Polynomial p2 = operations.readPolynomial(view.getTextAreaPoly2().getText());

                Polynomial differentiationResult = operations.differentiatePolynomial(p2);

                if(ViewMain.isStonkMode()) {
                    Timer timer = new Timer(500, f -> view.getTextAreaResult().setText(differentiationResult.toString()));
                    timer.setRepeats(false);
                    timer.start();
                } else {
                    view.getTextAreaResult().setText(differentiationResult.toString());
                }
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
}
