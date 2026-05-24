class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int[] charIndex = new int[128];
        Arrays.fill(charIndex, -1);
        int n = s.length();
        int maxLength = 0;
        
        if (n == 0) return 0;
        charIndex[s.charAt(0)] = 0;
        int right = 0;
        for (int i = 1; i < n; i++) {
            int curIdx = s.charAt(i);
            if (charIndex[curIdx] >= left) {
                maxLength = Math.max(maxLength, right - left + 1);
                left = Math.max(left, charIndex[curIdx] + 1);
            }
            charIndex[curIdx] = i;
            right = i;
        }
        maxLength = Math.max(maxLength, right - left + 1);
        return maxLength;
    }
}
