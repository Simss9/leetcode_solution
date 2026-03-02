class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] trailingzeroes = new int[n];
        for(int i = 0;i<n;i++){
            int count = 0;
           for(int j = n-1; j>=0;j--){
             if(grid[i][j]==0){
                count ++;
             }else{
                break;
             }
        }
        
              trailingzeroes[i]=count;

    }
        int swaps = 0;
        for(int i = 0;i < n;i++){
            int required = n - i - 1;
             int j = i;
            while(j < n && trailingzeroes[j] < required){
                j++;
            }
            if(j == n){
                return -1 ;
            }
            while(j>i){
                int temp = trailingzeroes[j];
                trailingzeroes[j] = trailingzeroes[j-1];
                trailingzeroes[j-1] = temp;
                swaps ++;
                j--;
            }
        }

        return swaps;
    }
}