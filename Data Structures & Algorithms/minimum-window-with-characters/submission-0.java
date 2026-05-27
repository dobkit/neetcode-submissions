class Solution {
    public String minWindow(String s, String t) {
        int required = 0;
        int formed = 0;
        Map<Character, Integer> targetFreq = new HashMap<>();
        Map<Character, Integer> windowFreq = new HashMap<>();
        int n = s.length();
        int m = t.length();
        if (n < m) return "";
        int minSub = Integer.MAX_VALUE;
        int start = 0;

        for (Character c : t.toCharArray()) {
            targetFreq.put(c, targetFreq.getOrDefault(c, 0) + 1);
        }
        required = targetFreq.size();

        int left = 0;
        for (int right = 0; right < n; right++) {
            // expand the right
            char c = s.charAt(right);
            windowFreq.put(c, windowFreq.getOrDefault(c, 0) + 1);

            // check if we need to increase formed
            if (windowFreq.get(c) == targetFreq.getOrDefault(c, 0)) formed++;

            // check if window valid
            while (formed == required) {
                // shrink left
                char charLeft = s.charAt(left);

                windowFreq.put(charLeft, windowFreq.get(charLeft) - 1);

                int subLength = right - left + 1;
                if (minSub > subLength) {
                    minSub = subLength;
                    start = left;
                }

                // window become invalid again
                if (windowFreq.get(charLeft) < targetFreq.getOrDefault(charLeft, 0)) {
                    formed--;
                }

                left++;
            }
        }
        return minSub == Integer.MAX_VALUE ? "" : s.substring(start, start + minSub);
    }
}
