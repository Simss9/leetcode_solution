import java.util.*;

class Solution {
    public String makeLargestSpecial(String s) {
        
        if (s.length() <= 2) {
            return s;
        }

        List<String> ans = new ArrayList<>();
        
        int count = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            
            if (s.charAt(i) == '1') {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                String inner = s.substring(start + 1, i);
                String processed = "1" + makeLargestSpecial(inner) + "0";
                ans.add(processed);
                start = i + 1;
            }
        }

        // Sort in descending order
        Collections.sort(ans, Collections.reverseOrder());

        StringBuilder result = new StringBuilder();
        for (int j = 0; j < ans.size(); j++) {
            result.append(ans.get(j));
        }

        return result.toString();
    }
}
