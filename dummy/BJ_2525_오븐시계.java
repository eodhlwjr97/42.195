import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		int h = in.nextInt();
		int m = in.nextInt();
        int time = in.nextInt();
		if ((m+time) >= 60) {
            h = h+(m+time)/60;
			m = (m+time)%60;
			if (h >= 24) {
				h = h-24;
			} 
			
		} else { 
			h = h;
            m = m+time;
		}
		System.out.println(h + " " + m);

	}

}
