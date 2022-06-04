import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
        int cnt = 0;
        for(int i=0; i<8; i++){ // 8x8 체스판에서 한줄씩 읽어와서
            String s = in.nextLine();
            for(int j=0; j<8; j++){ // 각 칸에 대해서 흰색 체스판에 말이 있는지 확인한다
                if(i%2==0){ // 가장 왼칸이 흰색 체스판으로 시작할 때
                    if(j%2==0 && s.charAt(j)=='F'){
                        cnt++;
                    }
                }else{ // 가장 왼칸이 검은색 체스판으로 시작할 때
                    if(j%2==1 && s.charAt(j)=='F'){
                        cnt++;
                    }
                }
            }
        }
  
		System.out.println(cnt);
	}

}
