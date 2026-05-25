class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int maxFreq = 0;
        int[] freqTracking = new int[26];
        int left = 0;
        int answer = 0;

        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            freqTracking[c - 'A'] += 1;
            maxFreq = Math.max(maxFreq, freqTracking[c - 'A']);
            int curLength = right - left + 1;
            if (curLength - maxFreq > k){
                freqTracking[s.charAt(left) - 'A']--;
                left += 1;
            }
            answer = Math.max(answer, right - left + 1);

        }
        return answer;
    }
}
