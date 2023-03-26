package views;

import javax.swing.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ViewMain extends JFrame {
	private JFrame frame = new JFrame();
	private JLabel labelTitle = new JLabel("Polynomial Calculator");
	private JLabel labelDescription0 = new JLabel("Input syntax: ax^n+bx^n-1+...+px^1+qx^0");
	private JLabel labelDescription1 = new JLabel("-coefficients are real numbers");
	private JLabel labelPoly1 = new JLabel("Polynomial 1:");
	private JLabel labelPoly2 = new JLabel("Polynomial 2:");
	private JTextField textAreaPoly1 = new JTextField();
	private JTextField textAreaPoly2 = new JTextField();
	private JLabel labelDescription2 = new JLabel("-exponents are positive integers");
	private JLabel labelResultText = new JLabel("");
	private JLabel labelResult = new JLabel("Result:");
	private JLabel labelDescription3 = new JLabel("-exponents can be in any order");
	private JButton buttonAddition = new JButton("Add");
	private JButton buttonSubtraction = new JButton("Subtract");

	private JButton buttonClearP1 = new JButton("Clear");
	private JButton buttonClearP2 = new JButton("Clear");
	private JButton buttonMultiplication = new JButton("Multiply");
	private JButton buttonDivision = new JButton("Divide");
	private JButton buttonIntegrateP1 = new JButton("Integrate P1");
	private JLabel labelOperationDescription = new JLabel("Syntax: P1 <op> P2");
	private JButton buttonDifferentiateP1 = new JButton("Differentiate P1");
	private JButton buttonSwapOrder = new JButton("Swap order");
	private JButton buttonIntegrateP2 = new JButton("Integrate P2");
	private JButton buttonDifferentiateP2 = new JButton("Differentiate P2");

	public ViewMain() {
		frame.setTitle("Polynomial Calculator");
		frame.setBounds(100, 100, 900, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(labelTitle);
		frame.getContentPane().add(labelDescription0);
		frame.getContentPane().add(labelDescription1);
		frame.getContentPane().add(labelPoly1);
		frame.getContentPane().add(textAreaPoly1);
		frame.getContentPane().add(labelPoly2);
		frame.getContentPane().add(textAreaPoly2);
		frame.getContentPane().add(labelDescription2);
		frame.getContentPane().add(labelResultText);
		frame.getContentPane().add(labelResult);
		frame.getContentPane().add(labelDescription3);
		frame.getContentPane().add(buttonAddition);
		frame.getContentPane().add(buttonSubtraction);
		frame.getContentPane().add(buttonMultiplication);
		frame.getContentPane().add(buttonDivision);
		frame.getContentPane().add(buttonIntegrateP1);
		frame.getContentPane().add(labelOperationDescription);
		frame.getContentPane().add(buttonDifferentiateP1);
		frame.getContentPane().add(buttonSwapOrder);
		frame.getContentPane().add(buttonIntegrateP2);
		frame.getContentPane().add(buttonDifferentiateP2);
		frame.getContentPane().add(buttonClearP1);
		frame.getContentPane().add(buttonClearP2);

		labelTitle.setBounds(40, 33, 436, 51);
		labelTitle.setFont(new Font("Vivaldi", Font.BOLD, 50));
		labelTitle.setHorizontalAlignment(SwingConstants.CENTER);

		labelDescription0.setBounds(517, 11, 289, 15);
		labelDescription0.setHorizontalAlignment(SwingConstants.LEFT);
		labelDescription0.setFont(new Font("Tahoma", Font.PLAIN, 12));

		labelDescription1.setBounds(517, 36, 279, 15);
		labelDescription1.setHorizontalAlignment(SwingConstants.LEFT);
		labelDescription1.setFont(new Font("Tahoma", Font.PLAIN, 12));

		labelPoly1.setBounds(0, 132, 195, 51);
		labelPoly1.setHorizontalAlignment(SwingConstants.CENTER);
		labelPoly1.setFont(new Font("Tahoma", Font.BOLD, 20));

		textAreaPoly1.setBounds(205, 132, 558, 51);
		textAreaPoly1.setFont(new Font("Tahoma", Font.PLAIN, 20));

		buttonClearP1.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonClearP1.setBounds(761, 132, 75, 50);

		labelPoly2.setBounds(0, 188, 195, 56);
		labelPoly2.setHorizontalAlignment(SwingConstants.CENTER);
		labelPoly2.setFont(new Font("Tahoma", Font.BOLD, 20));

		textAreaPoly2.setBounds(205, 188, 558, 56);
		textAreaPoly2.setFont(new Font("Tahoma", Font.PLAIN, 20));

		buttonClearP2.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonClearP2.setBounds(761, 188, 75, 55);

		labelDescription2.setHorizontalAlignment(SwingConstants.LEFT);
		labelDescription2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelDescription2.setBounds(517, 61, 279, 15);

		labelResultText.setBounds(205, 266, 633, 56);
		labelResultText.setFont(new Font("Tahoma", Font.PLAIN, 20));

		labelResult.setHorizontalAlignment(SwingConstants.CENTER);
		labelResult.setFont(new Font("Tahoma", Font.BOLD, 20));
		labelResult.setBounds(40, 266, 122, 44);

		labelDescription3.setHorizontalAlignment(SwingConstants.LEFT);
		labelDescription3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelDescription3.setBounds(517, 86, 279, 15);

		buttonAddition.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonAddition.setBounds(20, 342, 139, 51);

		buttonSubtraction.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonSubtraction.setBounds(169, 342, 139, 51);

		buttonMultiplication.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonMultiplication.setBounds(20, 397, 139, 51);

		buttonDivision.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonDivision.setBounds(169, 397, 139, 51);

		buttonIntegrateP1.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonIntegrateP1.setBounds(476, 342, 139, 51);

		labelOperationDescription.setHorizontalAlignment(SwingConstants.LEFT);
		labelOperationDescription.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelOperationDescription.setBounds(29, 315, 139, 15);

		buttonDifferentiateP1.setFont(new Font("Tahoma", Font.BOLD, 13));
		buttonDifferentiateP1.setBounds(646, 342, 139, 51);

		buttonSwapOrder.setFont(new Font("Tahoma", Font.BOLD, 10));
		buttonSwapOrder.setBounds(733, 86, 105, 36);

		buttonIntegrateP2.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonIntegrateP2.setBounds(476, 397, 139, 51);

		buttonDifferentiateP2.setFont(new Font("Tahoma", Font.BOLD, 13));
		buttonDifferentiateP2.setBounds(646, 397, 139, 51);

		frame.setVisible(true);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JLabel getLabelTitle() {
		return labelTitle;
	}

	public void setLabelTitle(JLabel labelTitle) {
		this.labelTitle = labelTitle;
	}

	public JLabel getLabelDescription0() {
		return labelDescription0;
	}

	public void setLabelDescription0(JLabel labelDescription0) {
		this.labelDescription0 = labelDescription0;
	}

	public JLabel getLabelDescription1() {
		return labelDescription1;
	}

	public void setLabelDescription1(JLabel labelDescription1) {
		this.labelDescription1 = labelDescription1;
	}

	public JLabel getLabelPoly1() {
		return labelPoly1;
	}

	public void setLabelPoly1(JLabel labelPoly1) {
		this.labelPoly1 = labelPoly1;
	}

	public JLabel getLabelPoly2() {
		return labelPoly2;
	}

	public void setLabelPoly2(JLabel labelPoly2) {
		this.labelPoly2 = labelPoly2;
	}

	public JTextField getTextAreaPoly1() {
		return textAreaPoly1;
	}

	public void setTextAreaPoly1(JTextField textAreaPoly1) {
		this.textAreaPoly1 = textAreaPoly1;
	}

	public JTextField getTextAreaPoly2() {
		return textAreaPoly2;
	}

	public void setTextAreaPoly2(JTextField textAreaPoly2) {
		this.textAreaPoly2 = textAreaPoly2;
	}

	public JLabel getLabelDescription2() {
		return labelDescription2;
	}

	public void setLabelDescription2(JLabel labelDescription2) {
		this.labelDescription2 = labelDescription2;
	}

	public JLabel getTextAreaResult() {
		return labelResultText;
	}

	public void setTextAreaResult(JLabel labelResultText) {
		this.labelResultText = labelResultText;
	}

	public JLabel getLabelResult() {
		return labelResult;
	}

	public void setLabelResult(JLabel labelResult) {
		this.labelResult = labelResult;
	}

	public JLabel getLabelDescription3() {
		return labelDescription3;
	}

	public void setLabelDescription3(JLabel labelDescription3) {
		this.labelDescription3 = labelDescription3;
	}

	public JButton getButtonAddition() {
		return buttonAddition;
	}

	public void setButtonAddition(JButton buttonAddition) {
		this.buttonAddition = buttonAddition;
	}

	public JButton getButtonSubtraction() {
		return buttonSubtraction;
	}

	public void setButtonSubtraction(JButton buttonSubtraction) {
		this.buttonSubtraction = buttonSubtraction;
	}

	public JLabel getLabelResultText() {
		return labelResultText;
	}

	public void setLabelResultText(JLabel labelResultText) {
		this.labelResultText = labelResultText;
	}

	public JButton getButtonClearP1() {
		return buttonClearP1;
	}

	public void setButtonClearP1(JButton buttonClearP1) {
		this.buttonClearP1 = buttonClearP1;
	}

	public JButton getButtonClearP2() {
		return buttonClearP2;
	}

	public void setButtonClearP2(JButton buttonClearP2) {
		this.buttonClearP2 = buttonClearP2;
	}

	public JButton getButtonIntegrateP1() {
		return buttonIntegrateP1;
	}

	public void setButtonIntegrateP1(JButton buttonIntegrateP1) {
		this.buttonIntegrateP1 = buttonIntegrateP1;
	}

	public JButton getButtonMultiplication() {
		return buttonMultiplication;
	}

	public void setButtonMultiplication(JButton buttonMultiplication) {
		this.buttonMultiplication = buttonMultiplication;
	}

	public JButton getButtonDivision() {
		return buttonDivision;
	}

	public void setButtonDivision(JButton buttonDivision) {
		this.buttonDivision = buttonDivision;
	}

	public JButton getButtonIntegrationP1() {
		return buttonIntegrateP1;
	}

	public void setButtonIntegrationP1(JButton buttonIntegrationP1) {
		this.buttonIntegrateP1 = buttonIntegrationP1;
	}

	public JLabel getLabelOperationDescription() {
		return labelOperationDescription;
	}

	public void setLabelOperationDescription(JLabel labelOperationDescription) {
		this.labelOperationDescription = labelOperationDescription;
	}

	public JButton getButtonDifferentiateP1() {
		return buttonDifferentiateP1;
	}

	public void setButtonDifferentiateP1(JButton buttonDifferentiateP1) {
		this.buttonDifferentiateP1 = buttonDifferentiateP1;
	}

	public JButton getButtonSwapOrder() {
		return buttonSwapOrder;
	}

	public void setButtonSwapOrder(JButton buttonSwapOrder) {
		this.buttonSwapOrder = buttonSwapOrder;
	}

	public JButton getButtonIntegrateP2() {
		return buttonIntegrateP2;
	}

	public void setButtonIntegrateP2(JButton buttonIntegrateP2) {
		this.buttonIntegrateP2 = buttonIntegrateP2;
	}

	public JButton getButtonDifferentiateP2() {
		return buttonDifferentiateP2;
	}

	public void setButtonDifferentiateP2(JButton buttonDifferentiateP2) {
		this.buttonDifferentiateP2 = buttonDifferentiateP2;
	}

	public void addSwapOrderListener(ActionListener actionListener) {
		buttonSwapOrder.addActionListener(actionListener);
	}

	public void addClearP1Listener(ActionListener actionListener) {
		buttonClearP1.addActionListener(actionListener);
	}

	public void addClearP2Listener(ActionListener actionListener) {
		buttonClearP2.addActionListener(actionListener);
	}

	public void addAdditionListener(ActionListener actionListener) {
		buttonAddition.addActionListener(actionListener);
	}

	public void addSubtractionListener(ActionListener actionListener) {
		buttonSubtraction.addActionListener(actionListener);
	}

	public void addDivisionListener(ActionListener actionListener) {
		buttonDivision.addActionListener(actionListener);
	}

	public void addMultiplicationListener(ActionListener actionListener) {
		buttonMultiplication.addActionListener(actionListener);
	}

	public void addIntegrateP1Listener(ActionListener actionListener) {
		buttonIntegrateP1.addActionListener(actionListener);
	}

	public void addIntegrateP2Listener(ActionListener actionListener) {
		buttonIntegrateP2.addActionListener(actionListener);
	}

	public void addDifferentiateP1Listener(ActionListener actionListener) {
		buttonDifferentiateP1.addActionListener(actionListener);
	}

	public void addDifferentiateP2Listener(ActionListener actionListener) {
		buttonDifferentiateP2.addActionListener(actionListener);
	}
	public void refresh() {

	}

	public void showErrorMessage(String message) {
		JOptionPane.showMessageDialog(this, message, "ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
		refresh();
	}
	public void showMessage(String message) {
		JOptionPane.showMessageDialog(this, message, "",JOptionPane.INFORMATION_MESSAGE);
		refresh();
	}
}
