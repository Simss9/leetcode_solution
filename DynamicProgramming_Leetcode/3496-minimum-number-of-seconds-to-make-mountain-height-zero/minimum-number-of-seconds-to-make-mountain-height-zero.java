class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
          long low = 1;
        long high = (long)1e18;
        long ans = high;

        while (low <= high) {

            long mid = low + (high - low) / 2;

            if (canReduce(mid, mountainHeight, workerTimes)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean canReduce(long time, int mountainHeight, int[] workerTimes) {

        long total = 0;

        for (int t : workerTimes) {

            long low = 0, high = mountainHeight;

            while (low <= high) {
                long mid = (low + high) / 2;

                long cost = (long)t * mid * (mid + 1) / 2;

                if (cost <= time) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            total += high;

            if (total >= mountainHeight)
                return true;
        }

        return total >= mountainHeight;
    }
}