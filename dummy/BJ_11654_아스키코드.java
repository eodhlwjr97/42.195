package 문자열;

import java.io.*;
import java.util.*;

public class BJ_11654_아스키코드 {

	public static void main(String[] args) throws Exception{
		Scanner in = new Scanner(System.in);
		
		/** 아스키코드 문자 -> 숫자(10진수):아스키코드 값 */
		char x = 'A';
		int result1 = x;
		System.out.println(result1);
		
		String y = "A";
		// char를 반환하는 charAt(index)
		char temp = y.charAt(0);
		int result2 = temp;
		System.out.println(result2);
		
		/** 숫자(10진수):아스키코드 값 -> 아스키코드 문자 */
		int n = 65;
		System.out.println((char)n);
		
		// 11654 문제풀기
		String s = in.next();
		char a = s.charAt(0);
		int result = a;
		System.out.println(result);

	}

}
