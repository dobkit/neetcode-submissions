class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n-1;
        while (left <= right) {
            int temp = (right + left) / 2;
            if (nums[temp] == target) return temp;
            else if (nums[temp] > target) right = temp - 1;
            else left = temp + 1;
        }
        return -1;
    }
}
