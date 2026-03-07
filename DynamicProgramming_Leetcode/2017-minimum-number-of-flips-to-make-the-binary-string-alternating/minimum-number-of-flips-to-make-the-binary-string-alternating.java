class Solution {
    public int minFlips(String s) {
        int n = s.length();
        s = s + s;

        int diff1 = 0, diff2 = 0;
        int left = 0;
        int ans = Integer.MAX_VALUE;

        for(int right = 0; right < 2*n; right++){

            char c = s.charAt(right);

            char p1 = (right % 2 == 0) ? '0' : '1';
            char p2 = (right % 2 == 0) ? '1' : '0';

            if(c != p1) diff1++;
            if(c != p2) diff2++;

            if(right - left + 1 > n){

                char leftChar = s.charAt(left);

                char lp1 = (left % 2 == 0) ? '0' : '1';
                char lp2 = (left % 2 == 0) ? '1' : '0';

                if(leftChar != lp1) diff1--;
                if(leftChar != lp2) diff2--;

                left++;
            }

            if(right - left + 1 == n){
                ans = Math.min(ans, Math.min(diff1, diff2));
            }
        }

        return ans;
    }
}