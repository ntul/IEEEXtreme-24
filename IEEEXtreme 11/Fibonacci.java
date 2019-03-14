import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
   
  static BigInteger x = new BigInteger("10");
    
  private static BigInteger fibonacci(int n) {
	BigInteger a = BigInteger.ZERO;
	BigInteger b = BigInteger.ONE;
	int m = 0;
	for (int bit = Integer.highestOneBit(n); bit != 0; bit >>>= 1) {
	
		
		
		BigInteger d = multiply(a, b.shiftLeft(1).subtract(a));
		BigInteger e = multiply(a, a).add(multiply(b, b));
		a = d;
		b = e;
		m *= 2;
			
		
		if ((n & bit) != 0) {
			BigInteger c = a.add(b).mod(x);
			a = b.mod(x);
			b = c.mod(x);
			m++;
			
		}
	}
	return a;
}
    
     static BigInteger multiply(BigInteger x, BigInteger y) {
	return x.multiply(y);
}
    
public static void main(String[] args) {
	
	
	Scanner in = new Scanner(System.in);
	int t=in.nextInt();
	BigInteger[] answer = new BigInteger[t];
	
	
	for(int c=0; c<t; c++){
	int n=in.nextInt();
	
	answer[c]=fibonacci(n+1).mod(x);
	}
	
	for(BigInteger p:answer)
	    System.out.println(p);
}
}
