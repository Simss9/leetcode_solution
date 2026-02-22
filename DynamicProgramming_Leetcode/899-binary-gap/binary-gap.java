class Solution {
    public int binaryGap(int n) {
         int last = -1;
        int maxDistance = 0;
        int position = 0;

        while (n > 0) {
            if ((n & 1) == 1) {   // if last bit is 1
                if (last != -1) {
                    maxDistance = Math.max(maxDistance, position - last);
                }
                last = position;
            }
            position++;
            n = n >> 1;   // right shift
        }

        return maxDistance;
    }
}