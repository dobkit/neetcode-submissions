class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> dupSet = new HashSet<Integer>();
        for (int i : nums) {
            if (!dupSet.add(i)) return true;
        }
        return false;
    }
}