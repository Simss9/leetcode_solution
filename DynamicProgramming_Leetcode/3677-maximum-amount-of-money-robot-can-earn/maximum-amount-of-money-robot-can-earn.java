class Solution {

    public int maximumAmount(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] prev = new int[m][3];

        // initialize prev
        for(int j = 0; j < m; j++){
            for(int k = 0; k < 3; k++){
                prev[j][k] = Integer.MIN_VALUE;
            }
        }

        // first cell
        if(grid[0][0] >= 0){
            prev[0][0] = grid[0][0];
        } else {
            prev[0][0] = grid[0][0];
            prev[0][1] = 0;
        }

        // first row
        for(int j = 1; j < m; j++){
            for(int k = 0; k < 3; k++){
                if(prev[j-1][k] == Integer.MIN_VALUE) continue;

                if(grid[0][j] >= 0){
                    prev[j][k] = Math.max(prev[j][k],
                                          prev[j-1][k] + grid[0][j]);
                } else {
                    if(k < 2){
                        prev[j][k+1] = Math.max(prev[j][k+1],
                                                prev[j-1][k]);
                    }
                    prev[j][k] = Math.max(prev[j][k],
                                          prev[j-1][k] + grid[0][j]);
                }
            }
        }

        // process remaining rows
        for(int i = 1; i < n; i++){

            int[][] curr = new int[m][3];

            // init curr
            for(int j = 0; j < m; j++){
                for(int k = 0; k < 3; k++){
                    curr[j][k] = Integer.MIN_VALUE;
                }
            }

            // first column
            for(int k = 0; k < 3; k++){
                if(prev[0][k] == Integer.MIN_VALUE) continue;

                if(grid[i][0] >= 0){
                    curr[0][k] = Math.max(curr[0][k],
                                          prev[0][k] + grid[i][0]);
                } else {
                    if(k < 2){
                        curr[0][k+1] = Math.max(curr[0][k+1],
                                                prev[0][k]);
                    }
                    curr[0][k] = Math.max(curr[0][k],
                                          prev[0][k] + grid[i][0]);
                }
            }

            // rest cells
            for(int j = 1; j < m; j++){
                for(int k = 0; k < 3; k++){

                    // from left
                    if(curr[j-1][k] != Integer.MIN_VALUE){
                        update(curr, grid, curr[j-1][k], i, j, k);
                    }

                    // from up
                    if(prev[j][k] != Integer.MIN_VALUE){
                        update(curr, grid, prev[j][k], i, j, k);
                    }
                }
            }

            prev = curr;
        }

        return Math.max(prev[m-1][0],
               Math.max(prev[m-1][1], prev[m-1][2]));
    }

    private void update(int[][] curr, int[][] grid, int val,
                        int i, int j, int k){

        if(grid[i][j] >= 0){
            curr[j][k] = Math.max(curr[j][k],
                                  val + grid[i][j]);
        } else {
            if(k < 2){
                curr[j][k+1] = Math.max(curr[j][k+1],
                                        val);
            }
            curr[j][k] = Math.max(curr[j][k],
                                  val + grid[i][j]);
        }
    }
}