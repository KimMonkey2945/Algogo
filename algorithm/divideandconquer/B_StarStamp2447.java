package algorithm.divideandconquer;
import java.util.Scanner;

public class B_StarStamp2447 {
	//메모리 초과는 나중에 수정하도록.... 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = (int) Math.pow(3, sc.nextInt());
		String[][] star = new String[N][N];
		
		for(int i = 0; i < star.length; i++) {
			for(int j = 0; j < star[0].length; j++) {
				star[i][j] = " ";
			}
		}
		stampStar(0, 0, N, star);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++) {
				sb.append(star[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb);
		
		
	}

	public static void stampStar(int r, int c, int N, String[][] star) {
		if(N == 1) {
			star[r][c] = "*";
			return;
		}
		int newN = N /3;
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(!(i == 1 & j == 1)) {
					stampStar(r +(newN * i), c + (newN* j), newN, star);
				}
			}
		}
	
	}

}
