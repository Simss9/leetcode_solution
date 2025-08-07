import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int size = candies.length;


        int max = candies[0];
        for (int i = 1; i < size; i++) {
            if (candies[i] > max) {
                max = candies[i];
            }
        }

 
        List<Boolean> result = new ArrayList<>();

       
        for (int i = 0; i < size; i++) {
            int total = candies[i] + extraCandies;
            if (total >= max) {
                result.add(true);
            } else {
                result.add(false);
            }
        }

        return result;
    }
}


