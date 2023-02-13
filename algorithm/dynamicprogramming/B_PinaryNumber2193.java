package algorithm.dynamicprogramming;
import java.util.Scanner;

public class B_PinaryNumber2193 {
	// bottop-up
	// �ܼ��� 1���� �����ؼ� ��ȭ���� �����س���
	// 1 -> 1, 2 -> 1, 3 -> 2, 4 -> 3, 5 -> 5, 6 -> 8...
	// n = (n-2) + (n-1) �̶�� ��ȭ�� ����
	// ��, n�� ������ 90�����̹Ƿ� int���� ���� �� �� �ִ�.
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