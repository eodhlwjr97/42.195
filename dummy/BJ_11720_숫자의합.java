package 문자열;

import java.io.*;
import java.util.*;

public class BJ_11720_숫자의합 {

	public static void main(String[] args) throws Exception{
		Scanner in = new Scanner(System.in);
		
		// Integer.parseInt: 문자열을 숫자로 변환
		int tc = Integer.parseInt(in.nextLine());
		String s = in.nextLine();
		
		int sum = 0;
		
		for (int i = 0; i < tc; i++) {	
			/** char -> String : String.valueOf(char) */
			// charAt자체로는 char만 반환하기 때문에 단독 사용은 불가능
			String numString = String.valueOf(s.charAt(i));
			int num = Integer.parseInt(numString);
			
			sum += num;
		}
		
		System.out.println(sum);

	}

}
