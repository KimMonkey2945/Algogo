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

		int n = Integer.parseInt(br.readLine()); // ��������
		int k = Integer.parseInt(br.readLine()); // ���߱�����

		Integer[] sensor = new Integer[n];
		if (k >= n) {
			System.out.println(0); 
			// ���������� ���߱� �������� ���ų� ���� ���� 1:1 ��Ī�� ���� �ϹǷ� �Ÿ��� 0�̴�. 
			return;
		}
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			sensor[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(sensor); // ������ ������������ �����ϰ�

		Integer[] distance = new Integer[n - 1];
		for (int i = 0; i < n - 1; i++) {
			distance[i] = sensor[i + 1] - sensor[i];
		} 

		Arrays.sort(distance, Collections.reverseOrder());
		// ������ ������ �Ÿ��� ���� ������������ �����Ѵ�.
		
		
		int sum = 0;
		for (int i = k - 1; i < n - 1; i++) {
			sum += distance[i];
		}
		
		// ������ ���� ���̸� k-1�� �и� ��, k�� �и��ϴ� ���� ���� ���̰� ���� ���� ������
		// k-1�� �����ϸ� �ȴ�.

		System.out.println(sum);
	}

}
