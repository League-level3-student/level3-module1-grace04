package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
  /* 
	 * Crate a HashMap of Integers for the keys and Strings for the values.
	 * Create a GUI with three buttons. 
	 * Button 1: Add Entry
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				After an ID is entered, use another input dialog to ask the user to enter a name.
	 * 				Add this information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				If that ID exists, display that name to the user.
	 * 				Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List
	 * 				When this button is clicked, display the entire list in a message dialog in the following format:
	 * 				ID: 123  Name: Harry Howard
	 * 				ID: 245  Name: Polly Powers
	 * 				ID: 433  Name: Oliver Ortega
	 * 				etc...
	 * 
	 * When this is complete, add a fourth button to your window.
	 * Button 4: Remove Entry
	 * 				When this button is clicked, prompt the user to enter an ID using an input dialog.
	 * 				If this ID exists in the HashMap, remove it. Otherwise, notify the user that the ID
	 * 				is not in the list. 
	 *
	 * */
	
	HashMap<Integer, String> hm = new HashMap<Integer, String>();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton add = new JButton();
	JButton search = new JButton();
	JButton view = new JButton();
	JButton remove = new JButton();
	
	public static void main(String[] args) {
		_02_LogSearch ls = new _02_LogSearch();
		ls.run();
	}
	
	void run(){
		add.addActionListener(this);
		add.setText("Add Entry");
		search.addActionListener(this);
		search.setText("Search by ID");
		view.addActionListener(this);
		view.setText("View List");
		remove.addActionListener(this);
		remove.setText("Remove Entry");
		frame.add(panel);
		panel.add(add);
		panel.add(search);
		panel.add(view);
		panel.add(remove);
		frame.setVisible(true);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton buttonPressed = (JButton) e.getSource();
		if(buttonPressed.equals(add)) {
			String ans = JOptionPane.showInputDialog("Enter ID number");
			int id = Integer.parseInt(ans);
			String name = JOptionPane.showInputDialog("Enter name");
			hm.put(id, name);
		}
		if(buttonPressed.equals(search)) {
			String ans = JOptionPane.showInputDialog("Enter ID number");
			int id = Integer.parseInt(ans);
			if(hm.containsKey(id)) {
				 JOptionPane.showMessageDialog(null, "The value of the entry is " + hm.get(id));
			}
			else {
				JOptionPane.showMessageDialog(null, "The entry does not exist");
			}
		}
		if(buttonPressed.equals(view)) {
			String list = "";
			for(int key : hm.keySet()) {
				list += "\nID: " + key + "   Name: " + hm.get(key);
			}
			JOptionPane.showMessageDialog(null, list);
		}
		if(buttonPressed.equals(remove)) {
			String ans = JOptionPane.showInputDialog("Enter ID number");
			int id = Integer.parseInt(ans);
			if(hm.containsKey(id)) {
				 hm.remove(id);
			}
			else {
				JOptionPane.showMessageDialog(null, "The entry does not exist");
			}
		}
	}
}
