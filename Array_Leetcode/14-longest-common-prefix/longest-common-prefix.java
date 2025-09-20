class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

       
        int minLen = Integer.MAX_VALUE;
        for (String s : strs) {
            if (s.length() < minLen) {
                minLen = s.length();
            }
        }

        int low = 1, high = minLen;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isCommonPrefix(strs, mid)) {
                low = mid + 1; 
            } else {
                high = mid - 1; 
            }
        }

        
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < high; i++) {
            prefix.append(strs[0].charAt(i));
        }
        return prefix.toString();
    }

    
    private boolean isCommonPrefix(String[] strs, int len) {
        for (int i = 1; i < strs.length; i++) {
            for (int j = 0; j < len; j++) {
                if (strs[i].charAt(j) != strs[0].charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}