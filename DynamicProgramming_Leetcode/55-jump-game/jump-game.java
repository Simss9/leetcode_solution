class Solution {
    public boolean canJump(int[] nums) {
        int MaxReach = 0;
        int n = nums.length;
        for( int i = 0;i<n ; i++){
            if(i>MaxReach){
                return false;
            }
            MaxReach = Math.max(MaxReach , i + nums[i]);
            if(MaxReach >= n-1){
                return true;
            }
        }
        return false;
    }
}