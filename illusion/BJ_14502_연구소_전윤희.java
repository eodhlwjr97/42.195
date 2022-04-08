package com.ssafy.A형대비;

import java.io.*;
import java.util.*;

public class BJ_14502_연구소 {
	static class Virus {
		int r;
		int c;

		public Virus(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int R, C;
	static List<Virus> v = new ArrayList<>();
	static Queue<Virus> q = new LinkedList<>();

	static int safeWall = -3; // 3개의 벽을 놓으니까 미리 초기화
	static int answer = 0;
	static int[][] map;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);

		R = in.nextInt();
		C = in.nextInt();

		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = in.nextInt();

				if (map[i][j] == 0) { // 빈칸
					safeWall++;
				} else if (map[i][j] == 2) { // 바이러스는 리스트에 넣기
					v.add(new Virus(i, j));
				}
			}
		}

		build();

		System.out.println(answer);
	}

	private static void build() {
		int size = R * C;

		// 벽 3개 자리 뽑기 (행우선순회)
		for (int i = 0; i < size - 2; i++) { // 첫번째 벽 세우고
			if (map[i / C][i % C] == 1)
				continue;
			map[i / C][i % C] = 1;

			for (int j = i + 1; j < size - 1; j++) { // 두번째 벽 세우고
				if (map[j / C][j % C] == 1)
					continue;
				map[j / C][j % C] = 1;

				for (int k = j + 1; k < size; k++) { // 세번째 벽 세우고
					if (map[k / C][k % C] == 1)
						continue;
					map[k / C][k % C] = 1;

					bfs();

					// 다음 반복문을 위해 원상복구 처리
					map[k / C][k % C] = 0;
				}
				map[j / C][j % C] = 0;
			}
			map[i / C][i % C] = 0;
		}

	}

	private static void bfs() {
		boolean[][] visited = new boolean[R][C];
		int count = 0;

		for (int i = 0; i < v.size(); i++) {
			Virus current = v.get(i);
			q.add(current);
			visited[current.r][current.c] = true;
		}

		while (!q.isEmpty()) {
			Virus current = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = current.r + dr[d];
				int nc = current.c + dc[d];

				if (check(nr, nc) && !visited[nr][nc] && map[nr][nc] != 1) {
					visited[nr][nc] = true;
					count++;
					q.add(new Virus(nr, nc));
				}
			}
		}
		
		answer = Math.max(answer, safeWall - count);
	}

	private static boolean check(int nr, int nc) {
		return (0 <= nr && nr < R && 0 <= nc && nc < C);
	}

}
