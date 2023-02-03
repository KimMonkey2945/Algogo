package algorithm.divideandconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_Multiplication1629 {
	/*
	 * ������ Math.pow()�� �����ڰ� % c �ϸ� ���� Ʋ���� ���´�... 
	 * 
	 * ������ ¦�� �϶� a^8 = a^4 * a^4 =(a^2 *
	 * a^2) * (a^2 * a^2) =((a^1 * a^1) * (a^1 * a^1)) * ((a^1 * a^1) * (a^1 * a^1))
	 * ������ Ȧ�� �϶� a^9 = a^4 * a^4 * a =(a^2 * a^2) * (a^2 * a^2) * a =((a^1 * a^1) *
	 * (a^1 * a^1)) * ((a^1 * a^1) * (a^1 * a^1)) * a
	 * 
	 * ��ⷯ �յ����� (a*b)%c = (a%c * b%c)%c
	 *
	 */

	public static long C;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long answer = 0;
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());

		answer = pow(A, B);
		System.out.println(answer);
	}

	public static long pow(long A, long exponent) {

		if (exponent == 1) {
			return A % C;
		}

		long temp = pow(A, exponent / 2);

		if (exponent % 2 == 1) {
			return (temp * temp % C) * A % C;
		}
		return temp * temp % C;

	}

}
