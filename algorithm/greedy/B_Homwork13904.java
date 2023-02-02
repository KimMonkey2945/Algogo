package algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B_Homwork13904 {
	
	//과제의 점수가 높은대로 정렬한 후에 점수가 높으면 그날에 딱 맞춰서 제출 배열을 따로 만들어 넣도록하고 하고 만약
		//그 다음 높은 것이 남은 일수가 같으면 -1 을 반복해서 남은 공간에 넣는다 
		//단, 이때 남아있는 공간이 일수보다 작은 공간에만 넣기.
		public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int N = Integer.parseInt(br.readLine()); // 과제갯수

			int[][] work = new int[N][2];
			int[] submit = new int[1001]; // 처음에 아무 생각없이 N의 크기로 줘서 실패했었음.
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				work[i][0] = Integer.parseInt(st.nextToken());
				work[i][1] = Integer.parseInt(st.nextToken());
			}

			Comparator<int[]> com = new Comparator<>() {

				@Override
				public int compare(int[] o1, int[] o2) { // 점수기준으로 내림차순 정렬
					return o2[1] - o1[1];
				}

			};

			Arrays.sort(work, com);
			
			int sum = 0;
			for (int i = 0; i < N; i++) {
				while (true) {

					if (submit[work[i][0]] == 0) {
						submit[work[i][0]] = work[i][1]; // 제출 배열에 자신의 일수와 같은 인덱스가 비어있으면 넣기
						break;
						
					}else {
						int count = work[i][0] - 1;
						while(true) {
							if(count <= 0) {
								break;
							}
							if(submit[count] == 0 && count > 0) {	//제출 배열에 제출인자 인덱스에 빈곳이 없으면 찾기 
								submit[count] = work[i][1];
								break;
							}
							if(count > work[i][0]) { // 단 제출 일자보다 인덱스가 커지면 점수로 포함하지 않는다.
								break;
							}
							count--;
						}
						break;
					}

				}
			}
			
			for(int a : submit) {
				sum += a;	// 제출 배열에 포함한 애들의 합
			}
			
			System.out.println(sum);

		}
}
