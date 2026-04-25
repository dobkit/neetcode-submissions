class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> dupMap = new HashMap<Integer, Integer>();
        for (int i : nums) {
            if (dupMap.containsKey(i)) return true;
            dupMap.put(i, 0);
        }
        return false;
    }
}