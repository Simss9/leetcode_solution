class Solution {
public:
    vector<bool> kidsWithCandies(vector<int>& candies, int extraCandies) {
        int size = candies.size();

        // Step 1: Find the maximum number of candies any kid has
        int maxCandies = candies[0];
        for (int i = 1; i < size; i++) {
            if (candies[i] > maxCandies) {
                maxCandies = candies[i];
            }
        }

        // Step 2: Prepare the result vector
        vector<bool> result;

        // Step 3: Check each kid
        for (int i = 0; i < size; i++) {
            int total = candies[i] + extraCandies;
            if (total >= maxCandies) {
                result.push_back(true);
            } else {
                result.push_back(false);
            }
        }

        return result;
    }
};

