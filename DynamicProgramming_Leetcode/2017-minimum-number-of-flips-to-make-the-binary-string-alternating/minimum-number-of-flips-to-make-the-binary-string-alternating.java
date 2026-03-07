class Solution {
    public int minFlips(String s) {
        int n = s.length();
        s = s + s;

        StringBuilder alt1 = new StringBuilder();
        StringBuilder alt2 = new StringBuilder();

        for(int i = 0; i < 2*n; i++){
            if(i % 2 == 0){
                alt1.append('0');
                alt2.append('1');
            }else{
                alt1.append('1');
                alt2.append('0');
            }
        }

        int res = Integer.MAX_VALUE;
        int diff1 = 0, diff2 = 0;
        int left = 0;

        for(int right = 0; right < 2*n; right++){

            if(s.charAt(right) != alt1.charAt(right)) diff1++;
            if(s.charAt(right) != alt2.charAt(right)) diff2++;

            if(right - left + 1 > n){
                if(s.charAt(left) != alt1.charAt(left)) diff1--;
                if(s.charAt(left) != alt2.charAt(left)) diff2--;
                left++;
            }

            if(right - left + 1 == n){
                res = Math.min(res, Math.min(diff1, diff2));
            }
        }

        return res;
    }
}