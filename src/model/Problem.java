// Marcos Brenes

package model;

import java.util.Random;

public class Problem {
	
	private Level level;
	private Operator operator;
	private Random randomizer;
	private int op1, op2;
	private boolean correct = false;
	double answer;
	private String userAnswer, correctAnswer;
	
	public Problem(Level level, Operator operator) {
		this.level = level;
		this.operator = operator;
		createProblem();
	}
	
	
	public boolean checkAnswer(String ans) throws Exception {
		correctAnswer = String.format("%.2f", answer);
		userAnswer = null;
		try {
			userAnswer = String.format("%.2f", Double.valueOf(ans).doubleValue()); 
		} catch (Exception e) {
			throw e;
		}
		return correct = correctAnswer.equals(userAnswer);
	}
	
	public String getProblemQuestion() {
		StringBuilder sb = new StringBuilder();
		sb.append(op1);
		
		switch (operator) {
		case ADDITION	: sb.append(" + "); break;
		case SUBTRACTION: sb.append(" - "); break;
		case MULTIPLICATION : sb.append(" * "); break;
		case DIVISION	: sb.append(" / "); break;
		}
		
		sb.append(op2);
		sb.append(" = ");
		
		return sb.toString();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(op1);
		
		switch (operator) {
		case ADDITION	: sb.append(" + "); break;
		case SUBTRACTION: sb.append(" - "); break;
		case MULTIPLICATION : sb.append(" * "); break;
		case DIVISION	: sb.append(" / "); break;
		}
		
		sb.append(op2);
		sb.append(" = ");
		sb.append(String.format("%.2f", answer));
		sb.append(" ");
		sb.append(correct ? " Correct!" : " Wrong");
		
		switch (level) {
		case EASY		: sb.append(" EASY"); break;
		case MODERATE	: sb.append(" MODERATE"); break;
		case DIFFICULT	: sb.append(" DIFFICULT"); break;
		}
		return sb.toString();
	}
	
	private void createProblem() {
		randomizer = new Random();
		switch (operator) {
		case ADDITION 		: createAddition(); break;
		case SUBTRACTION	: createSubtraction(); break;
		case MULTIPLICATION	: createMultiplication(); break;
		case DIVISION		: createDivision(); break;
		}
	}
	
	private void createAddition() {
		switch (level) {
		case EASY:
			op1 = randomizer.nextInt(50) + 1;
			op2 = randomizer.nextInt(50) + 1;
			break;
		case MODERATE:
			op1 = randomizer.nextInt(91) + 10;
			op2 = randomizer.nextInt(91) + 10;
			break;
		case DIFFICULT:
			op1 = randomizer.nextInt(901) + 100;
			op2 = randomizer.nextInt(901) + 100;
		}
		
		// generate answer
		answer = op1 + op2;
	}
	
	private void createSubtraction() {
		int x, y;
		
		switch (level) {
		case EASY:
			x = randomizer.nextInt(50) + 1;
			y = randomizer.nextInt(50) + 1;
			break;
		case MODERATE:
			x = randomizer.nextInt(91) + 10;
			y = randomizer.nextInt(91) + 10;
			break;
		default:
			x = randomizer.nextInt(901) + 100;
			y = randomizer.nextInt(901) + 100;
		}
		
		if (x > y) {
			op1 = x;
			op2 = y;
		} else {
			op1 = y;
			op2 = x;
		}
		
		// generate answer
		answer = op1 - op2;
	}
	
	private  void createMultiplication() {
		switch (level) {
		case EASY:
			op1 = randomizer.nextInt(12) + 1;
			op2 = randomizer.nextInt(12) + 1;
			break;
		case MODERATE:
			op1 = randomizer.nextInt(41) + 10;
			op2 = randomizer.nextInt(41) + 10;
			break;
		case DIFFICULT:
			op1 = randomizer.nextInt(991) + 10;
			op2 = randomizer.nextInt(991) + 10;
		}
		answer = op1 * op2;
	}
	
	private void createDivision() {
		int x, y;
		
		switch (level) {
		case EASY:
			x = randomizer.nextInt(12) + 1;
			y = randomizer.nextInt(12) + 1;
			break;
		case MODERATE:
			x = randomizer.nextInt(41) + 10;
			y = randomizer.nextInt(41) + 10;
			break;
		default:
			x = randomizer.nextInt(991) + 10;
			y = randomizer.nextInt(991) + 10;
		}
		
		if (x > y) {
			op1 = x;
			op2 = y;
		} else {
			op1 = y;
			op2 = x;
		}
		// generate answer
		answer = op1 / (double)op2;
	}
	
	public Level getLevel() {
		return level;
	}

	public Operator getOperator() {
		return operator;
	}

	public int getOp1() {
		return op1;
	}

	public int getOp2() {
		return op2;
	}

	public double getAnswer() {
		return answer;
	}
	
	public boolean getCorrect() {
		return correct;
	}
	
	public String getUserAnswer() {
		return userAnswer;
	}
	
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	
}
