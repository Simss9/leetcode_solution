    class Solution {
    public int minMaxGame(int[] nums) {
        int n = nums.length;

        
        while (n > 1) {
            int[] newNums = new int[n / 2];

            for (int i = 0; i < n / 2; i++) {
                if (i % 2 == 0) {
                    
                    newNums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
                } else {
                    
                    newNums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
                }
            }

            nums = newNums; 
            n = nums.length;
        }

        return nums[0]; 
    }
}
           