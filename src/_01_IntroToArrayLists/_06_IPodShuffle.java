package _01_IntroToArrayLists;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;


//Copyright The League of Amazing Programmers, 2015

public class _06_IPodShuffle implements MouseListener{
	
	Song so;
    ArrayList<Song> soli = new ArrayList<Song>();
	Random gen = new Random();
	int x;
	
	public _06_IPodShuffle() {
		// 1. Use the Song class the play the demo.mp3 file.

		/**
		 * 2. Congratulations on completing the sound check! * Now we want to make an
		 * iPod Shuffle that plays random music. * Create an ArrayList of Songs and a
		 * "Surprise Me!" button that will play a random song when it is clicked. * If
		 * you're really cool, you can stop all the songs, before playing a new one on
		 * subsequent button clicks.
		 */
		         
		addSong("demo.mp3");
		
		frame.add(panel);
		panel.add(b1);
		panel.add(b2);
		b1.addMouseListener(this);
		b2.addMouseListener(this);
		b1.setText("Surprise Me!");
		b2.setText("Stop!");
		
		frame.setVisible(true);
		frame.pack();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	}
	
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JButton b1 = new JButton();
		JButton b2 = new JButton();
		
	public static void main(String[] args) {
		new _06_IPodShuffle();
	}

	public void addSong(String string) {
		Song song = new Song(string);
		soli.add(song);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(b1)) {
			x = gen.nextInt(soli.size());
			so = soli.get(x);
			so.play();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}