package com.ssafy.cs;

import java.io.*;
import java.util.*;

public class D3_5515_2016년요일맞추기_7의배수_답참고 {

	static int month, day; // 입력받는 월, 일
	static int[] months = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30 }; // 이전 월의 날짜까지만 더한다
	static int date; // 월을 일로 치환
	static int res;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			month = in.nextInt();
			day = in.nextInt();

			date = 0;
			for (int i = 0; i < month; i++) {
				date += months[i];
			}

			switch ((date + day) % 7) {
			case 0: // 목
				res = 3;
				break;
			case 1: // 금
				res = 4;
				break;
			case 2: // 토
				res = 5;
				break;
			case 3: // 일
				res = 6;
				break;
			case 4: // 월
				res = 0;
				break;
			case 5: // 화
				res = 1;
				break;
			case 6: // 수
				res = 2;
				break;
			}

			System.out.println("#" + tc + " " + res);
		}

	}

}
