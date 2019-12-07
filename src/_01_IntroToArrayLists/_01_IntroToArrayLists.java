package _01_IntroToArrayLists;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class _01_IntroToArrayLists {
	public static void main(String[] args) {
		//1. Create an array list of Strings
		//   Don't forget to import the ArrayList class
		ArrayList<String> strgs = new ArrayList<String>();
		//2. Add five Strings to your list
		strgs.add("u");
		strgs.add("r");
		strgs.add("b");
		strgs.add("a");
		strgs.add("d");
		//3. Print all the Strings using a standard for-loop
		for (int i = 0; i<strgs.size(); i++) {
			String s = strgs.get(i);
			System.out.println(s);
		}
		System.out.println("\n");
		//4. Print all the Strings using a for-each loop
		for(String s : strgs){
			System.out.println(s);
		}
		System.out.println("\n");
		//5. Print only the even numbered elements in the list.
		for (int i = 0; i<strgs.size(); i++) {
			if (i%2 == 0) {
				String s = strgs.get(i);
				System.out.println(s);
			}
		}
		System.out.println("\n");
		//6. Print all the Strings in reverse order.
		for(int i = strgs.size() - 1; i >= 0; i--){
			String s = strgs.get(i);
			  System.out.println(s);
			}
		System.out.println("\n");
		//7. Print only the Strings that have the letter 'a' in them.
		String ans = JOptionPane.showInputDialog("Enter a letter.");
		for(String s : strgs){
			if (s.equals(ans)) {
				System.out.println(s);
			}
		}
	}
}
