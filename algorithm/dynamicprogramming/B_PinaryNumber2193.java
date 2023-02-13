package algorithm.dynamicprogramming;
import java.util.Scanner;

public class B_PinaryNumber2193 {
	// bottop-up
	// 단순히 1부터 시작해서 점화식을 도출해냈음
	// 1 -> 1, 2 -> 1, 3 -> 2, 4 -> 3, 5 -> 5, 6 -> 8...
	// n = (n-2) + (n-1) 이라는 점화식 도출
	// 단, n의 범위가 90까지이므로 int값을 벗어 날 수 있다.
	static long[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		dp = new long[N + 1];
		System.out.println(pinarynumber(N));
		

	}
	
	public static long pinarynumber(int N) {
		dp[0] = 0;
		dp[1] = 1;
		
		for(int i = 2; i <= N; i++) {
			dp[i] = dp[i - 2] + dp[i - 1];
		}
		
		return dp[N];
	}

}