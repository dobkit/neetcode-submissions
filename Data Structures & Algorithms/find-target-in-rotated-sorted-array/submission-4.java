class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int midValue = nums[mid];
            int leftValue = nums[left];
            int rightValue = nums[right];

            if (midValue <= rightValue) {
                if (target <= midValue || target > rightValue) right = mid;
                else left = mid + 1;
            }
            else {  // midValue > rightValue
                if (target > midValue || target <= rightValue) left = mid + 1;
                else right = mid;
            }
        }
        if (target == nums[left]) return left;
        return -1;
    }
}
