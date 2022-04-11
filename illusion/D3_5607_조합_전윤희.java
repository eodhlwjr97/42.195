package com.ssafy.A형대비;

import java.io.*;
import java.util.*;

public class D3_5607_조합 {
	static int n, r; // nCr
	static final long MOD = 1234567891;
	static long factorial[];

	public static long pow(long a, long remain) {
		if (remain == 0)
			return 1;
		else if (remain == 1)
			return a;
		if (remain % 2 == 0) {
			long temp = pow(a, remain / 2);
			return (temp * temp) % MOD;
		}
		long temp = pow(a, remain - 1) % MOD;
		return (temp * a) % MOD;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		factorial = new long[1000001];
		factorial[0] = 1;
		for (int i = 1; i < 1000001; i++) {
			factorial[i] = factorial[i - 1] * i;
			factorial[i] %= MOD;
		}
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());

			long up = 1, down = 1;
			up = factorial[n];
			down = (factorial[n - r] * factorial[r]) % MOD;
			down = pow(down, MOD - 2);
			System.out.println("#" + tc + " " + (up * down) % MOD);
		}
	}
}