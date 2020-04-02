package _03_IntroToStacks;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {
	/* 
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character is erased from the JLabel.
	 * Save that deleted character onto a Stack of Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed, the top Character is popped 
	 * off the Stack and added back to the JLabel.
	 * 
	 * */
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	String lab;
	String last;
	Stack<String> typed = new Stack<String>();
	Stack<String> deleted = new Stack<String>();
	
	public static void main(String[] args) {
		_02_TextUndoRedo tur = new _02_TextUndoRedo();
		tur.doStuff();
	}
	
	public void doStuff() {
		frame.add(panel);
		panel.add(label);
		frame.addKeyListener(this);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		lab = "";
		if (e.getKeyCode()==KeyEvent.VK_BACK_SPACE) {
			last = typed.pop();
			deleted.push(last);
		}
		else if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
			last = deleted.pop();
			typed.push(last);
			last = "";
		}
		else {
			typed.push(""+e.getKeyChar());
			System.out.println(e.getKeyChar());
		}
		for (String s:typed) {
			lab += s;
		}
		label.setText(lab);
		frame.pack();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
