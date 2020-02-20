package _03_IntroToStacks;

import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

public class _01_IntroToStack {
	public static void main(String[] args) {
		//1. Create a Stack of Doubles
		//   Don't forget to import the Stack class
		Stack<Double> doub = new Stack<Double>();
		//2. Use a loop to push 100 random doubles between 0 and 100 to the Stack.
		Random gen = new Random();
		double x;
		for(int i=0;i<100;i++) {
			x = Math.random()*101;
			doub.push(x);
		}
		System.out.println(doub);
		//3. Ask the user to enter in two numbers between 0 and 100, inclusive. 
		String Ansy = JOptionPane.showInputDialog("Enter number between 0 and 100, inclusive.");
		String Ansz = JOptionPane.showInputDialog("Enter another number between 0 and 100, inclusive.");
		int y = Integer.parseInt(Ansy);
		int z = Integer.parseInt(Ansz);
		//4. Pop all the elements off of the Stack. Every time a double is popped that is
		//   between the two numbers entered by the user, print it to the screen.
		double popped;
		double less;
		double more;
		if(y<z) {
			less = y;
			more = z;
		}
		else {
			less = z;
			more = y;
		}
		System.out.println(less + " " + more);
		int amount = 0;
		for(int i=0;i<doub.size();i++) {
			popped = doub.pop();
			if(popped>less&&popped<more) {
				System.out.println(popped);
				amount++;
			}
		}
		System.out.println(amount);
		
		//   EXAMPLE:
		//   NUM 1: 65
		//   NUM 2: 75
		
		//   Popping elements off stack...
		//   Elements between 65 and 75:
		//   66.66876846
		//   74.51651681
		//   70.05110654
		//   69.21350456
		//   71.54506465
		//   66.47984807
		//   74.12121224
	}
}
