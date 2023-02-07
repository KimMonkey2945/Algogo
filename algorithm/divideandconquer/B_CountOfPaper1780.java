package algorithm.divideandconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_CountOfPaper1780 {

	public static int paper[][];

	public static int one = 0;
	public static int zero = 0;
	public static int minus = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		paper = new int[N][N];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		paper(0,0,N);
		
		System.out.println(minus);
		System.out.println(zero);
		System.out.println(one);

	}

	public static void paper(int row, int col, int N) {

		if (check(row, col, N)) {
			if (paper[row][col] == -1) {
				minus++;
			} else if (paper[row][col] == 0) {
				zero++;
			} else {
				one++;
			}
			
			return;
		}
		
		int size = N / 3;
		
		paper(row, col, size);
		paper(row, col + size, size);
		paper(row, col + 2*size, size);
		
		paper(row + size, col, size);
		paper(row + size, col + size, size);
		paper(row + size, col + 2*size, size);

		paper(row + 2*size, col, size);
		paper(row + 2*size, col + size, size);
		paper(row + 2*size, col + 2*size, size);
		

	}

	public static boolean check(int row, int col, int N) {
		int value = paper[row][col];
		for (int i = row; i < row + N; i++) {
			for (int j = col; j < col + N; j++) {
				if (value != paper[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

}
