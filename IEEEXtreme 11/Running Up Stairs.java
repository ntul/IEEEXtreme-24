import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    
  static BigInteger stairs(int x){
	Map<Integer,BigInteger> computedValues = new HashMap<Integer, BigInteger>();
	computedValues.put(1, BigInteger.valueOf(1L));
	computedValues.put(2, BigInteger.valueOf(2L));
	if (x==2) return BigInteger.valueOf(2);
	else if (x==1) return BigInteger.valueOf(1);
	
	else return stairs(x, computedValues);
    }
    
    static BigInteger stairs(int n, Map<Integer,BigInteger> computedValues){
	
	if (computedValues.containsKey(n)) return computedValues.get(n);
	 
	    computedValues.put(n-1, stairs(n-1,computedValues));
	    computedValues.put(n-2, stairs(n-2,computedValues));
	 
	    BigInteger newValue = computedValues.get(n-1).add(computedValues.get(n-2))  ;
	    computedValues.put(n, newValue);
	    return newValue;

       }
    
    public static void main(String[] args) {
	
  	Scanner in = new Scanner(System.in);
  	  	
  	int t=in.nextInt();
	int n;
	
	BigInteger[] ans = new BigInteger[t];
	
	for(int i=0; i<t; i++){
	     n=in.nextInt();
	
	ans[i] = stairs(n);
	}
	for(BigInteger p:ans)
	System.out.println(p);
    }
}

