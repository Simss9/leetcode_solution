class Solution {
    public String longestNiceSubstring(String s) {
       
        return dfs(s, 0, s.length());
    }
    
    private String dfs(String s, int l, int r) {
        if (r - l < 2) return "";                // <-- return empty string, not " "
        
        int[] count = new int[128];
        for (int i = l; i < r; i++) count[s.charAt(i)]++;
        
        for (int i = l; i < r; i++) {
            char c = s.charAt(i);
            // if both lower and upper exist, this char is fine
            if (count[Character.toLowerCase(c)] > 0 && count[Character.toUpperCase(c)] > 0) {
                continue;
            }
            // otherwise split at i and solve left/right
            String left = dfs(s, l, i);
            String right = dfs(s, i + 1, r);
            return left.length() >= right.length() ? left : right;
        }
        // whole substring s[l:r] is nice
        return s.substring(l, r);
        
        
    }
}