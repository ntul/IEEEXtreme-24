
import java.util.*;
     
   
    public class Main
    {
	
	
	 Boolean self=false;
         int V;  
         ArrayList<LinkedList<Integer>> adj;
     
        
        Main(int v)
        {
            V = v;
            adj = new ArrayList<LinkedList<Integer>>();
            for (int i=0; i<v; ++i)
                adj.add(new LinkedList<Integer>());
        }
     
       
        void addEdge(int v,int w)
        {
            
            adj.get(v).add(w);
            adj.get(w).add(v);
            
        }
     
        
        Boolean isCyclicUtil(int v, Boolean visited[], int parent)
        {
            
            visited[v] = true;
            Integer i;
     
            
            Iterator<Integer> it = adj.get(v).iterator();
            while (it.hasNext())
            {
                i = it.next();
     
                
                if (!visited[i])
                {
                    if (isCyclicUtil(i, visited, v))
                        return true;
                }
     
                
                else if (i != parent)
                   return true;
            }
            return false;
        }
     
        
        Boolean isTree()
        {
            if (self) return false;
           
            Boolean visited[] = new Boolean[V];
            for (int i = 0; i < V; i++)
                visited[i] = false;
     
           
            if (isCyclicUtil(0, visited, -1))
                return false;
     
            
            for (int u = 0; u < V; u++)
                if (!visited[u])
                    return false;    
            
            return true;
        }
     
        Boolean isCyclic()
        {
            
            Boolean visited[] = new Boolean[V];
            for (int i = 0; i < V; i++)
                visited[i] = false;
     
           
            for (int u = 0; u < V; u++)
                if (!visited[u])
                    if (isCyclicUtil(u, visited, -1))
                        return true;
     
            return false;
        }
        
        public static void main(String args[])
        {
            
            Scanner in = new Scanner(System.in);
    	
            int t=in.nextInt();	
            int[] answer = new int[t];
            for(int k=0; k<t; k++){
    	int n=in.nextInt();
    	int m=in.nextInt();
    	
    	int[] path = new int[m*2];
    	
    	for(int i=0; i<(m*2); i++){
   	 path[i]=in.nextInt();
   	} 
          Main g1 = new Main(n);
          
         
          
    	for(int i=0; i<(m*2);i=i+2){
          g1.addEdge(path[i], path[(i+1)]);
    	}
     
    	
    	 if (g1.isCyclic())
             answer[k]=1;
         else 
             answer[k]=0;
    	 
            }
            in.close();
            
            for(int a: answer)
    	    System.out.println(a);
        }
    }
