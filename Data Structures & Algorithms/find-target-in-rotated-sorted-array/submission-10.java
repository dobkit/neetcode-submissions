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
            int leftValue = nums[left];
            int rightValue = nums[right];

            if (midValue <= rightValue) right = mid;
            else left = mid + 1;
        }
        int pivot = left;
        System.out.println("pivot: " + pivot);
        int pivotValue = nums[pivot];

        right = n - 1;
        left = 0;

        if (target == pivotValue) return pivot;
        else if (target > nums[right]) right = pivot - 1;
        else left = pivot;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = nums[mid];
            int leftValue = nums[left];
            int rightValue = nums[right];

            if (midValue == target) return mid;
            else if (midValue < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}
