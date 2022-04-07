package com.ssafy.A형대비;

import java.io.*;
import java.util.*;

public class D4_1249_보급로 {
	static int T, N;
	static int[][] map;
	
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	
	static int answer;

	static class position implements Comparable<position> {
		int r;
		int c;
		int sum;

		public position(int r, int c, int sum) {
			this.r = r;
			this.c = c;
			this.sum = sum;

		}

		@Override
		public int compareTo(position o) {
			return this.sum - o.sum;
		}

	}

	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input_D4_1249_보급로.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine()); // 지도의 크기(N x N)

			// 배열 초기화
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				char[] line = br.readLine().toCharArray();
				// String line = in.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = line[j] - '0';
					// map[i][j] = Integer.parseInt(line.charAt(j) + "");
				}
			}

			answer = Integer.MAX_VALUE;

			bfs(0, 0, map[0][0]);

			System.out.println("#" + tc + " " + answer);
		}
	}

	static void bfs(int r, int c, int sum) {
		PriorityQueue<position> q = new PriorityQueue<position>();
		boolean[][] visited = new boolean[N][N];
		visited[r][c] = true;
		q.offer(new position(r, c, sum));

		while (!q.isEmpty()) {
			position temp = q.poll();
			visited[temp.r][temp.c] = true;
			for (int d = 0; d < 4; d++) {
				int nr = temp.r + dr[d];
				int nc = temp.c + dc[d];
				int nSum = temp.sum;

				if (check(nr, nc) && !visited[nr][nc] && nSum < answer) {
					nSum += map[nr][nc];
					visited[nr][nc] = true;

					if (nr == N - 1 && nc == N - 1) {
						answer = Math.min(answer, nSum);
						visited[nr][nc] = false;

					} else {
						q.offer(new position(nr, nc, nSum));
						visited[nr][nc] = false;
					}
				}
			}

		}
	}

	static boolean check(int r, int c) {
		if (r >= 0 && r < N && c >= 0 && c < N)
			return true;
		return false;
	}

}