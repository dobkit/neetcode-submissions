class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] lastSeen = new int[128];
        Arrays.fill(lastSeen, -1);
        int left = 0;
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            left = Math.max(left, lastSeen[c] + 1);
            maxLength = Math.max(maxLength, i - left + 1);
            lastSeen[c] = i;
        }
        return maxLength;
    }
}
