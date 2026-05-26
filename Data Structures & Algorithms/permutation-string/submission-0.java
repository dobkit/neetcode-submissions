class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1Freq = new int[26];
        int[] s2Freq = new int[26];
        int n = s2.length();
        int m = s1.length();
        int matches = 0;
        int left = 0;
        if (m > n) return false;

        for (int i = 0; i < m; i++) {
            s1Freq[s1.charAt(i) - 'a']++;
            s2Freq[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (s1Freq[i] == s2Freq[i]) matches++;
        }

        if (matches == 26) return true;

        for (int right = m; right < n; right++) {
            // matching -> not matching
            if (s2Freq[s2.charAt(right) - 'a'] == s1Freq[s2.charAt(right) - 'a']) matches--;

            // not matching -> matching
            if (++s2Freq[s2.charAt(right) - 'a'] == s1Freq[s2.charAt(right) - 'a']) matches++;

            if (s2Freq[s2.charAt(left) - 'a'] == s1Freq[s2.charAt(left) - 'a']) matches--;
            if (--s2Freq[s2.charAt(left) - 'a'] == s1Freq[s2.charAt(left) - 'a']) matches++;

            if (matches == 26) return true;
            left++;
        }

        return false;
    }
}
