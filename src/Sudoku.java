public class Sudoku {
      static int[][] g= {
    		  {1,0,0,0,0,7,0,9,0},
    		  {0,3,0,0,2,0,0,0,8},
    		  {0,0,9,6,0,0,5,0,0},
    		  {0,0,5,3,0,0,9,0,0},
    		  {0,1,0,0,8,0,0,0,2},
    		  {6,0,0,0,0,4,0,0,0},
    		  {3,0,0,0,0,0,0,1,0},
    		  {0,4,0,0,0,0,0,0,7},
    		  {0,0,7,0,0,0,3,0,0}};

	  static boolean estPossible(int v,int i,int j){
	        for(int c=0; c<9;c++){
	            if(g[i][c]==v)
	                return false;
	        }
	        for(int l=0; l<9;l++){
	            if(g[l][j]==v)
	                return false;
	        }
	        int x1=3*(i/3);
	        int y1=3*(j/3);
	        int x2=x1+2;
	        int y2=y1+2;

	        for(int x=x1;x<=x2;x++)
	            for(int y=y1;y<=y2;y++)
	                if(g[x][y]==v)
	                    return false;
	        
	        return true;
	    }
	
	
	int[] caseSuivant(int i,int j) {
		
		if(j==8) 
			return new int[] {i+1,0};
		else
			return new int[] {i,j+1};
	}  
	
	boolean solve(int i,int j) {
		if(i==9 && j==0) {
			    return true;
		}        
		/*if(j>=9) {
        	int[] caseSui=caseSuivant(i,j);
		    int ii=caseSui[0];
		    int jj=caseSui[1];
		    return solve(ii,jj);
		}*/
		if(g[i][j]!=0) {
        	int[] caseSui=caseSuivant(i,j);
		    int ii=caseSui[0];
		    int jj=caseSui[1];
		    return solve(ii,jj);
        }
		
		for(int k=1;k<=9;k++) {	
			if(!estPossible(k,i,j))
			    continue;	
		    g[i][j]=k;
		    int[] caseSui1=caseSuivant(i,j);
		    int ii1=caseSui1[0];
		    int jj1=caseSui1[1];
				
		    if(solve(ii1,jj1))
			    return true;
			else
				g[i][j]=0;
		}
		
		
		return false;
	}
	  
	
	
	public static void main(String args[]) {

		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				System.out.print(g[i][j]);
			}
			System.out.println("\n");
		}
		System.out.println("-------------------------");
		
		Sudoku sd=new Sudoku();
		sd.solve(0,0);
		
		for(int i=0;i<9;i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(g[i][j]);
			}
			System.out.println("\n");
		}
    }
}
