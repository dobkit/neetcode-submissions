class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> setNums = new HashSet<>();
        for (int num : nums) {
            setNums.add(num);
        }

        int max = 0;

        for (int i : setNums) {
            if (setNums.contains(i - 1)) continue;

            int current = i;
            int count = 1;
            while (setNums.contains(current + 1)) {
                count += 1;
                current += 1;
            }

            max = Math.max(max, count);
        }
        return max;
    }
}
