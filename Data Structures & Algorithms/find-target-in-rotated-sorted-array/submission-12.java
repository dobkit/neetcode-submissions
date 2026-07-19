class Solution {
    public int search(int[] nums, int target) {
        // two binary search
        // find pivot, then find target
        int n = nums.length;
        int left = 0;
        int right = n - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int midValue = nums[mid];
            int rightValue = nums[right];

            if (midValue <= rightValue) right = mid;
            else left = mid + 1;
        }
        int pivot = left;
        int pivotValue = nums[pivot];

        right = n - 1;
        left = 0;

        if (target >= pivotValue && target <= nums[right]) {
            left = pivot;
            right = n - 1;
        }
        else {
            left = 0;
            right = pivot - 1;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = nums[mid];

            if (midValue == target) return mid;
            else if (midValue < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}
