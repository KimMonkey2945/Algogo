package algorithm.stack;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B_PostfixNotation2_1935 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String postfixNotation = br.readLine();
		double[] num = new double[27];
		Stack<Double> st = new Stack<>();

		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < postfixNotation.length(); i++) {
			if (postfixNotation.charAt(i) >= 'A' && postfixNotation.charAt(i) <= 'Z') {
				st.push(num[(int)(postfixNotation.charAt(i) - 'A')]);
			} else {
				double num1 = st.pop();
				double num2 = st.pop();

				switch (postfixNotation.charAt(i)) {
				case ('+'):
					st.push(num2 + num1);
					break;
				case ('-'):
					st.push(num2 - num1);
					break;
				case ('*'):
					st.push(num2 * num1);
					break;
				case ('/'):
					st.push(num2 / num1);
					break;
				}

			}
		}
		System.out.printf("%.2f", st.pop());

	}

}
