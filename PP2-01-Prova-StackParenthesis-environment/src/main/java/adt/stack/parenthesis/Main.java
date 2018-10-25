package adt.stack.parenthesis;

public class Main {

	public static void main(String[] args) {
		
		LongestValidParenthesisSubstringImpl stack = new LongestValidParenthesisSubstringImpl();
		
		System.out.println(stack.findLongest("()()((((("));

	}

}
