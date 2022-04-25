import java.io.*;
import java.util.*;

/**
 * 틀린 이유
 * 7 10
 * 10 (one zero)는 7 (seven)보다 사전순으로 앞에 있습니다. 따라서 출력은 8 9 10 7 이 되어야 합니다. 
 */
public class Algo1_광주_5반_전윤희 {
	// 진짜숫자 = {0,1,2,3,4,5,6,7,8,9};
	// 숫자순위= {10,5,9,8,3,2,7,6,1,4};
	static int[] order = { 10, 5, 9, 8, 3, 2, 7, 6, 1, 4 }; // 숫자의 우선순위 (인덱스 숫자의 우선순위)
	static int count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken()); // N이상
		int M = Integer.parseInt(st.nextToken()); // M이하의 수가 주어진다
		int cnt = (M - N) + 1; // N과 M사이의 범위

		int[] arr = new int[cnt];

		for (int i = 0; i < cnt; i++) {
			if (N < 10) { // 일의자리 숫자인 경우, 십의자리가 없으므로 따로 조건문 처리
				arr[i] = order[N]; // arr는 우선순위 숫자저장
			} else {
				int a = N / 10; // 십의자리
				int b = N % 10; // 일의자리

				arr[i] = order[a] * 10 + order[b]; // 각 숫자에 맡는 우선순위 수로 바꿔준다
			}
			N++; // N이상 M이하의 수들의 우선순위 수를 모두 알아봐야하기 때문
		}

		Arrays.sort(arr); // 우선순위로 된 수들을 정렬시킨다

		count = 0;
		for (int i = 0; i < cnt; i++) {
			if (count == 10) { // 10개씩 출력
				System.out.println(sb);
				count = 0;
				sb.setLength(0); // 스트링빌더 초기화
			}

			int c = arr[i] / 10; // 우선순위말고 원래의 숫자 십의자리로 되돌리기
			int d = arr[i] % 10; // 우선순위말고 원래의 숫자 일의자리로 되돌리기
			if (d == 0) { // 단 일의자리가 0이면 우선순위가 10이므로 십의자리가 바뀌기 때문에 원위치 시켜주어야 한다
				c = c - 1;
			}
			u1: for (int j = 0; j <= 9; j++) {
				if (c == 0)
					break u1;
				if (c == order[j]) {
					sb.append(j);
					break u1;
				}
			}
			u2: for (int k = 0; k <= 9; k++) {
				if (d == 0) {
					sb.append(0 + " ");
					break u2;
				} else if (d == order[k]) {
					sb.append(k + " ");
					break u2;
				}
			}
			count++;
		}
		System.out.println(sb);
	}

}
