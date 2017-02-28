// Marcos Brenes

package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import model.Level;
import model.Operator;
import model.Problem;

import javax.swing.JList;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JScrollPane;

public class MathTutorFrame extends JFrame{
	public JTextField txtAnswer;
	public JComboBox<Level> cmbDifficulty;
	public JComboBox<Operator> cmbOperator;
	public JButton btnEnterAnswer;
	public JPanel panelCheck;
	public JLabel lblRightWrong;
	public JButton btnNextQuestion;
	public JLabel lblProblem;
	public JList<String> listHistory;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	
	public MathTutorFrame() {
		getContentPane().setBackground(SystemColor.info);
		setResizable(false);
		setTitle("Math Tutor");
		
		JLabel lblDifficulty = new JLabel("Difficulty");
		lblDifficulty.setHorizontalAlignment(SwingConstants.CENTER);
		lblDifficulty.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		cmbDifficulty = new JComboBox();
		cmbDifficulty.setBackground(Color.WHITE);
		cmbDifficulty.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblOperator = new JLabel("Operator");
		lblOperator.setHorizontalAlignment(SwingConstants.CENTER);
		lblOperator.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		cmbOperator = new JComboBox();
		cmbOperator.setBackground(Color.WHITE);
		cmbOperator.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblHistory = new JLabel("History");
		lblHistory.setHorizontalAlignment(SwingConstants.CENTER);
		lblHistory.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblSolveThisProblem = new JLabel("Solve This Problem");
		lblSolveThisProblem.setHorizontalAlignment(SwingConstants.CENTER);
		lblSolveThisProblem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		
		txtAnswer = new JTextField();
		txtAnswer.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtAnswer.setHorizontalAlignment(SwingConstants.CENTER);
		txtAnswer.setColumns(10);
		
		btnEnterAnswer = new JButton("Enter");
		btnEnterAnswer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		panelCheck = new JPanel();
		panelCheck.setBackground(SystemColor.info);
		
		lblNewLabel = new JLabel("Answer:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		lblNewLabel_1 = new JLabel("2 decimal places max");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDifficulty)
								.addComponent(cmbDifficulty, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblOperator)
								.addComponent(cmbOperator, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)))
						.addComponent(panelCheck, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(panel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(btnEnterAnswer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(txtAnswer, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))))
						.addComponent(lblSolveThisProblem, GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblHistory, GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(14)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDifficulty)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblOperator, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblHistory)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 388, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(cmbOperator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(cmbDifficulty, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblSolveThisProblem)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(txtAnswer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(11)
									.addComponent(btnEnterAnswer))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_1)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panelCheck, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)))
					.addContainerGap())
		);
		
		listHistory = new JList();
		scrollPane.setViewportView(listHistory);
		
		lblRightWrong = new JLabel("Right/Wrong");
		lblRightWrong.setHorizontalAlignment(SwingConstants.CENTER);
		lblRightWrong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		btnNextQuestion = new JButton("Next Question");
		btnNextQuestion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_panelCheck = new GroupLayout(panelCheck);
		gl_panelCheck.setHorizontalGroup(
			gl_panelCheck.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelCheck.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelCheck.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblRightWrong, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
						.addComponent(btnNextQuestion, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelCheck.setVerticalGroup(
			gl_panelCheck.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelCheck.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblRightWrong, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
					.addComponent(btnNextQuestion))
		);
		panelCheck.setLayout(gl_panelCheck);
		
		lblProblem = new JLabel("Problem");
		lblProblem.setHorizontalAlignment(SwingConstants.CENTER);
		lblProblem.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblProblem, GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addGap(5)
					.addComponent(lblProblem, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
	}
}
