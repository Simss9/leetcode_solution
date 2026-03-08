class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        char[] result = new char[n];

        // Flip the diagonal bits
        for (int i = 0; i < n; i++) {
            result[i] = (nums[i].charAt(i) == '0') ? '1' : '0';
        }

        return new String(result);
    }
}