class Solution {
    public boolean hasAllCodes(String s, int k) {
         int n = s.length();
        int need = 1 << k;          // total patterns = 2^k
        
        // Quick check: agar itne substrings hi nahi ban sakte
        if (n - k + 1 < need) {
            return false;
        }

        boolean[] seen = new boolean[need];
        int count = 0;

        int hash = 0;
        int mask = need - 1;        // keeps only last k bits

        for (int i = 0; i < n; i++) {
            
            // rolling hash update
            hash = ((hash << 1) & mask) | (s.charAt(i) - '0');

            // start checking once window size is k
            if (i >= k - 1) {
                if (!seen[hash]) {
                    seen[hash] = true;
                    count++;
                    
                    if (count == need) {
                        return true;   // all patterns found
                    }
                }
            }
        }

        return false;
    
        
    }
}