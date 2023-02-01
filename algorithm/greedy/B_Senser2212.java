package algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class B_Senser2212 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine()); // 센서갯수
		int k = Integer.parseInt(br.readLine()); // 집중국갯수

		Integer[] sensor = new Integer[n];
		if (k >= n) {
			System.out.println(0); 
			// 센서갯수가 집중국 갯수보다 같거나 적을 때는 1:1 매칭이 가능 하므로 거리는 0이다. 
			return;
		}
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			sensor[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(sensor); // 센서를 오름차순으로 정렬하고

		Integer[] distance = new Integer[n - 1];
		for (int i = 0; i < n - 1; i++) {
			distance[i] = sensor[i + 1] - sensor[i];
		} 

		Arrays.sort(distance, Collections.reverseOrder());
		// 센서들 사이의 거리를 구해 내림차순으로 정렬한다.
		
		
		int sum = 0;
		for (int i = k - 1; i < n - 1; i++) {
			sum += distance[i];
		}
		
		// 센서와 센서 사이를 k-1번 분리 즉, k번 분리하는 것은 가장 차이가 많이 나는 구간을
		// k-1번 제거하면 된다.

		System.out.println(sum);
	}

}
