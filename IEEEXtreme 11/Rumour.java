import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Rumour {
 
    
  public static void main(String[] args) throws IOException {
	
	long a=0, b=0,logA=0, logB=0;
	long count=0;

	
	BufferedReader inB = new BufferedReader(new InputStreamReader(System.in));
	int t = Integer.parseInt((inB.readLine()));
	ArrayList<Long> answer = new ArrayList<Long>(t);
	
	for(int i=0; i<t; i++){
	   String[] q = inB.readLine().split("\\s");
	   a=Long.parseLong(q[0]);
	   b=Long.parseLong(q[1]);
	   
	   logA=(long)(Math.log10(a)/Math.log10(2));
	   logB=(long)(Math.log10(b)/Math.log10(2));
	  
	   
	   if(logA>logB){
	       count+=logA-logB;
	       a=a>>(logA-logB);
	   }
	   else{
	       count+=logB-logA;
	       b=b>>(logB-logA);
	   }
	   
	   while(true){
	       if(a==b){
	            break;    
	            }  
	       else if(a>>1==b>>1){
	            count+=2;
	            break;
	            }
	       else if(a>>2==b>>2){
	            count+=4;
	            break;
	            }
	       else if(a>>3==b>>3){
	            count+=6;
	            break;
	            }
	       else if(a>>4==b>>4){
	            count+=8;
	            break;
	            } 
	        else{
	            a=a>>5;
	            b=b>>5;
	            count+=10;
	        }
	   }
	   
	   answer.add(count);
	   count=0;
	   
	    
	}
	inB.close();
	System.out.println();
	
	for(long p:answer)
	    System.out.println(p);
    }
    }
