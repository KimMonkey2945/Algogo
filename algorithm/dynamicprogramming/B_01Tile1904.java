package algorithm.dynamicprogramming;

import java.util.Scanner;

public class B_01Tile1904 {
	// 1���� �����غ��� �Ǻ���ġ�������� �� �� ����.
	static int[] dp = new int[10000001];
	// 0���� �ʱ�ȭ
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i < dp.length; i++) {
			dp[i] = -1;
		}

		System.out.println(binaryTile(N));

	}

	public static int binaryTile(int N) {
			
		if(dp[N] == -1) {
				dp[N] = binaryTile(N - 2) + binaryTile(N - 1);
			}
			
			return dp[N] % 15746;
	}

}