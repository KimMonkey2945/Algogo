package algorithm.dynamicprogramming;

import java.util.Scanner;

public class Na_AntWarrior {
	//���� ����� �����ϱ� ���� dp
	static int[] dp = new int[100];
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] food = new int[n];
		//�ķ����� 
		for(int i = 0; i < food.length; i++) {
			food[i] = sc.nextInt();
		}
		//���Ҿ� ������� ����
		dp[0] = food[0];
		dp[1] = Math.max(food[0], food[1]);
		
		for(int i = 2; i < n; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i-2] + food[i]);
		}
		
		System.out.println(dp[n-1]);
		
	}

}
