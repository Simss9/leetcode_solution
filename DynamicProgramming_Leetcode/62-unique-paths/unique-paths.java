class Solution {
    public int uniquePaths(int m, int n) {
        int[][] uniquePaths = new int[m][n];
       for(int i =0 ; i<m; i++){
        uniquePaths[i][0] = 1;
       }
       for(int j = 0 ; j< n ; j++){
        uniquePaths[0][j] = 1;
       }
       for(int i = 1; i<m;i++){
        for(int j = 1 ; j< n ; j++){
            uniquePaths[i][j] = uniquePaths[i-1][j] + uniquePaths[i][j-1];
        }
       }
      
         return(uniquePaths[m-1][n-1]);
        
    }
}