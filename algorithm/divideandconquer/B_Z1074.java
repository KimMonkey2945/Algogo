package algorithm.divideandconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_Z1074 {

	public static int count = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int size = (int) Math.pow(2, N);

		check(r, c, size);
		System.out.println(count);

	}

	public static void check(int r, int c, int size) {

		if (size == 1)
			return;

		if (r < size / 2 && c < size / 2) {
			check(r, c, size / 2);
		} else if (r < size / 2 && c >= size / 2) {
			count += size * size / 4;
			check(r, c - size / 2, size / 2);
		} else if (r >= size / 2 && c < size / 2) {
			count += (size * size / 4) * 2;
			check(r - size / 2, c, size / 2);
		} else {
			count += (size * size / 4) * 3;
			check(r - size / 2, c - size / 2, size / 2);

		}
	}
}
