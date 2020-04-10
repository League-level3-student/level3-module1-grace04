package _03_IntroToStacks;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Stack;

import org.junit.Test;

public class _03_TestMatchingBrackets {

	@Test
	public void testMatchingBrackets() {
		assertTrue(doBracketsMatch("{}"));
		assertTrue(doBracketsMatch("{{}}"));
		assertTrue(doBracketsMatch("{}{}{{}}"));
		assertFalse(doBracketsMatch("{{}"));
		assertFalse(doBracketsMatch("}{"));
	}

	// USE A STACK TO COMPLETE THE METHOD FOR CHECKING IF EVERY OPENING BRACKET HAS A MATCHING CLOSING BRACKET
	private boolean doBracketsMatch(String b) {
		Stack<String> opening = new Stack<String>();
		Stack<String> closing = new Stack<String>();
		ArrayList<String> stri = new ArrayList<String>();
		for(int i=0;i<b.length();i++) {
			stri.add(b.substring(i, i+1));
			if(stri.get(i).equals("{")) {
				opening.push("{");
				System.out.println(opening);
			}
			if(stri.get(i).equals("}")) {
				closing.push("}");
				System.out.println(closing);
			}
		}
		if(b.substring(0, 1).equals("}")) {
			return false;
		}
		if(opening.size()==closing.size()) {
			return true;
		}
		return false;
	}
}