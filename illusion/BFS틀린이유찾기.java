package 기지국건설;

import java.io.*;
import java.util.*;

public class Solution_토마토BFS {

	static int R, C;
	static long costBenefit;
	static int[][] cell;
	static boolean[][] visited;
	static int pick;

	static int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };

	static class Position {
		int r;
		int c;

		public Position(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input_기지국건설.txt")));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());

			cell = new int[R + 1][C];
			for (int i = 0; i < R; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < C; j++) {
					cell[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = R - 1; i >= 0; i--) {
				for (int j = 0; j < C; j++) {
					if (j % 2 == 1) {
						if (i + 1 < R + 1) {
							cell[i + 1][j] = cell[i][j];
						}
						if (i == 0) {
							cell[i][j] = 0;
						}
					}
					cell[i][j] = cell[i][j];
				}
			}

//			for (int i = 0; i < R + 1; i++) {
//				for (int j = 0; j < C; j++) {
//					System.out.print(cell[i][j] + " ");
//				}
//				System.out.println();
//			}

			bfs();

			System.out.println("#" + tc + " " + (int) Math.pow(costBenefit, 2));
		}
	}

	private static void bfs() {
		Queue<Position> q = new LinkedList<>();
		visited = new boolean[R + 1][C];

		for (int i = 0; i < R + 1; i++) {
			for (int j = 0; j < C; j++) {
				if (cell[i][j] != 0) {
					q.add(new Position(i, j));
					
				}
			}
		}

		while (!q.isEmpty()) {
			if (pick == 4)
				break;
			Position temp = q.poll();
			visited[temp.r][temp.c] = true;
			for (int d = 0; d < 8; d++) {
				int nr = temp.r + dr[d];
				int nc = temp.c + dc[d];

				if (nr < 0 || nc < 0 || nr >= R || nc >= C || cell[nr][nc] == 0 || visited[nr][nc] == true)
					continue;

				cell[nr][nc] += cell[temp.r][temp.c];
				//System.out.println("cell[nr][nc]: " + cell[nr][nc]);
				pick++;
				q.offer(new Position(nr, nc));

			}
		}

		costBenefit = 0;
		for (int i = 0; i < R + 1; i++) {
			for (int j = 0; j < C; j++) {
				costBenefit = Math.max(costBenefit, cell[i][j]);
			}
		}
	}
}
