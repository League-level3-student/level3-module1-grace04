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
	JButton but = new JButton();
	String lab = "";
	String last;
	String undid;
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
		frame.setSize(200,100);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		char kp = (char) e.getKeyChar();
		int kc = (int) e.getKeyCode();
		lab = "" + kp;
		label.setText(label.getText()+lab);
		if(kc==8) {
			last = label.getText().substring(label.getText().length()-1);
			deleted.push(last);
			System.out.println(last);
			System.out.println(deleted);
			label.setText(label.getText().substring(0, label.getText().length()-2));
		}
		if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
			undid = deleted.pop();
			System.out.println(undid);
			label.setText(label.getText()+undid);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
