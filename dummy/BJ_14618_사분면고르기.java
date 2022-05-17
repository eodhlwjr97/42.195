package 조건문;

import java.io.*;
import java.util.*;

public class BJ_14618_사분면고르기 {

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		int x = in.nextInt();
		int y = in.nextInt();

		if (x > 0 && y > 0) {
			System.out.println(1);
		} else if (x < 0 && y > 0) {
			System.out.println(2);
		} else if (x < 0 && y < 0) {
			System.out.println(3);
		} else {
			System.out.println(4);
		}

	}

}
