class Solution {
public:
    int romanToInt(string s) {
    unordered_map<char, int> value = {
            {'I', 1},
            {'V', 5},
            {'X', 10},
            {'L', 50},
            {'C', 100},
            {'D', 500},
            {'M', 1000}
        };

        int total = 0;
        int n = s.length();

        for (int i = 0; i < n - 1; i++) {
            if (value[s[i]] < value[s[i + 1]]) {
                total -= value[s[i]];  // subtract if smaller before larger
            } else {
                total += value[s[i]];  // otherwise add
            }
        }

        // Last character always added
        total += value[s[n - 1]];

        return total;
    }
};
         