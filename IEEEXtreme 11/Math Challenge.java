
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.*;
import java.util.*;

//Math Challenge using Fast Doubling Factorial, Euler's Totient Theorem, Chinese Remainder Theorem,

public class MathChallengeFinal {
    static final long mL  = 1000000007L;
    static final long mL1 = 1000000006L;
    
    static long startTime, finishTime;
    
    // Initialize result
         // Or BigInteger.ONE
    
    static boolean isFirst=true;
    
    static long getFastFactorial(long num,long num1, long m)
    {
        long factorial=1L;
        long diffrennceFromActualNum=0;
        
        long previousSum = (long)num;
        long bNum = (long)num;
        long bNum1 = (long)num1;
        long n1 = bNum1+1;
        long n2 = bNum1+2;
        long n3 = n1*n2;
        long n4 = n3*bNum;
    
        if((num-num1)==2)
   	 return n1*bNum;  
       else if ((num-num1)==1)
   	 return num; 
       else if (num==num1)   
            return 1L;  
       else if ((num-num1)==3)
   	 return n4;
       else
       diffrennceFromActualNum=num1+2L;
             
        if(num==0) //Returning  1 as factorial if number is 0 
            return 1L;
        if((num-num1)%2==0)//  Checking if Number is odd or even
        { 
            while(num-diffrennceFromActualNum>=2L)
            {
                if(isFirst)
                {     previousSum=num*(num1+1);
                      factorial=previousSum;
                      isFirst=false;
                }
                previousSum=previousSum+(num-diffrennceFromActualNum);

                
                factorial=((factorial%m)*(previousSum%m))%m;
                
               
                diffrennceFromActualNum+=2L;
                
            }
        }
        else // In Odd Case (Number * getFactorial(Number-1))
        {
            factorial=(num*(getFastFactorial(num-1,num1, m)))%m;
           
        }
        isFirst=true;
        return factorial;
    }
    
    static long getFactorial(long num, long m)
    {
        long factorial=1L;
        long diffrennceFromActualNum=0;
        long previousSum=(long)num;

        if(num==0) //Returning  1 as factorial if number is 0 
            return 1L;
        if(num%2==0)//  Checking if Number is odd or even
        { 
            while(num-diffrennceFromActualNum>=2L)
            {
                if(!isFirst)
                {
                    previousSum=previousSum+(num-diffrennceFromActualNum);  
                }
                isFirst=false;                
                
                    factorial=((factorial%m)*(previousSum%m))%m;
                diffrennceFromActualNum+=2L;
            }
        }
        else // In Odd Case (Number * getFactorial(Number-1))
        {
            factorial=(num*getFactorial(num-1,m))%m;
        }
            isFirst=true;
            return factorial;
    }
      
 
    
    static long powerMod(long a,long b, long m) {
	    long x=1L;
	    long y=a;
	    while(b > 0){
	        if(b%2 == 1){
	            x=((x%m)*(y%m))%m;
	        }
	        y = ((y%m)*(y%m))%m; // squaring the base
	        b /= 2L;
	    }
	    return  x%m;
	}
    

     
    static long binomFact (long num, long denom, long m){
	
	long res=1L;
	
	if(m==2)
	    res=num;
	else
	res=num*powerMod(denom,m-2,m)%m;
	
	return res%m;
    }
    
    
    public static void main(String[] args) throws NumberFormatException, IOException {

	long inv1=250000002L;

	long a0=0;
  long a1=0;
	long x=0;
	
	long num, denom,res,res3,a,b,c,n,m;
	int t;
	
	BufferedReader inB = new BufferedReader(new InputStreamReader(System.in));
	
	t = Integer.parseInt(inB.readLine());
	long[] answer = new long[t];
	String [] q = new String[3];
	
	for(int k=0; k<t; k++){
	q = inB.readLine().split("\\s");
	a = Long.parseLong(q[0]);
	b = Long.parseLong(q[1]);
	c = Long.parseLong(q[2]);

	if (c>b-c) c=b-c;
	
	startTime = System.currentTimeMillis();
	if(b==c)
	    answer[k]=a; 
	else if (a==1)
	    answer[k]=1;
	else{
	
	a0=-1;

            
	    n=b;
	    m=c;
	    
	    if(n%2==0&&m%2==1)
	    a0=0;
	    else {
		while(m>1){
		    n=n>>1;
		    m=m>>1;
		    if(n%2==0&&m%2==1)
			    a0=0;
		}
		if(a0==-1&&n%2==1) a0=1;
		else if(a0==1&&n%2==0) a0=0;
	    }
	    
	    	    
	    num=getFastFactorial(b,b-c,500000003L);
	    denom=getFactorial(c,500000003L);
	    
	    
	    a1 = binomFact(num,denom,500000003L);

	    x = (a0*500000003L*1)%mL1+(a1*2L*inv1)%mL1;
	    
		    res=x%mL1;
	    	    	   	
	res3=powerMod(a,res,mL);
	answer[k]=res3;
	}
	
	}

	inB.close();

	long finishTime = System.currentTimeMillis();
	System.out.println("That took: "+(finishTime-startTime)+ " ms");
	
	for(long p:answer)
	    System.out.println(p);
	
    }
}
