package algorithm.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B_2841 {
	
	static int N, P, answer;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		
		Stack<Integer>[] stack = new Stack[7];
		for(int i = 1; i < 7; i++) {
			stack[i] = new Stack<Integer>();
		}
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int line = Integer.parseInt(st.nextToken());
			int fret = Integer.parseInt(st.nextToken());
			
			while(!stack[line].isEmpty()) {
				if(stack[line].peek() > fret) {
					stack[line].pop();
				}else if(stack[line].peek() < fret) {
					stack[line].push(fret);
				}else {
					break;
				}
				
				answer += 1;
			}
			
			if(stack[line].isEmpty()) {
				stack[line].push(fret);
				answer += 1;
			}
		}
		
		
		System.out.println(answer);
	
	}

}
