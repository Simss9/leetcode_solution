class Solution {

    public int maximumAmount(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][][] dp = new int[n][m][3];

        // initialize
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                for(int k = 0; k < 3; k++){
                    dp[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }

        // starting cell
        if(grid[0][0] >= 0){
            dp[0][0][0] = grid[0][0];
        } else {
            dp[0][0][0] = grid[0][0]; // take loss
            dp[0][0][1] = 0;          // neutralize
        }

        // fill dp
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                for(int k = 0; k < 3; k++){

                    if(dp[i][j][k] == Integer.MIN_VALUE) continue;

                    // move right
                    if(j + 1 < m){
                        process(grid, dp, i, j, i, j+1, k);
                    }

                    // move down
                    if(i + 1 < n){
                        process(grid, dp, i, j, i+1, j, k);
                    }
                }
            }
        }

        // final answer
        return Math.max(dp[n-1][m-1][0],
               Math.max(dp[n-1][m-1][1], dp[n-1][m-1][2]));
    }

    private void process(int[][] grid, int[][][] dp,
                         int i, int j, int ni, int nj, int k){

        // normal cell
        if(grid[ni][nj] >= 0){
            dp[ni][nj][k] = Math.max(dp[ni][nj][k],
                                    dp[i][j][k] + grid[ni][nj]);
        }
        else{
            // robber cell

            // ✅ option 1: neutralize → NO LOSS
            if(k < 2){
                dp[ni][nj][k+1] = Math.max(dp[ni][nj][k+1],
                                          dp[i][j][k]);
            }

            // ✅ option 2: don't neutralize → take loss
            dp[ni][nj][k] = Math.max(dp[ni][nj][k],
                                    dp[i][j][k] + grid[ni][nj]);
        }
    }
}