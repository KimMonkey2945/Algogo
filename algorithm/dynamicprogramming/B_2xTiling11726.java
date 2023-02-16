package algorithm.dynamicprogramming;

import java.util.Scanner;
//2x1 타일부터 보면 피보나치 수열이 나옴.
public class B_2xTiling11726 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] dp = new int[1001];
		dp[1] = 1;
		dp[2] = 2;
		for(int i = 3; i <= N; i++) {
			dp[i] = (dp[i - 2] + dp[i - 1]) % 10007;
		}
		System.out.println(dp[N]);
	}

}
