class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int len = n + m - 1;

        char[] word = new char[len];

        // Step 1: Fill with '?'
        for (int i = 0; i < len; i++) {
            word[i] = '?';
        }

        // Step 2: Apply all 'T'
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    if (word[i + j] == '?' || word[i + j] == str2.charAt(j)) {
                        word[i + j] = str2.charAt(j);
                    } else {
                        return ""; // conflict
                    }
                }
            }
        }

        // Step 3: Fill remaining with 'a'
        for (int i = 0; i < len; i++) {
            if (word[i] == '?') {
                word[i] = 'a';
            }
        }

        // Step 4: Handle all 'F'
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'F') {
                boolean match = true;

                for (int j = 0; j < m; j++) {
                    if (word[i + j] != str2.charAt(j)) {
                        match = false;
                        break;
                    }
                }

                // If equal → break it
                if (match) {
                    boolean changed = false;

                    for (int j = m - 1; j >= 0; j--) {
                        for (char c = 'a'; c <= 'z'; c++) {
                            if (c != word[i + j]) {
                                char old = word[i + j];
                                word[i + j] = c;

                                // Check all 'T' again (ensure no break)
                                boolean valid = true;
                                for (int k = 0; k < n; k++) {
                                    if (str1.charAt(k) == 'T') {
                                        for (int x = 0; x < m; x++) {
                                            if (word[k + x] != str2.charAt(x)) {
                                                valid = false;
                                                break;
                                            }
                                        }
                                        if (!valid) break;
                                    }
                                }

                                if (valid) {
                                    changed = true;
                                    break;
                                } else {
                                    word[i + j] = old;
                                }
                            }
                        }
                        if (changed) break;
                    }

                    if (!changed) return "";
                }
            }
        }

        return new String(word);
    }
}