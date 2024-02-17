package Test5;

public class mat {
	int [][] matrix;
	mat(int [][] mat)
	{
		matrix=mat;
	}
		
	
	    public static mat add(mat a,mat b)
	    {

			for(int i=0;i<a.matrix.length;i++) {
				for(int j=0;j<a.matrix[0].length;j++) {
					a.matrix[i][j] = a.matrix[i][j] + b.matrix[i][j];
				}
			}
			
			return a;
	    }
	    public static mat multiply(mat a,mat b)
	    {   
	    	int i, j, k;
//	       mat c = new mat();
	    	int [][] m1=new int[a.matrix.length][a.matrix[0].length];
	    	mat c = new mat(m1);
	    	for (i = 0; i < a.matrix.length; i++) {
	    	      for (j = 0; j < a.matrix.length; j++) {
	    	    	  c.matrix[i][j] = 0;
	    	        for (k = 0; k < a.matrix.length; k++) {
	    	        	c.matrix[i][j] += a.matrix[i][k] * b.matrix[k][j];
	    	        }
	    	      }
	    	    }
	    	return c;
	    }
	    public static mat transpose(mat m)
	    {
	    	int t[][]=new int[m.matrix.length][m.matrix[0].length]; 
	    	mat trans = new mat(t);
	    	for(int i=0;i<m.matrix.length;i++){    
	    		for(int j=0;j<m.matrix[0].length;j++){    
	    		 trans.matrix[i][j]=m.matrix[j][i];  
	    		}    
	       }  
	    	return trans;
	    }
	    public static mat rotate(mat m)
	    {
	    	 // Consider all squares one by one
	        for (int x = 0; x < m.matrix.length / 2; x++) {
	            // Consider elements in group
	            // of 4 in current square
	            for (int y = x; y <  m.matrix.length - x - 1; y++) {
	                // Store current cell in
	                // temp variable
	                int temp = m.matrix[x][y];
	 
	                // Move values from right to top
	                m.matrix[x][y] = m.matrix[y][ m.matrix.length - 1 - x];
	 
	                // Move values from bottom to right
	                m.matrix[y][ m.matrix.length - 1 - x]
	                    = m.matrix[ m.matrix.length - 1 - x][ m.matrix.length- 1 - y];
	 
	                // Move values from left to bottom
	                m.matrix[ m.matrix.length - 1 - x][ m.matrix.length- 1 - y]
	                   = m.matrix[ m.matrix.length - 1 - y][x];
	 
	                // Assign temp to left
	                m.matrix[ m.matrix.length - 1 - y][x] = temp;
	            }
	        }
	        
	        return m;
	    }
	    public  void print()
	    {
	        for(int i=0;i<matrix.length;i++)
	        {
	            for(int j=0;j<matrix[0].length;j++)
	            {
	                System.out.print(matrix[i][j]+" ");
	            }
	            System.out.println();
	        }
	    }
}
