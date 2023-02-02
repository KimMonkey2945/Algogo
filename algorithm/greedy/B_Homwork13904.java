package algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B_Homwork13904 {
	
	//������ ������ ������� ������ �Ŀ� ������ ������ �׳��� �� ���缭 ���� �迭�� ���� ����� �ֵ����ϰ� �ϰ� ����
		//�� ���� ���� ���� ���� �ϼ��� ������ -1 �� �ݺ��ؼ� ���� ������ �ִ´� 
		//��, �̶� �����ִ� ������ �ϼ����� ���� �������� �ֱ�.
		public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int N = Integer.parseInt(br.readLine()); // ��������

			int[][] work = new int[N][2];
			int[] submit = new int[1001]; // ó���� �ƹ� �������� N�� ũ��� �༭ �����߾���.
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				work[i][0] = Integer.parseInt(st.nextToken());
				work[i][1] = Integer.parseInt(st.nextToken());
			}

			Comparator<int[]> com = new Comparator<>() {

				@Override
				public int compare(int[] o1, int[] o2) { // ������������ �������� ����
					return o2[1] - o1[1];
				}

			};

			Arrays.sort(work, com);
			
			int sum = 0;
			for (int i = 0; i < N; i++) {
				while (true) {

					if (submit[work[i][0]] == 0) {
						submit[work[i][0]] = work[i][1]; // ���� �迭�� �ڽ��� �ϼ��� ���� �ε����� ��������� �ֱ�
						break;
						
					}else {
						int count = work[i][0] - 1;
						while(true) {
							if(count <= 0) {
								break;
							}
							if(submit[count] == 0 && count > 0) {	//���� �迭�� �������� �ε����� ����� ������ ã�� 
								submit[count] = work[i][1];
								break;
							}
							if(count > work[i][0]) { // �� ���� ���ں��� �ε����� Ŀ���� ������ �������� �ʴ´�.
								break;
							}
							count--;
						}
						break;
					}

				}
			}
			
			for(int a : submit) {
				sum += a;	// ���� �迭�� ������ �ֵ��� ��
			}
			
			System.out.println(sum);

		}
}
