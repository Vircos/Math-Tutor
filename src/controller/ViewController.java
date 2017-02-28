// Marcos Brenes

package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ListIterator;
import java.util.Stack;

import javax.swing.AbstractListModel;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Level;
import model.Operator;
import model.Problem;
import view.MathTutorFrame;

public class ViewController {

	private MathTutorFrame tutorFrame;
	private JComboBox<Level> cmbDifficulty;
	private JComboBox<Operator> cmbOperator;
	private JLabel lblRightWrong, lblProblem;
	private JButton btnEnterAnswer, btnNextQuestion;
	private JList<String> listHistory;
	private JPanel panelCheck;
	private JTextField textbox;
	private Problem currentProblem;
	
	private Stack<Problem> problemsStack;
	private DefaultListModel<String> listModel;

	@SuppressWarnings("serial")
	public ViewController(JFrame frame) {
		tutorFrame = (MathTutorFrame) frame;
		setUpProperties();
		problemsStack = new Stack<Problem>();

		// hide panel which indicates if answer is correct or not
		panelCheck.setVisible(false);
		cmbDifficulty.setModel(new DefaultComboBoxModel<>(Level.values()));
		cmbOperator.setModel(new DefaultComboBoxModel<>(Operator.values()));
		textbox.setText(null);

		QuestoinChangedListener cmbListener = new QuestoinChangedListener();
		cmbDifficulty.addActionListener(cmbListener);
		cmbOperator.addActionListener(cmbListener);

		btnEnterAnswer.addActionListener(new EnterButtonListener());
		btnEnterAnswer.setEnabled(false);

		btnNextQuestion.addActionListener(new NextQuestionButtonListener());
		
		updateJList();
		
		tutorFrame.setVisible(true);
	}
	
	private void updateJList() {
		listModel = new DefaultListModel<String>();
		ListIterator<Problem> iterator = problemsStack.listIterator();
		while (iterator.hasNext()) {
			listModel.addElement(iterator.next().toString());
		}
		listHistory.setModel(listModel);
	}

	private void setUpProperties() {
		cmbDifficulty = tutorFrame.cmbDifficulty;
		cmbOperator = tutorFrame.cmbOperator;
		lblRightWrong = tutorFrame.lblRightWrong;
		lblProblem = tutorFrame.lblProblem;
		btnEnterAnswer = tutorFrame.btnEnterAnswer;
		btnNextQuestion = tutorFrame.btnNextQuestion;
		listHistory = tutorFrame.listHistory;
		panelCheck = tutorFrame.panelCheck;
		textbox = tutorFrame.txtAnswer;
	}

	private void generateNewProblem() {
		Level level = (Level) cmbDifficulty.getSelectedItem();
		Operator operator = (Operator) cmbOperator.getSelectedItem();
		currentProblem = new Problem(level, operator);
		lblProblem.setText(currentProblem.getProblemQuestion());
	}

	private class EnterButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String textBoxAnswer = textbox.getText();
			boolean correct = false;
			if (!textBoxAnswer.equals("")) {
				try {
					correct = currentProblem.checkAnswer(textBoxAnswer);
					if (correct) {
						lblRightWrong.setText("Correct! Your Answer: " + currentProblem.getUserAnswer());
						lblRightWrong.setForeground(Color.GREEN);
					} else {
						lblRightWrong.setText("<html>Incorrect, Your Answer: " + currentProblem.getUserAnswer()
								+ "<br>Correct Answer: " + currentProblem.getCorrectAnswer() + "</html>");
						lblRightWrong.setForeground(Color.RED);
					}

					panelCheck.setVisible(true);
					btnEnterAnswer.setEnabled(false);
					problemsStack.push(currentProblem);
					updateJList();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(tutorFrame,
						    "Please enter integer or #.## format!",
						    "Input Error",
						    JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

	private class NextQuestionButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (!btnEnterAnswer.isEnabled())
				btnEnterAnswer.setEnabled(true);
			generateNewProblem();
			panelCheck.setVisible(false);
			textbox.setText("");

		}
	}

	private class QuestoinChangedListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			generateNewProblem();
			textbox.setText("");
			if (!btnEnterAnswer.isEnabled())
				btnEnterAnswer.setEnabled(true);
			if (panelCheck.isVisible())
				panelCheck.setVisible(false);

		}
	}

}
