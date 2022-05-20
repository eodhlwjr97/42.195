package 조건문;

import java.io.*;
import java.util.*;

public class BJ_2480_주사위세개 {

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		int cost = 0;
		if (a != b && b != c && c != a) {
			int temp = Math.max(Math.max(a, b), c);
			cost = temp * 100;
		} else if (a == b && b == c && c == a) {
			cost = 10000 + a * 1000;
		} else {
			if (a == b) {
				cost = 1000 + a * 100;
			} else if (b == c) {
				cost = 1000 + b * 100;
			} else {
				cost = 1000 + c * 100;
			}
		}
		System.out.println(cost);

	}

}
