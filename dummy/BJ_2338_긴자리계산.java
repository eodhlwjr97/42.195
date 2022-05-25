import java.util.*;
import java.math.BigInteger;

public class BJ_2338_긴자리계산 {

    /**
    -- int와 BigInteger의 차이점
        > int의 범위는 '-2,147,483,648~2,147,483,647'이지만 BigInteger의 범위는 문자열 형태로 이루어져 있어 무한임
    -- BigInteger 계산법
        > 문자열 형태로 이루어져 있기에 사칙연산이 NO
        > 따라서 BigInteger의 값을 계산을 하려면 클래스 내부의 함수를 이용해야 함
            > 클래스 내부의 함수
                - 더하기 : add()
                - 빼기 : subtract()
                - 곱하기 : multiply()
                - 나누기 : divide()
    **/
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BigInteger A = in.nextBigInteger(); 
        BigInteger B = in.nextBigInteger(); 
        in.close();
        System.out.println(A.add(B));
        System.out.println(A.subtract(B));
        System.out.println(A.multiply(B));
	}

}
