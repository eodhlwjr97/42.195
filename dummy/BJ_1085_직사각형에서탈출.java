import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        int w = in.nextInt();
        int h = in.nextInt();
        
        
        
        int temp1 = Math.min(w-x,h-y);
        int temp2 = Math.min(x-0, y-0);
        
        System.out.println(Math.min(temp1, temp2));
	}

}


/**
컴파일에러
System.out.println(Math.min(Math.min(w-x,h-y), temp2Math.min(x-0, y-0)));
**/
