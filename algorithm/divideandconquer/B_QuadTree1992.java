package algorithm.divideandconquer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_QuadTree1992 {

	public static int quadtree[][];
	public static StringBuffer sb = new StringBuffer();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int N = Integer.parseInt(br.readLine());
		quadtree = new int[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				quadtree[i][j] = str.charAt(j) - '0'; // 
			}
		}
		
		compress(0, 0, N);
		System.out.println(sb);

	}
	
	public static void compress(int row, int col, int N) {
		if(check(row, col, N)) {
			sb.append(quadtree[row][col]);
			return;
		}
		int size = N / 2;
		
		sb.append('(');
		
		compress(row, col, size);
		compress(row, col + size, size);
		compress(row + size, col, size);
		compress(row + size, col + size, size);
		
		sb.append(')');
	}
	
	public static boolean check(int row, int col, int N) {
		int value = quadtree[row][col];
		
		for(int i = row; i < row + N; i++) {
			for(int j = col; j < col + N; j++) {
				if(value != quadtree[i][j]) {
					return false;
				}
			}
		}
		return true;
		
	}

}