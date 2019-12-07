package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_GuestBook implements ActionListener{
	// Create a GUI with two buttons. One button reads "Add Name" and the other button reads "View Names". 
	// When the add name button is clicked, display an input dialog that asks the user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked, display a message dialog that displays
	// all the names added to the list. Format the list as follows:
	// Guest #1: Bob Banders
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton ad = new JButton();
	JButton vi = new JButton();
	
	public static void main(String[] args) {
		_02_GuestBook gb = new _02_GuestBook();
		gb.run();
	}
	
	public void run() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		panel.add(ad);
		ad.setText("Add Name");
		ad.addActionListener(this);
		panel.add(vi);
		vi.setText("View Names");
		vi.addActionListener(this);
		frame.pack();
	}

	ArrayList<String> names = new ArrayList<String>();
	
	public void add() {
		String ans = JOptionPane.showInputDialog("Input name below:");
		names.add(ans);
	}
	
	public void view() {
		for(int i = 0; i < names.size(); i++){
			String s = names.get(i);
			System.out.println("Guest #" + i + ": " + s);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton buttonPressed = (JButton) e.getSource();
		if (buttonPressed.equals(ad)) {
			add();
		}
		else if (buttonPressed.equals(vi)) {
			view();
		}
	}
	
}
