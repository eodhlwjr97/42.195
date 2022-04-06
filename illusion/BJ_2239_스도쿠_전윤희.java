package com.ssafy.A형대비;

import java.io.*;
import java.util.*;

// 빈칸에 들어갈 수 있는 값을 조사하면서 스도쿠를 완성해나가면서 풀이
// 백트래킹 기법
// 배열을 입력받을 때 빈칸(=0)을 List에 저장
// 이후, List 요소들에 순차적으로 접근하면서 해당 위치에 대입 가능한 숫자들을 찾아 채움
// 만약 대입 가능한 숫자가 없을 경우 이전 단계로 돌아가며 다음 가능한 숫자를 대입
// 위 과정을 반복, List에 있는 모든 위치를 방문한 경우 완성된 스도쿠를 출력하고 종료 
// 사전식으로 앞서는 것을 출력해야 하기 때문에 숫자를 1부터 대입
// 완성시 프로그램 종료


public class BJ_2239_스도쿠 {
	static int[][] map = new int[9][9];
	static ArrayList<int[]> blank = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 스도쿠 입력받기
		for (int r = 0; r < 9; r++) {
			char[] temp = br.readLine().toCharArray();
			// String temp = br.readLine();
			for (int c = 0; c < 9; c++) {
				map[r][c] = temp[c] - '0';
				// map[r][c] = temp.charAt(c) - '0';
				
				// 스도쿠 빈칸의 좌표는 list에 따로 저장
				if (map[r][c] == 0)
					blank.add(new int[] { r, c });
			}
		}

		sudoku(0);
	}

	static void sudoku(int index) {
		// 기저조건
		if (index == blank.size()) { // 빈칸의 개수를 다 채우면 종료
			StringBuilder sb = new StringBuilder();
			for (int r = 0; r < 9; r++) {
				for (int c = 0; c < 9; c++) {
					sb.append(map[r][c]);
				}
				sb.append('\n');
			}
			System.out.println(sb);
			System.exit(0); // 강제종료
		}

		// 유도파트
		int r = blank.get(index)[0]; // 빈칸 행
		int c = blank.get(index)[1]; // 빈칸 열

		boolean[] visited = new boolean[10]; // 1~9까지 수 중 이미 쓰인 숫자 체크

		for (int i = 0; i < 9; i++) { // 세로 줄 쓰인 숫자 처리
			visited[map[i][c]] = true; 
		}
		for (int i = 0; i < 9; i++) { // 가로 줄 쓰인 숫자 처리
			visited[map[r][i]] = true;
		}
		for (int i = r / 3 * 3; i < r / 3 * 3 + 3; i++) { // 3x3 박스 쓰인 숫자 처리
			for (int j = c / 3 * 3; j < c / 3 * 3 + 3; j++) {
				visited[map[i][j]] = true;
			}
		}

		for (int n = 1; n <= 9; n++) {
			if (!visited[n]) { // 쓰인 숫자가 없으면 
				map[r][c] = n;
				sudoku(index + 1);
				
				// 만약 1~9 중 쓸 숫자가 없으면 return 되어 그 전단계 칸으로 돌아와 다음 쓰이지 않은 숫자를 빈칸에 넣는 식으로 진행
				// 따라서 이거 안쓰면 오류남
				map[r][c] = 0;
			}
		}
	}
}