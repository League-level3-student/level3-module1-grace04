 package _04_HangMan;

import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class HangMan{
	int lives;
	int words;
	String ans;
	char an;
	String curr;
	int done;
	int choi;
	ArrayList<Character> wor = new ArrayList<Character>();
	Stack<String> playWords = new Stack<String>();
	Utilities uti = new Utilities();
	
	JFrame frame = new JFrame();
	JFrame scoreboard = new JFrame();
	JLabel lab = new JLabel();
	JLabel score = new JLabel();
	
	public static void main(String[] args) {
		HangMan hm = new HangMan();
		hm.run();
	}
	
	public void run() {
		frame.add(lab);
		lab.setText("");
		frame.setSize(200, 150);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		scoreboard.add(score);
		scoreboard.setVisible(true);
		scoreboard.pack();
		makeWords();
	}
	
	public void makeWords() {
		playWords.clear();
		ans = JOptionPane.showInputDialog("How many words?");
		words = Integer.parseInt(ans);
		int i = 0;
		while(i<words) {
			playWords.push(uti.readRandomLineFromFile("dictionary.txt"));
			i++;
		}
		lives = 10;
		done = 0;
		start();
	}
	
	public void start() {
		lab.setText("");
		wor.clear();
		curr = playWords.pop();
		for(int i=0;i<curr.length();i++) {
			lab.setText(lab.getText() + "-");
			wor.add(curr.charAt(i));
		}
		play();
	}
	
	public void play() {
		while(lives>0) {
			if(!(lab.getText().contains("-"))) {
				done++;
				if(done>=words) {
					dead();
				}
				else {
					start();
				}
			}
			ans = JOptionPane.showInputDialog("Guess a character");
			an = ans.charAt(0);
			for(int i=0;i<curr.length();i++) {
				if(an==wor.get(i)) {
					lab.setText(lab.getText().substring(0, i) + an + lab.getText().substring(i+1,lab.getText().length()));
				}
			}
			if(wor.contains(an)==false) {
				lives--;
				score.setText(" Lives: " + lives);
				scoreboard.pack();
			}
		}
		lab.setText(curr);
		dead();
	}
	
	public void dead() {
		JOptionPane.showMessageDialog(null, "Game Over");
		choi = JOptionPane.showConfirmDialog(null, "Play again?");
		if(choi==0) {
			run();
		}
		else {
			System.exit(0);
		}
	}
}