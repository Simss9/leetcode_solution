class Solution {
    public int rob(int[] nums) {
         int n = nums.length;

     
     
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);
        int curr = prev1;
        for(int i = 2 ; i<nums.length ; i++){
            curr = Math.max(prev1 , prev2 + nums[i]);
            prev2 = prev1;
            prev1 = curr;
        }
        return(curr);
    }
}