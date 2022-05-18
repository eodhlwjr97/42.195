package 조건문;

import java.io.*;
import java.util.*;

public class BJ_2884_알람시계 {

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		int h = in.nextInt();
		int m = in.nextInt();
		if (m < 45) {
			m = (m + 60) - 45;
			if (h == 0) {
				h = 23;
			} else {
				h = h - 1;
			}
		} else { // 45 <= m <= 59
			m = m - 45;
		}
		System.out.println(h + " " + m);

	}

}
