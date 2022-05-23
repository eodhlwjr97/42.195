package 문자열;

import java.io.*;
import java.util.*;

public class BJ_10809_알파벳찾기 {
	public static void main(String[] args) {
		/** 내 풀이 */
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();

		// [0]단어순서, [1]나온 횟수
		int[][] alphabet = new int[2][200]; // 26글자, 인덱스와 순서 맞추기
		int index = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int cNum = c;
			index = i;
			alphabet[1][cNum]++;
			if(alphabet[1][cNum] >= 2) continue; // 처음 등장했을 때 1이므로 두번째 등장은 2부터 시작임
			if (alphabet[0][cNum] == 0) { // 처음 등장하는 위치만 알고싶기때문
				alphabet[0][cNum] = index; // a는 97부터 z 122까지 각 문자의 아스키코드값에 순서 담기
			}
		}

		for (int i = 97; i <= 122; i++) {
			if (alphabet[1][i] == 0) { // 어떤 알파벳이 단어에 포함되어 있지 않다면
				alphabet[0][i] = -1;
			}
			System.out.print(alphabet[0][i] + " ");
		}
		
		
		/** 다른사람 풀이 */
		Scanner in = new Scanner(System.in);
 
		int[] arr = new int[26];		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = -1;
		}
 
		String S = in.nextLine();
		for(int i = 0; i < S.length(); i++) {
			char ch = S.charAt(i);
			if(arr[ch - 'a'] == -1) {	// arr 원소 값이 -1 인 경우에만 초기화
				arr[ch - 'a'] = i;
			}
		}
 
		for(int val : arr) {	// 배열 출력
			System.out.print(val + " ");
		}

	}

}
