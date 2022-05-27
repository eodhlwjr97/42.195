import java.io.*;
import java.util.*;

public class BJ_2475_검증수 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        double sum = 0;
        for(int i=0; i<5; i++){
            int num = in.nextInt();
            // Math.pow() 메소드는 입력값과 출력값은 모두 double형
            sum += Math.pow(num, 2);
        }
        int result = (int)sum % 10;
        System.out.println(result);
	}
}
