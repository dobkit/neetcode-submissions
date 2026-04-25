class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] charFrequency = new int[26];
        
        for (char c: s.toCharArray()) {
            charFrequency[c - 'a'] +=1;
        }
        for (char c: t.toCharArray()) {
            if (charFrequency[c - 'a'] == 0) return false;
            charFrequency[c - 'a'] -= 1;
        }
        return true;
    }
}
