package _04_HangMan;

import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class HangMan{
	int lives;
	int words;
	String ans;
	Stack<String> playWords = new Stack<String>();
	
	public static void main(String[] args) {
		
	}
	
	public void run() {
		JFrame frame = new JFrame();
		JLabel lab1 = new JLabel();
		JLabel lab2 = new JLabel();
		frame.add(lab1);
		frame.add(lab2);
		frame.setSize(200, 150);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	
	public void doStuff() {
		ans = JOptionPane.showInputDialog("How many words?");
		words = Integer.parseInt(ans);
		playWords.push(readRandomLineFromFile("dictionary.txt"))
	}
}