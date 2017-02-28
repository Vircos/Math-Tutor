// Marcos Brenes

package controller;

import java.awt.Dimension;

import javax.swing.JFrame;

import view.MathTutorFrame;

public class Main {
	public static void main(String[] args) {
		MathTutorFrame frame = new MathTutorFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(650, 470);
		
		ViewController controller = new ViewController(frame);
	}
	
//	public static <T extends Enum<?>> T randomEnum(Class<T> clazz){
//		Random random = new Random();
//        int x = random.nextInt(clazz.getEnumConstants().length);
//        return clazz.getEnumConstants()[x];
//    }
}
