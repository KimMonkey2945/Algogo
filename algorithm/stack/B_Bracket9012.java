package algorithm.stack;

import java.util.Scanner;
import java.util.Stack;

public class B_Bracket9012 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());

		for (int i = 0; i < n; i++) {
			System.out.println(vps(sc.next()));	
		}

	}
	
	static String vps(String bracket) {
		Stack<Character> st = new Stack<>();
		for(int i = 0; i < bracket.length(); i++) {
			char a = bracket.charAt(i);
			if(a == '(') {
				st.push(a);
			}else if (st.isEmpty()) {
				return "NO";
			}else {
				st.pop();
			}
		}
		
		if(st.isEmpty()) {
			return "YES";
		}else {
			return "NO";
		}
	}
}
