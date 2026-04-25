class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> checkedValues = new HashMap<>();
        for (int i = 0; i< nums.length; i++) {
            int need = target - nums[i];
            if (checkedValues.containsKey(need)) {
                return new int[] {checkedValues.get(need), i};
            }
            checkedValues.put(nums[i], i);
        }
        return new int[2];
    }
}
