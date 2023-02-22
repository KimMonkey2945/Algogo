package algorithm.stack;

import java.util.Scanner;
import java.util.Stack;

public class B_PostfixNotation1918 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String caculation = sc.next();
		
		StringBuffer sb = new StringBuffer();
		Stack<Character> st = new Stack<>();
		
		
		for(int i = 0; i < caculation.length(); i++) {
			char a = caculation.charAt(i);
			if(a >= 'A' && a <= 'Z') {
				sb.append(a);
			}else if(a == '(') {
				st.push(a);
			}else if(a == ')') {
				while(!st.isEmpty()) {
					if(st.peek() == '(') {
						st.pop();
						break;
					}
					sb.append(st.pop());
				}
			}else {
				while(!st.isEmpty() && priority(st.peek()) >= priority(a)) {
					sb.append(st.pop());
				}
				st.push(a);
			}
		}
		
		while(!st.isEmpty()) {
			sb.append(st.pop());
		}
		
		System.out.println(sb);

	}

	static int priority(char a) {
		
		if(a == '(') return 0;
		if(a == '+' || a == '-') return 1;
		else return 2;
			
	}

}
