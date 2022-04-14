package com.ssafy.cs;

import java.io.*;
import java.util.*;

public class D3_5515_2016년요일맞추기_7의배수 {
	// date 각 월별 날짜
	//mTod 이전까지의 월을 일로 치환한 날짜수
	//res 이전까지의 일을 7로 나눈 나머지
	static int date, mTod, res; 
	
	static int month, day; // 입력받는 월, 일

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			month = in.nextInt();
			day = in.nextInt();

			// monthToDate(month - 1);
			switch (month) {
			case 1:
				res = day % 7;
				findout(res);
				break;
			case 2:
				cal();
				break;
			case 3:
				cal();
				break;
			case 4:
				cal();
				break;
			case 5:
				cal();
				break;
			case 6:
				cal();
				break;
			case 7:
				cal();
				break;
			case 8:
				cal();
				break;
			case 9:
				cal();
				break;
			case 10:
				cal();
				break;
			case 11:
				cal();
				break;
			case 12:
				cal();
				break;
			}

			System.out.println("#" + tc + " " + findout(res));
		}

	}

	private static void cal() {
		monthToDate(month - 1);
		res = (mTod + day) % 7;
		// debug
		// System.out.println("res: " + res + " mTod: " + mTod + " day: " + day);
		findout(res);
	}

	private static void monthToDate(int month) {
		if (month == 0)
			return;
		if (month == 1) {
			mTod += 31;
			// debug
			// System.out.println(mTod);
			return;
		}

		// debug
		// System.out.println("month: " + month);
		if (month == 2) { // 2월 한달은 29일
			date = 29;
		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
			// 4, 6, 9,, 11월 한달은 30일
			date = 30;
		} else { // 그 외는 31일
			date = 31;
		}

		// debug
		// System.out.println("d: ");
		mTod += date;

		// debug
		// System.out.println("mTod: " + mTod);
		monthToDate(month - 1);
	}

	private static int findout(int res) {
		/*
		 * System.out.println(6); break;
		 * 
		 * -> return 으로 바꿔도 되네
		 */
		switch (res) {
		case 0: // 목
			return 3;
		case 1: // 금
			return 4;
		case 2: // 토
			return 5;
		case 3: // 일
			return 6;
		case 4: // 월
			return 0;
		case 5: // 화
			return 1;
		case 6: // 수
			return 2;
		}
		return -1;

	}

}
