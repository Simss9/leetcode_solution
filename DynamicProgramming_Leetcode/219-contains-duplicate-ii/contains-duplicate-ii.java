class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
      java.util.HashMap<Integer, Integer> lastIndex = new java.util.HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (lastIndex.containsKey(nums[i]) &&
                i - lastIndex.get(nums[i]) <= k) {
                return true;
            }
            lastIndex.put(nums[i], i);
        }
        return false;


        
        
    }
}